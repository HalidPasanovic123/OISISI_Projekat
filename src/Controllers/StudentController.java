package Controllers;

import java.util.ArrayList;
import java.util.List;

import Baze.BazaStudenata;
import Model.Adresa;
import Model.Status;
import Model.Student;
import Model.OcenaNaIspitu;
import Model.Predmet;
import View.MainWindowWithComponents.MainWindow;

public class StudentController {
	
private static StudentController instance = null;
	
	public static StudentController getInstance() {
		if (instance == null) {
			instance = new StudentController();
		}
		return instance;
	}
	private StudentController() {}
	
	public void dodajStudenta(String prezime, String ime, String datumRodjenja, Adresa adresaStanovanja, String kontaktTelefon,
	String emailAdresa, String brojIndeksa, String godinaUpisa, int trenutnaGodinaStudija, Status status,
	float prosecnaOcena, ArrayList<OcenaNaIspitu> polozeniIspiti, ArrayList<Predmet> nepolozeniIspiti) {
		BazaStudenata.getInstance().dodajStudenta(ime, prezime, datumRodjenja, adresaStanovanja, kontaktTelefon,
				emailAdresa, brojIndeksa, godinaUpisa, trenutnaGodinaStudija, status, prosecnaOcena,
				polozeniIspiti, nepolozeniIspiti);
		MainWindow.getInstance().updateShowingOfStudent("DODAT", -1);
	}
	
	public void editStudent(String prezime, String ime, String datumRodjenja, Adresa adresaStanovanja, String kontaktTelefon,
			String emailAdresa, String brojIndeksa, String godinaUpisa, int trenutnaGodinaStudija, Status status, Student s) {
		
		s.setIme(ime);
		s.setPrezime(prezime);
		s.setDatumRodjenja(datumRodjenja);
		s.setAdresa(adresaStanovanja);
		s.setKontakt(kontaktTelefon);
		s.seteMail(emailAdresa);
		s.setIndeks(brojIndeksa);
		s.setGodinaUpisa(godinaUpisa);
		s.setGodinaStudija(trenutnaGodinaStudija);
		s.setStatus(status);
		MainWindow.getInstance().updateShowingOfStudent("Izmena Studenta", -1);
		
	}
	
	public List<Student> getStudenti(){
		return BazaStudenata.getInstance().getStudenti();
	}
	
	public Student getStudentFromRow(int rowIndex) {
		return BazaStudenata.getInstance().getRow(rowIndex);
	}
	
	public Student GetStudentFromRow(int rowIndex) {
		return BazaStudenata.getInstance().getRow(rowIndex);
	}
	
    public Student getStudentByID(int id) {
        return BazaStudenata.getInstance().getStudentByID(id);
    }
    
	public void izbrisiStudent(Student s) {
		for (Predmet p : PredmetController.getInstance().getPredmeti()) {
			if (p != null)
			{
				if (p.getSpisakPolozenih() != null)
					for (Student s1 : p.getSpisakPolozenih()) {
						if (s1.equals(s))
							p.getSpisakPolozenih().remove(s);
					}
				if (p.getSpisakNepolozenih() != null)
					for (Student s1 : p.getSpisakNepolozenih()) {
						if (s1.equals(s))
							p.getSpisakNepolozenih().remove(s);
					}
			}
			BazaStudenata.getInstance().deleteStudent(s);
			
		}
	}
	
}
