package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.Draw;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Right extends JButton implements ActionListener {
    Draw canvas;

    public Right(Draw canvas, String Right){
        super(Right);
        this.setFocusable(false);
        this.canvas = canvas;
        this.addActionListener(this);
    }

    public void actionPerformed(ActionEvent e) {
        if (!canvas.maze.grid.get(canvas.getX()).get(canvas.getY()).isRightWall()) {
            if (!(canvas.getX() + 1 > 12)) {
                canvas.setX(canvas.getX() + 1);
            }
        }
        if (canvas.getX() == 11 && canvas.getY() == 11) {
            canvas.setX(0);
            canvas.setY(0);
            canvas.maze.grid.clear();
            canvas.newGame();
            canvas.repaint();
        }
        canvas.repaint();
    }
}
