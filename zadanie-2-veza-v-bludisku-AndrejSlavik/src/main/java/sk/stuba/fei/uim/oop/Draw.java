package sk.stuba.fei.uim.oop;

import java.awt.*;

public class Draw extends MazeSettings {
    Player player = new Player();
    private int x;
    private int y;

    public void paint(Graphics g){
        Graphics2D g2 = (Graphics2D) g;
        this.gridPaint(g2);
        player.playerFigure(g2, x, y);
    }

    @Override
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    @Override
    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
}
