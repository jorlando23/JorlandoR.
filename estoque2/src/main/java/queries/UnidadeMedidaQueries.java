
package queries;

import br.edu.ifms.estoque.database.Conexao;
import br.edu.ifms.estoque.model.GrupoProduto;
import br.edu.ifms.estoque.model.UnidadeMedida;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UnidadeMedidaQueries {
    private Conexao conexao;
    private PreparedStatement selectAllMedidas;
    private PreparedStatement selectUnidadeByNome;
    private PreparedStatement insertNovaUnidadeMedida;
    
    public UnidadeMedidaQueries() {
        try {
            conexao = Conexao.getInstance();
            Connection conn = conexao.getConn();
            
            selectAllMedidas = conn.prepareStatement(
                    "SELECT um.id, um.nome,"
                    + "  FROM unidade_medida AS um");
            
            selectUnidadeByNome = conn.prepareStatement(
                    "SELECT um.id, um.nome,"
                    + "  FROM unidade_medida AS um"
                    + "WHERE um.nome LIKE ?");
            
            insertNovaUnidadeMedida = conn.prepareStatement(
                    "INSERT INTO unidade_medida (id, nome) "
                    + "VALUES (?, ?)");
            
            } catch (SQLException ex) {
            ex.printStackTrace();
            System.exit(1);
        }
            
                    
    }
    public List<UnidadeMedida> getAllMedidas() {
        List<UnidadeMedida> results = null;
        ResultSet resultSet = null;
        
        try {
        resultSet = selectAllMedidas.executeQuery();
        results = new ArrayList<UnidadeMedida>();
        while (resultSet.next()) {
        
            results.add(new UnidadeMedida(
                        resultSet.getLong("id"),
                        resultSet.getString("nome"),
                ));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                resultSet.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
                close();
            }
        }
        return null;
    }

    
