package hearme.impl;

import hearme.IInvoker;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 * Date: 13.11.12
 * Time: 19:44
 * To change this template use File | Settings | File Templates.
 */
public class SimpleTimer implements IInvoker {
    private Timer myTimer;
    private TimerTask myTask;
    private long myInterval;
    private boolean isRunning;


    public SimpleTimer(TimerTask resolver, long interval) {
        if(resolver == null) throw  new NullPointerException();
        myTask = resolver;
        isRunning = false;
        myInterval = interval;

    }
    @Override
    public void startInBackground() {
        if(isRunning) return;

        isRunning = true;
        myTimer = new Timer(true);
        if(myInterval > 0)
            myTimer.scheduleAtFixedRate(myTask, myInterval, myInterval);

    }

    @Override
    public void stop() {
        if(myTimer != null)
            myTimer.cancel();
        isRunning = false;
    }
}
