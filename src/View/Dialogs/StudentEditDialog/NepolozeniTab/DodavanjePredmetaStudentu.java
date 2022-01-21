package View.Dialogs.StudentEditDialog.NepolozeniTab;

import java.util.List;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;

import Baze.BazaPredmeta;
import Baze.BazaStudenata;
import Model.OcenaNaIspitu;
import Model.Predmet;
import Model.Student;

public class DodavanjePredmetaStudentu extends JDialog{
    
    List<Predmet> predmetiZaDodavanje;
	private static Student s;

    public DodavanjePredmetaStudentu(NepolozeniTab parent, String brojIndeksa) {
		
		
		super();
		setSize(400,500);
		setLocationRelativeTo(parent);
		
		s = BazaStudenata.getInstance().getStudentByIndeks(brojIndeksa);
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc;
		setModal(true);
		setTitle("Dodavanje predmeta");
		ArrayList<Predmet> polozeniPredmeti = getPolozeniPredmeti(s, s.getOcenePolozenihPredmeta());
		predmetiZaDodavanje =new ArrayList<Predmet>(BazaPredmeta.getInstance().getPredmeti());
		int index=0;
		ArrayList<Predmet> tmpList=new ArrayList<Predmet>(predmetiZaDodavanje);
		
	
		for (Predmet p:tmpList) {
			if (s.getGodinaStudija() < Integer.valueOf(p.getGodinaStudija())) {
				predmetiZaDodavanje.remove(index);
				index--;
			}
			index++;
		}
		
		if(s.getNepolozeniPredmeti() != null){
			for (int i = 0; i < s.getNepolozeniPredmeti().size(); i++) {
				for (int j = 0; j < predmetiZaDodavanje.size(); j++) {
					if (predmetiZaDodavanje.get(j).getSifraPredmeta().equals(s.getNepolozeniPredmeti().get(i).getSifraPredmeta())) {
						predmetiZaDodavanje.remove(j);
					}
				}
			}
		}

		if(polozeniPredmeti != null){
			for (int i=0;i<polozeniPredmeti.size();i++) {
				for (int j=0;j<predmetiZaDodavanje.size();j++) {
					if (polozeniPredmeti.get(i).getSifraPredmeta().equalsIgnoreCase(predmetiZaDodavanje.get(j).getSifraPredmeta())) {
						predmetiZaDodavanje.remove(j);
					}
				}
			}
		}
		
		DefaultListModel<String> lista = new DefaultListModel<>(); 
		for (Predmet p:predmetiZaDodavanje) {
			String naziv=p.getSifraPredmeta()+"-"+p.getNazivPredmeta();
			lista.addElement(naziv);
		}
		JList<String> list=new JList<>(lista);
		JScrollPane scrollP=new JScrollPane(list);
		
		gbc=new GridBagConstraints(0, 0, 2, 1, 100, 100, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 20, 40, 20), 0, 0);
		this.add(scrollP,gbc);
		
		JButton btnDodaj=new JButton("Dodaj");
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 100, 20, 0), 0, 0);
		this.add(btnDodaj,gbc);

        btnDodaj.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (list.getSelectedIndex() != -1)
				{
					Predmet p=predmetiZaDodavanje.get(list.getSelectedIndex());
					predmetiZaDodavanje.remove(list.getSelectedIndex());
					s.getNepolozeniPredmeti().add(p);
					parent.getNepolozeniJTable().azuriraj();
					dispose();
				}
			}
		});
		
		JButton btnOdustani=new JButton("Odustani");
		gbc=new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 30, 20, 0), 0, 0);
		this.add(btnOdustani,gbc);		
		btnOdustani.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
			
		});
	}

    private ArrayList<Predmet> getPolozeniPredmeti(Student s,List<OcenaNaIspitu> ocene) {
		ArrayList<Predmet> predmeti = new ArrayList<Predmet>();
		if(ocene == null){
			return null;
		} 
		for (OcenaNaIspitu o : ocene) 
		{
			if (o.getStudentPolozio().getIndeks().equals(s.getIndeks())) 
			{
				predmeti.add(o.getPredmet());
			}
		}
		return predmeti;
	}


}
