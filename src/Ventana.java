import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ventana {
    private JPanel Principal;
    private JTabbedPane tabbedPane1;
    private JTextField codigoField;
    private JComboBox cboMarca;
    private JTextField ipField;
    private JTextField precioField;
    private JTextArea dispositivosTxt;
    private JButton ingresarDispositivoButton;
    private JButton btnListar;
    private JList noDuplicadosJList;
    private JComboBox cboMarca1;
    private JButton btnSumar;
    private JTextArea txtSuma;
    Lista lista=new Lista();
    public void llenarJlist(){
        DefaultListModel dlm=new DefaultListModel<>();
        for (PuntoAcceso p: lista.listaOrdenada()){
                dlm.addElement(p.toString());
        }
        noDuplicadosJList.setModel(dlm);
    }
    public Ventana(){

        ingresarDispositivoButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int codigo= Integer.parseInt(codigoField.getText().toString());
                String marca= cboMarca.getSelectedItem().toString();
                String ip= ipField.getText().toString();
                float precio= Float.parseFloat(precioField.getText().toString());
                PuntoAcceso pa= new PuntoAcceso(codigo, marca, ip, precio);
                lista.agregarDispositivo(pa);
                dispositivosTxt.setText(lista.listaDispositivos.toString());
            }
        });
        btnListar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                llenarJlist();
            }
        });
        btnSumar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String marca= cboMarca1.getSelectedItem().toString();
                float suma=lista.sumatoria(marca);
                txtSuma.setText("El resultado de la suma de dispositivos con la marca "+marca+ "es: "+suma);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Ventana");
        frame.setContentPane(new Ventana().Principal);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
