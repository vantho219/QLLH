/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package database;
import java.sql.Connection;
/**
 *
 * @author Darling
 */
public class TestDB {
    public static void main(String[] args){
            Connection conn = DatabaseUtils.getDBConnect();
            if (conn !=null){
                System.out.println("ket noi thanh cong");
            }else {
                System.out.println("ket noi that bai");
            }
    }
}
