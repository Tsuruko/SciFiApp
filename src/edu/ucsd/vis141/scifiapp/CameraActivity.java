package edu.ucsd.vis141.scifiapp;

import android.hardware.Camera;
import android.os.Bundle;
import android.app.Activity;
import android.widget.FrameLayout;

public class CameraActivity extends Activity {
	
	private Camera mCamera;
	private CameraPreview mPreview;
	private DrawView detectEdge;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_camera);
	
		mCamera = getCameraInstance();
		
        // Create our Preview view and set it as the content of our activity.
        mPreview = new CameraPreview(this, mCamera);
        detectEdge = new DrawView(this);
        
        FrameLayout preview = (FrameLayout) findViewById(R.id.camera_preview);
        preview.addView(mPreview);
        preview.addView(detectEdge);
	}
	
	/** A safe way to get an instance of the Camera object. */
	public static Camera getCameraInstance(){
	    Camera c = null;
	    try {
	        c = Camera.open(); // attempt to get a Camera instance
	    }
	    catch (Exception e){
	        // Camera is not available (in use or does not exist)
	    }
	    return c; // returns null if camera is unavailable
	}
	
}