
import com.tistory.sylphe.app.User;
import com.tistory.sylphe.app.UserDao;
import org.junit.Test;

import java.sql.SQLException;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class UserDaoTest {

    @Test
    public void get() throws SQLException, ClassNotFoundException {
        UserDao userDao = new UserDao();
        int id=1;
        User user = userDao.get(id);

        assertThat(user.getId(), is(1));

        assertThat(user.getName(), is("허윤호"));

        assertThat(user.getPassword(), is("1234"));

    }
}
