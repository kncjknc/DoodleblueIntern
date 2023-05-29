
public class LinkedLists {
	

	public Node head=null;
	public Node tail=null;
	
	
	public void insertAtEnd(int data) {
		Node node = new Node(data);
		
		if(head==null) {
			head=node;
			tail=node;
		}
		else {
			tail.next=node;
			tail=node;
		}
	}
	
	public void insertAtBegginin(int data) {
		Node node = new Node(data);
		if(head==null) {
			head=node;
			tail=node;
		}
		else {
			Node temp=head;
			head=node;
			head.next=temp;
		}
	}
	
	public void insertAtSpecificPosition(int data, int pos) {
		Node node = new Node(data);
		
		if(head==null) {
			if(pos!=0) {
				return;
			}
			else {
				head=node;
			}
		}
		
		if(head!=null && pos==0) {
			node.next=head;
			head=node;
			return;
		}
		
		Node cnode =head;
		Node pnode =null;
		int i=0;
		while(i<pos) {
			pnode=cnode;
			cnode=cnode.next;
			if(cnode==null) {
				break;
			}
			i++;
		}
		node.next=cnode;
		pnode.next=node;
	}
	
	public void show() {
		Node node = head;
		while(node.next!=null) {
			System.out.println(node.data);
			node = node.next;
		}
		if(node.next==null) {
			System.out.println(node.data);

		}
	}
	
	
}
