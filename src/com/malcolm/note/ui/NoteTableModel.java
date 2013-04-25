package com.malcolm.note.ui;

/**
 *
 * @author user
 */
public class NoteTableModel extends BaseTableModel {
    public static final String[] columnNames = new String [] {
        "选择", "序号", "名称", "备注", "截止日期", "优先级", "状态"
    };
    
    public NoteTableModel(){
        super(columnNames);
    }

    Class[] types = new Class[]{
        java.lang.Boolean.class, 
        java.lang.String.class, 
        java.lang.String.class, 
        java.lang.String.class, 
        java.lang.String.class, 
        java.lang.String.class, 
        java.lang.String.class
    };

    @Override
    public Class getColumnClass(int columnIndex) {
        return types[columnIndex];
    }
}
