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
public class ParametricEllipse {
      private int x,y;
      
      
      public ParametricEllipse(int x, int y){
          this.x = x;
          this.y =y;
      }
      
      public void drawParametricEllipse(int x, int y, int r, Graphics2D g2d, Color color){
          double circum = 6.28;
          double a = 0;
          while(a != circum){
              x = (int) (r * Math.cos(a));
              y = (int) (r * Math.cos(a));
              g2d.draw(new Ellipse2D.Double(x, y, 1, 1));
              
          }
          
      }
}
