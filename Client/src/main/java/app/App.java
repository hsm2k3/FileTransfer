package app;

import javax.swing.*;

public class App extends JFrame {

    public App(){
        JFrame jFrame = new JFrame("Any File");
        JButton jButton = new JButton("Browse"); // create instance of JButton
        jButton.setBounds(130,100,100,40);
        jFrame.add(jButton); // add button in JFrame
        jFrame.setSize(380,420); //400w x 500h frame
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setLayout(null); // use no layout manager
        jFrame.setVisible(true); // make frame visible
    }
}
