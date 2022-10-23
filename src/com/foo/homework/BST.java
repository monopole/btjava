package com.foo.homework;

public class BST {
    //node class that defines src.homework.BST node
    // src.homework.BST root node
    Node root;

    // Constructor for src.homework.BST =>initial empty tree
    BST(){
        root = null;
    }
    //delete a node from src.homework.BST
    void deleteKey(int key) {

    }

    int minValue(Node root)  {
        return 0;
    }

    // insert a node in src.homework.BST
    void insert(int key)  {
        root = insert_Recursive(root, key);
    }

    //recursive insert function
    Node insert_Recursive(Node root, int key) {
        //tree is empty
        if (root == null) {
            root = new Node(key);
            return root;
        }
        //traverse the tree
        if (key < root.key)     //insert in the left subtree
            root.left = insert_Recursive(root.left, key);
        else if (key > root.key)    //insert in the right subtree
            root.right = insert_Recursive(root.right, key);
        // return pointer
        return root;
    }

    boolean search(int key)  {
        return false;
    }

    //PostOrder Traversal - Left:Right:rootNode (LRn)
    void postOrder(Node node)  {

    }
    // InOrder Traversal - Left:rootNode:Right (LnR)
    void inOrder(Node node)  {
        if (node == null)
            return;
        //first traverse left subtree recursively
        inOrder(node.left);

        //then go for root node
        System.out.print(node.key + " ");

        //next traverse right subtree recursively
        inOrder(node.right);
    }
    //PreOrder Traversal - rootNode:Left:Right (nLR)
    void preOrder(Node node)  {

    }

    // Wrappers for recursive functions
    void postOrder_traversal()  {
        postOrder(root);  }
    void inOrder_traversal() {
        inOrder(root);   }
    void preOrder_traversal() {
        preOrder(root);  }
}
