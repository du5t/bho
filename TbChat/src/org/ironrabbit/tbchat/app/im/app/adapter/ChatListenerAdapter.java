/*
 * Copyright (C) 2007-2008 Esmertec AG. Copyright (C) 2007-2008 The Android Open
 * Source Project
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */

package org.ironrabbit.tbchat.app.im.app.adapter;

import org.ironrabbit.tbchat.app.im.app.ImApp;
import org.ironrabbit.tbchat.app.im.engine.Contact;
import org.ironrabbit.tbchat.app.im.engine.ImErrorInfo;
import org.ironrabbit.tbchat.app.im.engine.Message;

import org.ironrabbit.tbchat.app.im.IChatSession;
import org.ironrabbit.tbchat.app.im.IChatListener;

import android.os.RemoteException;
import android.util.Log;

public class ChatListenerAdapter extends IChatListener.Stub {

    private static final String TAG = ImApp.LOG_TAG;

    public void onContactJoined(IChatSession ses, Contact contact) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "onContactJoined(" + ses + ", " + contact + ")");
        }
    }

    public void onContactLeft(IChatSession ses, Contact contact) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "onContactLeft(" + ses + ", " + contact + ")");
        }
    }

    public void onIncomingMessage(IChatSession ses, Message msg) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "onIncomingMessage(" + ses + ", " + msg + ")");
        }
    }

    public void onSendMessageError(IChatSession ses, Message msg, ImErrorInfo error) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "onSendMessageError(" + ses + ", " + msg + ", " + error + ")");
        }
    }

    public void onInviteError(IChatSession ses, ImErrorInfo error) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "onInviteError(" + ses + ", " + error + ")");
        }
    }

    public void onConvertedToGroupChat(IChatSession ses) {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "onConvertedToGroupChat(" + ses + ")");
        }
    }

    @Override
    public void onIncomingReceipt(IChatSession ses, String packetId) throws RemoteException {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "onIncomingReceipt(" + ses + "," + packetId + ")");
        }
    }

    @Override
    public void onStatusChanged(IChatSession ses) throws RemoteException {
        if (Log.isLoggable(TAG, Log.DEBUG)) {
            Log.d(TAG, "onStatusChanged(" + ses + ")");
        }
    }
}
