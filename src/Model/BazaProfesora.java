package Model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class BazaProfesora {

    private static BazaProfesora instance = null;

    public static BazaProfesora getInstance(){
        if (instance == null) {
            instance = new BazaProfesora();
        }
        return instance;
    }

    private List<Profesor> profesors;
    private List<String> columns;

    private BazaProfesora(){
        this.columns = new ArrayList<String>();
        this.profesors = new ArrayList<Profesor>();

        profesors.add(new Profesor("prezime", "ime", LocalDate.now(), new Adresa(), "kontaktTelefon", "emailAdresa", new Adresa(), 65, "zvanje", 3, new ArrayList<>()));
        profesors.add(new Profesor("prezime", "ime", LocalDate.now(), new Adresa(), "kontaktTelefon", "emailAdresa", new Adresa(), 65, "zvanje", 3, new ArrayList<>()));
        profesors.add(new Profesor("prezime", "ime", LocalDate.now(), new Adresa(), "kontaktTelefon", "emailAdresa", new Adresa(), 65, "zvanje", 3, new ArrayList<>()));

        this.columns.add("Prezime");
        this.columns.add("Ime");
        this.columns.add("Zvanje");
        this.columns.add("E-Mail adresa");
    }

    public List<Profesor> getProfesors(){
        return profesors;
    }

    public int getRowCount(){
        return profesors.size();
    }

    public void setProfesors(List<Profesor> profesors){
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

    public void changeProfesor(Profesor profesor){
        for (Profesor p : profesors){
            if(p.getBrojLicneKarte() == profesor.getBrojLicneKarte()){
                profesors.remove(p);
                profesors.add(profesor);
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
