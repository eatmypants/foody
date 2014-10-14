package activ.foody;

import instruments.CustomPagerAdapter;
import activ.foody.R;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.support.v4.view.ViewPager;
/**
 * Screen with cuisines.
 */
public class CuisActivity extends Activity
{
	/**
	 * Oncreate method. Content and view initilization.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{ 
		/**
		 * No title on top of the screen.
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		/**
		 * Set content view.
		 */
		setContentView(R.layout.cuisine);
		/**
		 * Create and set adapter.
		 */
		CustomPagerAdapter adapter = new CustomPagerAdapter();
		ViewPager myPager = (ViewPager) findViewById(R.id.customviewpager);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);
	}
	/**
	 * When some of cuisines was clicked.
	 */
	public void clickCuis(View v)
	{
	}
	/**
	 * Only portrait view.
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig)
	{
		super.onConfigurationChanged(newConfig);
	}
	/**
	 * When back button was clicked opened menu screen.
	 */
	public void back(View v)
	{
		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
	}
}
