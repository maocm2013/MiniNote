/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malcolm.note.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.UUID;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import javax.swing.table.TableColumn;

/**
 *
 * @author user
 */
public class UITools {
    /**
     * 生成32位UUID
     * @return 
     */
    public static String generateUUID(){
        return UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
    }

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
    
    /**
     * 根据数据字典生成ComboxModel
     * @param dataMap
     * @return 
     */
    public static DefaultComboBoxModel getComboxValue(Map dataMap){
        Set set = dataMap.entrySet();
        ComboxValue[] values = new ComboxValue[set.size()];
        Iterator it = set.iterator();
        int i = 0;
        while(it.hasNext()){
            Entry entry = (Entry)it.next();
            ComboxValue value = new ComboxValue();
            value.setName(entry.getValue().toString());
            value.setValue(entry.getKey().toString());
            values[i] = value;
            i++;
        }
        return new DefaultComboBoxModel(values);
    }
}
