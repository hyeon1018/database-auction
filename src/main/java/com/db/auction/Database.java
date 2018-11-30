package com.db.auction;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Database {
    static Connection  connection = null;

    public static void initConnection() throws SQLException{
        connection = DriverManager.getConnection(
                "jdbc:mariadb://ec2-13-209-35-117.ap-northeast-2.compute.amazonaws.com/auction",
                "auction",
                "konkuk14*4");
    }

    public static int getLastInsertId(){
        int lastId = 0;
        try(PreparedStatement pstat = connection.prepareStatement("SELECT LAST_INSERT_ID()")) {
            ResultSet rs = pstat.executeQuery();
            if(rs.first()){
                lastId = rs.getInt(1);
            }

        } catch (SQLException se){
            se.printStackTrace();
        }
        return lastId;
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

    public static String[] getCategorys(){
        String getCategorySQL = "SELECT * FROM Category;";
        ResultSet rs;
        List<String> categorys = new ArrayList<>();
        try(PreparedStatement pstat = connection.prepareStatement(getCategorySQL)){
            rs = pstat.executeQuery();
            while(rs.next()){
                categorys.add(rs.getString(1));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }

        return categorys.stream().toArray(String[]::new);
    }

    public static void insertItem(String userId, String category, int price, String deal_type, int deliveryFee, String itemInfo){
        String expriedTime;
        if(deal_type.equals("Bid")){
            expriedTime = "DATE_ADD(NOW(), INTERVAL 7 DAY)";
        }else{
            expriedTime = "NULL";
        }

        String insertItemSQL = "INSERT INTO Item(user_id, category, price, deal_type, delivery_fee, item_info, expire_time)" +
                               "VALUES(?, ?, ?, ?, ?, ?," + expriedTime + ");";
        try(PreparedStatement pstat = connection.prepareStatement(insertItemSQL)){
            pstat.setString(1, userId);
            pstat.setString(2, category);
            pstat.setInt(3, price);
            pstat.setString(4, deal_type);
            pstat.setInt(5, deliveryFee);
            pstat.setString(6, itemInfo);
            pstat.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static void insertImage(String itemId, String imagedir){
        String insertItemSQL = "INSERT INTO Image VALUES(?, ?);";
        try(PreparedStatement pstat = connection.prepareStatement(insertItemSQL)){
            pstat.setString(1, itemId);
            pstat.setString(2, imagedir);
            pstat.execute();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public static List<String []> searchItemList(String deal_type, String category, int minPrice, int maxPrice, String keyword, String user, Date expired){

        List<String []> itemList = new ArrayList<>();
        String itemListSQL = "SELECT deal_type, item_id, category, price, item_info, user_id, expire_time FROM Item";
        itemListSQL += " WHERE price >= ?" ;


        if(maxPrice > 0){
            itemListSQL += " AND price <= ?";;
        }else{
            itemListSQL += " AND 0 <= ?";
        }

        if(deal_type.equals("")){
            itemListSQL += " AND \"\" = ?";
        }else{
            itemListSQL += " AND deal_type = ?";
        }

        if(category.equals("")){
            itemListSQL += " AND \"\" = ?";
        }else{
            itemListSQL += " AND category = ?";
        }

        itemListSQL += " AND item_info LIKE ?";

        if(user.equals("")){
            itemListSQL += " AND \"\" = ? ";
        }else {
            itemListSQL += " AND user_id = ?";
        }

        if(expired != null){
            itemListSQL += " AND expire_time < ?";
        }

        itemListSQL += ";";


        try(PreparedStatement pstat = connection.prepareStatement(itemListSQL)){
            pstat.setInt(1, minPrice);
            pstat.setInt(2, maxPrice);
            pstat.setString(3, deal_type);
            pstat.setString(4, category);
            pstat.setString(5, "%" + keyword + "%");
            pstat.setString(6, user);
            if(expired != null){
                pstat.setDate(7, expired);
            }

            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                String[] data = new String[7];
                data[0] = rs.getString(1);
                data[1] = String.valueOf(rs.getInt(2));
                data[2] = rs.getString(3);
                data[3] = String.valueOf(rs.getInt(4));
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                data[6] = (rs.getDate(7) != null ? rs.getDate(7).toString():"");
                itemList.add(data);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }

        return itemList;
    }

    public static String [] getItemInfo(String itemId){
        String [] data = new String [5];
        String getItemInfoSQL = "SELECT deal_type, item_id, category, price, delivery_fee, item_info, user_id FROM Item Where item_id = ?";
        try(PreparedStatement pstat = connection.prepareStatement(getItemInfoSQL)){
            pstat.setInt(1, Integer.parseInt(itemId));
            ResultSet rs = pstat.executeQuery();
            if(rs.first()){
                data[0] = rs.getString(7);
                data[1] = rs.getString(1);
                data[2] = String.valueOf(rs.getInt(4));
                data[3] = String.valueOf(rs.getInt(5));
                data[4] = rs.getString(6);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }

        return data;
    }

    public static List<String> getImageDirs(String itemId){
        List<String> imageDirs = new ArrayList<>();
        String getImageDirsSQL = "SELECT dir FROM Image WHERE item_id = ?";
        try(PreparedStatement pstat = connection.prepareStatement(getImageDirsSQL)){
            pstat.setInt(1, Integer.parseInt(itemId));
            ResultSet rs = pstat.executeQuery();
            while(rs.next()){
                imageDirs.add(rs.getString(1));
            }
        }catch(SQLException se){
            se.printStackTrace();
        }

        return imageDirs;
    }
}
