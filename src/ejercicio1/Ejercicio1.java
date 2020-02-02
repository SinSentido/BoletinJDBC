package ejercicio1;

import java.io.*;
import java.sql.*;

public class Ejercicio1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost/?allowMultiQueries=true&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Libertas11?");
            Statement statement = connection.createStatement();

            System.out.println(scriptToString("./scripts/2019-2020_script_horario.sql"));

            int queryResult = statement.executeUpdate(scriptToString("./scripts/2019-2020_script_horario.sql"));

            System.out.println("La base de datos se ha cargado correctamente. Código: " + queryResult);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    static String scriptToString(String scriptPath){
        File script = new File(scriptPath);
        StringBuilder query = new StringBuilder();
        String line;

        try {
            FileReader fr = new FileReader(script);
            BufferedReader br = new BufferedReader(fr);

            while((line =br.readLine()) != null){
                query.append(line);
                query.append("\n");
            }

            br.close();
            fr.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return query.toString();
    }
}
