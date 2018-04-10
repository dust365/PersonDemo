package com.example.dust.persondemo.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.dust.persondemo.R;
import com.example.dust.persondemo.adapter.ShopDetialsPageAdapter;
import com.example.dust.persondemo.bean.Stock2Bean;
import com.example.dust.persondemo.view.MyScrollView;

import java.util.ArrayList;


/**
 * @author dust
 * @function
 * @created at 2017/8/13
 */
public class ScrollShopDetialsActivity extends Activity {

	private static final String TAG = ScrollShopDetialsActivity.class.getSimpleName();



	private Toolbar mToolbar;
	MyScrollView mScrollView;
	LinearLayout mLLOne ;
	LinearLayout mLLTwo ;
	LinearLayout mLLThree ;
	LinearLayout mLLFour ;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		setContentView(R.layout.activity_scroll_shop_detials);

		FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);




		mToolbar = findViewById(R.id.toolbar_main);
		mToolbar.setTitle("商品详情");


		floatingActionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				int childCount = mScrollView.getChildCount();




				for (int i = 0; i < childCount; i++) {

					View childView = mScrollView.getChildAt(i);

					float y = childView.getY();
					Log.e(TAG,"getY()==="+y);

					int height = childView.getHeight();
					Log.e(TAG,"getHeight()()==="+height);






				}

				scrollToView(mLLThree);




			}
		});

		 mScrollView = findViewById(R.id.scrollView);
		 mLLOne = findViewById(R.id.ll_one);
		 mLLTwo = findViewById(R.id.ll_two);
		 mLLThree = findViewById(R.id.ll_three);
		 mLLFour = findViewById(R.id.ll_four);


		mScrollView.setOnScrollListener(new MyScrollView.OnScrollListener() {
			@Override
			public void onScroll(int scrollY) {



				Log.e(TAG,"scrollY==="+scrollY);




			}
		});


		int height = mScrollView.getHeight();
		Log.e(TAG,"mScrollView ----> height="+height);

		int measuredHeight = mScrollView.getMeasuredHeight();
		Log.e(TAG,"mScrollView ----> measuredHeight="+measuredHeight);





	}

	private void scrollToView(final LinearLayout linearLayout) {
		mScrollView.post(new Runnable() {
			@Override
			public void run() {
				//To change body of implemented methods use File | Settings | File Templates.
//                    mRootScrollView.fullScroll(ScrollView.FOCUS_DOWN);
				int[] location = new int[2];
				linearLayout.getLocationOnScreen(location);
				int offset = location[1] - mScrollView.getMeasuredHeight();
				if (offset < 0) {
					offset = 0;
				}
				mScrollView.smoothScrollTo(0, offset);
			}
		});
	}

}
