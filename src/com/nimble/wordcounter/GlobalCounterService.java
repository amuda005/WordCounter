package com.nimble.wordcounter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author sravya
 *
 */
//Class which counts the number of occurrences of a word across files
public class GlobalCounterService{

	public Map<String,Integer> countWords(List<Map<String,Integer>> fileCounters){
		Map<String,Integer> countMap = new HashMap<String, Integer>();
		for(Map<String, Integer> singleMap:fileCounters) {
			//iterating through word counts of each file to accumulate in a global map
			for(Map.Entry<String,Integer> entry : singleMap.entrySet()) {
				String key = entry.getKey();
				if(countMap.containsKey(key)){
					int value=countMap.get(key);
					countMap.put(entry.getKey(), value+entry.getValue());
				}else {
					countMap.put(key, entry.getValue());
				}
			}
		}
		return countMap;
	}
}
