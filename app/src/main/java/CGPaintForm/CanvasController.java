/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package CGPaintForm;
import Alghoritms.BresenhamDiffEll;
import Alghoritms.BresenhamEllipse;
import Alghoritms.BresenhamLine;
import Alghoritms.ParametricEllipse;
import Alghoritms.ParametricLine;
import Alghoritms.PixelbyPixelLine;
import Alghoritms.RadiusEllipse;
import Alghoritms.RotacionEllipse;
import java.awt.BasicStroke;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.List;
import javax.swing.JPanel;


/**
 *
 * @author Daza_
 */
public class CanvasController extends JPanel{
  
   private int opt;
   private List<ColorPoint> currentPath; // for line
   //ALL PATHS
   private List<List<ColorPoint>> allPaths;

   private Color color; //colour 

   public CanvasController(){
       this.opt = 0;
   }

    public void setOpt(int option){
        this.opt = option;
        
    }
    
   
    public void factoryLine(int option, int x, int y, int x1, int y1, Graphics2D g2d, Color color,Canvas canvas2, int sizeLine){
                  g2d.setStroke(new BasicStroke(sizeLine));  
                  Graphics2D g = (Graphics2D) canvas2.getGraphics();
                  g.clearRect(0, 0, canvas2.getWidth(), canvas2.getHeight());
        switch(option){
            case 2:              
                   PixelbyPixelLine drawLine = new PixelbyPixelLine(x1,y1,x,y); 
                   drawLine.drawLine(x1, y1, x, y, g2d, color);
                   g2d.dispose();
                break;
            case 3:
                   ParametricLine drawLineParametric = new ParametricLine(x1,y1,x,y); 
                   drawLineParametric.drawParametric(x1, y1, x, y, g2d, color);
                   g2d.dispose();
                break;
            case 4:
                   BresenhamLine drawLineBresenham = new BresenhamLine(x1,y1,x,y); 
                   
                   drawLineBresenham.drawBresenhamLine(x1, y1, x, y, g2d, color);
                   g2d.dispose();
                   break;
            default:
                break;
                
        }
    }
    
   public void factoryCircum(int option, int x, int y, int x1, int y1,Graphics2D g2d, Color color, Canvas canvas2,int sizeLine){
                  g2d.setStroke(new BasicStroke(sizeLine));  
                  Graphics2D g = (Graphics2D) canvas2.getGraphics();
                  g.clearRect(0, 0, canvas2.getWidth(), canvas2.getHeight());
                  double r;
                  
        switch(option){
            case 5:
                   r = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));                
                   RadiusEllipse drawEllipseRadius = new RadiusEllipse(x,y);
                   drawEllipseRadius.drawRadiusEllipse(x,y,Math.toIntExact(Math.round(r)),g2d,color);
                   g2d.dispose();
                break;
            case 6:
                  r = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
                  ParametricEllipse drawEllipseParametric = new ParametricEllipse(x,y);
                  drawEllipseParametric.drawParametricEllipse(x1, y1, x, y, Math.toIntExact(Math.round(r)), g2d, color);
                  g2d.dispose();
                break;
            case 7: 
                  r = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
                  RotacionEllipse drawRotacionEllipse = new RotacionEllipse(x,y);
                  drawRotacionEllipse.drawRotacionEllipse(x1, y1, r, x, y, g2d, color);           
                  g2d.dispose();
                break;
            case 8:
                  r = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1)); 
                  BresenhamEllipse drawBresenhamEllipse = new BresenhamEllipse();
                  drawBresenhamEllipse.drawBresenhamEllipse(x1,y1, (int) r, g2d, color);
                  g2d.dispose();
                break;
            case 9:
                  r = Math.sqrt((x-x1)*(x-x1) + (y-y1)*(y-y1));
                  BresenhamDiffEll drawBresenhamDiffEll = new BresenhamDiffEll();
                  drawBresenhamDiffEll.drawBresenhamDiff(x1, y1, (int) r, g2d, color);
                  g2d.dispose();
                  break;
                 } 
            
   }
   
 }



