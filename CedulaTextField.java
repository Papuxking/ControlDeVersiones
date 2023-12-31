import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;

public class CedulaTextField extends JTextField {

    public CedulaTextField() {
        // Configurar el filtro para permitir solo números
        ((AbstractDocument) getDocument()).setDocumentFilter(new NumberOnlyFilter());
    }

    // Filtro para permitir solo números
    private class NumberOnlyFilter extends DocumentFilter {
        @Override
        public void insertString(FilterBypass fb, int offset, String string, AttributeSet attr)
                throws BadLocationException {
            if (string.matches("\\d+")) {
                super.insertString(fb, offset, string, attr);
            }
        }

        @Override
        public void replace(FilterBypass fb, int offset, int length, String text, AttributeSet attrs)
                throws BadLocationException {
            if (text.matches("\\d+")) {
                super.replace(fb, offset, length, text, attrs);
            }
        }
    }

    // Método para validar la cédula
    public boolean validarCedula() {
        String cedula = getText();

        // Preguntamos si la cédula consta de 10 dígitos
        if (cedula.length() == 10) {
            // Obtenemos el dígito de la región que son los dos primeros dígitos
            int digitoRegion = Integer.parseInt(cedula.substring(0, 2));

            // Preguntamos si la región existe (Ecuador se divide en 24 regiones)
            if (digitoRegion >= 1 && digitoRegion <= 24) {
                // Extraemos el último dígito
                int ultimoDigito = Integer.parseInt(cedula.substring(9));

                // Agrupamos todos los pares y los sumamos
                int pares = Character.getNumericValue(cedula.charAt(1)) +
                        Character.getNumericValue(cedula.charAt(3)) +
                        Character.getNumericValue(cedula.charAt(5)) +
                        Character.getNumericValue(cedula.charAt(7));

                // Agrupamos los impares, los multiplicamos por un factor de 2,
                // si la resultante es > que 9 le restamos 9 a la resultante
                int impares = 0;
                for (int i = 0; i < 9; i += 2) {
                    int numero = Character.getNumericValue(cedula.charAt(i)) * 2;
                    impares += (numero > 9) ? numero - 9 : numero;
                }

                // Suma total
                int sumaTotal = pares + impares;

                // Extraemos el primer dígito
                int primerDigitoSuma = Character.getNumericValue(Integer.toString(sumaTotal).charAt(0));

                // Obtenemos la decena inmediata
                int decena = (primerDigitoSuma + 1) * 10;

                // Obtenemos la resta de la decena inmediata - la sumaTotal
                // Esto nos da el dígito validador
                int digitoValidador = decena - sumaTotal;

                // Si el dígito validador es igual a 10, toma el valor de 0
                if (digitoValidador == 10) {
                    digitoValidador = 0;
                }

                // Validamos que el dígito validador sea igual al último dígito de la cédula
                return digitoValidador == ultimoDigito;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("CedulaTextField Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            CedulaTextField cedulaTextField = new CedulaTextField();
            JButton validarButton = new JButton("Validar");

            validarButton.addActionListener(e -> {
                if (cedulaTextField.validarCedula()) {
                    JOptionPane.showMessageDialog(frame, "La cédula es válida.");
                } else {
                    JOptionPane.showMessageDialog(frame, "La cédula no es válida.");
                }
            });

            frame.setLayout(new FlowLayout());
            frame.add(cedulaTextField);
            frame.add(validarButton);

            frame.setSize(300, 100);
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}