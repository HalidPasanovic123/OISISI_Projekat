package View.MainWindowWithComponents;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.KeyStroke;

import AbstractActions.CreateAction;
import AbstractActions.DeleteAction;
import AbstractActions.ModifyAction;
import AbstractActions.SaveAction;
import View.Dialogs.KatedraDialog;
import View.Dialogs.StudentEditDialog.NepolozeniTab.PolaganjeButton.PolaganjeJDialog;

import java.awt.event.KeyEvent;
import java.io.File;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBar extends JMenuBar {

	public MenuBar(final JFrame parent)
	{
		
		//padajuci meniji sa mnemonicima
		JMenu file = new JMenu("File");
		file.setMnemonic(KeyEvent.VK_F);
		
		JMenu edit = new JMenu("Edit");
		edit.setMnemonic(KeyEvent.VK_E);
		
		JMenu help = new JMenu("Help");
		help.setMnemonic(KeyEvent.VK_H);
		
		JMenu open = new JMenu("Open");
		open.setIcon(new ImageIcon("Images"+File.separator+"open.png"));
		open.setMnemonic(KeyEvent.VK_O);
		
		CreateAction create = new CreateAction();
		JMenuItem novi = new JMenuItem(create);
		novi.setText("New");
		novi.setIcon(new ImageIcon("Images"+File.separator+"new.png"));
		novi.setMnemonic(KeyEvent.VK_N);
		
		SaveAction saveAction = new SaveAction();
		JMenuItem save = new JMenuItem(saveAction);
		save.setText("Save");
		save.setIcon(new ImageIcon("Images"+File.separator+"save.png"));
		save.setMnemonic(KeyEvent.VK_S);
		
		JMenuItem close = new JMenuItem("Close");
		close.setIcon(new ImageIcon("Images"+File.separator+"close.png"));
		close.setMnemonic(KeyEvent.VK_C);
		close.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,ActionEvent.CTRL_MASK));
		
		JMenuItem studenti = new JMenuItem("Studenti");
		studenti.setIcon(new ImageIcon("Images"+File.separator+"student.png"));
		studenti.setMnemonic(KeyEvent.VK_T);
		studenti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,ActionEvent.CTRL_MASK));
		
		JMenuItem profesori = new JMenuItem("Profesori");
		profesori.setIcon(new ImageIcon("Images"+File.separator+"profesor.png"));
		profesori.setMnemonic(KeyEvent.VK_P);
		profesori.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,ActionEvent.CTRL_MASK));
		
		JMenuItem predmeti= new JMenuItem("Predmeti");
		predmeti.setIcon(new ImageIcon("Images"+File.separator+"predmet.jpg"));
		predmeti.setMnemonic(KeyEvent.VK_R);
		predmeti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,ActionEvent.CTRL_MASK));
		
		JMenuItem katedre = new JMenuItem("Katedre");
		katedre.setIcon(new ImageIcon("Images"+File.separator+"katedra.png"));
		katedre.setMnemonic(KeyEvent.VK_K);
		katedre.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_K,ActionEvent.CTRL_MASK));
		katedre.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent ev) 
			{
				//System.out.println("kliknuto");
				KatedraDialog k = new KatedraDialog();
				k.setVisible(true);
			}
		});
		
		ModifyAction modify = new ModifyAction(parent);
		JMenuItem edit2 = new JMenuItem(modify);
		edit2.setText("Edit");
		edit2.setIcon(new ImageIcon("Images"+File.separator+"edit.png"));
		edit2.setMnemonic(KeyEvent.VK_E);
		
		DeleteAction del_act = new DeleteAction(parent);
		JMenuItem delete = new JMenuItem(del_act);
		delete.setText("Delete");
		delete.setIcon(new ImageIcon("Images"+File.separator+"delete.png"));
		delete.setMnemonic(KeyEvent.VK_D);
		
		JMenuItem help2 = new JMenuItem("Help");
		help2.setIcon(new ImageIcon("Images"+File.separator+"help.png"));
		help2.setMnemonic(KeyEvent.VK_H);
		help2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,ActionEvent.CTRL_MASK));
		
		JMenuItem about = new JMenuItem("About");
		about.setIcon(new ImageIcon("Images"+File.separator+"about.png"));
		about.setMnemonic(KeyEvent.VK_A);
		about.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,ActionEvent.CTRL_MASK));
		
		//dodavanje stavki tipa JMenuItem u padajuci meni tipa JMenu
		open.add(studenti);
		open.add(profesori);
		open.add(predmeti);
		open.add(katedre);
		
		file.add(novi);
		file.add(save);
		file.add(open);
		file.addSeparator();
		file.add(close);
		
		edit.add(edit2);
		edit.add(delete);
		
		help.add(help2);
		help.add(about);
		
		//dodavanje padajucih menija u Menu_Bar
		add(file);
		add(edit);
		add(help);
			
	}
}
