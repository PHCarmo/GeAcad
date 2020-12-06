package br.com.fatecmc.geacad.model.dao;

import br.com.fatecmc.geacad.model.domain.Pessoa;
import br.com.fatecmc.geacad.model.domain.EntidadeDominio;
import br.com.fatecmc.geacad.util.ConnectionConstructor;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO implements IDAO {
    private Connection conn;

    @Override
    public int salvar(EntidadeDominio entidade) {
        int id = 0;
        this.conn = ConnectionConstructor.getConnection();
        String sql = "INSERT INTO pessoas(nome, rg, cpf, email, data_nascimento, sexo) VALUES(?, ?, ?, ?, ?, ?)";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Pessoa){
            try {
                conn.setAutoCommit(false);
                
                stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
                stmt.setString(1, ((Pessoa) entidade).getNome());
                stmt.setString(2, ((Pessoa) entidade).getRg());
                stmt.setString(3, ((Pessoa) entidade).getCpf());
                stmt.setString(4, ((Pessoa) entidade).getEmail());
                stmt.setDate(5, new Date(((Pessoa) entidade).getData_nascimento().getTime()));
                stmt.setString(6, ((Pessoa) entidade).getSexo());

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
        String sql = "UPDATE pessoas SET nome=?, rg=?, cpf=?, email=?, data_nascimento=?, sexo=? WHERE id_pessoa=?";

        PreparedStatement stmt = null;
        
        if(entidade instanceof Pessoa){
            try {
                stmt = conn.prepareStatement(sql);
                stmt.setString(1, ((Pessoa) entidade).getNome());
                stmt.setString(2, ((Pessoa) entidade).getRg());
                stmt.setString(3, ((Pessoa) entidade).getCpf());
                stmt.setString(4, ((Pessoa) entidade).getEmail());
                stmt.setDate(5, new Date(((Pessoa) entidade).getData_nascimento().getTime()));
                stmt.setString(6, ((Pessoa) entidade).getSexo());
                stmt.setInt(7, entidade.getId());

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
        String sql = "DELETE FROM pessoas WHERE id_pessoa=?";

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
        String sql = "SELECT * FROM pessoas";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            
            while(rs.next()) {
            Pessoa pessoa = new Pessoa();
                
                pessoa.setId(rs.getInt("id_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setData_nascimento(rs.getDate("data_nascimento"));
                pessoa.setSexo(rs.getString("sexo"));
                
                pessoas.add(pessoa);
            }
                
            return pessoas;
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
        String sql = "SELECT * FROM pessoas WHERE id_pessoa=?";
        
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Pessoa> pessoas = new ArrayList<>();
        try {
            stmt = conn.prepareStatement(sql);
            stmt.setInt(1, id);
                
            rs = stmt.executeQuery();
            
            while(rs.next()) {
            Pessoa pessoa = new Pessoa();
                
                pessoa.setId(rs.getInt("id_pessoa"));
                pessoa.setNome(rs.getString("nome"));
                pessoa.setRg(rs.getString("rg"));
                pessoa.setCpf(rs.getString("cpf"));
                pessoa.setEmail(rs.getString("email"));
                pessoa.setData_nascimento(rs.getDate("data_nascimento"));
                pessoa.setSexo(rs.getString("sexo"));
                
                pessoas.add(pessoa);
            }
                
            return pessoas;
        } catch (SQLException ex) {
            System.out.println("Não foi possível consultar os dados no banco de dados.\nErro: " + ex.getMessage());
        } finally {
            ConnectionConstructor.closeConnection(conn, stmt, rs);
        }
        return null;
    }
    
}
