package com.foo.homework;

// BST implements a binary search tree.
public class BST {
    private Node root;

    public BST() {
        root = null;
    }

    public static BST makeFromArray(int[] array) {
        BST tree = new BST();
        for (int item : array) {
            tree.insert(item);
        }
        return tree;
    }

    public static BST makeExample() {
        BST tree = new BST();
        tree.root = new Node(45);
        tree.root.left = new Node(10);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(12);
        tree.root.right = new Node(90);
        return tree;
    }

    // delete an entry if exists
    public void deleteKey(int key) {
        root = recurseToDelete(root, key);
    }

    private Node recurseToDelete(Node n, int key) {
        if (n == null) {
            return null;
        }
        if (key == n.key) {
            TreeBuildingVisitor v = new TreeBuildingVisitor();
            postOrder(n.left, v);
            postOrder(n.right, v);
            return v.getTree().root;
        }
        if (key < n.key) {
            n.left = recurseToDelete(n.left, key);
            return n;
        }
        n.right = recurseToDelete(n.right, key);
        return n;
    }

    // insert an integer
    public void insert(int key) {
        root = recurseToInsert(root, key);
    }

    private Node recurseToInsert(Node n, int key) {
        if (n == null) {
            return new Node(key);
        }
        if (key == n.key) {
            return n;
        }
        if (key < n.key) {
            n.left = recurseToInsert(n.left, key);
            return n;
        }
        n.right = recurseToInsert(n.right, key);
        return n;
    }

    // search returns true if the argument is in the tree, else false.
    public boolean search(int key) {
        return recurseToSearch(root, key);
    }

    private boolean recurseToSearch(Node n, int key) {
        if (n == null) {
            return false;
        }
        if (key == n.key) {
            return true;
        }
        if (key < n.key) {
            return recurseToSearch(n.left, key);
        }
        return recurseToSearch(n.right, key);
    }

    // PostOrder Traversal - Left:Right:rootNode (LRn)
    public void postOrder_traversal(NodeVisitor v) {
        postOrder(root, v);
    }

    private void postOrder(Node node, NodeVisitor v) {
        if (node == null) return;
        postOrder(node.left, v);
        postOrder(node.right, v);
        v.visit(node);
    }

    // InOrder Traversal - Left:rootNode:Right (LnR)
    public void inOrder_traversal(NodeVisitor v) {
        inOrder(root, v);
    }

    private void inOrder(Node node, NodeVisitor v) {
        if (node == null) return;
        inOrder(node.left, v);
        v.visit(node);
        inOrder(node.right, v);
    }

    // PreOrder Traversal - rootNode:Left:Right (nLR)
    public void preOrder_traversal(NodeVisitor v) {
        preOrder(root, v);
    }

    private void preOrder(Node node, NodeVisitor v) {
        if (node == null) return;
        v.visit(node);
        preOrder(node.left, v);
        preOrder(node.right, v);
    }
}
