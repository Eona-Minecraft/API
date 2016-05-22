package dal;

import java.sql.*;

public abstract class AbstractDatabase {

    protected Connection _dbConn = null;
    private String className = "";
    protected DatabaseCredentials credentials = null;

    abstract String getConnectionString();

    public void loadDriver() throws Exception {
        if(className.isEmpty()){
            throw new Exception("No driver name given");
        }else{
            try{
                Class.forName(this.className).newInstance();
            }catch(Exception e){
                throw e;
            }
        }
    }

    public void open() throws SQLException {
        try{
            _dbConn = DriverManager.getConnection(getConnectionString());
        }catch(Exception e){
            throw e;
        }
    }

    public void close() throws Exception{
        if(_dbConn != null){
            if(!_dbConn.isClosed() ){
                _dbConn.close();
            }else{
                throw new Exception("Database-Link already closed");
            }
        }else{
            throw new Exception("No Database-Link");
        }
    }


    public ResultSet query(String sql) throws Exception{
        if(_dbConn != null){
            if(!_dbConn.isClosed() ){
                return _dbConn.createStatement().executeQuery(sql);
            }else{
                throw new Exception("Database-Link already closed");
            }
        }else{
            throw new Exception("No Database-Link");
        }
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public DatabaseCredentials getCredentials() {
        return credentials;
    }

    public void setCredentials(DatabaseCredentials credentials) {
        this.credentials = credentials;
    }


}
