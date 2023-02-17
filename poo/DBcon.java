import java.sql.*;
import javax.swing.*;
import javax.swing.table.*;

public class DBcon {

    Statement stmt;

    public DBcon() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String user = "root";
            String pass = "";
            String Bdd = "gg";
            String host = "jdbc:mysql://localhost:3306/" + Bdd;
            Connection con;
            con = DriverManager.getConnection(host, user, pass);
            stmt = con.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    public void afficher(JTable tab) {

        String column[] = { "Code", "Nom", "Prix", "Quantite", "description", "categorie" };
        DefaultTableModel model = new DefaultTableModel(null, column);
        try {

            ResultSet resultat = stmt.executeQuery("SELECT * FROM products");
            while (resultat.next()) {

                String c = resultat.getString("code");
                String n = resultat.getString("nom");
                String p = resultat.getString("prix");
                String q = resultat.getString("quantite");
                String d = resultat.getString("description");
                String ct = resultat.getString("categorie");

                String[] s = { c, n, p, q, d, ct };

                model.addRow(s);

            }
            tab.setModel(model);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void supprime(String code) {
        try {
            stmt.executeUpdate("Delete FROM products where code = '" + code + "';");
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public void rechrcher(JTable tab, String x) {

        String column[] = { "Code", "Nom", "Prix", "Quantite", "description", "categorie" };
        DefaultTableModel model = new DefaultTableModel(null, column);
        try {
            ResultSet resultat = stmt.executeQuery("SELECT * FROM products where code = '" + x + "';");
            if (resultat.next()) {

                String c = resultat.getString("code");
                String n = resultat.getString("nom");
                String p = resultat.getString("prix");
                String q = resultat.getString("quantite");
                String d = resultat.getString("description");
                String ct = resultat.getString("categorie");

                String[] o = { c, n, p, q, d, ct };

                model.addRow(o);
            }
            tab.setModel(model);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    public String[] getRow(String code) {
        String[] s = { "", "", "", "", "", "" };
        try {
            ResultSet resultat = stmt.executeQuery("SELECT * FROM products where code = '" + code + "';");
            if (resultat.next()) {
                s[0] = resultat.getString("nom");
                s[1] = resultat.getString("prix");
                s[2] = resultat.getString("quantite");
                s[3] = resultat.getString("categorie");
                s[4] = resultat.getString("description");

            }
        } catch (Exception e) {
            // TODO: handle exception
        }
        return s;
    }

    public boolean codeExist(String code) {
        ResultSet rs;
        try {
            rs = stmt.executeQuery("SELECT * FROM products WHERE code = '" + code + "';");
            if (rs.next() == true) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            return false;
        }
    }

    public void ajouter(String code, int prix, String nom, int quantite, String categorie, String desc) {
        try {
            stmt.executeUpdate("INSERT INTO products (code, nom, prix, quantite, description, categorie) VALUES ('" + code + "','" + nom
                    + "','" + prix + "','" + quantite + "','" + desc + "','" + categorie + "');");
            JOptionPane.showMessageDialog(null, "products Added Succesfuly");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "products not  Added ");

        }

    }

    public void alter(String code, int prix, String nom, int quantite, String categorie, String desc) {
        try {
            stmt.executeUpdate("UPDATE products SET prix = '" + prix + "', nom = '" + nom + "', categorie = '" + categorie
                    + "', quantite = '" + quantite + "', description = '" + desc +"' WHERE code = '" + code + "';");
            JOptionPane.showMessageDialog(null, "products updated Succesfuly");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "products not  updated ");

        }
    }

}
