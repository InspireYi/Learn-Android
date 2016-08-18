package com.test.activitytest;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;

public class SecondActivity extends BaseActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		Log.d("SecondActivity", "Task id is " + getTaskId());
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.second_layout);
		Button button2 = (Button)findViewById(R.id.button_2);
		button2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
				startActivity(intent);
			}
		});
	}
	
	public static void actionStart(Context context,String data1,String data2){
		Intent intent = new Intent(context,SecondActivity.class);
		intent.putExtra("param1", data1);
		intent.putExtra("param2", data2);
		context.startActivity(intent);
	}
	
	@Override
	protected void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		Log.d("SecondActivity", "onDestroy");
	}
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent intent = new Intent();
		intent.putExtra("data_return", "Hello FirstActivity");
		setResult(RESULT_OK,intent);
		finish();
	}
}
