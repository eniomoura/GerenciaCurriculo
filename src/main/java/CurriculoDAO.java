import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CurriculoDAO {
	private static final String URL = "jdbc:derby:db;create=true";
	
	public static void criaTabela() throws SQLException{
		Connection conn = DriverManager.getConnection(URL);
		String sql = "create table usuarios(id int GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1), email varchar(255), nome varchar(255), senha varchar(255), userType varchar(64) default 'usuarioNormal')";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	public static void deletaTabela() throws SQLException{
		Connection conn = DriverManager.getConnection(URL);
		String sql = "drop table usuarios";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	public static void inclui(String email, String nome, String senha, String userType) throws SQLException {
		Connection conn = DriverManager.getConnection(URL);
		String sql = "insert into usuarios (email, nome, senha, userType) values (?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, nome);
		pstmt.setString(3, senha);
		pstmt.setString(4, userType);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	public static void alterar(int id, String email, String nome, String senha, String userType) throws SQLException {
		Connection conn = DriverManager.getConnection(URL);
		String sql = "update usuarios set email=?, nome=?, senha=?, userType=? where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		pstmt.setString(2, nome);
		pstmt.setString(3, senha);
		pstmt.setInt(4, id);
		pstmt.setString(5, userType);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	public static void excluir(int id) throws SQLException {
		Connection conn = DriverManager.getConnection(URL);
		String sql = "delete from usuarios where id = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, id);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	public static List<Curriculo> listar() throws SQLException {
		Connection conn = DriverManager.getConnection(URL);
		String sql = "select id, email, nome, senha, userType from usuario";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Curriculo> usuarios = new ArrayList<>();
		while (rs.next()) {
			Curriculo usuario = new Curriculo(
					rs.getString("nome"),
					rs.getString("email"),
					rs.getString("telefone"),
					rs.getString("nascimento"),
					rs.getString("endereco"),
					rs.getString("areas"),
					rs.getString("idiomas"),
					rs.getString("conhecimentos"),
					rs.getString("formacao"),
					rs.getString("experiencia"),
					rs.getString("remuneracao")
		);
			usuarios.add(usuario);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return usuarios;
	}

	public static Curriculo consultarNome(String nome) throws SQLException{
		Connection conn = DriverManager.getConnection(URL);
		String sql = "select * from usuarios where ?=nome";
		Curriculo result=null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nome);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			result= new Curriculo(
					rs.getString("nome"),
					rs.getString("email"),
					rs.getString("telefone"),
					rs.getString("nascimento"),
					rs.getString("endereco"),
					rs.getString("areas"),
					rs.getString("idiomas"),
					rs.getString("conhecimentos"),
					rs.getString("formacao"),
					rs.getString("experiencia"),
					rs.getString("remuneracao")
		);
		}
		pstmt.close();
		conn.close();
		return result;
	}
	
	public static Curriculo consultarEmail(String email) throws SQLException{
		Connection conn = DriverManager.getConnection(URL);
		String sql = "select * from usuarios where ?=email";
		Curriculo result=null;
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, email);
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()){
			result= new Curriculo(
								rs.getString("nome"),
								rs.getString("email"),
								rs.getString("telefone"),
								rs.getString("nascimento"),
								rs.getString("endereco"),
								rs.getString("areas"),
								rs.getString("idiomas"),
								rs.getString("conhecimentos"),
								rs.getString("formacao"),
								rs.getString("experiencia"),
								rs.getString("remuneracao")
					);
		}
		pstmt.close();
		conn.close();
		return result;
	}
}