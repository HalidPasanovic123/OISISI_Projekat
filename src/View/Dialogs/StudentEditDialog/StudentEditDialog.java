package View.Dialogs.StudentEditDialog;

import javax.swing.JDialog;
import javax.swing.JFrame;

import Model.Student;

import java.awt.BorderLayout;

public class StudentEditDialog extends JDialog {

	public StudentEditDialog(JFrame parent,String title,Student s) {
		super(parent, title);

		setSize(573, 595);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		this.add(new StudentEditTabbedPane(this,s));
	}
}
