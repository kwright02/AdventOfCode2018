import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;

public class day1 {

	public static int f = 0, tri = 0;
	public static ArrayList<Integer> prev = new ArrayList<Integer>();
	public static boolean done = false;

	public static void main(String[] args){
		File input1 = new File("../Day 1/input.txt"), input2 = new File("../Day 1/input2.txt");
		BufferedReader br = null;
		/*
		 * Day 1 part 1
		 * 
		 * I solved this problem by using for-each
		 * consumer responders on the buffered reader
		 * result to attempt at quickly calculating the result.
		 * It takes about 1.3 seconds to complete.
		 */
		try {
			br = new BufferedReader(new FileReader(input1));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		br.lines().forEach(new Consumer<String>() {
			@Override
			public void accept(String line) {
				Arrays.asList(line.replace("+", "").split(",")).forEach(new Consumer<String>(){
					@Override
					public void accept(String t) {
						f += (Integer.valueOf(t));
					}
				});
			}
		});
		System.out.println("Part 1: " + f);
		try {
			br.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		 * Day 1 part 2
		 * 
		 * 
		 */
		System.out.println("Starting part 2");
		BufferedReader br2 = null;
		try {
			br2 = new BufferedReader(new FileReader(input2));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		day1.f = 0;
		ArrayList<String> linesList = new ArrayList<>();
		br2.lines().forEach(new Consumer<String>() {
			@Override
			public void accept(String line) {
				Arrays.asList(line.replace("+", "")).forEach(new Consumer<String>(){
					@Override
					public void accept(String t) {
						linesList.add(t);
					}
				});
			}
		});
		String[] lines = linesList.toString().replace('[', ' ').replace(']', ' ').replaceAll(" ", "").split(",");
		System.out.println(linesList);
		int i = 0;
		while(!done) {
			if(i >= lines.length) {
				i = 0;
			}
			f += Integer.valueOf(lines[i]);
			if(prev.contains(f)) {
				System.out.println("Part 2: " + f);
			} else {
				prev.add(f);
			}
		}
		try {
			br2.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}