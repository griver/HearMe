package ru.spbau.hm.environment;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 */


public class Time implements Comparable<Time> {
    private int myHours;
    private int myMinutes;
    private int mySeconds;

    public Time(int myHours, int myMinutes, int mySeconds) {
        this.myHours = myHours;
        this.myMinutes = myMinutes;
        this.mySeconds = mySeconds;
    }

    public Time(int myHours, int myMinutes) {
        this.myHours = myHours;
        this.myMinutes = myMinutes;
        this.mySeconds = 0;
    }

    public int getHours(){
        return myHours;
    }

    public int getMinutes(){
        return myMinutes;
    }

    public int getSeconds() {
        return mySeconds;
    }

    @Override
    public int compareTo(Time time) {
        int my    = (this.myHours * 10000) + this.myMinutes * 100 + this.getSeconds();
        int other = (time.myHours * 10000) + time.myMinutes * 100 + time.getSeconds();
        return (my - other) / Math.abs(my - other);
    }
}
