package model;

public class Dublador {
	private int cpf;
	private String nome;
	private char sexo;
	private String dataNascimento;
	private String tipoDeVoz;
	private int agenciaDeDublagem;
	public Dublador(int cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public char getSexo() {
		return sexo;
	}
	public void setSexo(char sexo) {
		this.sexo = sexo;
	}
	public String getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getTipoDeVoz() {
		return tipoDeVoz;
	}
	public void setTipoDeVoz(String tipoDeVoz) {
		this.tipoDeVoz = tipoDeVoz;
	}
	public int getAgenciaDeDublagem() {
		return agenciaDeDublagem;
	}
	public void setAgenciaDeDublagem(int agenciaDeDublagem) {
		this.agenciaDeDublagem = agenciaDeDublagem;
	}
}
