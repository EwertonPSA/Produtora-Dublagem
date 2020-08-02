package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Cena;
import model.Episodio;
import model.Sala;
import model.SessaoGravacao;
import model.Tecnico;

public class SessaoGravacaoDAO {
	public SessaoGravacaoDAO() {
	}
	/*
	 * Metodo que faz a busca pelas sessoes, cenas, episodios e o tecnico envolvidos
	 */
	public static List<SessaoGravacao> getSessaoGravacao() {
		List<SessaoGravacao> resultado = null;
		String sql = "";
		try {
			/*
			 * Apartir da tabela produz é feito o inner join com a tabela sessaogravacao e
			 * então outro inner join com cena para ter todos as cenas trabalhadas nessa sessao
			 * para conseguir o nome do anime e da temporada eh necessario fazer outro inner join com
			 * episodio e para conseguir os dados do tecnico eh feito um inner join com tecnico.
			 */
			PreparedStatement stmt = Conector.getConector().prepareStatement(
					"SELECT P.sala, TO_CHAR(P.data_hora, 'DD/MM/YYYY') as data, "
					+ "TO_CHAR(P.data_hora, 'HH24:MI') as hora_inicial,"
					+ "TO_CHAR(SES.horariofinal, 'HH24:MI') as hora_final,"
					+ "EP.id_episodio, "
					+ "EP.anime, EP.temporada, EP.numero as EPISODIO,"
					+ "P.cena , C.estado as status, SES.tecnico , Te.nome "
					+ "FROM PRODUZ P JOIN SESSAODEGRAVACAO SES ON P.SALA = SES.SALA AND P.DATA_HORA = SES.DATA_HORA "
					+ "JOIN CENA C ON C.EPISODIO = P.EPISODIO AND C.NUMERO = P.cena "
					+ "JOIN EPISODIO EP ON EP.ID_EPISODIO=C.EPISODIO "
					+ "JOIN TECNICODEAUDIO Te ON Te.cpf = SES.tecnico "
					+ "ORDER BY P.data_hora, P.SALA");
			ResultSet rs = stmt.executeQuery();
			// funcao que ira recuperar os dados da busca
			resultado = SessaoGravacaoDAO.getDadosResultSet(rs);
		} catch (SQLException e) {
			throw new RuntimeException("Erro de conexao no banco");
		} finally {
			try {
				Conector.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return resultado;
	}
	
	public static List<SessaoGravacao> getSessaoGravacaoPorData(String data) {
		List<SessaoGravacao> resultado = null;
		String sql = "";
		try {
			/*
			 * A mesma que a de cima porém retorna somente as sessoes com data posterior a passada
			 * no metodo.
			 */
			PreparedStatement stmt = Conector.getConector().prepareStatement(
					"SELECT P.sala, TO_CHAR(P.data_hora, 'DD/MM/YYYY') as data, "
					+ "TO_CHAR(P.data_hora, 'HH24:MI') as hora_inicial,"
					+ "TO_CHAR(SES.horariofinal, 'HH24:MI') as hora_final,"
					+ "EP.id_episodio, "
					+ "EP.anime, EP.temporada, EP.numero as EPISODIO,"
					+ "P.cena , C.estado as status, SES.tecnico , Te.nome "
					+ "FROM PRODUZ P JOIN SESSAODEGRAVACAO SES ON P.SALA = SES.SALA AND P.DATA_HORA = SES.DATA_HORA "
					+ "JOIN CENA C ON C.EPISODIO = P.EPISODIO AND C.NUMERO = P.cena "
					+ "JOIN EPISODIO EP ON EP.ID_EPISODIO=C.EPISODIO "
					+ "JOIN TECNICODEAUDIO Te ON Te.cpf = SES.tecnico "
					+ "WHERE SES.data_hora > TO_DATE(? , 'DD/Mon/YYYY HH24:MI') "
					+ "ORDER BY P.data_hora, P.SALA");
			// atribui o valor que vai ser usado no where
			stmt.setString(1, data);
			ResultSet rs = stmt.executeQuery();
			// funcao que ira recuperar os dados da busca
			resultado = SessaoGravacaoDAO.getDadosResultSet(rs);
		} catch (SQLException e) {
			e.getMessage();
			throw new RuntimeException("Erro de conexao no banco");
		} finally {
			try {
				Conector.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultado;
	}
	/*
	 * eh a funcao que faz a recuperacao dos dados apartir de um ResultSet.
	 */
	private static List<SessaoGravacao> getDadosResultSet(ResultSet rs) throws SQLException {
		List<SessaoGravacao> resultado = new ArrayList<SessaoGravacao>();
		while (rs.next()) {
			SessaoGravacao a = new SessaoGravacao(new Sala(rs.getInt(1)), rs.getString(2));
			a.setHora_inicial(rs.getString(3));
			a.setHora_final(rs.getString(4));
			Episodio ep = new Episodio(rs.getLong(5));
			ep.setAnime(rs.getString(6));
			ep.setTemporada(rs.getInt(7));
			ep.setNumeroEp(rs.getInt(8));
			Cena c = new Cena(ep , rs.getInt(9));
			c.setEstado(rs.getString(10));
			Tecnico te = new Tecnico(rs.getLong(11));
			te.setNome(rs.getString(12));
			a.setTecnico(te);
			//isso é para colocar numa lista as cenas que pertecem a uma sessao.
			if(resultado.size() > 0 && a.equals(resultado.get(resultado.size()-1))) {
				resultado.get(resultado.size() -1).addCenas(c);
			}else {
				a.addCenas(c);
				resultado.add(a);
			}
		}
		return resultado;
	}

}
