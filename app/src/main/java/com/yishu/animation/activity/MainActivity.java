package com.yishu.animation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.yishu.animation.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.normal, R.id.property_value, R.id.property_object, R.id.activity_main, R.id.property_animationSet})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.normal:
                startActivity(new Intent(this, NormalAnimatorActivity.class));
                break;
            case R.id.property_object:
                startActivity(new Intent(this, ObjectAnimatorActivity.class));
                break;
            case R.id.property_value:
                startActivity(new Intent(this, ValueAnimatorActivity.class));
                break;
            case R.id.property_animationSet:
                startActivity(new Intent(this, AnimatorSetActivity.class));
                break;
        }
    }

}
