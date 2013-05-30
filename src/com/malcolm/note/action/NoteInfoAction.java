package com.malcolm.note.action;

import com.malcolm.note.dao.NoteInfoDao;
import com.malcolm.note.domain.NoteInfo;
import com.malcolm.note.ui.NoteTableConfig;
import com.malcolm.note.util.DictEnum;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class NoteInfoAction {
    private static final Logger log = Logger.getLogger(NoteInfoAction.class);

    private static final NoteInfoDao dao = new NoteInfoDao();

    /**
     * 获取未完成的便签信息
     *
     * @return
     */
    public static Object[][] getAllNotFinishedNoteTableData() {
        Object[][] data = null;
        try {
            List<NoteInfo> list = dao.getAllNoteInfo(new String[]{DictEnum.NoteState.DELAY, DictEnum.NoteState.HUNGUP,DictEnum.NoteState.INACTIVE,DictEnum.NoteState.PROCESSING});
            if (list != null && list.size() > 0) {
                data = List2TableData(list);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }

    /**
     * 获取已完成的便签信息
     *
     * @return
     */
    public static Object[][] getAllFinishedNoteTableData() {
        Object[][] data = null;
        try {
            List<NoteInfo> list = dao.getAllNoteInfo(new String[]{DictEnum.NoteState.FINISHED, DictEnum.NoteState.DISCARD});
            if (list != null && list.size() > 0) {
                data = List2TableData(list);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }

    /**
     * 根据条件查询便签信息
     *
     * @param noteName
     * @param noteComment
     * @param deadLineDateStart
     * @param deadLineDateEnd
     * @param priority
     * @param noteState
     * @return
     */
    public static Object[][] getAllNoteTableData(String noteName, String noteComment, Date deadLineDateStart, Date deadLineDateEnd, String priority, String noteState) {
        Object[][] data = null;
        try {
            List<NoteInfo> list = dao.getAllNoteInfo(noteName, noteComment, deadLineDateStart, deadLineDateEnd, priority, noteState);
            if (list != null && list.size() > 0) {
                data = List2TableData(list);
            }
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return data;
    }

    private static Object[][] List2TableData(List<NoteInfo> list) {
        Object[][] data = new String[list.size()][NoteTableConfig.tableColumnNames.length];
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
        return data;
    }

    /**
     * 保存或新增便签信息
     *
     * @param noteInfo
     */
    public static void saveOrUpdateNoteInfo(NoteInfo noteInfo) {
        try {
            dao.saveOrUpdateNoteInfo(noteInfo);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }

    /**
     * 根据主键获取便签信息
     *
     * @param pkId
     * @return
     */
    public static NoteInfo getNoteInfoById(String pkId) {
        NoteInfo noteInfo = null;
        try {
            noteInfo = dao.getNoteInfoById(pkId);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
        return noteInfo;
    }

    /**
     * 根据主键集合删除便签信息
     *
     * @param list
     * @return
     */
    public static void deleteNoteInfoById(ArrayList<String> list) {
        try {
            dao.deleteNoteInfoById(list);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }

    /**
     * 根据主键集合完成便签信息
     *
     * @param list
     * @return
     */
    public static void finishNoteInfoById(ArrayList<String> list) {
        try {
            dao.finishNoteInfoById(list);
        } catch (Exception ex) {
            log.error("error:", ex);
        }
    }
}
