import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
//import javax.swing.border.Border;


public class Menu extends JPanel implements ActionListener   {
    MyButton logout;
    public Menu() {
        

        setLayout(new BorderLayout(80, 0));
        setBackground(Styles.BLUE_COLOR);

        ImageIcon img = new ImageIcon("Frame.png");

        JLabel logo = new JLabel(img);
        logo.setPreferredSize(new Dimension(0, 160));

        JPanel p = new JPanel();
        p.setBackground(null);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        p.add(mybtn("Dashboard"));
        
        p.add(Box.createVerticalStrut(10));
        p.add(mybtn("stock"));
        p.add(Box.createVerticalStrut(10));
        p.add(mybtn("Fournisseur"));
        p.add(Box.createVerticalStrut(10));
        p.add(mybtn("Commandes"));
        p.add(Box.createVerticalStrut(10));
        p.add(mybtn("Caisse"));

        p.add(Box.createVerticalStrut(190));
        logout = mybtn("Logout");
        p.add(logout);

        add(logo, BorderLayout.NORTH);
        add(p, BorderLayout.CENTER);
        p.add(Box.createVerticalStrut(10));
    }

    public MyButton mybtn(String txt){
        MyButton btn  = new MyButton(txt, 24, Styles.CBLUE_COLOR, Styles.BG_COLOR);
        btn.setMaximumSize(new Dimension(216, 48));
        btn.setPreferredSize(new Dimension(216, 64));
        btn.setMinimumSize(new Dimension(216, 64)); 
        btn.addActionListener(this);
        
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == logout){
            System.out.println("menu");
            // Home.disp();
        }
    }
    
}
