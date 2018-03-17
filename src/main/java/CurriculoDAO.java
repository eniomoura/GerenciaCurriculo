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
		String sql = "create table curriculos(nome varchar(255), email varchar(255), telefone varchar(255), nascimento varchar(255), endereco varchar(255), area varchar(255), idiomas varchar(255), conhecimentos varchar(255), formacao varchar(255), experiencia varchar(255), remuneracao varchar(255))";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}
	
	public static void deletaTabela() throws SQLException{
		Connection conn = DriverManager.getConnection(URL);
		String sql = "drop table curriculos";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	public static void inclui(String nome, String email, String telefone, String nascimento, String endereco, String area,
			String idiomas, String conhecimentos, String formacao, String experiencia, String remuneracao) throws SQLException {
		Connection conn = DriverManager.getConnection(URL);
		String sql = "insert into curriculos (nome, email, telefone, nascimento, endereco, area, idiomas, conhecimentos, formacao, experiencia, remuneracao) values (?,?,?,?,?,?,?,?,?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nome);
		pstmt.setString(2, email);
		pstmt.setString(3, telefone);
		pstmt.setString(4, nascimento);
		pstmt.setString(5, endereco);
		pstmt.setString(6, area);
		pstmt.setString(7, idiomas);
		pstmt.setString(8, conhecimentos);
		pstmt.setString(9, formacao);
		pstmt.setString(10, experiencia);
		pstmt.setString(11, remuneracao);
		pstmt.executeUpdate();
		pstmt.close();
		
		conn.close();
		System.out.println(nome);
	}

	public static void alterar(String nome, String email, String telefone, String nascimento, String endereco, String area,
			String idiomas, String conhecimentos, String formacao, String experiencia, String remuneracao) throws SQLException {
		Connection conn = DriverManager.getConnection(URL);
		String sql = "update curriculos set nome=?, telefone=?, nascimento=?, endereco=?, area=?, idiomas=?, formacao=?, experiencia=?, remuneracao=? where email = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setString(1, nome);
		pstmt.setString(2, telefone);
		pstmt.setString(3, nascimento);
		pstmt.setString(4, endereco);
		pstmt.setString(5, area);
		pstmt.setString(6, idiomas);
		pstmt.setString(7, conhecimentos);
		pstmt.setString(8, formacao);
		pstmt.setString(9, experiencia);
		pstmt.setString(10, remuneracao);
		pstmt.setString(11, email);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
		System.out.println(nome);
	}

	public static void excluir(int email) throws SQLException {
		Connection conn = DriverManager.getConnection(URL);
		String sql = "delete from curriculos where email = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1, email);
		pstmt.executeUpdate();
		pstmt.close();
		conn.close();
	}

	public static List<Curriculo> listar() throws SQLException {
		Connection conn = DriverManager.getConnection(URL);
		String sql = "select nome, email, telefone, nascimento, endereco, area, idiomas, conhecimentos, formacao, experiencia, remuneracao from curriculos";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		List<Curriculo> curriculos = new ArrayList<>();
		while (rs.next()) {
			Curriculo curriculo = new Curriculo(
					rs.getString("nome"),
					rs.getString("email"),
					rs.getString("telefone"),
					rs.getString("nascimento"),
					rs.getString("endereco"),
					rs.getString("area"),
					rs.getString("idiomas"),
					rs.getString("conhecimentos"),
					rs.getString("formacao"),
					rs.getString("experiencia"),
					rs.getString("remuneracao")
		);
			curriculos.add(curriculo);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return curriculos;
	}

	public static Curriculo consultarNome(String nome) throws SQLException{
		Connection conn = DriverManager.getConnection(URL);
		String sql = "select * from curriculos where ?=nome";
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
					rs.getString("area"),
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
		String sql = "select * from curriculos where ?=email";
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
								rs.getString("area"),
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