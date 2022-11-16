package gp.project.utils;

import gp.project.nodes.Node;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import java.awt.*;

public class MyTreeCellRenderer extends DefaultTreeCellRenderer {
    @Override
    public Component getTreeCellRendererComponent(JTree tree, Object value,
                                                  boolean isSelected, boolean expanded, boolean leaf, int row,
                                                  boolean hasFocus) {

        JComponent c = (JComponent) super.getTreeCellRendererComponent(tree, value, isSelected, expanded, leaf, row, hasFocus);
//        DefaultMutableTreeNode node = (DefaultMutableTreeNode) value;
        Node data = (Node)((DefaultMutableTreeNode)value).getUserObject();
        if(data.isMutated()){
            c.setForeground(Color.blue);
        }

        return c;
    }
}