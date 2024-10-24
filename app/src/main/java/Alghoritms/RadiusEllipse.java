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
public class RadiusEllipse {
    private int x,y;

    public RadiusEllipse(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public RadiusEllipse(){}

    public void drawRadiusEllipse(int x, int y,int r, Graphics2D g2d, Color color) {
        g2d.setColor(color);
        int xc, yc;
        
        for (xc = -r; xc <= r; xc++) {
            double a = Math.sqrt((r * r) - (xc * xc));
            yc = (int) Math.round(a);

            // Desenha os pontos da circunferência nos octantes
            g2d.draw(new Ellipse2D.Double(x + xc, y + yc, 1, 1));
            g2d.draw(new Ellipse2D.Double(x + xc, y - yc, 1, 1));
            g2d.draw(new Ellipse2D.Double(x - xc, y + yc, 1, 1));
            g2d.draw(new Ellipse2D.Double(x - xc, y - yc, 1, 1));
        }
    }
}
