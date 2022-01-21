package Model;

public enum Status  {
	B, S;
	
	private String [] opis = {"B", "S"};
	
	@Override
	public String toString()
	{
		return opis[this.ordinal()];
	}
}
