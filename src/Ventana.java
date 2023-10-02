import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel principal;
    private JTextField textNumero;
    private JButton btnInsertar;
    private JButton btnEliminar;
    private JButton btnConsultar;
    private JButton btnListar;
    private JTextArea txtListarElementos;
    private Pila coleccion=new Pila();

    public Ventana() {

        btnInsertar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                coleccion.insertar(Integer.parseInt(textNumero.getText()));
                JOptionPane.showMessageDialog(null,"Insertado correctamente");
            }
        });

        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null,"Eliminado"+coleccion.eliminar());
                } catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }
            }
        });

        btnConsultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(null,"cima"+coleccion.consultarTope());
                }catch (Exception ex){
                    JOptionPane.showMessageDialog(null,ex.getMessage());
                }

            }
        });

        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtListarElementos.setText(coleccion.toString());
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
