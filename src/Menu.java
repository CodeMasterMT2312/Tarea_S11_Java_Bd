import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JFrame {
    private JButton Ingreso;
    private JButton VisualizarBoton;
    private JButton BusquedaButton;
    private JPanel MenuPanel;

    public Menu(){
        super("Menu");
        setContentPane(MenuPanel);

        Ingreso.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Ingreso ing=new Ingreso();
                ing.iniciar();
                dispose(); //Cierra la ventana actual al abrir la de ingreso de datos
            }
        });
        VisualizarBoton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Visualizar vis = new Visualizar();
                vis.iniciar();
                dispose();
            }
        });
        BusquedaButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Busqueda busq= new Busqueda();
                busq.iniciar();
                dispose(); //Cierra la ventana actual al abrir la de búsqueda
            }
        });
    }
    public void iniciar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(350, 200);
        setVisible(true);
    }
}
