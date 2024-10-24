/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alghoritms;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

/**
 *
 * @author gerson.lucas_unesp
 */
public class RotacionEllipse {
    int x,y;
    
    
    public RotacionEllipse(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void drawRotacionEllipse(int x, int y,double r, int x1, int y1, Graphics2D g2d, Color color){
        int xc = (int) r;
        int yc = 0;
        
        double cos = Math.cos(1);
        double sin = Math.sin(1);
        
        for(int i = 0; i <= 360; i++){
            double tempx = xc * cos - yc * sin;
            double tempy = x * sin + y * cos;
            xc = Math.toIntExact((long) tempx);
            yc = Math.toIntExact((long) tempy);
            g2d.draw(new Ellipse2D.Double(x1 + xc, y1 + yc,1,1));
        }
        
    }
    
}
