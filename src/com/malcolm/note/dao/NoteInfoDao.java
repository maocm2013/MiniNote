package com.malcolm.note.dao;

import com.malcolm.note.domain.NoteInfo;
import com.malcolm.note.util.DictEnum;
import com.malcolm.note.util.JdbcUtil;
import com.malcolm.note.util.UITools;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;
import org.apache.log4j.Logger;

/**
 *
 * @author user
 */
public class NoteInfoDao {

    private static final Logger log = Logger.getLogger(NoteInfoDao.class);

    /**
     * 根据便签状态筛选数据，并且按照到达日期升序、优先级升序排列
     * @param noteStates 如果为NULL则获取所有数据
     * @return
     * @throws SQLException 
     */
    public List getAllNoteInfo(String[] noteStates) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        List<NoteInfo> list = null;
        StringBuffer sb = new StringBuffer("select pk_id pkId,note_name noteName,note_comment noteComment,dead_line_date deadLineDate,priority priority,note_state noteState,remind_time remindTime from note_info where 1=1 ");
        if (noteStates != null && noteStates.length > 0) {
            sb.append("and ( 1<>1 ");
            for (int i = 0; i < noteStates.length; i++) {
                sb.append(" or note_state = ? ");
            }
            sb.append(" ) ");
        }
        sb.append(" order by dead_line_date,priority");

        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            list = (List<NoteInfo>) queryRunner.query(conn, sb.toString(), new BeanListHandler(NoteInfo.class), noteStates);
        } finally {
            DbUtils.close(conn);
        }
        return list;
    }

    /**
     * 根据条件查询便签信息,默认不显示已完成和遗弃的数据，并且按照到达日期升序、优先级升序排列
     *
     * @param noteName
     * @param noteComment
     * @param deadLineDateStart
     * @param deadLineDateEnd
     * @param priority
     * @param noteState
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public List getAllNoteInfo(String noteName, String noteComment, Date deadLineDateStart, Date deadLineDateEnd, String priority, String noteState) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        List<NoteInfo> list = null;
        StringBuilder sb = new StringBuilder("select pk_id pkId,note_name noteName,note_comment noteComment,dead_line_date deadLineDate,priority priority,note_state noteState,remind_time remindTime from note_info where 1=1 ");
        try {
            ArrayList<Object> params = new ArrayList<Object>();
            if (StringUtils.isNotEmpty(noteName)) {
                params.add(noteName.trim());
                sb.append(" and note_name like '%'||?||'%' ");
            }
            if (StringUtils.isNotEmpty(noteComment)) {
                params.add(noteComment.trim());
                sb.append(" and note_comment like '%'||?||'%' ");
            }
            if (deadLineDateStart != null) {
                params.add(DateFormatUtils.format(deadLineDateStart, "yyyyMMdd"));
                sb.append(" and dead_line_date>=? ");
            }
            if (deadLineDateEnd != null) {
                params.add(DateFormatUtils.format(deadLineDateEnd, "yyyyMMdd"));
                sb.append(" and dead_line_date<=? ");
            }
            if (StringUtils.isNotEmpty(priority)) {
                params.add(priority);
                sb.append(" and priority=? ");
            }
            if (StringUtils.isNotEmpty(noteState)) {
                params.add(noteState);
                sb.append(" and note_state=? ");
            }
            sb.append(" order by dead_line_date,priority");
            log.debug("查询sql=" + sb.toString());

            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            list = (List<NoteInfo>) queryRunner.query(conn, sb.toString(), new BeanListHandler(NoteInfo.class), params.toArray());
        } finally {
            DbUtils.close(conn);
        }
        return list;
    }

    /**
     * 根据主键获取便签信息
     *
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public NoteInfo getNoteInfoById(String pkId) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        NoteInfo noteInfo = null;
        String sql = "select pk_id pkId,note_name noteName,note_comment noteComment,dead_line_date deadLineDate,priority priority,note_state noteState,remind_time remindTime from note_info where pk_id=?";
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            noteInfo = (NoteInfo) queryRunner.query(conn, sql, new BeanHandler(NoteInfo.class), pkId);
        } finally {
            DbUtils.close(conn);
        }
        return noteInfo;
    }

    /**
     * 根据主键集合删除多条便签信息
     *
     * @param list
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void deleteNoteInfoById(ArrayList<String> list) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        String sql = "delete from note_info where pk_id=?";
        try {
            conn = JdbcUtil.getConn();
            conn.setAutoCommit(false);
            queryRunner = new QueryRunner();
            for (int i = 0; i < list.size(); i++) {
                queryRunner.update(conn, sql, list.get(i));
            }
            conn.commit();
        } finally {
            conn.setAutoCommit(true);
            DbUtils.close(conn);
        }
    }

    /**
     * 根据主键集合完成便签信息
     *
     * @param list
     * @return
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void finishNoteInfoById(ArrayList<String> list) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        String sql = "update note_info set note_state=? where pk_id=?";
        try {
            conn = JdbcUtil.getConn();
            conn.setAutoCommit(false);
            queryRunner = new QueryRunner();
            for (int i = 0; i < list.size(); i++) {
                queryRunner.update(conn, sql, DictEnum.NoteState.FINISHED, list.get(i));
            }
            conn.commit();
        } finally {
            conn.setAutoCommit(true);
            DbUtils.close(conn);
        }
    }

    /**
     * 保存或更新便签信息（根据PK_ID是否为空来判断）
     *
     * @param noteInfo
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void saveOrUpdateNoteInfo(NoteInfo noteInfo) throws SQLException {
        Connection conn = null;
        QueryRunner queryRunner = null;
        String sql_insert = "insert into note_info(note_name,note_comment,dead_line_date,priority,note_state,remind_time,pk_id)values(?,?,?,?,?,?,?)";
        String sql_update = "update note_info set note_name=?,note_comment=?,dead_line_date=?,priority=?,note_state=?,remind_time=? where pk_id=?";
        try {
            conn = JdbcUtil.getConn();
            queryRunner = new QueryRunner();
            Object[] params = new Object[7];
            int seq = 0;
            params[seq++] = noteInfo.getNoteName();
            params[seq++] = noteInfo.getNoteComment();
            params[seq++] = noteInfo.getDeadLineDate();
            params[seq++] = noteInfo.getPriority();
            params[seq++] = noteInfo.getNoteState();
            params[seq++] = noteInfo.getRemindTime();
            if (StringUtils.isNotEmpty(noteInfo.getPkId())) {
                params[seq++] = noteInfo.getPkId();
                queryRunner.update(conn, sql_update, params);
            } else {
                params[seq++] = UITools.generateUUID();
                queryRunner.update(conn, sql_insert, params);
            }
        } finally {
            DbUtils.close(conn);
        }
    }
}
