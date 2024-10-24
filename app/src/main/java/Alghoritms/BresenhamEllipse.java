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
 * @author Daza_
 */
public class BresenhamEllipse {

    
    public BresenhamEllipse(){
     }
    
   
 
    
    public void drawBresenhamEllipse(int x, int y, int r, Graphics2D g2d, Color color){
        int xc = 0;
        int yc = (int) r;
        int h = 1 - r;
        int dE = 3;
        int dSE = -2 * r + 5;
        
        drawOctan(x,y,xc,yc,g2d,color);     
        while(xc < yc){
            if(h < 0){
                //choose E
                h += dE;
                dE += 2;
                dSE += 2;
            }
            else{
                //choose SE
                h += dSE;
                dE += 2;
                dSE += 4;
                yc += -1;
            }
            xc += 1;
            drawOctan(x,y,xc,yc,g2d,color);
            
        }
    }
   
    public static void drawOctan(int x, int y, int xc, int yc, Graphics2D g2d, Color color){
        g2d.draw(new Ellipse2D.Double(x + yc,y + xc,1,1));
        g2d.draw(new Ellipse2D.Double(x + xc,y + yc,1,1));
        g2d.draw(new Ellipse2D.Double(x - xc,y + yc,1,1));
        g2d.draw(new Ellipse2D.Double(x - yc,y + xc,1,1));
        g2d.draw(new Ellipse2D.Double(x - yc,y - xc,1,1));
        g2d.draw(new Ellipse2D.Double(x - xc,y - yc,1,1));
        g2d.draw(new Ellipse2D.Double(x + xc,y - yc,1,1));
        g2d.draw(new Ellipse2D.Double(x + yc,y - xc,1,1));
    }

    
        
}


