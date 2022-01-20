package View.Dialogs.StudentEditDialog;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import AbstractTableModels.AbstractTableModelPolozeniPredmeti;
import Baze.BazaStudenata;
import Model.OcenaNaIspitu;
import Model.Predmet;
import Model.Student;



public class PolozeniTab extends JPanel
{
	
	private static JButton ponistiButton;
	private  PolozeniJTable polozeniJTable;
	
	static JLabel prosekL;
	static JLabel espbL;
	
	
	public PolozeniTab(int row, StudentEditTabbedPane parent)
	{
		Student student = BazaStudenata.getInstance().getRow(row);
				
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
				
		polozeniJTable= parent.getPolozeniJTable();
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE, new Insets(0, 30, 0, 0), 0, 0);
		ponistiButton = new JButton("Poništi ocenu");
		this.add(ponistiButton,gbc);
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 30, 10, 30), 0, 0);
		JScrollPane sPane = new JScrollPane(polozeniJTable);
		this.add(sPane,gbc);
		
		float prosek = BazaStudenata.getInstance().getProsek(student);
		String prosekTxt = String.format("Prosečna ocena: %.2f", prosek);
		prosekL = new JLabel(prosekTxt);
		gbc=new GridBagConstraints(0, 2, 3, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0);
		this.add(prosekL,gbc);
		
		int espb = BazaStudenata.getInstance().getESPB(student.getIndeks());
		String espbTxt = String.format("Ukupno ESPB: %d", espb);
		espbL = new JLabel(espbTxt);
		gbc=new GridBagConstraints(0, 3, 3, 1, 100, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(0, 0, 0, 10), 0, 0);
		this.add(espbL,gbc);
		
		ponistiButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int rowTable =  polozeniJTable.getSelectedRow();
				if (rowTable != -1){
					int reply=JOptionPane.showOptionDialog(parent, 
			        "Da li ste sigurni da želite da ponistite ocenu?", 
			        "Ponistavanje ocene", 
			        JOptionPane.OK_CANCEL_OPTION, 
			        JOptionPane.INFORMATION_MESSAGE, 
			        null, 
			        new String[]{"Da", "Ne"}, 
			        "default");
					if(reply==JOptionPane.YES_OPTION) {
						Student student = BazaStudenata.getInstance().getRow(row);
						
						OcenaNaIspitu ocena = student.getOcenePolozenihPredmeta().get(polozeniJTable.convertRowIndexToModel(rowTable));

						//Brisanje iz liste polozenih predmeta kod studenta
						student.getOcenePolozenihPredmeta().remove(ocena);
						
						//Dodavanje u listu nepolozenih predmeta
						student.getNepolozeniPredmeti().add(ocena.getPredmet());
						
						//Dodavanje u spisak nepolozenih studenata predmeta
						ocena.getPredmet().getSpisakNepolozenih().add(student);

						//Brisanje iz spiska polozenih studenata predmeta
						ocena.getPredmet().getSpisakPolozenih().remove(student);

						parent.getNepolozeniTab().updateShowingOfNepolozeni();

						parent.getPolozeniTab().updateShowingOfPolozeni();
					}
				}
			}

		});
	}

	public void updateShowingOfPolozeni(){
		AbstractTableModelPolozeniPredmeti model = (AbstractTableModelPolozeniPredmeti) polozeniJTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
