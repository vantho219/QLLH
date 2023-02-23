/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Darling
 */
public class Classroom {
    private int id;
    private String name;
    private String malop;
    private String mota;
    private int slmin;
    private int slmax;

    public Classroom() {
    }

    public Classroom(int id, String name, String malop, String mota, int slmin, int slmax) {
        this.id = id;
        this.name = name;
        this.malop = malop;
        this.mota = mota;
        this.slmin = slmin;
        this.slmax = slmax;
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

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public int getSlmin() {
        return slmin;
    }

    public void setSlmin(int slmin) {
        this.slmin = slmin;
    }

    public int getSlmax() {
        return slmax;
    }

    public void setSlmax(int slmax) {
        this.slmax = slmax;
    }

    @Override
    public String toString() {
        return "Classroom{" + "id=" + id + ", name=" + name + ", malop=" + malop + ", mota=" + mota + ", slmin=" + slmin + ", slmax=" + slmax + '}';
    }
    
    
}
