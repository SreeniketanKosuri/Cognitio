package k.arez.niki.fbla;

import android.animation.Animator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.Interpolator;

public class Utility {
    private int mediumAnimDuration = 400;
    private Interpolator easeInterpolator = new AccelerateDecelerateInterpolator();
    public void fade(String type, View view, Animator.AnimatorListener listen) {
        if (type.toLowerCase() == "in") {
            view.animate()
                    .setInterpolator(easeInterpolator)
                    .alpha(1f)
                    .setDuration(mediumAnimDuration)
                    .setListener(listen);
        } else if (type.toLowerCase() == "out") {
            view.animate()
                    .setInterpolator(easeInterpolator)
                    .alpha(0f)
                    .setDuration(mediumAnimDuration)
                    .setListener(listen);
        }
    }
    public void translateX(View view, int x) {
        view.animate()
                .setInterpolator(easeInterpolator)
                .x(x)
                .setDuration(mediumAnimDuration)
                .setListener(null);
    }
    public void translateY(View view, int y) {
        view.animate()
                .setInterpolator(easeInterpolator)
                .y(y)
                .setDuration(mediumAnimDuration)
                .setListener(null);
    }
    public void destroy(View view) {
        ((ViewGroup) view.getParent()).removeView(view);
    }
}
