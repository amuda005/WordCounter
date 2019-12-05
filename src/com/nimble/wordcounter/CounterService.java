/**
 * 
 */
package com.nimble.wordcounter;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @author sravya
 *
 */
//Class which counts the number of occurrences of a word in a file
public class CounterService {
	
	public Map<String,Integer> countWords(String fileName){
		File wordsInput = new File(fileName);
		Map<String,Integer> countMap = new HashMap<String, Integer>();
		try {
			BufferedReader bufferedReader = new BufferedReader(new FileReader(wordsInput));
			String line;
			while((line=bufferedReader.readLine())!=null) {
				//removing all characters apart from alphabets,space and apostrophes
				line=line.replaceAll("[^A-Za-z'\\s]", " ");
				line=line.replaceAll("\n", "");
				String[] words=line.split("\\s+");
				for(String word:words) {
					//converting each word to lowercase
					word=word.toLowerCase();
					if(word.isEmpty()) {
						continue;
					}
					//incrementing counters of a word in the map
					if(countMap.containsKey(word)){
						int value=countMap.get(word);
						countMap.put(word, value+1);
					}else {
						countMap.put(word, 1);
					}
				}
			}
			//closing buffers for garbage collection
			bufferedReader.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return countMap;
	}
}
