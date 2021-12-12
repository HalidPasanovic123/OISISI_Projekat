package Model;

import java.util.ArrayList;

public class Student {
	
	private String ime;
	private String prezime;
	private String datumRodjenja;
	private String adresa;
	private String kontakt;
	private String eMail;
	private String indeks;
	private String godinaUpisa;
	private int godinaStudija;
	private Status status;
	private float prosecnaOcena;
	private ArrayList<OcenaNaIspitu> ocenePolozenihPredmeta;
	private ArrayList<OcenaNaIspitu> nepolozeniPredmeti;
	
	public Student(String ime, String prezime, String datumRodjenja, String adresa, String kontakt, String eMail,
			String indeks, String godinaUpisa, int godinaStudija, Status status, float prosecnaOcena,
			ArrayList<OcenaNaIspitu> ocenePolozenihPredmeta, ArrayList<OcenaNaIspitu> nepolozeniPredmeti) {
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

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
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

	public void setGodinaUpisa(String godinaUpisa) {
		this.godinaUpisa = godinaUpisa;
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

	public ArrayList<OcenaNaIspitu> getNepolozeniPredmeti() {
		return nepolozeniPredmeti;
	}

	public void setNepolozeniPredmeti(ArrayList<OcenaNaIspitu> nepolozeniPredmeti) {
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
}
