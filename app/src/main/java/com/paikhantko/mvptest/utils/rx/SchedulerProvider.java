package com.paikhantko.mvptest.utils.rx;

import io.reactivex.Scheduler;

public interface SchedulerProvider {
    Scheduler computation();
    Scheduler io();
    Scheduler ui();
}
