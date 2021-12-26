package View.MainWindowWithComponents.MainTabPanels;

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
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Baze.BazaStudenata;
import Controllers.StudentController;
import Model.Adresa;
import Model.Status;
import Model.Student;

public class InformacijeTab extends JPanel {
	
	DateFormat datum;
	
	private JTextField txtField1;
	private JTextField txtField2;
	private JTextField txtField3;
	private JTextField txtField4;
	private JTextField txtField5;
	private JTextField txtField6;
	private JTextField txtField7;
	private JTextField txtField8;
	private JButton btnPotvrdi;
	private Student student;
	
	
	public InformacijeTab(int row) {
		super();
		InformacijeTab si =this;
		
		student = BazaStudenata.getInstance().getRow(row);
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc;
		
		gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label1 = new JLabel("Ime*");
		this.add(label1,gbc);
		
		txtField1=new JTextField();
		txtField1.setText(student.getIme());
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField1,gbc);
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label2 = new JLabel("Prezime*");
		this.add(label2,gbc);
		
		txtField2 = new JTextField();
		txtField2.setText(student.getPrezime());
		gbc=new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField2,gbc);
		
		gbc=new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label3=new JLabel("Datum roÄ‘enja*");
		this.add(label3,gbc);
		
		txtField3=new JTextField();
		txtField3.setToolTipText("dd.mm.yyyy.");
		datum = new SimpleDateFormat("dd.MM.yyyy.");
		txtField3.setText(student.getDatumRodjenja());
		gbc=new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField3,gbc);
		

		gbc=new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label4=new JLabel("Adresa stanovanja*");
		this.add(label4,gbc);
		
		txtField4=new JTextField();
		txtField4.setToolTipText("ulica broj, grad");
		txtField4.setText(student.ispisiAdresu());
		gbc=new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField4,gbc);
		
		gbc=new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label5=new JLabel("Broj telefona*");
		this.add(label5,gbc);
		
		txtField5=new JTextField();
		txtField5.setText(student.getKontakt());
		gbc=new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField5,gbc);
		
		gbc=new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label6=new JLabel("E-mail adresa*");
		this.add(label6,gbc);
		
		txtField6=new JTextField();
		txtField6.setText(student.geteMail());
		gbc=new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField6,gbc);
		
		gbc=new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label7=new JLabel("Broj indeksa*");
		this.add(label7,gbc);
		
		txtField7=new JTextField();
		txtField7.setText(student.getIndeks());
		gbc=new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField7,gbc);
		
		gbc=new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label8=new JLabel("Godina upisa*");
		this.add(label8,gbc);
		
		txtField8=new JTextField();
		txtField8.setText(String.valueOf(student.getGodinaUpisa()));
		gbc=new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField8,gbc);
		
		gbc=new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label9=new JLabel("Trenutna godina studija*");
		this.add(label9,gbc);
		
		ArrayList<String> valsGS = new ArrayList<String>();
		valsGS.add("I (prva)");
		valsGS.add("II (druga)");
		valsGS.add("III (treÄ‡a)");
		valsGS.add("IV (ÄŤetvrta)");
		valsGS.add("V (peta)");
		
		final JComboBox<String> combo = new JComboBox(valsGS.toArray()) ;
		gbc=new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 132, 0);
		if (student.getGodinaStudija() == 1)
		{
			combo.setSelectedIndex(0);
		}
			
		else if (student.getGodinaStudija() == 2)
		{
			combo.setSelectedIndex(1);
		}	
		else if (student.getGodinaStudija() == 3)
		{
			combo.setSelectedIndex(2);
		}			
		else if (student.getGodinaStudija() == 4)
		{
			combo.setSelectedIndex(3);
		}	
		else 
		{
			combo.setSelectedIndex(4);
		}
		this.add(combo,gbc);
		
		gbc=new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label10=new JLabel("NaÄŤin finansiranja*");
		this.add(label10,gbc);
		
		ArrayList<String> valsStatus = new ArrayList<String>();
		valsStatus.add("BudĹľet");
		valsStatus.add("Samofinansiranje");
		
		final JComboBox<String> combo2 = new JComboBox(valsStatus.toArray());
		if (student.getStatus() == Status.B)
		{
			combo2.setSelectedIndex(0);
		}
		else
		{
			combo2.setSelectedIndex(1);
		}
			
		gbc=new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 103, 0);
		this.add(combo2,gbc);
		
		btnPotvrdi=new JButton("Potvrdi");
		gbc=new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0);
		this.add(btnPotvrdi,gbc);
		
		JButton btnOdustani=new JButton("Odustani");
		gbc=new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 0, 0);
		this.add(btnOdustani,gbc);
		
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ime=txtField1.getText();
				String prezime=txtField2.getText();
				String datum = txtField3.getText();
				Adresa adresaStanovanja= new Adresa(txtField4.getText());
				String brojTelefona=txtField5.getText();
				String emailAdresa=txtField6.getText();
				String brojIndeksa=txtField7.getText();
				String godinaUpisa=txtField8.getText();
				
				int godinaStudiranja;
				if (combo.getSelectedItem().toString().equals("I (prva)"))
				{
					godinaStudiranja = 1;
				} 
				else if (combo.getSelectedItem().toString().equals("II (druga)"))
				{
					godinaStudiranja = 2;
				} 
				else if (combo.getSelectedItem().toString().equals("III (treÄ‡a)"))
				{
					godinaStudiranja = 3;
				}
				else if (combo.getSelectedItem().toString().equals("IV (ÄŤetvrta)"))
				{
					godinaStudiranja = 4;
				}	 
				else
				{
					godinaStudiranja = 5;
				}
				
				
				boolean postoji = false;
				for (Student s : StudentController.getInstance().getStudenti())
				{
					if (s.getIndeks().equals(brojIndeksa) && !s.getIndeks().equals(student.getIndeks()))
					{
						postoji = true;
					}
						
				}
				
				Status status;
				if (combo2.getSelectedItem().toString().equals("BudĹľet"))
				{
					status = Status.B;
				}		
				else
				{
					status = Status.S;
				}
				if(provera())
				{
					StudentController.getInstance().editStudent(prezime ,ime, datum, adresaStanovanja, brojTelefona, emailAdresa, brojIndeksa, godinaUpisa, godinaStudiranja, status, row);
					JDialog parent1 = (JDialog) SwingUtilities.getWindowAncestor(si);
					parent1.dispose();
				}
						
			}
				
		});
		
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				JDialog parent1 = (JDialog) SwingUtilities.getWindowAncestor(si);
			    parent1.dispose();
				
			}
		});
	}
	
	public Boolean provera() {
		
		String prezime=txtField2.getText();
		String ime=txtField1.getText();
		String brojTelefona=txtField5.getText();
		String emailAdresa=txtField6.getText();
		String brojIndeksa=txtField7.getText();
		
		boolean postoji = false;
		for (Student s : StudentController.getInstance().getStudenti())
		{
			if (s.getIndeks().equals(brojIndeksa) && !s.getIndeks().equals(student.getIndeks()))
				postoji = true;
		}
		
		if(!Pattern.matches("([a-zA-ZĹˇÄ‘ÄŤÄ‡ĹľĹ Ä�ÄŚÄ†Ĺ˝]+[\\s]*)+", ime)) 
		{
			JOptionPane.showMessageDialog(null, "Neispravno uneto ime!");
			return false;
		} 
		else if(!Pattern.matches("([a-zA-ZĹˇÄ‘ÄŤÄ‡ĹľĹ Ä�ÄŚÄ†Ĺ˝]+[\\s]*)+", prezime)) 
		{
			JOptionPane.showMessageDialog(null, "Neispravno uneto prezime!");
			return false;
		} 
		else if(!Pattern.matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}[.]", txtField3.getText())) 
		{
			JOptionPane.showMessageDialog(null, "Neispravan datum!\n Format: dd.mm.yyyy.");
			return false;
		} 
		else if(!Pattern.matches("[+]?[0-9]+", brojTelefona)) 
		{
			JOptionPane.showMessageDialog(null, "Neispravno unet broj telefona!");
			return false;
		} 
		else if(!Pattern.matches("^(.+)@(.+)$", emailAdresa)) 
		{
			JOptionPane.showMessageDialog(null, "Neispravno uneta email adresa!");
			return false;
		} 
		else if (postoji)
		{
			JOptionPane.showMessageDialog(null, "Broj indeksa veÄ‡ postoji!");
			return false;
		} 
		else 
		{
			return true;
			
		}

	}
}
