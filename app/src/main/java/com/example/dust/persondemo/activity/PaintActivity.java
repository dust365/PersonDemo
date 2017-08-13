package com.example.dust.persondemo.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;

import com.example.dust.persondemo.R;
import com.example.dust.persondemo.bean.PieData;
import com.example.dust.persondemo.view.PieView;

import java.util.ArrayList;


/**
 * @author dust
 * @function  paint 画笔学习页面
 * @created at 2017/8/13
 */
public class PaintActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		setContentView(R.layout.activity_paint);



		//扇形图

		PieView pieView = (PieView) findViewById(R.id.pieview);


		ArrayList<PieData> datas = new ArrayList<>();
		PieData pieData = new PieData("sloop", 60);
		PieData pieData2 = new PieData("sloop", 30);
		PieData pieData3 = new PieData("sloop", 40);
		PieData pieData4 = new PieData("sloop", 20);
		PieData pieData5 = new PieData("sloop", 20);
		datas.add(pieData);
		datas.add(pieData2);
		datas.add(pieData3);
		datas.add(pieData4);
		datas.add(pieData5);
		pieView.setData(datas);


	}


}
