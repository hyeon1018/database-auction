package com.db.auction;

import java.sql.*;

public class Database {
    static Connection  connection = null;

    public static void initConnection() throws SQLException{
        connection = DriverManager.getConnection(
                "jdbc:mariadb://ec2-13-209-35-117.ap-northeast-2.compute.amazonaws.com/auction",
                "auction",
                "konkuk14*4");
    }

    public static boolean isValidUser(String userId, String userPw){
        boolean valid = false;
        String LoginSQL ="SELECT COUNT(user_id) FROM User WHERE user_id = ? AND user_pw = md5(?);";
        ResultSet rs = null;
        try(PreparedStatement pstat = connection.prepareStatement(LoginSQL)){
            pstat.setString(1, userId);
            pstat.setString(2, userPw);
            rs = pstat.executeQuery();

            if(rs.first()) {
                if (1 == rs.getInt(1)) {
                    valid = true;
                }
            }
        }catch (SQLException se){
            valid = false;
            se.printStackTrace();
        }

        return valid;
    }
}
