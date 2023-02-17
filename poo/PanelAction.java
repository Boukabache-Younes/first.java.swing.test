import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class PanelAction extends JPanel implements ActionListener {

    MyButton deleteBtn;
    MyButton editBtn;
    MyButton ajtbtn;

    public PanelAction() {

        ImageIcon plus = new ImageIcon("plus.png");
        ImageIcon garbage = new ImageIcon("garbage.png");

        setBackground(null);
        setLayout(new GridLayout(1,1,24,24));
        

        ajtbtn = new MyButton("Ajouter", 24, Styles.BLUE_COLOR, Styles.WHITE_COLOR);
        ajtbtn.addActionListener(this);
        ajtbtn.setPreferredSize(new Dimension(200, 64));
        ajtbtn.setIcon(plus);
        ajtbtn.setIconTextGap(8);
        ajtbtn.setHorizontalTextPosition(SwingConstants.LEFT);
        add(ajtbtn);

        JPanel gap1 = new JPanel();
        gap1.setPreferredSize(new Dimension(50, 0));
        gap1.setBackground(Styles.BG_COLOR);
        add(gap1);

        editBtn = new MyButton("Modifier", 24, Styles.GRAY_COLOR, Styles.TEXT_COLOR);
        editBtn.addActionListener(this);
        editBtn.setPreferredSize(new Dimension(180, 64));
        add(editBtn);

        deleteBtn = new MyButton("Supprimer", 24, Styles.WARNING_COLOR, Styles.WHITE_COLOR);
        deleteBtn.addActionListener(this);
        deleteBtn.setPreferredSize(new Dimension(200, 64));
        deleteBtn.setIcon(garbage);
        deleteBtn.setIconTextGap(8);
        deleteBtn.setHorizontalTextPosition(SwingConstants.LEFT);
        
        add(deleteBtn);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == deleteBtn) {
            System.out.println("del");
            new Supprime();
        }
        if (e.getSource() == editBtn) {
            System.out.println("mod");
            new Modifie();
        }
        if (e.getSource() == ajtbtn) {
            System.out.println("mod");
            new Ajouter();
        }
    }
}
