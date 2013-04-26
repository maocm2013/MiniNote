package com.malcolm.note.action;

import com.malcolm.note.dao.NoteInfoDao;
import com.malcolm.note.domain.NoteInfo;
import com.malcolm.note.ui.NoteTableModel;
import com.malcolm.note.util.DictEnum;
import java.util.List;

/**
 *
 * @author user
 */
public class NoteInfoAction {

    /**
     *
     * @return
     */
    public static Object[][] getAllNoteTableData() {
        NoteInfoDao dao = new NoteInfoDao();
        Object[][] data = null;
        try {
            List<NoteInfo> list = dao.getAllNoteInfo();
            if (list != null && list.size() > 0) {
                data = new String[list.size()][NoteTableModel.columnNames.length];
                for (int i = 0; i < list.size(); i++) {
                    int seq = 0;
                    NoteInfo note = list.get(i);
                    data[i][seq++] = null;
                    data[i][seq++] = note.getPkId();
                    data[i][seq++] = String.valueOf(i + 1);
                    data[i][seq++] = note.getNoteName();
                    data[i][seq++] = note.getNoteComment();
                    data[i][seq++] = note.getDeadLineDate();
                    data[i][seq++] = String.valueOf(DictEnum.NotePriority.dataMap.get(note.getPriority()));
                    data[i][seq++] = String.valueOf(DictEnum.NoteState.dataMap.get(note.getNoteState()));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return data;
    }

    /**
     * 保存或新增便签信息
     *
     * @param noteInfo
     */
    public static void saveOrUpdateNoteInfo(NoteInfo noteInfo) {
        NoteInfoDao dao = new NoteInfoDao();
        try {
            dao.saveOrUpdateNoteInfo(noteInfo);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * 根据主键获取便签信息
     * @param pkId
     * @return 
     */
    public static NoteInfo getNoteInfoById(String pkId) {
        NoteInfoDao dao = new NoteInfoDao();
        NoteInfo noteInfo = null;
        try {
            noteInfo = dao.getNoteInfoById(pkId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return noteInfo;
    }
}
