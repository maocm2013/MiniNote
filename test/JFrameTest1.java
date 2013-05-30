
import com.alibaba.fastjson.JSON;
import com.malcolm.note.action.NoteInfoAction;
import com.malcolm.note.ui.NoteTableConfig;
import com.malcolm.note.ui.NoteTableConfig.NoteTableModel;
import com.malcolm.note.util.ComboxValue;
import com.malcolm.note.util.DictEnum;
import com.malcolm.note.util.UITools;
import java.awt.Color;
import java.awt.Component;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumn;
import org.jdesktop.swingx.JXTable;
import org.jdesktop.swingx.renderer.DefaultTableRenderer;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author user
 */
public class JFrameTest1 extends javax.swing.JFrame {

    /**
     * Creates new form JFrameTest1
     */
    public JFrameTest1() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        jXTable2 = new org.jdesktop.swingx.JXTable();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        jXComboBox1 = new org.jdesktop.swingx.JXComboBox();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        jXButton2 = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        NoteTableConfig.NoteTableModel model1 = new NoteTableConfig().new NoteTableModel();
        //初始化显示数据
        Object[][] datas1 = NoteInfoAction.getAllNotFinishedNoteTableData();
        model1.refreshContents(datas1);
        jXTable1.setModel(model1);
        //第一列隐藏
        UITools.hideColumn(jXTable1, 1);
        jScrollPane2.setViewportView(jXTable1);

        jXTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, "高", null, "w"},
                {null, "中", null, "f"},
                {null, "低", null, null},
                {null, "加急", null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class
            };
            boolean[] canEdit = new boolean [] {
                false, true, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        //第二列进行渲染
        TableColumn bColumn = jXTable2.getColumnModel().getColumn(1);
        bColumn.setCellRenderer(new MyTableCellRenderer());
        //jXTable2.setDefaultRenderer(Object.class, new MyTableCellRenderer());

        //将第三列也显示复选框
        TableColumn aColumn = jXTable2.getColumnModel().getColumn(2);
        aColumn.setCellEditor(new JXTable.BooleanEditor());
        aColumn.setCellRenderer(new DefaultTableRenderer());
        jScrollPane3.setViewportView(jXTable2);

        jXButton1.setText("CHECK TEST");
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });

        jXComboBox1.setModel(UITools.getComboxValue(DictEnum.NotePriority.dataMap,false));

        jXLabel1.setText("下拉列表：");

        jXButton2.setText("改变选择项");
        jXButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE)
                    .addComponent(jScrollPane3))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jXButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jXComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 119, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(105, 105, 105))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jXButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jXComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(164, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed
        JOptionPane.showMessageDialog(rootPane, "选中行数=" + UITools.getCheckedRows(jXTable1));
        JOptionPane.showMessageDialog(rootPane, "选中记录主键=" + JSON.toJSONString(UITools.getCheckedRowsId(jXTable1)));
    }//GEN-LAST:event_jXButton1ActionPerformed

    private void jXButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton2ActionPerformed
        jXComboBox1.getModel().setSelectedItem(new ComboxValue("高", "H"));
        //jXComboBox1.updateUI();
    }//GEN-LAST:event_jXButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(JFrameTest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrameTest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrameTest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrameTest1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrameTest1().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXButton jXButton2;
    private org.jdesktop.swingx.JXComboBox jXComboBox1;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXTable jXTable1;
    private org.jdesktop.swingx.JXTable jXTable2;
    // End of variables declaration//GEN-END:variables

    class MyTableCellRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            String _value = "";
            if (value != null) {
                _value = String.valueOf(value);
            }

            /*设置字体设置方式*/
//            this.setText(String.valueOf(_value));
//
//            //设置字体
//            HashMap attr = new HashMap();
//            if (_value.equals("低")) {
//                attr.put(TextAttribute.FAMILY, "黑体");
//                attr.put(TextAttribute.SIZE, 14);
//                attr.put(TextAttribute.FOREGROUND, Color.red);
//
//            } else {
//                attr.put(TextAttribute.FAMILY, "黑体");
//                attr.put(TextAttribute.SIZE, 14);
//                attr.put(TextAttribute.FOREGROUND, Color.BLUE);
//            }
//            Font font = new Font(attr);
//            this.setFont(font);

            //针对第二列进行图片显示渲染
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
