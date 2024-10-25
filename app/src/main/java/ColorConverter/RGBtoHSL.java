/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColorConverter;

/**
 *
 * @author Daza_
 */
public class RGBtoHSL extends ColorConverter{
     public static float[] rgbToHsl(int r, int g, int b) {
        float rNorm = r / 255.0f;
        float gNorm = g / 255.0f;
        float bNorm = b / 255.0f;

        float max = Math.max(rNorm, Math.max(gNorm, bNorm));
        float min = Math.min(rNorm, Math.min(gNorm, bNorm));
        float h, s, l = (max + min) / 2.0f;

        float diff = max - min;

        if (diff == 0) {
            h = s = 0; // Acromático
        } else {
            s = (l < 0.5f) ? diff / (max + min) : diff / (2.0f - max - min);

            if (max == rNorm) {
                h = 60 * ((gNorm - bNorm) / diff + (gNorm < bNorm ? 6 : 0));
            } else if (max == gNorm) {
                h = 60 * ((bNorm - rNorm) / diff + 2);
            } else {
                h = 60 * ((rNorm - gNorm) / diff + 4);
            }
        }

        return new float[]{h, s * 100, l * 100}; // return hsl
    }
}
