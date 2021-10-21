package conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBancoDados {

    private Connection conn;
    private static ConexaoBancoDados instancia;

    private ConexaoBancoDados() throws SQLException {
        String url = "jdbc:postgresql://localhost/estoque?user=postgres&password=33446280";
        conn = DriverManager.getConnection(url);
    }

    public static ConexaoBancoDados getInstance() throws SQLException {
        if (instancia == null) {
            instancia = new ConexaoBancoDados();
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
