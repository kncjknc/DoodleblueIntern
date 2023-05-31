
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
				return;
			}
		}
		
		if(head!=null && pos==0) {
			node.next=head;
			head=node;
			return;
		}
		
		Node nextnode =head;
		Node pnode =null;
		int i=0;
		while(i<pos) {
			pnode=nextnode;
			nextnode=nextnode.next;
			if(nextnode==null) {
				break;
			}
			i++;
		}
		node.next=nextnode;
		pnode.next=node;
	}
	
	public void deleteSpecificPosition(int pos) {
	
		if(head==null) {
			return;
		}
		Node temp=head;
		if(pos==0) {
			head=temp.next;
		}
		for(int i=0;temp!=null && i<pos-1;i++) {// 1 2 3 4  20 30 40 50 
			temp=temp.next;
		}
		if(temp==null || temp.next==null) {
			return;
		}
		Node newNode = temp.next.next;
		temp.next=newNode;
		
	}
	
	public void deleteAtBegin() {
		if(head!=null) {
			return;
		}
		else {
			if(head!=tail) {
				head=head.next;
			}
			else {
				head=tail=null;
			}
		}
	}
	
	public void deleteAtEnd() {
		if(head==null) {
			return;
		}
		else {
			if(head!=tail) {
			Node temp=head;
			while(temp.next!=tail) {
				temp=temp.next;
			}
			tail=temp;
			tail=temp.next;
			}
			else {
				head=tail=null;
			}
			
		}
	}
	
	public void search(int data) {
		if(head==null) {
			return;
		}
		else {
			Node temp=head;
			int i=1;
			boolean flag=false;
			while(temp!=null) {
				if(temp.data==data) {
					flag=true;
					break;
				}
				else {
					temp=temp.next;
				}
			}
			if(flag==true) {
				System.out.println("Found it");
			}
			else {
				System.out.println("Not Found it");
			}
			
		}
	}
	
	public Node reverse() {
		
			Node pnode=null;
			Node cnode=head;
			Node nnode=null;
			
			while(cnode!=null) {
				nnode=cnode.next;
				cnode.next=pnode;
				pnode=cnode;
				cnode=nnode;
			}
			head=pnode;
			return head;
			
			// 1  2  3  n2 cn null pn1 cn2  n3 cn1 pn2 cn3 nn null cn2 pn3 nn null
			// 
		
		
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
