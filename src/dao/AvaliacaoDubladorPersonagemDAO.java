package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.AvaliacaoDubladorPersonagem;

public class AvaliacaoDubladorPersonagemDAO {
	
	/* Obtem uma lista Dubladores e outras informacoes no banco*/
	public static List<AvaliacaoDubladorPersonagem> getAvaliacaoDublador(String anime, String personagem){
		List<AvaliacaoDubladorPersonagem> resultConsulta = new ArrayList<AvaliacaoDubladorPersonagem>();
		/* Esse comando DDL obtem os dubladores que dublou determinado personagem em um anime contendo suas informacoes
		 * Foi necessario relacionar com a descricao do personagem para repassar para a interface*/

		try {
			String sql = "SELECT dub.nome, inter.avaliacaototal, pers.descricao, ag.nome, ag.email, ag.telefone1 " + 
					"FROM personagem pers JOIN interpreta inter ON pers.anime = inter.anime AND pers.nome = inter.personagem " + 
					"JOIN dublador dub ON inter.dublador = dub.cpf JOIN agenciaDeDublagem ag ON dub.agenciaDeDublagem = ag.cnpj " +
					" WHERE inter.personagem = ? AND pers.anime = ?"; 
			AvaliacaoDubladorPersonagem infoBanco;
			PreparedStatement stmt = Conector.getConector().prepareStatement(sql);
			stmt.setString(1, personagem);
			stmt.setString(2, anime);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				infoBanco = new AvaliacaoDubladorPersonagem();
				infoBanco.setNome(rs.getString(1));
				infoBanco.setAvaliacaoTotal(rs.getInt(2));
				infoBanco.setDescricao(rs.getString(3));
				infoBanco.setNomeDaAgencia(rs.getString(4));
				infoBanco.setEmailAgencia(rs.getString(5));
				infoBanco.setTelefoneDaAgencia(Integer.toString(rs.getInt(6)));
				resultConsulta.add(infoBanco);
			}
		}catch(SQLException e) {
			throw new RuntimeException("Erro de conexao no banco");
		}finally{
			try {
				Conector.close();
			} catch (SQLException e) {
				throw new RuntimeException("Erro de conexao no banco");
			}
		}
		return resultConsulta;
	}
}
