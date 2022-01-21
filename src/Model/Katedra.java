package Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Katedra implements Serializable {
	
	private String sifraKatedre;
	private String nazivKatedre;
	private Profesor sefKatedre;
	private ArrayList<Profesor> profesori;
	
	public Katedra(String sifraKatedre, String nazivKatedre, Profesor sefKatedre, ArrayList<Profesor> profesori) {
		super();
		this.sifraKatedre = sifraKatedre;
		this.nazivKatedre = nazivKatedre;
		this.sefKatedre = sefKatedre;
		this.profesori = profesori;
	}
	
	public Katedra() {
		super();
	}
	
	public String getSifraKatedre() {
		return sifraKatedre;
	}
	
	public void setSifraKatedre(String sifraKatedre) {
		this.sifraKatedre = sifraKatedre;
	}
	
	public String getNazivKatedre() {
		return nazivKatedre;
	}
	
	public void setNazivKatedre(String nazivKatedre) {
		this.nazivKatedre = nazivKatedre;
	}
	
	public Profesor getSefKatedre() {
		return sefKatedre;
	}
	
	public void setSefKatedre(Profesor sefKatedre) {
		this.sefKatedre = sefKatedre;
	}
	
	public ArrayList<Profesor> getProfesori() {
		return profesori;
	}
	
	public void setProfesori(ArrayList<Profesor> profesori) {
		this.profesori = profesori;
	}
	
	@Override
	public String toString() {
		return "Katedra [sifraKatedre=" + sifraKatedre + ", nazivKatedre=" + nazivKatedre + ", šefKatedre=" + sefKatedre
				+ ", profesori=" + profesori + "]";
	}
		
}
