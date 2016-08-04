package wordAssociation.core.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Implements the basic framework
 * 
 */
public class WordMap {
	private Map<String, Word> wordMap = new HashMap<String, Word>();
	private List<String> frontier;
	
	/**
	 * Constructor for the WordMap of the word association game
	 */
	public WordMap() {
		setFrontier(new ArrayList<String>());
	}

	/**
	 * Add a node into the wordMap (as well as its neighborhood information)
	 * 
	 * @param data Content on the node
	 * @param neighbors Neighbors of the new node
	 */
	public synchronized void addVertex(String data, List<String> neighbors) {
		if (wordMap.containsKey(data)) {
			System.out.println("Duplicated node added");
			return;
		}
		for (String s: neighbors) {
			if (!wordMap.containsKey(s)) {
				System.out.println("Preset neighbor " + s + " does not exist. Ignore.");
				continue;
			}
			wordMap.get(s).addNeighbor(data);
		}
		
		Word w = new Word(data, neighbors);
		wordMap.put(data, w);
		return;
	}
	
	/**
	 * Add a neighbor relationship between two words
	 * 
	 * @param first The first word (as a String) to be joined
	 * @param second The second word (as a String) to be joined
	 */
	public synchronized void addEdge(String first, String second) {
		if (wordMap.containsKey(first) && wordMap.containsKey(second)) {
			wordMap.get(first).addNeighbor(second);
			wordMap.get(second).addNeighbor(first);
		}
	}
	
	/**
	 * Get the Word object (if any) from the content of this word
	 * 
	 * @param data The content of the word (as a String, in English)
	 * @return A copy of the Word object, if there's any matching the data; otherwise null
	 */
	public synchronized Word getWord(String data) {
		return wordMap.containsKey(data) ? new Word(wordMap.get(data)) : null;
	}

	public synchronized List<String> getFrontier() {
		return frontier;
	}

	private synchronized void setFrontier(List<String> frontier) {
		this.frontier = frontier;
	}

}

