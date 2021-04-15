package com.example.dust.persondemo.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.example.dust.persondemo.R;
import com.example.dust.persondemo.adapter.ShopDetialsPageAdapter;
import com.example.dust.persondemo.bean.Stock2Bean;
import com.example.dust.persondemo.view.MyScrollView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


/**
 * @author dust
 * @function
 * @created at 2017/8/13
 */
public class ScrollShopDetialsActivity extends Activity {

	private static final String TAG = ScrollShopDetialsActivity.class.getSimpleName();


	int mLayoutOneHeight = -1;

	int mLayoutTwoHeight = -1;

	int mLayoutThreeHeight = -1;

	int mLayoutFourHeight = -1;




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

//				int childCount = mScrollView.getChildCount();
//
//
//
//
//				for (int i = 0; i < childCount; i++) {
//
//					View childView = mScrollView.getChildAt(i);
//
//					float y = childView.getY();
//					Log.e(TAG,"getY()==="+y);
//
//					int height = childView.getHeight();
//					Log.e(TAG,"getHeight()()==="+height);
//
//
//
//
//
//
//				}
//
//				scrollToView(mLLThree);


				int y = mLayoutOneHeight + mLayoutTwoHeight;
				Log.e(TAG, "onClick: y = " + y );
				mScrollView.smoothScrollTo(0, y);




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





		ViewTreeObserver layoutOneVto = mLLOne.getViewTreeObserver();
		layoutOneVto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout() {
				mLLOne.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				mLayoutOneHeight = mLLOne.getHeight();
				Log.e(TAG, "onGlobalLayout: mLayoutOneHeight = " + mLayoutOneHeight );


			}
		});



		ViewTreeObserver layoutTwoVto = mLLTwo.getViewTreeObserver();
		layoutTwoVto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout() {
				mLLTwo.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				mLayoutTwoHeight = mLLTwo.getHeight();

				Log.e(TAG, "onGlobalLayout: mLayoutTwoHeight = " + mLayoutTwoHeight );


			}
		});



		ViewTreeObserver layoutThreeVto = mLLThree.getViewTreeObserver();
		layoutThreeVto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout() {

				mLLThree.getViewTreeObserver().removeOnGlobalLayoutListener(this);
				mLayoutThreeHeight = mLLThree.getHeight();


				Log.e(TAG, "onGlobalLayout: mLayoutThreeHeight = " + mLayoutThreeHeight );


			}
		});



		ViewTreeObserver layoutFourVto = mLLFour.getViewTreeObserver();
		layoutFourVto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {

			@Override
			public void onGlobalLayout() {

				mLLFour.getViewTreeObserver().removeGlobalOnLayoutListener(this);
				mLayoutFourHeight = mLLFour.getHeight();


				Log.e(TAG, "onGlobalLayout: mLayoutFourHeight = " + mLayoutFourHeight );

			}
		});







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
