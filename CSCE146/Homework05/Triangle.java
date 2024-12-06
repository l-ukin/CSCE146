/*
* Written by Lukin Uhte, with help from lecture
*/

import java.awt.*;
import javax.swing.*;
public class Triangle extends Canvas
{
    public static void main(String[] args)
    {
        JFrame frame = new JFrame("Sierpinski's Triangle");
        frame.setSize(900, 900);
        Triangle sp = new Triangle();
        frame.add(sp);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void paint(Graphics g)
    {
        int[] x = {0, this.getSize().height/2, this.getSize().height}; //3 points, left to right
        int[] y = {this.getSize().height, 0, this.getSize().height}; //3 points, left to right
        drawTriangle(x, y, g, Color.black, this.getSize().height);
    }

    public void drawTriangle(int[] x, int[] y, Graphics g, Color color, int size)
    {
        g.setColor(color);
        g.drawPolygon(x, y, 3);
        g.fillPolygon(x, y, 3);
        int[] x2 = new int[3];
        int[] y2 = new int[3];
        int[] x3 = new int[3];
        int[] y3 = new int[3];
        int[] x4 = new int[3];
        int[] y4 = new int[3];
        if(color.equals(Color.black))
        {
            x2[0] = (x[0] + x[1]) / 2; //Midpoint of x[0] and x[1]
            x2[1] = x[1];
            x2[2] = (x[1] + x[2]) / 2; //Midpoint of x[1] and x[2]

            y2[0] = (y[0] + y[1]) / 2; //Midpoint of y[0] and y[1]
            y2[1] = y[0];
            y2[2] = (y[0] + y[1]) / 2; //Midpoint of y[0] and y[1]
            if(size >= 4)
            {
                drawTriangle(x2, y2, g, Color.white, size); //This does not decrease size because only the black triangles decrease size, otherwise we would have half as many white triangles
            }
        }else{
            //Draw left black triangle (not really necessary to draw it, but gets the coordinates right for white triangles)
            x2[0] = x[1] - ((x[1]-x[0]) * 2);
            x2[1] = x[0];
            x2[2] = x[1];

            y2[0] = y[1];
            y2[1] = y[0];
            y2[2] = y[1];

           //Draw right black triangle (not really necessary to draw it, but gets the coordinates right for white triangles)
            x3[0] = x[1];
            x3[1] = x[2];
            x3[2] = ((x[2]-x[1]) * 2) + x[1];

            y3[0] = y[1];
            y3[1] = y[0];
            y3[2] = y[1];

            //Draw top black triangle (not really necessary to draw it, but gets the coordinates right for white triangles)
            x4[0] = x[0];
            x4[1] = x[1];
            x4[2] = x[2];

            y4[0] = y[0];
            y4[1] = y[1] - ((y[1]-y[0]) * 2);
            y4[2] = y[2];

            if(size >= 4)
            {
                drawTriangle(x2, y2, g, Color.black, size/2);
                drawTriangle(x3, y3, g, Color.black, size/2);
                drawTriangle(x4, y4, g, Color.black, size/2);
            }
        }
    }
}