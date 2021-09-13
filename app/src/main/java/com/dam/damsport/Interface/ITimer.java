package com.dam.damsport.Interface;

import android.widget.TextView;

public interface ITimer {
    public void start();
    public void pause();
    public void stop();
    public void setTextChronoFrag(TextView tv);
}
