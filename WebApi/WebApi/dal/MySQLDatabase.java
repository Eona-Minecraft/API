package dal;

/**
 * Created by marcel on 09.01.16.
 */
public class MySQLDatabase extends AbstractDatabase{

    public MySQLDatabase() throws Exception{
        this.setClassName("com.mysql.jdbc.Driver");
        this.loadDriver();
    }

    @Override
    String getConnectionString() {
        return "jdbc:mysql://" + credentials.getDbHost() + "/" + credentials.getDbName() + "?user=" + credentials.getDbUser() + "&password=" + credentials.getDbPass();
    }
}
