package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Player extends MazeSettings{

    public void playerFigure(Graphics2D g2, int x, int y) {
        g2.setColor(Color.blue);
        g2.fillOval(x*getSizeOfCell() + getMargin() + getLineStroke()*4, y*getSizeOfCell() + getMargin() + getLineStroke()*4, getSizeOfCell()/2, getSizeOfCell()/2);
    }
}
