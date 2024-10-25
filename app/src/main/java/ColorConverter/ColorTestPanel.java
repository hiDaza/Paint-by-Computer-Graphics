/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ColorConverter;

/**
 *
 * @author Daza_
 */







import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorTestPanel extends JPanel {
    private JLabel rgbLabel;
    private JLabel hslLabel;
    private JButton chooseColorButton;

    public ColorTestPanel() {
        setLayout(new BorderLayout());

        chooseColorButton = new JButton("Escolha uma cor");
        chooseColorButton.addActionListener(new ColorChooserListener());
        add(chooseColorButton, BorderLayout.NORTH);

        rgbLabel = new JLabel("RGB: ");
        hslLabel = new JLabel("HSL: ");
        JPanel labelsPanel = new JPanel();
        labelsPanel.add(rgbLabel);
        labelsPanel.add(hslLabel);
        add(labelsPanel, BorderLayout.CENTER);
    }

    private class ColorChooserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Usando JColorChooser.showDialog para abrir um diálogo de seleção de cor
            Color chosenColor = JColorChooser.showDialog(ColorTestPanel.this, "Escolha uma cor", Color.WHITE);

            if (chosenColor != null) {
                int r = chosenColor.getRed();
                int g = chosenColor.getGreen();
                int b = chosenColor.getBlue();

                // Convertendo RGB para HSL
                float[] hsl = RGBtoHSL.rgbToHsl(r, g, b);

                // Atualizando os rótulos com os valores RGB e HSL
                rgbLabel.setText(String.format("RGB: (%d, %d, %d)", r, g, b));
                hslLabel.setText(String.format("HSL: (%.2f, %.2f, %.2f)", hsl[0], hsl[1], hsl[2]));
            }
        }
    }

    public static void createAndShowGUI() {
          JFrame frame = new JFrame("Color Test Panel");
          frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Muda para DISPOSE_ON_CLOSE
          frame.setSize(400, 200);
          frame.add(new ColorTestPanel());
          frame.setVisible(true);
    }
}




