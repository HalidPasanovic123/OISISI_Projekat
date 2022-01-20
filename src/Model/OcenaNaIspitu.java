package Model;

import java.time.LocalDate;

public class OcenaNaIspitu {

	private Student studentPolozio;
	private Predmet predmet;
	private LocalDate datumPolaganja;
	private Ocena ocena;
	
	public OcenaNaIspitu() {
		
	}

	public OcenaNaIspitu(Student studentPolozio, Predmet predmet, LocalDate datumPolaganja, Ocena ocena) {
		this.studentPolozio = studentPolozio;
		this.predmet = predmet;
		this.datumPolaganja = datumPolaganja;
		this.ocena = ocena;
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

	public LocalDate getDatumPolaganja() {
		return datumPolaganja;
	}

	public void setDatumPolaganja(LocalDate datumPolaganja) {
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
		return "OcenaNaIspitu [datumPolaganja=" + datumPolaganja + ", ocena=" + ocena + ", predmet=" + predmet
				+ ", studentPolozio=" + studentPolozio + "]";
	}
}
