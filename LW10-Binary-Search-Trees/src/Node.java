public class Node {
    private boolean isBalanced;
    int value;
    Node left, right;
    //private int height = left.height() - right.height();
    Node(int key) {
        this.value = key;
        left = null;
        right = null;
    }

}