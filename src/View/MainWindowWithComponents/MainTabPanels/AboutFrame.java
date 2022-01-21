package View.MainWindowWithComponents.MainTabPanels;

import javax.swing.JFrame;
import java.awt.TextArea;

import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import View.MainWindowWithComponents.MainWindow;

public class AboutFrame extends JFrame{
    
    public AboutFrame(){
        
        super();
        setSize(500,500);
        setLocationRelativeTo(MainWindow.getInstance());
        setTitle("Informacije");

        TextArea informacije = new TextArea();
        String s = "Informacije:\n\t-Projekat radili Aleksa Spasojević i Halid Pašanović\n"
        + "\t-Raspodela poslova je pratila specifikaciju projekta, Aleksa-Student 1, Halid-Student 2\n"
        + "\t-Verzija na kojoj je projekat rađen je jdk-17.0.1";
        informacije.setText(s);
		informacije.setEditable(false);
        JButton btn = new JButton("Cancel");
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
		});

		this.add(informacije,BorderLayout.CENTER);
        this.add(btn,BorderLayout.SOUTH);
    }
}
