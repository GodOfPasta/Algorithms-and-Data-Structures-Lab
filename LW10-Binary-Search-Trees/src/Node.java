public class Node {
    private boolean isBalanced;
    int value;
    int height;
    Node left, right;
    Node(int key) {
        this.value = key;
        left = null;
        right = null;
    }

}