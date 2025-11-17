package playground.jdbcs;

import java.math.BigDecimal;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class jdbcPlayground {
    public static void main(String[] args) throws SQLException {
        Statement stmt = null;
        String nome = "Victor";
        String sql = "SELECT * FROM user WHERE nome = '" + nome + "'";
        stmt.executeQuery(sql);

        Connection conn = null;
        PreparedStatement ps = conn.prepareStatement("SELECT * FROM user WHERE  NOME = ? ");
        ps.setString(1, nome);

        PreparedStatement ps2 = conn.prepareStatement("INSERT INTO cliente(nome) VALUES(?)");
        String[] nomes = new String[5];
        for (String n : nomes) {
            ps.setString(1, "teste");
            ps.addBatch();
        }
        ps2.executeBatch();

        PreparedStatement ps3 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps3.executeUpdate();
        try (ResultSet keys = ps.getGeneratedKeys()) {
        }

        // Consulta com filtro (seguro)
        String sql2 = "SELECT id, nome FROM cliente WHERE ativo = ? AND criado_em >= ?";
        try (PreparedStatement ps4 = conn.prepareStatement(sql2)) {
            ps.setBoolean(1, true);
            ps.setTimestamp(2, Timestamp.valueOf("2025-10-21 00:00:00"));
            try (ResultSet rs2 = ps.executeQuery()) {
                while (rs2.next()) {
                    /* ... */
                }
            }
        }

        // Atualizacao em lote
        String sql3 = "UPDATE produto SET preco = ? WHERE id = ?";
        class Produto {
            int preco;
            int id;

            public int getPreco() {
                return preco;
            }

            public int getId() {
                return id;
            }
        }

        List<Produto> produtos = new ArrayList<>();
        try (PreparedStatement ps4 = conn.prepareStatement(sql3)) {
            for (Produto p : produtos) {
                ps.setBigDecimal(1, BigDecimal.valueOf(p.getPreco()));
            }
        }

        String sql5 = "SELECT * from user WHERE nome = '" + nome + "'";
        stmt.executeQuery(sql5); // risco de injection

        PreparedStatement ps6 = conn.prepareStatement("SELECT * FROM user WHERE NOME = ?");
        ps.setString(1, nome); // seguro

        PreparedStatement ps7 = conn.prepareStatement("INSERT INTO cliente(nome) VALUES(?)");
        for (String n : nomes) {
            ps.setString(1, n);
            ps.addBatch();
        }
        ps7.executeBatch();

        PreparedStatement ps8 = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
        ps8.executeUpdate();
        try (ResultSet keys = ps8.getGeneratedKeys()) {
        }

        Connection conn2 = null;
        conn2.setAutoCommit(false);
        try {
            // varias operações
            conn2.commit();
        } catch (Exception e) {
            conn2.rollback();
            throw e;
        }

        //Batch
        String up = "UPDATE produto SET preco=? WHERE id=?";
        try (PreparedStatement ps9 = conn.prepareStatement(up)) {
            for (Produto p : produtos) {
                ps.setBigDecimal(1, BigDecimal.valueOf(p.getPreco()));
                ps.setLong(2, p.getId());
                ps.addBatch();
            }
            int[] counts = ps.executeBatch();
        }

        // Chaves gerdas
        try (PreparedStatement ps9 = conn.prepareStatement(
                "INSERT INTO cliente(nome) VALUES(?)",
                Statement.RETURN_GENERATED_KEYS)) {
            ps.setString(1, "Ana");
            ps.executeUpdate();
            try (ResultSet keys = ps9.getGeneratedKeys()) {
                //if (keys.next()) long id = keys.getLong(1);
            }
        }
        //ResultSet: Lê o resultado linha a linha
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                long id = rs.getLong("id"); // Ou por índice: rs.getLong(1)
                String nm = rs.getString("nome");
            }
        }
        PreparedStatement ps10 = conn.prepareStatement(
                sql,
                ResultSet.TYPE_SCROLL_INSENSITIVE,
                ResultSet.CONCUR_UPDATABLE);

    }
}
