import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Home  implements ActionListener {
        static Frame frame;
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
    @Override
    public static void actionPerformed (ActionEvent e){
        if(e.getSource()==Menu.logout){
            frame.dispose();
            new Login();

        }
    }
    
}
