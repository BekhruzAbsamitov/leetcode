package tree;

import queue.Queue;
import queue.QueueOverflowException;
import stack.StackUnderflowException;

public class Node<T> {

    private T data;
    private Node<T> leftChild;
    private Node<T> rightChild;

    public Node(T data) {
        this.data = data;
    }

    public static void breathFirst(Node root) throws QueueOverflowException, StackUnderflowException {
        if (root == null) {
            return;
        }

        Queue<Node> queue = new Queue<>(Node.class);
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            Node node = queue.dequeue();
            System.out.println(node);

            if (node.getLeftChild() != null) {
                queue.enqueue(node.getLeftChild());
            }
            if (node.getRightChild() != null) {
                queue.enqueue(node.getRightChild());
            }
        }
    }

    public static void preOrder(Node<Character> root) {
        if (root == null) {
            return;
        }

        System.out.println(root);
        preOrder(root.getLeftChild());
        preOrder(root.getRightChild());
    }

    public static void inOrder(Node<Character> root) {
        if (root == null) {
            return;
        }
        inOrder(root.getLeftChild());
        System.out.println(root);
        inOrder(root.getRightChild());
    }

    public static void postOrder(Node<Character> root) {
        if (root == null) {
            return;
        }

        postOrder(root.getLeftChild());
        postOrder(root.getRightChild());
        System.out.println(root);
    }

    public static Node<Character> insert(Node<Character> head, Node<Character> node) {
        if (head == null) {
            return node;
        }

        if (node.getData() <= head.getData()) {
            head.setLeftChild(insert(head.getLeftChild(), node));
        } else {
            head.setRightChild(insert(head.getRightChild(), node));
        }
        return head;
    }

    public static Node<Character> lookup(Node<Character> head, char data) {
        if (head == null) {
            return null;
        }

        if (head.getData() == data) {
            return head;
        }

        if (data <= head.getData()) {
            return lookup(head.getLeftChild(), data);
        } else {
            return lookup(head.getRightChild(), data);
        }
    }

    public static int minimumValue(Node<Character> head) {
        if (head == null) {
            return Integer.MIN_VALUE;
        }

        if (head.getLeftChild() == null) {
            return head.getData();
        }

        return minimumValue(head.getLeftChild());
    }

    public static int maxDepth(Node<Character> root) {
        if (root == null) {
            return 0;
        }

        if (root.getLeftChild() == null && root.getRightChild() == null) {
            return 0;
        }

        int leftMaxDepth = 1 + maxDepth(root.getLeftChild());
        int rightMaxDepth = 1 + maxDepth(root.getRightChild());

        return Math.max(leftMaxDepth, rightMaxDepth);
    }

    public static void mirror(Node<Integer> root) {
        if (root == null) {
            return;
        }

        mirror(root.getLeftChild());
        mirror(root.getRightChild());

        //Swap the left and right child for every node
        Node<Integer> temp = root.getRightChild();
        root.setLeftChild(root.getRightChild());
        root.setRightChild(temp);
    }

    public static int countTrees(int numNodes) {
        if (numNodes <= 1) {
            return 1;
        }

        int sum = 0;
        for (int i = 1; i <= numNodes; i++) {
            int countLeftTrees = countTrees(i - 1);
            int countRightTrees = countTrees(numNodes - i);

            sum = sum + (countLeftTrees * countRightTrees);
        }

        return sum;
    }

    public static void printRange(Node<Integer> root, int low, int high) {
        if (root == null) {
            return;
        }

        if (low <= root.getData()) {
            printRange(root.getLeftChild(), low, high);
        }

        if (low <= root.getData() && root.getData() <= high) {
            System.out.println(root.getData());
        }

        if (high > root.getData()) {
            printRange(root.getRightChild(), low, high);
        }
    }

    public static boolean isBinarySearchTree(Node<Integer> root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.getData() <= min || root.getData() > max) {
            return false;
        }

        return isBinarySearchTree(root.getLeftChild(), min, root.getData()) ||
                isBinarySearchTree(root.getRightChild(), root.getData(), max);
    }

    public T getData() {
        return data;
    }

    public Node<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(Node<T> leftChild) {
        this.leftChild = leftChild;
    }

    public Node<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(Node<T> rightChild) {
        this.rightChild = rightChild;
    }
}
