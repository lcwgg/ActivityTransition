package test.com.activitytransition;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitytransition.intents.SingleImageIntent;

/**
 * Created by laetitia on 4/30/15.
 */
public class SingleImageActivity extends Activity {

    @InjectView(R.id.view_imageview)
    ImageView mImageView;



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable the transition (only if theme different from Theme.Material)
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        // possible transitions
//        getWindow().setEnterTransition(new Explode());
//        getWindow().setExitTransition(new Explode());

//        Slide slide = new Slide();
//        slide.setSlideEdge(Gravity.RIGHT);
//        getWindow().setEnterTransition(slide);
//        getWindow().setExitTransition(slide);

//        getWindow().setEnterTransition(new Fade());
//        getWindow().setExitTransition(new Fade());
        setContentView(R.layout.activity_single_image);
        ButterKnife.inject(this);

        SingleImageIntent intent = new SingleImageIntent(getIntent());
        mImageView.setImageResource(intent.getImageId());

    }

}
