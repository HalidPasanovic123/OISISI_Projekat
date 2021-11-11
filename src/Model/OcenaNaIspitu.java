package Model;
import java.time.LocalDate;

public class OcenaNaIspitu {

	private Student studentPolozio;
	private Predmet predmet;
	private LocalDate datumPolaganja;
	
	
	public OcenaNaIspitu(Student studentPolozio, Predmet predmet, LocalDate datumPolaganja) {
		super();
		this.studentPolozio = studentPolozio;
		this.predmet = predmet;
		this.datumPolaganja = datumPolaganja;
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
	public LocalDate getDatumPolaganja() {
		return datumPolaganja;
	}
	public void setDatumPolaganja(LocalDate datumPolaganja) {
		this.datumPolaganja = datumPolaganja;
	}


	@Override
	public String toString() {
		return "OcenaNaIspitu [studentPolozio=" + studentPolozio + ", predmet=" + predmet + ", datumPolaganja="
				+ datumPolaganja + "]";
	}

	
	
}
