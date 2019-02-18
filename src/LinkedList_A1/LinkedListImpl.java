/**
 * COMP 410
 *See inline comment descriptions for methods not described in interface.
 *
*/
package LinkedList_A1;

public class LinkedListImpl implements LIST_Interface {
  Node sentinel; //this will be the entry point to your linked list (the head)
  	
  public LinkedListImpl(){//this constructor is needed for testing purposes. Please don't modify!
    sentinel=new Node(0); //Note that the root's data is not a true part of your data set!
  }
  
  //implement all methods in interface, and include the getRoot method we made for testing purposes. Feel free to implement private helper methods!
  
  public Node getRoot(){ //leave this method as is, used by the grader to grab your linkedList easily.
    return sentinel;
  }

  @Override
  public boolean insert(double elt, int index) {
	Node runner;
	Node nToInsert = new Node(elt);
	if (index < 0 || index > size()) {
		return false;
	} else if (size() == 0) { // Inserting 1st Node.
		sentinel.next = nToInsert;
		sentinel.prev = nToInsert;
		nToInsert.next = sentinel;
		nToInsert.prev = sentinel;
		return true;
	} else if (index == size()) { // Inserting at end.
		runner = runToIndex(index-1);
		runner.next = nToInsert;
		nToInsert.prev = runner;
		nToInsert.next = sentinel;
		sentinel.prev = nToInsert;
		return true;
	} else if (index == 0) { // 1st node (size > 0) 
		nToInsert.next = sentinel.next;
		sentinel.next = nToInsert;
		nToInsert.prev = sentinel;
		nToInsert.next.prev = nToInsert;
		return true;
	} else { //Insert in middle of list (size > 1)
		runner = runToIndex(index-1);
		Node temp = runner.next;
		runner.next = nToInsert;
		nToInsert.prev = runner;
		nToInsert.next = temp;
		temp.prev = nToInsert;
		return true;
	}
  }

  @Override
  public boolean remove(int index) {
	Node runner;
	if (index < 0 || index >= size()) {
		return false;
	} else if (size() == 1) { //Remove only node
		this.clear();
		return true;
	} else if (index == 0) { //Remove 1st node (size > 1)
		runner = runToIndex(index+1);
		sentinel.next = runner;
		runner.prev = sentinel;
		return true;
	} else if (index == (size() - 1)) { //Remove last node (size > 1)
		runner = runToIndex(index-1);
		runner.next = sentinel;
		sentinel.prev = runner;
		return true;
	} else { //Remove node in middle of list (size > 1)
		runner = runToIndex(index - 1);
		runner.next = runner.next.next;
		runner.next.prev = runner;
		return true;
	}
  }

  @Override
  public double get(int index) {
	Node runner;
	if (index < 0 || index >= size()) {
		return Double.NaN;
	} else {
		runner = runToIndex(index);
	}
	return runner.getData();
  }

  @Override
  public int size() {
	Node runner = sentinel;
	int size = 0;
	while (runner.next != null) {
		if (runner.next == sentinel) {
			break;
		} else {
			runner = runner.next;
			size++;
		}
	}
	return size;
  }

  @Override
  public boolean isEmpty() {
	if (size() == 0) {
		return true;
	} else {
		return false;
	}
  }

  @Override
  public void clear() {
	sentinel.next = null;
	sentinel.prev = null;
  }
  
  /* Helper method to return the node at a given index.
   * In: An integer (position index)
   * Out: The Node found at that index in the linked list.
   * Effect: No change to list state.
   * Errors: Index not found in list, returns null.
   */
  public Node runToIndex(int index) {
	  Node runner = sentinel;
	  if (index < 0 || index >= size()) {
		  return null;
	  } else {
		  for (int i = -1 ; i < index ; i++) {
			  if (runner.next != null) {
				  runner = runner.next;
			  }
		  }
	  }
	  return runner;
  }
}