package Baze;

import java.util.ArrayList;
import java.util.List;

import Model.Ocena;
import Model.OcenaNaIspitu;
import Model.Predmet;
import Model.Semestar;
import Model.Student;

public class BazaPolozenihPredmeta {

	private List<OcenaNaIspitu> ocene;
	private List<String> kolone;

	public BazaPolozenihPredmeta(Student student) {
	
	
		ocene=student.getOcenePolozenihPredmeta();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");		
		this.kolone.add("Ocena");
		this.kolone.add("Datum");

	}

	

	public List<OcenaNaIspitu> getOcenePredmeta() {
		return ocene;
	}

	public void setPredmeti(List<OcenaNaIspitu> ocene) {
		this.ocene = ocene;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public OcenaNaIspitu getRow(int rowIndex) {
		return this.ocene.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		OcenaNaIspitu ocena = this.ocene.get(row);
		switch (column) {
		case 0:
			return ocena.getPredmet().getSifraPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return String.valueOf(ocena.getPredmet().getBrojESPB());
		case 3:
			return ocena.getOcena().toString();
		case 4:
			return ocena.getDatumPolaganja();
		default:
			return null;
		}
	}
	
	public void dodajPolozeniPredmet(String sifra, String naziv, Semestar semestar, String godina, int bodovi,Ocena ocenaa,String datum) 
	{
		Predmet pom = new Predmet(sifra, naziv, semestar, godina, bodovi);
		this.ocene.add(new OcenaNaIspitu(pom,ocenaa,datum));
	}
	
	public void obrisiPredmet(Predmet p) {
		for(OcenaNaIspitu pp:this.ocene) {
			if(pp.equals(p)) {
				this.ocene.remove(pp);
				break;
			}
		}
	}
}

