package activ.foody;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Window;

/**
 * Welcome screen.
 */
public class WelcomeActivity extends Activity {
	/**
	 * Hold the length of time to keep the welcome screen up.
	 */
	private long splashDelay = 3500;

	/**
	 * Set content view in welcome layout.
	 */
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * No title on top
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		/**
		 * Welcome view
		 */
		setContentView(R.layout.welcome);
		/**
		 * Timer task. When time is up , going to the next screen.
		 */
		TimerTask task = new TimerTask() {
			public void run() {
				finish();
				Intent mainIntent = new Intent().setClass(WelcomeActivity.this,
						MenuActivity.class);
				startActivity(mainIntent);
			}
		};
		/**
		 * Timer object.
		 */
		Timer timer = new Timer();
		timer.schedule(task, splashDelay);
	}
	/**
	 * Only portrait view.
	 */
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
	}
}