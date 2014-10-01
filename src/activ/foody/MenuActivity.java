package activ.foody;



import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
/**
 * Menu window.
 */
public class MenuActivity extends Activity
{
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
		/**
		 * No title on top.
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		/**
		 * Set content view.
		 */
		setContentView(R.layout.menu);
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
	 * Action when we click on cuisines button.
	 * When we click this button , we go to the cuisines window.
	 */
	public void cuisClick(View v)
	{
		Intent intent = new Intent(this, CuisActivity.class);
		startActivity(intent);
	}
	/**
	 * Action when we click on search button.
	 * When we click this button , we go to the searching window.
	 */
	public void searchClick(View v)
	{
		Intent intent = new Intent(this, SearchActivity.class);
		startActivity(intent);
	}
	/**
	 * Action when we click on restorans button.
	 * When we click this button , we go to the restorans window.
	 */
	public void restClick(View v)
	{
		Intent intent = new Intent(this, RestActivity.class);
		startActivity(intent);
	}
	
}