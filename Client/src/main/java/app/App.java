package app;

import javax.swing.*;

public class App extends JFrame{
    JFrame jFrame;
    public App(){
        JButton jButton = new JButton("click"); // create instance of JButton
        jButton.setBounds(130,100,100,40);
        add(jButton); // add button in JFrame
        setSize(380,420); //400w x 500h frame
        setLayout(null); // use no layout manager
        setVisible(true); // make frame visible
    };
}
