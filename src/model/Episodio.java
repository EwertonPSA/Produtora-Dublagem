package model;

public class Episodio {
	private String anime;
	private int temporada;
	private int numeroEp;
	private long id;
	private String titulo;
	private String duracao;
	
	
	
	public Episodio(long id) {
		this.id = id;
	}

	public String getAnime() {
		return anime;
	}
	
	public void setAnime(String anime) {
		this.anime = anime;
	}
	
	public int getTemporada() {
		return temporada;
	}
	
	public void setTemporada(int temporada) {
		this.temporada = temporada;
	}
	
	public int getNumeroEp() {
		return numeroEp;
	}
	
	public void setNumeroEp(int numeroEp) {
		this.numeroEp = numeroEp;
	}
	
	public String getTitulo() {
		return titulo;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	
	public String getDuracao() {
		return duracao;
	}
	
	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}
	
	public long getId() {
		return id;
	}
	
}
