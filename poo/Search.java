import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Search extends JPanel implements ActionListener {
    MyButton btn;
    JTextField sb;

    public Search() {
        setBackground(null);
        setLayout(new BorderLayout(32, 0));
        this.btn = searchBtn();
        this.sb = searchBar();
        add(sb, BorderLayout.CENTER);
        add(btn, BorderLayout.EAST);
    }

    public JTextField searchBar() {
        JTextField sb = new JTextField("");
        sb.setPreferredSize(new Dimension(800, 64));
        sb.setBackground(Styles.WHITE_COLOR);
        sb.setForeground(Styles.TEXT_COLOR);
        sb.setFont(new Font("Poppins", Font.BOLD, 24));
        

        return sb;
        
    }



   

    public MyButton searchBtn() {
        MyButton btn = new MyButton("Recherche", 24, Styles.BLUE_COLOR, Styles.WHITE_COLOR);
        btn.addActionListener(this);
        btn.setPreferredSize(new Dimension(200, 64));

        return btn;
    }

    

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btn) {            
            if (sb.getText().isBlank()) {
                // JOptionPane.showMessageDialog(null, "Please fill search field");
                new DBcon().afficher(TableScroll.tab);
            } else {
                if (new DBcon().codeExist(sb.getText())) {
                    new DBcon().rechrcher(TableScroll.tab, sb.getText());
                } else {
                    // JOptionPane.showMessageDialog(null, "med n'exist pas");
                    new DBcon().afficher(TableScroll.tab);
                }
            }
        }
    }
}
