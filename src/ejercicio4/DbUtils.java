package ejercicio4;

import java.sql.*;

public class DbUtils {
    Connection connection;

    public DbUtils(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost/Horario",
                    "root", "Libertas11?");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertProfesor(String codProf, String nombre, String apellidos, Date fechaAlta){
        String insertProfesor = "INSERT INTO Profesor VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertProfesor);

            //Configuration of the prepared statement
            preparedStatement.setString(1, codProf);
            preparedStatement.setString(2, nombre);
            preparedStatement.setString(3, apellidos);
            preparedStatement.setDate(4, fechaAlta);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    void insertCurso(String codOe, String codCurso, String codTutor){
        String insertCurso = "INSERT INTO Curso VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertCurso);

            //Configuration of the prepared statement
            preparedStatement.setString(1, codOe);
            preparedStatement.setString(2, codCurso);
            preparedStatement.setString(3, codTutor);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    void insertAsignatura(String codAsig, String nombre, int horasSemanales, int horasTotales){
        String insertAsignatura = "INSERT INTO Asignatura VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(insertAsignatura);

            //Configuration of the prepared statement
            preparedStatement.setString(1, codAsig);
            preparedStatement.setString(2, nombre);
            preparedStatement.setInt(3, horasSemanales);
            preparedStatement.setInt(4, horasTotales);

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
