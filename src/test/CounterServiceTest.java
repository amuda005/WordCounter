/**
 * @author sravya
 *
 */
package test;

import java.nio.file.Paths;
import java.util.Map;

import org.junit.Test;

import com.nimble.wordcounter.CounterService;

import static org.junit.Assert.*;

public class CounterServiceTest {

	private CounterService counterService;

	public CounterServiceTest() {
		counterService = new CounterService();
	}

	@Test
	public void countWordsTest() {
		
		String filename = Paths.get("../inputDir", "file1.txt").toString();
		Map<String, Integer> countWords = counterService.countWords(filename);

		assertEquals(new Integer(2), countWords.get("love"));
		assertEquals(null, countWords.get("hellolll"));
		assertEquals(new Integer(1), countWords.get("world"));
	}

}
