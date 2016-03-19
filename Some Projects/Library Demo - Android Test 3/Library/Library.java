package Library;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.ConcurrentHashMap;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import org.json.simple.JSONObject;

enum readingTypes {	BOOKS, TEXTBOOKS, MAGAZINES }

public class Library extends Thread {
	
	ArrayList<Person> customers;
	ArrayList<String> nameOfReadableItems;
	ConcurrentHashMap<String, HashMap<String, ArrayList<IReadable>>> catalogue;

	public Library() {
		this.nameOfReadableItems = new ArrayList<String>();
		this.customers = new ArrayList<Person>();
		this.catalogue = new ConcurrentHashMap<String, HashMap<String, ArrayList<IReadable>>>();

		this.catalogue.put(readingTypes.BOOKS.toString(), new HashMap<String, ArrayList<IReadable>>());
		this.catalogue.get(readingTypes.BOOKS.toString()).put("tragedia", new ArrayList<IReadable>());
		this.catalogue.get(readingTypes.BOOKS.toString()).get("tragedia").add(new Book("Stareca i moreto", "Heminguei", "Nyakakvo si tam", LocalDate.of(1952, 06, 26)));
		this.catalogue.get(readingTypes.BOOKS.toString()).get("tragedia").add(new Book("Romeo i Zhulieta", "Shakespere", "Nyakakvo si tam", LocalDate.of(1595, 05, 22)));
		this.catalogue.get(readingTypes.BOOKS.toString()).put("fantastika", new ArrayList<IReadable>());
		this.catalogue.get(readingTypes.BOOKS.toString()).get("fantastika").add(new Book("Krayat na vechnostta", "Ayzuk Azimov", "Fantastichno", LocalDate.of(1955, 12, 15)));
		this.catalogue.get(readingTypes.BOOKS.toString()).get("fantastika").add(new Book("Fondaciata", "Ayzuk Azimov", "Mnogo Fantastichno", LocalDate.of(1951, 01, 15)));

		this.catalogue.put(readingTypes.TEXTBOOKS.toString(), new HashMap<String, ArrayList<IReadable>>());
		this.catalogue.get(readingTypes.TEXTBOOKS.toString()).put("history", new ArrayList<IReadable>());
		this.catalogue.get(readingTypes.TEXTBOOKS.toString()).get("history").add(new Textbook("istoriya slavianobulgarska", "Hristova", "Bezizvestno"));
		this.catalogue.get(readingTypes.TEXTBOOKS.toString()).get("history").add(new Textbook("elada", "Hristova", "Fa fa"));
		this.catalogue.get(readingTypes.TEXTBOOKS.toString()).get("history").add(new Textbook("world war II", "Hristova", "Mnogo Izvestno"));
		this.catalogue.get(readingTypes.TEXTBOOKS.toString()).put("math", new ArrayList<IReadable>());
		this.catalogue.get(readingTypes.TEXTBOOKS.toString()).get("math").add(new Textbook("matematika 1", "Petrov", "PMG"));

		this.catalogue.put(readingTypes.MAGAZINES.toString(), new HashMap<String, ArrayList<IReadable>>());
		this.catalogue.get(readingTypes.MAGAZINES.toString()).put("moda", new ArrayList<IReadable>());
		this.catalogue.get(readingTypes.MAGAZINES.toString()).get("moda").add(new Magazine("fafa", "edno tam", 2, LocalDate.of(2016, 02, 03)));
		this.catalogue.get(readingTypes.MAGAZINES.toString()).get("moda").add(new Magazine("fafa", "edno tam", 3, LocalDate.of(2016, 02, 10)));
		this.catalogue.get(readingTypes.MAGAZINES.toString()).get("moda").add(new Magazine("fafa", "edno tam", 1, LocalDate.of(2016, 01, 26)));
		this.catalogue.get(readingTypes.MAGAZINES.toString()).put("nauka", new ArrayList<IReadable>());
		this.catalogue.get(readingTypes.MAGAZINES.toString()).get("nauka").add(new Magazine("kosmos", "kosmichesko", 16, LocalDate.of(2016, 01, 12)));
		this.catalogue.get(readingTypes.MAGAZINES.toString()).get("nauka").add(new Magazine("ebasi powera", "dve tam", 13, LocalDate.of(2015, 06, 13)));
		this.catalogue.get(readingTypes.MAGAZINES.toString()).get("nauka").add(new Magazine("ebasi powera", "dve tam", 22, LocalDate.of(2015, 11, 25)));
		this.catalogue.get(readingTypes.MAGAZINES.toString()).get("nauka").add(new Magazine("8", "osem tam", 111, LocalDate.of(2016, 01, 12)));
	
		addTitles();
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.currentThread().sleep(10_000); // 31 seconds represent 31 days i.e. 1 month
			} catch (InterruptedException e) {

			}
			startRevision();
		}
	}

	private void startRevision() {
		System.out.println("START REVISION");
		generateFileToWhireAllCurrentlyTakenItems();
		returnAllTakenReadableItems(); // also exports to a file all overdue readable items
	}

	private void returnAllTakenReadableItems() {
		JSONObject obj = new JSONObject();
		BufferedWriter writer = null;
		String row = "";
		for (Map.Entry<String, HashMap<String, ArrayList<IReadable>>> outerMap : this.catalogue.entrySet()) {
			HashMap<String, ArrayList<IReadable>> tempMap = outerMap.getValue();
			for(Map.Entry<String, ArrayList<IReadable>> innerMap : tempMap.entrySet()) {
				for (int i = 0; i < innerMap.getValue().size(); i++) {
					if (innerMap.getValue().get(i) instanceof Magazine) {
						continue;
					}
					
					if (((ReadableItem)innerMap.getValue().get(i)).getIsTaken() == true) {
						
						long returnedTime = System.currentTimeMillis() - ((ReadableItem)innerMap.getValue().get(i)).getTakenOn();
						
						int rentMoney = 2;
						double rentPercent = 0.02;
						
						if (innerMap.getValue().get(i) instanceof Textbook) {
							rentMoney = 3;
							rentPercent = 0.03;
						}
						
						if (returnedTime <= 2000) {
							System.out.println(((ReadableItem)innerMap.getValue().get(i)).getTakenFrom().getName() + " payed 2 lv for renting: " + ((ReadableItem)innerMap.getValue().get(i)).getName());
						} else {
							System.out.println(((ReadableItem)innerMap.getValue().get(i)).getTakenFrom().getName() + " payed " + (rentMoney + (rentMoney * (returnedTime / 1000 * rentPercent))) + " lv for renting: " + ((ReadableItem)innerMap.getValue().get(i)).getName());
							
							// export items to overdue list
							File overdueItems = new File("Overdue_Readable_Items.txt");
							
							if (!overdueItems.isFile()) {
								try {
									overdueItems.createNewFile();
								} catch (IOException e) {
									System.out.println("Something went wrong with the creation.");
								}
							}
							
							int counterTakenItems = 0;
							double price = (rentMoney + (rentMoney * (returnedTime / 1000 * rentPercent)));
							
							// WITH JSON
							
							obj.put("Name", ((ReadableItem)innerMap.getValue().get(i)).getName());
							obj.put("Taken from", ((ReadableItem)innerMap.getValue().get(i)).getTakenFrom().getName());
							obj.put("Overdue price", String.valueOf(price));
							
							try (FileWriter file = new FileWriter("JSONFile.txt")) {
								file.write(obj.toJSONString());
							} catch (IOException e1) {}
							
							// WITH NORMAL WRITER
							
							try {
								if (writer == null) {
									writer = new BufferedWriter(new FileWriter("Overdue_Readable_Items.txt"));
								}								
								
								row = ((ReadableItem)innerMap.getValue().get(i)).getName().concat(", ").concat(((ReadableItem)innerMap.getValue().get(i)).getTakenFrom().getName()).concat(", ammount to pay: ").concat(String.valueOf(price));
								writer.write(row);
								writer.newLine();
							} catch (IOException e) {
								System.out.println("File not exist!");
							} finally {
								if (writer != null) {
									try {
										writer.close();
									} catch (IOException e) {
										System.out.println("File not exist in last check!");
									}
								}
							}
						}
						
						((ReadableItem)innerMap.getValue().get(i)).getTakenFrom().takenItemsFromLibrary.clear();
						((ReadableItem)innerMap.getValue().get(i)).setIsTaken(false); // returns the item
						((ReadableItem)innerMap.getValue().get(i)).setTakenFrom(null); // set the person that took the item to null
					}
				}
			}
		}
		try {
			generateAndSendEmail(row);
		} catch (MessagingException e) {
			System.out.println("Something went wrong with sending the email via MailAPI");
		}
		
//		generateAndSendEmailWithAttachment(row);
		System.out.println("END REVISION");
	}

	private void generateAndSendEmailWithAttachment(String row) {
		String to = "alexander.zorov@gmail.com";
		String from = "noexile@gmail.com";
		 
		final String username = "*****";//change accordingly
		final String password = "*****";//change accordingly
		
		String host = "relay.jangosmtp.net";
		
		Properties props = new Properties();
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", "25");
		
		Session session = Session.getInstance(props, new javax.mail.Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(username, password);
			}
		});
		
		try {
			// Create a default MimeMessage object.
			Message message = new MimeMessage(session);
			
			// Set From: header field of the header.
			message.setFrom(new InternetAddress(from));
			
			// Set To: header field of the header.
			message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
			
			// Set Subject: header field
	         message.setSubject("Zadachata ot Test 3 Android Group s prikachen file");

	         // Create the message part
	         BodyPart messageBodyPart = new MimeBodyPart();
	         
	         // Now set the actual message
	         messageBodyPart.setText("Tsatchets");

	         // Create a multipar message
	         Multipart multipart = new MimeMultipart();

	         // Set text message part
	         multipart.addBodyPart(messageBodyPart);
	         
	      // Part two is attachment
	         messageBodyPart = new MimeBodyPart();
	         String filename = "D:/workspace/TestOnTest3AndroidGroup/JSONFile.txt";
	         DataSource source = new FileDataSource(filename);
	         messageBodyPart.setDataHandler(new DataHandler(source));
	         messageBodyPart.setFileName(filename);
	         multipart.addBodyPart(messageBodyPart);
	         
	      // Send the complete message parts
	         message.setContent(multipart);

	         // Send message
	         Transport.send(message);
	         
		} catch (MessagingException e) {
			throw new RuntimeException(e);
		}
	   
	}

	private void generateAndSendEmail(String row) throws AddressException, MessagingException {
		Properties mailServerProperties;
		Session getMailSession;
		MimeMessage generateMailMessage;
		
		mailServerProperties = System.getProperties();
		mailServerProperties.put("mail.smtp.port", "587");
		mailServerProperties.put("mail.smtp.auth", "true");
		mailServerProperties.put("mail.smtp.starttls.enable", "true");
		
		getMailSession = Session.getDefaultInstance(mailServerProperties, null);
		generateMailMessage = new MimeMessage(getMailSession);
		generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress("krasimir.stoev@ittalents.bg"));
		generateMailMessage.setSubject("Zadachata ot Test 3 Android Group");
		generateMailMessage.setContent(row, "text/html");
		
		Transport transport = getMailSession.getTransport("smtp");
		
		transport.connect("smtp.gmail.com", "username", "password");
		transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
		transport.close();
	}

	private void generateFileToWhireAllCurrentlyTakenItems() {
		File yourFile = new File("Lend_Readable_Items.txt");
		if (!yourFile.isFile()) {
			try {
				yourFile.createNewFile();
			} catch (IOException e) {
				System.out.println("Something went wrong with the creation.");
			}
		}
		
		ArrayList<IReadable> takenItems = checkTakenItems();
		Collections.sort(takenItems, new SortByDateTaken()); // TODO - not working properly
		String row = "";
		int counterTakenItems = 0;

		BufferedWriter writer = null;
		try {
			writer = new BufferedWriter(new FileWriter("Lend_Readable_Items.txt"));
			for (int i = 0; i < takenItems.size(); i++) {
				if (takenItems.get(i) instanceof Book) {
					row = ((Book)takenItems.get(i)).getName();
				} else if (takenItems.get(i) instanceof Textbook) {
					row = ((Textbook)takenItems.get(i)).getName();
				}
				writer.write(row);
				writer.newLine();
				counterTakenItems++;
			}
		} catch (IOException e) {
			System.out.println("File not exist!");
		} finally {
			if (writer != null) {
				try {
					writer.close();
				} catch (IOException e) {
					System.out.println("File not exist in last check!");
				}
			}
		}
	}

	private ArrayList<IReadable> checkTakenItems() {
		ArrayList<IReadable> tempItems = new ArrayList<IReadable>();
		
		
		for (Map.Entry<String, HashMap<String, ArrayList<IReadable>>> outsideMap : this.catalogue.entrySet()) {
			if (outsideMap.getKey().equalsIgnoreCase(readingTypes.MAGAZINES.toString())) {
				continue;
			}
			
			HashMap<String, ArrayList<IReadable>> tempMap = outsideMap.getValue();
			for(Map.Entry<String, ArrayList<IReadable>> insideMap : tempMap.entrySet()) {
				ArrayList<IReadable> insideTempList = insideMap.getValue();
				for (int i = 0; i < insideTempList.size(); i++) {
					if (insideTempList.get(i) == null) {
						continue;
					} 
					if (insideTempList.get(i) instanceof Book) {
						if (((Book)insideTempList.get(i)).getIsTaken() == true) {
							tempItems.add(insideTempList.get(i));
						}
					} else if (insideTempList.get(i) instanceof Textbook) {
						if (((Textbook)insideTempList.get(i)).getIsTaken() == true) {
							tempItems.add(insideTempList.get(i));
						}
					}
				}
			}
		}
		
		return tempItems;
	}

	synchronized public ReadableItem takeReadableItemFromLibrary(String name, Person person) {
		for (Map.Entry<String, HashMap<String, ArrayList<IReadable>>> outsideMap : this.catalogue.entrySet()) {
			HashMap<String, ArrayList<IReadable>> tempMap = outsideMap.getValue();
			for(Map.Entry<String, ArrayList<IReadable>> insideMap : tempMap.entrySet()) {
				for (int i = 0; i < insideMap.getValue().size(); i++) {
					if (insideMap.getValue().get(i) instanceof Magazine) {
						continue;
					}
					if (((ReadableItem)insideMap.getValue().get(i)).getName().equalsIgnoreCase(name)) {
						ReadableItem item = ((ReadableItem)insideMap.getValue().get(i));
						if (item.getIsTaken() == true) {
							try {
								throw new ItemAlreadyTakenException();
							} catch (ItemAlreadyTakenException e) {
								System.out.println(name + e.getMessage() + " " + person.getName());
							}
							return null;
						}
						
						System.out.println(person.getName() + " takes " + name);
						item.setIsTaken(true);
						item.setTakenFrom(person);
						item.setTakenOn(System.currentTimeMillis());
						
						return item;
					}
				}
			
			}
		}
		return null;
	}
	
	synchronized public void returnReadableItemFromLibrary(String name, Person person) {
		for (Map.Entry<String, HashMap<String, ArrayList<IReadable>>> outsideMap : this.catalogue.entrySet()) {
			HashMap<String, ArrayList<IReadable>> tempMap = outsideMap.getValue();
			for(Map.Entry<String, ArrayList<IReadable>> insideMap : tempMap.entrySet()) {
				for (int i = 0; i < insideMap.getValue().size(); i++) {
					if (insideMap.getValue().get(i) instanceof Magazine) {
						continue;
					}
					if (((ReadableItem)insideMap.getValue().get(i)).getName().equalsIgnoreCase(name)) {
						ReadableItem item = ((ReadableItem)insideMap.getValue().get(i));
						
						item.setIsTaken(false);
						item.setTakenFrom(null);
						System.out.println(person.getName() + " returns " + name);
						return;
					}
				}

			}
		}
	}

	public void showAllBooks() {
		for (Map.Entry<String, HashMap<String, ArrayList<IReadable>>> outsideMap : this.catalogue.entrySet()) {
			if (outsideMap.getKey().equalsIgnoreCase(readingTypes.BOOKS.toString())) {
				HashMap<String, ArrayList<IReadable>> tempMap = outsideMap.getValue();
				System.out.println("-----LIST OF BOOKS-----");
				for (Map.Entry<String, ArrayList<IReadable>> insideMap : tempMap.entrySet()) {
					ArrayList<IReadable> entryList = insideMap.getValue();
					Collections.sort(entryList, new BookSortComparator()); // NOT WORKING PROPERLY
					System.out.println(insideMap.getKey() + ":");
					for (int i = 0; i < entryList.size(); i++) {
						if (entryList.get(i) == null) {
							continue;
						}
						String availability = (((Book) entryList.get(i)).getIsTaken() ? "NOT AVAILABLE" : "AVAILABLE");
						System.out.println("- " + ((Book) entryList.get(i)).getName() + " "
								+ ((Book) entryList.get(i)).getReleaseDate() + " <" + availability + ">");
					}

				}
			}
		}
	}

	public void showAllTextbooks() {
		for (Map.Entry<String, HashMap<String, ArrayList<IReadable>>> outsideMap : this.catalogue.entrySet()) {
			if (outsideMap.getKey().equalsIgnoreCase(readingTypes.TEXTBOOKS.toString())) {
				HashMap<String, ArrayList<IReadable>> tempMap = outsideMap.getValue();
				System.out.println("-----LIST OF TEXTBOOKS-----");
				for (Map.Entry<String, ArrayList<IReadable>> insideMap : tempMap.entrySet()) {
					ArrayList<IReadable> entryList = insideMap.getValue();
					System.out.println(insideMap.getKey() + ":");
					Collections.sort(entryList, new NameComparator());
					for (int i = 0; i < entryList.size(); i++) {
						if (entryList.get(i) == null) {
							continue;
						}
						String availability = (((Textbook) entryList.get(i)).getIsTaken() ? "NOT AVAILABLE"
								: "AVAILABLE");
						System.out.println("- " + ((Textbook) entryList.get(i)).getName() + " <" + availability + ">");
					}
				}
			}
		}
	}

	public void showAllMagazines() {
		for (Map.Entry<String, HashMap<String, ArrayList<IReadable>>> outsideMap : this.catalogue.entrySet()) {
			if (outsideMap.getKey().equalsIgnoreCase(readingTypes.MAGAZINES.toString())) {
				HashMap<String, ArrayList<IReadable>> tempMap = outsideMap.getValue();

				System.out.println("-----LIST OF MAGAZINES-----");
				for (HashMap.Entry<String, ArrayList<IReadable>> insideMap : tempMap.entrySet()) {
					ArrayList<IReadable> entryList = insideMap.getValue();
					System.out.println(insideMap.getKey() + ":");
					Collections.sort(entryList, new MagazineComparator());
					for (int i = 0; i < entryList.size(); i++) {
						if (entryList.get(i) == null) {
							continue;
						}
						String availability = (((Magazine) entryList.get(i)).getIsTaken() ? "NOT AVAILABLE"
								: "AVAILABLE");
						System.out.println("- " + ((Magazine) entryList.get(i)).getName() + " broi "
								+ ((Magazine) entryList.get(i)).getNumber() + " <" + availability + ">");
					}
				}
			}
		}

	}

	private void addTitles() {
		for (Map.Entry<String, HashMap<String, ArrayList<IReadable>>> outsideMap : this.catalogue.entrySet()) {
			HashMap<String, ArrayList<IReadable>> tempMap = outsideMap.getValue();
			for(Map.Entry<String, ArrayList<IReadable>> insideMap : tempMap.entrySet()) {
				for (int i = 0; i < insideMap.getValue().size(); i++) {
					if (insideMap.getValue().get(i) instanceof Book || insideMap.getValue().get(i) instanceof Textbook ) {
						this.nameOfReadableItems.add(((ReadableItem)insideMap.getValue().get(i)).getName());
					} 
				}
			}
		}
	}
}
