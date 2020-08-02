package model;

public class Sala {
	private int numero;
	private int numeroKits;
	
	
	
	public Sala(int numero) {
		super();
		this.numero = numero;
	}
	
	public int getNumeroKits() {
		return numeroKits;
	}
	public void setNumeroKits(int numeroKits) {
		this.numeroKits = numeroKits;
	}
	public int getNumero() {
		return numero;
	}

	@Override
	public boolean equals(Object obj) {
		if(this == obj) return true;
		else if (!(obj instanceof Sala)) return false;
		Sala a = (Sala) obj;
		if(a.numero == this.numero) return true;
		return false;
	}
	
	
}
