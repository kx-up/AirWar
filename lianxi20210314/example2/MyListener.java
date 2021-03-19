package com.lianxi20210314.example2;

import com.lianxi20210314.example2.Obj.Jet;

import java.awt.*;
import java.awt.event.KeyEvent;

public class MyListener extends Listener {

    private Graphics g;
    private Jet j20;

    public  MyListener(Graphics g, Jet j20) {
        this.g = g;
        this.j20 = j20;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println(e.getKeyCode());
        if (e.getKeyCode() == KeyEvent.VK_W) {
            j20.move(Jet.UP);
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            j20.move(Jet.DOWN);
        } else if (e.getKeyCode() == KeyEvent.VK_A) {
            j20.move(Jet.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_D) {
            j20.move(Jet.RIGHT);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
