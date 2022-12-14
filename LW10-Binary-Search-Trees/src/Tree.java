public class Tree {
    Node root;
    Tree(){
        root = null;
    }
    public void add(int value) {
        root = addRecursive(root, value);
    }
    private Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        if (value < current.value) {
            current.left = addRecursive(current.left, value);
        }
        else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        else {
            return current;
        }
        return current;
    }
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }
    private Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            if (current.left == null && current.right == null) {
                return null;
            }
            if (current.right == null) {
                return current.left;
            }
            if (current.left == null) {
                return current.right;
            }
            Node mostLeftNode = mostLeftNode(current.right);
            current.value = mostLeftNode.value;
            current.right = deleteRecursive(current.right, mostLeftNode.value);
            return current;
        }
        if (value < current.value) {
            current.left = deleteRecursive(current.left, value);
            return current;
        }
        current.right = deleteRecursive(current.right, value);
        return current;
    }
    protected Node mostLeftNode(Node current) {
        return current.left == null ? current : mostLeftNode(current.left);
    }
    public boolean contains(int value){
        return containsRecursive(root, value);
    }
    private boolean containsRecursive(Node current, int value) {
        if (current == null)
            return false;
        if (value == current.value)
            return true;
        return value < current.value ? containsRecursive(current.left, value) : containsRecursive(current.right, value);
    }

    //???????????????????????????????? ??????????
    public void inorder(Node current){
        if(current != null){
            inorder(current.left);
            System.out.printf(" %d ->", current.value);
            inorder(current.right);
        }
    }
    //???????????????????? ??????????
    public void preorder(Node current){
        if(current != null){
            System.out.printf(" %d ->", current.value);
            preorder(current.left);
            preorder(current.right);
        }
    }
    //???????????????????? ??????????
    public void postorder(Node current){
        if(current != null){
            postorder(current.left);
            postorder(current.right);
            System.out.printf(" %d ->", current.value);
        }
    }
}
