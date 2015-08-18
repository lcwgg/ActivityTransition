package test.com.activitytransition;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitytransition.intents.SingleImageIntent;

/**
 * Created by laetitia on 4/30/15.
 */
public class SingleImageActivity extends Activity {

    @InjectView(R.id.view_dog_imageview)
    ImageView mImageView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable the transitions
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        setContentView(R.layout.activity_single_image);
        ButterKnife.inject(this);

        SingleImageIntent intent = new SingleImageIntent(getIntent());
        mImageView.setImageResource(intent.getImageId());


    }

}
