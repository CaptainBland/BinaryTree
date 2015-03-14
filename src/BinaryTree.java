
public class BinaryTree {
	private Node root;
	
	/**Internal data representation of the binary tree*/
	private class Node {
		public Node parent;
		public Node lchild;
		public Node rchild;
		public short balance;
		int value;
		public Node(int val, Node parent) {
			value = val;
			balance = 0;
			lchild = null;
			rchild = null;
			this.parent = parent;
		}
		
		public Node insert(int value) {
			
			if(value < this.value) {
				balance--;
				if(lchild == null) {
					lchild = new Node(value, this);
					return lchild;
				} else {
					return lchild.insert(value);
				}
				
				
			} else if(value > this.value) {
				balance++;
				if(rchild == null) {
					rchild = new Node(value, this);
					return rchild;
				} else {
					return rchild.insert(value);
				}
			}
		
			return null;
		}
	}
	
	
	/**Rotate left around some node Y*/
	public void rotateLeft (Node Y) {
		Node p = Y.parent;
		Node L = Y.lchild;
		Node R = Y.rchild;
		Node RL = R .lchild;
		
		if(Y.value > p.value) {
			p.rchild = R;
		} else {
			p.lchild = R;
		}
		
		Y.lchild = L;
		Y.rchild = RL;
				
	}
	
	
	public void rotateRight(Node Y) {
		Node p = Y.parent;
		Node L = Y.lchild;
		Node LR = L.rchild;
		
		if(Y.value > p.value) {
			p.rchild = L;
		} else {
			p.lchild = L;
		}
		Y.lchild = LR;
		
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
		root = new Node(rootval, null);
	}
	
	/**
	 * 
	 * @param value
	 * @return the node that was inserted
	 */
	Node insert(int value) {
		return root.insert(value);
	}
	
	public static void main(String[] args) {
		BinaryTree btree = new BinaryTree(20);
		btree.insert(5);
		btree.insert(3);
		btree.insert(10);
		btree.insert(11);
		btree.insert(-5);
		btree.insert(-7);
		btree.insert(14);
		btree.insert(15);
		btree.insert(16);
		btree.insert(17);
		for(int i = 30; i < -20; i++) {
			btree.insert(i);
		}
		System.out.println(btree);

		btree.rotateLeft(btree.root.lchild);
		System.out.println(btree);
	}
	
	
}
