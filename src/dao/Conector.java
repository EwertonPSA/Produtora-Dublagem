package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Essa Classe foi feita para gerar uma conexao, armazenar e passar
 * para outras classes usarem
 */
public class Conector {
	protected static String conexaoLocal = null;
	private static Connection conector = null;
	
	public static void connection() {
		try {
			conector = DriverManager.getConnection("jdbc:postgresql://0.0.0.0:8089/anime_produtora", "postgres", "postgres");
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao tentar conectar no servidor");	
		}
	}
	
	/* Na primeira conexao do banco eh feito uma conexao
	 * Verificando primeiro se o OJDBC se encontra no projeto*/
	public static void FirstConnection()  throws RuntimeException{
		if(conector == null) {
			try {/*jar OJDBC eh necessario para fazer conexao ao banco*/
				Class.forName("org.postgresql.Driver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Falha ao achar o ojdbc");
			}
			
			try {/*Conexao fora da rede usp*/
				conector = DriverManager.getConnection("jdbc:postgresql://0.0.0.0:8089/anime_produtora", "postgres", "postgres");
			} catch (SQLException e) {
				throw new RuntimeException("Falha ao conectar no servidor, checar informacoes do banco de dados postgres!");	
			}
		}
	}
	
	/* Usuario envoca esse metodo para realizar uma conexao no banco*/
	public static Connection getConector(){
		if(conexaoLocal != null) {
			Conector.connection();
		}else if(Conector.conector == null) {
			Conector.FirstConnection();
		}
		return Conector.conector;
	}
	
	/**
	 * Fecha a conxeao caso ela exista
	 * @throws SQLException
	 */
	public static void close() throws SQLException{
		if(Conector.conector == null) {
			return;
		}
		Conector.conector.close();
		Conector.conector = null;
	}
}
