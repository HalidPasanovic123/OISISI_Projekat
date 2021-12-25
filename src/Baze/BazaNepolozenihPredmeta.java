package Baze;

import java.util.ArrayList;
import java.util.List;

import Model.Predmet;
import Model.Semestar;
import Model.Student;

public class BazaNepolozenihPredmeta {

	private List<Predmet> predmeti;
	private List<String> kolone;

	public BazaNepolozenihPredmeta(Student student) {
	
	
		predmeti=student.getNepolozeniPredmeti();

		this.kolone = new ArrayList<String>();
		this.kolone.add("Šifra predmeta");
		this.kolone.add("Naziv predmeta");
		this.kolone.add("ESPB");
		this.kolone.add("Godina studija");
		this.kolone.add("Semestar");

	}

	

	public List<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(List<Predmet> predmeti) {
		this.predmeti = predmeti;
	}

	public int getColumnCount() {
		return 5;
	}

	public String getColumnName(int index) {
		return this.kolone.get(index);
	}

	public Predmet getRow(int rowIndex) {
		return this.predmeti.get(rowIndex);
	}

	public String getValueAt(int row, int column) {
		Predmet predmet = this.predmeti.get(row);
		switch (column) {
		case 0:
			return predmet.getSifraPredmeta();
		case 1:
			return predmet.getNazivPredmeta();
		case 2:
			return String.valueOf(predmet.getBrojESPB());
		case 3:
			return predmet.getGodinaStudija();
		case 4:
			return predmet.getSemestar().toString();
		default:
			return null;
		}
	}
	
	public void dodajPredmet(String sifra, String naziv, Semestar semestar, String godina, int bodovi) {
		this.predmeti.add(new Predmet(sifra, naziv, semestar, godina, bodovi));
	}
	
	public void obrisiPredmet(Predmet p) {
		for(Predmet pp:this.predmeti) {
			if(pp.equals(p)) {
				this.predmeti.remove(pp);
				break;
			}
		}
	}
}
