package test.com.activitytransition.intents;

import android.content.Context;
import android.content.Intent;

import test.com.activitytransition.ImageAndTextActivity;
import test.com.activitytransition.R;
import test.com.activitytransition.SingleImageActivity;
import test.com.activitytransition.TransitionActivity;

/**
 * Created by laetitia on 4/30/15.
 */
public class ImageAndTextIntent extends Intent {

    public static final String ARG_IMAGE_ID = "ARG_IMAGE_ID";
    public static final String ARG_NAME = "ARG_NAME";
    public static final String ARG_LAYOUT_ID = "ARG_LAYOUT_ID";

    public ImageAndTextIntent(Intent o) {
        super(o);
    }

    public ImageAndTextIntent(Context packageContext, TransitionActivity.Choice choice, int imageId, String name) {
        super(packageContext, ImageAndTextActivity.class);
        putExtra(ARG_IMAGE_ID, imageId);
        putExtra(ARG_NAME, name);
        if (choice == TransitionActivity.Choice.FRAGMENT) {
            putExtra(ARG_LAYOUT_ID, R.layout.activity_fragment);
        } else {
            putExtra(ARG_LAYOUT_ID, R.layout.activity_image_and_text);
        }
    }

    public int getImageId() {
        return getIntExtra(ARG_IMAGE_ID, -1);
    }

    public String getName() {
        return getStringExtra(ARG_NAME);
    }

    public int getLayoutId() {
        return getIntExtra(ARG_LAYOUT_ID, R.layout.activity_image_and_text);
    }
}
