package com.lianxi20210314.example2;

import com.lianxi20210314.example2.Obj.Jet;
import com.lianxi20210314.example2.Obj.Obj;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class AirWar extends JFrame {

    public ArrayList<Obj> objects = new ArrayList<>();

    public Jet j20;

    public AirWar() throws IOException {
        this.setTitle("空战");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.black);

        j20 = new Jet();

        this.setVisible(true);
    }

    public static void main(String[] args) throws IOException {
        AirWar airWar = new AirWar();
        MyListener listener = new MyListener(airWar.getGraphics(), airWar.j20);
        airWar.addKeyListener(listener);

        MyThread myThread = new MyThread(airWar.getGraphics(), airWar.objects, airWar.j20);
        myThread.start();
    }
}
