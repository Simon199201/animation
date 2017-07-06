package com.yishu.animation.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Button;

import com.yishu.animation.R;
import com.yishu.animation.bean.Point;
import com.yishu.animation.util.PointEvaluator;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by simon on 17/7/6.
 * 相比于ValueAnimator，ObjectAnimator可能才是我们最常接触到的类，因为ValueAnimator只不过是对值进行了一个平滑的动画过渡，
 * 但我们实际使用到这种功能的场景好像并不多。而ObjectAnimator则就不同了，它是可以直接对任意对象的任意属性进行动画操作的，比如说View的alpha属性。
 */

public class ObjectAnimatorActivity extends Activity {
    @BindView(R.id.btn_alpha)
    Button btnAlpha;
    @BindView(R.id.btn_rotation)
    Button btnRotation;
    @BindView(R.id.btn_translationX)
    Button btnTranslationX;
    @BindView(R.id.btn_scaleY)
    Button btnScaleY;
    @BindView(R.id.btn_advance)
    Button btnAdvance;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_alpha)
    public void onBtnAlphaClicked() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(btnAlpha, "alpha", 1f, 0f, 1f);
        animator.setDuration(5000);
        animator.start();
    }

    @OnClick(R.id.btn_rotation)
    public void onBtnRotationClicked() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(btnRotation, "rotation", 1f, 360f);
        animator.setDuration(5000);
        animator.start();
    }

    @OnClick(R.id.btn_translationX)
    public void onBtnTranslationXClicked() {
        float curTranslationX = btnTranslationX.getTranslationX();

        ObjectAnimator animator = ObjectAnimator.ofFloat(btnTranslationX, "translationY", curTranslationX, -500f, curTranslationX);
        animator.setDuration(5000);
        animator.start();
    }

    @OnClick(R.id.btn_scaleY)
    public void onBtnScaleYClicked() {
        ObjectAnimator animator = ObjectAnimator.ofFloat(btnScaleY, "scaleX", 1, 0, 1);
        animator.setDuration(5000);
        animator.start();
    }

    @OnClick(R.id.btn_advance)
    public void onViewClicked() {
        Point point1 = new Point(0, 0);
        Point point2 = new Point(300, 300);
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new PointEvaluator(), point1, point2);
        valueAnimator.setDuration(5000);

    }
}
