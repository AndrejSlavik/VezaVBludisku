package sk.stuba.fei.uim.oop;

import javax.swing.*;
import java.awt.*;

public class GameSettings extends JFrame {

    Draw draw = new Draw();
    Buttons but = new Buttons();

    public void GameSettings() {
        this.setTitle("Maze");

        this.setSize(1400, 800);
        this.setResizable(false);

        this.setLayout(new GridLayout());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.add(draw);
        this.add(but.Buttons(draw));

        PlayerMove playerMove = new PlayerMove(draw);
        this.addKeyListener(playerMove);

        this.setFocusable(true);
        this.setVisible(true);
    }
}
