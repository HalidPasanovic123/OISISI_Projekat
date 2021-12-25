package Baze;

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

    private BazaPredmeta(){
        this.columns = new ArrayList<String>();
        this.predmeti = new ArrayList<Predmet>();

        predmeti.add(new Predmet("sifraPredmeta", "nazivPredmeta", Semestar.LETNJI, "godinaStudija", new Profesor(), 5, new ArrayList<Student>(), new ArrayList<Student>()));
        predmeti.add(new Predmet("sifraPredmeta", "nazivPredmeta", Semestar.LETNJI, "godinaStudija", new Profesor(), 5, new ArrayList<Student>(), new ArrayList<Student>()));
        predmeti.add(new Predmet("sifraPredmeta", "nazivPredmeta", Semestar.LETNJI, "godinaStudija", new Profesor(), 5, new ArrayList<Student>(), new ArrayList<Student>()));

        this.columns.add("Sifra predmeta");
        this.columns.add("Naziv predmeta");
        this.columns.add("Broj ESPB");
        this.columns.add("Godina studija");
        this.columns.add("Semestar");
    }

    public ArrayList<Predmet> getPredmeti(){
        return predmeti;
    }

    public void setpredmeti(ArrayList<Predmet> predmeti){
        this.predmeti = predmeti;
    }

    public int getRowCount(){
        return predmeti.size();
    }

    public int getColumnCount(){
        return columns.size();
    }

    public String getColumnName(int index){
        return this.columns.get(index);
    }

    public Predmet getRow(int index){
        return this.predmeti.get(index);
    }

    public void addPredmet(Predmet Predmet){
        this.predmeti.add(Predmet);
    }
    
    public void deletePredmet(String sifraPredmeta){
        for (Predmet p : predmeti){
            if(p.getSifraPredmeta() == sifraPredmeta){
                predmeti.remove(p);
                break;
            }
        }
    }

    public void changePredmet(Predmet Predmet){
        for (Predmet p : predmeti){
            if(p.getSifraPredmeta() == Predmet.getSifraPredmeta()){
                predmeti.remove(p);
                predmeti.add(Predmet);
                break;
            }
        } 
    }
    

    public String getValueAt(int row, int column){
        Predmet predmet = predmeti.get(row);
        switch (column){
            case 0:
                return predmet.getSifraPredmeta();
            case 1:
                return predmet.getNazivPredmeta();
            case 2:
                return Long.toString(predmet.getBrojESPB());
            case 3:
                return predmet.getGodinaStudija();
            case 4:
                return predmet.getSemestar().toString();
            default:
                return null;
        }
    }
}
