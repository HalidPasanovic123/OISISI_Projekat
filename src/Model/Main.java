package Model;

import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student student1 = new Student();
		Student student2 = new Student();
		student1.setIme("Aleksa");
		student1.setIndeks("RA136/2019");
		student2.setIme("Halid");
		student2.setPrezime("Pašanoviæ");
		student2.setGodinaStudija(3);
		System.out.println(student1.getIme());
		
		
		ArrayList<Student> lista1 = new ArrayList();
		ArrayList<Student> lista2 = new ArrayList();
		lista1.add(student1);
		lista2.add(student2);
		
		Profesor profesor1 = new Profesor();
		profesor1.setIme("Nebojsa");
		profesor1.setPrezime("Ralevic");
		profesor1.setAdresaKancelarije("Kabinet 612");
		profesor1.setEmailAdresa("nralevic@uns.ac.rs");

		Predmet analiza1 = new Predmet("E212","Matematicka Analiza1", Semestar.LETNJI, "1", profesor1, 9,lista2,lista1);
		System.out.println(analiza1.toString());
		
		OcenaNaIspitu ocena_analiza = new OcenaNaIspitu(student2, analiza1, "01.02.2020",Ocena.SEDAM);
		System.out.println(ocena_analiza.toString());
	}

}
