package com.foo.homework;

import java.util.ArrayList;
import java.util.List;

public class KeyAppendingVisitor implements NodeVisitor {
    private final List<Integer> list = new ArrayList<>();

    @Override
    public void visit(Node n) {
        list.add(n.key);
    }

    public void reset() {
        list.clear();
    }

    public String asString() {
        StringBuilder b = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            b.append(list.get(i));
            if (i < list.size() - 1) {
                b.append(" ");
            }
        }
        return b.toString();
    }
}
