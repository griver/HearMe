package hearme.environment;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 9:41
 * To change this template use File | Settings | File Templates.
 */
public class CallSettings {
    private boolean myIsVibrationOn;
    private int volume;

    public CallSettings(boolean myIsVibrationOn, int volume) {
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
