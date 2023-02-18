import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class Modifie extends JFrame implements ActionListener {

    MyButton mod, codebtn;
    JTextField nomf, prixf, quanf, codef, catgf;
    JTextArea desca;

    public Modifie() {
        setLayout(null);
        setSize(800, 400);
        setResizable(false);

        JPanel p = new JPanel();
        p.setLayout(new GridBagLayout());
        p.setBackground(null);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;

        int ins = 8;
        gbc.insets = new Insets(ins, ins, ins, ins);

        gbc.gridheight = 1;

        JLabel codel = label("Code");
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        p.add(codel, gbc);

        codef = textf();
        codef.setEditable(true);
        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.gridwidth = 4;
        p.add(codef, gbc);

        JLabel noml = label("Nom");
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        p.add(noml, gbc);

        nomf = textf();
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        p.add(nomf, gbc);

        JLabel prixl = label("Prix");
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        p.add(prixl, gbc);

        prixf = textf();
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        p.add(prixf, gbc);

        codebtn = new MyButton("Set Code", 16, Styles.WHITE_COLOR, Styles.BLUE_COLOR);
        codebtn.addActionListener(this);
        codebtn.setFont(Styles.LABLE_FONT);
        codebtn.setPreferredSize(new Dimension(100, 20));
        gbc.gridx = 5;
        gbc.gridy = 0;
        gbc.gridwidth = 1;
        p.add(codebtn, gbc);

        JLabel catgl = label("Categorie");
        gbc.gridx = 5;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        p.add(catgl, gbc);

        catgf = textf();
        gbc.gridx = 6;
        gbc.gridy = 2;
        gbc.gridwidth = 4;
        p.add(catgf, gbc);

        JLabel quanl = label("Quantite");
        gbc.gridx = 5;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        p.add(quanl, gbc);

        quanf = textf();
        gbc.gridx = 6;
        gbc.gridy = 1;
        gbc.gridwidth = 4;
        p.add(quanf, gbc);

        mod = new MyButton("Modifier", 24, Styles.BLUE_COLOR, Styles.WHITE_COLOR);
        mod.addActionListener(this);
        mod.setPreferredSize(new Dimension(200, 64));
        gbc.gridx = 18;
        gbc.gridy = 4;
        gbc.gridwidth = 8;
        p.add(mod, gbc);

        JLabel descl = label("Description");
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 1;
        p.add(descl, gbc);

        desca = new JTextArea();
        desca.setLineWrap(true);
        desca.setBackground(Styles.WHITE_COLOR);
        desca.setForeground(Styles.TEXT_COLOR);
        desca.setFont(new Font("Poppins", Font.PLAIN, 12));
        desca.setEditable(false);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.gridwidth = 10;
        gbc.gridheight = 3;
        p.add(desca, gbc);


        JLabel a = new Title("Modifier", false);
        a.setBounds(16, 8, 800, 64);
        add(a);
        p.setBounds(20, 40, 760, 360);
        add(p);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public JLabel label(String txt) {
        JLabel l = new JLabel();
        l.setText(txt);
        l.setForeground(Styles.TEXT_COLOR);
        l.setFont(Styles.LABLE_FONT);

        return l;
    }

    public JTextField textf() {
        JTextField tf = new JTextField();
        tf.setPreferredSize(new Dimension(120, 20));
        tf.setBackground(Styles.WHITE_COLOR);
        tf.setForeground(Styles.TEXT_COLOR);
        tf.setFont(new Font("Poppins", Font.PLAIN, 12));
        tf.setEditable(false);

        return tf;
    }

    public boolean isNotNum(String s) {
        try {
            Integer.parseInt(s);
            return false;
        } catch (Exception e) {
            return true;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (codef.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter code");
        } else {
            if (!new DBcon().codeExist(codef.getText())) {
                JOptionPane.showMessageDialog(null, "Code does not exist");
            } else {
                if (e.getSource() == codebtn) {
                    String[] s = new DBcon().getRow(codef.getText());

                    nomf.setText(s[0]);
                    nomf.setEditable(true);

                    prixf.setText(s[1]);
                    prixf.setEditable(true);

                    quanf.setText(s[2]);
                    quanf.setEditable(true);

                    catgf.setText(s[3]);
                    catgf.setEditable(true);

                    desca.setText(s[4]);
                    desca.setEditable(true);

                }
                if (e.getSource() == mod) {
                    if (isNotNum(prixf.getText()) || isNotNum(quanf.getText())) {
                        JOptionPane.showMessageDialog(null, "Prix and Quantite must be a number");
                    } else {
                        new DBcon().alter(codef.getText(), Integer.parseInt(prixf.getText()), nomf.getText(),
                                Integer.parseInt(quanf.getText()), catgf.getText(), desca.getText());
                        new DBcon().afficher(TableScroll.tab);
                        dispose();
                    }
                }
            }
        }

    }

}
