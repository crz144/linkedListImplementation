/**
 * COMP 410
 * Don't modify this file!
*/

package LinkedList_A1;

public class Node {
  public double data;
  public Node next; //links this node to the next Node in the List
  public Node prev; //links this node to the preceding Node in the List
  public Node(double data){
    this.data=data;
    this.next=null;
    this.prev=null;
  }
  public String toString(){
    return "data: "+data+"\thasNext: "+(next!=null)+"\t\thasPrev: "+(prev!=null);
  }
  
  public boolean isNode(){
    return true;
  }
  public double getData(){
    return data;
  }
  public Node getNext(){
    return next;
  }
  public Node getPrev(){
    return prev;
  }
}