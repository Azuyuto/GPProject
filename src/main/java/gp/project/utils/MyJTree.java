package gp.project.utils;

import gp.project.Tree;
import gp.project.nodes.Node;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import java.awt.*;
import java.util.ArrayList;

public class MyJTree {
    JFrame f;
    MyJTree(ArrayList<Tree> trees)
    {
        f=new JFrame();
        DefaultMutableTreeNode myPrograms = new DefaultMutableTreeNode("My Programs");
        trees.forEach(tree -> {
            myPrograms.add(GenerateTreeNode(tree));
        });
        JTree jt=new JTree(myPrograms);
        final Font currentFont = jt.getFont();
        final Font bigFont = new Font(currentFont.getName(), currentFont.getStyle(), currentFont.getSize() + 12);
        jt.setFont(bigFont);
        f.add(jt);
        f.setSize(600, 600);
        f.setVisible(true);
    }

    public DefaultMutableTreeNode GenerateTreeNode(Tree tree)
    {
        return GenerateInit(tree.getRoot());
    }

    public DefaultMutableTreeNode GenerateInit(Node node)
    {
        DefaultMutableTreeNode treeNode = new DefaultMutableTreeNode(node.getLogName());
        node.getChildren().forEach(childNode -> {
            treeNode.add(GenerateInit(childNode));
        });
        return treeNode;
    }

    public static void ShowTree(ArrayList<Tree> tree)
    {
        new MyJTree(tree);
    }
}