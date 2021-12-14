package View;

import javax.swing.JDialog;

public class ProfesorJDialog extends JDialog{

    public ProfesorJDialog() {
        super(MainWindow.getInstance());
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(400, 400);
        setLocationRelativeTo(MainWindow.getInstance());
    }
    
}
