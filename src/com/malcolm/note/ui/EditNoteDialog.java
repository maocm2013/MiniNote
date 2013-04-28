/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malcolm.note.ui;

import com.malcolm.note.action.NoteInfoAction;
import com.malcolm.note.domain.NoteInfo;
import com.malcolm.note.util.ComboxValue;
import com.malcolm.note.util.DictEnum;
import org.apache.commons.lang3.time.DateFormatUtils;
import com.malcolm.note.util.UITools;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author user
 */
public class EditNoteDialog extends javax.swing.JDialog {

    /**
     * Creates new form EditNoteDialog
     */
    public EditNoteDialog(java.awt.Frame parent, boolean modal,NoteInfo noteInfo) {
        super(parent, modal);
        this.noteInfo = noteInfo;
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

        jXTitledSeparator1 = new org.jdesktop.swingx.JXTitledSeparator();
        jXLabel1 = new org.jdesktop.swingx.JXLabel();
        fd_noteName = new org.jdesktop.swingx.JXTextField();
        jXLabel2 = new org.jdesktop.swingx.JXLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        fd_noteComment = new org.jdesktop.swingx.JXTextArea();
        jXLabel3 = new org.jdesktop.swingx.JXLabel();
        fd_deadLineDate = new org.jdesktop.swingx.JXDatePicker();
        jXLabel4 = new org.jdesktop.swingx.JXLabel();
        fd_priority = new org.jdesktop.swingx.JXComboBox();
        jXLabel5 = new org.jdesktop.swingx.JXLabel();
        fd_noteState = new org.jdesktop.swingx.JXComboBox();
        jXButton1 = new org.jdesktop.swingx.JXButton();
        jXButton2 = new org.jdesktop.swingx.JXButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jXTitledSeparator1.setFont(new java.awt.Font("黑体", 0, 14)); // NOI18N
        jXTitledSeparator1.setTitle("编辑便签");

        jXLabel1.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel1.setText("标题：");
        jXLabel1.setTextAlignment(org.jdesktop.swingx.JXLabel.TextAlignment.CENTER);

        if(noteInfo != null){
            fd_noteName.setText(noteInfo.getNoteName());
        }

        jXLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel2.setText("备注：");

        if(noteInfo != null){
            fd_noteComment.setText(noteInfo.getNoteComment());
        }
        fd_noteComment.setColumns(20);
        fd_noteComment.setRows(5);
        jScrollPane1.setViewportView(fd_noteComment);

        jXLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel3.setText("到达日期：");

        fd_deadLineDate.setFormats("yyyyMMdd");
        try{
            if(noteInfo != null){
                SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
                fd_deadLineDate.setDate(format.parse(noteInfo.getDeadLineDate()));
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        jXLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel4.setText("优先级：");

        fd_priority.setModel(UITools.getComboxValue(DictEnum.NotePriority.dataMap));
        if(noteInfo != null){
            fd_priority.getModel().setSelectedItem(new ComboxValue(String.valueOf(DictEnum.NotePriority.dataMap.get(noteInfo.getPriority())),noteInfo.getPriority()));
        }

        jXLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jXLabel5.setText("状态：");

        fd_noteState.setModel(UITools.getComboxValue(DictEnum.NoteState.dataMap));
        if(noteInfo != null){
            fd_noteState.getModel().setSelectedItem(new ComboxValue(String.valueOf(DictEnum.NoteState.dataMap.get(noteInfo.getNoteState())),noteInfo.getNoteState()));
        }

        jXButton1.setText("保   存");
        jXButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jXButton1ActionPerformed(evt);
            }
        });

        jXButton2.setText("取  消");
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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(fd_noteName, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fd_deadLineDate, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fd_priority, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(fd_noteState, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jXButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jXTitledSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fd_noteName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jXLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fd_deadLineDate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fd_priority, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fd_noteState, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jXButton1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jXButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jXButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton2ActionPerformed
        this.dispose();
    }//GEN-LAST:event_jXButton2ActionPerformed

    private void jXButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jXButton1ActionPerformed
        NoteInfo note = new NoteInfo();
        if(StringUtils.isEmpty(fd_noteName.getText())){
            JOptionPane.showMessageDialog(this, "名称不能为空！");
            //获取焦点
            fd_noteName.requestFocus();
            return;
        }else{
            note.setNoteName(fd_noteName.getText().trim());
        }
        
        if(StringUtils.isEmpty(fd_noteComment.getText())){
            JOptionPane.showMessageDialog(this, "备注不能为空！");
            //获取焦点
            fd_noteComment.requestFocus();
            return;
        }else{
            note.setNoteComment(fd_noteComment.getText().trim());
        }
        
        if(fd_deadLineDate.getDate() == null){
            JOptionPane.showMessageDialog(this, "到达日期不能为空！");
            //获取焦点
            fd_deadLineDate.requestFocus();
            return;
        }else{
            note.setDeadLineDate(DateFormatUtils.format(fd_deadLineDate.getDate(), "yyyyMMdd"));
        }
        
        ComboxValue cm_priority = (ComboxValue)fd_priority.getSelectedItem();
        note.setPriority(cm_priority.getValue());
        ComboxValue cm_noteState = (ComboxValue)fd_noteState.getSelectedItem();
        note.setNoteState(cm_noteState.getValue());
        
        //如果具备便签信息则是修改操作
        if(noteInfo != null){
            note.setPkId(noteInfo.getPkId());
        }
        //JOptionPane.showMessageDialog(null, note.toString());
        NoteInfoAction.saveOrUpdateNoteInfo(note);
        JOptionPane.showMessageDialog(this, "保存成功！");
        this.dispose();
        
        //刷新父界面中的表单数据
        MiniNoteFrame frame = (MiniNoteFrame)this.getParent();
        frame.refreshNoteTableDatas();
    }//GEN-LAST:event_jXButton1ActionPerformed

    private NoteInfo noteInfo;
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private org.jdesktop.swingx.JXDatePicker fd_deadLineDate;
    private org.jdesktop.swingx.JXTextArea fd_noteComment;
    private org.jdesktop.swingx.JXTextField fd_noteName;
    private org.jdesktop.swingx.JXComboBox fd_noteState;
    private org.jdesktop.swingx.JXComboBox fd_priority;
    private javax.swing.JScrollPane jScrollPane1;
    private org.jdesktop.swingx.JXButton jXButton1;
    private org.jdesktop.swingx.JXButton jXButton2;
    private org.jdesktop.swingx.JXLabel jXLabel1;
    private org.jdesktop.swingx.JXLabel jXLabel2;
    private org.jdesktop.swingx.JXLabel jXLabel3;
    private org.jdesktop.swingx.JXLabel jXLabel4;
    private org.jdesktop.swingx.JXLabel jXLabel5;
    private org.jdesktop.swingx.JXTitledSeparator jXTitledSeparator1;
    // End of variables declaration//GEN-END:variables
}
