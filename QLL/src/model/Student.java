/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Darling
 */
public class Student {
    private int id;
    private String name;
    private String malop;
    private String lophoc;
    private int sdt;
    private int masv;

    public Student() {
    }

    public Student(int id, String name, String malop, String lophoc, int sdt, int masv) {
        this.id = id;
        this.name = name;
        this.malop = malop;
        this.lophoc = lophoc;
        this.sdt = sdt;
        this.masv = masv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMalop() {
        return malop;
    }

    public void setMalop(String malop) {
        this.malop = malop;
    }

    public String getLophoc() {
        return lophoc;
    }

    public void setLophoc(String lophoc) {
        this.lophoc = lophoc;
    }

    public int getSdt() {
        return sdt;
    }

    public void setSdt(int sdt) {
        this.sdt = sdt;
    }

    public int getMasv() {
        return masv;
    }

    public void setMasv(int masv) {
        this.masv = masv;
    }

    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name=" + name + ", malop=" + malop + ", lophoc=" + lophoc + ", sdt=" + sdt + ", masv=" + masv + '}';
    }
}
