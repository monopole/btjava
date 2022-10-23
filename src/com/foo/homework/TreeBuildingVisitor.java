package com.foo.homework;

public class TreeBuildingVisitor implements NodeVisitor {
    private final BST tree = new BST();

    @Override
    public void visit(Node n) {
        tree.insert(n.key);
    }

    public BST getTree() {
        return tree;
    }
}
