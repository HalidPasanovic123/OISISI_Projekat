package Baze;

import java.time.LocalDate;
import java.util.ArrayList;

import Model.Adresa;
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

        profesors.add(new Profesor("Pasanovic", "Halid", LocalDate.now(),  new Adresa("Kisacka", 44, "Novi Sad", "Srbija"), "12345", "halidpasanovic1000@gmail.com", new Adresa("Kisacka", 44, "Novi Sad", "Srbija"), 65, "Profesor", 3));
        profesors.add(new Profesor("Spasojevic", "Aleksa", LocalDate.now(),  new Adresa("Kisacka", 44, "Novi Sad", "Srbija"), "12345", "halidpasanovic1000@gmail.com", new Adresa("Kisacka", 44, "Novi Sad", "Srbija"), 66, "Profesor", 3));
        profesors.add(new Profesor("Pasanovic", "David", LocalDate.now(),  new Adresa("Kisacka", 44, "Novi Sad", "Srbija"), "12345", "halidpasanovic1000@gmail.com", new Adresa("Kisacka", 44, "Novi Sad", "Srbija"), 67, "Profesor", 3));
        

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
    
    public void deleteProfesor(int brojLicneKarte){
        for (Profesor p : profesors){
            if(p.getBrojLicneKarte() == brojLicneKarte){
                profesors.remove(p);
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

}
