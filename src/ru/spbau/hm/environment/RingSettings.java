package ru.spbau.hm.environment;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 9:41
 * To change this template use File | Settings | File Templates.
 */
public class RingSettings {
    private boolean myIsVibrationOn;
    private int volume;

    public RingSettings(boolean myIsVibrationOn, int volume) {
        this.myIsVibrationOn = myIsVibrationOn;
        this.volume = volume;
    }

    boolean isVibrationOn() {
        return myIsVibrationOn;
    }

    int getVolume() {
        return volume;
    }
}
