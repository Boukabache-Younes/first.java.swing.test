import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;

public class Login implements ActionListener{
    JComponent frameL;
    MyButton connect;

    final public Font mainFont = new Font("Open sans", Font.BOLD, 28);
    final public Font mainFont2 = new Font("Popines", Font.BOLD, 36);
    JTextField temail, passworField;
    Border border = BorderFactory.createLineBorder(new Color(0x022243), 50);
    Border border2 = BorderFactory.createLineBorder(new Color(0xfffffff), 32);

    public Login() {


        JPanel pane = new JPanel();
        pane.setBackground(new Color(0xffffff));
        pane.setLayout(null);

        JLabel emLabel = new JLabel();
        emLabel.setText("Email :");
        emLabel.setBounds(100, 245, 200, 40);
        emLabel.setFont(mainFont);
        pane.add(emLabel);

        JTextField emaField = new JTextField();
        emaField.setBounds(100, 295, 610, 60);
        emaField.setBackground(new Color(0xDFE1E2));
        emaField.setFont(mainFont);
        pane.add(emaField);

        JLabel passwordJLabel = new JLabel();
        passwordJLabel.setText("Password :");
        passwordJLabel.setBounds(100, 370, 200, 40);
        passwordJLabel.setFont(mainFont);
        pane.add(passwordJLabel);

        JPasswordField passField = new JPasswordField();
        passField.setBounds(100, 420, 610, 60);
        passField.setBackground(new Color(0xDFE1E2));
        passField.setFont(mainFont);
        pane.add(passField);

        MyButton connect  = new MyButton("Login", 24, Styles.BLUE_COLOR, Styles.BG_COLOR);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        connect.setBounds(200, 530, 400, 70);
        connect.setBackground(new Color(0x022243));
        connect.setText("Login");
        connect.setFont(mainFont2);
        connect.setForeground(new Color(0xffffff));
        connect.setHorizontalTextPosition(JButton.CENTER);
        connect.setFocusable(false);
        //connect.setAction();
        pane.add(connect);

        ImageIcon logo2 = new ImageIcon("logo33.png");
        JLabel logo = new JLabel(logo2);
        logo.setBorder(border);

        JFrame frameL = new JFrame();
        frameL.setVisible(true);
        frameL.setSize(1440, 1024);
        frameL.setTitle("Login");
        frameL.setBackground(new Color(0xfffffff));

        JPanel pan = new JPanel();
        pan.setLayout(new BorderLayout());
        pan.setBackground(new Color(0x022243));

        frameL.add(pane, BorderLayout.CENTER);
        pan.add(logo, BorderLayout.CENTER);
        frameL.add(pan, BorderLayout.WEST);
        

    }

    private void setDefaultCloseOperation(int exitOnClose) {
    }

    @Override
    public void actionPerformed (ActionEvent e){
        if (e.getSource()==connect) {
            System.out.println("pppppp");
        }
    }

}