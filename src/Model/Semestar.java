package Model;

public enum Semestar {

	LETNJI,ZIMSKI;
	
	private String[] opis = {"LETNJI", "ZIMSKI"};
	
	@Override
	public String toString()
	{
		return opis[this.ordinal()];
	}
}
