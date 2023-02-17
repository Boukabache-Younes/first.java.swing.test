import java.awt.*;
import javax.swing.*;

public class Main {

    public Main(){
        Frame frame = new Frame("GG");

        //JFrame login = new JFrame();
        //login.add(login, new Login());

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout(0, 0));

        panel.add(new Dashboard(), BorderLayout.CENTER);

        panel.add(new SideBar(), BorderLayout.WEST);

        frame.setContentPane(panel);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }
}
