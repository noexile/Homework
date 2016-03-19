package warPeace;

import java.io.File;
import java.io.FileReader;

public class Demo {
	public static void main(String[] args) throws Exception {
		
		String wordOne = "war";
		String wordTwo = "peace";
		
		File file;
		FileReader reader = null;
		
		try{
			file = new File("C:/Users/Admin/Desktop/war_peace.txt");
			reader = new FileReader(file);
			StringBuilder sb = new StringBuilder();
			while(true) {
				int c = reader.read();
				if(c == -1)
					break;
				sb.append((char)c);
			}
		
		
			countCommasSingleThread(sb.toString());
			countWordsSingleThread(wordOne, sb.toString().toLowerCase());
			countWordsSingleThread(wordTwo, sb.toString().toLowerCase());
			
			countCommasFourThreads(sb.toString());
			countWordsFourThreads(wordOne, sb.toString().toLowerCase());
			countWordsFourThreads(wordTwo, sb.toString().toLowerCase());
			
		} catch (Exception e) {
			System.out.println("the shit got real");
		} finally {
			reader.close();
		}
	}

	private static void countWordsFourThreads(String word, String text) throws InterruptedException {
		// creating inner class for Threads
		class CommaReader extends Thread {		
			
			private String text;
			int counter = 0;
			long start = System.currentTimeMillis();
			
			CommaReader(String text) {
				this.text = text;
			}
			
			@Override
			public void run() {
				
				String[] textArray = text.split(" ");
				
				for (int i = 0; i < textArray.length; i++) {
					if (textArray[i].contains(word)) {
						counter++;
					}
				}
				
				long duration = System.currentTimeMillis() - start;
				System.out.println(Thread.currentThread().getName() + " counted " + counter + " times the word \""+ word + "\" for duration = " + duration + " ms.");
			}
		}
		
		int allWordsInTheText = 0;
		int textPart = text.length() / 4;
		int textStart = 0;
		
		String partOne = text.substring(textStart, textPart + textStart);
		textStart += textPart;
		String partTwo = text.substring(textStart, textPart + textStart);
		textStart += textPart;
		String partThree = text.substring(textStart, textPart + textStart);
		textStart += textPart;
		String partFour = text.substring(textStart);
		textStart += textPart;
		
		long startTime = System.currentTimeMillis();
		System.out.println("----- 4 Threads -----");
		CommaReader reader1 = new CommaReader(partOne);
		CommaReader reader2 = new CommaReader(partTwo);
		CommaReader reader3 = new CommaReader(partThree);
		CommaReader reader4 = new CommaReader(partFour);
		reader1.start();
		reader2.start();
		reader3.start();
		reader4.start();
		reader1.join();
		reader2.join();
		reader3.join();
		reader4.join();
		
		
		allWordsInTheText += reader1.counter;
		allWordsInTheText += reader2.counter;
		allWordsInTheText += reader3.counter;
		allWordsInTheText += reader4.counter;
		
		
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("Total number of \"" + word + "\" in the book: " + allWordsInTheText + " counted for: " + duration + " ms.");
		
	}

	private static void countCommasFourThreads(String text) throws InterruptedException {
		// creating inner class for Threads
		class CommaReader extends Thread {
			
			private String text;
			int counter = 0;
			long start = System.currentTimeMillis();
			CommaReader(String text) {
				this.text = text;
			}
			
			@Override
			public void run() {
				
					for(char c : this.text.toCharArray()) {
						if(c == ',') {
							counter++;
						}
					}
				long duration = System.currentTimeMillis() - start;
				System.out.println(Thread.currentThread().getName() + " counted " + counter + " \",\" for duration = " + duration + " ms.");
			}
		}
		
		int allCommasInTheText = 0;
		int textPart = text.length() / 4;
		int textStart = 0;
		
		String partOne = text.substring(textStart, textPart + textStart);
		textStart += textPart;
		String partTwo = text.substring(textStart, textPart + textStart);
		textStart += textPart;
		String partThree = text.substring(textStart, textPart + textStart);
		textStart += textPart;
		String partFour = text.substring(textStart);
		textStart += textPart;
		
		long startTime = System.currentTimeMillis();
		System.out.println("----- 4 Threads -----");
		CommaReader reader1 = new CommaReader(partOne);
		CommaReader reader2 = new CommaReader(partTwo);
		CommaReader reader3 = new CommaReader(partThree);
		CommaReader reader4 = new CommaReader(partFour);
		reader1.start();
		reader2.start();
		reader3.start();
		reader4.start();
		reader1.join();
		reader2.join();
		reader3.join();
		reader4.join();
		
		
		allCommasInTheText += reader1.counter;
		allCommasInTheText += reader2.counter;
		allCommasInTheText += reader3.counter;
		allCommasInTheText += reader4.counter;
		
		
		long duration = System.currentTimeMillis() - startTime;
		System.out.println("Total number of \",\" in the book: " + allCommasInTheText + " counted for: " + duration + " ms.");
		
	}

	private static void countWordsSingleThread(String word, String text) {
		
		int counter = 0;
		
		long start = System.currentTimeMillis();
		String[] textArray = text.split(" ");
		
		for (int i = 0; i < textArray.length; i++) {
			if (textArray[i].contains(word)) {
				counter++;
			}
		}
		
		long duration = System.currentTimeMillis() - start;
		System.out.println("Total number of \"" + word + "\" in the book: " + counter + " counted for: " + duration + " ms.");				
	}

	private static void countCommasSingleThread(String text) {
		
		int counter = 0;
		long start = System.currentTimeMillis();
		System.out.println("----- 1 Thread -----");
		for(char c : text.toCharArray()) {
			if(c == ',')
				counter++;
		}

		long duration = System.currentTimeMillis() - start;
		System.out.println("Total number of \",\" in the book: " + counter + " counted for: " + duration + " ms.");
		
	}

	
}
