package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.Professor;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProfessorDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        this.conn = ConnectionConstructor.getConnection();
        String sql = "INSERT INTO professores(salario, titulacao, pessoas_id_pessoa) VALUES(?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Professor){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setDouble(1, ((Professor) entidade).getSalario());
                stmt.setString(2, ((Professor) entidade).getTitulacao());
                stmt.setInt(3, ((Professor) entidade).getId_pessoa());
                stmt.executeUpdate();
                
                ResultSet rs = stmt.getGeneratedKeys();
                if(rs.next()) id = rs.getInt(1);
                
                conn.commit();	
            } catch (SQLException ex) {
                System.out.println("Não foi possível salvar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionConstructor.closeConnection(conn, stmt);
            }
        }
        return id;
    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        this.conn = ConnectionConstructor.getConnection();
        String sql = "UPDATE professores SET salario=?, titulacao=?, pessoas_id_pessoa=? WHERE id_professor=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Professor){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setDouble(1, ((Professor) entidade).getSalario());
                stmt.setString(2, ((Professor) entidade).getTitulacao());
                stmt.setInt(3, ((Professor) entidade).getId_pessoa());
                stmt.setInt(4, entidade.getId());

                if(stmt.executeUpdate() == 1) return true;
            } catch (SQLException ex) {
                System.out.println("Não foi possível alterar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionConstructor.closeConnection(conn, stmt);
            }
        }
        return false;
    }

    @Override
    public boolean excluir(int id) {
        this.conn = ConnectionConstructor.getConnection();
        String sql = "DELETE FROM professores WHERE id_professor=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            if(stmt.executeUpdate() == 1) return true;
        } catch (SQLException ex) {
            System.out.println("Não foi possível excluir os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt);
        }
        return false;
    }
    
    @Override
    public List consultar() {
        this.conn = ConnectionConstructor.getConnection();
        String sql = "SELECT * FROM professores LEFT JOIN pessoas ON pessoas_id_pessoa = id_pessoa";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Professor> professores = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Professor professor = new Professor();

                professor.setId(rs.getInt("id_professor"));
                professor.setSalario(rs.getDouble("salario"));
                professor.setTitulacao(rs.getString("titulacao"));
                professor.setId_pessoa(rs.getInt("pessoas_id_pessoa"));
                professor.setNome(rs.getString("nome"));
                professor.setRg(rs.getString("rg"));
                professor.setCpf(rs.getString("cpf"));
                professor.setEmail(rs.getString("email"));
                professor.setData_nascimento(rs.getDate("data_nascimento"));
                professor.setSexo(rs.getString("sexo"));
                
                professores.add(professor);
            }
                
            return professores;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    @Override
    public List consultar(int id) {
        this.conn = ConnectionConstructor.getConnection();
        String sql = "SELECT * FROM professores LEFT JOIN pessoas ON pessoas_id_pessoa = id_pessoa WHERE id_professor=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Professor> professores = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
            
            rs = stmt.executeQuery();
            
            while(rs.next()) {
                Professor professor = new Professor();

                professor.setId(rs.getInt("id_professor"));
                professor.setSalario(rs.getDouble("salario"));
                professor.setTitulacao(rs.getString("titulacao"));
                professor.setId_pessoa(rs.getInt("pessoas_id_pessoa"));
                professor.setNome(rs.getString("nome"));
                professor.setRg(rs.getString("rg"));
                professor.setCpf(rs.getString("cpf"));
                professor.setEmail(rs.getString("email"));
                professor.setData_nascimento(rs.getDate("data_nascimento"));
                professor.setSexo(rs.getString("sexo"));
                
                professores.add(professor);
            }
                
            return professores;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
