package aun.control;

import android.app.Activity;
import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;

public class Control extends Activity implements SensorEventListener  {

	private SensorManager mSensorManager;
	private Sensor mAccelerometer;
	private float TILT ;
	
	public Control(Activity activity){
		 mSensorManager = (SensorManager) activity.getSystemService(Context.SENSOR_SERVICE);
		 if (mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).size() != 0) {
			mAccelerometer = mSensorManager.getSensorList(Sensor.TYPE_ACCELEROMETER).get(0);
			mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
		 }
	}
	
	@Override
	public void onAccuracyChanged(Sensor sensor, int accuracy) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSensorChanged(SensorEvent event) {
		// TODO Auto-generated method stub
		TILT = event.values[0];
	}
    
	public float getTilt(){
    	return TILT ;
    }

}
