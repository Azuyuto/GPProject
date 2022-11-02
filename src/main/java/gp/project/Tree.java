package gp.project;

import java.util.ArrayList;
import java.util.List;

public class Tree {
    String data = null;
    Tree left = null;
    Tree right = null;

    Tree(String data) {this.data = data;}

    public void print() {
        print("", this, false);
    }

    public void print(String prefix, Tree n, boolean isLeft) {
        if (n != null) {
            System.out.println (prefix + (isLeft ? "|-- " : "\\-- ") + n.data);
            print(prefix + (isLeft ? "|   " : "    "), n.left, true);
            print(prefix + (isLeft ? "|   " : "    "), n.right, false);
        }
    }
}