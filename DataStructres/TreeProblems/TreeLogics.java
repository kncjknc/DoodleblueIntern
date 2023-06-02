package package3;

public class TreeLogics {
	
	public Nodes root;
	
	public TreeLogics() {
		this.root=null;
	}
	
	
	
	public void insert(int data) {
		
		Nodes node = new Nodes(data);
		
		if(root==null) {
			root=node;
			return;
		}
		else {
			Nodes currentNode=root,  parentNode=null; 
			while(true) {
				parentNode=currentNode;
				if(data<currentNode.data) {
					currentNode=currentNode.left;
				
				    if(currentNode==null) {
					   parentNode.left=node;
					   return;
				      }
			     }
				else {
					currentNode=currentNode.right;
					if(currentNode==null) {
						parentNode.right=node;
						return;	
					}
				}
			}
			
			
			
		}
	}
	
	public Nodes minVal(Nodes node) {
		if(node.left!=null) {
			return minVal(node.left);
		}
		else {
			return node;
		}
	}
	
	public Nodes delete(Nodes node, int val) {
		if(node==null) {
			return null;
		}
		else {
		if(val<node.data) {
			node.left=delete(node.left,val);
		}
		else if(val<node.data) {
			node.right=delete(node.right,val);
		}
		else {
			if(node.right==null && node.left==null) {
				node=null;
			}
			else if(node.left==null) {
				node=node.left;
			}
			else {
				Nodes temp = minVal(node.right);
				node.data=temp.data;
				node.right=delete(node.right,temp.data);
			}
		}
		
		return node;
	}
		
		
	}
	
	public void inOrder(Nodes node) {
		if(root==null) {
			System.out.println("Empty");
			return;
		}
		else {
			System.out.println(node.data +" ");
		if(node.left!=null) {
			inOrder(node.left);
		}
		if(node.right!=null) {
			inOrder(node.right);
		}
		}

	}

}
