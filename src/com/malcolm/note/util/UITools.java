/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malcolm.note.util;

import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author user
 */
public class UITools {

    /**
     * 隐藏table中的某一列
     * @param jtable
     * @param columnIndex 
     */
    public static void hideColumn(JTable jtable, int columnIndex) {
        TableColumn tc = jtable.getColumnModel().getColumn(columnIndex);
        tc.setWidth(0);
        tc.setMinWidth(0);
        tc.setMaxWidth(0);
        tc.setPreferredWidth(0);
        jtable.getTableHeader().getColumnModel().getColumn(columnIndex).setMaxWidth(0);
        jtable.getTableHeader().getColumnModel().getColumn(columnIndex).setMinWidth(0);
    }
}
