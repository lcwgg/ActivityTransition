package test.com.activitytransition;

import android.app.Activity;
import android.app.ActivityOptions;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.InjectView;
import test.com.activitytransition.adapters.SingleImageAdapter;
import test.com.activitytransition.intents.SingleImageIntent;

public class TransitionActivity extends Activity implements SingleImageAdapter.OnItemCLickListener {

    @InjectView(R.id.recyclerview)
    RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // enable the transition
//        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);

        // possible transitions
//        getWindow().setEnterTransition(new AutoTransition());
//        getWindow().setExitTransition(new AutoTransition());

//        getWindow().setEnterTransition(new Explode());
//        getWindow().setExitTransition(new Explode());

//        Slide slide = new Slide();
//        slide.setSlideEdge(Gravity.RIGHT);
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
        final SingleImageAdapter adapter = new SingleImageAdapter(images);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener(this);

    }

    @Override
    public void onItemClick(View imageView, int imageRefId) {
        SingleImageIntent intent = new SingleImageIntent(this, imageRefId);
        // Activate the transition, nothing will happen without this line
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(this);
        startActivity(intent, options.toBundle());

    }
}
