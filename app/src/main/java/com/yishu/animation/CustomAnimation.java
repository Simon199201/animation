package com.yishu.animation;

import android.content.Context;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.Transformation;

/**
 * Created by simon on 17/3/10.
 */

public class CustomAnimation extends Animation {
    private static final String TAG = "CustomAnimation";

    @Override
    public void setInterpolator(Context context, int resID) {
        super.setInterpolator(context, resID);
    }

    public CustomAnimation() {
        super();
        setDuration(5000);
    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        Log.i(TAG, "applyTransformation: " + interpolatedTime);
        t.getMatrix().setTranslate((float) Math.sin(interpolatedTime*10)*50,0);
        super.applyTransformation(interpolatedTime, t);
    }
}
