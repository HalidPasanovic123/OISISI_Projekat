package View;

import javax.swing.JDialog;

public class PredmetJDialog extends JDialog{

    public PredmetJDialog() {
        super(MainWindow.getInstance());
        setModalityType(ModalityType.APPLICATION_MODAL);
        setSize(400, 400);
        setLocationRelativeTo(MainWindow.getInstance());
    }
    
}
