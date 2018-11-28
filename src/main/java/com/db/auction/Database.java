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
        String loginSQL ="SELECT COUNT(user_id) FROM User WHERE user_id = ? AND user_pw = md5(?);";
        ResultSet rs;
        try(PreparedStatement pstat = connection.prepareStatement(loginSQL)){
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

    public static void regiesterUser(String userId, String userPw, String name, int age, String gender, String phoneNumber){
        String registerSQL ="INSERT INTO User VALUES (?, md5(?), ?, ?, ?, ?);";
        try(PreparedStatement pstat = connection.prepareStatement(registerSQL)){
            pstat.setString(1, userId);
            pstat.setString(2, userPw);
            pstat.setString(3, name);
            pstat.setInt(4, age);
            pstat.setString(5, gender);
            pstat.setString(6, phoneNumber);
            pstat.execute();
        }catch (SQLException se){
            se.printStackTrace();
            // TODO - 예외 처리 -> 중복 or 데이터 부족시에.
        }
    }

    public static void addAddress(String usereId, String alias, String address){
        String addAddressSQL ="INSERT INTO Address VALUES (?, ?, ?);";
        try(PreparedStatement pstat = connection.prepareStatement(addAddressSQL)){
            pstat.setString(1, usereId);
            pstat.setString(2, alias);
            pstat.setString(3, address);
            pstat.execute();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }
}
