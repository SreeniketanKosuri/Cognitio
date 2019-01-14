package k.arez.niki.fbla;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TableLayout;
import android.widget.TextView;

public class QuizActivity extends AppCompatActivity {
    /*Define class variables*/
    private Utility util =  new Utility();
    private TriviaQuestions triviaQuestions = new TriviaQuestions();
    private boolean switchHistory;
    private boolean switchFBLAEvents;
    private boolean switchBusinessSkills;
    private boolean switchNationalSponsors;
    private boolean switchNationalOffice;

    /*When back is pressed*/
    public void returnButton(View view) {
        triviaQuestions.resetQuiz();
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.no_anim, R.anim.slide_down);
    }

    /*When an answer is selected is pressed*/
    public void onAnswerSelect(View view) {
        /*get user's selected answer and the current question*/
        String text = (((Button) view).getText()).toString();
        String question = (((TextView) findViewById(R.id.triviaQuestion)).getText()).toString();
        /*check the answer that the user selected and paint ui for next question*/
        triviaQuestions.checkAnswer(text, question, this);
        triviaQuestions.setUIForQuestion(
                switchHistory,
                switchFBLAEvents,
                switchBusinessSkills,
                switchNationalSponsors,
                switchNationalOffice,
                this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Window window = this.getWindow();
        //Remove notification bar
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);

        switchHistory = getIntent().getBooleanExtra("switchHistory", false);
        switchFBLAEvents = getIntent().getBooleanExtra("switchFBLAEvents", false);
        switchBusinessSkills = getIntent().getBooleanExtra("switchBusinessSkills", false);
        switchNationalSponsors = getIntent().getBooleanExtra("switchNationalSponsors", false);
        switchNationalOffice = getIntent().getBooleanExtra("switchNationalOffice", false);

        TextView triviaOptions = findViewById(R.id.triviaQuestion);
        TableLayout buttonLayout = findViewById(R.id.buttonLayout);

        util.fade("in", triviaOptions, null);
        util.fade("in", buttonLayout, null);

        triviaQuestions.setUIForQuestion(
                switchHistory,
                switchFBLAEvents,
                switchBusinessSkills,
                switchNationalSponsors,
                switchNationalOffice,
                this);
    }

    /*Animation to run if the back arrow is pressed*/
    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.slide_down, R.anim.no_anim);
    }

    /*If the back arrow is pressed, reset the quiz*/
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        triviaQuestions.resetQuiz();
    }
}
