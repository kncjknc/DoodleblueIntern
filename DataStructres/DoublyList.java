package Package2;

public class DoublyLinkedList {
	
	public Nodes head,tail=null;
	
	public void insertAtEnd(int data) {
		Nodes node = new Nodes(data);
		
		if(head==null) {
			head=node;
			tail=node;
			
			head.prev=null;
			tail.next=null;
		}
		else {
			tail.next=node;
			node.prev=tail;
			tail=node;
			tail.next=null;
		}
	}
	
	
	public void insertAtBegin(int data) {
	
		Nodes node = new Nodes(data);
		
		if(head==null) {
			head=node;
			tail=node;
			
			head.next=null;
			head.prev=null;
			
		}
		else {
			head.prev=node;
			node.next=head;
			head=node;
			node.prev=null;
		}
	}
	
	public void inserAtSpecific(int data, int pos) {
		Nodes node = new Nodes(data);
		
		if(head==null) {
			if(pos!=0) {
				return;
			}
		}
		else {
			head=node;
		}
		
		Nodes cnode=head;
		Nodes pnode=null;
		
		int i=0;
		
		if(head!=null && pos==0) {
			node.next=head;
			head=node;
			return;
		}
		
		while(i<pos) {
			pnode=cnode;
			cnode=cnode.next;
			if(cnode==null) {
				break;
			}
			i++;
		}
		
		node.next=cnode;
		cnode.prev=node;
		node.prev=pnode;
		pnode.next=node;
		
	}
	
	public void deleteAtSpecPos(int pos) {
		
		if(head==null) {
			return;
		}
		Nodes temp=head;
		if(pos==0) {
			head=temp.next;
			head.prev=null;
			return;
		}
		
		for(int i=0; temp!=null && i < pos-1 ;i++) {
			temp=temp.next;
		}
		
		if(temp==null || temp.next==null) {
			return;
		}
		
		Nodes newNode = temp.next.next;
		temp.next=newNode;
		newNode.prev=temp;
		
	}
	
	public void deleteAtBegin() {
		if(head==null) {
			return;
		}
		else {
			if(head!=tail) {
			head=head.next;
			head.prev=null;
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
			Nodes node=head;
			if(head!=tail) {
				while(node.next!=tail) {
					node=node.next;
				}
				tail.prev=null;
				tail=node;
				tail.next=null;
			}
		}
	}
	
	public void search(int data) {
		Nodes node = head;
		int i=1;
		boolean flag=false;
		if(head==null) {
			return;
		}
		else {
			while(node!=null) {
				if(node.data==data) {
					flag=true;
					break;
				}
				i++;
				node=node.next;
			}
			if(flag==true) {
				System.out.println("Found it!");
			}
			else {
				System.out.println("Not Found it!");
			}
		}
	}
	
	public void reverse() {
		Nodes cnode=head;
		Nodes pnode=null;
		if(head!=null)
		while(cnode!=null) {
			pnode=cnode.prev;
			cnode.prev=cnode.next;
			cnode.next=pnode;
			cnode=cnode.prev;
     	}
		if(pnode!=null) {
			head=pnode;
		}
	}
	
	public void display() {
		Nodes temp = head;
		while(temp!=null) {
			System.out.println(temp.data);
			temp=temp.next;
		}
	}
	
	
}
