import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Visualizar extends JFrame {
    private JPanel VisualizarPanel;
    private JTextArea RegistrosArea;
    private JButton regresarButton;
    private JButton verRegistrosButton;

    public Visualizar() {
        super("Visualizar Registros");
        setContentPane(VisualizarPanel);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menAd = new Menu();
                menAd.iniciar();
                dispose(); // Cierra la ventana actual
            }
        });
        verRegistrosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String URL = "jdbc:mysql://localhost:3306/curso"; // Nombre de la base de datos
                    String userDB = "root";
                    String password = "123456";

                    Connection conn = DriverManager.getConnection(URL, userDB, password);
                    String query = "SELECT * FROM estudiantes;";
                    Statement stmt = conn.createStatement();
                    ResultSet rs = stmt.executeQuery(query);
                    RegistrosArea.setText(""); // Limpiar el area de texto

                    while (rs.next()) {
                        int Matricula = rs.getInt("codigo_matricula");
                        String Nombre = rs.getString("nombre_apellido");
                        String direccion = rs.getString("direccion");
                        String Telefono = rs.getString("telefono");
                        String email = rs.getString("correo");
                        Double note1 = rs.getDouble("nota1");
                        Double note2 = rs.getDouble("nota2");

                        RegistrosArea.append("Matricula: " + Matricula + "\n");
                        RegistrosArea.append("Nombre y Apellido: " + Nombre + "\n");
                        RegistrosArea.append("Dirección: " + direccion + "\n");
                        RegistrosArea.append("Teléfono: " + Telefono + "\n");
                        RegistrosArea.append("Correo Electrónico: " + email + "\n");
                        RegistrosArea.append("Nota 1: " + note1 + "\n");
                        RegistrosArea.append("Nota 2: " + note2 + "\n");
                        RegistrosArea.append("\n"); // Salto de línea para separar los registros
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
