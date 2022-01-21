package Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Student implements Serializable{
	
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private Adresa adresa;
	private String kontakt;
	private String eMail;
	private String indeks;
	private String godinaUpisa;
	private int godinaStudija;
	private Status status;
	private float prosecnaOcena;
	private ArrayList<OcenaNaIspitu> ocenePolozenihPredmeta;
	private ArrayList<Predmet> nepolozeniPredmeti;
	
	public Student(String ime, String prezime, String datumRodjenja, Adresa adresa, String kontakt, String eMail,
			String indeks, String godinaUpisa, int godinaStudija, Status status, float prosecnaOcena,
			ArrayList<OcenaNaIspitu> ocenePolozenihPredmeta, ArrayList<Predmet> nepolozeniPredmeti) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.datumRodjenja = datumRodjenja;
		this.adresa = adresa;
		this.kontakt = kontakt;
		this.eMail = eMail;
		this.indeks = indeks;
		this.godinaUpisa = godinaUpisa;
		this.godinaStudija = godinaStudija;
		this.status = status;
		this.prosecnaOcena = prosecnaOcena;
		this.ocenePolozenihPredmeta = ocenePolozenihPredmeta;
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}

	public Student() {
		super();
	}
	
	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(String datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Adresa getAdresa() {
		return adresa;
	}

	public void setAdresa(Adresa adresa) {
		this.adresa = adresa;
	}

	public String getKontakt() {
		return kontakt;
	}

	public void setKontakt(String kontakt) {
		this.kontakt = kontakt;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	public String getIndeks() {
		return indeks;
	}

	public void setIndeks(String indeks) {
		this.indeks = indeks;
	}

	public String getGodinaUpisa() {
		return godinaUpisa;
	}

	public void setGodinaUpisa(String godina) {
		this.godinaUpisa = godina;
	}

	public int getGodinaStudija() {
		return godinaStudija;
	}

	public void setGodinaStudija(int godinaStudija) {
		this.godinaStudija = godinaStudija;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public float getProsecnaOcena() {
		return prosecnaOcena;
	}

	public void setProsecnaOcena(float prosecnaOcena) {
		this.prosecnaOcena = prosecnaOcena;
	}

	public ArrayList<OcenaNaIspitu> getOcenePolozenihPredmeta() {
		return ocenePolozenihPredmeta;
	}

	public void setOcenePolozenihPredmeta(ArrayList<OcenaNaIspitu> ocenePolozenihPredmeta) {
		this.ocenePolozenihPredmeta = ocenePolozenihPredmeta;
	}

	public ArrayList<Predmet> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}

	public void brisanjeNepolozenog(Predmet predmet) {
		for (Predmet p : nepolozeniPredmeti){
			if(p.getSifraPredmeta() == predmet.getSifraPredmeta()){
				nepolozeniPredmeti.remove(p);
				break; 
			}
		}
	}

	public String getValueAtPolozeni() {
		return null;
	}

	public void setNepolozeniPredmeti(ArrayList<Predmet> nepolozeniPredmeti) {
		this.nepolozeniPredmeti = nepolozeniPredmeti;
	}

	@Override
	public String toString() {
		return "Student [ime=" + ime + ", prezime=" + prezime + ", datumRodjenja=" + datumRodjenja + ", adresa="
				+ adresa + ", kontakt=" + kontakt + ", eMail=" + eMail + ", indeks=" + indeks + ", godinaUpisa="
				+ godinaUpisa + ", godinaStudija=" + godinaStudija + ", status=" + status + ", prosecnaOcena="
				+ prosecnaOcena + ", ocenePolozenihPredmeta=" + ocenePolozenihPredmeta + ", nepolozeniPredmeti="
				+ nepolozeniPredmeti + "]";
	}
	
	public String ispisiAdresu()
	{
		String s = "";
		if(this.adresa.getUlica() != null)
		{
			s += this.adresa.getUlica() + " ";
		}
		if(this.adresa.getBroj() != 0)
		{
			s += this.adresa.getBroj() + " ";
		}
		if(this.adresa.getGrad() != null)
		{
			s += this.adresa.getGrad() + " ";
		}
		if(this.adresa.getDrzava() != null)
		{
			s += this.adresa.getDrzava() + " ";
		}
		return s;
	}
}
