    /*
     * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
     * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
     */
    package CGPaintForm;

    import javax.swing.*;
    import java.awt.*;
    import java.awt.event.ActionEvent;
    import java.awt.event.ActionListener;

public class Projecao3D2D extends JFrame {
    private final double[][] points;
    private final JTextField scaleXField;
    private final JTextField scaleYField, scaleZField;
    private final JTextField translationXField, translationYField, translationZField;
    private final JTextField degreesField;
    private final JComboBox<String> axisComboBox;
    private final JTextField[][] shearingFields;
    private final JRadioButton originRotation, objectRotation;
    private final JPanel drawingPanel;
    
    public Projecao3D2D() {
        // pre defined matrix
        points = new double[][]{
            {50, 150, 0, 1},
            {50, 150, 100, 1},
            {50, 150, 0, 1},
            {0, 100, 0, 1},
            {50, 150, 0, 1},
            {100, 100, 0, 1},
            {50, 150, 100, 1},
            {0, 100, 100, 1},
            {50, 150, 100, 1},
            {100, 100, 100, 1},
            {0, 100, 0, 1},
            {0, 100, 100, 1},
            {0, 100, 0, 1},
            {0, 0, 0, 1},
            {100, 100, 0, 1},
            {100, 100, 100, 1},
            {100, 100, 0, 1},
            {100, 0, 0, 1},
            {0, 100, 100, 1},
            {0, 0, 100, 1},
            {100, 100, 100, 1},
            {100, 0, 100, 1},
            {0, 0, 0, 1},
            {100, 0, 0, 1},
            {100, 0, 0, 1},
            {100, 0, 100, 1},
            {0, 0, 100, 1},
            {0, 0, 0, 1},
            {0, 0, 100, 1},
            {100, 0, 100, 1}
        };

        //windows config
        setTitle("Projeção 3D para 2D");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // draw panel
        drawingPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2d = (Graphics2D) g;
                drawPoints(g2d); // Desenha os pontos transformados
            }
        };
        drawingPanel.setPreferredSize(new Dimension(400, 400));
        drawingPanel.setBackground(Color.WHITE);
        drawingPanel.setBorder(BorderFactory.createTitledBorder("Visualização 3D"));
        add(drawingPanel, BorderLayout.CENTER);

        // control panel
        JPanel controlPanel = new JPanel();
        controlPanel.setLayout(new BoxLayout(controlPanel, BoxLayout.Y_AXIS));
        controlPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        add(controlPanel, BorderLayout.EAST);

        // escale section
        JPanel scalePanel = new JPanel(new GridLayout(2, 1, 5, 5));
        scalePanel.setBorder(BorderFactory.createTitledBorder("Escala"));
        ButtonGroup scaleGroup = new ButtonGroup();
        JRadioButton localScale = new JRadioButton("Local");
        JRadioButton globalScale = new JRadioButton("Global");
        scaleGroup.add(localScale);
        scaleGroup.add(globalScale);
        localScale.setSelected(true);
        scalePanel.add(localScale);
        scalePanel.add(globalScale);

        // x y z global field
        JPanel scaleLocalPanel = new JPanel(new GridLayout(1, 3, 5, 5));
        scaleXField = new JTextField("1"); // Criando o campo de escala X
        scaleYField = new JTextField("1"); // Criando o campo de escala Y
        scaleZField = new JTextField("1"); // Criando o campo de escala Z
        scaleLocalPanel.add(new JLabel("X:"));
        scaleLocalPanel.add(scaleXField);
        scaleLocalPanel.add(new JLabel("Y:"));
        scaleLocalPanel.add(scaleYField);
        scaleLocalPanel.add(new JLabel("Z:"));
        scaleLocalPanel.add(scaleZField);
        controlPanel.add(scalePanel);
        controlPanel.add(scaleLocalPanel);

        // translation setion
        JPanel translationPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        translationPanel.setBorder(BorderFactory.createTitledBorder("Translação"));
        translationXField = new JTextField("0"); // Campo de translação X
        translationYField = new JTextField("0"); // Campo de translação Y
        translationZField = new JTextField("0"); // Campo de translação Z
        translationPanel.add(new JLabel("X:"));
        translationPanel.add(translationXField);
        translationPanel.add(new JLabel("Y:"));
        translationPanel.add(translationYField);
        translationPanel.add(new JLabel("Z:"));
        translationPanel.add(translationZField);
        controlPanel.add(translationPanel);

        // rotation setion
        JPanel rotationPanel = new JPanel(new GridLayout(3, 2, 5, 5));
        rotationPanel.setBorder(BorderFactory.createTitledBorder("Rotação"));
        ButtonGroup rotationGroup = new ButtonGroup();
        originRotation = new JRadioButton("Origem");
        objectRotation = new JRadioButton("Centro do Objeto");
        rotationGroup.add(originRotation);
        rotationGroup.add(objectRotation);
        originRotation.setSelected(true);
        rotationPanel.add(originRotation);
        rotationPanel.add(objectRotation);

        // Shafts and degrees
        JPanel rotationAxisPanel = new JPanel(new GridLayout(1, 2, 5, 5));
        axisComboBox = new JComboBox<>(new String[]{"X", "Y", "Z"});
        degreesField = new JTextField("0");
        rotationAxisPanel.add(new JLabel("Eixo:"));
        rotationAxisPanel.add(axisComboBox);
        rotationAxisPanel.add(new JLabel("Graus:"));
        rotationAxisPanel.add(degreesField);
        controlPanel.add(rotationPanel);
        controlPanel.add(rotationAxisPanel);

        // shearing setion
        JPanel shearingPanel = new JPanel(new GridLayout(4, 4, 5, 5));
        shearingPanel.setBorder(BorderFactory.createTitledBorder("Shearing (Cisalhamento)"));
        shearingFields = new JTextField[4][4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                shearingFields[i][j] = new JTextField("0", 5);
                shearingFields[i][j].setPreferredSize(new Dimension(50, 30));
                shearingPanel.add(shearingFields[i][j]);
            }
        }
        controlPanel.add(shearingPanel);

        // execute button
        JButton executeButton = new JButton("EXECUTAR");
        executeButton.setPreferredSize(new Dimension(100, 40));
        executeButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        controlPanel.add(executeButton);

        // button execut action
        executeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                applyTransformations(); // aply transformation
                drawingPanel.repaint(); // redraw panel
            }
        });

        setVisible(true);
    }

        private void drawPoints(Graphics2D g) {
            // scale factor
            double scaleFactor = 1.0;

            // central coordenates calc
            int centerX = getWidth() / 2;
            int centerY = getHeight() / 2;

            g.setColor(Color.BLUE);

            // draw lines in the points
            for (int i = 0; i < points.length - 1; i++) {
                int x1 = (int) (points[i][0] * scaleFactor) + centerX; // Centraliza na tela
                int y1 = centerY - (int) (points[i][1] * scaleFactor); // Inverte Y para ficar correto
                int x2 = (int) (points[i + 1][0] * scaleFactor) + centerX;
                int y2 = centerY - (int) (points[i + 1][1] * scaleFactor);
                g.drawLine(x1, y1, x2, y2); // Desenha a linha entre os pontos
            }
        }

        private void applyTransformations() {
        // escale values
            double scaleX = Double.parseDouble(scaleXField.getText());
            double scaleY = Double.parseDouble(scaleYField.getText());
            double scaleZ = Double.parseDouble(scaleZField.getText());

        // translation values
            double translateX = Double.parseDouble(translationXField.getText());
            double translateY = Double.parseDouble(translationYField.getText());
            double translateZ = Double.parseDouble(translationZField.getText());
        // rotation values
            double degrees = Math.toRadians(Double.parseDouble(degreesField.getText())); // Converte para radianos
            String axis = (String) axisComboBox.getSelectedItem();

        // shearing values
            double[][] shearingMatrix = new double[4][4];
                for (int i = 0; i < 4; i++) {
                    for (int j = 0; j < 4; j++) {
                //if 0 values keep draw
                        if (i == j) {
                        shearingMatrix[i][j] = 1;
                    }else {
                        shearingMatrix[i][j] = Double.parseDouble(shearingFields[i][j].getText());
                    }
                }
            }

        // matrix 4x4
            double[][] transformationMatrix = {
                {1, 0, 0, 0},
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
        };

        // aply scale
            double[][] scaleMatrix = {
            {scaleX, 0, 0, 0},
            {0, scaleY, 0, 0},
            {0, 0, scaleZ, 0},
            {0, 0, 0, 1}
        };
        transformationMatrix = multiplyMatrix(transformationMatrix, scaleMatrix);

        // aply translation
        double[][] translationMatrix = {
            {1, 0, 0, translateX},
            {0, 1, 0, translateY},
            {0, 0, 1, translateZ},
            {0, 0, 0, 1}
        };
        transformationMatrix = multiplyMatrix(transformationMatrix, translationMatrix);

    // aply rotation
        double[][] rotationMatrix = getRotationMatrix(axis, degrees);
        transformationMatrix = multiplyMatrix(transformationMatrix, rotationMatrix);

    // aply shearing
        transformationMatrix = multiplyMatrix(transformationMatrix, shearingMatrix);

    // aply transformation matrix in all points
        for (int i = 0; i < points.length; i++) {
            points[i] = multiplyMatrixVector(transformationMatrix, points[i]);
        }
    }

        private double[][] getRotationMatrix(String axis, double angle) {
            double[][] rotationMatrix;
            switch (axis) {
        case "X":
                rotationMatrix = new double[][] {
                {1, 0, 0, 0},
                {0, Math.cos(angle), -Math.sin(angle), 0},
                {0, Math.sin(angle), Math.cos(angle), 0},
                {0, 0, 0, 1}
                };
            break;
        case "Y":
            rotationMatrix = new double[][] {
                {Math.cos(angle), 0, Math.sin(angle), 0},
                {0, 1, 0, 0},
                {-Math.sin(angle), 0, Math.cos(angle), 0},
                {0, 0, 0, 1}
            };
            break;
        case "Z":
            rotationMatrix = new double[][] {
                {Math.cos(angle), -Math.sin(angle), 0, 0},
                {Math.sin(angle), Math.cos(angle), 0, 0},
                {0, 0, 1, 0},
                {0, 0, 0, 1}
            };
            break;
        default:
            throw new IllegalArgumentException("Eixo inválido");
    }
    return rotationMatrix;
}

    // multiply two 4x4 matrix
        private double[][] multiplyMatrix(double[][] m1, double[][] m2) {
            double[][] result = new double[4][4];
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < 4; j++) {
                result[i][j] = 0;
                    for (int k = 0; k < 4; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        return result;
    }

    // multiply 4x4 matrix by a vector
        private double[] multiplyMatrixVector(double[][] matrix, double[] vector) {
            double[] result = new double[4];
            for (int i = 0; i < 4; i++) {
                result[i] = 0;
            for (int j = 0; j < 4; j++) {
                result[i] += matrix[i][j] * vector[j];
            }
        }
        return result;
    }

}

