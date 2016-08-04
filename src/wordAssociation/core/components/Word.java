package wordAssociation.core.components;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Word implements Block {
	protected boolean hidden;
	private String data;
	private List<String> neighbor;
	
	/**
	 * Constructor of a word block in the word association game
	 * 
	 * @param name The content (String format) of the word
	 * @param neighbors A list of the neighbor words in the word association network
	 */
	public Word(String name, List<String> neighbors) {
		this.data = name;
		this.neighbor = new ArrayList<String>(neighbors);   // Duplicate the list
	}
	
	public Word(Word word) {
		this.hidden = word.hidden;
		this.data = word.data;
		this.neighbor = new ArrayList<String>(word.neighbor);
	}

	/**
	 * Reveal the data on the block
	 */
	public void reveal() {
		this.hidden = true;
	}
	
	public String getData() {
		return data;
	}

	public List<String> getNeighbor() {
		return neighbor;
	}
	
	public void addNeighbor(String newNeighbor) {
		this.neighbor.add(newNeighbor);
	}
	
	@Override
	public String toString() {
		String s = this.getData();
		if (this.hidden) {
			char[] chars = new char[s.length()];
			Arrays.fill(chars, '_');
			String hidden_word = new String(chars);
			return hidden_word;
		}
		return getData();
	}

	
}
