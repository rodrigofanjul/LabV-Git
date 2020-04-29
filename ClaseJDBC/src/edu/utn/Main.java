package edu.utn;

import javax.xml.transform.Result;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/mail";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    private static Connection con;

    public static void main(String[] args) {
        try {
            Class.forName(DATABASE_DRIVER);
            con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
            System.out.println("Conectado correctamente");

            //Ejecutar una query de manera simple
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery("select * from messages");
            while (rs.next()) {
                Integer idMessage = rs.getInt("id_message");
                Integer idFrom = rs.getInt("id_from");
                Integer idTo = rs.getInt("id_to");
                String subject = rs.getString("subject");
                String body = rs.getString("body");
                Date date = rs.getDate("message_date");
           //     System.out.println(String.format("%d %d %d %s %s %s", idMessage, idFrom, idTo, subject, body, date.toString()));
            }
            rs.close();
            st.close();

            //Ejecutar una query parametrizada
            java.util.Date date = new java.util.Date(10000);
            List<Message> messageList = getReceivedMessage(2, new Date(date.getTime()));

            messageList.forEach(m -> {
                        System.out.println(m);
                    }
            );
            System.out.println(messageList.size());

            //Delete simple
            Statement stDelete = con.createStatement();
            int deleteRowsAffected = stDelete.executeUpdate("delete from countries");
            System.out.println(String.format("Delete Rows Affected : %d", deleteRowsAffected));
            //Insertar un dato
            insertCountry("Argentina");
            insertCountryStoredProcedure("Brasil");



            //Ejecutar queries donde no se sabe que se va a traer y lo que recibimos es por parametro


            con.close();
        } catch (ClassNotFoundException e) {
            System.out.println("No se pudo cargar el driver");
        } catch (SQLException e) {
            System.out.println("SQL State : " + e.getSQLState());
            System.out.println("Message : " + e.getMessage());
            System.out.println("error code : " + e.getErrorCode());
        }

    }

    private static int insertCountryStoredProcedure(String countryName) throws SQLException {
        CallableStatement callableStatement = con.prepareCall("call sp_add_countries(?,?)");
        callableStatement.setString(1, countryName);
        callableStatement.registerOutParameter("pCountryId", Types.INTEGER);
        callableStatement.execute();
        int countryId =  callableStatement.getInt("pCountryId");
        callableStatement.close();
       return countryId;
    }

    private static void insertCountry(String countryName) throws SQLException {
        PreparedStatement st = con.prepareStatement("insert into countries (country_name) values (?)");
        st.setString(1 , countryName);
        st.execute();
        st.close();
    }


    //Ejecutar queries pasando valores por parametro
    private static List<Message> getReceivedMessage(int idTo, Date from) throws SQLException {
        PreparedStatement st = con.prepareStatement("select * from messages where id_to = ? and message_date > ?  order by message_date");
        st.setInt(1, idTo);
        st.setDate(2, from);
        ResultSet rs = st.executeQuery();
        List<Message> list = new ArrayList<>();
        while (rs.next()) {
            list.add(new Message(rs.getInt("id_message"), rs.getInt("id_from"), rs.getInt("id_to"), rs.getString("subject"), rs.getString("body"), rs.getDate("message_date")));
        }
        rs.close();
        st.close();
        return list;
    }
}
