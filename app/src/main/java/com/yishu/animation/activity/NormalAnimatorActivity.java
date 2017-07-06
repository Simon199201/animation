package com.yishu.animation.activity;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.view.animation.LayoutAnimationController;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.yishu.animation.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by simon on 17/7/6.
 */

public class NormalAnimatorActivity extends Activity {
    private static final String TAG = "NormalAnimatorActivity";
    @BindView(R.id.animation1)
    Button btAnimation;
    @BindView(R.id.remove)
    Button remove;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);
        ButterKnife.bind(this);
        LinearLayout rootView = (LinearLayout) findViewById(R.id.activity_main);
        /**
         * 布局animation
         * 子view自带动画
         */
        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1);
        scaleAnimation.setDuration(3000);
        LayoutAnimationController ac = new LayoutAnimationController(scaleAnimation);
        ac.setOrder(LayoutAnimationController.ORDER_NORMAL);
        ac.setDelay(1);
        rootView.setLayoutAnimation(ac);

        imageView.setBackgroundResource(R.drawable.rocket);
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
        //DrawableAnimation 可以做背景图片变换
        AnimationDrawable animation = (AnimationDrawable) imageView.getBackground();
        animation.start();
    }

    @OnClick(R.id.animation1)
    public void onViewClicked() {
//        ScaleAnimation scaleAnimation = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//        scaleAnimation.setDuration(2000);
//        btAnimation.startAnimation(scaleAnimation);

        /**
         * 复合动画
         */
//        Animation animation = AnimationUtils.loadAnimation(this, R.anim.anim);
//        btAnimation.startAnimation(animation);
        /**
         * 自定义动画
         */
//        CustomAnimation customAnimation = new CustomAnimation();
//        btAnimation.startAnimation(customAnimation);

        /**
         * 属性动画
         */
        float curTranslationX = btAnimation.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(btAnimation, "translationX", curTranslationX, -500f, curTranslationX);
        animator.setDuration(5000);
        animator.start();
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float currentValue = (float) animation.getAnimatedValue();
                Log.e(TAG, "onAnimationUpdate: value is " + currentValue );
            }
        });
        /**
         * 组合动画
         */
        ObjectAnimator moveIn = ObjectAnimator.ofFloat(btAnimation, "translationX", -500f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(btAnimation, "rotation", 0f, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(btAnimation, "alpha", 1f, 0f, 1f);
        AnimatorSet animSet = new AnimatorSet();
        animSet.play(rotate).with(fadeInOut).after(moveIn);
        animSet.setDuration(5000);
        animSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        animSet.start();
    }

    @OnClick(R.id.remove)
    public void remove(View view) {
        activityMain.removeView(view);
    }
}
