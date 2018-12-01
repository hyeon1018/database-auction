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
        String itemListSQL = "SELECT deal_type, item_id, category, price, delivery_fee, item_info, user_id, expire_time, seller_rate\n" +
                "FROM item_list LEFT OUTER JOIN (SELECT Item.user_id, avg(item_point) as seller_rate FROM Deal JOIN Item USING(item_id) GROUP BY Item.user_id) rate USING(user_id)\n";
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

        itemListSQL += "AND (expire_time > now() OR expire_time is null);";


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
                String[] data = new String[9];
                data[0] = rs.getString(1);
                data[1] = String.valueOf(rs.getInt(2));
                data[2] = rs.getString(3);
                data[3] = String.valueOf(rs.getInt(4));
                data[4] = String.valueOf(rs.getInt(5));
                data[5] = rs.getString(6);
                data[6] = rs.getString(7);
                data[7] = (rs.getDate(8) != null ? rs.getDate(8).toString():"");
                data[8] = String.valueOf(rs.getFloat(9));
                itemList.add(data);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }

        return itemList;
    }

    /**
     * @param itemId
     * @return String[] with deal_type, item_id, category, price, delivery_fee, item_info, user_id, expire_time
     */
      public static String [] getItemInfo(String itemId){
        String [] data = new String [9];
        String getItemInfoSQL = "SELECT deal_type, item_id, category, price, delivery_fee, item_info, user_id, expire_time, seller_rate\n" +
                "FROM item_list LEFT OUTER JOIN (SELECT Item.user_id, avg(item_point) as seller_rate FROM Deal JOIN Item USING(item_id) GROUP BY Item.user_id) rate USING(user_id)\n" +
                "WHERE item_id = ?;";
        try(PreparedStatement pstat = connection.prepareStatement(getItemInfoSQL)){
            pstat.setInt(1, Integer.parseInt(itemId));
            ResultSet rs = pstat.executeQuery();
            if(rs.first()){
                data[0] = rs.getString(1);
                data[1] = String.valueOf(rs.getInt(2));
                data[2] = rs.getString(3);
                data[3] = String.valueOf(rs.getInt(4));
                data[4] = String.valueOf(rs.getInt(5));
                data[5] = rs.getString(6);
                data[6] = rs.getString(7);
                data[7] = (rs.getDate(8) != null ? rs.getDate(8).toString() : null);
                data[8] = String.valueOf(rs.getFloat(9));
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return data;
    }

    public static List<String> getAddresses(String userId){
          List<String> addresses = new ArrayList<>();
          String getAdressesSQL = "SELECT address_alias, address FROM Address WHERE user_id = ?";
          try(PreparedStatement ps = connection.prepareStatement(getAdressesSQL)){
              ps.setString(1, userId);
              ResultSet rs = ps.executeQuery();
              while(rs.next()){
                  addresses.add(rs.getString(1) + "-" + rs.getString(2));
              }
          }catch(SQLException se){
              se.printStackTrace();
          }

          return addresses;
    }

    public static void updateAddress(String userId, String alias, String address){
          String updateAddressSQL = "UPDATE Address SET address = ? WHERE user_id = ? AND address_alias = ?";
          try(PreparedStatement ps = connection.prepareStatement(updateAddressSQL)){
              ps.setString(1, address);
              ps.setString(2, userId);
              ps.setString(3, alias);
              ps.execute();
          }catch (SQLException se){
              se.printStackTrace();
          }
    }

    public static List<String> getPayments(String userId){
          List<String> payments = new ArrayList<>();
          String getPaymentsSQL = "WITH payments(user_id, idf_c, idf_n) AS (SELECT * FROM Card UNION SELECT * FROM Account)\n" +
                  "SELECT idf_c, idf_n FROM payments WHERE user_id = ?;";
          try(PreparedStatement ps = connection.prepareStatement(getPaymentsSQL)){
              ps.setString(1, userId);
              ResultSet rs = ps.executeQuery();
              while(rs.next()){
                  payments.add(rs.getString(1) + "-" + rs.getString(2));
              }
          }catch (SQLException se){
              se.printStackTrace();
          }
          return payments;
    }

    public static void addCard(String userId, String cardCompany, String cardNo){
          String addCardSQL = "INSERT INTO Card VALUES(?,?,?);";
          try(PreparedStatement ps = connection.prepareStatement(addCardSQL)){
              ps.setString(1, userId);
              ps.setString(2, cardCompany);
              ps.setString(3, cardNo);
              ps.execute();
          }catch(SQLException se){
              se.printStackTrace();
          }
    }

    public static void addAccount(String userId, String Bank, String accountNo){
        String addCardSQL = "INSERT INTO Account VALUES(?,?,?);";
        try(PreparedStatement ps = connection.prepareStatement(addCardSQL)){
            ps.setString(1, userId);
            ps.setString(2, Bank);
            ps.setString(3, accountNo);
            ps.execute();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

    public  static void deletePayment(String userId, String bank, String number){
          String [] deletePaymentSQL = {
                  "DELETE FROM Card WHERE user_id = ? AND card_company = ? AND card_number = ?",
                  "DELETE FROM Account WHERE user_id = ? AND bank = ? AND account = ?"
          };
          for(String sql : deletePaymentSQL){
              try(PreparedStatement ps = connection.prepareStatement(sql)){
                  ps.setString(1, userId);
                  ps.setString(2, bank);
                  ps.setString(3,number);
                  ps.execute();
              }catch (SQLException se){
                  se.printStackTrace();
              }
          }

    }

    public static String[] getUserInfo(String userId){
          String getUserInfoSQL = "SELECT  user_id, name, age, gender, phone_number FROM User WHERE user_id = ?";
          String [] data = new String[5];
          try(PreparedStatement ps = connection.prepareStatement(getUserInfoSQL)){
              ps.setString(1, userId);
              ResultSet rs = ps.executeQuery();
              if(rs.first()){
                  data[0] = rs.getString(1);
                  data[1] = rs.getString(2);
                  data[2] = String.valueOf(rs.getInt(3));
                  data[3] = rs.getString(4);
                  data[4] = rs.getString(5);
              }
          }catch(SQLException se){

          }
          return data;
    }

    public static void updateUserInfo(String userId, int age, String phoneNumber, String password){
          String updateUserInfoSQL = "UPDATE User SET age = ?, phone_number = ?" +
                                        (password.equals("") ? "" : ", user_pw = md5(?)") +
                                        " WHERE user_id = ?";
          try(PreparedStatement ps = connection.prepareStatement(updateUserInfoSQL)){
                int i = 1;
                ps.setInt(i++, age);
                ps.setString(i++, phoneNumber);
                if(!password.equals("")){
                    ps.setString(i++, password);
                }
                ps.setString(i++,userId);
                ps.execute();
          }catch(SQLException se){
              se.printStackTrace();
          }
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

    public static void bidItem(String userId, String itemId, int bidPrice){
        String bidSQL = "INSERT INTO Bid Values(?,?,now(),?);";
        try(PreparedStatement pstat = connection.prepareStatement(bidSQL)){
            pstat.setInt(1, Integer.parseInt(itemId));
            pstat.setString(2, userId);
            pstat.setInt(3, bidPrice);
            pstat.execute();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public static List<String[]> getWinningBidItem(String userId){
          String getWinningBidItemSQL = "SELECT Item.user_id, Item.item_id, join_price\n" +
                                        "FROM Bid JOIN Item USING(item_id)\n" +
                                        "WHERE join_price >= ALL (SELECT join_price FROM Bid)\n" +
                                        "AND item_id NOT IN (SELECT item_id FROM Deal)\n" +
                                        "AND expire_time < now()\n" +
                                        "AND Bid.user_id = ?";
          List<String[]> winningBids = new ArrayList<>();
          try(PreparedStatement ps = connection.prepareStatement(getWinningBidItemSQL)){
              ps.setString(1, userId);
              ResultSet rs = ps.executeQuery();
              while(rs.next()){
                  String[] data = new String[3];
                  data[0] = rs.getString(1);
                  data[1] = rs.getString(2);
                  data[2] = String.valueOf(rs.getInt(3));
                  winningBids.add(data);
              }

          }catch (SQLException se){
              se.printStackTrace();
        }
          return winningBids;
    }

    public static void dealItem(String userId, String addressAlias, String itemId){
          String dealItemSQL = "INSERT INTO Deal (user_id, address_alias, item_id, time) VALUES (?,?,?,now());";
          try(PreparedStatement ps = connection.prepareStatement(dealItemSQL)){
              ps.setString(1, userId);
              ps.setString(2, addressAlias);
              ps.setInt(3, Integer.parseInt(itemId));
              ps.execute();
          }catch (SQLException se){
              se.printStackTrace();
          }
    }

    public static List<String []>  getLogListbyBuyer(String user_id){
        List<String []> LogList = new ArrayList<>();
        String LogListbyBuyerSQL = "WITH my_address AS (SELECT address, address_alias FROM Address WHERE user_id = ?), " +
                "my_deal AS (SELECT time, item_id, state, address_alias, deal_id FROM Deal WHERE user_id = ?), " +
                "item_dealer AS (SELECT item_id, user_id, name, phone_number, price FROM Item JOIN User USING (user_id)) " +
                "SELECT time, deal_id, user_id, name, phone_number, item_id, price, address, state " +
                "FROM item_dealer JOIN (my_deal JOIN my_address USING (address_alias)) USING (item_id) ";

        try(PreparedStatement pstat = connection.prepareStatement(LogListbyBuyerSQL)){
            pstat.setString(1, user_id);
            pstat.setString(2, user_id);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()) {
                String[] data = new String[9];
                data[0] = rs.getDate(1).toString();
                data[1] = String.valueOf(rs.getInt(2));
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = String.valueOf(rs.getInt(6));
                data[6] = String.valueOf(rs.getInt(7));
                data[7] = rs.getString(8);
                data[8] = rs.getString(9);
                LogList.add(data);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }

        return LogList;
        // 구매자가 구매 내역 조회하는 Query문.
    }

    public static List<String []>  getLogListbySeller(String user_id){
        List<String []> LogList = new ArrayList<>();
        String LogListbySellerSQL = "WITH item_deal (time, user_id, item_id, item_price, address_alias, state, deal_id) AS " +
                "(SELECT time, Deal.user_id, item_id, price, address_alias, state, deal_id " +
                "FROM Deal Join Item USING (item_id) WHERE Item.user_id = ?), " +
                "user_address AS (SELECT user_id, name, phone_number, address, address_alias FROM Address JOIN User USING(user_id)) " +
                "SELECT time, deal_id, user_id, name, phone_number, item_id, item_price, address, state " +
                "FROM item_deal JOIN user_address USING(user_id, address_alias) ";

        try(PreparedStatement pstat = connection.prepareStatement(LogListbySellerSQL)){
            pstat.setString(1, user_id);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()) {
                String[] data = new String[9];
                data[0] = rs.getDate(1).toString();
                data[1] = String.valueOf(rs.getInt(2));
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = String.valueOf(rs.getInt(6));
                data[6] = String.valueOf(rs.getInt(7));
                data[7] = rs.getString(8);
                data[8] = rs.getString(9);
                LogList.add(data);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }

        return LogList;
        // 판매자가 판매 내역 조회하는 Query문.
    }

    public static void setItemShipped(int dealId){
        String setItemShippedSQL = "UPDATE Deal SET state = '배송중' WHERE Deal_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(setItemShippedSQL)){
            ps.setInt(1, dealId);
            ps.execute();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

    public static void setItemReached(int dealId){
        String setItemShippedSQL = "UPDATE Deal SET state = '구매 확정' WHERE Deal_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(setItemShippedSQL)){
            ps.setInt(1, dealId);
            ps.execute();
        }catch(SQLException se){
            se.printStackTrace();
        }
    }

    public static void DeleteLogList(int deal_id){
        String DeleteLogListSQL = "DELETE FROM Deal WHERE deal_id = ?";
        try(PreparedStatement pstat = connection.prepareStatement(DeleteLogListSQL)) {
            pstat.setInt(1, deal_id);
            pstat.execute();
        }catch(SQLException se){
            se.printStackTrace();
        }
        // 판매자 및 구매자가 자신의 판매/구매 내역을 삭제하는 Query문.
    }

    public static List<String> getFavorite(String user_id){

          List<String> FavoriteList = new ArrayList<>();
          String FavoriteSQL = "SELECT seller_user_id FROM Favorite WHERE user_id = ?";
          try(PreparedStatement pstat = connection.prepareStatement(FavoriteSQL)){
              pstat.setString(1, user_id);
              ResultSet rs = pstat.executeQuery();
              while(rs.next()) {
                  String data = rs.getString(1);
                  FavoriteList.add(data);
              }
          }catch(SQLException se){
              se.printStackTrace();
          }

        return FavoriteList;
    }

    public static void deleteFavorite(String user_id, String target_user_id){
        String DeleteFavoriteSQL = "DELETE FROM Favorite WHERE user_id = ? AND seller_user_id = ?";
        try(PreparedStatement pstat = connection.prepareStatement((DeleteFavoriteSQL))){
            pstat.setString(1, user_id);
            pstat.setString(2, target_user_id);
            pstat.execute();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public static void insertFavorite(String user_id, String target_user_id){
        String InsertFavoriteSQL = "INSERT INTO Favorite VALUES (?,?);";
        try(PreparedStatement pstat = connection.prepareStatement((InsertFavoriteSQL))){
            pstat.setString(1, target_user_id);
            pstat.setString(2, user_id);
            pstat.execute();
        }catch (SQLException se){
            se.printStackTrace();
        }
    }

    public static List<String []> FavoriteResultList(String userId){
        List<String []> favoriteresult = new ArrayList<>();
        String FavoriteResultSQL = "SELECT deal_type, item_id, category, price, item_info, user_id, expire_time\n" +
                "FROM item_list\n" +
                "WHERE (expire_time > now() OR expire_time is null) AND user_id = ?;";
        try (PreparedStatement pstat = connection.prepareStatement(FavoriteResultSQL)){
            pstat.setString(1, userId);
            ResultSet rs =  pstat.executeQuery();
            while(rs.next()) {
                String[] data = new String[7];
                data[0] = rs.getString(1);
                data[1] = String.valueOf(rs.getInt(2));
                data[2] = rs.getString(3);
                data[3] = String.valueOf(rs.getInt(4));
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                data[6] = (rs.getDate(7) != null ? rs.getDate(7).toString() : "");
                favoriteresult.add(data);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }
        return favoriteresult;
    }

    // TEST_START
    public static List<String []>  getLogListTEST(String user_id){
        List<String []> LogList = new ArrayList<>();
        String LogListTestSQL = "SELECT item_id, price, user_id, name, phone_number, address, address_alias, gender, age " +
                "FROM Item JOIN (User JOIN Address USING(user_id)) USING(user_id) " +
                "WHERE user_id = ?";
        try(PreparedStatement pstat = connection.prepareStatement(LogListTestSQL)){
            pstat.setString(1, user_id);
            ResultSet rs = pstat.executeQuery();
            while(rs.next()) {
                String[] data = new String[9];
                data[0] = String.valueOf(rs.getInt(1));
                data[1] = String.valueOf(rs.getInt(2));
                data[2] = rs.getString(3);
                data[3] = rs.getString(4);
                data[4] = rs.getString(5);
                data[5] = rs.getString(6);
                data[6] = rs.getString(7);
                data[7] = rs.getString(8);
                data[8] = String.valueOf(rs.getInt(9));
                LogList.add(data);
            }
        }catch (SQLException se){
            se.printStackTrace();
        }

        return LogList;
    }
//TEST_END

}
