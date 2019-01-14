package k.arez.niki.fbla;

/*Android Imports*/
import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.os.CountDownTimer;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

/*Library Imports*/
import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieOnCompositionLoadedListener;

import k.arez.niki.fbla.ViewPagerClasses.CustomViewPager;
import k.arez.niki.fbla.ViewPagerClasses.ViewPageAdapter;

public class MainActivity extends AppCompatActivity {
    /*Define class variables*/
    private RelativeLayout loadWrap;
    private ImageView logoView;
    private LottieAnimationView animationView;
    private CustomViewPager viewPager;
    private TriviaQuestions triviaQuestions = new TriviaQuestions();

    private Utility util = new Utility();
    private Context mainContext = this;

    /*Fragment Functions*/
    /*Function that runs on the start quiz button*/
    public void triviaStartButton(View view) {
        /*Collect switch data*/
        if (!((Switch) findViewById(R.id.switchHistory)).isChecked()
                && !((Switch) findViewById(R.id.switchFBLAEvents)).isChecked()
                && !((Switch) findViewById(R.id.switchBusinessSkills)).isChecked()
                && !((Switch) findViewById(R.id.switchNationalSponsors)).isChecked()
                && !((Switch) findViewById(R.id.switchNationalOffice)).isChecked()
            ) {
            TextView error = findViewById(R.id.errorMessage);
            util.fade("in", error, null);
        } else {
            /*Fade out error if it is visible*/
            TextView error = findViewById(R.id.errorMessage);
            util.fade("out", error, null);
            /*Animate in activity*/
            Intent intent = new Intent(this, QuizActivity.class);
            /*send switch boolean values to new activity (the quiz page)*/
            intent.putExtra("switchHistory", ((Switch) findViewById(R.id.switchHistory)).isChecked());
            intent.putExtra("switchFBLAEvents", ((Switch) findViewById(R.id.switchFBLAEvents)).isChecked());
            intent.putExtra("switchBusinessSkills", ((Switch) findViewById(R.id.switchBusinessSkills)).isChecked());
            intent.putExtra("switchNationalSponsors", ((Switch) findViewById(R.id.switchNationalSponsors)).isChecked());
            intent.putExtra("switchNationalOffice", ((Switch) findViewById(R.id.switchNationalOffice)).isChecked());
            startActivity(intent);
            overridePendingTransition(R.anim.slide_up, R.anim.no_anim);
        }
    }

    /*Functions to run when the viewpager loads the fragment*/
    private void onMainLoad() {}
    private void onTriviaLoad() {
        RelativeLayout triviaOptions = findViewById(R.id.triviaOptions);
        if (triviaOptions != null) {
            util.fade("in", triviaOptions, null);
        }
    }
    private void onAttributionLoad() {}

    /*Activity Functions*/
    @Override protected void onStart() { super.onStart(); }

    @Override protected void onCreate(Bundle savedInstanceState) {
        /*
        * Things to do:
            * Create pages that can be swiped in each direction
        * */
        super.onCreate(savedInstanceState);

        Window window = this.getWindow();
        //Remove notification bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        //Initialize Views
        loadWrap = findViewById(R.id.loadWrap);
        logoView = findViewById(R.id.logoView);
        animationView = findViewById(R.id.animView);
        viewPager = findViewById(R.id.viewPager);

        //Set up viewpager
        viewPager.setAdapter(new ViewPageAdapter(getSupportFragmentManager()));
        /*Set viewpager to the "main" page (the main fragment)*/
        viewPager.setCurrentItem(1);
        viewPager.setPagingEnabled(true);
        /*Append viewpager load functions to the viewpager*/
        viewPager.addOnPageChangeListener(new ViewPager.SimpleOnPageChangeListener() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                switch (position) {
                    case 0:
                        onAttributionLoad();
                    case 1:
                        onMainLoad();
                    case 2:
                        onTriviaLoad();
                }
            }
        });

        /*Start loading process*/
        util.fade("in", logoView, null);

        /*Set listener for loader animation, and fade in loader when it is ready*/
        animationView.addLottieOnCompositionLoadedListener(new LottieOnCompositionLoadedListener() {
            @Override public void onCompositionLoaded(LottieComposition composition) {
                util.fade("in", animationView, null);
                /*Timer to load in items*/
                CountDownTimer timer = new CountDownTimer(3000, 1000) {
                    @Override
                    public void onTick(long millisUntilFinished) {}
                    @Override
                    public void onFinish() {
                        //Fade out loading screen elements
                        util.fade("out", logoView, null);
                        util.fade("out", animationView, new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animation) {}
                            @Override
                            public void onAnimationEnd(Animator animation) {
                                util.destroy(logoView);
                                util.destroy(animationView);
                            }
                            @Override
                            public void onAnimationCancel(Animator animation) {}
                            @Override
                            public void onAnimationRepeat(Animator animation) {}
                        });

                        //Animate viewPager in
                        util.fade("in", viewPager, null);
                    }
                };
                timer.start();
            }
        });
    }
}
