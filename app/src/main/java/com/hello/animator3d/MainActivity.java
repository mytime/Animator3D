package com.hello.animator3d;

import android.animation.AnimatorInflater;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

/**
 * 图片3D翻转效果
 */
public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //点击监听
        findViewById(R.id.image).setOnClickListener(this);
        findViewById(R.id.image1).setOnClickListener(this);

    }

    boolean flag;

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.image:

                /**
                 * java code 实现图片3D翻转
                 */
                if (flag) {

                    ObjectAnimator.ofFloat(v, "rotationY", 0f, 180f).setDuration(1000).start();
//            ObjectAnimator.ofFloat(iv, "rotationX", 0f, 180f).setDuration(1000).start();
                    flag = false;

                } else {

                    ObjectAnimator.ofFloat(v, "rotationY", 180f, 0f).setDuration(1000).start();
//            ObjectAnimator.ofFloat(iv, "rotationX", 180f, 0f).setDuration(1000).start();
                    flag = true;
                }
                break;
            case R.id.image1:

                /**
                 * xml 实现图片3D翻转
                 */

                if(flag){
                    ObjectAnimator oa = (ObjectAnimator) AnimatorInflater.loadAnimator(this,
                            R.animator.amin_3d);
                    oa.setTarget(v);
                    oa.start();
                    flag = false;
                }else{
                    ObjectAnimator oa = (ObjectAnimator)AnimatorInflater.loadAnimator(this,
                            R.animator.anim_3d_2);
                    oa.setTarget(v);
                    oa.start();
                    flag = true;
                }

                break;
        }


    }
}
