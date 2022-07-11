package sk.stuba.fei.uim.oop;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlayerMove implements KeyListener {
    Draw canvas;

    public PlayerMove(Draw canvas) {
        this.canvas = canvas;
    }

    public void keyTyped(KeyEvent e) {
            char key = e.getKeyChar();
            if (key == 'a') { //LEFT
                if (!canvas.maze.grid.get(canvas.getX()).get(canvas.getY()).isLeftWall()) {
                    if (!(canvas.getX() - 1 < 0)) {
                        canvas.setX(canvas.getX() - 1);
                    }
                }
            }
            else if (key == 'd') { //RIGHT
                if (!canvas.maze.grid.get(canvas.getX()).get(canvas.getY()).isRightWall()) {
                    if (!(canvas.getX() + 1 > 12)) {
                        canvas.setX(canvas.getX() + 1);
                    }
                }
            }
            else if (key == 'w') { //TOP
                if (!canvas.maze.grid.get(canvas.getX()).get(canvas.getY()).isTopWall()) {
                    if (!(canvas.getY() - 1 < 0)) {
                        canvas.setY(canvas.getY() - 1);
                    }
                }
            }
            else if (key == 's') { //DOWN
                if (!canvas.maze.grid.get(canvas.getX()).get(canvas.getY()).isDownWall()) {
                    if (!(canvas.getY() + 1 > 12)) {
                        canvas.setY(canvas.getY() + 1);
                    }
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

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
