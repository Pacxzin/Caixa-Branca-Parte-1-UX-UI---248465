import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe responsável por gerenciar operações de usuário no banco de dados.
 */
public class User {

    private static final String URL = "jdbc:mysql://127.0.0.1/test";
    private static final String USER = "lopes";
    private static final String PASSWORD = "123";

    private String nome = "";

    /**
     * Abre conexão com o banco de dados.
     */
    public Connection conectarBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Erro ao conectar ao banco: " + e.getMessage());
            return null;
        }
    }

    /**
     * Verifica se o usuário existe no banco.
     */
    public boolean verificarUsuario(String login, String senha) {

        String sql = "SELECT nome FROM usuarios WHERE login = ? AND senha = ?";

        try (Connection conn = conectarBD();
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, login);
            ps.setString(2, senha);

            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    this.nome = rs.getString("nome");
                    return true;
                }
            }

        } catch (Exception e) {
            System.out.println("Erro ao verificar usuário: " + e.getMessage());
        }

        return false;
    }

    public String getNome() {
        return nome;
    }
}
