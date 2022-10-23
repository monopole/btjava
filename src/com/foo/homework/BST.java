package com.foo.homework;

import java.util.List;

public class BST {
    private Node root;

    // Constructor for src.homework.BST =>initial empty tree
    public BST() {
        root = null;
    }

    public static BST makeExample() {
        BST tree = new BST();
        tree.root = new Node(45);
        tree.root.left = new Node(10);
        tree.root.right = new Node(90);
        tree.root.left.left = new Node(7);
        tree.root.left.right = new Node(12);
        return tree;
    }

    //delete a node from src.homework.BST
    public void deleteKey(int key) {

    }

    private int minValue(Node root) {
        return 0;
    }

    // insert a node in src.homework.BST
    public void insert(int key) {
        root = insertRecursive(root, key);
    }

    // recursively insert a node
    private Node insertRecursive(Node n, int key) {
        if (n == null) {
            return new Node(key);
        }
        if (key < n.key) {
            n.left = insertRecursive(n.left, key);
        } else {
            if (key > n.key) {
                n.right = insertRecursive(n.right, key);
            }
        }
        return n;
    }

    public boolean search(int key) {
        return false;
    }

    public void postOrder_traversal(List<Integer> list) {
        postOrder(root);
    }

    //PostOrder Traversal - Left:Right:rootNode (LRn)
    private void postOrder(Node node) {

    }


    public void inOrder_traversal(List<Integer> list) {
        inOrder(root, list);
    }

    // InOrder Traversal - Left:rootNode:Right (LnR)
    private void inOrder(Node node, List<Integer> list) {
        if (node == null) return;
        //first traverse left subtree recursively
        inOrder(node.left, list);

        list.add(node.key);

        //next traverse right subtree recursively
        inOrder(node.right, list);
    }

    public void preOrder_traversal(List<Integer> list) {
        preOrder(root);
    }

    //PreOrder Traversal - rootNode:Left:Right (nLR)
    private void preOrder(Node node) {

    }
}
