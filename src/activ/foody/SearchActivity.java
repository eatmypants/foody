package activ.foody;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;
/**
 * Searching window.
 */
public class SearchActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		/**
		 * Without title on top.
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		/**
		 * Set content view.
		 */
		setContentView(R.layout.search);
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
