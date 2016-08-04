package wordAssociation.core.components;

import java.util.ArrayList;
import java.util.List;

/**
 * Defines the interface for word block
 * 
 */
public interface Block {

	/**
	 * A getter that fetch the data content contained by the block
	 * 
	 * @return Data content that resides on the block
	 */
	String getData();
	
	/**
	 * Get the list of neighbors of the block in the graph 
	 *
	 * @return neighbor blocks
	 */
	List<String> getNeighbor();
	
	/**
	 * Add a new neighbor to the block in the graph
	 * 
	 * @param newNeighbor A String representing the new neighbor to be added
	 */
	void addNeighbor(String newNeighbor);
}
