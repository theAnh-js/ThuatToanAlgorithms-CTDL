package Tree;

public class Test {

    public static void main(String[] args) {
        // MyBinaryTree myTree = new MyBinaryTree();
        // myTree.init();

        // System.out.println("Done");

        MyBST myBST = new MyBST();

        myBST.mRoot = myBST.insert(myBST.mRoot, 5);
        myBST.mRoot = myBST.insert(myBST.mRoot, 1);
        myBST.mRoot = myBST.insert(myBST.mRoot, 6);
        myBST.mRoot = myBST.insert(myBST.mRoot, 0);
        myBST.mRoot = myBST.insert(myBST.mRoot, 3);
        myBST.mRoot = myBST.insert(myBST.mRoot, 7);
        myBST.mRoot = myBST.insert(myBST.mRoot, 2);
        myBST.mRoot = myBST.insert(myBST.mRoot, 4);

        System.out.println("Done");
    }
}
