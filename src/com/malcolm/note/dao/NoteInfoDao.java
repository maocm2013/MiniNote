/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malcolm.note.dao;

import com.malcolm.note.domain.NoteInfo;
import com.malcolm.note.util.JdbcUtil;
import com.malcolm.note.util.UITools;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author user
 */
public class NoteInfoDao {

    /**
     * 获取所有便签信息
     * @return @throws SQLException
     * @throws ClassNotFoundException
     */
    public List getAllNoteInfo() throws SQLException, ClassNotFoundException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        List<NoteInfo> list = null;
        String sql = "select pk_id pkId,note_name noteName,note_comment noteComment,dead_line_date deadLineDate,priority priority,note_state noteState from note_info";
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            list = (List<NoteInfo>) queryRunner.query(conn, sql, new BeanListHandler(NoteInfo.class));
        } finally {
            DbUtils.close(conn);
        }
        return list;
    }

    /**
     * 保存或更新便签信息（根据PK_ID是否为空来判断）
     * @param noteInfo
     * @throws ClassNotFoundException
     * @throws SQLException 
     */
    public void saveOrUpdateNoteInfo(NoteInfo noteInfo) throws ClassNotFoundException, SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        String sql_insert = "insert into note_info(pk_id,note_name,note_comment,dead_line_date,priority,note_state)values(?,?,?,?,?,?)";
        String sql_update = "update note_info set note_name=?,note_comment=?,dead_line_date=?,priority=?,note_state=? where pk_id=?";
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            Object[] params = new Object[6];
            int seq = 0;
            if(StringUtils.isNotEmpty(noteInfo.getPkId())){
                params[seq++] = noteInfo.getPkId();
            }else{
                params[seq++] = UITools.generateUUID();
            }
            params[seq++] = noteInfo.getNoteName();
            params[seq++] = noteInfo.getNoteComment();
            params[seq++] = noteInfo.getDeadLineDate();
            params[seq++] = noteInfo.getPriority();
            params[seq++] = noteInfo.getNoteState();
            if(StringUtils.isNotEmpty(noteInfo.getPkId())){
                queryRunner.update(conn, sql_update, params);
            }else{
                queryRunner.update(conn, sql_insert, params);
            }
        } finally {
            DbUtils.close(conn);
        }
    }
}
