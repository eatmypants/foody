package activ.foody;


import instruments.CustomPagerAdapter;
import activ.foody.R;
import activ.rest.CuisRestActivity;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

import android.support.v4.view.ViewPager;




public class CuisActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		if (getIntent().getBooleanExtra("finish", false))
			finish();
		setContentView(R.layout.cuisine);

		// Create and set adapter
		CustomPagerAdapter adapter = new CustomPagerAdapter();
		ViewPager myPager = (ViewPager) findViewById(R.id.customviewpager);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);

	}
	
	public void clickCuis(View v)
	{
	
	
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
	}

	public void back(View v)
	{
		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
	}



}
