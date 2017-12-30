//apples.java 

import javax.swing.JFrame; //give basic windows features
public class apples {
    public static void main (String[] args){
        
        tuna joel = new tuna(); 
        
        //close operation
        joel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //set windows size 
        joel.setSize(350,100);
        //set visibility
        joel.setVisible(true);
    }
}

//tuna.java
import java.awt.Component;
import java.awt.FlowLayout; // gives you the layout
import java.awt.event.ActionListener; //listens for an user action 
import java.awt.event.ActionEvent;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JOptionPane;


        
public class tuna extends JFrame{
    
    private JTextField item1;
    private JTextField item2;
    private JTextField item3;
    private JPasswordField passwordField;
    
    public tuna() {
        
        super("the title");
        setLayout(new FlowLayout());
        
        item1 = new JTextField(10); //the length of it is 10
        //add item to the window
        Component add = add(item1);
        
        item2 = new JTextField("enter text here"); //default text entered 
        //add item to the window
        add(item2);
        
        item3 = new JTextField("uneditable", 20); //the textfield is uneditable and has a length of 20
        //make sure the user can't edit
        item3.setEditable(false); //can see but can't touch
        //add item to the window
        add(item3);
        
        passwordField = new JPasswordField(10);
        add(passwordField);
        
        thehandler handler = new thehandler(); //build an action listener object 
        item1.addActionListener(handler);
        item2.addActionListener(handler);
        item3.addActionListener(handler);
        passwordField.addActionListener(handler);
        
    }
    //build a class inside a class 
    //class that handles the events 
    //takes one method 
    private class thehandler implements ActionListener{
        
        public void actionPerformed(ActionEvent event){
            
            String string = "";
            
            if(event.getSource() == item1){
                string=String.format("field 1: %s", event.getActionCommand());                
            }
            else if (event.getSource() == item2){
                string=String.format("field 2: %s", event.getActionCommand());                
            }
            else if (event.getSource() == item3){
                string=String.format("field 3: %s", event.getActionCommand());               
            }
            else if (event.getSource() == passwordField){
                string=String.format("password field is: %s", event.getActionCommand());
                
            }
            //blank window
            JOptionPane.showMessageDialog(null, string);
        }
    }
    
}
