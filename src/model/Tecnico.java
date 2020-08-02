package model;

import java.text.DecimalFormat;

public class Tecnico {
	private Long cpf;
	private String nome;
	private String logradouro;
	private String complemento;
	private int numeroCasa;
	private String email;
	private String telefone1;
	private String telefone2;
	

	public Long getCpf() {
		return cpf;
	}
	
	public String getCpfString() {
		DecimalFormat df = new DecimalFormat("###.###.###-##");
		return df.format(this.cpf);
	}
	
	
	public Tecnico(Long cpf) {
		super();
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getComplemento() {
		return complemento;
	}
	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}
	public int getNumeroCasa() {
		return numeroCasa;
	}
	public void setNumeroCasa(int numeroCasa) {
		this.numeroCasa = numeroCasa;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTelefone1() {
		return telefone1;
	}
	public void setTelefone1(String telefone1) {
		this.telefone1 = telefone1;
	}
	public String getTelefone2() {
		return telefone2;
	}
	public void setTelefone2(String telefone2) {
		this.telefone2 = telefone2;
	}
	
	
	
	
	
	
}
