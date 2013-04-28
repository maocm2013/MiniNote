package com.malcolm.note.ui;

import com.malcolm.note.action.NoteInfoAction;
import com.malcolm.note.domain.NoteInfo;
import com.malcolm.note.util.UITools;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.TableColumnModel;

/**
 *
 * @author user
 */
public class MiniNoteFrame extends javax.swing.JFrame {

    /**
     * Creates new form MiniNoteFrame
     */
    public MiniNoteFrame() {
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

        toolBar = new javax.swing.JToolBar();
        addBton = new javax.swing.JButton();
        delBton = new javax.swing.JButton();
        editBton = new javax.swing.JButton();
        finishBton = new javax.swing.JButton();
        searchBton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        NoteTableModel model = new NoteTableModel();
        //初始化显示数据
        Object[][] datas = NoteInfoAction.getAllNoteTableData();
        model.refreshContents(datas);
        noteTable = new org.jdesktop.swingx.JXTable(model);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("桌面便签");
        setPreferredSize(new java.awt.Dimension(640, 480));
        setResizable(false);

        toolBar.setFloatable(false);
        toolBar.setRollover(true);

        addBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/add.png"))); // NOI18N
        addBton.setToolTipText("添加");
        addBton.setFocusable(false);
        addBton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        addBton.setPreferredSize(new java.awt.Dimension(83, 60));
        addBton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        addBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtonActionPerformed(evt);
            }
        });
        toolBar.add(addBton);

        delBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/delete.png"))); // NOI18N
        delBton.setToolTipText("删除");
        delBton.setFocusable(false);
        delBton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        delBton.setPreferredSize(new java.awt.Dimension(83, 60));
        delBton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        delBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                delBtonActionPerformed(evt);
            }
        });
        toolBar.add(delBton);

        editBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/edit.png"))); // NOI18N
        editBton.setToolTipText("修改");
        editBton.setFocusable(false);
        editBton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        editBton.setPreferredSize(new java.awt.Dimension(83, 60));
        editBton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        editBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                editBtonActionPerformed(evt);
            }
        });
        toolBar.add(editBton);

        finishBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/finish.png"))); // NOI18N
        finishBton.setToolTipText("完成");
        finishBton.setFocusable(false);
        finishBton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        finishBton.setPreferredSize(new java.awt.Dimension(83, 60));
        finishBton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        finishBton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finishBtonActionPerformed(evt);
            }
        });
        toolBar.add(finishBton);

        searchBton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/search.png"))); // NOI18N
        searchBton.setToolTipText("搜索");
        searchBton.setFocusable(false);
        searchBton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        searchBton.setPreferredSize(new java.awt.Dimension(83, 60));
        searchBton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        toolBar.add(searchBton);

        //隐藏第一列（主键）
        UITools.hideColumn(noteTable, 1);
        //设置列宽
        TableColumnModel cm = noteTable.getColumnModel();
        cm.getColumn(0).setMaxWidth(40);
        cm.getColumn(2).setMaxWidth(40);
        cm.getColumn(5).setMaxWidth(80);
        cm.getColumn(6).setMaxWidth(50);
        cm.getColumn(7).setMaxWidth(50);
        noteTable.setRowHeight(30);
        jScrollPane2.setViewportView(noteTable);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(toolBar, javax.swing.GroupLayout.DEFAULT_SIZE, 825, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 635, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(toolBar, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 604, Short.MAX_VALUE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtonActionPerformed
        EditNoteDialog dialog = new EditNoteDialog(this, true, null);
        dialog.setVisible(true);
    }//GEN-LAST:event_addBtonActionPerformed

    private void editBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_editBtonActionPerformed
        if (UITools.getCheckedRows(noteTable) != 1) {
            JOptionPane.showMessageDialog(rootPane, "请确认您选择了一条记录！");
        } else {
            ArrayList<String> list = UITools.getCheckedRowsId(noteTable);
            String pkId = list.get(0);
            //JOptionPane.showMessageDialog(rootPane, "便签主键=" + pkId);
            NoteInfo noteInfo = NoteInfoAction.getNoteInfoById(pkId);
            //JOptionPane.showMessageDialog(rootPane, "便签信息=" + JSON.toJSONString(noteInfo));
            EditNoteDialog dialog = new EditNoteDialog(this, true, noteInfo);
            dialog.setVisible(true);
        }
    }//GEN-LAST:event_editBtonActionPerformed

    private void delBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_delBtonActionPerformed
        if (UITools.getCheckedRows(noteTable) == 0) {
            JOptionPane.showMessageDialog(rootPane, "您至少需要选择一条记录！");
        } else {
            if (JOptionPane.showConfirmDialog(rootPane, "请确认您是否要删除数据？") == JOptionPane.YES_OPTION) {
                ArrayList<String> list = UITools.getCheckedRowsId(noteTable);
                NoteInfoAction.deleteNoteInfoById(list);
                JOptionPane.showMessageDialog(rootPane, list.size() + "条记录删除成功！");
                refreshNoteTableDatas();
            }
        }
    }//GEN-LAST:event_delBtonActionPerformed

    private void finishBtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finishBtonActionPerformed
        if (UITools.getCheckedRows(noteTable) == 0) {
            JOptionPane.showMessageDialog(rootPane, "您至少需要选择一条记录！");
        } else {
            if (JOptionPane.showConfirmDialog(rootPane, "请确认您是否要强制完成所选记录？") == JOptionPane.YES_OPTION) {
                ArrayList<String> list = UITools.getCheckedRowsId(noteTable);
                NoteInfoAction.finishNoteInfoById(list);
                JOptionPane.showMessageDialog(rootPane, list.size() + "条记录强制完成成功！");
                refreshNoteTableDatas();
            }
        }
    }//GEN-LAST:event_finishBtonActionPerformed

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
            java.util.logging.Logger.getLogger(MiniNoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MiniNoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MiniNoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MiniNoteFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MiniNoteFrame().setVisible(true);
            }
        });
    }

    /**
     * 刷新表单数据
     */
    public void refreshNoteTableDatas() {
        NoteTableModel model = (NoteTableModel) noteTable.getModel();
        model.refreshContents(NoteInfoAction.getAllNoteTableData());
        //TODO:必须要重新设置一下model，否则刷新内容后界面无变化
        noteTable.setModel(model);
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBton;
    private javax.swing.JButton delBton;
    private javax.swing.JButton editBton;
    private javax.swing.JButton finishBton;
    private javax.swing.JScrollPane jScrollPane2;
    private org.jdesktop.swingx.JXTable noteTable;
    private javax.swing.JButton searchBton;
    private javax.swing.JToolBar toolBar;
    // End of variables declaration//GEN-END:variables
}
