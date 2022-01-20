package View.MainWindowWithComponents;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.LineBorder;


public class StatusBar extends JPanel{
	
			
	private String appName = "Studentska Slu�ba-Studenti";
	private String time;
	JLabel appNameLabel = new JLabel(appName);
	JLabel timeLabel = new JLabel();
	DateFormat timeFormat = new SimpleDateFormat("HH:mm dd.MM.yyyy. ");
	public StatusBar()
	{
		
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(new Color(0)));
		
		TimeListener t1 = new TimeListener();
		Timer timer = new Timer(60*1000, t1);
		timer.setInitialDelay(0);
		timer.start();
		
		this.add(appNameLabel,BorderLayout.WEST);
		this.add(timeLabel,BorderLayout.EAST);
	}
	
	public StatusBar(String s)
	{
		appName = s;
		JLabel appNameLabel = new JLabel(appName);
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(new Color(0)));
		
		TimeListener t1 = new TimeListener();
		Timer timer = new Timer(60*1000, t1);
		timer.setInitialDelay(0);
		timer.start();
		
		this.add(appNameLabel,BorderLayout.WEST);
		this.add(timeLabel,BorderLayout.EAST);
	}
	public void setAppNameLabel(JLabel appNameLabel) {
		this.appNameLabel = appNameLabel;
	}

	private class TimeListener implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			Date now = new Date();
			time = timeFormat.format(now);
			timeLabel.setText(time);
			
		}
		
	}
}
