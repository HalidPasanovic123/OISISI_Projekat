package Model;

public class OcenaNaIspitu {

	private Student studentPolozio;
	private Predmet predmet;
	private String datumPolaganja;
	private Ocena ocena;
	
	
	public OcenaNaIspitu(Student studentPolozio, Predmet predmet, String datumPolaganja,Ocena ocena) {
		super();
		this.studentPolozio = studentPolozio;
		this.predmet = predmet;
		this.datumPolaganja = datumPolaganja;
		this.ocena = ocena;
	}
	
	
	public OcenaNaIspitu() {
		super();
		// TODO Auto-generated constructor stub
	}


	public Student getStudentPolozio() {
		return studentPolozio;
	}
	public void setStudentPolozio(Student studentPolozio) {
		this.studentPolozio = studentPolozio;
	}
	public Predmet getPredmet() {
		return predmet;
	}
	public void setPredmet(Predmet predmet) {
		this.predmet = predmet;
	}
	public String getDatumPolaganja() {
		return datumPolaganja;
	}
	public void setDatumPolaganja(String datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}


	public Ocena getOcena() {
		return ocena;
	}


	public void setOcena(Ocena ocena) {
		this.ocena = ocena;
	}


	@Override
	public String toString() {
		return "OcenaNaIspitu [studentPolozio=" + studentPolozio + ", predmet=" + predmet + ", datumPolaganja="
				+ datumPolaganja + ", ocena=" + ocena + "]";
	}

	
	
}
