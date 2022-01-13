package Baze;


import java.util.ArrayList;
import java.util.List;

import Model.Status;
import Model.Student;
import Model.Adresa;
import Model.OcenaNaIspitu;
import Model.Predmet;


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
		
		studenti.add(new Student("Ime", "Prezime", "01.02.2002.",adresa ,
				"0634723723" ,"imenkoprezimic@gmail.com"  , "RA-230-2021", "2021",1, Status.B, (float) 9.32, new ArrayList<OcenaNaIspitu>(), new ArrayList<Predmet>()));
		
		studenti.add(new Student("Ime", "Prezime", "11.05.2001.",adresa ,
				"0634723723" ,"imenkoprezimic@gmail.com"  , "RA-231-2020", "2020",2, Status.S, (float) 7.18, new ArrayList<OcenaNaIspitu>(), new ArrayList<Predmet>()));
		
		studenti.add(new Student("Ime", "Prezime", "13.12.2000.",adresa ,
				"0634723723" ,"imenkoprezimic@gmail.com"  , "RA-232-2019", "2019",3, Status.B, (float) 10.0, new ArrayList<OcenaNaIspitu>(), new ArrayList<Predmet>()));
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
}