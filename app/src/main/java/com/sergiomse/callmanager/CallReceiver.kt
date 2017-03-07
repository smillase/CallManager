package com.sergiomse.callmanager

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.telephony.TelephonyManager
import android.util.Log

class CallReceiver : BroadcastReceiver() {

    private val TAG = CallReceiver::class.simpleName

    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "incoming call: " + intent.action)
        if (intent.action == TelephonyManager.ACTION_PHONE_STATE_CHANGED) {
            val state = intent.getStringExtra(TelephonyManager.EXTRA_STATE)
            val number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER)
            Log.d(TAG, "state: $state, number: $number")

//            if (state == TelephonyManager.EXTRA_STATE_RINGING)
        }
    }
}