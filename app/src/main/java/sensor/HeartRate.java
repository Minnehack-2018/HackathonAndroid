package sensor;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class HeartRate extends AppCompatActivity implements SensorEventListener {

    //Correlates to the place on the screen where it needs
    private TextView showHeartRate;

    private SensorManager sensorMgr;
    private Sensor heartRate;

    //Holds the value of the heart rate
    private String heartRateValue;

    public HeartRate(TextView showHeartRate, View appContext) {

        //Take the context of the passed in view
        setContentView(appContext);

        this.showHeartRate = showHeartRate;
        sensorMgr = (SensorManager)this.getSystemService(SENSOR_SERVICE);

        heartRate = sensorMgr.getDefaultSensor(Sensor.TYPE_HEART_RATE);

    }

    //Need to call for onResume()
    public void startListening() {
        sensorMgr.registerListener(this,heartRate,SensorManager.SENSOR_DELAY_NORMAL);
    }

    //Need to call for onPause()
    public void stopListening() {
        sensorMgr.unregisterListener(this);
    }

    //Used for any other function that wants the most recent heartRateValue
    public String getHeartRateValue() { return heartRateValue; }

    @Override
    public void onSensorChanged(SensorEvent event) {
        //Update the stored value when the sensor reads a change
        heartRateValue = Integer.toString(event.sensor.getType());

        //Sets the screen text to display the heart-rate
        showHeartRate.setText(heartRateValue);

    }

    //Not used, but needs to be implemented
    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
