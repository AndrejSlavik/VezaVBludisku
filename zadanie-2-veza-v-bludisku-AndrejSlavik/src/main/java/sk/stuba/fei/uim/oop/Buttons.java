package sk.stuba.fei.uim.oop;

import javax.swing.*;

public class Buttons extends JPanel {
    String Restart = "Restart";
    String Up = "UP", Down = "DOWN", Left = "LEFT", Right = "RIGHT";

    public JPanel Buttons(Draw canvas){
        Right rightButton = new Right(canvas, Right);
        Left leftButton = new Left(canvas, Left);
        Down downButton = new Down(canvas, Down);
        Up upButton = new Up(canvas, Up);

        GroupLayout layout = new GroupLayout(this);
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);
        this.setLayout(layout);

        layout.setHorizontalGroup(layout.createSequentialGroup().addComponent(leftButton).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(upButton).addComponent(downButton))).addComponent(rightButton));
        layout.setVerticalGroup(layout.createSequentialGroup().addComponent(upButton).addGroup(layout.createSequentialGroup().addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(leftButton).addComponent(downButton).addComponent(rightButton))));

        return this;
    }
}
