public class AVLTree extends Tree{
    void updateHeight(Node current) {
        current.height = 1 + Math.max(height(current.left), height(current.right));
    }
    int height(Node current) {
        return current == null ? -1 : current.height;
    }
    int getBalance(Node current) {
        return (current == null) ? 0 : height(current.left) - height(current.right);
    }
    Node rotateRight(Node current) {
        Node left = current.left;
        Node rightLeft = left.right;
        left.right = current;
        current.left = rightLeft;
        updateHeight(current);
        updateHeight(left);
        return left;
    }
    Node rotateLeft(Node current) {
        Node right = current.right;
        Node leftRight = right.left;
        right.left = current;
        current.right = leftRight;
        updateHeight(current);
        updateHeight(right);
        return right;
    }
    Node rebalance(Node current) {
        updateHeight(current);
        int balance = getBalance(current);
        if (balance > 1) {
            if (height(current.left.left) > height(current.left.right))
                current = rotateRight(current);
            else {
                current.left = rotateLeft(current.left);
                current = rotateRight(current);
            }
        } else if (balance < -1) {
            if (height(current.right.right) > height(current.right.left)) {
                current = rotateLeft(current);
            } else {
                current.right = rotateRight(current.right);
                current = rotateLeft(current);
            }
        }
        return current;
    }
    @Override
    public void add(int value) {
        root = addRecursive(root, value);
    }
    Node addRecursive(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }
        else if (value < current.value) {
            current.left = addRecursive(current.left, value);
        }
        else if (value > current.value) {
            current.right = addRecursive(current.right, value);
        }
        else {
            return current;
        }
        return rebalance(current);
    }
    @Override
    public void delete(int value) {
        root = deleteRecursive(root, value);
    }
    Node deleteRecursive(Node current, int value) {
        if (current == null) {
            return null;
        }
        else if (current.value > value) {
            current.left = deleteRecursive(current.left, value);
        }
        else if (current.value < value) {
            current.right = deleteRecursive(current.right, value);
        }
        else {
            if (current.left == null || current.right == null) {
                current = (current.left == null) ? current.right : current.left;
            }
            else {
                Node mostLeftNode = mostLeftNode(current.right);
                current.value = mostLeftNode.value;
                current.right = deleteRecursive(current.right, current.value);
            }
        }
        if (current != null) {
            current = rebalance(current);
        }
        return current;
    }
}
