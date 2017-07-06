package com.yishu.animation.util;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.yishu.animation.bean.Point;

/**
 * Created by simon on 17/7/6.
 */

public class MyAnimView extends View {
    private static final float RADIUS = 50f;
    private Point currentPoint;
    private Paint mPaint;

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
        mPaint.setColor(Color.parseColor(color));
        invalidate();
    }

    private String color;

    public MyAnimView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (null == currentPoint) {
            currentPoint = new Point(RADIUS, RADIUS);
            drawCircle(canvas);
            startAnimation();
        } else {
            drawCircle(canvas);
        }
    }

    private void startAnimation() {
        Point startPoint = new Point(RADIUS, RADIUS);
        Point endPoint = new Point(getWidth() - RADIUS, getHeight() - RADIUS);
        ValueAnimator animator = ValueAnimator.ofObject(new PointEvaluator(), startPoint, endPoint);
        animator.setDuration(5000);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentPoint = (Point) animation.getAnimatedValue();
                invalidate();
            }
        });
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(this, "color", new ColorEvaluator(), "#0000FF", "#FF0000");
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.setDuration(5000);
        animatorSet.play(animator).with(objectAnimator);
        animatorSet.start();

    }

    private void drawCircle(Canvas canvas) {
        canvas.drawCircle(currentPoint.getX(), currentPoint.getY(), RADIUS, mPaint);
    }
}
