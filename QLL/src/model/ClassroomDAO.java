/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import database.DatabaseUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Darling
 */
public class ClassroomDAO {
     public int add(Classroom ee){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert Classrooms(name, malop, mota, slmin, slmax) values (?,?,?,?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1,ee.getName());
            sttm.setString(2,ee.getMalop());
            sttm.setString(3,ee.getMota());
            sttm.setInt(4,ee.getSlmin());
            sttm.setInt(5,ee.getSlmax());
            if (sttm.executeUpdate()>0){
                System.out.println("them thanh cong");
                return 1;
            }
        }catch (Exception e){
            System.out.println("Error:"+e.toString());
        }finally {
            try{
                conn.close();
                sttm.close();
            }catch (Exception e){

            }
        }
        return -1;
    }

    public int edit(Classroom ee){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update Classrooms set name = ?,malop = ?,mota = ?,slmin = ?,slmax = ? where id = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1,ee.getName());
            sttm.setString(2,ee.getMalop());
            sttm.setString(3,ee.getMota());
            sttm.setInt(4,ee.getSlmin());
            sttm.setInt(5,ee.getSlmax());
            sttm.setInt(6, ee.getId());
            if (sttm.executeUpdate()>0){
                System.out.println("sua thanh cong");
                return 1;
            }
        }catch (Exception e){
            System.out.println("Error:"+e.toString());
        }finally {
            try{
                conn.close();
                sttm.close();
            }catch (Exception e){

            }
        }
        return -1;
    }

    public int del(int id){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "delete Classrooms where id = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1,id);

            if (sttm.executeUpdate()>0){
                System.out.println("xoa thanh cong");
                return 1;
            }
        }catch (Exception e){
            System.out.println("Error:"+e.toString());
        }finally {
            try{
                conn.close();
                sttm.close();
            }catch (Exception e){

            }
        }
        return -1;
    }

    public List<Classroom> getAllClassroom(){
        List<Classroom> ls = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try{
            String sSQL = "select id, name, malop, mota, slmin, slmax from Classrooms order by id desc";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                Classroom ee = new Classroom();
                ee.setId(rs.getInt(1));
                ee.setName(rs.getString(2));
                ee.setMalop(rs.getString(3));
                ee.setMota(rs.getString(4));
                ee.setSlmin(rs.getInt(5));
                ee.setSlmax(rs.getInt(6));
                ls.add(ee);
            }
        }catch (Exception e){
            System.out.println("Error:"+e.toString());
        }finally {
            try {
                rs.close();
                sttm.close();
                conn.close();
            }catch (Exception e){

            }
        }
        return ls;
    }

    public Classroom getClassroomByID(int id){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        Classroom ee = new Classroom();
        try{
            String sSQL = "select id, name, malop, mota, slmin, slmax from Classrooms where id = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1,id);
            rs = sttm.executeQuery();
            while (rs.next()){
                ee.setId(rs.getInt(1));
                ee.setName(rs.getString(2));
                ee.setMalop(rs.getString(3));
                ee.setMota(rs.getString(4));
                ee.setSlmin(rs.getInt(5));
                ee.setSlmax(rs.getInt(6));
                return ee;
            }
        }catch (Exception e){
            System.out.println("Error:"+e.toString());
        }finally {
            try{
                conn.close();
                rs.close();
                sttm.close();
            }catch (Exception e){

            }
        }
        return null;
    }
    public static void main (String[] args){
        ClassroomDAO dao = new ClassroomDAO();
        Classroom ee = new Classroom(1, "Kien truc 16", "KT16", "Test lai mo ta", 15, 30);
//        dao.add(ee);
//        dao.edit(ee);
//        dao.del(2);
        System.out.println("=>" +dao.getClassroomByID(1));
    }
}
