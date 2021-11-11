package Model;
import java.util.ArrayList;
public class Predmet {

	private String sifraPredmeta;
	private String nazivPredmeta;
	private Semestar semestar;
	private String godinaStudija;
	private Profesor predmetniProfesor;
	private int brojESPB;
	private ArrayList<Student> spisakPolozenih;
	private ArrayList<Student> spisakNepolozenih;
	
	
	public Predmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, String godinaStudija,
			Profesor predmetniProfesor, int brojESPB, ArrayList<Student> spisakPolozenih,
			ArrayList<Student> spisakNepolozenih) {
		super();
		this.sifraPredmeta = sifraPredmeta;
		this.nazivPredmeta = nazivPredmeta;
		this.semestar = semestar;
		this.godinaStudija = godinaStudija;
		this.predmetniProfesor = predmetniProfesor;
		this.brojESPB = brojESPB;
		this.spisakPolozenih = spisakPolozenih;
		this.spisakNepolozenih = spisakNepolozenih;
	}


	public Predmet() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getSifraPredmeta() {
		return sifraPredmeta;
	}


	public void setSifraPredmeta(String sifraPredmeta) {
		this.sifraPredmeta = sifraPredmeta;
	}


	public String getNazivPredmeta() {
		return nazivPredmeta;
	}


	public void setNazivPredmeta(String nazivPredmeta) {
		this.nazivPredmeta = nazivPredmeta;
	}


	public Semestar getSemestar() {
		return semestar;
	}


	public void setSemestar(Semestar semestar) {
		this.semestar = semestar;
	}


	public String getGodinaStudija() {
		return godinaStudija;
	}


	public void setGodinaStudija(String godinaStudija) {
		this.godinaStudija = godinaStudija;
	}


	public Profesor getPredmetniProfesor() {
		return predmetniProfesor;
	}


	public void setPredmetniProfesor(Profesor predmetniProfesor) {
		this.predmetniProfesor = predmetniProfesor;
	}


	public int getBrojESPB() {
		return brojESPB;
	}


	public void setBrojESPB(int brojESPB) {
		this.brojESPB = brojESPB;
	}


	public ArrayList<Student> getSpisakPolozenih() {
		return spisakPolozenih;
	}


	public void setSpisakPolozenih(ArrayList<Student> spisakPolozenih) {
		this.spisakPolozenih = spisakPolozenih;
	}


	public ArrayList<Student> getSpisakNepolozenih() {
		return spisakNepolozenih;
	}


	public void setSpisakNepolozenih(ArrayList<Student> spisakNepolozenih) {
		this.spisakNepolozenih = spisakNepolozenih;
	}


	@Override
	public String toString() {
		return "Predmet [sifraPredmeta=" + sifraPredmeta + ", nazivPredmeta=" + nazivPredmeta + ", semestar=" + semestar
				+ ", godinaStudija=" + godinaStudija + ", predmetniProfesor=" + predmetniProfesor + ", brojESPB="
				+ brojESPB + ", spisakPolozenih=" + spisakPolozenih + ", spisakNepolozenih=" + spisakNepolozenih + "]";
	}
	
	
	

}
