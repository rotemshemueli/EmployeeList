package com.rosol.employeelist.sync;

import android.app.IntentService;
import android.content.Intent;

import androidx.annotation.Nullable;

public class BirthdayIntentService extends IntentService {
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * Used to name the worker thread, important only for debugging.
     */
    public BirthdayIntentService() {
        super("BirthdayReminderIntentService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        String action=intent.getAction();


    }
}
