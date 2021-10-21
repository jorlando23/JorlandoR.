
package conexao2;

import conexao.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TesteConexao2 {
    public static void main(String[] args) {
        try {
            ConexaoBancoDados dados = ConexaoBancoDados.getInstance();
            System.out.println("Conecção inicializada");
            
            dados.close();
            System.out.println("Conecção encerrada");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
