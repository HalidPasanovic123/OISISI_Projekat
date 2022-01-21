package View.Dialogs;

import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;


import Baze.BazaKatedre;
import Model.*;
import View.MainWindowWithComponents.MainWindow;

public class KatedraDialog extends JDialog {

    List<Katedra> listakatedri;
    KatedraDialog parent = this;
    public KatedraDialog()
    {
        super();
		setSize(400,500);
        setLocationRelativeTo(MainWindow.getInstance());
        
        //GridBagConstraints gbc;
        //GridBagLayout gb=new GridBagLayout();
		//setLayout(gb);
		setTitle("Dodavanje šefa katedre");

		listakatedri =new ArrayList<Katedra>(BazaKatedre.getInstance().getKatedre());

        DefaultListModel<String> lista = new DefaultListModel<>(); 
		for (Katedra k:listakatedri) {
            String naziv;
            if(k.getSefKatedre() == null)
            {
                naziv=k.getSifraKatedre()+"-"+k.getNazivKatedre() + "- nema Šefa";
            }
            else
            {
                naziv=k.getSifraKatedre()+"-"+k.getNazivKatedre() + "-Šef: " + k.getSefKatedre().getBrojLicneKarte() + "-" + k.getSefKatedre().getIme() + "-" + k.getSefKatedre().getPrezime();
            }
			
			lista.addElement(naziv);
		}
		JList<String> list=new JList<>(lista);
		JScrollPane scrollP=new JScrollPane(list);
		JButton btnDodaj=new JButton("Dodaj");

        btnDodaj.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(list.getSelectedIndex() != -1)
                {
                    System.out.println(list.getSelectedIndex());

                    Katedra k = listakatedri.get(list.getSelectedIndex());
                    SefKatedreDialog s = new SefKatedreDialog(k);
                    s.setVisible(true);
                    dispose();
                }

            }
            
        });
		//gbc=new GridBagConstraints(0, 0, 0, 0, 0, 0, GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(5, 100, 20, 0), 0, 0);
		this.add(btnDodaj,BorderLayout.NORTH);

        //gbc=new GridBagConstraints(0, 2, 2, 1, 200, 200, GridBagConstraints.CENTER, GridBagConstraints.BOTH, new Insets(30, 20, 40, 20), 0, 0);
		this.add(scrollP,BorderLayout.CENTER);
    }
    
}
