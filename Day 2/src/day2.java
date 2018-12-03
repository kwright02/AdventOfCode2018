import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class day2 {

	public static char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
	
	public static void main(String[] args) {
		File input1 = new File("../Day 2/input.txt");//, input2 = new File("../Day 2/input2.txt");
		/*
		 * Day 2 part 1
		 * 
		 * 
		 */
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(input1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<String> twos = new ArrayList<>(), threes = new ArrayList<>();
		br.lines().forEach(new Consumer<String>() {
			@Override
			public void accept(String t) {
				char[] chars = t.toCharArray();
				Arrays.sort(chars);
				String a = Arrays.toString(chars).replace("[", "").replace("]", "").replace(",", "").replace(" ", "");
				ArrayList<String> lines = new ArrayList<>();
				for(char c: alphabet) {
					if(a.indexOf(c) >= 0) {
						lines.add(a.substring(a.indexOf(c), a.lastIndexOf(c) + 1));
					}
				}
				System.out.println(lines);
				for(String l: lines) {
					if(l.length() == 2 && !twos.contains(t)) {
						twos.add(t);
					} else if(l.length() == 3 && !threes.contains(t)) {
						threes.add(t);
					}
				}
				System.out.println("Two: " + twos.contains(t) + " Three: " + threes.contains(t));
			}
		});
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Part 1: " + " t: " + twos.size() + " th: " + threes.size() + " a: " + (twos.size() * threes.size()));
		/*
		 * Day 2 part 2
		 * 
		 */
		
	}
	
}
