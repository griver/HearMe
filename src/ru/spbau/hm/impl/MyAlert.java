package ru.spbau.hm.impl;

import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 22:30
 * To change this template use File | Settings | File Templates.
 */
public class MyAlert extends TimerTask {
    private int i = 0;
    public MyAlert() {

    }
    @Override
    public void run() {
        ++i;
    }

    public  int getValue()  {
        return i;
    }
}
