package officeinvantoryapps;

import java.awt.Color;
import java.awt.Container;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Mynewframe extends JFrame {

    ArrayList<product> productlist;

    private Container c;
    private JLabel pn, pc, pp, pd, prd, pq, ser;
    public static JTextField texf1, texf2, texf3, texf4, texf5, texf6, texf7;
    private JButton add, update, delete, search, exit;
    private JTable table;
    private JScrollPane scroll;
    private DefaultTableModel model;

    Mynewframe() {
        initcomponent();
    }

    public void initcomponent() {
        productlist = new ArrayList<>();

        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Office Inventory System");

        c = this.getContentPane();
        c.setLayout(null);

        String[] col = {"P.Name", "P.code", "P.price", "P.description", "P.R.date", "P.quantity"};
        Object[] p = new Object[6];

        Font fc;

        fc = new Font("Arial", Font.CENTER_BASELINE, 14);
        pn = new JLabel(" Product Name");
        pc = new JLabel("Product code");
        pp = new JLabel("Product price");
        pd = new JLabel("Product description");
        prd = new JLabel("Product regster date");
        pq = new JLabel("Product quantity");
        ser = new JLabel("Please enter product code for search and delete");

        texf1 = new JTextField();
        texf2 = new JTextField();
        texf3 = new JTextField();
        texf4 = new JTextField();
        texf5 = new JTextField();
        texf6 = new JTextField();
        texf7 = new JTextField();
        add = new JButton("Add");
        update = new JButton("Update");
        delete = new JButton("Delete");
        search = new JButton("Search");
        exit = new JButton("Exit");

        model = new DefaultTableModel();
        model.setColumnIdentifiers(col);
        table = new JTable();
        table.setModel(model);
        scroll = new JScrollPane(table);
        table.setSelectionBackground(Color.MAGENTA);

        pn.setBounds(10, 30, 200, 30);
        pc.setBounds(10, 70, 200, 30);
        pp.setBounds(10, 110, 200, 30);
        pd.setBounds(10, 160, 200, 30);
        prd.setBounds(10, 210, 200, 30);
        pq.setBounds(10, 260, 200, 30);
        ser.setBounds(10, 300, 350, 30);

        texf1.setBounds(200, 30, 300, 30);
        texf2.setBounds(200, 70, 300, 30);
        texf3.setBounds(200, 110, 300, 30);
        texf4.setBounds(200, 160, 300, 30);
        texf5.setBounds(200, 210, 300, 30);
        texf6.setBounds(200, 260, 300, 30);
        texf7.setBounds(400, 300, 150, 30);

        add.setBounds(20, 330, 80, 30);
        update.setBounds(170, 330, 80, 30);

       
        search.setBounds(310, 330, 80, 30);
        delete.setBounds(470, 330, 80, 30);
        scroll.setBounds(25, 370, 540, 150);
        exit.setBounds(480, 520, 80, 30);

        pn.setFont(fc);
        pc.setFont(fc);
        pd.setFont(fc);
        pp.setFont(fc);
        prd.setFont(fc);
        pq.setFont(fc);
        ser.setFont(fc);

        c.add(pn);
        c.add(pc);
        c.add(pp);
        c.add(pd);
        c.add(prd);
        c.add(pq);
        c.add(ser);
        c.add(texf1);
        c.add(texf2);
        c.add(texf3);
        c.add(texf4);
        c.add(texf5);
        c.add(texf6);
        c.add(texf7);

        c.add(add);
        c.add(update);
        c.add(delete);
        c.add(exit);

        c.add(search);
        c.add(scroll);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {

                System.exit(0);

            }
        });

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                String pname = texf1.getText();
                String pcode = texf2.getText();
                String pprice = texf3.getText();
                String pdescription = texf4.getText();
                String pedate = texf5.getText();
                String pquantity = texf6.getText();

                productlist.add(new product(pname, pcode, pprice, pdescription, pedate, pquantity));

                writeData();
                clearData();

            }
        });

        table.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {

                // i = the index of the selected row
                int i = table.getSelectedRow();

                texf1.setText(model.getValueAt(i, 0).toString());
                texf2.setText(model.getValueAt(i, 1).toString());

                texf3.setText(model.getValueAt(i, 2).toString());
                texf4.setText(model.getValueAt(i, 3).toString());
                texf5.setText(model.getValueAt(i, 4).toString());
                texf6.setText(model.getValueAt(i, 5).toString());

            }
        });
        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // i = the index of the selected row
                int i = table.getSelectedRow();
                String newpname = texf1.getText();
                String newpcode = texf2.getText();
                String newpprice = texf3.getText();
                String newpdescription = texf4.getText();
                String newpedate = texf5.getText();
                String newpquantity = texf6.getText();

                productlist.get(i).pname = newpname;
                productlist.get(i).pcode = newpcode;
                productlist.get(i).pprice = newpprice;
                productlist.get(i).pdescription = newpdescription;
                productlist.get(i).pedate = newpedate;
                productlist.get(i).pquantity = newpquantity;
                writeData();

            }
        });
        // button remove row
        delete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // i = the index of the selected row
                /*    int i = table.getSelectedRow();
                if (i >= 0) {
                JOptionPane.showMessageDialog(null, "ok");
                // remove a row from jtable
                model.removeRow(i);
                } */
                String target = texf7.getText();
                for (int i = 0; i < productlist.size(); i++) {

                    if (productlist.get(i).pcode.equalsIgnoreCase(target)) {
                        //
                        //productlist[i] = productlist[i+1];
                        JOptionPane.showMessageDialog(null, "ok");

                        productlist.remove(i);
                        model.removeRow(i);
                    } else {
                        continue;
                    }

                    return;
                }
                JOptionPane.showMessageDialog(delete, "Not Found !", " product", 2);
                clearData();

            }
        });

        search.addActionListener((ActionEvent e) -> {
            String target = texf7.getText();

            for (int i = 0; i < productlist.size(); i++) {
                if (productlist.get(i).pcode.equalsIgnoreCase(target)) {

                    JOptionPane.showMessageDialog(search, "Found !", "Search product", 2);

                    texf1.setText(productlist.get(i).pname);
                    texf2.setText(productlist.get(i).pcode);
                    texf3.setText(productlist.get(i).pprice);
                    texf4.setText(productlist.get(i).pdescription);
                    texf5.setText(productlist.get(i).pedate);
                    texf6.setText(productlist.get(i).pquantity);

                } else {
                    continue;
                }

                return;
            }
            JOptionPane.showMessageDialog(search, "Not Found !", "Search product", 2);

        } //GEN-LAST:event_jbtsearchActionPerformed
        );

    }

    private void clearData() {
        texf1.setText(null);
        texf2.setText(null);
        texf3.setText(null);
        texf4.setText(null);
        texf5.setText(null);
        texf6.setText(null);
    }

    private void loadData() {
        try {
            File inFile = new File("data.txt");
            Scanner scanner = new Scanner(inFile);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                String studarray[] = data.toString().split(",");
                String productArray[] = data.toString().split(",");
                productlist.add(new product(productArray[0], productArray[1], productArray[2], productArray[3], productArray[4], productArray[5]));

            }
        } catch (Exception e) {

        }
        model.setRowCount(0);
        for (int i = 0; i < productlist.size(); i++) {

            Object[] obj = {productlist.get(i).pname, productlist.get(i).pcode, productlist.get(i).pprice, productlist.get(i).pdescription, productlist.get(i).pedate, productlist.get(i).pquantity};

        }
    }

    private void writeData() {
        try {
            File outFile = new File("data.txt");
            FileWriter outFileStream = new FileWriter(outFile);
            PrintWriter outStream = new PrintWriter(outFileStream);
            for (int i = 0; i < productlist.size(); i++) {
                outStream.print(productlist.get(i).pname + ",");
                outStream.print(productlist.get(i).pcode + ",");
                outStream.print(productlist.get(i).pprice + ",");
                outStream.print(productlist.get(i).pdescription + ",");
                outStream.print(productlist.get(i).pedate + ",");
                outStream.println(productlist.get(i).pquantity);
            }
            outStream.close();

        } catch (IOException xe) {

        }

        model.setRowCount(0);
        for (int i = 0; i < productlist.size(); i++) {
            Object[] obj = {productlist.get(i).pname, productlist.get(i).pcode, productlist.get(i).pprice, productlist.get(i).pdescription, productlist.get(i).pedate, productlist.get(i).pquantity};

            model.addRow(obj);

        }

    }

    public static void main(String[] args) {

        Mynewframe j = new Mynewframe();
        j.setVisible(true);

    }

}
