package com.saarang.eventlayout;


import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.FloatMath;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Toast;

@SuppressWarnings("unused")
public class EventView extends View{
	
	private int N;
	private int type;
	private Bitmap logo;
	private int width;
	private int[] colors;
	private int inner_rad, outer_rad;
	private float w, h;
	private float DefPosX, DefPosY;
	
	private int state;
	private Context cxt;
	private float LogoPosX, LogoPosY;
	
	int counter;
	boolean touched;
	
	Bitmap[] DanceEvents;
	

	public EventView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		cxt = context;
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		 
		w = display.getWidth();  // deprecated
		h = display.getHeight();  // deprecated
		counter = 0;
		
		logo = BitmapFactory.decodeResource(getResources(), R.drawable.saarang).copy(Config.ARGB_8888, true);
		LogoPosX = (w-logo.getWidth())/2;
		LogoPosY = (h-logo.getHeight())/2;
		
		DefPosX = (w-logo.getWidth())/2;
		DefPosY = (h-logo.getHeight())/2;
		DanceEvents = new Bitmap[3];
		
		DanceEvents[0] = BitmapFactory.decodeResource(getResources(), R.drawable.dance_events);  
		width = 40;
		TypedArray a = context.getTheme().obtainStyledAttributes(
		        attrs,
		        R.styleable.EventView,
		        0, 0);
		
		
		
		 
		colors = new int[]{Color.YELLOW, Color.BLUE, Color.GREEN, Color.MAGENTA, Color.WHITE, 0xffc6f9e5, 0xffb6e9b5, 0xffa6d9b5, 0xff96c9b5};
		try {
			N = a.getInteger(R.styleable.EventView_number, 6);
			type = a.getInteger(R.styleable.EventView_type, 0);
		} finally {
			a.recycle();
		}
		
		
	}
	
	
	//TODO PUBLIC FUNCTIONS TO SET Type, and which will set N and thus dynamically 
	//			generate the view
	
	
	@Override
	protected void onSizeChanged(int w, int h, int oldw, int oldh) {
		super.onSizeChanged(w, h, oldw, oldh);
		//TODO Calculate 
	}
	
	@Override
    protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
			
		Log.i("SIZES",Integer.toString(canvas.getWidth())+"  "+logo.getWidth());
		RectF outerbound = new RectF(LogoPosX -40 , LogoPosY - 40, LogoPosX + logo.getWidth()+40, LogoPosY + logo.getHeight()+40);
		w = canvas.getWidth();
		h = canvas.getHeight();
		inner_rad = logo.getWidth()/2;
		outer_rad = logo.getWidth()/2 + 40;
		int dangle = 360/N;
		int init = 0;
		Paint p0 = new Paint();
		p0.setStyle(Paint.Style.STROKE);
		p0.setStrokeWidth(width);
		p0.setColor(colors[0]);
		
		for(int i = 0; i < N; i++) {
			p0.setColor(colors[i]);
			canvas.drawArc(outerbound, init + 1, dangle - 1, false, p0);
			init = init + dangle;
		}
		canvas.drawBitmap(logo, LogoPosX, LogoPosY, null);
		
		if(touched) {
			switch(state) {
			case 1:
				canvas.drawBitmap(DanceEvents[0], 10,  10, null);
				canvas.drawBitmap(DanceEvents[0], 380, 280, null);
				canvas.drawBitmap(DanceEvents[0], 450, 930, null);
				canvas.drawBitmap(DanceEvents[0], 320, 700, null);
			}
		}
		
	}
	
	
	@Override
    public boolean onTouchEvent(MotionEvent event) {
		Log.i("LOG", "Touch "+ event.getX() + " " + event.getY());
		CharSequence text = "Hello toast!";
		int duration = Toast.LENGTH_SHORT;
		if(event.getAction() == MotionEvent.ACTION_DOWN) {
			Polar tcr = new Polar(event.getX() - (LogoPosX + logo.getWidth()/2), event.getY()-(LogoPosY + logo.getHeight()/2));
			Log.i("LOG", "R = " + tcr.r + " inr " + inner_rad);
			Log.i("LOG", "Ang = " + tcr.ang);
			
			if(tcr.r < inner_rad)  {
				while(LogoPosX != DefPosX) {
					LogoPosX = (LogoPosX < DefPosX) ? (LogoPosX+1) : (LogoPosX-1); 
					invalidate();
				}
				while(LogoPosY != DefPosY) {
					LogoPosY = (LogoPosY < DefPosY) ? (LogoPosY+1) : (LogoPosY-1); 
					invalidate();
				}
				touched = false;
			}  else if(tcr.r < outer_rad) {
				int i = (int)Math.ceil(tcr.ang/Math.PI * 3);
				Log.i("TAG TEST", Integer.toString(i));
				state = i;
				switch (i) {
				case 0:
				case 1:
					for(int cnt = 0; LogoPosX > -logo.getWidth()/2; cnt++) {
						LogoPosX = (LogoPosX - 0.5f);
						//invalidate();
						postInvalidateDelayed(100);
					}
					break;
				case -2:
				case  3:
					for(int cnt = 0; LogoPosX < (w-logo.getWidth()/2); cnt++) {
						LogoPosX = (LogoPosX + 0.5f);
						//invalidate();
						postInvalidateDelayed(100);
					}
					break;
				case -1:
					for(int cnt = 0; LogoPosY < (h-logo.getHeight()/2); cnt++) {
						LogoPosY = (LogoPosY + 0.5f);
						//invalidate();
						postInvalidateDelayed(100);
					}
					break;
				case 2:
					for(int cnt = 0; LogoPosY > (-logo.getHeight()/2); cnt++) {
						LogoPosY = (LogoPosY - 0.5f);
						//invalidate();
						postInvalidateDelayed(100);
					}
					break;
				default:
					break;
				}
				touched = true;
			}
		}
		return super.onTouchEvent(event);
	}
}

/*
 * Class written to handle touch events and get the position relative to the 
 * Centre of the Logo.
 * 
 */

class Polar {
	
	public float r;
	public float ang;
	

	Polar(float x, float y) {
		this.r = FloatMath.sqrt(x*x+y*y);
		this.ang = (float) Math.atan2(y, x);
	}
}
