package igu;

/**
 *
 * @author Asullom
 */

import javax.swing.JPanel;

public class ChangePanel {
    
    private JPanel currentPanel;
    private JPanel newPanel;

    public ChangePanel(JPanel currentPanel, JPanel newPanel) {
        this.currentPanel = currentPanel;
        this.newPanel = newPanel;
        this.currentPanel.removeAll();
        this.currentPanel.revalidate();
        this.currentPanel.repaint();
        
        this.currentPanel.add(this.newPanel);
        this.currentPanel.revalidate();
        this.currentPanel.repaint();
    }

}

