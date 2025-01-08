
package airlinemanagementsystem;
//import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
public  class Login extends JFrame implements ActionListener{
    
    JButton  submit, reset, close;
    JTextField tfusername;
    JPasswordField tfPassword;
     
    public Login(){
        getContentPane().setBackground(Color.CYAN);
        setLayout(null);
        
        JLabel lblusername  = new JLabel("Username");
        lblusername.setBounds(20, 20, 100, 20);    
        add(lblusername);
                
        tfusername = new JTextField();
        tfusername.setBounds(130, 20, 200, 20);
        add(tfusername);
        
        
        JLabel lblpassword  = new JLabel("password");
        lblpassword.setBounds(20, 60, 100, 20);    
        add(lblpassword);
        
        tfPassword = new JPasswordField();
        tfPassword.setBounds(130, 60, 200, 20);
        add(tfPassword);

        reset = new JButton("Reset");
        reset.setBounds(40, 120, 120, 20);
        reset.addActionListener(this);
        add(reset);
        
        submit = new JButton("submit");
        submit.setBounds(190, 120, 120, 20);
        submit.addActionListener(this);
        add(submit);
        
        close = new JButton("close");
        close.setBounds(130, 160, 120, 20);
        close.addActionListener(this);
        add(close);
        
        
        setSize(400,250);
        setLocation(600,250);
      setVisible(true);  
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()== submit){
            String username = tfusername.getText();
            String Password = tfPassword.getText();
            
            try{
                Conn c = new Conn();
                String query = "select*  from login where username  = '"+username+"' and password = '"+Password+"'";
               ResultSet rs = c.s.executeQuery(query);
               if (rs.next()) {
                   new Home();
                   //System.out.println("Valid");
                   setVisible(false);
               }
               else{
                   JOptionPane.showMessageDialog(null,"Invalid  Username or Password");
                   setVisible(false);
               }
            }
            catch(Exception e){
                e.printStackTrace();
            }
    }else if(ae.getSource()== close){
        setVisible(false);
    }else if(ae.getSource()== reset){
        
        tfusername.setText(" ");
        tfPassword.setText(" ");
    }
        
    }
    
    public static void main(String[]args){
        new Login();
    }
    
}
