package com.example.app.services;

import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.widget.Toast;

/**
 * Created by dkocian on 11/16/13.
 */
public class MessengerService extends Service {
    private static final String HELLO = "hello!";
    private static final String BINDING = "binding";
    // Command to the service to display a message
    public static final int MSG_SAY_HELLO = 1;
    // Target we publish for clients to send messages to IncomingHandler.
    final Messenger mMessenger = new Messenger(new IncomingHandler());

    /**
     * When binding to the service, we return an interface to our messenger
     * for sending messages to the service.
     */
    @Override
    public IBinder onBind(Intent intent) {
        Toast.makeText(MessengerService.this, BINDING, Toast.LENGTH_SHORT).show();
        return mMessenger.getBinder();
    }

    // Handler of incoming messages from clients.
    class IncomingHandler extends Handler {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case MSG_SAY_HELLO:
                    Toast.makeText(MessengerService.this, HELLO, Toast.LENGTH_SHORT).show();
                    break;
                default:
                    super.handleMessage(msg);
            }
        }
    }
}
