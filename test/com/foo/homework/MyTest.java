package com.foo.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class MyTest {
    private String asString(List<Integer> l) {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < l.size(); i++) {
            b.append(l.get(i));
            if (i < l.size() - 1) {
                b.append(" ");
            }
        }
        return b.toString();
    }

    @Test
    public void testAsString() {
        List<Integer> l = new ArrayList<>();
        l.add(2);
        l.add(3);
        Assertions.assertEquals("2 3", asString(l));
    }

    private BST makeTree() {
        BST bst = new BST();
        bst.insert(45);
        bst.insert(10);
        bst.insert(7);
        bst.insert(12);
        bst.insert(90);
        bst.insert(50);
        return bst;
    }

    @Test
    public void testInOrder() {
        BST bst = makeTree();
        List<Integer> l = new ArrayList<>();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
    }

    @Test
    public void testPreOrder() {
        BST bst = makeTree();
        List<Integer> l = new ArrayList<>();
        bst.preOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
    }

    @Test
    public void testPostOrder() {
        BST bst = makeTree();
        List<Integer> l = new ArrayList<>();
        bst.postOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
    }

    @Test
    public void testDeleteLeaves() {
        BST bst = makeTree();
        List<Integer> l = new ArrayList<>();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
        bst.deleteKey(12);
        l.clear();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
        bst.deleteKey(90);
        l.clear();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));

    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        BST bst = makeTree();
        List<Integer> l = new ArrayList<>();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
        bst.deleteKey(45);
        l.clear();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
    }

    @Test
    public void testSearch() {
        BST bst = makeTree();
        Assertions.assertTrue(bst.search(50));
        Assertions.assertTrue(bst.search(12));
        Assertions.assertFalse(bst.search(9999));
    }

    @Test
    public void testExampleTree() {
        BST tree = BST.makeExample();
        List<Integer> l = new ArrayList<>();
        tree.preOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
        l.clear();
        tree.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
        l.clear();
        tree.postOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
    }
}
