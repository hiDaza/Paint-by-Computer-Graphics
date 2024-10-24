/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alghoritms;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author Daza_
 */
public class ParametricLine {
    float t = 0; 
    int x1,y1;
    int x2,y2;
    
    public ParametricLine(int x1, int y1, int x2, int y2){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        
    }
    
    public void drawParametric(int x1, int y1, int x2, int y2,Graphics2D g2d, Color color){
       
       while(t < 1) { 
            int x = (int) (x1 + t * (x2 - x1));  
            int y = (int) (y1 + t * (y2 - y1));
            g2d.drawLine(x, y, x, y);  // draw point
            t += 0.01; 
           
           
        }
    }
    
}
