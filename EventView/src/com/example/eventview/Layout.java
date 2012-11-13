package com.example.eventview;



import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

public class Layout extends View{

	private Context cxt;
	private int w;
	private int h;

	// ImageViews
	ImageView iv1, iv2,  iv3, iv4, iv5, iv6;

	public Layout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		cxt = context;
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		 
		w = display.getWidth();  // deprecated
		h = display.getHeight();  // deprecated
		
		iv1 = (ImageView) findViewById(R.id.imageView1);
		iv2 = (ImageView) findViewById(R.id.imageView2);
		iv3 = (ImageView) findViewById(R.id.imageView3);
		iv4 = (ImageView) findViewById(R.id.imageView4);
		iv5 = (ImageView) findViewById(R.id.imageView5);
		iv6 = (ImageView) findViewById(R.id.imageView6);
		
		LoadImages();
		
		InitialAnim();
		
		
	}
	
	private void InitialAnim() {
		
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
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		//TODO Calculate 
	}
	
	@Override
    protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
	}
	
	
	@Override
    public boolean onTouchEvent(MotionEvent event) {
		return super.onTouchEvent(event);
	}
}
