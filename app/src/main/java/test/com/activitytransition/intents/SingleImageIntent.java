package test.com.activitytransition.intents;

import android.content.Context;
import android.content.Intent;

import test.com.activitytransition.SingleImageActivity;

/**
 * Created by laetitia on 4/30/15.
 */
public class SingleImageIntent extends Intent {

    public static final String ARG_IMAGE_ID = "ARG_IMAGE_ID";

    public SingleImageIntent(Intent o) {
        super(o);
    }

    public SingleImageIntent(Context packageContext, int imageId) {
        super(packageContext, SingleImageActivity.class);
        putExtra(ARG_IMAGE_ID, imageId);
    }

    public int getImageId() {
        return getIntExtra(ARG_IMAGE_ID, -1);
    }

}
