package View.Dialogs.StudentEditDialog.NepolozeniTab;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Controllers.PredmetController;
import Controllers.StudentController;
import View.Dialogs.StudentEditDialog.StudentEditTabbedPane;
import View.Dialogs.StudentEditDialog.NepolozeniTab.PolaganjeButton.PolaganjeJDialog;

public class NepolozeniTab extends JPanel {
	private StudentNepolozeniJTable nepolozeniJTable;

	public NepolozeniTab(int row, StudentEditTabbedPane parent) {
		super();

		JButton dodaj=new JButton("Dodaj");
		this.add(dodaj, BorderLayout.NORTH);
		
		JButton obrisi=new JButton("Obriši");
		this.add(obrisi,  BorderLayout.NORTH);
		
		JButton polaganje=new JButton("Polaganje");

		NepolozeniTab temp1 = this;
		polaganje.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int temp = nepolozeniJTable.getSelectedRow();
				if (temp != -1) {
					PolaganjeJDialog polaganje = new PolaganjeJDialog(PredmetController.getInstance().getPredmetByID(nepolozeniJTable.convertRowIndexToModel(temp)), parent, temp1);
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
}

