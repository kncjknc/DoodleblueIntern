package package3;

public class RunnerClass {

	public static void main(String[] args) {
		
		TreeLogics tl = new TreeLogics();
		
		tl.insert(10);
		tl.insert(20);
		tl.insert(30);
		tl.insert(40);
		tl.insert(50);
		tl.delete(tl.root,50);
		
		tl.inOrder(tl.root);

		

	}

}
