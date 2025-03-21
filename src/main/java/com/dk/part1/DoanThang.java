/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dk.part1;

/**
 *
 * @author AN515-57
 */
public class DoanThang {
    private Diem a;
    private Diem b;

    public DoanThang(Diem a, Diem b) {
        this.a = a;
        this.b = b;
    }
    /**
     * @return the a
     */
    public Diem getA() {
        return a;
    }

    /**
     * @param a the a to set
     */
    public void setA(Diem a) {
        this.a = a;
    }

    /**
     * @return the b
     */
    public Diem getB() {
        return b;
    }

    /**
     * @param b the b to set
     */
    public void setB(Diem b) {
        this.b = b;
    }
    
    public void display()
    {
        System.out.printf("Doan thang cua ban la: [ (%.1f . %.1f) ,(%.1f . %.1f)]\n",a.getHoanhDo(),a.getTungDo(),b.getHoanhDo(),b.getTungDo());   
    }     
    
    public double calLength()
    {
     return a.distance(b);
    }
    public Diem trungDiem ()
    {
        double x = (a.getHoanhDo() + b.getHoanhDo()) / 2;
        double y = (b.getTungDo() + b.getTungDo()) / 2;
        return new Diem(x,y);   
    }
    public boolean isParallel (DoanThang other)
    {
     double dx1 = this.a.getHoanhDo() - this.b.getHoanhDo();
     double dy1 = this.a.getTungDo() - this.b.getTungDo();
     
     //Doan thang other
      double dx2 = other.getA().getHoanhDo() - other.getB().getHoanhDo();
      double dy2 = other.getA().getTungDo() - other.getB().getTungDo();
      
      double crossMul = dx1 * dy2 - dx2*dy1;
      //Co the co sai so 
      return Math.abs(crossMul) < 1e-9;
    }
}
