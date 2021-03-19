package com.lianxi20210314.example2;

import com.lianxi20210314.example2.Obj.Jet;
import com.lianxi20210314.example2.Obj.Obj;
import com.lianxi20210314.example2.Obj.Star;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class MyThread extends Thread{

    Graphics graphics;
    ArrayList<Obj> objects;
    Jet j20;

    public MyThread(Graphics graphics, ArrayList<Obj> objects, Jet j20) {
        this.graphics = graphics;
        this.objects = objects;
        this.j20 = j20;
    }

    @Override
    public void run() {
        Random random = new Random();
        while (true) {
            graphics.setColor(Color.black);
            graphics.fillRect(0, 0, 800, 600);

            int isCreat = random.nextInt(50);
            if (isCreat == 1) {
                objects.add(Star.randomStar());
            }

            int count = objects.size();
            for (int i = 0; i < count; i++) {
                Star star = (Star) objects.get(i);
                if (star.move())
                {
                    objects.remove(star);
                    count--;
                }
                else
                {
                    star.draw(graphics);
                }
            }

            j20.draw(graphics);

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
