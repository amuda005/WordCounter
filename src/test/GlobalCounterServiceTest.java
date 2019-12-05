package test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.nimble.wordcounter.GlobalCounterService;

/**
 * @author sravya
 *
 */
public class GlobalCounterServiceTest {

	private GlobalCounterService globalCounterService;
	private List<Map<String, Integer>> fileCounters;

	public GlobalCounterServiceTest() {
		globalCounterService = new GlobalCounterService();
		fileCounters = new ArrayList<Map<String, Integer>>();
	}

	@Before
	public void populate() {
		Map<String, Integer> map1 = new HashMap<String, Integer>();
		Map<String, Integer> map2 = new HashMap<String, Integer>();
		Map<String, Integer> map3 = new HashMap<String, Integer>();

		map1.put("hello", 10);
		map2.put("hello", 11);
		map3.put("World", 7);
		fileCounters.add(map1);
		fileCounters.add(map2);
		fileCounters.add(map3);
	}

	@Test
	public void countWordsPositiveTest() {

		Map<String, Integer> countWords = globalCounterService.countWords(fileCounters);
		
		assertEquals(new Integer(21), countWords.get("hello"));
		assertEquals(new Integer(7), countWords.get("World"));
	}

	@Test
	public void countWordsNegativeTest() {
		Map<String, Integer> countWords = globalCounterService.countWords(fileCounters);
		assertEquals(null, countWords.get("Nothing"));
	}
}
