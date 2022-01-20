package Baze;


import java.util.ArrayList;
import java.util.List;

import Model.Status;
import Model.Student;
import Model.Adresa;
import Model.OcenaNaIspitu;
import Model.Predmet;
import Model.Profesor;
import Model.Semestar;


public class BazaStudenata {
	private static BazaStudenata instance = null;
	
	private List<Student> studenti;
	private List<String> kolone;

	public static BazaStudenata getInstance() {
		if (instance == null) {
			instance = new BazaStudenata();
		}
		return instance;
	}
	
	private BazaStudenata()
	{
		initStudente();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Indeks");
		this.kolone.add("Ime");
		this.kolone.add("Prezime");
		this.kolone.add("Godina studija");
		this.kolone.add("Status");
		this.kolone.add("Prosek");
		
		
		
	}
	
	
	private void initStudente() {
		this.studenti = new ArrayList<Student>();
		Adresa adresa =  new Adresa("ulica",32,"grad","drzava");

		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();

		predmeti.add(new Predmet("sifraPredmeta1", "nazivPredmeta", Semestar.LETNJI, "godinaStudija", new Profesor(), 5, new ArrayList<Student>(), new ArrayList<Student>()));
        predmeti.add(new Predmet("sifraPredmeta2", "nazivPredmeta", Semestar.LETNJI, "godinaStudija", new Profesor(), 5, new ArrayList<Student>(), new ArrayList<Student>()));
        predmeti.add(new Predmet("sifraPredmeta3", "nazivPredmeta", Semestar.LETNJI, "godinaStudija", new Profesor(), 5, new ArrayList<Student>(), new ArrayList<Student>()));
		
		ArrayList<Predmet> predmeti1 = (ArrayList<Predmet>) predmeti.clone();
		ArrayList<Predmet> predmeti2 = (ArrayList<Predmet>) predmeti.clone();

		studenti.add(new Student("Ime", "Prezime", "01.02.2002.",adresa ,
				"0634723723" ,"imenkoprezimic@gmail.com"  , "RA-230-2021", "2021",1, Status.B, (float) 9.32, new ArrayList<OcenaNaIspitu>(), predmeti));
		
		studenti.add(new Student("Ime", "Prezime", "11.05.2001.",adresa ,
				"0634723723" ,"imenkoprezimic@gmail.com"  , "RA-231-2020", "2020",2, Status.S, (float) 7.18, new ArrayList<OcenaNaIspitu>(), predmeti1));
		
		studenti.add(new Student("Ime", "Prezime", "13.12.2000.",adresa ,
				"0634723723" ,"imenkoprezimic@gmail.com"  , "RA-232-2019", "2019",3, Status.B, (float) 10.0, new ArrayList<OcenaNaIspitu>(), predmeti2));
	}
	
	
	public List<Student> getStudenti() {
		return studenti;
	}
	
	public void setStudenti(List<Student> studenti) {
		this.studenti = studenti;
	}
	public int getColumnCount() {
		return 6;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
    public Student getStudentByID(int id) {
        return studenti.get(id);
    }
    
	public Student getRow(int rowIndex) {
		return this.studenti.get(rowIndex);
	}
	
	public String getValueAt(int row, int column) {
		Student student = this.studenti.get(row);
		switch (column) {
		case 0:
			return student.getIndeks();
		case 1:
			return student.getIme();
		case 2:
			return student.getPrezime();
		case 3:
			return String.valueOf(student.getGodinaStudija());
		case 4:
			return student.getStatus().toString();
		case 5:
			return String.valueOf(student.getProsecnaOcena());
		default:
			return null;
		}
	}

	public String getValueAtPolozeni(int row, int column, Student student) {
		OcenaNaIspitu ocena = student.getOcenePolozenihPredmeta().get(row);
		switch (column) {
		case 0:
			return ocena.getPredmet().getSifraPredmeta();
		case 1:
			return ocena.getPredmet().getNazivPredmeta();
		case 2:
			return String.valueOf(ocena.getPredmet().getBrojESPB());
		case 3:
			return String.valueOf(ocena.getOcena());
		case 4:
			return String.valueOf(ocena.getDatumPolaganja());
		default:
			return null;
		}
	}

	public String getValueAtNepolozeni(int row, int column, Student student) {
		Predmet predmet = student.getNepolozeniPredmeti().get(row);
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
			return String.valueOf(predmet.getSemestar());
		default:
			return null;
		}
	}

	public void dodajStudenta(String ime, String prezime, String datumRodjenja, Adresa adresa, String kontakt, String eMail,
			String indeks, String godinaUpisa, int godinaStudija, Status status, float prosecnaOcena,
			ArrayList<OcenaNaIspitu> ocenePolozenihPredmeta, ArrayList<Predmet> nepolozeniPredmeti)  {
		this.studenti.add(new Student(ime, prezime, datumRodjenja, adresa, kontakt, eMail, indeks, godinaUpisa, godinaStudija, status, prosecnaOcena, ocenePolozenihPredmeta, nepolozeniPredmeti));
	}
	
	public void deleteStudent(Student s) {
		for(Student ss:this.studenti) {
			if(ss.equals(s)) {
				this.studenti.remove(ss);
				break;
			}
		}
	}

	public float getProsek(Student s)
	{
		float prosek = 0;
		for (OcenaNaIspitu o : s.getOcenePolozenihPredmeta())
		{
			prosek += o.getOcenaBr(o.getOcena());
		}
		if (s.getOcenePolozenihPredmeta().size() > 0)
		{
			prosek = prosek / s.getOcenePolozenihPredmeta().size();
		}
		s.setProsecnaOcena(prosek);
		return prosek;
	}

	public int getESPB(String indeks) {
		int espb = 0;
		for (Student s : studenti) {
			if (s.getIndeks().equals(indeks)) {
				for (OcenaNaIspitu o : s.getOcenePolozenihPredmeta()) {
					espb += o.getPredmet().getBrojESPB();
				}
				break;
			}

		}
		return espb;
	}
}