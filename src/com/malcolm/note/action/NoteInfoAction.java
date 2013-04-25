package com.malcolm.note.action;

import com.malcolm.note.dao.NoteInfoDao;
import com.malcolm.note.domain.NoteInfo;
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
    public static String[][] getAllNoteTableData(){
        NoteInfoDao dao = new NoteInfoDao();
        String[][] data = null;
        try {
            List<NoteInfo> list = dao.getAllNoteInfo();
            if(list != null && list.size() > 0){
                data = new String[list.size() + 1][7];
                for(int i = 0; i < list.size(); i++){
                    int seq = 0;
                    NoteInfo note = list.get(i);
                    data[i][seq++] = "";
                    data[i][seq++] = String.valueOf(i + 1);
                    data[i][seq++] = note.getNoteName();
                    data[i][seq++] = note.getNoteComment();
                    data[i][seq++] = note.getDeadLineDate();
                    data[i][seq++] = note.getPriority();
                    data[i][seq++] = note.getNoteState();
                }    
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } 
        return data;
    }
}
