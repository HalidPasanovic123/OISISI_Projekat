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

import Model.Predmet;
import Model.Profesor;
import Model.Semestar;
import Model.Student;


public class BazaPredmeta {
    
    private static BazaPredmeta instance = null;

    public static BazaPredmeta getInstance(){
        if (instance == null) {
            instance = new BazaPredmeta();
        }
        return instance;
    }

    private ArrayList<Predmet> predmeti;
    private ArrayList<String> columns;
    private ArrayList<String> columnsForProfesorEdit;
    private ArrayList<String> columnsForStudentPolozeni;

    private BazaPredmeta(){
        this.columns = new ArrayList<String>();
        this.predmeti = new ArrayList<Predmet>();
        this.columnsForProfesorEdit = new ArrayList<String>();
        this.columnsForStudentPolozeni = new ArrayList<String>();

        try {
            deserialization();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        this.columns.add("Šifra predmeta");
        this.columns.add("Naziv predmeta");
        this.columns.add("Broj ESPB");
        this.columns.add("Godina studija");
        this.columns.add("Semestar");

        this.columnsForProfesorEdit.add("Šifra predmeta");
        this.columnsForProfesorEdit.add("Naziv predmeta");
        this.columnsForProfesorEdit.add("Semestar");
        this.columnsForProfesorEdit.add("Godina studija");

        this.columnsForStudentPolozeni.add("Šifra predmeta");
        this.columnsForStudentPolozeni.add("Naziv predmeta");
        this.columnsForStudentPolozeni.add("Broj ESPB");
        this.columnsForStudentPolozeni.add("Ocena");
        this.columnsForStudentPolozeni.add("Datum");
    }

    public ArrayList<Predmet> getPredmeti(){
        return predmeti;
    }

    public Predmet getPredmet(int id){
        return predmeti.get(id);
    }

    public void setpredmeti(ArrayList<Predmet> predmeti){
        this.predmeti = predmeti;
    }

    public int getRowCount(){
        return predmeti.size();
    }

    public int getRowCountProfesor(Profesor profesor){
         return profesor.getPredmeti().size();
    }

    public int getColumnCount(){
        return columns.size();
    }

    public int getColumnCountProfesor(){
        return columnsForProfesorEdit.size();
    }

    public int getColumnCountPolozeni(){
        return columnsForStudentPolozeni.size();
    }

    public String getColumnName(int index){
        return this.columns.get(index);
    }

    public String getColumnNameProfesor(int index){
        return this.columnsForProfesorEdit.get(index);
    }

    public String getColumnNamePolozeni(int index){
        return this.columnsForStudentPolozeni.get(index);
    }

    public Predmet getRow(int index){
        return this.predmeti.get(index);
    }

    public void addPredmet(Predmet Predmet){
        this.predmeti.add(Predmet);
    }

    public void dodajProfesorNaPredmet(Predmet predmet, Profesor profesor){
        for (Predmet p : predmeti){
            if(p.getSifraPredmeta() == predmet.getSifraPredmeta()){
                p.setPredmetniProfesor(profesor);
                break;
            }
        } 
    }

    public void obrisiProfesoraSaPredmeta(Predmet predmet){
        for (Predmet p : predmeti){
            if(p.getSifraPredmeta() == predmet.getSifraPredmeta()){
                p.setPredmetniProfesor(null);
                break;
            }
        }
    }
    
    public void deletePredmet(Predmet predmet){
        for (Predmet p : predmeti){
            if(p.getSifraPredmeta() == predmet.getSifraPredmeta()){
                predmeti.remove(p);
                break;
            }
        }
    }

    public void changePredmet(Predmet Predmet, String prethodnaSifra){
        for (Predmet p : predmeti){
            if(p.getSifraPredmeta() == prethodnaSifra){
                predmeti.remove(p);
                predmeti.add(Predmet);
                break;
            }
        } 
    }

    public void changePredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, String godinaStudija, int brojESPB, String prethodnaSifra){
        for (Predmet p : predmeti){
            if(p.getSifraPredmeta() == prethodnaSifra){
                p.setSifraPredmeta(sifraPredmeta);
                p.setNazivPredmeta(nazivPredmeta);
                p.setSemestar(semestar);
                p.setGodinaStudija(godinaStudija);
                p.setBrojESPB(brojESPB);
                break;
            }
        } 
    }
    
    public String getValueAtDodaj(int row, int column){
        Predmet predmet = predmeti.get(row);
        switch (column){
            case 0:
                return predmet.getSifraPredmeta() + " - " + predmet.getNazivPredmeta();
            default:
                return null;
        }
    }

    public Object getValueAt(int row, int column){
        Predmet predmet = predmeti.get(row);
        switch (column){
            case 0:
                return predmet.getSifraPredmeta();
            case 1:
                return predmet.getNazivPredmeta();
            case 2:
                return predmet.getBrojESPB();
            case 3:
                return predmet.getGodinaStudija();
            case 4:
                return predmet.getSemestar().toString();
            default:
                return null;
        }
    }

    public String getValueAtProfesor(int row, int column, Profesor profesor){
        Predmet predmet = profesor.getPredmeti().get(row); //predmeti.get(row);
        switch (column){
            case 0:
                return predmet.getSifraPredmeta();
            case 1:
                return predmet.getNazivPredmeta();
            case 2:
                return predmet.getGodinaStudija();
            case 3:
                return predmet.getSemestar().toString();
            default:
                return null;
        }
    }
    
    public void dodajPredmet(String sifraPredmeta, String nazivPredmeta, Semestar semestar, String godinaStudija,
			Profesor predmetniProfesor, int brojESPB, ArrayList<Student> spisakPolozenih,
			ArrayList<Student> spisakNepolozenih)
    {
    	this.predmeti.add(new Predmet( sifraPredmeta,  nazivPredmeta,  semestar,  godinaStudija,
    			 predmetniProfesor,  brojESPB, spisakPolozenih, spisakNepolozenih));
    }

    public void serialization() throws IOException {
        File file = new File("data"+File.separator+"predmeti.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        try {
            oos.writeObject(predmeti);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			oos.close();
		}
    }

    public void deserialization() throws FileNotFoundException, IOException {
        File file = new File("data"+File.separator+"predmeti.txt");
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            ArrayList<Predmet> inPredmeti = (ArrayList<Predmet>) ois.readObject();
            predmeti = inPredmeti;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ois.close();
        }
    }
}
