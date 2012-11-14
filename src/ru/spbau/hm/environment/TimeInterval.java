package ru.spbau.hm.environment;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 9:23
 * To change this template use File | Settings | File Templates.
 */
public class TimeInterval {
    private Time myBegin;
    private Time myEnd;

    public TimeInterval(Time myBegin, Time myEnd) {
        if(myBegin.compareTo(myEnd) >= 0 ) throw new TimeIntervalException();
        this.myBegin = myBegin;
        this.myEnd = myEnd;

    }

    public Time getBegin() {
        return myBegin;
    }
    public Time getEnd() {
        return myEnd;
    }

    boolean isInclude(Time time) {
        return (time.compareTo(myBegin) >= 0) && (time.compareTo(myEnd)< 0);
    }

    boolean isInclude(TimeInterval timeInterval) {
        return isInclude(timeInterval.getBegin()) && isInclude(timeInterval.getEnd());
    }

}
