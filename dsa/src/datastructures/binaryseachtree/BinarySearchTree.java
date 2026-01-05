package datastructures.binaryseachtree;

public class BinarySearchTree {

    Node root;

    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
        }

    }

    public BinarySearchTree() {
        root = null;
    }

    public boolean insert(int value) {
        Node newNode = new Node(value);
        if (root == null) {
            root = newNode;
            return true;
        }
        Node temp = root;
        while(true) {
            if (newNode.value == temp.value) return false;
            if (newNode.value < temp.value) { // Left
                if (temp.left == null) { // Left node is open
                    temp.left = newNode;
                    return true;
                }
                temp = temp.left;
            } else { // Right
                if (temp.right == null) { // Left node is open
                    temp.right = newNode;
                    return true;
                }
                temp = temp.right;
            }
        }
    }

    public boolean contains(int value) {
        if (root == null) return false;

        Node temp = root;
        while(temp != null) {
            if (temp.value == value) return true;
            if (value < temp.value) { // Move to left node
                temp = temp.left;
            } else {
                temp = temp.right;
            }
        }
        return false;
    }

}
