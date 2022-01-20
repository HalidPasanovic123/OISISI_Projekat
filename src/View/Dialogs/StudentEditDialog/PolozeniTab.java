package View.Dialogs.StudentEditDialog;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

	private Student student;
	
	
	public PolozeniTab(int row, StudentEditTabbedPane parent)
	{
		student = BazaStudenata.getInstance().getRow(row);
				
		ponistiButton = new JButton("Poni�ti ocenu");
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
		this.add(ponistiButton, BorderLayout.NORTH);
		
		polozeniJTable= parent.getPolozeniJTable();
		JScrollPane scrollPane = new JScrollPane(polozeniJTable);
		this.add(scrollPane, BorderLayout.CENTER);
	}

	public void updateShowingOfPolozeni(){
		AbstractTableModelPolozeniPredmeti model = (AbstractTableModelPolozeniPredmeti) polozeniJTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
}
