package model.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Database {
    private Connection con = null;

        public void myConnect(String pDriver, String pConnectionString) throws Exception{
            Class.forName(pDriver);
            con = DriverManager.getConnection(pConnectionString);
            System.out.println("LOG: connected");
        }

        public ResultSet myQuery(String pSql) throws Exception{
            return con.createStatement().executeQuery(pSql);
        }

        public String myInsert( long id, String username, int age, char gender, String state, char[] password) throws Exception{

            PreparedStatement preparedStatement = con.prepareStatement("insert into tblUsers values(?,?)");

            preparedStatement.setLong(1,id);
            preparedStatement.setString(2,username);
            preparedStatement.setInt(3,age);
            preparedStatement.setString (4, String.valueOf(gender));
            preparedStatement.setString(5,state);
            preparedStatement.setString(6,String.valueOf(password));
            int count = preparedStatement.executeUpdate();

            return count + " records affected";
        }

        public void myClose()throws Exception{
            if(con != null){
                con.close();
            }
        }
}

