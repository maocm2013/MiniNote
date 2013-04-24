
import com.malcolm.note.util.JdbcUtil;
import java.sql.SQLException;

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
}
