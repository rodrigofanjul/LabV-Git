package edu.utn;

import java.sql.*;
import java.util.List;

import static edu.utn.MainConTransacciones.*;

public class FacturaDao {

    private Connection con;

    public FacturaDao() throws SQLException, ClassNotFoundException {
        Class.forName(DATABASE_DRIVER);
        con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
        con.setAutoCommit(false);
    }

    public Factura addFactura(Factura f) throws AddFacturaException {
        try {
            PreparedStatement ps = con.prepareStatement("insert into facturas(nombre_cliente, fecha, cantidad_items) values (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, f.getNombreCliente());
            ps.setDate(2, new Date(f.getFecha().getTime()));
            ps.setInt(3, f.getItems().size());
            ps.executeUpdate();
            f.setIdFactura(getAutoIncrement(ps));
            for (Item item : f.getItems()) {
                PreparedStatement psItem = con.prepareStatement("insert into items_facturas(id_factura, nombre_producto, cantidad, precio) values (?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
                psItem.setInt(1, f.getIdFactura());
                psItem.setString(2, item.getNombreProducto());
                psItem.setInt(3, item.getCantidad());
                psItem.setDouble(4, item.getPrecio());
                psItem.executeUpdate();
                item.setIdItem(getAutoIncrement(psItem));
                psItem.close();
            }
            ps.close();
            con.commit();
            return f;
        } catch (SQLException e) {
            try {
                if (con != null) {
                    con.rollback();
                }
            } catch (SQLException rollbackException) {
            }
            throw new AddFacturaException(e);
        }
    }


    public List<Factura> getFacturas() {

        return null;
    }


    private int getAutoIncrement(PreparedStatement ps) throws SQLException {
        ResultSet rs = ps.getGeneratedKeys();
        rs.next();
        int autoIncrement = rs.getInt(1);
        rs.close();
        return autoIncrement;
    }
}
