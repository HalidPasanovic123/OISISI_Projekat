package View.Dialogs;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import Model.Student;
import View.MainWindowWithComponents.MainWindow;
import Model.Adresa;
import Model.OcenaNaIspitu;
import Model.Predmet;
import Model.Status;
import Controllers.StudentController;

public class StudentJDialog  extends JDialog{
	
	/**
	 * 
	 */
	JTextField txtField1;
	JTextField txtField2;
	JTextField txtField3;
	JTextField txtField4;
	JTextField txtField5;
	JTextField txtField6;
	JTextField txtField7;
	JTextField txtField8;
	
	JComboBox<String> comboBox1;
	JComboBox<String> comboBox2;
	
	JButton btnPotvrdi;
	JButton btnOdustani;
	
	private static final long serialVersionUID = 1L;

	public StudentJDialog() 
	{
		super();

		setSize(500, 500);
		setLocationRelativeTo(MainWindow.getInstance());
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
		GridBagConstraints gbc;
		
		class MyDocListener implements DocumentListener
		  {
			
			@Override
			public void changedUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				provera();
			}


			@Override
			public void insertUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				provera();
			}

			@Override
			public void removeUpdate(DocumentEvent arg0) {
				// TODO Auto-generated method stub
				provera();
			}
		 
		  }
		
		DocumentListener myDocumentListener=new MyDocListener();
		
		gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label1 = new JLabel("Ime*");
		this.add(label1,gbc);
		
		txtField1=new JTextField();
		txtField1.getDocument().addDocumentListener(myDocumentListener);
		gbc=new GridBagConstraints(1, 0, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField1,gbc);
		
		gbc=new GridBagConstraints(0, 1, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label2 = new JLabel("Prezime*");
		this.add(label2,gbc);
		
		txtField2 = new JTextField();
		txtField2.getDocument().addDocumentListener(myDocumentListener);
		gbc=new GridBagConstraints(1, 1, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField2,gbc);
		
		gbc=new GridBagConstraints(0, 2, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label3=new JLabel("Datum rodjenja*");
		this.add(label3,gbc);
		
		txtField3=new JTextField();
		txtField3.getDocument().addDocumentListener(myDocumentListener);
		gbc=new GridBagConstraints(1, 2, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField3,gbc);

		gbc=new GridBagConstraints(0, 3, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label4=new JLabel("Adresa stanovanja*");
		this.add(label4,gbc);
		
		txtField4=new JTextField();
		txtField4.setToolTipText("ulica broj, grad");
		txtField4.getDocument().addDocumentListener(myDocumentListener);
		gbc=new GridBagConstraints(1, 3, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField4,gbc);
		
		gbc=new GridBagConstraints(0, 4, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label5=new JLabel("Broj telefona*");
		this.add(label5,gbc);
		
		txtField5=new JTextField();
		txtField5.getDocument().addDocumentListener(myDocumentListener);
		gbc=new GridBagConstraints(1, 4, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField5,gbc);
		
		gbc=new GridBagConstraints(0, 5, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label6=new JLabel("E-mail adresa*");
		this.add(label6,gbc);
		
		txtField6=new JTextField();
		txtField6.getDocument().addDocumentListener(myDocumentListener);
		gbc=new GridBagConstraints(1, 5, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField6,gbc);
		
		gbc=new GridBagConstraints(0, 6, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label7=new JLabel("Broj indeksa*");
		this.add(label7,gbc);
		
		txtField7=new JTextField();
		txtField7.getDocument().addDocumentListener(myDocumentListener);
		gbc=new GridBagConstraints(1, 6, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField7,gbc);
		
		gbc=new GridBagConstraints(0, 7, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label8=new JLabel("Godina upisa*");
		this.add(label8,gbc);
		
		txtField8=new JTextField();
		txtField8.getDocument().addDocumentListener(myDocumentListener);
		gbc=new GridBagConstraints(1, 7, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 225, 0);
		this.add(txtField8,gbc);
		
		gbc=new GridBagConstraints(0, 8, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label9=new JLabel("Trenutna godina studija*");
		this.add(label9,gbc);
		
		ArrayList<String> valsGS = new ArrayList<String>();
		valsGS.add("I (prva)");
		valsGS.add("II (druga)");
		valsGS.add("III (treca)");
		valsGS.add("IV (cetvrta)");
		valsGS.add("V (peta)");
		comboBox1 = new JComboBox(valsGS.toArray()) ;
		gbc=new GridBagConstraints(1, 8, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 140, 0);
		this.add(comboBox1,gbc);
		
		gbc=new GridBagConstraints(0, 9, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0);
		JLabel label10=new JLabel("Nacin finansiranja*");
		this.add(label10,gbc);
		
		ArrayList<String> valsStatus = new ArrayList<String>();
		valsStatus.add("Budžet");
		valsStatus.add("Samofinansiranje");
		
		comboBox2 = new JComboBox(valsStatus.toArray());
		gbc=new GridBagConstraints(1, 9, 1, 1, 0, 0, GridBagConstraints.CENTER, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 103, 0);
		this.add(comboBox2,gbc);
		
		btnPotvrdi=new JButton("Potvrdi");
		gbc=new GridBagConstraints(0, 10, 1, 1, 0, 0, GridBagConstraints.EAST, GridBagConstraints.NONE, new Insets(5, 0, 0, 0), 0, 0);
		this.add(btnPotvrdi,gbc);
		btnPotvrdi.setEnabled(false);
		
		btnOdustani=new JButton("Odustani");
		gbc=new GridBagConstraints(1, 10, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 30, 0, 0), 0, 0);
		this.add(btnOdustani,gbc);
		
		
		btnPotvrdi.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				String ime=txtField1.getText();
				String prezime=txtField2.getText();
				String datum = txtField3.getText();
				Adresa adresaStanovanja = new Adresa();
				adresaStanovanja.setGrad(txtField5.getText());
				String brojTelefona=txtField5.getText();
				
				String emailAdresa=txtField6.getText();
				String brojIndeksa=txtField7.getText();
				
				String godinaUpisa=txtField8.getText();
				
				int godinaStudiranja;
				if (comboBox1.getSelectedItem().toString().equals("I (prva)"))
				{
					godinaStudiranja = 1;
				}	 
				else if (comboBox1.getSelectedItem().toString().equals("II (druga)"))
				{
					godinaStudiranja = 2;
				}
				else if (comboBox1.getSelectedItem().toString().equals("III (treća)"))
				{
					godinaStudiranja = 3;
				}
				else if (comboBox1.getSelectedItem().toString().equals("IV (četvrta)"))
				{
					godinaStudiranja = 4;
				}
				else 
				{
					godinaStudiranja = 5;
				}

				Status status;
				if (comboBox2.getSelectedItem().toString().equals("Budžet"))
				{
					status = Status.B;
				}
				else
				{
					status = Status.S;
				}
		
				StudentController.getInstance().dodajStudenta(ime, prezime, datum, adresaStanovanja, brojTelefona, emailAdresa, brojIndeksa, godinaUpisa, godinaStudiranja, status, (float)0, new ArrayList<OcenaNaIspitu>(), new ArrayList<Predmet>());;
				dispose();
				}
		});
		
		btnOdustani.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}
	
	public void provera()
	{
		String ime=txtField1.getText();
		String prezime=txtField2.getText();
		Adresa adresaStanovanja = new Adresa();
		adresaStanovanja.setGrad(txtField5.getText());
		String brojTelefona=txtField5.getText();
		
		String emailAdresa=txtField6.getText();
		String brojIndeksa=txtField7.getText();
		
		String godinaUpisa=txtField8.getText();
		
		int godinaStudiranja;
		if (comboBox1.getSelectedItem().toString().equals("I (prva)"))
		{
			godinaStudiranja = 1;
		}	 
		else if (comboBox1.getSelectedItem().toString().equals("II (druga)"))
		{
			godinaStudiranja = 2;
		}
		else if (comboBox1.getSelectedItem().toString().equals("III (treća)"))
		{
			godinaStudiranja = 3;
		}
		else if (comboBox1.getSelectedItem().toString().equals("IV (četvrta)"))
		{
			godinaStudiranja = 4;
		}
		else 
		{
			godinaStudiranja = 5;
		}

		Status status;
		if (comboBox2.getSelectedItem().toString().equals("Budžet"))
		{
			status = Status.B;
		}
		else
		{
			status = Status.S;
		}
		
		boolean postoji = false;
		for (Student s : StudentController.getInstance().getStudenti())
		{
			if (s.getIndeks().equals(brojIndeksa))
			{
				postoji = true;
			}
				
		}
		
		btnPotvrdi.setEnabled(false);
		if(Pattern.matches("([a-zA-ZčČćĆžŽđĐšŠ]+[\\s]*)+", ime) &&
		Pattern.matches("([a-zA-ZčČćĆžŽđĐšŠ]+[\\s]*)+", prezime) && 
		Pattern.matches("[0-9]{1,2}[.][0-9]{1,2}[.][0-9]{4}[.]", txtField3.getText()) &&
		Pattern.matches("[+]?[0-9]+", brojTelefona) && Pattern.matches("^(.+)@(.+)$", emailAdresa) &&
		Pattern.matches("[0-9]{4}", godinaUpisa) && !postoji) 
		{
			btnPotvrdi.setEnabled(true);
		}
	}
}
