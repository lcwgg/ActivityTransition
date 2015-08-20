package test.com.activitytransition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitytransition.adapters.ImageAndTextAdapter;
import test.com.activitytransition.adapters.SingleImageAdapter;
import test.com.activitytransition.intents.ImageAndTextIntent;
import test.com.activitytransition.intents.SingleImageIntent;
import test.com.activitytransition.intents.TransitionIntent;

public class TransitionActivity extends Activity
        implements SingleImageAdapter.OnItemCLickListener,
        ImageAndTextAdapter.OnItemCLickListener {

    @InjectView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    private Choice mChoice;

    public enum Choice {SINGLE, IMAGEANDTEXT, FRAGMENT}

    ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable the transition (only if theme different from Theme.Material)
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        // possible transitions
//        getWindow().setEnterTransition(new AutoTransition());
//        getWindow().setExitTransition(new AutoTransition());

//        getWindow().setEnterTransition(new Explode());
//        getWindow().setExitTransition(new Explode());

//        Slide slide = new Slide();
//        slide.setSlideEdge(Gravity.LEFT);
//        getWindow().setEnterTransition(slide);
//        getWindow().setExitTransition(slide);

//        getWindow().setEnterTransition(new Fade());
//        getWindow().setExitTransition(new Fade());

        setContentView(R.layout.activity_transition);
        ButterKnife.inject(this);

        ArrayList<Integer> images = new ArrayList<>();
        images.add(R.drawable.chiot1);
        images.add(R.drawable.chiot2);
        images.add(R.drawable.chiot3);
        images.add(R.drawable.chiot4);
        images.add(R.drawable.chiot5);
        images.add(R.drawable.chiot6);
        images.add(R.drawable.chiot7);
        images.add(R.drawable.chiot8);

        final RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this, 2);

        mRecyclerView.setLayoutManager(layoutManager);


        TransitionIntent intent = new TransitionIntent(getIntent());
        mChoice = intent.getChoice();
        switch (mChoice) {
            case SINGLE:
                final SingleImageAdapter singleImageAdapter = new SingleImageAdapter(images);
                mRecyclerView.setAdapter(singleImageAdapter);
                singleImageAdapter.setOnItemClickListener(this);
                break;
            default:
                final ImageAndTextAdapter imageAndTextAdapter = new ImageAndTextAdapter(images);
                mRecyclerView.setAdapter(imageAndTextAdapter);
                imageAndTextAdapter.setOnItemClickListener(this);
                break;
        }

    }

    @Override
    public void onItemClick(View imageView, int imageRefId) {
        SingleImageIntent intent = new SingleImageIntent(this, imageRefId);
        // Activate the transition, nothing will happen without this line
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(intent, options.toBundle());
    }

    @Override
    public void onItemClick(View imageView, View textView, int imageRefId) {
        // Activate the transition, nothing will happen without this line
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        ImageAndTextIntent imageAndTextIntent = new ImageAndTextIntent(this, mChoice, imageRefId, ((TextView) textView).getText().toString());
        startActivity(imageAndTextIntent, options.toBundle());
    }
}
