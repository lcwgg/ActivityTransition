package test.com.activitytransition;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;
import test.com.activitytransition.intents.TransitionIntent;

/**
 * Created by laetitia on 8/19/15.
 */
public class HomeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.inject(this);
    }

    @OnClick(R.id.single_image)
    public void onSingleImageClick(){
        TransitionIntent intent = new TransitionIntent(this, TransitionActivity.Choice.SINGLE);
        startActivity(intent);
    }

    @OnClick(R.id.image_and_text)
    public void onImageAndTextClick(){
        TransitionIntent intent = new TransitionIntent(this, TransitionActivity.Choice.IMAGEANDTEXT);
        startActivity(intent);
    }

    @OnClick(R.id.fragment)
    public void onFargmentClick(){
        TransitionIntent intent = new TransitionIntent(this, TransitionActivity.Choice.FRAGMENT);
        startActivity(intent);
    }
}
