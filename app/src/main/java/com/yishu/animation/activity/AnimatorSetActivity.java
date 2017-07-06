package com.yishu.animation.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
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

public class AnimatorSetActivity extends Activity {
    @BindView(R.id.btn_animatorSet)
    Button btnAnimatorSet;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animatorset);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_animatorSet)
    public void onViewClicked() {

        ObjectAnimator moveIn = ObjectAnimator.ofFloat(btnAnimatorSet, "translationX", -100f, 0f);
        ObjectAnimator rotate = ObjectAnimator.ofFloat(btnAnimatorSet, "rotation", 0, 360f);
        ObjectAnimator fadeInOut = ObjectAnimator.ofFloat(btnAnimatorSet, "alpha", 1f, 0f, 1f);

        AnimatorSet animationSet = new AnimatorSet();
        animationSet.play(rotate).with(fadeInOut).after(moveIn);
        animationSet.setDuration(5000);
        animationSet.start();
    }
}
