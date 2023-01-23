package Java_firstproject;
import java.awt.Color;
import java.awt.Graphics;

public class Rocket {
    int xPointsTriangular[]=new int[3];
    int yPointsTriangular[]=new int[3];
    int xPointsRectangle[]=new int[4];
    int yPointsRectangle[]=new int[4];
    int xPointsFire[]=new int[7];
    int yPointsFire[]=new int[7];

    Rocket(int screenHeight,int screenWidth,int rocketHeight,int rocketWidth){
        xPointsTriangular[0]=screenWidth-rocketWidth+rocketWidth;
        xPointsTriangular[1]=screenWidth-rocketWidth/4*3+rocketWidth;
        xPointsTriangular[2]=screenWidth-rocketWidth/4*3+rocketWidth;

        yPointsTriangular[0]=screenHeight/2;
        yPointsTriangular[1]=screenHeight/2+rocketHeight/2;
        yPointsTriangular[2]=screenHeight/2-rocketHeight/2;

        xPointsRectangle[0]=screenWidth-rocketWidth/4*3+rocketWidth;
        xPointsRectangle[1]=screenWidth-rocketWidth*1/5+rocketWidth;
        xPointsRectangle[2]=screenWidth-rocketWidth*1/5+rocketWidth;
        xPointsRectangle[3]=screenWidth-rocketWidth/4*3+rocketWidth;

        yPointsRectangle[0]=screenHeight/2-rocketHeight/2;
        yPointsRectangle[1]=screenHeight/2-rocketHeight/2;
        yPointsRectangle[2]=screenHeight/2+rocketHeight/2;
        yPointsRectangle[3]=screenHeight/2+rocketHeight/2;

        xPointsFire[0]=screenWidth-rocketWidth*1/5+rocketWidth;
        xPointsFire[1]=screenWidth-rocketWidth*1/10+rocketWidth;
        xPointsFire[2]=screenWidth-rocketWidth*1/5+rocketWidth;
        xPointsFire[3]=screenWidth+rocketWidth;
        xPointsFire[4]=screenWidth-rocketWidth*1/5+rocketWidth;
        xPointsFire[5]=screenWidth-rocketWidth*1/10+rocketWidth;
        xPointsFire[6]=screenWidth-rocketWidth*1/5+rocketWidth;

        yPointsFire[0]=screenHeight/2-rocketHeight/2;
        yPointsFire[1]=(screenHeight/2-rocketHeight/2+(screenHeight/2-rocketHeight/2+screenHeight/2)/2)/2;
        yPointsFire[2]=(screenHeight/2-rocketHeight/2+screenHeight/2)/2;
        yPointsFire[3]=screenHeight/2;
        yPointsFire[4]=(screenHeight/2+rocketHeight/2+screenHeight/2)/2;
        yPointsFire[5]=(screenHeight/2+rocketHeight/2+(screenHeight/2+rocketHeight/2+screenHeight/2)/2)/2;
        yPointsFire[6]=screenHeight/2+rocketHeight/2;
    }
    
    public void draw(Graphics g){
        g.setColor(Color.RED);
        g.fillPolygon(xPointsTriangular,yPointsTriangular,3);
        g.setColor(Color.WHITE);
        g.fillPolygon(xPointsRectangle,yPointsRectangle,4);
        g.setColor(Color.ORANGE);
        g.fillPolygon(xPointsFire,yPointsFire,7);
    }
}