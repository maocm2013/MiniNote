package com.malcolm.note.ui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author user
 */
public class NoteTableConfig {

    public static final String[] tableColumnNames = new String[]{
        "选择", "主键", "序号", "名称", "备注", "截止日期", "优先级", "状态"
    };

    public class NoteTableModel extends BaseTableModel {

        public NoteTableModel() {
            super(tableColumnNames);
            //设置第1列可编辑，保证复选框可以选择
            this.setCheckColumn(0);
        }
        Class[] types = new Class[]{
            java.lang.Boolean.class,
            java.lang.String.class,
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

    /**
     * 优先级字段显示渲染器
     */
    public class PriorityCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String _value = "";
            if (value != null) {
                _value = String.valueOf(value);
            }

            /*使用图片显示方式*/
            if (_value.equals("低")) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/LOW.png")));
            } else if (_value.equals("中")) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/MIDDLE.png")));
            } else if (_value.equals("高")) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/HIGH.png")));
            } else if (_value.equals("加急")) {
                this.setIcon(new ImageIcon(this.getClass().getResource("/URGENT.png")));
            }

            //设置背景色
            if (isSelected) {
                this.setBackground(table.getSelectionBackground());
            } else {
                this.setBackground(Color.white);
            }
            return this;
        }
    }
}
