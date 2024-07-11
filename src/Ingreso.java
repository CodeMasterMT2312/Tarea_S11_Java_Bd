import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Ingreso  extends JFrame {
    private JTextField NombreApellido;
    private JTextField Direc;
    private JTextField age;
    private JTextField tel;
    private JTextField email;
    private JTextField nota1;
    private JTextField nota2;
    private JButton enviarButton;
    private JButton regresarButton;
    private JPanel IngresoPanel;

    public Ingreso() {
        super("Ingreso Estudiantes");
        setContentPane(IngresoPanel);
        regresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Menu menuAdmin = new Menu();
                menuAdmin.iniciar();
                dispose();
            }
        });
        enviarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String URL = "jdbc:mysql://localhost:3306/curso"; // Nombre de la base de datos
                    String userDB = "root";
                    String password = "123456";

                    Connection conn = DriverManager.getConnection(URL, userDB, password);
                    String query = "INSERT INTO estudiantes(nombre_apellido,direccion,edad,telefono,correo,nota1,nota2) VALUES (?,?,?,?,?,?,?);";
                    Statement stmt = conn.createStatement();
                    PreparedStatement guardar = conn.prepareStatement(query);

                    String nombreApellido = NombreApellido.getText();
                    String direccion = Direc.getText();
                    int edad = Integer.parseInt(age.getText());
                    String telefono = tel.getText();
                    String correo = email.getText();
                    double Nota1 = Double.parseDouble(nota1.getText());
                    double Nota2 = Double.parseDouble(nota2.getText());

                    guardar.setString(1,nombreApellido);
                    guardar.setString(2,direccion);
                    guardar.setInt(3, edad);
                    guardar.setString(4, telefono);
                    guardar.setString(5, correo);
                    guardar.setDouble(6, Nota1);
                    guardar.setDouble(7, Nota2);

                    int RegistroInsertado = guardar.executeUpdate();
                    if (RegistroInsertado > 0) {
                        JOptionPane.showMessageDialog(null, "Registro insertado correctamente");
                        NombreApellido.setText("");
                        Direc.setText("");
                        age.setText("");
                        tel.setText("");
                        email.setText("");
                        nota1.setText("");
                        nota2.setText("");
                        guardar.close(); //Cerrar el PreparedStatement para liberar recursos
                    } else {
                        JOptionPane.showMessageDialog(null, "Error al insertar el registro");
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
