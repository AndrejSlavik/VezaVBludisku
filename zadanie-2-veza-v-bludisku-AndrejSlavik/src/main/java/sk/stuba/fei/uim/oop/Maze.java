package sk.stuba.fei.uim.oop;

import java.util.ArrayList;
import java.util.Stack;
import java.util.Random;
import java.util.Vector;

public class Maze {
    private final int rows = 12;
    private final int cols = 12;
    ArrayList<ArrayList<Cell>> grid;

    public Maze() {
        mazeGenerate();
    }

    public void mazeGenerate() {
        ArrayList<Cell> row;
        grid = new ArrayList<>();
        for (int i = 0; i < rows; i++) {
            row = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                Cell cell = new Cell(i, j);
                row.add(cell);
            }
            grid.add(row);
        }
        deepFirstSearch();
    }

    public void deepFirstSearch() {
        Stack<Cell> stack = new Stack<>();
        Cell current;
        Cell next;
        grid.get(0).get(0).setVisited(true);
        stack.push(grid.get(0).get(0));
        while (!stack.empty()) {
            current = stack.pop();
            next = neighbours(current);
            if (next != null) {
                stack.push(current);
                wallsSet(current, next);
                next.setVisited(true);
                stack.push(next);
            }
        }
    }

    public Cell neighbours(Cell cell) {
        Vector<Cell> v = new Vector<>();
        if (((cell.getI() - 1) < rows) && ((cell.getI() - 1) > -1)) { //LEFT
            if (!grid.get(cell.getI() - 1).get(cell.getJ()).isVisited()) {
                v.add(grid.get(cell.getI() - 1).get(cell.getJ()));
            }
        }
        if (((cell.getI() + 1) < rows) && ((cell.getI() + 1) > -1)) { //RIGHT
            if (!grid.get(cell.getI() + 1).get(cell.getJ()).isVisited()) {
                v.add(grid.get(cell.getI() + 1).get(cell.getJ()));
            }
        }
        if (((cell.getJ() - 1) < rows) && ((cell.getJ() - 1) > -1)) { //TOP
            if (!grid.get(cell.getI()).get(cell.getJ() - 1).isVisited()) {
                v.add(grid.get(cell.getI()).get(cell.getJ() - 1));
            }
        }
        if (((cell.getJ() + 1) < rows) && ((cell.getJ() + 1) > -1)) { //DOWN
            if (!grid.get(cell.getI()).get(cell.getJ() + 1).isVisited()) {
                v.add(grid.get(cell.getI()).get(cell.getJ() + 1));
            }
        }
        if (v.isEmpty()) {
            return null;
        }
        else {
            Random rand = new Random();
            var order = rand.nextInt(v.size());
            return v.get(order);
        }
    }

    public void wallsSet(Cell current, Cell next) {
        if (current.getI() - 1 == next.getI()) {
            current.setLeftWall(false);
            next.setRightWall(false);
        }
        else if (current.getI() + 1 == next.getI()) {
            current.setRightWall(false);
            next.setLeftWall(false);
        }
        else if (current.getJ() - 1 == next.getJ()) {
            current.setTopWall(false);
            next.setDownWall(false);
        }
        else if (current.getJ() + 1 == next.getJ()) {
            current.setDownWall(false);
            next.setTopWall(false);
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
