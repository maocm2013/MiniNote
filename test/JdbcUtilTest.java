
import com.malcolm.note.dao.NoteInfoDao;
import com.malcolm.note.domain.NoteInfo;
import com.malcolm.note.util.JdbcUtil;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author user
 */
import org.junit.Test;
public class JdbcUtilTest {
    @Test
    public void testGetConn() throws ClassNotFoundException, SQLException{
        JdbcUtil.getConn();
    }
    
    @Test
    public void tetGetNoteInfo() throws SQLException, ClassNotFoundException{
        NoteInfoDao dao = new NoteInfoDao();
        List<NoteInfo> list = dao.getAllNoteInfo();
        if(list != null && list.size() > 0){
            for(int i = 0; i < list.size(); i++){
                NoteInfo note = list.get(i);
                System.out.println(note.toString());
            }
        }
    }
}
