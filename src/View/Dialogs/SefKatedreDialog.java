package View.Dialogs;

import java.util.List;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JScrollPane;
import java.awt.GridBagLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.BorderLayout;


import Baze.BazaProfesora;
import Model.Katedra;
import Model.Profesor;
import View.MainWindowWithComponents.MainWindow;

public class SefKatedreDialog extends JDialog{

    List<Profesor> listasvihprofesora;
    public SefKatedreDialog(Katedra kk)
    {
        super();
        setSize(400,500);
        setLocationRelativeTo(MainWindow.getInstance());

        listasvihprofesora = new ArrayList<Profesor>(BazaProfesora.getInstance().getProfesors());
        
        DefaultListModel<String> lista = new DefaultListModel<>(); 
        for(Profesor p : listasvihprofesora)
        {
            if(p.getGodineStaza() >= 5 && (p.getZvanje().equals("Profesor") || p.getZvanje().equals("Vanredni")))
            {
                String naziv = p.getIme() + "-" + p.getPrezime() + "-" + p.getBrojLicneKarte();
                lista.addElement(naziv);
            }
        }

        JList<String> list=new JList<>(lista);
		JScrollPane scrollP=new JScrollPane(list);
		
        JButton btnDodaj=new JButton("Postavi");

        btnDodaj.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) 
            {
                if(list.getSelectedIndex()!= -1)
                {
                    Profesor prof = listasvihprofesora.get(list.getSelectedIndex());
                    kk.setSefKatedre(prof);
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
