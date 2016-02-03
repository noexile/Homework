//  Да се напише конзолно приложение, което показва списък с най-често срещаните букви в даден текст, въведен от потребителя. Програмата да извежда статистическа
//  информация за честотата на срещане на буквите, като не се прави разлика между големи и малки букви. Буквите да са подредени по честотата на срещане в текста. 
//  На всеки ред да се изписва буквата, броя на срещанията, както и графика, която да илюстрира процента на срещания (чрез символа „#”).

package mostCommonLetters;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.TreeMap;

public class Demo {
	public static void main(String[] args) {
		
		System.out.print("Please enter your text: ");
		Scanner input = new Scanner(System.in);
		String unformattedText = input.nextLine();
		String formatedText = unformattedText.replaceAll("[^\\p{L}\\p{Nd}]+", "").toUpperCase();
		TreeMap<Character, Integer> text = new TreeMap<Character, Integer>();

		for (int i = 0; i < formatedText.length(); i++) {
			if (!text.containsKey(formatedText.charAt(i))) {
				text.put(formatedText.charAt(i), 1); // creates new entry
				continue;
			}

			int value = text.get(formatedText.charAt(i)).intValue(); // value of the current element
			text.put(formatedText.charAt(i), value + 1);
		}

		// creates an array to put the entries of the map
		ArrayList<Entry<Character, Integer>> list = new ArrayList<Entry<Character, Integer>>(text.entrySet());

		// sort the array's entries by value
		Collections.sort(list, new Comparator<Map.Entry<Character, Integer>>() {
			
			@Override
			public int compare(Entry<Character, Integer> o1, Entry<Character, Integer> o2) {
				return o2.getValue().compareTo(o1.getValue());
			}
		});
		
		// printing the result
		for (Map.Entry<Character, Integer> tsak : list) {
			System.out.print(tsak.getKey() + ": " + tsak.getValue() + " ");
			for (int i = 0; i < (text.get(tsak.getKey()).floatValue() * 20) / Collections.max(text.values()); i++) {
				System.out.print("#");
			}
			System.out.println();
		}

		input.close();
	}

}
