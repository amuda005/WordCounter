/**
 * 
 */
package com.nimble.wordcounter;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * @author sravya
 *
 */
public class Starter {
	static String dir = "inputDir";

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String path = "files.txt";

		//Read the file which contains list of files
		File filesInput = new File(Paths.get(dir, path).toUri());
		List<String> fileNames = new ArrayList<String>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(filesInput));
			String fileName;
			while ((fileName = bufferedReader.readLine()) != null) {
				fileNames.add(fileName);
			}
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Counting words in each file
		List<Map<String, Integer>> fileCounters = new ArrayList<Map<String, Integer>>();
		CounterService counterService = new CounterService();
		for (int i=0;i<fileNames.size();i++) {
			fileCounters.add(i, counterService.countWords(Paths.get(dir, fileNames.get(i)).toString()));
		}
		
		//counting words from across files
		GlobalCounterService globalCounterService = new GlobalCounterService();
		Map<String, Integer> out = globalCounterService.countWords(fileCounters);
		
		
		//writing count of all words across files to output file
		File outputFile = new File(Paths.get("output_" + System.currentTimeMillis() + ".txt").toUri());
		try {
			Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(outputFile.getAbsolutePath())));
			for (String key : out.keySet()) {
				writer.write(key+" "+out.get(key)+"\n");//writing in key-value format
				System.out.println(key+" "+out.get(key));
			}
			//closing writer for garbage collection
			writer.close();
			}catch (IOException e) {
				e.printStackTrace();
			}
		System.out.println("\n\nEnter a word for selection:");
		// selecting a word from list of words
		Scanner enter = new Scanner(System.in);
		String choice = enter.next();

		while (true) {
			if (out.containsKey(choice)) {
				System.out.println("The word showed up in these files : ");
				for (int i=0;i<fileNames.size();i++) {
					if(fileCounters.get(i).containsKey(choice))
						System.out.println(fileNames.get(i)+" has the word "+fileCounters.get(i).get(choice)+" times");
				}
				System.out.println("Total Number of times the word showed up: "+out.get(choice));
			} else
				System.out.println("Not a word from list");
			System.out.println("\nPress Ctrl+C to stop the program.");
			System.out.println("\nEnter a word for selection:");
			choice=enter.next();
		}
	}

}
