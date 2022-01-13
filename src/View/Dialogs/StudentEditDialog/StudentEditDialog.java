package View.Dialogs.StudentEditDialog;

import javax.swing.JDialog;
import javax.swing.JFrame;
import java.awt.BorderLayout;

public class StudentEditDialog extends JDialog {

	public StudentEditDialog(JFrame parent, String title) {
		super(parent, title);

		setSize(500, 500);
		setLocationRelativeTo(parent);
		setLayout(new BorderLayout());
		this.add(new StudentEditTabbedPane(this));
	}
}
