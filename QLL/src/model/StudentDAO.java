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
public class StudentDAO {
    public int add(Student ee){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "insert Students(name, malop, lophoc, sdt, masv) values (?,?,?,?,?)";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1,ee.getName());
            sttm.setString(2,ee.getMalop());
            sttm.setString(3,ee.getLophoc());
            sttm.setInt(4,ee.getSdt());
            sttm.setInt(5,ee.getMasv());
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

    public int edit(Student ee){
        Connection conn = null;
        PreparedStatement sttm = null;
        try {
            String sSQL = "update Students set name = ?,malop = ?,lophoc = ?,sdt = ?,masv = ? where id = ? ";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm = conn.prepareStatement(sSQL);
            sttm.setString(1,ee.getName());
            sttm.setString(2,ee.getMalop());
            sttm.setString(3,ee.getLophoc());
            sttm.setInt(4,ee.getSdt());
            sttm.setInt(5,ee.getMasv());
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
            String sSQL = "delete Students where id = ?";
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

    public List<Student> getAllStudents(){
        List<Student> list = new ArrayList<>();
        Connection conn = null;
        Statement sttm = null;
        ResultSet rs = null;
        try{
            String sSQL = "select name, malop, lophoc, sdt, masv from Students order by id desc";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.createStatement();
            rs = sttm.executeQuery(sSQL);
            while (rs.next()){
                Student ee = new Student();
                ee.setId(rs.getInt(1));
                ee.setName(rs.getString(2));
                ee.setMalop(rs.getString(3));
                ee.setLophoc(rs.getString(4));
                ee.setSdt(rs.getInt(5));
                ee.setMasv(rs.getInt(6));
                list.add(ee);
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
        return list;
    }

    public Student getStudentByID(int id){
        Connection conn = null;
        PreparedStatement sttm = null;
        ResultSet rs = null;
        Student ee = new Student();
        try{
            String sSQL = "select id, name, malop, lophoc, sdt, masv from Students where id = ?";
            conn = DatabaseUtils.getDBConnect();
            sttm = conn.prepareStatement(sSQL);
            sttm.setInt(1,id);
            rs = sttm.executeQuery();
            while (rs.next()){
                ee.setId(rs.getInt(1));
                ee.setName(rs.getString(2));
                ee.setMalop(rs.getString(3));
                ee.setLophoc(rs.getString(4));
                ee.setSdt(rs.getInt(5));
                ee.setMasv(rs.getInt(6));
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
        StudentDAO dao = new StudentDAO();
//        Student ee = new Student(4, "Tho", "CNTT1301", "Dieu duong",12345126 , 12345);
//        dao.add(ee);
//        dao.edit(ee);
//        dao.del(5);
        System.out.println("=>" +dao.getStudentByID(1));
    }
}
