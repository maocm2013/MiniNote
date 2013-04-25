/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malcolm.note.util;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.DefaultComboBoxModel;
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
    
            
    static class ComboxValue{
        private String value;
        private String name;

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
        
    }
}
