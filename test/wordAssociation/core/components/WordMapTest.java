package wordAssociation.core.components;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class WordMapTest {

	private WordMap wm1;
	
	@Before
	public void setUp() throws Exception {
		wm1 = new WordMap();
	}

	@Test
	public void testAddVertex() {
		wm1.addVertex("sun", new ArrayList<String>());
		wm1.addVertex("sea", new ArrayList<String>());
		wm1.addVertex("grass", new ArrayList<String>());
		wm1.addVertex("rose", Arrays.asList("sun"));
		wm1.addVertex("apple", Arrays.asList("sun", "rose"));
		assertArrayEquals(wm1.getWord("sun").getNeighbor().toArray(), new String[]{"rose", "apple"});
		assertArrayEquals(wm1.getWord("rose").getNeighbor().toArray(), new String[]{"sun", "apple"});
		assertEquals(wm1.getWord("grass").getNeighbor().size(), 0);
	}
	
	@Test
	public void testAddEdge() {
		wm1.addVertex("sun", new ArrayList<String>());
		wm1.addVertex("rose", Arrays.asList("sun"));
		wm1.addVertex("apple", Arrays.asList("sun"));
		assertArrayEquals(wm1.getWord("rose").getNeighbor().toArray(), new String[]{"sun"});
		assertArrayEquals(wm1.getWord("apple").getNeighbor().toArray(), new String[]{"sun"});
		wm1.addEdge("rose", "apple");
		assertArrayEquals(wm1.getWord("rose").getNeighbor().toArray(), new String[]{"sun", "apple"});
		assertArrayEquals(wm1.getWord("apple").getNeighbor().toArray(), new String[]{"sun", "rose"});
	}
	
	@Test
	public void testGetWordExists() {
		wm1.addVertex("sun", new ArrayList<String>());
		wm1.addVertex("rose", Arrays.asList("sun"));
		wm1.addVertex("apple", Arrays.asList("sun"));
		assertEquals(wm1.getWord("sun").getData(), "sun");
		assertArrayEquals(wm1.getWord("sun").getNeighbor().toArray(), new String[]{"rose", "apple"});
	}
	
	@Test
	public void testGetWordNotExists() {
		wm1.addVertex("sun", new ArrayList<String>());
		wm1.addVertex("rose", Arrays.asList("sun"));
		wm1.addVertex("apple", Arrays.asList("sun"));
		assertNull(wm1.getWord("grass"));
		assertNull(wm1.getWord("sea"));
		assertNotNull(wm1.getWord("apple"));
	}
	
	@Test
	public void testGetFrontier() {
		
	}

}
