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

public class BazaProfesora {

    private static BazaProfesora instance = null;

    public static BazaProfesora getInstance(){
        if (instance == null) {
            instance = new BazaProfesora();
        }
        return instance;
    }

    private ArrayList<Profesor> profesors;
    private ArrayList<String> columns;

    private BazaProfesora(){
        this.columns = new ArrayList<String>();
        this.profesors = new ArrayList<Profesor>();

        try {
            deserialization();
        } catch (Exception e) {
            e.printStackTrace();
        }

        this.columns.add("Prezime");
        this.columns.add("Ime");
        this.columns.add("Zvanje");
        this.columns.add("E-Mail adresa");
    }

    public ArrayList<Profesor> getProfesors(){
        return profesors;
    }

    public Profesor getProfesorByID(int id) {
        return profesors.get(id);
    }

    public int getRowCount(){
        return profesors.size();
    }

    public void setProfesors(ArrayList<Profesor> profesors){
        this.profesors = profesors;
    }

    public int getColumnCount(){
        return columns.size();
    }

    public String getColumnName(int index){
        return this.columns.get(index);
    }

    public Profesor getRow(int index){
        return this.profesors.get(index);
    }

    public void addProfesor(Profesor profesor){
        this.profesors.add(profesor);
    }
    
    public void deleteProfesor(Profesor profesor){
        for (Profesor p : profesors){
            if(p.getBrojLicneKarte() == profesor.getBrojLicneKarte()){
                profesors.remove(p);
                break;
            }
        }
    }

    public void dodajPredmetNaProfesor(Predmet predmet, Profesor profesor) {
        for (Profesor p : profesors){
            if(p.getBrojLicneKarte() == profesor.getBrojLicneKarte()){
                p.getPredmeti().add(predmet);
                break;
            }
        }
    }

    public void obrisiPredmetSaProfesora(Predmet predmet, Profesor profesor) {
        for (Profesor p : profesors){
            if(p.getBrojLicneKarte() == profesor.getBrojLicneKarte()){
                p.brisanjePredmeta(predmet);
                break;
            }
        }
    }

    public void changeProfesor(Profesor profesor, int prethodniBrojLicne){
        for (Profesor p : profesors){
            if(p.getBrojLicneKarte() == prethodniBrojLicne){
                p.changeProfesor(profesor);
                break;
            }
        } 
    }

    public String getValueAt(int row, int column){
        Profesor profesor = profesors.get(row);
        switch (column){
            case 0:
                return profesor.getPrezime();
            case 1:
                return profesor.getIme();
            case 2:
                return profesor.getZvanje();
            case 3:
                return profesor.getEmailAdresa();
            default:
                return null;
        }
    }

    public String getValueAtDodaj(int row, int column){
        Profesor profesor = profesors.get(row);
        switch (column){
            case 0:
                return profesor.getPrezime() + " " + profesor.getIme();
            default:
                return null;
        }
    }

    public void serialization() throws IOException {
        File file = new File("data"+File.separator+"profesori.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        try {
            oos.writeObject(profesors);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			oos.close();
		}
    }

    public void deserialization() throws FileNotFoundException, IOException {
        File file = new File("data"+File.separator+"profesori.txt");
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            ArrayList<Profesor> inProfesors = (ArrayList<Profesor>) ois.readObject();
            profesors = inProfesors;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ois.close();
        }
    }

}
