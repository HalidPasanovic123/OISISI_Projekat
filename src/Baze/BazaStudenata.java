package Baze;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Model.Status;
import Model.Student;
import View.Dialogs.StudentEditDialog.NepolozeniTab.StudentNepolozeniJTable;
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

		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();

		try {
            deserialization();
        } catch (Exception e) {
            e.printStackTrace();
        }

	 }
	
	
	public List<Student> getStudenti() {
		return studenti;
	}

	public Student getStudentByIndeks(String brojIndeksa) {
		for (Student s : studenti) 
		{
			if (s.getIndeks().equals(brojIndeksa))
				return s;
		}
		return null;
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

	public Student findStudentByRow(int row) {
		return studenti.get(row);
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
		if (s.getOcenePolozenihPredmeta() == null) {
			return prosek;
		}
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
				if(s.getOcenePolozenihPredmeta() == null){
					break;
				}
				for (OcenaNaIspitu o : s.getOcenePolozenihPredmeta()) {
					espb += o.getPredmet().getBrojESPB();
				}
				break;
			}

		}
		return espb;
	}

	public void ukloniPredmet(String brojIndeksa, StudentNepolozeniJTable t) {
		Student student=this.getStudentByIndeks(brojIndeksa);
		int indeksPredmetaZaUk=t.convertRowIndexToModel(t.getSelectedRow());
		student.getNepolozeniPredmeti().remove(indeksPredmetaZaUk);
	}

	public void serialization() throws IOException {
        File file = new File("data"+File.separator+"studenti.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        try {
            oos.writeObject(studenti);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			oos.close();
		}
    }

	public void deserialization() throws FileNotFoundException, IOException {
        File file = new File("data"+File.separator+"studenti.txt");
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            ArrayList<Student> inStudents = (ArrayList<Student>) ois.readObject();
            studenti = inStudents;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ois.close();
        }
    }
}