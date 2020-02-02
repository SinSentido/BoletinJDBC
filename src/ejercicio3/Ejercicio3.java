package ejercicio3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Ejercicio3 {
    public static void main(String[] args){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/Horario", "root", "Libertas11?");
            Statement statement = connection.createStatement();

            int queryCode = statement.executeUpdate("INSERT INTO OfertaEducativa VALUES( " +
                    "'FPB', " +
                    "'FP Básica Informática y comunicaciones'," +
                    "'La formación profesional básica de informática y comunicaciones tiene una duración de 2000 horas repartidas entre dos cursos académicos incluyendo 240 horas de Formación en centros de trabajo (FCT) en empresas del Sector'," +
                    "'FPB'," +
                    "null)");

            System.out.println(queryCode);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
