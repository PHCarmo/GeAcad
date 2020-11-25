package br.com.fatecmc.geacad.model.dao;


import br.com.fatecmc.geacad.model.domain.Pessoa;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.model.connection.ConnectionFactory;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements IDAO {
    private Connection conn;

    @Override
    public boolean salvar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "INSERT INTO pessoas(nome, rg, cpf, email, data_nascimento, sexo) VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Pessoa){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Pessoa) entidade).getNome());
                stmt.setString(2, ((Pessoa) entidade).getRg());
                stmt.setInt(3, ((Pessoa) entidade).getCpf());
                stmt.setString(4, ((Pessoa) entidade).getEmail());
                stmt.setDate(5, new Date(((Pessoa) entidade).getData_nascimento().getTime()));
                stmt.setString(6, ((Pessoa) entidade).getSexo());

                stmt.execute();
                return true;
            } catch (SQLException ex) {
                System.out.println("Não foi possível salvar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return false;
    }

    @Override
    public boolean alterar(EntidadeDominio entidade) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "UPDATE pessoas SET nome=?, rg=?, cpf=?, email=?, data_nascimento=?, sexo=? WHERE id_pessoa=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Pessoa){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Pessoa) entidade).getNome());
                stmt.setString(2, ((Pessoa) entidade).getRg());
                stmt.setInt(3, ((Pessoa) entidade).getCpf());
                stmt.setString(4, ((Pessoa) entidade).getEmail());
                stmt.setDate(5, new Date(((Pessoa) entidade).getData_nascimento().getTime()));
                stmt.setString(6, ((Pessoa) entidade).getSexo());

                if(stmt.executeUpdate() == 1){
                    return true;
                }
            } catch (SQLException ex) {
                System.out.println("Não foi possível alterar os dados no banco de dados.\nErro: " + ex.getMessage());
            } finally {
                ConnectionFactory.closeConnection(conn, stmt);
            }
        }
        return false;
    }

    @Override
    public boolean excluir(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "DELETE FROM pessoas WHERE id_pessoa=?";

        PreparedStatement stmt = null;

        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);

            if(stmt.executeUpdate() == 1){
                return true;
            }
        } catch (SQLException ex) {
            System.out.println("Não foi possível excluir os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt);
        }
        return false;
    }
    
    public List consultar() {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM pessoas";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            Pessoa pessoa = new Pessoa();
            while(rs.next()) {
                pessoa.setId(rs.getInt("id_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setCpf(rs.getInt("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setData_nascimento(rs.getDate("data_nascimento"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoas.add(pessoa);
            }
                
            return pessoas;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
    @Override
    public List consultar(int id) {
        this.conn = ConnectionFactory.getConnection();
        String sql = "SELECT * FROM pessoas WHERE id_pessoa=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            Pessoa pessoa = new Pessoa();
            while(rs.next()) {
                pessoa.setId(rs.getInt("id_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setCpf(rs.getInt("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setData_nascimento(rs.getDate("data_nascimento"));
                pessoa.setSexo(rs.getString("sexo"));
                pessoas.add(pessoa);
            }
                
            return pessoas;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionFactory.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
