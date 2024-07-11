import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Busqueda extends JFrame {
    private JButton regresarButton;
    private JTextField MatriculaNum;
    private JTextArea BusquedaVer;
    private JPanel BusquedaPanel;
    private JButton buscarButton;

    public Busqueda() {
        super("Busqueda Registro");
        setContentPane(BusquedaPanel);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu ADmen = new Menu();
                ADmen.iniciar();
                dispose();
            }
        });
        buscarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String URL = "jdbc:mysql://localhost:3306/curso"; // Nombre de la base de datos
                    String userDB = "root";
                    String password = "123456";

                    Connection conn = DriverManager.getConnection(URL, userDB, password);
                    String query = "SELECT * FROM estudiantes WHERE codigo_matricula=?;";
                    PreparedStatement search = conn.prepareStatement(query);
                    String numMatricula = MatriculaNum.getText();
                    search.setString(1, numMatricula);
                    ResultSet rs = search.executeQuery();
                    BusquedaVer.setText("");
                    while (rs.next()) {
                        BusquedaVer.append("Num Matricula: " + rs.getInt("codigo_matricula")+"\n");
                        BusquedaVer.append("Nombre: " + rs.getString("nombre_apellido") + "\n");
                        BusquedaVer.append("Direccion: " + rs.getString("direccion") + "\n");
                        BusquedaVer.append("Edad: " + rs.getInt("edad") + "\n");
                        BusquedaVer.append("Telefono: " + rs.getString("telefono") + "\n");
                        BusquedaVer.append("Correo: " + rs.getString("correo") + "\n");
                        BusquedaVer.append("Nota1: " + rs.getDouble("nota1") + "\n");
                        BusquedaVer.append("Nota2: " + rs.getDouble("nota2") + "\n");
                        BusquedaVer.append("\n");
                    }
                    conn.close(); //Cerrar conexion a la base de datos
                } catch (SQLException ex) {
                    System.out.println("Error al conectar a la base de datos: " + ex.getMessage());
                }
            }
        });
    }

    public void iniciar() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setVisible(true);
    }
}
