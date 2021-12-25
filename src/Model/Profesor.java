package Model;
import java.time.LocalDate;
import java.util.ArrayList;

public class Profesor {
	
	private String prezime;
	private String ime;
	private LocalDate datumRodjenja;
	private Adresa adresaStanovanja;
	private String kontaktTelefon;
	private String emailAdresa;
	private Adresa adresaKancelarije;
	private int brojLicneKarte;
	private String zvanje;
	private int godineStaza;
	private ArrayList<Predmet> predmeti;
	
	
	public Profesor() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Profesor(String prezime, String ime, LocalDate datumRodjenja, Adresa adresaStanovanja, String kontaktTelefon,
			String emailAdresa, Adresa adresaKancelarije, int brojLicneKarte, String zvanje, int godineStaza) {
		super();
		this.prezime = prezime;
		this.ime = ime;
		this.datumRodjenja = datumRodjenja;
		this.adresaStanovanja = adresaStanovanja;
		this.kontaktTelefon = kontaktTelefon;
		this.emailAdresa = emailAdresa;
		this.adresaKancelarije = adresaKancelarije;
		this.brojLicneKarte = brojLicneKarte;
		this.zvanje = zvanje;
		this.godineStaza = godineStaza;
		this.predmeti = new ArrayList<Predmet>();
	}

	public void changeProfesor(Profesor profesor) {
		this.prezime = profesor.getPrezime();
		this.ime = profesor.getIme();
		this.datumRodjenja = profesor.getDatumRodjenja();
		this.adresaStanovanja = profesor.getAdresaStanovanja();
		this.kontaktTelefon = profesor.getKontaktTelefon();
		this.emailAdresa = profesor.getEmailAdresa();
		this.adresaKancelarije = profesor.getAdresaKancelarije();
		this.brojLicneKarte = profesor.getBrojLicneKarte();
		this.zvanje = profesor.getZvanje();
		this.godineStaza = profesor.getGodineStaza();
		this.predmeti = profesor.getPredmeti();
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public LocalDate getDatumRodjenja() {
		return datumRodjenja;
	}

	public void setDatumRodjenja(LocalDate datumRodjenja) {
		this.datumRodjenja = datumRodjenja;
	}

	public Adresa getAdresaStanovanja() {
		return adresaStanovanja;
	}

	public void setAdresaStanovanja(Adresa adresaStanovanja) {
		this.adresaStanovanja = adresaStanovanja;
	}

	public String getKontaktTelefon() {
		return kontaktTelefon;
	}

	public void setKontaktTelefon(String kontaktTelefon) {
		this.kontaktTelefon = kontaktTelefon;
	}

	public String getEmailAdresa() {
		return emailAdresa;
	}

	public void setEmailAdresa(String emailAdresa) {
		this.emailAdresa = emailAdresa;
	}

	public Adresa getAdresaKancelarije() {
		return adresaKancelarije;
	}

	public void setAdresaKancelarije(Adresa adresaKancelarije) {
		this.adresaKancelarije = adresaKancelarije;
	}

	public int getBrojLicneKarte() {
		return brojLicneKarte;
	}

	public void setBrojLicneKarte(int brojLicneKarte) {
		this.brojLicneKarte = brojLicneKarte;
	}

	public String getZvanje() {
		return zvanje;
	}

	public void setZvanje(String zvanje) {
		this.zvanje = zvanje;
	}

	public int getGodineStaza() {
		return godineStaza;
	}

	public void setGodineStaza(int godineStaza) {
		this.godineStaza = godineStaza;
	}

	public ArrayList<Predmet> getPredmeti() {
		return predmeti;
	}

	public void setPredmeti(ArrayList<Predmet> predmeti) {
		this.predmeti = predmeti;
	}



	@Override
	public String toString() {
		return "Profesor [prezime=" + prezime + ", ime=" + ime + ", datumRodjenja=" + datumRodjenja
				+ ", adresaStanovanja=" + adresaStanovanja + ", kontaktTelefon=" + kontaktTelefon + ", emailAdresa="
				+ emailAdresa + ", adresaKancelarije=" + adresaKancelarije + ", brojLicneKarte=" + brojLicneKarte
				+ ", zvanje=" + zvanje + ", godineStaza=" + godineStaza + ", predmeti=" + predmeti + "]";
	}
}
