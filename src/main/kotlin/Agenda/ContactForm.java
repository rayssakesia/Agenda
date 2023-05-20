package Agenda;
import Business.ContactBusiness;
import Entity.EntityContact;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactForm extends JFrame {
    private JPanel rootPanel;
    public JTextField textName;
    public JTextField textPhone;
    public JButton buttonSave;
    public JButton buttonCancel;
    private ContactBusiness rContactBusiness;
    String Name;
    String Phone;

    public ContactForm() {
        setContentPane(rootPanel);
        setSize(500, 250);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        rContactBusiness = new ContactBusiness();
        setListeners();
    }


    private void setListeners() {
        buttonSave.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    Name = textName.getText();
                    Phone = textPhone.getText();
                    rContactBusiness.save(Name, Phone);
                    new MainForm();
                    dispose();
                } catch (Exception ex) {
                    JOptionPane.showConfirmDialog(new JFrame(), ex.getMessage());
                }
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new MainForm();
                dispose();
            }
        });
    }


}