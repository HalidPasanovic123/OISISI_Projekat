package View.MainWindowWithComponents.MainTabPanels;

import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import Baze.BazaStudenata;
import Model.Student;

import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import View.Dialogs.StudentEditDialog.StudentEditTabbedPane;

public class PolozeniTab extends JPanel{
	private static JButton ponistiO;
	private static JLabel prosekL;
	private static JLabel espbL;
	
	
	
	public PolozeniTab(int row, StudentEditTabbedPane parent)
	{
		
		GridBagLayout gb=new GridBagLayout();
		setLayout(gb);
				
		GridBagConstraints gbc=new GridBagConstraints(0, 0, 1, 1, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 30, 0, 0), 0, 0);
		ponistiO = new JButton("Poništi ocenu");
		this.add(ponistiO,gbc);
	}
}
