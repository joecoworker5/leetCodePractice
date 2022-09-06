package com.cathaybk.practice.nt87944.b;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class DBConnection {
    static DBConnection db = new DBConnection();

    @SuppressWarnings("unused")
    public static void main(String[] args) {

        List<Map<Object, Object>> list = new ArrayList<>();
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@88.249.45.5:80/ORCLCDB.localdomain", "STUDENT",
            "CATHAYBK654321"); PreparedStatement pstmt = conn.prepareStatement("select * from CARS", ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE );) {
            
            try (ResultSet rs = pstmt.executeQuery();) {
                int row = rs.getRow();
                if(row>20){
                    throw new Exception();
                }
                while (rs.next()) {
                    
                    Map<Object, Object> map = new HashMap<>();
                    String manu = rs.getString("MANUFACTURER");
                    String type = rs.getString("TYPE");
                    BigDecimal min_price = rs.getBigDecimal("MIN_PRICE");
                    BigDecimal price = rs.getBigDecimal("PRICE");
                    map.put("MANUFACTURER", manu);
                    map.put("TYPE", type);
                    map.put("MIN_PRICE", min_price);
                    map.put("PRICE", price);
                    list.add(map);
                }
                System.out.printf("%-15s", "MANUFACTURER");
                System.out.printf("%-15s", "TYPE");
                System.out.printf("%-15s", "MIN_PRICE");
                System.out.printf("%-15s", "PRICE");
                System.out.println();
                for (Map<Object, Object> map : list) {
                    System.out.printf("%-15s", map.get("MANUFACTURER"));
                    System.out.printf("%-15s", map.get("TYPE"));
                    System.out.printf("%-15s", map.get("MIN_PRICE"));
                    System.out.printf("%-15s", map.get("PRICE"));
                    System.out.println();
                }
            }

            //            Scanner in = new Scanner(System.in);
            //            System.out.println("請選擇以下指輸入: select、insert、update、delete");
            //            String method = in.next();
            db.choose(conn);
        } catch (SQLException e) {
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    void choose(Connection conn) {
        Scanner in = new Scanner(System.in);
        System.out.println("請選擇以下指輸入: select、insert、update、delete");
        String method = in.next();
        if ("select".equals(method)) {
            db.query(conn);
        } else if ("insert".equals(method)) {
            db.insert(conn);
        } else if ("update".equals(method)) {
            db.update(conn);
        } else if ("delete".equals(method)) {
            db.delete(conn);
        } else {
            System.out.println("輸入錯誤請重新輸入");
            db.choose(conn);
        }
    }

    @SuppressWarnings("resource")
    void query(Connection conn) {
        try (PreparedStatement pstmt = conn.prepareStatement("select * from CARS where MANUFACTURER= ? and TYPE=?");) {
            Scanner in = new Scanner(System.in);
            // 本身没有数据，自然不用new初始化实例域
            System.out.println("请输入想查詢的製造商");
            String manufac = in.next();
            System.out.println("请输入想查詢車種");
            String typecar = in.next();
            pstmt.setString(1, manufac);
            pstmt.setString(2, typecar);
            try (ResultSet rs = pstmt.executeQuery();) {
                System.out.printf("%-15s", "MANUFACTURER");
                System.out.printf("%-15s", "TYPE");
                System.out.printf("%-15s", "MIN_PRICE");
                System.out.printf("%-15s", "PRICE");
                System.out.println();
                while (rs.next()) {
                    System.out.printf("%-15s", rs.getString("MANUFACTURER"));
                    System.out.printf("%-15s", rs.getString("TYPE"));
                    System.out.printf("%-15s", rs.getBigDecimal("MIN_PRICE"));
                    System.out.printf("%-15s", rs.getBigDecimal("PRICE"));
                    System.out.println();
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void insert(Connection conn) {
        try (PreparedStatement pstmt = conn.prepareStatement("insert into CARS (MANUFACTURER, TYPE, MIN_PRICE, PRICE) values (?,?,?,?)");) {
            Scanner in = new Scanner(System.in);
            // 本身没有数据，自然不用new初始化实例域
            System.out.println("请输入製造商");
            String manufac = in.next();
            System.out.println("请输入類型");
            String typecar = in.next();
            System.out.println("请输入底價");
            String min_price = in.next();
            System.out.println("请输入售價");
            String price = in.next();
            pstmt.setString(1, manufac);
            pstmt.setString(2, typecar);
            pstmt.setString(3, min_price);
            pstmt.setString(4, price);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("新增成功");
            } else {
                System.out.println("新增失敗");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void update(Connection conn) {
        try (PreparedStatement pstmt = conn.prepareStatement("update CARS set MIN_PRICE=?, PRICE=? where MANUFACTURER = ? and TYPE = ?");) {
            Scanner in = new Scanner(System.in);
            // 本身没有数据，自然不用new初始化实例域
            System.out.println("请输入製造商");
            String manufac = in.next();
            System.out.println("请输入類型");
            String typecar = in.next();
            System.out.println("请输入新的底價");
            String min_price = in.next();
            System.out.println("请输入新售價");
            String price = in.next();
            pstmt.setString(1, min_price);
            pstmt.setString(2, price);
            pstmt.setString(3, manufac);
            pstmt.setString(4, typecar);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("更新成功");
            } else {
                System.out.println("更新失敗");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    void delete(Connection conn) {
        try (PreparedStatement pstmt = conn.prepareStatement("delete CARS where MANUFACTURER = ? and TYPE = ?");) {
            Scanner in = new Scanner(System.in);
            // 本身没有数据，自然不用new初始化实例域
            System.out.println("请输入製造商");
            String manufac = in.next();
            System.out.println("请输入類型");
            String typecar = in.next();
            pstmt.setString(1, manufac);
            pstmt.setString(2, typecar);
            int result = pstmt.executeUpdate();
            if (result == 1) {
                System.out.println("刪除成功");
            } else {
                System.out.println("刪除失敗");
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}
