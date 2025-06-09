package Visual;

/**
 *
 * @author Chavelys
 * @author Mel
 * @author Zaile
 */
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JPanel;

public class BackgroundPanel extends JPanel {
    private Image backgroundImage;
    
    // Constructor vacío (compatible con NetBeans)
    public BackgroundPanel() {}
    
    // Método para establecer la imagen
    public void setBackgroundImage(Image image) {
        this.backgroundImage = image;
        repaint();
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            // Escalar la imagen al tamaño del panel
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }
}