package model;

public class AvaliacaoDubladorPersonagem {
	private String nome;
	private String descricao;
	private Integer avaliacaoTotal;
	private String nomeDaAgencia;
	private String emailAgencia;
	private String telefoneDaAgencia;
	
	public String getTelefoneDaAgencia() {
		return telefoneDaAgencia;
	}
	public void setTelefoneDaAgencia(String telefoneDaAgencia) {
		this.telefoneDaAgencia = telefoneDaAgencia;
	}
	public String getNomeDaAgencia() {
		if(nomeDaAgencia != null) return nomeDaAgencia;
		else return "";
	}
	public void setNomeDaAgencia(String nomeDaAgencia) {
		this.nomeDaAgencia = nomeDaAgencia;
	}
	public String getEmailAgencia() {
		if(nomeDaAgencia != null) return emailAgencia;
		else return "";
	}
	public void setEmailAgencia(String emailAgencia) {
		this.emailAgencia = emailAgencia;
	}
	public String getDescricao() {
		if(descricao == null) return "";
		else if(descricao.equals("null")) return "";
		else return alteraFormatacao(descricao);
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getAvaliacaoTotal() {
		if(avaliacaoTotal != null) return avaliacaoTotal;
		return avaliacaoTotal;
	}
	public void setAvaliacaoTotal(Integer avaliacaoTotal) {
		this.avaliacaoTotal = avaliacaoTotal;
	}

	private static String alteraFormatacao(String descricao) {
		String html = "<html>";
		return html + descricao + html;
	}
}
