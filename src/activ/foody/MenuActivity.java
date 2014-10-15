package activ.foody;

import activ.rest.AllRestaurantsActivity;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

/**
 * 
 * Menu window.With two buttons: "cuisines" and "restaurants".
 */
public class MenuActivity extends Activity {
	/**
	 * flag for Internet connection status.
	 */
	Boolean isInternetPresent = false;
	/**
	 * Connection detector class.
	 */
	instruments.ConnectionDetector cd;
	/**
	 * On create method, content intilization.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		/**
		 * No title on top.
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		super.onCreate(savedInstanceState);
		/**
		 * creating connection detector class instance.
		 */
		cd = new instruments.ConnectionDetector(getApplicationContext());
		/**
		 * get Internet status.
		 */
		isInternetPresent = cd.isConnectingToInternet();
		/**
		 * check for Internet status.
		 */
		if (isInternetPresent) {
			/**
			 * Set content view.
			 */
			setContentView(R.layout.menu);

		} else {
			/**
			 * Set content view.
			 */
			setContentView(R.layout.menu);
			/**
			 * Internet connection is not present
			 * Ask user to connect to Internet
			 */
			showAlertDialog(
					MenuActivity.this,
					"No Internet Connection",
					"Please connect to the internet.Data cannot be load or might be lost.",
					false);
		}

	}
	/**
	 * Only portrait view.
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
	/**
	 * Action when we click on restorans button. When we click this button , we
	 * go to the restorans window.
	 */
	public void cuisClick(View v) {
		finish();

		/**
		 * Start new intent.
		 */
		Intent in = new Intent(getApplicationContext(), CuisActivity.class);
		/**
		 * Starting new activity
		 */
		startActivity(in);
	}
	/**
	 * Action when we click on restorans button. When we click this button , we
	 * go to the restorans window.
	 */
	public void restClick(View v) {
		finish();
		/**
		 * Start new intent.
		 */
		Intent in = new Intent(getApplicationContext(),
				AllRestaurantsActivity.class);
		/**
		 * Starting new activity
		 */
		startActivity(in);
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
		 * Setting Dialog Title.
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
				setContentView(R.layout.menu);
			}
		});
		/**
		 * Showing Alert Message.
		 */
		alertDialog.show();
	}
}