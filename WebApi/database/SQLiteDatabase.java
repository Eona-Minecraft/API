import org.sqlite.SQLiteConfig;

import java.sql.SQLException;

/**
 * Created by marcel on 09.01.16.
 */
public class SQLiteDatabase extends AbstractDatabase {

    public SQLiteDatabase() throws Exception {
        setClassName("org.sqlite.JDBC");
        loadDriver();
    }

    @Override
    String getConnectionString() {
        return "jdbc:sqlite:" + credentials.getDbHost();
    }


}
