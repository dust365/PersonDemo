package com.example.dust.persondemo.activity;

import android.app.Activity;
import android.graphics.Rect;
import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.dust.persondemo.R;
import com.example.dust.persondemo.adapter.ShopDetialsPageAdapter;
import com.example.dust.persondemo.bean.Stock2Bean;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;


/**
 * @author dust
 * @function
 * @created at 2017/8/13
 */
public class SlidingShopDetialsActivity extends Activity {

	private static final String TAG = SlidingShopDetialsActivity.class.getSimpleName();


	ArrayList<Stock2Bean> mGoodsList = new ArrayList();
	private LinearLayoutManager mLinearLayoutManager;
	private Toolbar mToolbar;
	RecyclerView mrecycleView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);


		setContentView(R.layout.activity_sliding_shop_detials);

		FloatingActionButton floatingActionButton = findViewById(R.id.floatingActionButton);
		 mToolbar = findViewById(R.id.toolbar_main);
		mToolbar.setTitle("商品详情");

		  mrecycleView = findViewById(R.id.recycleView);

		mLinearLayoutManager = new LinearLayoutManager(SlidingShopDetialsActivity.this);
//		linearLayoutManager.setReverseLayout(true);// 设置列表倒叙
//		linearLayoutManager.setStackFromEnd(true);

		mrecycleView.setLayoutManager(mLinearLayoutManager);



		mGoodsList.add(new Stock2Bean(1, "第111111111111111111111111111111111页面"));
		mGoodsList.add(new Stock2Bean(0, "第22222222222222222页面","100.00"));


		mGoodsList.add(new Stock2Bean(1, "第333333页面"));
		mGoodsList.add(new Stock2Bean(0, "第444444444444444页面","100.00"));


		ShopDetialsPageAdapter shopDetialsPageAdapter = new ShopDetialsPageAdapter(SlidingShopDetialsActivity.this,mGoodsList);

		mrecycleView.setAdapter(shopDetialsPageAdapter);


		int scrollState = mrecycleView.getScrollState();


		Log.e(TAG,"scrollState="+scrollState);









		floatingActionButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				mrecycleView.scrollToPosition(1);
			}
		});


		mrecycleView.addOnScrollListener(new RecyclerView.OnScrollListener() {
			@Override
			public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
				super.onScrollStateChanged(recyclerView, newState);

				/**
				 * The RecyclerView is not currently scrolling.
				 * （静止没有滚动）SCROLL_STATE_IDLE = 0;
				 */


				 /**
				  * The RecyclerView is currently being dragged by outside input such as user touch input.
				  *（正在被外部拖拽,一般为用户正在用手指滚动） SCROLL_STATE_DRAGGING = 1;
				  */


				/**
				 * The RecyclerView is currently animating to a final position while not under outside control.
				 *（自动滚动） SCROLL_STATE_SETTLING = 2;
				 */
				int scrollY = recyclerView.getScrollY();


			}

			@Override
			public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
				super.onScrolled(recyclerView, dx,dy );

				int height = recyclerView.getHeight();
				Log.e(TAG,"recyclerView ----> height="+height);

				int measuredHeight = recyclerView.getMeasuredHeight();
				Log.e(TAG,"recyclerView ----> measuredHeight="+measuredHeight);





               //向下滚动
				if (dy > 0) {
					int visibleItemCount = mLinearLayoutManager.getChildCount();
					int totalItemCount = mLinearLayoutManager.getItemCount();
					int pastVisiblesItems = mLinearLayoutManager.findFirstVisibleItemPosition();

					Log.e(TAG,"向下滚动 dy="+dy);


					//向上滚动
				} else if (dy < 0) {


					Log.e(TAG,"向上滚动 dy="+dy);

				}







				int childCount = mrecycleView.getChildCount();

				for (int i = 0; i <childCount ; i++) {

					View childView = mrecycleView.getChildAt(i);
					int childViewHeight = childView.getHeight();

					float y = childView.getY();
					Log.e(TAG,"childViewHeight "+i+"=="+childViewHeight);
					Log.e(TAG,"childView  Y "+i+"=="+y);

				}


//				int currentViewIndex = getCurrentViewIndex();
//				Log.d(TAG,"currentViewIndex=="+currentViewIndex);


				int currentViewIndex=0;
				int firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
				//屏幕中最后一个可见子项的position
				int lastVisibleItemPosition = mLinearLayoutManager.findLastVisibleItemPosition();
				//当前屏幕所看到的子项个数
				int visibleItemCount = mLinearLayoutManager.getChildCount();
				//当前RecyclerView的所有子项个数
				int totalItemCount = mLinearLayoutManager.getItemCount();
				//RecyclerView的滑动状态
				int state = mrecycleView.getScrollState();
//				if(visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1 && state == mrecycleView.SCROLL_STATE_IDLE){
				if(visibleItemCount > 0 && lastVisibleItemPosition == totalItemCount - 1 ){

				   //最后一个


					//向下滚动
					if (dy > 0) {

						currentViewIndex=firstVisibleItem;

						//向上滚动
					} else if (dy < 0) {

						currentViewIndex=lastVisibleItemPosition;

					}

				}else {

					 currentViewIndex = firstVisibleItem;
				}



				if(currentViewIndex==0){

					mToolbar.setTitle("详情");

				}else if (currentViewIndex==1){

					mToolbar.setTitle("参数");

				}else if (currentViewIndex==2){

					mToolbar.setTitle("车型");

				}else if (currentViewIndex==3){

					mToolbar.setTitle("售后");

				}



			}
		});

		mrecycleView.addOnItemTouchListener(new RecyclerView.OnItemTouchListener() {
			@Override
			public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

				int x = (int) e.getX();
				int y = (int) e.getY();

				Log.e(TAG,"onInterceptTouchEvent ----> y="+y);
				switch (e.getAction()){
					/**
					 *  如果是ACTION_DOWN事件，那么记录当前按下的位置，
					 *  记录当前的系统时间。
					 */
					case MotionEvent.ACTION_DOWN:
//						mLastDownX = x;
//						mLastDownY = y;
//						mDownTime = System.currentTimeMillis();
//						isMove = false;
						break;
					/**
					 *  如果是ACTION_MOVE事件，此时根据TouchSlop判断用户在按下的时候是否滑动了，
					 *  如果滑动了，那么接下来将不处理点击事件
					 */
					case MotionEvent.ACTION_MOVE:
//						if(Math.abs(x - mLastDownX)>touchSlop || Math.abs(y - mLastDownY)>touchSlop){
//							isMove = true;
//						}


						int firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
						Log.e(TAG,"   firstVisibleItem=="+firstVisibleItem);






						break;
					/**
					 *  如果是ACTION_UP事件，那么根据isMove标志位来判断是否需要处理点击事件；
					 *  根据系统时间的差值来判断是哪种事件，如果按下事件超过1s，则认为是长按事件，
					 *  否则是单击事件。
					 */
					case MotionEvent.ACTION_UP:
//						if(isMove){
//							break;
//						}
//						if(System.currentTimeMillis()-mDownTime > 1000){
//							isLongPressUp = true;
//						}else {
//							isSingleTapUp = true;
//						}
						break;
				}



				return false;
			}

			@Override
			public void onTouchEvent(RecyclerView rv, MotionEvent e) {

			}

			@Override
			public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

			}
		});



	}



	public int getCurrentViewIndex() {
		int firstVisibleItem = mLinearLayoutManager.findFirstVisibleItemPosition();
		int lastVisibleItem = mLinearLayoutManager.findLastVisibleItemPosition();
		int currentIndex = firstVisibleItem;
		int lastHeight = 0;
		for (int i = firstVisibleItem; i <= lastVisibleItem; i++) {
			View view = mLinearLayoutManager.getChildAt(i - firstVisibleItem);
			if (null == view) {
				continue;
			}

			int[] location = new int[2];
			view.getLocationOnScreen(location);

			Rect localRect = new Rect();
			view.getLocalVisibleRect(localRect);

			int showHeight = localRect.bottom - localRect.top;
//			int showHeight = localRect.bottom ;
			if (showHeight > lastHeight) {
				currentIndex = i;
				lastHeight = showHeight;
			}

			Log.d(TAG,i+"   localRect.bottom=="+localRect.bottom);


		}

		if (currentIndex < 0) {
			currentIndex = 0;
		}

		return currentIndex;
	}


}
