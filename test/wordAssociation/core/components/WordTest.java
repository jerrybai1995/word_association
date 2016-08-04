package wordAssociation.core.components;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class WordTest {
	
	private Word w1;
	private Word w2;
	private Word w3;
	private Word w4;
	
	@Before
	public void setUp() throws Exception {
		w1 = new Word("w1", Arrays.asList("w2", "w3", "w4"));
		w2 = new Word("w2", Arrays.asList("w1"));
		w3 = new Word("w3", Arrays.asList("w1", "w4"));
		w4 = new Word("w4", Arrays.asList("w1", "w3"));
	}
	
	@Test
	public void testReveal() {
		assertFalse(w1.hidden);
		assertFalse(w2.hidden);
		w1.reveal();
		assertTrue(w1.hidden);
		assertFalse(w2.hidden);
		w2.reveal();
		assertTrue(w2.hidden);
	}
	
	@Test
	public void testGetData() {
		assertEquals(w1.getData(), "w1");
		assertEquals(w2.getData(), "w2");
		assertEquals(w3.getData(), "w3");
		assertEquals(w4.getData(), "w4");
	}
	
	@Test
	public void testGetNeighbor() {
		assertArrayEquals(w1.getNeighbor().toArray(), new String[]{"w2", "w3", "w4"});
		assertArrayEquals(w2.getNeighbor().toArray(), new String[]{"w1"});
		assertArrayEquals(w3.getNeighbor().toArray(), new String[]{"w1", "w4"});
		assertArrayEquals(w4.getNeighbor().toArray(), new String[]{"w1", "w3"});
	}
	
	@Test
	public void testAddNeighbor() {
		assertArrayEquals(w2.getNeighbor().toArray(), new String[]{"w1"});
		w2.addNeighbor("w3");
		assertArrayEquals(w2.getNeighbor().toArray(), new String[]{"w1", "w3"});
	}

}
