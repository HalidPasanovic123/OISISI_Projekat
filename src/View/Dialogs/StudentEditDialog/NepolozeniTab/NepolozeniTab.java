package View.Dialogs.StudentEditDialog.NepolozeniTab;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Baze.BazaStudenata;
import Controllers.PredmetController;
import Model.Student;
import View.Dialogs.StudentEditDialog.StudentEditTabbedPane;
import View.Dialogs.StudentEditDialog.NepolozeniTab.PolaganjeButton.PolaganjeJDialog;

public class NepolozeniTab extends JPanel {
	
	private StudentNepolozeniJTable nepolozeniJTable;
	private NepolozeniTab nepolozenitab = this;

	public NepolozeniTab(int row, StudentEditTabbedPane parent) {
		super();
		JButton dodaj=new JButton("Dodaj");
		this.add(dodaj, BorderLayout.NORTH);
		dodaj.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				DodavanjePredmetaStudentu dps = new DodavanjePredmetaStudentu(nepolozenitab, BazaStudenata.getInstance().findStudentByRow(row).getIndeks());
				dps.setVisible(true);
			}

		});
		JButton obrisi=new JButton("Obriši");
		this.add(obrisi,  BorderLayout.NORTH);
		obrisi.addActionListener(new ActionListener() 
		{
			@Override
			public void actionPerformed(ActionEvent e) {
				if (nepolozeniJTable.getSelectedRow() != -1)
				{
					Student s = BazaStudenata.getInstance().findStudentByRow(row);
					int reply=JOptionPane.showOptionDialog(nepolozenitab, 
					        "Da li ste sigurni da želite da uklonite predmet?", 
					        "Uklanjanje predmeta", 
					        JOptionPane.OK_CANCEL_OPTION, 
					        JOptionPane.INFORMATION_MESSAGE, 
					        null, 
					        new String[]{"Da", "Ne"}, 
					        "default");
					if(reply==JOptionPane.YES_OPTION) 
					{
						BazaStudenata.getInstance().ukloniPredmet(s.getIndeks(), nepolozenitab.getNepolozeniJTable());
						nepolozenitab.getNepolozeniJTable().azuriraj();						
					}
				}
			}
		});
		
		JButton polaganje=new JButton("Polaganje");
		polaganje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int temp = nepolozeniJTable.getSelectedRow();
				if (temp != -1) {
					Student s = BazaStudenata.getInstance().findStudentByRow(row);
					int tep = nepolozeniJTable.convertRowIndexToModel(temp);
					PolaganjeJDialog polaganje = new PolaganjeJDialog(s.getNepolozeniPredmeti().get(tep), parent);
					polaganje.setVisible(true);
				}
			}

		});
		this.add(polaganje, BorderLayout.NORTH);
		
		JPanel jpanel=new JPanel();
		this.add(jpanel, BorderLayout.NORTH);
		
		nepolozeniJTable= new StudentNepolozeniJTable(row);
		JScrollPane scrollPane = new JScrollPane(nepolozeniJTable);
		this.add(scrollPane,BorderLayout.CENTER);
	}

	public void updateShowingOfNepolozeni(){
		AbstractTableModelNepolozeni model = (AbstractTableModelNepolozeni) nepolozeniJTable.getModel();
		model.fireTableDataChanged();
		validate();
	}
	public StudentNepolozeniJTable getNepolozeniJTable() {
		return nepolozeniJTable;
	}
}

