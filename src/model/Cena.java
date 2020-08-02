package model;

public class Cena {
	private Episodio episodio;
	private int numero;
	private String duracao;
	private String script;
	private String audio;
	private String estado;
	


	public Cena(Episodio episodio , int numero) {
		this.episodio = episodio;
		this.numero = numero;
	}
	
	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}
	
	public String getDuracao() {
		return duracao;
	}
	
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	public String getScript() {
		return script;
	}
	
	public void setScript(String script) {
		this.script = script;
	}
	
	public String getAudio() {
		return audio;
	}
	
	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	public Episodio getEpisodio() {
		return episodio;
	}
	
	public int getNumero() {
		return numero;
	}
	
	
	
}
