package conexao2;

import conexao.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados2 {

    private Connection conn;
    private static ConexaoBancoDados2 instancia;

    private ConexaoBancoDados2() throws SQLException {
        String url = "jdbc:postgresql://localhost/estoque?user=postgres&password=33446280";
        conn = DriverManager.getConnection(url);
    }

    public static ConexaoBancoDados2 getInstance() throws SQLException {
        if (instancia == null) {
            instancia = new ConexaoBancoDados2();
        }
        return instancia;
    }

    public void close() throws SQLException {
        if (conn.isClosed()) {
            conn.close();
        }
        conn = null;
        instancia = null;
    }
    public Connection getConnection(){
        return conn;
    }
}
