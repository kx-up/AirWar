package com.lianxi20210314.example2.Obj;

import java.awt.*;
import java.util.Random;

public class Star implements Obj{

    private int x;
    private int y;

    private int[] xs;
    private int[] ys;

    private Color color;

    private static final Color[] colors = {new Color(120,120,120), new Color(90, 90, 90), new Color(60, 60, 60)};

    public Star() {

    }

    public static Star randomStar() {

        int WIDTH = 6;
        int HEIGHT = 14;

        Star star = new Star();

        Random random = new Random();
        star.x = random.nextInt(700) + 50;
        star.y = 0;

        int h = random.nextInt(2) + WIDTH;
        int v = random.nextInt(2) + HEIGHT;

        final int INNER_W = 2;

        int[] xs = {star.x, star.x -INNER_W, star.x - h, star.x -INNER_W, star.x, star.x +INNER_W, star.x + h, star.x +INNER_W};
        int[] ys = {0, star.y - v + INNER_W, star.y - v, star.y - v - INNER_W, star.y - 2 * v, star.y - v - INNER_W, star.y - v, star.y - v +INNER_W};
        star.xs = xs;
        star.ys = ys;

        int colorIndex = random.nextInt(3);

        star.color = colors[colorIndex];

        return star;
    }

    /**
     * 返回true即代表超出边界，可删除该星星
     * @return
     */
    public boolean move() {
        if(ys[0] + step > 600 + 14) return true;
        for (int i = 0; i < ys.length; i++) {
            ys[i] += step;
        }
        return false;
    }

    public void draw(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillPolygon(xs, ys, xs.length);
    }
}
