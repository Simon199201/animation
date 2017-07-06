package com.yishu.animation.activity;

import android.animation.ValueAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Button;

import com.yishu.animation.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by simon on 17/7/6.
 * ValueAnimator是整个属性动画机制当中最核心的一个类，前面我们已经提到了，属性动画的运行机制是通过不断地对值进行操作来实现的，而初始值和结束值之间的动画过渡就是由ValueAnimator这个类来负责计算的。
 * 它的内部使用一种时间循环的机制来计算值与值之间的动画过渡，我们只需要将初始值和结束值提供给ValueAnimator，并且告诉它动画所需运行的时长，那么ValueAnimator就会自动帮我们完成从初始值平滑地过渡到结束值这样的效果。
 * 除此之外，ValueAnimator还负责管理动画的播放次数、播放模式、以及对动画设置监听器等，确实是一个非常重要的类。
 */

public class ValueAnimatorActivity extends Activity {
    private static final String TAG = ValueAnimatorActivity.class.getSimpleName();
    @BindView(R.id.btn_float)
    Button btnFloat;
    @BindView(R.id.btn_int)
    Button btnInt;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_float)
    public void onBtnFloatClicked() {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 1, 2, 3, 0);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                float current_value = (float) animation.getAnimatedValue();
                Log.e(TAG, "onAnimationUpdate: " + current_value);
            }
        });
        valueAnimator.setRepeatCount(5);
        valueAnimator.setRepeatMode(ValueAnimator.RESTART);
        valueAnimator.start();
    }

    @OnClick(R.id.btn_int)
    public void onBtnIntClicked() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 50, 100, 50, 0);
        valueAnimator.setDuration(3000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int current_value = (int) animation.getAnimatedValue();
                Log.e(TAG, "onAnimationUpdate: " + current_value);
            }
        });
        valueAnimator.start();
    }
}
