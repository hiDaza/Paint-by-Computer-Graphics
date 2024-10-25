/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColorConverter;

/**
 *
 * @author Daza_
 */
public class HSLtoRGB extends ColorConverter{
      public static int[] hslToRgb(float h, float s, float l) {
        float r, g, b;

        float sNorm = s / 100;
        float lNorm = l / 100;

        if (sNorm == 0) {
            r = g = b = lNorm; // Acromático
        } else {
            float q = lNorm < 0.5 ? lNorm * (1 + sNorm) : lNorm + sNorm - (lNorm * sNorm);
            float p = 2 * lNorm - q;

            r = hueToRgb(p, q, h + 120);
            g = hueToRgb(p, q, h);
            b = hueToRgb(p, q, h - 120);
        }

        return new int[]{(int) (r * 255), (int) (g * 255), (int) (b * 255)};
    }

    private static float hueToRgb(float p, float q, float t) {
        if (t < 0) t += 360;
        if (t > 360) t -= 360;

        if (t < 60) return p + (q - p) * t / 60;
        if (t < 180) return q;
        if (t < 240) return p + (q - p) * (240 - t) / 60;
        return p;
    }
}
