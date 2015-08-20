package test.com.activitytransition.intents;

import android.content.Context;
import android.content.Intent;

import test.com.activitytransition.TransitionActivity;

/**
 * Created by laetitia on 8/19/15.
 */
public class TransitionIntent extends Intent {

    public static final String ARG_CHOICE = "ARG_CHOICE";

    public TransitionIntent(Context context, TransitionActivity.Choice choice) {
        super(context, TransitionActivity.class);
        putExtra(ARG_CHOICE, choice);
    }

    public TransitionIntent(Intent o) {
        super(o);
    }

    public TransitionActivity.Choice getChoice(){
        return (TransitionActivity.Choice) getExtras().get(ARG_CHOICE);
    }
}
