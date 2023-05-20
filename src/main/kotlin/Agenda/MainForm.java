package Agenda;

 import Business.ContactBusiness;
 import Entity.EntityContact;

 import javax.swing.*;
 import javax.swing.event.ListSelectionEvent;
 import javax.swing.event.ListSelectionListener;
 import javax.swing.table.DefaultTableModel;
 import java.awt.*;
 import java.awt.event.ActionEvent;
 import java.awt.event.ActionListener;
 import java.util.List;

public class MainForm extends JFrame {
    public JPanel rootPanel;
    public JButton removeButton;
    public JTable tableContacts;
    public JButton newButton;
    public JLabel labelContactCount;

    private ContactBusiness rContactBusiness;
    private String Name = "";
    private String Phone = "";

    public MainForm() {
        rContactBusiness = new ContactBusiness();

        setContentPane(rootPanel);
        setSize(500, 300);
        setVisible(true);

        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        setLocation(dim.width / 2 - getSize().width / 2, dim.height / 2 - getSize().height / 2);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        loadContacts();
        setListeners();
    }

    private void loadContacts() {
        List<EntityContact> contactList = rContactBusiness.getList();
        String[] column = {"Name", "Phone Number"};
        DefaultTableModel tables = new DefaultTableModel(new Object[0][0], column);

        for (EntityContact i : contactList) {
            Object o[] = new Object[2];
            o[0] = i.getName();
            o[1] = i.getPhone();
            tables.addRow(o);
        }
        tableContacts.clearSelection();
        tableContacts.setModel(tables);
        labelContactCount.setText(rContactBusiness.getCountList());
    }

    private void setListeners() {
        newButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                new ContactForm();
                dispose();
            }
        });
        tableContacts.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent ListSelectionEvent) {
                if (ListSelectionEvent.getValueIsAdjusting()) {
                    if (tableContacts.getSelectedRow() != -1) {
                        Name = tableContacts.getValueAt(tableContacts.getSelectedRow(), 0).toString();
                        Phone = tableContacts.getValueAt(tableContacts.getSelectedRow(), 1).toString();
                    }
                }
            }
        });
        removeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    rContactBusiness.delete(Name, Phone);
                    loadContacts();
                    Name = "";
                    Phone = "";
                    //limpando o contatoselecionado
                } catch (Exception e) {
                    JOptionPane.showConfirmDialog(new JFrame(), e.getMessage());
                }
            }
        });
    }

}

