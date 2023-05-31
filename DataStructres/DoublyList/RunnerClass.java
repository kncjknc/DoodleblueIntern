package Package2;

public class RunnerClass {
	
	public static void main(String[] args) {

	DoublyLinkedList dl = new DoublyLinkedList();
	
	dl.insertAtEnd(10);
	dl.insertAtEnd(20);
	dl.insertAtEnd(30);
	dl.insertAtEnd(40);
	dl.insertAtEnd(50);
	dl.deleteAtBegin();
	dl.deleteAtEnd();
	
	dl.deleteAtSpecPos(1);
	dl.display();
	
	}
}
