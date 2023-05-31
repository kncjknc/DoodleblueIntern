
public class Runner {
	
	public static void main(String[] args) {
		LinkedLists ls = new LinkedLists();
		
		ls.insertAtEnd(20);
		ls.insertAtEnd(30);
		ls.insertAtEnd(40);
		ls.insertAtEnd(50);
		//ls.insertAtEnd(40);
		//ls.insertAtBegginin(10);
		ls.insertAtSpecificPosition(22, 0);
		//ls.deleteSpecificPosition(2);
		//ls.deleteSpecificPosition(3);
		//ls.search(30);

		//ls.reverse();
		ls.show();
	}

}
