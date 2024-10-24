/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alghoritms;
import java.awt.Graphics2D;
import java.awt.Color;

/**
 *
 * @author azad
 */
public class PixelbyPixelLine {
    
    //first coordinates when i clicked
    public int x,y;
    // second coordinates when i up mouse
    public int x2,y2;
    
    public PixelbyPixelLine(int x, int y, int x2, int y2){
        this.x = x;
        this.y = y;
        this.x2 = x2;
        this.y2 = y2;
    }
        
    public static void drawLine(int x1, int y1, int x2, int y2, Graphics2D g2d, Color color){
        final int dx = Math.abs(x2 - x1);
        final int dy = Math.abs(y2 - y1);
        
        final double m = (double) (y2 - y1) / (x2 - x1);
        int inc = 1;
        
        int x = x1;
        int y = y1;

        if(dx > dy){
            if(x2 < x1)
                inc = -1;

            while(x != x2){
                y = (int) (m * (x - x1) + y1);
                g2d.drawLine(x, y, x2, y2);

                x += inc;
            } 
        }
        else {
            if(y2 < y1)
                inc = -1;
            
                while(y != y2){
                    x = (int) ((y - y1) / m + x1);
                    g2d.drawLine(x, y, x2, y2);
                    y += inc;
                } 
        }
    }


} 
      
    


