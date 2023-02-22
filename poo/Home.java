import java.awt.*;
import javax.swing.*;

public class Home extends JFrame{
    // static Frame frame;

    public Home() {
        // Frame frame = new Frame("GG");

        setTitle("GG");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(true);
        setSize(1920, 1080);
        setMinimumSize(new Dimension(1200, 960));

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));

        panel.add(new Dashboard(), BorderLayout.CENTER);

        panel.add(new SideBar(), BorderLayout.WEST);

        setContentPane(panel);
        // frame.setResizable(false);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Home();
    }

}
