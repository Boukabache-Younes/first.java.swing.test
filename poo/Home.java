import java.awt.*;
import javax.swing.*;

public class Home {

    public Home(){
        Frame frame = new Frame("GG");

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));

        panel.add(new Dashboard(), BorderLayout.CENTER);

        panel.add(new SideBar(), BorderLayout.WEST);

        frame.setContentPane(panel);
        //frame.setResizable(false);
        frame.setVisible(true);
    }

    
}
