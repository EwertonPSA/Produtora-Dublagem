package model;

import java.util.List;

import javax.swing.text.html.HTMLDocument.HTMLReader.IsindexAction;

import java.util.ArrayList;

public class SessaoGravacao {
	private Sala sala;
	private String data;
	private Tecnico tecnico;
	private String hora_final;
	private String hora_inicial;
	private List<Cena> cenas;
	
	

	public SessaoGravacao(Sala sala, String data) {
		this.sala = sala;
		this.data = data;
	}

	
	public String getHora_inicial() {
		return hora_inicial;
	}


	public void setHora_inicial(String hora_inicial) {
		this.hora_inicial = hora_inicial;
	}


	public List<Cena> getCenas() {
		return cenas;
	}
	
	public void addCenas(Cena cena) {
		if(this.cenas == null) {
			this.cenas = new ArrayList<Cena>();
		}
		this.cenas.add(cena);
	}

	public void setCenas(List<Cena> cenas) {
		this.cenas = cenas;
	}
	
	public Sala getSala() {
		return sala;
	}
	
	public String getData() {
		return data;
	}
	
	public Tecnico getTecnico() {
		return tecnico;
	}
	
	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
	}
	
	public String getHora_final() {
		return hora_final;
	}
	
	public void setHora_final(String data_hora_final) {
		this.hora_final = data_hora_final;
	}


	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		else if (!(obj instanceof SessaoGravacao)) return false;
		SessaoGravacao a = (SessaoGravacao) obj;
		if(a.getSala().equals(this.sala) && a.getData().equals(this.data)) return true;
		return false;
	}
	
	
}
