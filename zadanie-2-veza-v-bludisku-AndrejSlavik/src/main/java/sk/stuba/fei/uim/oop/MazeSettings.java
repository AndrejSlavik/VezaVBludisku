package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class MazeSettings extends JPanel {
    public Maze maze = new Maze();

    private final int width = 800, height = 700;
    private int gamecounter = 0;
    private final int lineStroke = 3;
    private final int offset = height - 100;
    private final int sizeOfCell = 50;
    private final int margin = 30;

    public void newGame(){
        Maze newM = new Maze();
        this.gamecounter++;
        maze = newM;
    }

    public void gridPaint(Graphics2D g2) {
        g2.setStroke(new BasicStroke(lineStroke));
        g2.setPaint(Color.red);
        g2.fillRect(margin + lineStroke, margin + lineStroke, sizeOfCell - lineStroke*2, sizeOfCell - lineStroke*2);
        g2.setPaint(Color.black);

        for (int x = 0; x < maze.getRows(); x++) {
            for (int y = 0; y < maze.getCols(); y++) {
                if (maze.grid.get(x).get(y).isRightWall()) {
                    g2.drawLine(x * sizeOfCell + sizeOfCell + margin, y * sizeOfCell + margin, x * sizeOfCell + sizeOfCell + margin, y * sizeOfCell + sizeOfCell + margin);
                }
                if (maze.grid.get(x).get(y).isDownWall()) {
                    g2.drawLine(x * sizeOfCell + margin, y * sizeOfCell + sizeOfCell + margin, x * sizeOfCell + sizeOfCell + margin, y * sizeOfCell + sizeOfCell + margin);
                }
                if (maze.grid.get(x).get(y).isTopWall()) {
                    g2.drawLine(x * sizeOfCell + margin, y * sizeOfCell + margin, x * sizeOfCell + sizeOfCell + margin, y * sizeOfCell + margin);
                }
                if (maze.grid.get(x).get(y).isLeftWall()) {
                    g2.drawLine(x * sizeOfCell + margin, y * sizeOfCell + margin, x * sizeOfCell + margin, y * sizeOfCell + sizeOfCell + margin);
                }
            }
        }
        g2.setPaint(Color.green);
        g2.fillRect(11*sizeOfCell + margin + lineStroke, 11*sizeOfCell + margin + lineStroke, sizeOfCell - lineStroke*2, sizeOfCell - lineStroke*2);
        g2.setPaint(Color.black);
        String s = "GAMES WON: " + this.gamecounter;
        String last = ":LAST BUTTON USED";
        g2.drawString(last, 75, 20);
        g2.drawString(s, 300, 20);
    }

    @Override
    public int getWidth() {
        return width;
    }

    @Override
    public int getHeight() {
        return height;
    }

    public int getLineStroke() {
        return lineStroke;
    }

    public int getOffset() {
        return offset;
    }

    public int getSizeOfCell() {
        return sizeOfCell;
    }

    public int getMargin() {
        return margin;
    }
}
