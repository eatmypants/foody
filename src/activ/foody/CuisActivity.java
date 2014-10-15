package activ.foody;

import instruments.CustomPagerAdapter;
import activ.foody.R;
import activ.rest.FrenchRestaurants;
import activ.rest.ItalianRestaurants;
import activ.rest.JapaneseRestaurants;
import activ.rest.MedievalRestaurants;
import activ.rest.PizzaRestaurants;
import activ.rest.RussianRestaurants;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.support.v4.view.ViewPager;

/**
 * Screen with cuisines.
 */
public class CuisActivity extends Activity {

	/**
	 * flag for Internet connection status.
	 */
	Boolean isInternetPresent = false;

	/**
	 *  Connection detector class.
	 */
	instruments.ConnectionDetector cd2;

	/**
	 * Oncreate method. Content and view initialization.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		/**
		 * No title on top of the screen.
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		/**
		 * Check if internet is turn on.
		 */
		checkConnection();
		/**
		 * Initialize objects.
		 */
		initialization();

	}
	/**
	 * Check internet connection.
	 */
	public void checkConnection() {

		/**
		 * creating connection detector class instance.
		 */
		cd2 = new instruments.ConnectionDetector(getApplicationContext());
		/**
		 * get Internet status.
		 */
		isInternetPresent = cd2.isConnectingToInternet();
		/**
		 * check for Internet status.
		 */
		if (isInternetPresent) {
			/**
			 * Set content view.
			 */
			setContentView(R.layout.cuisine);

		} else {
			/**
			 * Set content view.
			 */
			setContentView(R.layout.cuisine);
			/**
			 * Internet connection is not present
			 * Error message.
			 */
			showAlertDialog(
					CuisActivity.this,
					"No Internet Connection",
					"Please connect to the internet.Data cannot be load or might be lost.",
					false);

		}

	}
	/**
	 * Objects initialization.
	 */
	public void initialization() {
		/**
		 * Create and set adapter.
		 */
		CustomPagerAdapter adapter = new CustomPagerAdapter();
		ViewPager myPager = (ViewPager) findViewById(R.id.customviewpager);
		myPager.setAdapter(adapter);
		myPager.setCurrentItem(0);
	}
	/**
	 * Only portrait view.
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	/**
	 * When back button was clicked opened menu screen.
	 */
	public void back(View v) {
		finish();
		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
	}
	/**
	 * All this going to be changed in 2 iteration.
	 * Click to pizza cuisine , move to all pizza restaurants.
	 */
	public void clickPizza(View v) {

		Intent intent = new Intent(this, PizzaRestaurants.class);
		startActivity(intent);
	}
	/**
	 * Click to italian cuisine , move to italian restaurants.
	 */
	public void clickItalian(View v) {

		Intent intent = new Intent(this, ItalianRestaurants.class);
		startActivity(intent);
	}
	/**
	 * Click to japanese cuisine, move to japanese restaurants.
	 */
	public void clickJapanese(View v) {

		Intent intent = new Intent(this, JapaneseRestaurants.class);
		startActivity(intent);
	}
	/**
	 * Click to medieval cuisine, move to medieval restaurants.
	 */
	public void clickMedieval(View v) {

		Intent intent = new Intent(this, MedievalRestaurants.class);
		startActivity(intent);
	}
	/**
	 * Click to russian cuisine,move to russian restaurants.
	 * @param v
	 */
	public void clickRussian(View v) {

		Intent intent = new Intent(this, RussianRestaurants.class);
		startActivity(intent);
	}
	/**
	 * Click to french cuisine, move to french restaurants.
	 * @param v
	 */
	public void clickFrench(View v) {

		Intent intent = new Intent(this, FrenchRestaurants.class);
		startActivity(intent);
	}
	/**
	 * Function to display simple Alert Dialog
	 * 
	 * @param context
	 *            - application context
	 * @param title
	 *            - alert dialog title
	 * @param message
	 *            - alert message
	 * */
	@SuppressWarnings("deprecation")
	public void showAlertDialog(Context context, String title, String message,
			Boolean status) {
		AlertDialog alertDialog = new AlertDialog.Builder(context).create();
		/**
		 * Setting Dialog Title
		 */
		alertDialog.setTitle(title);
		/**
		 * Setting Dialog Message.
		 */
		alertDialog.setMessage(message);
		/**
		 * Setting OK Button.
		 */
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				/**
				 * Set content view.
				 */
				setContentView(R.layout.cuisine);
				initialization();
			}
		});
		/**
		 * Showing Alert Message.
		 */
		alertDialog.show();
	}

}
