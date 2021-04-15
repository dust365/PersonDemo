package com.example.dust.persondemo.activity;

import android.content.Intent;
//import android.support.design.widget.CollapsingToolbarLayout;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.example.dust.persondemo.R;
import com.google.android.material.appbar.CollapsingToolbarLayout;

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

        ActionBar actionBar = getSupportActionBar();
        if(actionBar!=null) {

            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        collToolBar.setTitle("详情页面");



             testRxjava();




        findViewById(R.id.tv_1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DesignDetialActivity.this, SecondActivity.class);
                intent.putExtra(SecondActivity.STATE_TYPE,"1");
                startActivity(intent);



            }
        });

        findViewById(R.id.tv_2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(DesignDetialActivity.this, SecondActivity.class);
                intent.putExtra(SecondActivity.STATE_TYPE,"2");
                startActivity(intent);

            }
        });

        findViewById(R.id.tv_3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DesignDetialActivity.this, SecondActivity.class);
                intent.putExtra(SecondActivity.STATE_TYPE,"3");
                startActivity(intent);


            }
        });

        findViewById(R.id.tv_4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DesignDetialActivity.this, SecondActivity.class);
                intent.putExtra(SecondActivity.STATE_TYPE,"4");
                startActivity(intent);



            }
        });
        findViewById(R.id.tv_5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(DesignDetialActivity.this, SecondActivity.class);
                intent.putExtra(SecondActivity.STATE_TYPE,"5");
                startActivity(intent);


            }
        });



    }



    private void testRxjava() {


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
