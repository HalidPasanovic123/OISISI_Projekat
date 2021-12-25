package View.Dialogs;

import java.awt.Frame;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.JTextField;

import Model.Student;
import View.MainWindowWithComponents.MainWindow;
import Baze.BazaStudenata;
import Model.Adresa;
import Model.Status;
import Controllers.StudentController;

public class StudentJDialog  extends JDialog{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public StudentJDialog() 
	{
		super();

		setSize(500, 500);
		setLocationRelativeTo(MainWindow.getInstance());
		
		
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc;
		
		gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label1 = new JLabel("Ime*");
		this.add(label1,gbc);
		
		JTextField txtField1=new JTextField();
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField1,gbc);
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label2 = new JLabel("Prezime*");
		this.add(label2,gbc);
		
		JTextField txtField2 = new JTextField();
		gbc=new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField2,gbc);
		
		gbc=new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label3=new JLabel("Datum roÄ‘enja*");
		this.add(label3,gbc);
		
		JTextField txtField3=new JTextField();
		txtField3.setToolTipText("dd.mm.yyyy.");
		gbc=new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField3,gbc);
		

		gbc=new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label4=new JLabel("Adresa stanovanja*");
		this.add(label4,gbc);
		
		JTextField txtField4=new JTextField();
		txtField4.setToolTipText("ulica broj, grad");
		gbc=new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField4,gbc);
		
		gbc=new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label5=new JLabel("Broj telefona*");
		this.add(label5,gbc);
		
		JTextField txtField5=new JTextField();
		gbc=new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField5,gbc);
		
		gbc=new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label6=new JLabel("E-mail adresa*");
		this.add(label6,gbc);
		
		JTextField txtField6=new JTextField();
		gbc=new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField6,gbc);
		
		gbc=new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label7=new JLabel("Broj indeksa*");
		this.add(label7,gbc);
		
		JTextField txtField7=new JTextField();
		//txtField7.setToolTipText("SMER-BROJ-GODINA");
		gbc=new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField7,gbc);
		
		gbc=new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label8=new JLabel("Godina upisa*");
		this.add(label8,gbc);
		
		JTextField txtField8=new JTextField();
		gbc=new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField8,gbc);
		
		gbc=new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label9=new JLabel("Trenutna godina studija*");
		this.add(label9,gbc);
		
	
		ArrayList<String> valsGS = new ArrayList<String>();
		valsGS.add("I (prva)");
		valsGS.add("II (druga)");
		valsGS.add("III (treca)");
		valsGS.add("IV (cetvrta)");
		valsGS.add("V (peta)");
		final JComboBox<String> combo = new JComboBox(valsGS.toArray()) ;
		gbc=new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 140, 0);
		this.add(combo,gbc);
		
		
		
		gbc=new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label10=new JLabel("Nacin finansiranja*");
		this.add(label10,gbc);
		
		ArrayList<String> valsStatus = new ArrayList<String>();
		valsStatus.add("Budzet");
		valsStatus.add("Samofinansiranje");
		
		
		final JComboBox<String> combo2 = new JComboBox(valsStatus.toArray());
		gbc=new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 103, 0);
		this.add(combo2,gbc);
		
		JButton btnPotvrdi=new JButton("Potvrdi");
		gbc=new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0);
		this.add(btnPotvrdi,gbc);
		
		JButton btnOdustani=new JButton("Odustani");
		gbc=new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 0, 0);
		this.add(btnOdustani,gbc);
		
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String prezime=txtField2.getText();
				String ime=txtField1.getText();
				Adresa adresaStanovanja = new Adresa();
				adresaStanovanja.setGrad(txtField5.getText());
				String brojTelefona=txtField5.getText();
				
				String emailAdresa=txtField6.getText();
				String brojIndeksa=txtField7.getText();
				
				String godinaUpisa=txtField8.getText();
				
				int godinaStudiranja;
				if (combo.getSelectedItem().toString().equals("I (prva)"))
					 godinaStudiranja = 1;
				else if (combo.getSelectedItem().toString().equals("II (druga)"))
					 godinaStudiranja = 2;
				else if (combo.getSelectedItem().toString().equals("III (treca)"))
					 godinaStudiranja = 3;
				else if (combo.getSelectedItem().toString().equals("IV (cetvrta)"))
					 godinaStudiranja = 4;
				else godinaStudiranja = 5;
				
				
				boolean postoji = false;
				for (Student s : StudentController.getInstance().getStudenti())
				{
					if (s.getIndeks().equals(brojIndeksa))
						postoji = true;
				}
				

				Status status;
				if (combo2.getSelectedItem().toString().equals("BudĹľet"))
					status = Status.B;
				else
					status = Status.S;
				
				btnPotvrdi.setEnabled(false);
				if(!Pattern.matches("([a-zA-ZĹˇÄ‘ÄŤÄ‡ĹľĹ Ä�ÄŚÄ†Ĺ˝]+[\\s]*)+", ime)) {
					JOptionPane.showMessageDialog(null, "Neispravno uneto ime!");
					btnPotvrdi.setEnabled(false);
				} 
				else if(!Pattern.matches("([a-zA-ZĹˇÄ‘ÄŤÄ‡ĹľĹ Ä�ÄŚÄ†Ĺ˝]+[\\s]*)+", prezime)) {
					JOptionPane.showMessageDialog(null, "Neispravno uneto prezime!");
					btnPotvrdi.setEnabled(false);
				} 
				else if(!Pattern.matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}[.]", txtField3.getText())) {
					JOptionPane.showMessageDialog(null, "Neispravan datum!\n Format: dd.mm.yyyy.");
					btnPotvrdi.setEnabled(false);
				} else if(!Pattern.matches("[+]?[0-9]+", brojTelefona)) {
					JOptionPane.showMessageDialog(null, "Neispravno unet broj telefona!");
					btnPotvrdi.setEnabled(false);
				} else if(!Pattern.matches("^(.+)@(.+)$", emailAdresa)) {
					JOptionPane.showMessageDialog(null, "Neispravno uneta email adresa!");
					btnPotvrdi.setEnabled(false);
				} else if (postoji) {
					JOptionPane.showMessageDialog(null, "Broj indeksa veÄ‡ postoji!");
					btnPotvrdi.setEnabled(false);
				}
					else if(!Pattern.matches("[0-9]{4}", godinaUpisa)) {
					JOptionPane.showMessageDialog(null, "Neispravno uneta godina upisa!");
					btnPotvrdi.setEnabled(false);
				} else {
				String datum = txtField3.getText();
				StudentController.getInstance().dodajStudenta(ime, prezime, datum, adresaStanovanja, brojTelefona, emailAdresa, brojIndeksa, godinaUpisa, godinaStudiranja, status, (float)0, null, null);;
				}
				
		
			}
		});
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
	}
	
}
