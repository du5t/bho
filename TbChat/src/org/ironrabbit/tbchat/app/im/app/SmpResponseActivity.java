package org.ironrabbit.tbchat.app.im.app;

import org.ironrabbit.tbchat.IOtrChatSession;
import org.ironrabbit.tbchat.app.im.IChatSession;

import java.util.List;

import org.ironrabbit.tbchat.OtrDebugLogger;
import org.ironrabbit.tbchat.app.im.service.ImServiceConstants;
import org.ironrabbit.tbchat.app.lang.BhoEditText;

import net.java.otr4j.OtrException;
import net.java.otr4j.session.TLV;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.RemoteException;
import android.util.Log;

public class SmpResponseActivity extends Activity {

    private BhoEditText mInputSMP;
    private String mSessionId;
    private String mQuestion;
    private long mProviderId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mInputSMP = new BhoEditText(this);

        mSessionId = getIntent().getStringExtra("sid");
        mProviderId = getIntent().getLongExtra(ImServiceConstants.EXTRA_INTENT_PROVIDER_ID, -1);
        mQuestion = getIntent().getStringExtra("q");
        showQuestionDialog();
    }

    private void showQuestionDialog() {

        new AlertDialog.Builder(this).setTitle("OTR Verification").setMessage(mQuestion)
                .setView(mInputSMP)
                .setPositiveButton("Answer", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {

                        String secret = mInputSMP.getText().toString();
                        respondSmp(mSessionId, secret);

                        SmpResponseActivity.this.finish();
                    }
                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int whichButton) {
                        // Do nothing.
                    }
                }).show();

    }

    private void respondSmp(String sid, String answer) {
        ImApp app = ImApp.getApplication(this);

        IOtrChatSession iOtrSession;
        try {
            IChatSession chatSession = app.getChatSession(mProviderId, sid);
            iOtrSession = chatSession.getOtrChatSession();
            if (iOtrSession == null) {
                OtrDebugLogger.log("no session in progress for provider " + mProviderId);
                return;
            }
            iOtrSession.respondSmpVerification(answer);

        } catch (RemoteException e) {
            OtrDebugLogger.log("could not respond to SMP", e);
        }
    }

}
