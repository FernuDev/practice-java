package datastructures.binaryseachtree;

public class Main {
    public static void main(String[] args) {
        BinarySearchTree myBST = new BinarySearchTree();

        myBST.insert(47);
        myBST.insert(21);
        myBST.insert(76);
        myBST.insert(18);
        myBST.insert(52);
        myBST.insert(82);

        myBST.insert(27);

        System.out.println(myBST.root.left.right.value);

        int searchTo = 17;
        if (myBST.contains(searchTo)) {
            System.out.println("El árbol binario contiene al "+searchTo);
        } else {
            System.out.println("El árbol binario NO contiene al "+searchTo);
        }
    }
}
