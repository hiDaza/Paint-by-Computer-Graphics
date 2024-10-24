/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alghoritms;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import org.checkerframework.checker.units.qual.t;

/**
 *
 * @author Daza_
 */
public class ParametricEllipse {
      private int x,y;
      
      
      public ParametricEllipse(int x, int y){
          this.x = x;
          this.y =y;
      }
      
      public void drawParametricEllipse(int x, int y,int x1,int y1, int r, Graphics2D g2d, Color color){
         double inc = 0.01;
         double circum = Math.PI * 2;
         double t;
         for(t = 0; t <= circum; t += inc){
          int xf = (int) (r * Math.cos(t));
          int yf = (int) (r * Math.sin(t));     
          
          g2d.draw(new Ellipse2D.Double(x + xf,y + yf,1,1));
                }
       }
}
