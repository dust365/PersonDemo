package com.example.dust.persondemo.activity;

import android.app.Activity;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.dust.persondemo.R;

/**
 * Created by dust on 2018/3/7.
 */

public class SensorActivity extends Activity {

    private static final String TAG = SensorActivity.class.getSimpleName();

    private TextView tv_pressure;
    private TextView tv_light;
    private TextView tv_accelerometer;
    private SensorManager sensorManager;
    private Sensor pressureSensor;

    private SensorEventListener sensorEventListener = new SensorEventListener() {

        @Override
        public void onSensorChanged(SensorEvent sensorEvent) {
            float[] values = sensorEvent.values;
            int sensorType = sensorEvent.sensor.getType();


            switch(sensorType) {

                case Sensor.TYPE_LIGHT:



                    tv_light.setText("当前光强："+ values[0]);
                    break;
                case Sensor.TYPE_PRESSURE:


                    tv_pressure.setText("当前压力为："+String.format("%.3f mbar", values[0]));
                    break;
                case Sensor.TYPE_ACCELEROMETER:

                    // 读取加速度传感器数值，values数组0,1,2分别对应x,y,z轴的加速度
                    Log.i(TAG, "onSensorChanged: " + values[0] + ", " + values[1] + ", " + values[2]);

                    tv_accelerometer.setText("加速度：X=="+ values[0] + "Y== " + values[1] + "Z==" + values[2]);
                    break;

            }



        }

        @Override
        public void onAccuracyChanged(Sensor sensor, int i) {
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sensor);
        tv_pressure = findViewById(R.id.tv_pressure);
        tv_light = findViewById(R.id.tv_light);
        tv_accelerometer = findViewById(R.id.tv_accelerometer);
        sensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
//        pressureSensor = sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        //压力
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_PRESSURE), SensorManager.SENSOR_DELAY_UI);

        //当前光强
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_LIGHT), SensorManager.SENSOR_DELAY_UI);


         //加速度
        sensorManager.registerListener(sensorEventListener, sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER), SensorManager.SENSOR_DELAY_UI);



    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(sensorEventListener);
    }


}
