package com.saarang;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.drawable.Drawable;
import android.view.View;

public class NewLayout extends View {
	
	public Bitmap OrangeRing;
	public Bitmap GreenRing;
	public Bitmap BlueRing;
	public Bitmap WhiteRing;
	

	public NewLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		
		OrangeRing = getResBitmap(R.drawable.orange);
		GreenRing  = getResBitmap(R.drawable.green);
		BlueRing   = getResBitmap(R.drawable.blue);
		WhiteRing  = getResBitmap(R.drawable.white);
		
		
	}
	
	public void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		
	}

	private Bitmap getResBitmap(int bmpResId) {
        Options opts = new Options();
        opts.inDither = false;

        Resources res = getResources();
        Bitmap bmp = BitmapFactory.decodeResource(res, bmpResId, opts);

        if (bmp == null && isInEditMode()) {
           
            Drawable d = res.getDrawable(bmpResId);
            int w = d.getIntrinsicWidth();
            int h = d.getIntrinsicHeight();
            bmp = Bitmap.createBitmap(w, h, Config.ARGB_8888);
            Canvas c = new Canvas(bmp);
            d.setBounds(0, 0, w - 1, h - 1);
            d.draw(c);
        }

        return bmp;
    }

}
