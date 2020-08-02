package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Essa Classe foi feita para gerar uma conex�o e armazenar ela e pasar ela 
 * para outras classes usarem ela
 */
public class Conector {
	
	private static String usuario = "E10346975";
	private static String senha = "jatifalei";
	protected static String conexaoLocal = null;
	private static Connection conector = null;
	
	/*Realiza conexao no banco fora da rede USP*/
	public static void connectionInUSP() {
		try {
			conector = DriverManager.getConnection("jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl",usuario,senha);
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao tentar conectar no servidor");	
		}
	}
	
	/*Realiza conexao dentro da rede USP*/
	public static void connectionOutUSP() {
		try {
			conector = DriverManager.getConnection("jdbc:oracle:thin:@192.168.183.15:1521:orcl",usuario,senha);
		} catch (SQLException e) {
			throw new RuntimeException("Falha ao tentar conectar no servidor");	
		}
	}
	
	/* Na primeira conexao do banco eh feito duas tentativas de conexao
	 * Uma dentro da rede USP e outra fora, aquele que der certo eh mapeado para que agilize o processo
	 * De conexao ao banco de dados*/
	public static void FirstConnection()  throws RuntimeException{
		if(conector == null) {
			try {/*jar OJDBC eh necessario para fazer conexao ao banco*/
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				throw new RuntimeException("Falha ao acharo ojdbc");
			}
			
			try {/*Conexao fora da rede usp*/
				conector = DriverManager.getConnection("jdbc:oracle:thin:@grad.icmc.usp.br:15215:orcl",usuario,senha);
				conexaoLocal = "InUSP";
			} catch (SQLException e) {
				System.out.println("Conexao falhou testando outra URL");
				try {/*Dentro da rede USP*/
					conector = DriverManager.getConnection("jdbc:oracle:thin:@192.168.183.15:1521:orcl", usuario, senha);
					conexaoLocal = "OutUSP";
				}catch(SQLException ex) {
					throw new RuntimeException("Falha ao tentar conectar no servidor");
				}
			}
			
			if(conector == null) {
				throw new RuntimeException("Falha ao tentar conectar no servidor");
			}
		}
	}
	
	/* Usuario envoca esse metodo para realizar uma conexao no banco*/
	public static Connection getConector(){
		if(conexaoLocal != null) {
			if(conexaoLocal.equals("InUSP")) {
				Conector.connectionInUSP();
			}else if(conexaoLocal.equals("OutUSP")){
				Conector.connectionOutUSP();
			}
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