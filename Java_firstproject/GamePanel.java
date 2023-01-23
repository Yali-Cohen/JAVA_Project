package Java_firstproject;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.ActionListener;
public class GamePanel extends JPanel implements ActionListener{
    static final int SCREEN_HEIGHT=800;
    static final int SCREEN_WIDTH=1600;
    static final int ROCKET_HEIGHT=60;
    static final int ROCKET_WIDTH=230;
    static final int MAX_DIAMETER_ASTEROID=150;
    static final int MIN_DIAMETER_ASTEROID=30;
    static final int DELAY=25;
    static final int BUTTON_HEIGHT=100;
    static final int BUTTON_WIDTH=200;
    static final int MEMORY=SCREEN_WIDTH/50;

    static int value=0;

    int speed=15;
    int s=5;
    double seconds=0;
    char direction='L';
    boolean running=false;
    boolean takeAction=false;

    Rocket r;
    Asteroid a;
    Timer timer;
    JButton button;
    ImageIcon space1;
    ImageIcon space2;
    JLabel label;
    
    GamePanel(){
        this.setPreferredSize(new Dimension(SCREEN_WIDTH,SCREEN_HEIGHT));
        gameOpening();
    }

    public void gameOpening(){
        this.setLayout(null);
        button=new JButton("start game");
        button.setBounds(SCREEN_WIDTH/2-BUTTON_WIDTH/2,SCREEN_HEIGHT/2-BUTTON_HEIGHT/2,BUTTON_WIDTH,BUTTON_HEIGHT);
        button.setFocusable(false);
        button.addActionListener(this);
        space1=new ImageIcon("SpaceBackgroundImage1.jpg");
        label=new JLabel();
        label.setBounds(0,0,SCREEN_WIDTH,SCREEN_HEIGHT);
        label.setIcon(space1);
        label.setText("WELCOM TO ASTEROSPACE GAME! To continue click the button below");
        label.setHorizontalTextPosition(JLabel.CENTER);
        label.setVerticalTextPosition(JLabel.TOP);
        label.setIconTextGap(-SCREEN_HEIGHT/5);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("MV Boli",Font.PLAIN,30));
        label.add(button);
        this.add(label);
    }
    public void beginGame(){
        r=new Rocket(SCREEN_HEIGHT,SCREEN_WIDTH,ROCKET_HEIGHT,ROCKET_WIDTH);
        a=new Asteroid(SCREEN_HEIGHT,SCREEN_WIDTH,MAX_DIAMETER_ASTEROID,MIN_DIAMETER_ASTEROID,ROCKET_HEIGHT,MEMORY);
        running=true;
        timer=new Timer(DELAY,this);
        timer.start();
    }
    public void startGame(){
        takeAction=true;
        this.setFocusable(true);
        this.addKeyListener(new GameKeyAdapter());
        this.requestFocus();
    }
    public void endGame(){
        timer.stop();
        takeAction=false;
        this.setFocusable(false);
        value=0;
        speed=10;
        s=5;
        seconds=0;
        direction='L';
        label.setText("You Crashed! The Game Is Over. to play again click the button below");
        label.setForeground(Color.YELLOW);
        button.setText("play again");
        label.add(button);
    }

    public void move(){
        if(running==true && takeAction==true){
            for(int i=0;i<MEMORY;i++){
                a.xAsteroid[i]+=speed;
            }
            if(value>0){
                if(a.xAsteroid[value-1]>=ROCKET_WIDTH*2){
                    a.newAsteroid(value);
                }
            }
            else{
                if(a.xAsteroid[MEMORY-1]>=ROCKET_WIDTH*2){
                    a.newAsteroid(value);
                }
            }
            repaint();
        }
        else{
            for (int i=0;i<3;i++){
                r.xPointsTriangular[i]-=speed;
            }
            for (int i=0;i<4;i++){
                r.xPointsRectangle[i]-=speed;
            }
            for (int i=0;i<7;i++){
                r.xPointsFire[i]-=speed;
            }
            repaint();
            if(r.xPointsTriangular[0]<=SCREEN_WIDTH/2){
                startGame(); 
            }
        }
        if(direction=='U'){
            if(r.yPointsTriangular[2]>=5){
                r.yPointsTriangular[0]-=speed/3;
                r.yPointsTriangular[1]-=speed/3;
                r.yPointsTriangular[2]-=speed/3;
    
                r.yPointsRectangle[0]-=speed/3;
                r.yPointsRectangle[1]-=speed/3;
                r.yPointsRectangle[2]-=speed/3;
                r.yPointsRectangle[3]-=speed/3;
    
                r.yPointsFire[0]-=speed/3;
                r.yPointsFire[1]-=speed/3;
                r.yPointsFire[2]-=speed/3;
                r.yPointsFire[3]-=speed/3;
                r.yPointsFire[4]-=speed/3;
                r.yPointsFire[5]-=speed/3;
                r.yPointsFire[6]-=speed/3; 
            }
        }
        if(direction=='D'){
            if(r.yPointsTriangular[1]<=SCREEN_HEIGHT-5){
                r.yPointsTriangular[0]+=speed/3;
                r.yPointsTriangular[1]+=speed/3;
                r.yPointsTriangular[2]+=speed/3;

                r.yPointsRectangle[0]+=speed/3;
                r.yPointsRectangle[1]+=speed/3;
                r.yPointsRectangle[2]+=speed/3;
                r.yPointsRectangle[3]+=speed/3;

                r.yPointsFire[0]+=speed/3;
                r.yPointsFire[1]+=speed/3;
                r.yPointsFire[2]+=speed/3;
                r.yPointsFire[3]+=speed/3;
                r.yPointsFire[4]+=speed/3;
                r.yPointsFire[5]+=speed/3;
                r.yPointsFire[6]+=speed/3;
            }
        }
    }
    public void checkCollision(){
        int x1[]={r.xPointsTriangular[0],r.xPointsTriangular[1],r.xPointsTriangular[2],r.xPointsRectangle[0],r.xPointsRectangle[1],r.xPointsRectangle[2],r.xPointsRectangle[3]};
        int y1[]={r.yPointsTriangular[0],r.yPointsTriangular[1],r.yPointsTriangular[2],r.yPointsRectangle[0],r.yPointsRectangle[1],r.yPointsRectangle[2],r.yPointsRectangle[3]};
        int x2[]=new int[MEMORY];
        int y2[]=new int[MEMORY];
        int radius[]=new int[MEMORY];
        for(int i=0;i<MEMORY;i++){
            x2[i]=a.xAsteroid[i]+a.diameterAsteroid[i]/2;
            y2[i]=a.yAsteroid[i]+a.diameterAsteroid[i]/2;
            radius[i]=a.diameterAsteroid[i]/2;
        }
        for(int i=0;i<7;i++){
            for(int j=0;j<MEMORY;j++){
                int d=(int) Math.sqrt(Math.pow(x1[i]-x2[j],2)+Math.pow(y1[i]-y2[j],2));
                if(d-radius[j]<=0){
                    a.yAsteroid[j]=SCREEN_WIDTH+5;
                    for (int k=0;k<3;k++){
                        r.xPointsTriangular[k]+=SCREEN_WIDTH+5;
                    }
                    for (int k=0;k<4;k++){
                        r.xPointsRectangle[k]+=SCREEN_WIDTH+5;
                    }
                    for (int k=0;k<7;k++){
                        r.xPointsFire[k]+=SCREEN_WIDTH+5;
                    }
                    endGame();
                }
            }
        }
    }

    public void time(){
        seconds+=DELAY/1000.0;
        if((int)seconds==s){
            s+=5;
            speed+=1;
        }
    }

    @Override
    public void paint(Graphics g){
        super.paint(g);
        if(running==true){
            r.draw(g);
            a.draw(g);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==timer){
            if(running==true && takeAction==true){
                move();
                time();
                checkCollision();
            }
            else{
                move();
            }
        }
        else{
           label.remove(button);
           label.setText("");
           space2=new ImageIcon("SpaceBackgroundImage2.png");
           label.setIcon(space2);
           beginGame();
        }
    }



public class GameKeyAdapter extends KeyAdapter{
    @Override
    public void keyPressed(KeyEvent e){
		if(e.getKeyCode()==KeyEvent.VK_UP){
            direction='U';
        }	
		if(e.getKeyCode()==KeyEvent.VK_DOWN){
            direction='D';
        }
    }
    @Override
    public void keyReleased(KeyEvent e){
        direction='L';
    }
}
}