package Java_firstproject;
import java.awt.Graphics;
import java.util.Random;

public class Asteroid {
    static int screenHeight;
    static int maxDiameterAsteroid;
    static int minDiameterAsteroid;
    static int rocketHeight;
    static int memory;

    int xAsteroid[];
    int yAsteroid[];
    int diameterAsteroid[];

    Random random;

    Asteroid(int screenHeight,int screenWidth,int maxDiameterAsteroid,int minDiameterAsteroid,int rocketHeight,int memory){
        Asteroid.screenHeight=screenHeight;
        Asteroid.maxDiameterAsteroid=maxDiameterAsteroid;
        Asteroid.minDiameterAsteroid=minDiameterAsteroid;
        Asteroid.rocketHeight=rocketHeight;
        Asteroid.memory=memory;

        xAsteroid=new int[memory];
        yAsteroid=new int[memory];
        diameterAsteroid=new int[memory];    

        for(int i=0;i<memory;i++){
            xAsteroid[i]=screenWidth+5;
        }

        random=new Random();
    }

    public void newAsteroid(int value){
        int diameter;
        int y;
        int max;
        int min;
        for(int i=0;i<3;i++){
            if(i==0){
                diameterAsteroid[value]=random.nextInt(maxDiameterAsteroid-minDiameterAsteroid+1)+minDiameterAsteroid;
                max=screenHeight-diameterAsteroid[value]/3;
                min=-diameterAsteroid[value]/3;
                yAsteroid[value]=random.nextInt(max-min+1)+min;
                xAsteroid[value]=-maxDiameterAsteroid-5;
                value+=1;
            }

            else if(i==1){
                diameter=random.nextInt(maxDiameterAsteroid-minDiameterAsteroid+1)+minDiameterAsteroid;
                max=screenHeight-diameter/3;
                if(value>0){
                    min=yAsteroid[value-1]+diameterAsteroid[value-1];
                    if(max>min){
                        y=random.nextInt(max-min+1)+min;
                    }
                    else{
                        y=-screenHeight*2;
                    }
                    if(y-diameterAsteroid[value-1]-yAsteroid[value-1]>=rocketHeight*2){
                        diameterAsteroid[value]=diameter;
                        yAsteroid[value]=y;
                        xAsteroid[value]=-maxDiameterAsteroid-5;
                        value+=1;
                    }
                }

                else{
                    min=yAsteroid[memory-1]+diameterAsteroid[memory-1];
                    if(max>min){
                        y=random.nextInt(max-min+1)+min;
                    }
                    else{
                        y=-screenHeight*2;
                    }
                    if(y-diameterAsteroid[memory-1]-yAsteroid[memory-1]>=rocketHeight*2){
                        diameterAsteroid[value]=diameter;
                        yAsteroid[value]=y;
                        xAsteroid[value]=-maxDiameterAsteroid-5;
                        value+=1;
                    }
                }
            }

            else{
                diameter=random.nextInt(maxDiameterAsteroid-minDiameterAsteroid+1)+minDiameterAsteroid;
                min=-diameter/3;
                if(value>0){
                    max=screenHeight-yAsteroid[value-1]-diameter;
                    if(max>min){
                        y=random.nextInt(max-min+1)+min;
                    }
                    else {
                        y=screenHeight*2;
                    }
                    if(yAsteroid[value-1]-diameter-y>=rocketHeight*2){
                        diameterAsteroid[value]=diameter;
                        yAsteroid[value]=y;
                        xAsteroid[value]=-maxDiameterAsteroid-5; 
                        value+=1;
                    }
                }

                else{
                    max=screenHeight-yAsteroid[memory-1]-diameter;
                    if(max>min){
                        y=random.nextInt(max-min+1)+min;
                    }
                    else {
                        y=screenHeight*2;
                    }
                    if(yAsteroid[memory-1]-diameter-y>=rocketHeight*2){
                        diameterAsteroid[value]=diameter;
                        yAsteroid[value]=y;
                        xAsteroid[value]=-maxDiameterAsteroid-5;
                        value+=1;
                    }
                }
            }
            if(value==memory){
                value=0;
            }
        }
        GamePanel.value=value;
    }
    
    public void draw(Graphics g){
        g.setColor(new java.awt.Color(95, 2, 31));
        for(int i=0;i<memory;i++){
            g.fillOval(xAsteroid[i], yAsteroid[i], diameterAsteroid[i], diameterAsteroid[i]);
        }
    }
}