package activ.foody;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
/**
 * Cuisines window.
 */
public class CuisActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		/**
		 * Wihtout title on top.
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		/**
		 * Set content view.
		 */
		setContentView(R.layout.cuisine);
	}
	/**
	 * Only portrait view.
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) 
	{  
		super.onConfigurationChanged(newConfig);  
	}
}
