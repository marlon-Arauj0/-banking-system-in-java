package db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class PessoasDbCRUDImpl implements PessoasDbCRUD {

    private final Connection connection;

    public PessoasDbCRUDImpl() {
        MysqlConfig mysqlConfig = new MysqlConfig();
        connection = mysqlConfig.getConnection();
    }

    @Override
    public void createPessoa(String nome, String dt_nascimento, String documento, String email) {
        String sql = "INSERT INTO pessoas(nome, dt_nascimento, documento, email) VALUES(?, ?, ?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            stmt.setString(2, dt_nascimento);
            stmt.setString(3, documento);
            stmt.setString(4, email);

            int rows = stmt.executeUpdate();
            System.out.println("Cadastro realizado - linhas afetadas" + rows);

        } catch (SQLException e){
            throw new RuntimeException("Ocorreu um erro no createPessoa - erro: " + e.getMessage());
        }

    }
    @Override
    public PessoasDb readPessoaByNome(String nome) {
        String sql = "SELECT * FROM pessoas WHERE nome = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, nome);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                return getPessoasDb(rs);
            }

        } catch (SQLException e){
            throw new RuntimeException("Ocorreu um erro no readPessoaByNome - erro: " + e.getMessage());
        }
        return null;
    }

    @Override
    public PessoasDb readPessoa(Integer id) {
        String sql = "SELECT * FROM pessoas p WHERE p.id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1,id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()){
                return getPessoasDb(rs);
            }

        } catch (SQLException e){
            throw new RuntimeException("Ocorreu um erro no readPessoa(id) - erro: " + e.getMessage());
        }
        return null;
    }

    @Override
    public List<PessoasDb> readPessoas() {
        String sql = "SELECT * FROM pessoas";
        List<PessoasDb> pessoasDbs = new ArrayList<>();

        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();

            while (rs.next()){
                var pessoasDb = getPessoasDb(rs);
                pessoasDbs.add(pessoasDb);
            }

        } catch (SQLException e){
            throw new RuntimeException("Ocorreu um erro no readPessoas - erro: " + e.getMessage());
        }
        return pessoasDbs;
    }

    @Override
    public void updatePessoa(PessoasDb pessoasDb) {
        String sql = "UPDATE pessoas SET " +
                        "nome           = ?, " +
                        "dt_nascimento  = ?, " +
                        "documento      = ?, " +
                        "email          = ?  " +
                     "WHERE id          = ?  ";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setString(1, pessoasDb.getNome());
            stmt.setString(2, pessoasDb.getDt_nascimento());
            stmt.setString(3, pessoasDb.getDocumento());
            stmt.setString(4, pessoasDb.getEmail());
            stmt.setInt(5,pessoasDb.getId());

            int rows = stmt.executeUpdate();
            System.out.println("Atualização realizada - linhas afetadas" + rows);

        } catch (SQLException e){
            throw new RuntimeException("Ocorreu um erro no updatePessoa - erro: " + e.getMessage());
        }
    }

    @Override
    public void deletePessoa(Integer id) {
        String sql = "DELETE FROM pessoas WHERE id = ?";
        try {
            PreparedStatement stmt = connection.prepareStatement(sql);
            stmt.setInt(1, id);

            int rows = stmt.executeUpdate();
            System.out.println("Atualização realizada - linhas afetadas" + rows);

        } catch (SQLException e){
            throw new RuntimeException("Ocorreu um erro no deletePessoa - erro: " + e.getMessage());
        }
    }

    private static PessoasDb getPessoasDb(ResultSet rs) throws SQLException {
        Integer id = rs.getInt("id");
        String nome = rs.getString("nome");
        String dt_nascimento = rs.getString("dt_nascimento");
        String documento = rs.getString("documento");
        String email = rs.getString("email");
        LocalDateTime dt_criacao = rs.getTimestamp("dt_criacao").toLocalDateTime();
        return new PessoasDb(id, nome, dt_nascimento,documento,email, dt_criacao);
    }
}
