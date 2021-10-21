package dados;

import conexao.ConexaoBancoDados;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ListarDados {

    private static final String CONSULTAR_DADOS = "SELECT id, nome, fracionado FROM unidade_medida";

    public static void main(String[] args) {
        try {
            ConexaoBancoDados conexao = ConexaoBancoDados.getInstance();
            Connection conn = conexao.getConnection();
            Statement statement = conn.createStatement();
            ResultSet resultSet = statement.executeQuery(CONSULTAR_DADOS);

            System.out.println("Listagem de dados da tabela unidade_medida:");
            ResultSetMetaData metaData = resultSet.getMetaData();
            int numeroColunas = metaData.getColumnCount();
            for (int i = 1; i <= numeroColunas; i++) {
                System.out.printf("%-8s\t", metaData.getColumnName(i));
            }
            System.out.println("");

            while (resultSet.next()) {
                for (int i = 1; i <= numeroColunas; i++) {
                    System.out.printf("%-8s\t", resultSet.getObject(i));
                }
                System.out.println("");
            }

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
