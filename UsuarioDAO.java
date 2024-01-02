package Controlador;

import Clases.Usuario;
import MySQL.BaseDatos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioDAO {

    private static final String OBTENER_USUARIO = "SELECT * FROM empleados WHERE correo = ? AND password = ?";

    public static Usuario obtenerUsuario(String nombreUsuario, String contrasena) {
        try ( PreparedStatement statement = BaseDatos.obtenerConexion().prepareStatement(OBTENER_USUARIO)) {
            statement.setString(1, nombreUsuario);
            statement.setString(2, contrasena);

            try ( ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return new Usuario(
                            resultSet.getString("correo"),
                            resultSet.getString("password"),
                            resultSet.getString("tipo_usuario")
                    );
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
