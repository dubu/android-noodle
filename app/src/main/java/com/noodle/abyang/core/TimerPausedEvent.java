package com.noodle.abyang.core;

public class TimerPausedEvent {

    private boolean timerIsPaused;

    public TimerPausedEvent(boolean timerIsPaused) {
        this.timerIsPaused = timerIsPaused;
    }

    public boolean isTimerIsPaused() {
        return timerIsPaused;
    }
}
