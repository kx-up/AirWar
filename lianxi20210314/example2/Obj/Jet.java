package com.lianxi20210314.example2.Obj;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Jet {

    public static final String UP = "up";
    public static final String DOWN = "down";
    public static final String LEFT = "left";
    public static final String RIGHT = "right";

    private int x;
    private int y;
    private final Image image;

    Map<String, Image> j20Form = new HashMap<>();

    private static final int step = 10;

    public Jet() throws IOException {

        this.x = 400; this.y = 400;

        image = ImageIO.read(new File("img/jet/j20x80.png"));

        Image imgJ20 = ImageIO.read(new File("img/jet/j20x150.png"));
        Image imgJ20left = ImageIO.read(new File("img/jet/j20x150left.png"));
        Image imgJ20right = ImageIO.read(new File("img/jet/j20x150right.png"));

        j20Form.put("down", imgJ20);
        j20Form.put("left", imgJ20left);
        j20Form.put("right", imgJ20right);
    }

    public void move(String direction) {
        switch (direction) {
            case UP:
                y -= step;
                break;
            case DOWN:
                y += step;
                break;
            case LEFT:
                x -= step;
                break;
            case RIGHT:
                x += step;
                break;
        }
    }

    public void draw(Graphics graphics) {
        graphics.drawImage(image, x - 40, y - 40, null);
    }

    public void setForm() {

    }
}
