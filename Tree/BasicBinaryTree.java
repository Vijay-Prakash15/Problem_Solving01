// Node class
class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }
}

// Binary Tree class
class BinaryTree {
    Node root;

    // constructor
    BinaryTree() {
        root = null;
    }

    // Inorder Traversal (Left -> Root -> Right)
    void inorder(Node root) {
        if (root == null) return;

        inorder(root.left);
        System.out.print(root.val + " ");
        inorder(root.right);
    }

    // Preorder Traversal (Root -> Left -> Right)
    void preorder(Node root) {
        if (root == null) return;

        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    // Postorder Traversal (Left -> Right -> Root)
    void postorder(Node root) {
        if (root == null) return;

        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }
}

// Main class
public class BasicBinaryTree {
    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();

        // Manual tree creation
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);

        System.out.print("Inorder Traversal: ");
        tree.inorder(tree.root);

        System.out.print("\nPreorder Traversal: ");
        tree.preorder(tree.root);

        System.out.print("\nPostorder Traversal: ");
        tree.postorder(tree.root);
    }
}
