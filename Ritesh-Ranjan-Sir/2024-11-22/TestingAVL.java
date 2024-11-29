public class TestingAVL {

    public static void main(String[] args) {

        /* Creating a Binary Search Tree */
        BST<Integer, String> b = new BST<>();

        b.insert(8, "");
        b.insert(7, "");
        b.insert(6, "");
        b.insert(5, "");
        b.insert(4, "four");
        b.insert(3, "i m three");
        b.insert(2, "two");

        System.out.println(b.height()==7);

        /* Setting up an AVL Tree Height Based */
        AVLTreeHeight<Integer, String> avlTree = new AVLTreeHeight<>();

        avlTree.insert(8, "");
        avlTree.insert(7, "");
        avlTree.insert(6, "");
        avlTree.insert(5, "");
        avlTree.insert(4, "four");
        avlTree.insert(3, "i m three");
        avlTree.insert(2, "two");

        System.out.println(avlTree.height()==3);

        /* Setting up an AVL Tree Size Based */
        AVLTreeSize<Integer, String> avlTree2 = new AVLTreeSize<>();

        avlTree2.insert(8, "");
        avlTree2.insert(7, "");
        avlTree2.insert(6, "");
        avlTree2.insert(5, "");
        avlTree2.insert(4, "four");
        avlTree2.insert(3, "i m three");
        avlTree2.insert(2, "two");

        System.out.println(avlTree2.height()==4);

    }
}