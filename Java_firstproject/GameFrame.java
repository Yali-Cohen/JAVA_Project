package Java_firstproject;


import javax.swing.*;
// import java.awt.*;
// import java.awt.Image;

public class GameFrame extends JFrame {
     GameFrame() {
    this.add( new GamePanel());
    this.setTitle("AsteroSpace");
    ImageIcon icon=new ImageIcon("image2.jpg");
    this.setIconImage(icon.getImage());
    this.setLocationRelativeTo(null);
    this.setResizable(false);
    this.pack();


    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    this.setVisible(true);
    
}
}