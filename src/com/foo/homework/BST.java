package com.foo.homework;

import java.util.List;

// BST implements a binary search tree.
public class BST {
    private Node root;

    public BST() {
        root = null;
    }

    public static BST makeFromArray(int[] array) {
        BST tree = new BST();
        for (int item : array ) {
            tree.insert(item);
        }
        return tree;
    }

    public void deleteKey(int key) {
        root = recurseToDelete(root, key);
    }
    private Node recurseToDelete(Node n, int key) {
        if (n == null) {
            // Not found in tree, nothing to do.
            return null;
        }
        if (key == n.key) {
            return null;
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

    // recursively insert a node
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
        return searchRecursive(root, key);
    }

    private boolean searchRecursive(Node n, int key) {
        if (n == null) {
            return false;
        }
        if (key == n.key) {
            return true;
        }
        if (key < n.key) {
            return searchRecursive(n.left, key);
        }
        return searchRecursive(n.right, key);
    }

    // PostOrder Traversal - Left:Right:rootNode (LRn)
    public void postOrder_traversal(List<Integer> list) {
        postOrder(root, list);
    }

    private void postOrder(Node node, List<Integer> list) {
        if (node == null) return;
        postOrder(node.left, list);
        postOrder(node.right, list);
        list.add(node.key);
    }

    // InOrder Traversal - Left:rootNode:Right (LnR)
    public void inOrder_traversal(List<Integer> list) {
        inOrder(root, list);
    }

    private void inOrder(Node node, List<Integer> list) {
        if (node == null) return;
        inOrder(node.left, list);
        list.add(node.key);
        inOrder(node.right, list);
    }

    // PreOrder Traversal - rootNode:Left:Right (nLR)
    public void preOrder_traversal(List<Integer> list) {
        preOrder(root, list);
    }

    private void preOrder(Node node, List<Integer> list) {
        if (node == null) return;
        list.add(node.key);
        preOrder(node.left, list);
        preOrder(node.right, list);
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
}
