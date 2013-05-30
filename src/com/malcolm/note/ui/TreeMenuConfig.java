/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malcolm.note.ui;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author user
 */
public class TreeMenuConfig {
    /**
     * 菜单名称定义
     */
    public static class MenuName{
        /**
         * M_00_01-未完成
         */
        public static final String M_00_01 = "未完成";
        
        /**
         * M_00_02-已完成
         */
        public static final String M_00_02 = "已完成";
    }
    
    /**
     * 生成菜单模型
     * @return 
     */
    public static DefaultTreeModel generateTreeMenu(){
        DefaultMutableTreeNode root = new DefaultMutableTreeNode("菜单");
        DefaultTreeModel tm = new DefaultTreeModel(root);
        
        DefaultMutableTreeNode m_00_01 = new DefaultMutableTreeNode(MenuName.M_00_01);
        DefaultMutableTreeNode m_00_02 = new DefaultMutableTreeNode(MenuName.M_00_02);
        
        root.add(m_00_01);
        root.add(m_00_02);
        return tm;
    }
}
