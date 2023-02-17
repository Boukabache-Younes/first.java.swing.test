import java.awt.*;
import javax.swing.*;

public class Frame extends JFrame {
    public Frame(String name) {
        ImageIcon img = new ImageIcon("Frame.png");
        
        setTitle(name);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(1920, 1080);
        setMinimumSize(new Dimension(1200, 960));
        setIconImage(img);

    }

    private void setIconImage(ImageIcon img) {
    }
}
