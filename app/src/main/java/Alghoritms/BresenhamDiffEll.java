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
public class BresenhamDiffEll {
    
    public BresenhamDiffEll(){
    }
    
    public void drawBresenhamDiff(int x, int y, int r, Graphics2D g2d, Color color){
        int xc = 0; 
        int yc = r;
        int h = 1 - r;
        
        drawOctan(x,y,xc,yc,g2d,color);
        
        while(xc < yc){
            if(h < 0){
                //choose E
                h = h + 2 * xc + 3;
                xc += 1;
            }else{
                //choose SE
                h = h + 2 * (xc - yc) + 5;
                xc += 1;
                yc += -1;
            }
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
