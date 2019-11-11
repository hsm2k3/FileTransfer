package app;

import javax.swing.*;

public class App extends JFrame {

    public App(){
        super("Any File");
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JButton jButton = new JButton("Browse"); // create instance of JButton
                jButton.setBounds(130,100,100,40);
                add(jButton); // add button in JFrame
                setSize(380,420); //400w x 500h frame
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                setLayout(null); // use no layout manager
                setVisible(true); // make frame visible
            }
        });
    }
}
