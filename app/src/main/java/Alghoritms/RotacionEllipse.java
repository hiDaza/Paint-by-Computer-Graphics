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
// sin cos with symetri;

public class RotacionEllipse {
    int x,y;
    
    
    public RotacionEllipse(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public void drawRotacionEllipse(int x, int y,double r, int x1, int y1, Graphics2D g2d, Color color){
        double xc =  r;
        double yc = 0;
        
        double angle = Math.toRadians(1);
        double cos = Math.cos(angle);
        double sin = Math.sin(angle);
       
        
        for(int i = 1; i <= 360; i++){         
            g2d.draw(new Ellipse2D.Double(x1 + xc, y1 + yc,1,1));
            double tempX = xc * cos - yc * sin;
            yc = xc * sin + yc * cos;
            xc = tempX;
        }
        
    }
    
}
