package Tugas4pbo_123200029;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class GUI extends JFrame{
    JLabel labelUsername = new JLabel("Username : ");
    JTextField fieldUsername = new JTextField (20);
    JLabel labelPassword = new JLabel ("Password : ");
    JPasswordField fieldPassword = new JPasswordField(10);
    JButton buttonLogin = new JButton("Login");
    JLabel labelRegUser = new JLabel ("Username : ");
    JTextField fieldRegUser = new JTextField (20);
    JLabel labelRegPass = new JLabel ("Password : ");
    JPasswordField fieldRegPass = new JPasswordField (10);
    JButton buttonRegister = new JButton ("Register");
    
    public GUI(){
        setVisible(true);
        setTitle("");
        setSize(600,230);
        setLayout(null);
        
        add(labelUsername);
        add(fieldUsername);
        add(labelPassword);
        add(fieldPassword);
        add(buttonLogin);
        
        add(labelRegUser);
        add(fieldRegUser);
        add(labelRegPass);
        add(fieldRegPass);
        add(buttonRegister);
        
        labelUsername.setBounds(30, 40, 100,30);
        fieldUsername.setBounds(120,40,100,30);
        labelPassword.setBounds(30,80,100,30);
        fieldPassword.setBounds(120,80,100,30);
        buttonLogin.setBounds(120,120,90,20);
        
        labelRegUser.setBounds(270,40,100,30);
        fieldRegUser.setBounds(360,40,100,30);
        labelRegPass.setBounds(270,80,100,30);
        fieldRegPass.setBounds(360,80,100,30);
        buttonRegister.setBounds(360,120,90,20);
        
        buttonLogin.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Connector conn = new Connector();
                String user = fieldUsername.getText();
                System.out.println(user);
                if (conn.checkUsername(user) && user != "" && conn.checkLogin(user, String.valueOf(fieldPassword.getPassword()))) {
                    JOptionPane.showMessageDialog(null, "Login Sukses!");
                }
                else if (user.isEmpty() || String.valueOf(fieldPassword.getPassword()).isEmpty()) { //error handling
                    JOptionPane.showMessageDialog(null, "Jangan Kosong!");
                }
                else if (!conn.checkUsername(user)) {
                    JOptionPane.showMessageDialog(null, "Username Salah!");
                }
                else{
                    JOptionPane.showMessageDialog(null,"Password Salah!");
                }
                
            }
            
        });
        buttonRegister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                Connector conn = new Connector();
                String reguser = fieldRegUser.getText();
                String regpass = String.valueOf(fieldRegPass.getPassword());
                if (!reguser.isEmpty() && !regpass.isEmpty()) {
                    conn.masukData(reguser,regpass);
                    JOptionPane.showMessageDialog(null, "Register Sukses!");
                }
                else if (reguser.isEmpty() || regpass.isEmpty()) { //error handling
                    JOptionPane.showMessageDialog(null, "Jangan Kosong!");
                }
            }
        });
    }
    
}
