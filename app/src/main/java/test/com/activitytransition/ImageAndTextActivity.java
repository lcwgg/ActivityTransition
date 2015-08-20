package test.com.activitytransition;

import android.app.Activity;
import android.os.Bundle;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.view.Gravity;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitytransition.intents.ImageAndTextIntent;
import test.com.activitytransition.intents.SingleImageIntent;

/**
 * Created by laetitia on 4/30/15.
 */
public class ImageAndTextActivity extends Activity {

    @InjectView(R.id.view_imageview)
    ImageView mImageView;

    @InjectView(R.id.view_name)
    TextView mTextView;

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

        ImageAndTextIntent intent = new ImageAndTextIntent(getIntent());

        setContentView(intent.getLayoutId());
        ButterKnife.inject(this);

        mImageView.setImageResource(intent.getImageId());
        mTextView.setText(intent.getName());

        // Unexplicable bug for this example specifically
        // If the textview does not have a transition name
        // the transition won't apply to the fragment content when entering the screen
        // but the exit will done correctly.
        // However the bug happened with devices running on version 5.0.x
        // But it did not happen on 5.1.x devices
        mTextView.setTransitionName(intent.getName());
    }

}
