package edu.ucsd.vis141.CanYouSeeNow;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.PorterDuff.Mode;
import android.view.SurfaceView;

/*********************************
 * UCSD VIS 141A project
 * SciFiAPP
 * 
 * Created By: Monica Liu
 * Last Modified 2/10/14
 * 
 * DrawView.java:
 *   A drawview class used to overlay the sufaceview holding the camera preview.
 *   The edges found in the image are drawn on this view using canvas and paint.
 *   
 ********************************/

public class DrawView extends SurfaceView{

	public DrawView(Context context) {
		super(context);
		
		setWillNotDraw(false);
	}

	@Override
	protected void onDraw(Canvas canvas){
		canvas.drawColor(0, Mode.CLEAR);
		if (DataHolder.getInstance().getStatus()) canvas.drawBitmap(DataHolder.getInstance().getBitmap(), 0, 0, null);
	}
	
}