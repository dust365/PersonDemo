package com.example.dust.persondemo.activity;

import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.example.dust.persondemo.R;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class DesignDetialActivity extends AppCompatActivity {

    private static final String TAG = DesignDetialActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_design_detial);

        CollapsingToolbarLayout collToolBar = (CollapsingToolbarLayout) findViewById(R.id.coll_toolbar);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar2);

        setSupportActionBar(toolbar);

        android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collToolBar.setTitle("详情页面");



             testRxjava();



    }



    private void testRxjava() {



//        //创建一个上游 Observable：
//        Observable<Integer> observable = Observable.create(new ObservableOnSubscribe<Integer>() {
//            @Override
//            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
//                emitter.onNext(1);
//                emitter.onNext(2);
//                emitter.onNext(3);
//                emitter.onComplete();
//
//                emitter.onNext(43);
////                Throwable throwable = new Throwable("错误");
////                emitter.onError(throwable);
//
//                /**
//                 *   onComplete     onError  二者互斥不能同时存在
//                 */
//
//            }
//        });
//        //创建一个下游 Observer
//        Observer<Integer> observer = new Observer<Integer>() {
//            @Override
//            public void onSubscribe(Disposable d) {
//                Log.d(TAG, "subscribe");
//            }
//
//            @Override
//            public void onNext(Integer value) {
//                Log.d(TAG, "" + value);
//            }
//
//            @Override
//            public void onError(Throwable e) {
//                Log.d(TAG, "error");
//            }
//
//            @Override
//            public void onComplete() {
//                Log.d(TAG, "complete");
//            }
//        };
//        //建立连接
//        observable.subscribe(observer);

  Observable.create(new ObservableOnSubscribe<Integer>() {
      @Override
      public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {

          Log.d(TAG, "emit 1");
          emitter.onNext(1);
          Log.d(TAG, "emit 2");
          emitter.onNext(2);
          Log.d(TAG, "emit 3");
          emitter.onNext(3);
          Log.d(TAG, "emit complete");
          emitter.onComplete();
          Log.d(TAG, "emit 4");
          emitter.onNext(4);

      }
  }).subscribe(new Observer<Integer>() {
      @Override
      public void onSubscribe(Disposable d) {

      }

      @Override
      public void onNext(Integer integer) {
          Log.d(TAG, "onNext" + integer);
      }

      @Override
      public void onError(Throwable e) {
          Log.d(TAG, "onError" + e);
      }

      @Override
      public void onComplete() {

          Log.d(TAG, "onComplete" );

      }
  });






    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){
            case  android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
