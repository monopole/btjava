package com.foo.homework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BstTest {
    @Test
    public void testInOrder() {
        BST tree = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        KeyAppendingVisitor v = new KeyAppendingVisitor();
        tree.inOrder_traversal(v);
        Assertions.assertEquals("7 10 12 45 50 90", v.asString());
    }

    @Test
    public void testPreOrder() {
        BST tree = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        KeyAppendingVisitor v = new KeyAppendingVisitor();
        tree.preOrder_traversal(v);
        Assertions.assertEquals("45 10 7 12 90 50", v.asString());
    }

    @Test
    public void testPostOrder() {
        BST tree = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        KeyAppendingVisitor v = new KeyAppendingVisitor();
        tree.postOrder_traversal(v);
        Assertions.assertEquals("7 12 10 50 90 45", v.asString());
    }

    @Test
    public void testDeleteLeafNodes() {
        BST tree = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        KeyAppendingVisitor v = new KeyAppendingVisitor();
        tree.inOrder_traversal(v);
        Assertions.assertEquals("7 10 12 45 50 90", v.asString());
        tree.deleteKey(12);
        v.reset();
        tree.inOrder_traversal(v);
        Assertions.assertEquals("7 10 45 50 90", v.asString());
        tree.deleteKey(90);
        v.reset();
        tree.inOrder_traversal(v);
        Assertions.assertEquals("7 10 45 50", v.asString());
    }

    @Test
    public void testDeleteNodeWithTwoChildren() {
        BST tree = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        KeyAppendingVisitor v = new KeyAppendingVisitor();
        tree.inOrder_traversal(v);
        Assertions.assertEquals("7 10 12 45 50 90", v.asString());
        tree.deleteKey(45);
        v.reset();
        tree.inOrder_traversal(v);
        Assertions.assertEquals("7 10 12 50 90", v.asString());
    }

    @Test
    public void testSearch() {
        BST tree = BST.makeFromArray(new int[]{45, 10, 7, 12, 90, 50});
        Assertions.assertFalse(tree.search(1));
        Assertions.assertTrue(tree.search(50));
        Assertions.assertTrue(tree.search(12));
        Assertions.assertFalse(tree.search(9999));
    }

    @Test
    public void testExampleTree() {
        BST tree = BST.makeExample();
        KeyAppendingVisitor v = new KeyAppendingVisitor();
        tree.preOrder_traversal(v);
        Assertions.assertEquals("45 10 7 12 90", v.asString());
        v.reset();
        tree.inOrder_traversal(v);
        Assertions.assertEquals("7 10 12 45 90", v.asString());
        v.reset();
        tree.postOrder_traversal(v);
        Assertions.assertEquals("7 12 10 90 45", v.asString());
    }
}
