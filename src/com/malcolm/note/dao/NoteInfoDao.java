/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.malcolm.note.dao;

import com.malcolm.note.domain.NoteInfo;
import com.malcolm.note.util.JdbcUtil;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author user
 */
public class NoteInfoDao {
    /**
     * 
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException 
     */
    public List getAllNoteInfo() throws SQLException, ClassNotFoundException{
        Connection conn = null;
        QueryRunner queryRunner = null;
        List<NoteInfo> list = null;
        String sql = "select pk_id pkId,note_name noteName,note_comment noteComment,dead_line_date deadLineDate,priority priority,note_state noteState from note_info";
        try{
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            list = (List<NoteInfo>)queryRunner.query(conn, sql, new BeanListHandler(NoteInfo.class));
        }finally{
            DbUtils.close(conn);
        }
        return list;
    }
}
