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

    @Test
    public void testInOrder() {
        BST bst = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        List<Integer> l = new ArrayList<>();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
    }

    @Test
    public void testPreOrder() {
        BST bst = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        List<Integer> l = new ArrayList<>();
        bst.preOrder_traversal(l);
        Assertions.assertEquals("45 10 7 12 90 50", asString(l));
    }

    @Test
    public void testPostOrder() {
        BST bst = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        List<Integer> l = new ArrayList<>();
        bst.postOrder_traversal(l);
        Assertions.assertEquals("7 12 10 50 90 45", asString(l));
    }

    @Test
    public void testDeleteLeafNodes() {
        BST bst = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        List<Integer> l = new ArrayList<>();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
        bst.deleteKey(12);
        l.clear();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 45 50 90", asString(l));
        bst.deleteKey(90);
        l.clear();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 45 50", asString(l));
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        BST bst = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        List<Integer> l = new ArrayList<>();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 50 90", asString(l));
        bst.deleteKey(45);
        l.clear();
        bst.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 50 90", asString(l));
    }

    @Test
    public void testSearch() {
        BST bst = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        Assertions.assertFalse(bst.search(1));
        Assertions.assertTrue(bst.search(50));
        Assertions.assertTrue(bst.search(12));
        Assertions.assertFalse(bst.search(9999));
    }

    @Test
    public void testExampleTree() {
        BST tree = BST.makeExample();
        List<Integer> l = new ArrayList<>();
        tree.preOrder_traversal(l);
        Assertions.assertEquals("45 10 7 12 90", asString(l));
        l.clear();
        tree.inOrder_traversal(l);
        Assertions.assertEquals("7 10 12 45 90", asString(l));
        l.clear();
        tree.postOrder_traversal(l);
        Assertions.assertEquals("7 12 10 90 45", asString(l));
    }
}
