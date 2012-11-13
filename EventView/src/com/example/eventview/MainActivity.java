package com.example.eventview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ImageView;

import com.nineoldandroids.animation.AnimatorSet;
import com.nineoldandroids.animation.ObjectAnimator;

public class MainActivity extends Activity {

	ImageView iv1, iv2,  iv3, iv4, iv5, iv6;
	float h,w, iw, ih;
	
    @TargetApi(13)
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
		Bitmap test = BitmapFactory.decodeResource(getResources(), R.drawable.classical);
        iw = test.getWidth();
        ih = test.getHeight();
        Display display = getWindowManager().getDefaultDisplay();
        Point size = new Point();
        display.getSize(size);
        w = size.x;
        h = size.y;
        iv1 = (ImageView) findViewById(R.id.imageView1);
		iv2 = (ImageView) findViewById(R.id.imageView2);
		iv3 = (ImageView) findViewById(R.id.imageView3);
		iv4 = (ImageView) findViewById(R.id.imageView4);
		iv5 = (ImageView) findViewById(R.id.imageView5);
		iv6 = (ImageView) findViewById(R.id.imageView6);
		
		LoadImages();
		InitialAnim();
		
		iv1.setOnTouchListener(new OnTouchListener() {
			
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				//ObjectAnimator o1 = ObjectAnimator.ofFloat(target, propertyName, values)
				return false;
			}
		});
	}
	
	private void InitialAnim() {
				Log.e("LOG", Float.toString((w - iv1.getWidth()-10)));
		AnimatorSet H1 = new AnimatorSet();
		H1.playTogether(
				//ObjectAnimator.ofFloat(iv1, "translationX", 0, (w - iw-10)),
				ObjectAnimator.ofFloat(iv2, "translationX", (-1*w + iw)),
				ObjectAnimator.ofFloat(iv3, "translationX", (-1*w + iw)),
				ObjectAnimator.ofFloat(iv4, "translationX", (-1*w + iw)),
				ObjectAnimator.ofFloat(iv5, "translationX", (-1*w + iw)),
				ObjectAnimator.ofFloat(iv6, "translationX", (-1*w + iw)));
		
		H1.setDuration(3000);
		H1.start();
		
		AnimatorSet V1 = new AnimatorSet();
		V1.playTogether(
				//ObjectAnimator.ofFloat(iv1, "translationX", (w - iv1.getWidth()-10)),
				//ObjectAnimator.ofFloat(iv2, "translationX", (w - iv1.getWidth()-10)),
				ObjectAnimator.ofFloat(iv3, "translationY", (h - 3*ih)),
				ObjectAnimator.ofFloat(iv4, "translationY", (h - 3*ih)),
				ObjectAnimator.ofFloat(iv5, "translationY", (h - 3*ih)),
				ObjectAnimator.ofFloat(iv6, "translationY", (h - 3*ih)));
		
		V1.setDuration(3000);
		V1.setStartDelay(3000);
		V1.start();
		
		AnimatorSet H2 = new AnimatorSet();
		H2.playTogether(
				//ObjectAnimator.ofFloat(iv1, "translationX", 0, (w - iw-10)),
				//ObjectAnimator.ofFloat(iv2, "translationX", -1*(-1*w + iw)),
				//ObjectAnimator.ofFloat(iv3, "translationX", -1*(-1*w + iw)),
				ObjectAnimator.ofFloat(iv4, "translationX", (w-3*iw - 80)),
				ObjectAnimator.ofFloat(iv5, "translationX", (w-3*iw - 80)),
				ObjectAnimator.ofFloat(iv6, "translationX", (w-3*iw - 80)));
		
		H2.setDuration(3000);
		H2.setStartDelay(6000);
		H2.start();
		
		AnimatorSet V2 = new AnimatorSet();
		V2.playTogether(
				//ObjectAnimator.ofFloat(iv1, "translationX", (w - iv1.getWidth()-10)),
				//ObjectAnimator.ofFloat(iv2, "translationX", (w - iv1.getWidth()-10)),
				//ObjectAnimator.ofFloat(iv3, "translationY", (h - 3*ih)),
				//ObjectAnimator.ofFloat(iv4, "translationY", (h - 3*ih)),
				ObjectAnimator.ofFloat(iv5, "translationY", (h - ih - 100)),
				ObjectAnimator.ofFloat(iv6, "translationY", (h - ih- 100)));
		
		V2.setDuration(3000);
		V2.setStartDelay(9000);
		V2.start();
		
		AnimatorSet H3 = new AnimatorSet();
		H3.playTogether(
				//ObjectAnimator.ofFloat(iv1, "translationX", 0, (w - iw-10)),
				//ObjectAnimator.ofFloat(iv2, "translationX", -1*(-1*w + iw)),
				//ObjectAnimator.ofFloat(iv3, "translationX", -1*(-1*w + iw)),
				//ObjectAnimator.ofFloat(iv4, "translationX", (w-3*iw - 80)),
				//ObjectAnimator.ofFloat(iv5, "translationX", (w-3*iw - 80)),
				ObjectAnimator.ofFloat(iv6, "translationX", (-1*w + iw)));
		
		H3.setDuration(3000);
		H3.setStartDelay(12000);
		H3.start();
	}
	
	private void LoadImages() {
		iv1.setImageResource(R.drawable.carnival);
		iv2.setImageResource(R.drawable.classical);
		iv3.setImageResource(R.drawable.dance);
		iv4.setImageResource(R.drawable.design);
		iv5.setImageResource(R.drawable.lecdems);
		iv6.setImageResource(R.drawable.media);
	}
	
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
