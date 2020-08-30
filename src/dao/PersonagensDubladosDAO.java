package dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.PersonagensDublados;

public class PersonagensDubladosDAO {
	private static String[] tipoDeVozBanco = {"TODOS OS TIPOS", "SOPRANO", "MEZZO_SOPRANO", "CONTRALTO", "TENOR", "BARITONO", "BAIXO"};
	
	/* Obtem uma lista personagens que foram dublados com um determinado tipo de voz*/
	public static List<PersonagensDublados> getAvaliacaoDublador(int index){
		ArrayList<PersonagensDublados> resultConsulta = new ArrayList<PersonagensDublados>();
		String sql = null;
			
		try {
			PersonagensDublados infoBanco;
			PreparedStatement stmt ;
			
			/*Nessas consultas DML um mesmo personagem pode ter varios dubladores, para nao haver repeticoes de informacoes foi usado o DISTINCT*/
			if(tipoDeVozBanco[index].equals("TODOS OS TIPOS")) {/*Essa dml pega todos os personagens dublados*/
				sql = "SELECT DISTINCT pers.anime, pers.nome as personagem, pers.tipodevoz as tipo_de_voz from interpreta inter" + 
						" join personagem pers on inter.anime = pers.anime AND inter.personagem = pers.nome ORDER BY pers.anime";
				stmt = Conector.getConector().prepareStatement(sql);
			}else {/*Essa DML pega todos os personagens com um determinado tipo de voz*/
				sql = "SELECT DISTINCT pers.anime, pers.nome as personagem, pers.tipodevoz as tipo_de_voz from interpreta inter" +
						" join personagem pers on inter.anime = pers.anime AND inter.personagem = pers.nome WHERE pers.tipodevoz = ? ORDER BY pers.anime";
				stmt = Conector.getConector().prepareStatement(sql);
				stmt.setString(1,tipoDeVozBanco[index]);
			}
			
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				infoBanco = new PersonagensDublados();
				infoBanco.setAnime(rs.getString(1));
				infoBanco.setPersonagem(rs.getString(2));
				infoBanco.setTipoDeVoz(rs.getString(3));
				resultConsulta.add(infoBanco);
			}
		}catch(SQLException e) {
			throw new RuntimeException("Erro de conexao no banco");
		}finally {
			try {
				Conector.close();
			} catch (SQLException e) {
				throw new RuntimeException("Erro para fechar a conexao do banco");
			}
		}
		return resultConsulta;
	}
}
