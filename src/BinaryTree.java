
public class BinaryTree {
	private Node root;
	
	/**Internal data representation of the binary tree*/
	private class Node {
		public Node parent;
		public Node lchild;
		public Node rchild;
		public short balance;
		int value;
		public Node(int val) {
			value = val;
			balance = 0;
			lchild = null;
			rchild = null;
		}
		
		public Node insert(int value, Node parent) {
			
			if(value < this.value) {
				balance--;
				if(lchild == null) {
					lchild = new Node(value);
					return lchild;
				} else {
					return lchild.insert(value, this);
				}
				
				
			} else if(value > this.value) {
				balance++;
				if(rchild == null) {
					rchild = new Node(value);
					return rchild;
				} else {
					return rchild.insert(value, this);
				}
			}
		
			return null;
		}
	}
	
	
	/**Traverse the tree and join it into a string*/
	private String joinTree(Node node) {
		String before = "";
		String after = "";

		String midstring = String.valueOf(node.value);
		
		if(node.lchild != null) {
			before = joinTree(node.lchild) + ", ";
		}
		if(node.rchild != null) {
			after = ", " + joinTree(node.rchild);
		}
		
		
		return before + midstring + after;
		
	}
	
	@Override
	public String toString() {
		return "<BinaryTree> CONTAINS: " + joinTree(root) + " :: BALANCE: " + root.balance;
	}
	
	
	public BinaryTree(int rootval) {
		root = new Node(rootval);
	}
	
	/**
	 * 
	 * @param value
	 * @return the node that was inserted
	 */
	Node insert(int value) {
		return root.insert(value, null);
	}
	
	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree(6);
		btree.insert(5);
		btree.insert(3);
		btree.insert(10);
		btree.insert(11);
		btree.insert(-5);
		
		System.out.println(btree);
	}
	
	
}
