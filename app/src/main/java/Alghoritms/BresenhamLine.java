/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Alghoritms;

import java.awt.Color;
import java.awt.Graphics2D;
import javax.swing.JTextField;

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
    
    public BresenhamLine(){
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
    
      public void drawBresenhamLine(Graphics2D g2d, Color color) {
        int dx = Math.abs(x2 - x1);
        int dy = Math.abs(y2 - y1);
        int sx = (x1 < x2) ? 1 : -1;
        int sy = (y1 < y2) ? 1 : -1;
        int err = dx - dy;

        g2d.setColor(color); // Define a cor da linha

        while (true) {
            g2d.drawLine(x1, y1, x1, y1); // Desenha o ponto na posição atual
            if (x1 == x2 && y1 == y2) break;
            int err2 = err * 2;
            if (err2 > -dy) {
                err -= dy;
                x1 += sx;
            }
            if (err2 < dx) {
                err += dx;
                y1 += sy;
            }
        }
      }
            // Escala local
    public void scale(double sx, double sy, double sz) {
        int centerX = (x1 + x2) / 2;
        int centerY = (y1 + y2) / 2;
        x1 = (int) (centerX + (x1 - centerX) * sx);
        y1 = (int) (centerY + (y1 - centerY) * sy);
        x2 = (int) (centerX + (x2 - centerX) * sx);
        y2 = (int) (centerY + (y2 - centerY) * sy);
    }

    // Escala global
    public void globalScale(double sx, double sy, double sz) {
        x1 = (int) (x1 * sx);
        y1 = (int) (y1 * sy);
        x2 = (int) (x2 * sx);
        y2 = (int) (y2 * sy);
    }

    // Translação
    public void translate(double tx, double ty, double tz) {
        x1 += tx;
        y1 += ty;
        x2 += tx;
        y2 += ty;
    }

    // Rotação
    public void rotate(String axis, double degrees) {
        double radians = Math.toRadians(degrees);
        double cosTheta = Math.cos(radians);
        double sinTheta = Math.sin(radians);
        
        // Centro da linha
        int centerX = (x1 + x2) / 2;
        int centerY = (y1 + y2) / 2;

        // Transforma as coordenadas para o centro da linha
        int tempX1 = x1 - centerX;
        int tempY1 = y1 - centerY;
        int tempX2 = x2 - centerX;
        int tempY2 = y2 - centerY;

        if (axis.equals("X")) {
            // Rotação em torno do eixo X não afeta 2D
            // Para efeitos de visualização 2D, não aplicamos a rotação ao eixo X
        } else if (axis.equals("Y")) {
            // Rotação em torno do eixo Y não afeta 2D
            // Para efeitos de visualização 2D, não aplicamos a rotação ao eixo Y
        } else if (axis.equals("Z")) {
            // Rotação em torno do eixo Z
            x1 = (int) (centerX + (tempX1 * cosTheta - tempY1 * sinTheta));
            y1 = (int) (centerY + (tempX1 * sinTheta + tempY1 * cosTheta));
            x2 = (int) (centerX + (tempX2 * cosTheta - tempY2 * sinTheta));
            y2 = (int) (centerY + (tempX2 * sinTheta + tempY2 * cosTheta));
        }
    }

    // Cisalhamento
    public void shear(JTextField[][] shearingFields) {
        double shearX = Double.parseDouble(shearingFields[0][1].getText());
        double shearY = Double.parseDouble(shearingFields[1][0].getText());

        int tempX1 = (int) (x1 + shearX * y1);
        int tempY1 = (int) (y1 + shearY * x1);
        int tempX2 = (int) (x2 + shearX * y2);
        int tempY2 = (int) (y2 + shearY * x2);
        
        x1 = tempX1;
        y1 = tempY1;
        x2 = tempX2;
        y2 = tempY2;
    }
}
        
        
        

        
        
        
    
    


