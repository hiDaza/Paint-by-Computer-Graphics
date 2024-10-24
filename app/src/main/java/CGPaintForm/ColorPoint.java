/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CGPaintForm;

import java.awt.Color;

/**
 *
 * @author Daza_
 */
public class ColorPoint {
    private Color color; 
    private int x,y;
    
    public ColorPoint(int x, int y,Color color){
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    
}
