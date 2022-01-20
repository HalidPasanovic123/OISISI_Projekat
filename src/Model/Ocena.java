package Model;

public enum Ocena {
	PET(5),SEST(6),SEDAM(7),OSAM(8),DEVET(9),DESET(10);
	int ocena;
	
	private Ocena() {}
	private Ocena(int i) {this.ocena = i;}
	
	@SuppressWarnings("unused")
	private String[] opis = {"PET","SEST","SEDAM","OSAM","DEVET","10"};
}
