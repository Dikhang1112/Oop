/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.dk.part1;

/**
 *
 * @author AN515-57
 */
public class Diem {
    private double hoanhDo;
    private double tungDo;

    public Diem(double hoanhDo, double tungDo) {
        this.hoanhDo = hoanhDo;
        this.tungDo = tungDo;
    }
    
    public void display()
    {
        System.out.printf("Toa do diem la:(%.1f / %.1f) \n", this.getHoanhDo(), this.getTungDo());    
    }
    public double distance(Diem b)
    {
        return Math.sqrt(Math.pow(this.getHoanhDo() - b.getHoanhDo(), 2) + Math.pow(this.getTungDo()- b.getTungDo(),2));
    }

    /**
     * @return the hoanhDo
     */
    public double getHoanhDo() {
        return hoanhDo;
    }

    /**
     * @param hoanhDo the hoanhDo to set
     */
    public void setHoanhDo(double hoanhDo) {
        this.hoanhDo = hoanhDo;
    }

    /**
     * @return the tungDo
     */
    public double getTungDo() {
        return tungDo;
    }

    /**
     * @param tungDo the tungDo to set
     */
    public void setTungDo(double tungDo) {
        this.tungDo = tungDo;
    }
}
