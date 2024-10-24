/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alghoritms;

import java.awt.Color;
import java.awt.Graphics2D;

/**
 *
 * @author gerson.lucas_unesp
 */
public class BresenhamLine {
    private int x1, y1, x2, y2;
    
    
    public BresenhamLine(int x1, int y1, int x2, int y2){
        this.x1 = x1; 
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
    }
    
    public void drawBresenhamLine(int x1, int y1, int x2, int y2, Graphics2D g2d ,Color color){
        int dx = Math.abs(x2 - x1); 
        int dy = Math.abs(y2 - y1); 
        int d = 2 * dy - dx;
        int dE = 2 * dy;
        int dNE = 2 * (dy - dx);
        int dN = (-dx)*2;
        int x = x1;
        int y = y1;
        

        int incX = 0;
        int incY = 0;
        g2d.drawLine(x, y, x, y);
    
        if(x < x2){
            incX = 1;
        }else{
            incX = -1;
        }
        if(y < y2){
            incY = 1;
        }else{
            incY = -1;
        }
   
        
     if(dx > dy){
         while(x != x2){
            if(d < 0){
                d += dE;
                x += incX;
            }else{
                d += dNE;
                x += incX;
                y += incY;
            }
         g2d.drawLine(x, y, x, y);
        }
      }else{
         d = 2 * (dy -dx);
         while(y != y2){
             if(d < 0){
                d += dNE;
                x += incX;
                y += incY;
             }else{
                d += dN;
                y += incY;
             }
             g2d.drawLine(x, y, x, y);
         }
     }
    }
        
        
        
    }
    


