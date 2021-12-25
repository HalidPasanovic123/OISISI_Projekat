/*package View.MainWindowWithComponents.MainTabPanels;

import java.text.DateFormat;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Baze.BazaStudenata;
import Controllers.StudentController;
import Model.Student;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import View.Dialogs.StudentEditDialog.StudentEditTabbedPane;

public class PolozeniPredmetiTab extends JPanel{

	private static JButton ponistiO;
	private static JLabel prosekL;
	private static JLabel espbL;
	
	
	
	public PolozeniPredmetiTab(int row, StudentEditTabbedPane parent)
	{
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		
		Student student = BazaStudenata.getInstance().getRow(row);
		
		OcenaJTable tabOcena = OcenaJTable.getInstance();
		JScrollPane sPane = new JScrollPane(tabOcena);
		
		
		
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 30, 0, 0), 0, 0);
		ponistiO = new JButton("Poništi ocenu");
		this.add(ponistiO,gbc);
		
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 100, 0, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 30, 10, 30), 0, 0);

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
		
		
		ponistiO.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (tabOcena.getSelectedRow() != -1)
				{
					Student s = BazaStudenata.getInstance().findStudentByRow(row);
					 
					int reply=JOptionPane.showOptionDialog(tabOcena, 
					        "Da li ste sigurni da želite da poništite ocenu?", 
					        "Poništavanje ocene", 
					        JOptionPane.OK_CANCEL_OPTION, 
					        JOptionPane.INFORMATION_MESSAGE, 
					        null, 
					        new String[]{"Da", "Ne"}, 
					        "default");
					if(reply==JOptionPane.YES_OPTION) {
						StudentController.getInstance().ponistiOcenu(student.getIndeks(), parent.getNepolozeniJTable());
						updateLabele(s);
						validate();
							
						}
				}
				
			}
		});
		
		
		
		
	}
	
	public static void updateLabele(Student s) {

		
		float prosek = BazaStudent.getInstance().getProsek(s); 
		
		
		
																														
		String prosekTxt = String.format("Prosečna ocena: %.2f", prosek);
		prosekL.setText(prosekTxt);
		
		int espb = BazaStudent.getInstance().getESPB(s.getBrojIndeksa());
																												
		String espbTxt = String.format("Ukupno ESPB: %d", espb);
		espbL.setText(espbTxt);
	}
	
}*/
