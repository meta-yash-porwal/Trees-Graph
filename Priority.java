
/**
 * interface for Priority Queue
 * @author yash.porwal_metacube
 *
 */
public interface Priority {
	
	/**
	 * method is for adding data with the priority to the queue
	 * @param data input by user in an integer form
	 * @param priority of the task (data) 
	 */
	public void enqueue(int data,int priority);
	
	/**
	 * method is for removing data with the priority from the queue 
	 * @return the integer with priority which is being removed
	 */
	public int dequeue();
	
	/**
	 * method to display the first value which is being remove first
	 * @return the integer value
	 */
	public int peek();
	
	/**
	 * checks that the queue is empty or not
	 * @return the boolean value
	 */
	public boolean isEmpty();
	
	/**
	 * checks that the queue is full or not
	 * @return the boolean value
	 */
	public boolean isFull();
}