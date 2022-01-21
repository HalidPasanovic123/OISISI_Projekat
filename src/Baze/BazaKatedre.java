package Baze;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import Model.Katedra;

public class BazaKatedre {
	private static BazaKatedre instance = null;

	private List<Katedra> katedre;

    public static BazaKatedre getInstance() {
		if (instance == null) {
			instance = new BazaKatedre();
		}
		return instance;
	}

    private BazaKatedre()
    {
        initKatedre();
    }

    public List<Katedra> getKatedre() {
		return katedre;
	}

    private void initKatedre() {
		try {
            deserialization();
        } catch (Exception e) {
            e.printStackTrace();
        }

	 }

    public void serialization() throws IOException {
        File file = new File("data"+File.separator+"katedre.txt");
        ObjectOutputStream oos = new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(file)));
        try {
            oos.writeObject(katedre);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
			oos.close();
		}
    }

	public void deserialization() throws FileNotFoundException, IOException {
        File file = new File("data"+File.separator+"katedre.txt");
        ObjectInputStream ois = new ObjectInputStream(new BufferedInputStream(new FileInputStream(file)));
        try {
            ArrayList<Katedra> inStudents = (ArrayList<Katedra>) ois.readObject();
            katedre = inStudents;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            ois.close();
        }
    }
}
