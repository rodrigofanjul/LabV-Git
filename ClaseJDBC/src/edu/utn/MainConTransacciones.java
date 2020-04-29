package edu.utn;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

public class MainConTransacciones {


    public  static final String DATABASE_DRIVER = "com.mysql.cj.jdbc.Driver";
    public  static final String DATABASE_URL = "jdbc:mysql://localhost:3306/facturacion";
    public  static final String USERNAME = "root";
    public  static final String PASSWORD = "";


    public static void main(String[] args) throws Exception {
        FacturaDao dao = new FacturaDao();

        List<Item> items = new ArrayList<>();
        items.add(new Item("Lenovo", 2, 3.5));
        items.add(new Item("CEPAC Trainings ", 5, 9.5));
        items.add(new Item("Toshiba Notebook", 15, 0.5));

        Factura f = new Factura("UTN", new Date(System.currentTimeMillis()), items);

        dao.addFactura(f);

    }
}