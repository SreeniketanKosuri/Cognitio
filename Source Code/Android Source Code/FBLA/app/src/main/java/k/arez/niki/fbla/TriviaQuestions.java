package k.arez.niki.fbla;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;
import com.airbnb.lottie.LottieComposition;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class TriviaQuestions {
    private List<Map<String,String>> Questions = new ArrayList<>();
    private int[] selectedQuestions = new int[35];
    private int currentQuestion = 0;
    private int currentScore = 0;
    private Utility util = new Utility();

    TriviaQuestions() {
        for (int i = 0; i < 35; i++) {
            Questions.add(new HashMap<String, String>());
        }
        for (int i = 0; i < 35; i++) {
            selectedQuestions[i] = 0;
        }
        /*Initialize question bank*/
        Questions.get(0).put("Question", "What does FBLA stand for?");
        Questions.get(0).put("choiceA", "Future Business Leaders of America");
        Questions.get(0).put("choiceB", "Formidable Business Learners of America");
        Questions.get(0).put("choiceC", "Future Business Learners of America");
        Questions.get(0).put("correctChoice", "Future Business Leaders of America");
        Questions.get(0).put("Category", "History");

        Questions.get(1).put("Question", "What does FBLA’s college division (PBL) stand for?");
        Questions.get(1).put("choiceA", "Professional Business Leaders");
        Questions.get(1).put("choiceB", "Phi Beta Lambda");
        Questions.get(1).put("choiceC", "Profound Brilliant Learners");
        Questions.get(1).put("correctChoice", "Phi Beta Lambda");
        Questions.get(1).put("Category", "History");

        Questions.get(2).put("Question", "Who was the founder of the FBLA program?");
        Questions.get(2).put("choiceA", "Edward D. Miller");
        Questions.get(2).put("choiceB", "Hamden L. Forkner");
        Questions.get(2).put("choiceC", "Conrad N. Hilton");
        Questions.get(2).put("correctChoice", "Hamden L. Forkner");
        Questions.get(2).put("Category", "History");

        Questions.get(3).put("Question", "Where was the first FBLA high school chapter chartered?");
        Questions.get(3).put("choiceA", "Colorado");
        Questions.get(3).put("choiceB", "Tennessee");
        Questions.get(3).put("choiceC", "Massachusetts");
        Questions.get(3).put("correctChoice", "Tennessee");
        Questions.get(3).put("Category", "History");

        Questions.get(4).put("Question", "In which state was the first FBLA state chapter located?");
        Questions.get(4).put("choiceA", "Nebraska");
        Questions.get(4).put("choiceB", "Washington");
        Questions.get(4).put("choiceC", "Iowa");
        Questions.get(4).put("correctChoice", "Iowa");
        Questions.get(4).put("Category", "History");

        Questions.get(5).put("Question", "Who was the first full-time executive director of FBLA?");
        Questions.get(5).put("choiceA", "Edward D. Miller");
        Questions.get(5).put("choiceB", "Jean J. Buckley");
        Questions.get(5).put("choiceC", "Elena M. Daly");
        Questions.get(5).put("correctChoice", "Edward D. Miller");
        Questions.get(5).put("Category", "History");

        Questions.get(6).put("Question", "In what year was the grand opening of the FBLA-PBL National Center?");
        Questions.get(6).put("choiceA", "1987");
        Questions.get(6).put("choiceB", "1992");
        Questions.get(6).put("choiceC", "1991");
        Questions.get(6).put("correctChoice", "1991");
        Questions.get(6).put("Category", "History");

        Questions.get(7).put("Question", "What type of event is “Introduction to Financial Math”?");
        Questions.get(7).put("choiceA", "Objective Test");
        Questions.get(7).put("choiceB", "Prejudged Project & Presentation");
        Questions.get(7).put("choiceC", "Prejudged Report");
        Questions.get(7).put("correctChoice", "Objective Test");
        Questions.get(7).put("Category", "FBLA Events");

        Questions.get(8).put("Question", "Which of the following is NOT a Prejudged Project & Presentation event?");
        Questions.get(8).put("choiceA", "Computer Game & Simulation Programming");
        Questions.get(8).put("choiceB", "Database Design & Applications");
        Questions.get(8).put("choiceC", "E-business");
        Questions.get(8).put("correctChoice", "Database Design & Applications");
        Questions.get(8).put("Category", "FBLA Events");

        Questions.get(9).put("Question", "What are events specifically for grades 9 — 10 called?");
        Questions.get(9).put("choiceA", "Introduction Events");
        Questions.get(9).put("choiceB", "Preliminary Events");
        Questions.get(9).put("choiceC", "Fundamental Events");
        Questions.get(9).put("correctChoice", "Introduction Events");
        Questions.get(9).put("Category", "FBLA Events");

        Questions.get(10).put("Question", "Fill in the blank: Competitors can choose to compete ____");
        Questions.get(10).put("choiceA", "Individually or with a team");
        Questions.get(10).put("choiceB", "With a team or chapter team");
        Questions.get(10).put("choiceC", "Individually, with a team, or with a chapter team");
        Questions.get(10).put("correctChoice", "Individually, with a team, or with a chapter team");
        Questions.get(10).put("Category", "FBLA Events");

        Questions.get(11).put("Question", "Which of the following is an FBLA Chapter event?");
        Questions.get(11).put("choiceA", "Community Service Project");
        Questions.get(11).put("choiceB", "Business Financial Plan");
        Questions.get(11).put("choiceC", "Client Service");
        Questions.get(11).put("correctChoice", "Community Service Project");
        Questions.get(11).put("Category", "FBLA Events");

        Questions.get(12).put("Question", "How many “Speech” events are available in FBLA?");
        Questions.get(12).put("choiceA", "1");
        Questions.get(12).put("choiceB", "5");
        Questions.get(12).put("choiceC", "3");
        Questions.get(12).put("correctChoice", "3");
        Questions.get(12).put("Category", "FBLA Events");

        Questions.get(13).put("Question", "Which of the following is the ONLY Prejudged Report event?");
        Questions.get(13).put("choiceA", "Business Plan");
        Questions.get(13).put("choiceB", "Local Chapter Annual Business Report");
        Questions.get(13).put("choiceC", "American Enterprise Project");
        Questions.get(13).put("correctChoice", "Local Chapter Annual Business Report");
        Questions.get(13).put("Category", "FBLA Events");

        Questions.get(14).put("Question", "What is appropriate FBLA business attire?");
        Questions.get(14).put("choiceA", "Business Formal");
        Questions.get(14).put("choiceB", "Business Casual");
        Questions.get(14).put("choiceC", "Formal");
        Questions.get(14).put("correctChoice", "Business Formal");
        Questions.get(14).put("Category", "Code of Conduct");

        Questions.get(15).put("Question", "Which of these shoes are appropriate for an FBLA Event?");
        Questions.get(15).put("choiceA", "Canvas and fabric shoes");
        Questions.get(15).put("choiceB", "Dress shoes/boots");
        Questions.get(15).put("choiceC", "Hiking Boots");
        Questions.get(15).put("correctChoice", "Dress shoes/boots");
        Questions.get(15).put("Category", "Code of Conduct");

        Questions.get(16).put("Question", "Which of the following items are unacceptable at an FBLA event?");
        Questions.get(16).put("choiceA", "Business Dress");
        Questions.get(16).put("choiceB", "Collared Dress Shirt and a Tie");
        Questions.get(16).put("choiceC", "Shorts");
        Questions.get(16).put("correctChoice", "Shorts");
        Questions.get(16).put("Category", "Code of Conduct");

        Questions.get(17).put("Question", "What must be worn at all conference functions?");
        Questions.get(17).put("choiceA", "Flip Flops");
        Questions.get(17).put("choiceB", "Name Badges");
        Questions.get(17).put("choiceC", "Hats");
        Questions.get(17).put("correctChoice", "Name Badges");
        Questions.get(17).put("Category", "Code of Conduct");

        Questions.get(18).put("Question", "As written in the FBLA Code of Ethics, an FBLA member shall “dress and act in a manner that will bring respect to me and to my ____”");
        Questions.get(18).put("choiceA", "School");
        Questions.get(18).put("choiceB", "Chapter");
        Questions.get(18).put("choiceC", "Classmates");
        Questions.get(18).put("correctChoice", "School");
        Questions.get(18).put("Category", "Code of Conduct");

        Questions.get(19).put("Question", "What is the first line in the FBLA Code of Ethics?");
        Questions.get(19).put("choiceA", "Willingly accept responsibilities and duties ");
        Questions.get(19).put("choiceB", "Be honest and sincere");
        Questions.get(19).put("choiceC", "Always be punctual");
        Questions.get(19).put("correctChoice", "Be honest and sincere");
        Questions.get(19).put("Category", "Code of Conduct");

        Questions.get(20).put("Question", "What should all FBLA members observe in the conference program?");
        Questions.get(20).put("choiceA", "Breakfast Options");
        Questions.get(20).put("choiceB", "Meal Times");
        Questions.get(20).put("choiceC", "Curfew");
        Questions.get(20).put("correctChoice", "Curfew");
        Questions.get(20).put("Category", "Code of Conduct");

        Questions.get(21).put("Question", "Which of the following technology companies offers member discounts for FBLA?");
        Questions.get(21).put("choiceA", "AT&T");
        Questions.get(21).put("choiceB", "HP");
        Questions.get(21).put("choiceC", "Google");
        Questions.get(21).put("correctChoice", "HP");
        Questions.get(21).put("Category", "National Sponsors / Partners ");

        Questions.get(22).put("Question", "Which major insurance company sponsors FBLA?");
        Questions.get(22).put("choiceA", "Progressive");
        Questions.get(22).put("choiceB", "Liberty Mutual");
        Questions.get(22).put("choiceC", "Geico");
        Questions.get(22).put("correctChoice", "Geico");
        Questions.get(22).put("Category", "National Sponsors / Partners ");

        Questions.get(23).put("Question", "Which major educational company that produces many textbooks sponsors FBLA?");
        Questions.get(23).put("choiceA", "Cengage");
        Questions.get(23).put("choiceB", "Schoology");
        Questions.get(23).put("choiceC", "Pearson");
        Questions.get(23).put("correctChoice", "Cengage");
        Questions.get(23).put("Category", "National Sponsors / Partners ");

        Questions.get(24).put("Question", "Which of these online shopping websites sponsor FBLA?");
        Questions.get(24).put("choiceA", "Etsy");
        Questions.get(24).put("choiceB", "Amazon");
        Questions.get(24).put("choiceC", "Ebay");
        Questions.get(24).put("correctChoice", "Amazon");
        Questions.get(24).put("Category", "National Sponsors / Partners ");

        Questions.get(25).put("Question", "Which of these sponsors provides fundraising for FBLA?");
        Questions.get(25).put("choiceA", "Country Meats");
        Questions.get(25).put("choiceB", "Alamo Rent A Car");
        Questions.get(25).put("choiceC", "Amazon");
        Questions.get(25).put("correctChoice", "Country Meats");
        Questions.get(25).put("Category", "National Sponsors / Partners ");

        Questions.get(26).put("Question", "Which website creating company sponsors FBLA?");
        Questions.get(26).put("choiceA", "Wix");
        Questions.get(26).put("choiceB", "Weebly");
        Questions.get(26).put("choiceC", "SquareSpace");
        Questions.get(26).put("correctChoice", "SquareSpace");
        Questions.get(26).put("Category", "National Sponsors / Partners ");

        Questions.get(27).put("Question", "Which of the following organizations provide sponsorships for FBLA?");
        Questions.get(27).put("choiceA", "Berkeley College, Champlain College, and Cumberland University");
        Questions.get(27).put("choiceB", "Berkeley College, Yale University, and Champlain College");
        Questions.get(27).put("choiceC", "Harvard University, Arizona State University, and Colorado State University ");
        Questions.get(27).put("correctChoice", "Berkeley College, Champlain College, and Cumberland University");
        Questions.get(27).put("Category", "National Sponsors / Partners ");

        Questions.get(28).put("Question", "Who is the current FBLA CEO?");
        Questions.get(28).put("choiceA", "Jean M. Buckley");
        Questions.get(28).put("choiceB", "Jacob D. Berkeley");
        Questions.get(28).put("choiceC", "Marissa H. Hoffmann");
        Questions.get(28).put("correctChoice", "Jean M. Buckley");
        Questions.get(28).put("Category", "National Office");

        Questions.get(29).put("Question", "Who is the National President of FBLA?");
        Questions.get(29).put("choiceA", "Michael Shang");
        Questions.get(29).put("choiceB", "Eu Ro Wang");
        Questions.get(29).put("choiceC", "Roberto Diaz-Gutierrez");
        Questions.get(29).put("correctChoice", "Eu Ro Wang");
        Questions.get(29).put("Category", "National Office");

        Questions.get(30).put("Question", "How many total FBLA National Officers are there?");
        Questions.get(30).put("choiceA", "6");
        Questions.get(30).put("choiceB", "13");
        Questions.get(30).put("choiceC", "9");
        Questions.get(30).put("correctChoice", "9");
        Questions.get(30).put("Category", "National Office");

        Questions.get(31).put("Question", "How is the FBLA National Parliamentarian appointed?");
        Questions.get(31).put("choiceA", "Election");
        Questions.get(31).put("choiceB", "Exam Score");
        Questions.get(31).put("choiceC", "Selection by CEO");
        Questions.get(31).put("correctChoice", "Exam Score");
        Questions.get(31).put("Category", "National Office");

        Questions.get(32).put("Question", "Which of the following positions serves on the Board of Directors?");
        Questions.get(32).put("choiceA", "National Treasury");
        Questions.get(32).put("choiceB", "National Parliamentarian");
        Questions.get(32).put("choiceC", "National President");
        Questions.get(32).put("correctChoice", "National President");
        Questions.get(32).put("Category", "National Office");

        Questions.get(33).put("Question", "What does FBLA’s college division (PBL) stand for?");
        Questions.get(33).put("choiceA", "2");
        Questions.get(33).put("choiceB", "4");
        Questions.get(33).put("choiceC", "1");
        Questions.get(33).put("correctChoice", "1");
        Questions.get(33).put("Category", "National Office");

        Questions.get(34).put("Question", "Where and by who are National Officers elected every year?");
        Questions.get(34).put("choiceA", "FBLA Headquarters / Board of Directors");
        Questions.get(34).put("choiceB", "National Leadership Conference (NLC) / Board of Directors");
        Questions.get(34).put("choiceC", "National Leadership Conference (NLC) / Peers");
        Questions.get(34).put("correctChoice", "National Leadership Conference (NLC) / Peers");
        Questions.get(34).put("Category", "National Office");
    }

    public void setUIForQuestion(boolean switchHistory,
                                 boolean switchFBLAEvents,
                                 boolean switchBusinessSkills,
                                 boolean switchNationalSponsors,
                                 boolean switchNationalOffice,
                                 Context quizActivity) {
        /*Runs when UI is to be painted to screen*/
        Activity activity = (Activity) quizActivity;
        if (currentQuestion <= 5) {
            Random rand = new Random();
            int questionNumber = rand.nextInt(34);
            currentQuestion = currentQuestion + 1;

            TextView currentQ = activity.findViewById(R.id.currentQuestion);
            ProgressBar progressBar = activity.findViewById(R.id.progressBar);

            currentQ.setText(Integer.toString(currentQuestion - 1) + "/5");
            progressBar.setProgress((currentQuestion - 1) * 20);

            if (switchHistory) {
                for (int j = 0; j < 7; j++) {
                    if (selectedQuestions[j] == 0) {
                        selectedQuestions[j] = 1;
                    }
                }
            }
            if (switchFBLAEvents) {
                for (int k = 7; k < 14; k++) {
                    if (selectedQuestions[k] == 0) {
                        selectedQuestions[k] = 1;
                    }
                }
            }
            if (switchBusinessSkills) {
                for (int l = 14; l < 21; l++) {
                    if (selectedQuestions[l] == 0) {
                        selectedQuestions[l] = 1;
                    }
                }
            }
            if (switchNationalSponsors) {
                for (int m = 21; m < 28; m++) {
                    if (selectedQuestions[m] == 0) {
                        selectedQuestions[m] = 1;
                    }
                }
            }
            if (switchNationalOffice) {
                for (int n = 28; n < 35; n++) {
                    if (selectedQuestions[n] == 0) {
                        selectedQuestions[n] = 1;
                    }
                }
            }

            while (selectedQuestions[questionNumber] != 1) {
                questionNumber = rand.nextInt(34);
            }
            selectedQuestions[questionNumber] = 3;

            TextView triviaQuestion = activity.findViewById(R.id.triviaQuestion);
            Button button1 = activity.findViewById(R.id.triviaButton1);
            Button button2 = activity.findViewById(R.id.triviaButton2);
            Button button3 = activity.findViewById(R.id.triviaButton3);
            triviaQuestion.setText(Questions.get(questionNumber).get("Question"));
            button1.setText(Questions.get(questionNumber).get("choiceA"));
            button2.setText(Questions.get(questionNumber).get("choiceB"));
            button3.setText(Questions.get(questionNumber).get("choiceC"));
        } else {
            //Display finish screen
            TextView triviaOptions = activity.findViewById(R.id.triviaQuestion);
            TableLayout buttonLayout = activity.findViewById(R.id.buttonLayout);
            RelativeLayout niceJob = activity.findViewById(R.id.relativeNiceJobLayout);
            LottieAnimationView anim = activity.findViewById(R.id.smileAnim);
            Button button = activity.findViewById(R.id.triviaBack);

            button.setVisibility(View.VISIBLE);
            util.fade("out", triviaOptions, null);
            util.fade("out", buttonLayout, null);
            util.fade("in", niceJob, null);
            anim.playAnimation();
        }
    }
    public void checkAnswer(String text, String questionText, Context ctx) {
        /*Checks answer against correct answer and updates score*/
        Activity activity = (Activity) ctx;
        for (int i = 0; i < 35; i++) {
            String question = Questions.get(i).get("Question");
            if (question == questionText) {
                String correctAnswer = Questions.get(i).get("correctChoice");
                if (text == correctAnswer && currentQuestion <= 6) {
                    TextView score = activity.findViewById(R.id.currentScore);
                    currentScore = currentScore + 1;
                    score.setText("Score: " + Integer.toString(currentScore));
                }
                break;
            }
        }
    }
    public void resetQuiz() {
        for (int i = 0; i < 35; i++) {
            selectedQuestions[i] = 0;
        }
        currentQuestion = 0;
        currentScore = 0;
    }
}