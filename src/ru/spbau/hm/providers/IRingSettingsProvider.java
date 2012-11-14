package ru.spbau.hm.providers;

import ru.spbau.hm.environment.RingSettings;

/**
 * Created with IntelliJ IDEA.
 * User: griver
 */
public interface IRingSettingsProvider {

    void setNew(RingSettings settings);

    void setDefault();

    RingSettings getCurrent();

    RingSettings getDefault();
}
