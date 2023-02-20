import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.Border;


public class Menu extends JPanel implements ActionListener   {
    static MyButton logout;
    public Menu() {
        

        setLayout(new BorderLayout(80, 0));
        setBackground(Styles.BLUE_COLOR);

        ImageIcon img = new ImageIcon("Frame.png");

        JLabel logo = new JLabel(img);
        logo.setPreferredSize(new Dimension(0, 160));

        JPanel p = new JPanel();
        p.setBackground(null);
        p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));

        new JLabel("stock");
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
       
        logout  = new MyButton("logout", 24, Styles.CBLUE_COLOR, Styles.BG_COLOR);
        logout.setMaximumSize(new Dimension(216, 48));
        logout.setPreferredSize(new Dimension(216, 64));
        logout.setMinimumSize(new Dimension(216, 64)); 
        logout.addActionListener(this);
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
        
        return btn;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Home.actionPerformed (e);
    }
    
}
