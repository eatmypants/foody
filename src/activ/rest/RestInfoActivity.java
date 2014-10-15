package activ.rest;

import instruments.JSONParser;
<<<<<<< HEAD


import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

=======
import java.util.ArrayList;
import java.util.List;
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
<<<<<<< HEAD

import activ.foody.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
=======
import activ.foody.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
<<<<<<< HEAD
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Screen with restaurant information.
 */
public class RestInfoActivity extends Activity

{
	/**
	 * flag for Internet connection status.
	 */
	Boolean isInternetPresent = false;
	/**
	 * Connection detector class.
	 */
	instruments.ConnectionDetector cd4;
	/**
	 * Text views where information were going to be put. Avarage price of the
	 * restaurant.
=======
import android.widget.TextView;
/**
 *Screen with restaurant information.
 */
public class RestInfoActivity extends Activity
{
	/**
	 * Text views where information were going to be put.
	 * Avarage price of the restaurant.
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
	 */
	TextView txtPrice;
	/**
	 * Description of the restaurant.
	 */
	TextView txtDesc;
	/**
	 * Web page of the restaurant.
	 */
	TextView txtLink;
	/**
	 * Location of the restaurant.
	 */
	TextView txtLocation;
	/**
	 * Restaurant id.
	 */
	String rest_id;
	/**
	 * Progress Dialog.
	 */
	private ProgressDialog pDialog;
	/**
	 * JSON parser class.
	 */
	JSONParser jsonParser = new JSONParser();
	/**
	 * Single restaurant url.
	 */
	private static final String url_restaurant_detials = "http://foodyapp.890m.com//android_connect/get_rest_details.php";
	/**
	 * JSON Node names.
	 */
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_RESTAURANTS = "restaurant";
	private static final String TAG_RES_ID = "rest_id";
	private static final String TAG_AVG_PRICE = "avg_price";
	private static final String TAG_DESCRIPTION = "description";
	private static final String TAG_LOCATION = "location";
	private static final String TAG_LINK = "link";
<<<<<<< HEAD
	private static final String TAG_PHOTO = "main_image_url";

=======
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
	/**
	 * On create method. Initilization of content and view.
	 */
	@Override
<<<<<<< HEAD
	public void onCreate(Bundle savedInstanceState) {

=======
	public void onCreate(Bundle savedInstanceState) 
	{
		super.onCreate(savedInstanceState);
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
		/**
		 * No title on top
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);
<<<<<<< HEAD
		super.onCreate(savedInstanceState);
		/**
		 * Check internet connection.
		 */
		checkConnection();
		/**
		 * Initialization objects.
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
		cd4 = new instruments.ConnectionDetector(getApplicationContext());
		/**
		 * get Internet status.
		 */
		isInternetPresent = cd4.isConnectingToInternet();
		/**
		 * check for Internet status.
		 */
		if (isInternetPresent) {
			/**
			 * Set content view.
			 */
			setContentView(R.layout.restinfo);

		} else {
			/**
			 * Set content view.
			 */
			setContentView(R.layout.restinfo);
            /**
             * Internet connection is not present
             * Ask user to connect to Internet
             */
			showAlertDialog(
					RestInfoActivity.this,
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
		 * Main restaurant image.
		 */
		mainImage = (ImageView) findViewById(R.id.mainImage);

		/**
		 * Find text views by id. Description.
		 */
		TextView desc = (TextView) findViewById(R.id.inputDesc);
		/**
		 * Price label.
		 */
		TextView price = (TextView) findViewById(R.id.price);
		/**
		 * Location label.
		 */
		TextView location = (TextView) findViewById(R.id.location);
		/**
		 * Price.
		 */
		TextView inputprice = (TextView) findViewById(R.id.inputPrice);
		/**
		 * Location.
		 */
		TextView inputlocation = (TextView) findViewById(R.id.inputLocation);
		/**
		 * Link label.
		 */
		TextView link = (TextView) findViewById(R.id.link);
		/**
		 * Link.
		 */
		TextView inputlink = (TextView) findViewById(R.id.inputLink);
		/**
		 * EUR.
		 */
		TextView EUR = (TextView) findViewById(R.id.EUR);
		/**
		 * Comments label.
		 */
		TextView comments = (TextView) findViewById(R.id.comments);
		/**
		 * Comments.
		 */
		TextView inputcomments = (TextView) findViewById(R.id.inputComments);
		/**
		 * Fon creation.
		 */
		Typeface custom_font = Typeface.createFromAsset(getAssets(),
				"fonts/koz.otf");
		/**
		 * Put all textviews with koz.otf font.
		 */
		desc.setTypeface(custom_font);
		link.setTypeface(custom_font);
		EUR.setTypeface(custom_font);
		inputlink.setTypeface(custom_font);
		comments.setTypeface(custom_font);
		inputcomments.setTypeface(custom_font);
		price.setTypeface(custom_font);
		location.setTypeface(custom_font);
		inputprice.setTypeface(custom_font);
		inputlocation.setTypeface(custom_font);
		/**
		 * Getting restaurant details from intent.
		 */
		Intent i = getIntent();
		/**
		 * Getting restaurant id (rest_id) from intent.
		 */
		rest_id = i.getStringExtra(TAG_RES_ID);

		/**
		 * Getting complete restaurant details in background thread.
		 */
		new GetRestDetails().execute();

	}

	/**
	 * Background Async Task to Get complete restaurant details
	 */
	class GetRestDetails extends AsyncTask<String, String, String> {
=======
		/**
		 * Set content view.
		 */
		setContentView(R.layout.restinfo);
		/**
		 * Find text views by id.
		 * Description.
		 */
		TextView desc = (TextView)findViewById(R.id.inputDesc);
		/**
		 * Price label.
		 */
		 TextView price = (TextView)findViewById(R.id.price);
		 /**
		  * Location label.
		  */
	     TextView location = (TextView)findViewById(R.id.location);
	     /**
	      * Price.
	      */
	     TextView inputprice = (TextView)findViewById(R.id.inputPrice);
	     /**
	      * Location.
	      */
	      TextView inputlocation = (TextView)findViewById(R.id.inputLocation);
	      /**
	       * Link label.
	       */
	      TextView link= (TextView)findViewById(R.id.link);
	      /**
	       * Link.
	       */
	      TextView inputlink = (TextView)findViewById(R.id.inputLink);
	      /**
	       * EUR.
	       */
	      TextView EUR = (TextView)findViewById(R.id.EUR);
	      /**
	       * Comments label.
	       */
	      TextView comments= (TextView)findViewById(R.id.comments);
	      /**
	       * Comments.
	       */
	      TextView inputcomments = (TextView)findViewById(R.id.inputComments);
	      /**
	       * Fon creation.
	       */
	      Typeface custom_font = Typeface.createFromAsset(getAssets(),"fonts/koz.otf");
	      /**
	       * Put all textviews with koz.otf font.
	       */
	      desc.setTypeface(custom_font);
	      link.setTypeface(custom_font);
	      EUR.setTypeface(custom_font);
	      inputlink.setTypeface(custom_font);
	      comments.setTypeface(custom_font); 
	      inputcomments.setTypeface(custom_font);
	      price.setTypeface(custom_font);
	      location.setTypeface(custom_font);
	      inputprice.setTypeface(custom_font); 
	      inputlocation.setTypeface(custom_font);
	      /**
	       * Getting restaurant details from intent.
	       */
	      Intent i = getIntent();
	      /**
	       * Getting restaurant id (rest_id) from intent.
	       */
	      rest_id = i.getStringExtra(TAG_RES_ID);
	      /**
	       * Getting complete restaurant details in background thread.
	       */
	      new GetRestDetails().execute();
	 }
	/**
	* Background Async Task to Get complete restaurant details
	*/
	class GetRestDetails extends AsyncTask<String, String, String> 
	{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
<<<<<<< HEAD
		protected void onPreExecute() {
=======
		protected void onPreExecute() 
		{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
			super.onPreExecute();
			pDialog = new ProgressDialog(RestInfoActivity.this);
			pDialog.setMessage("Loading rest details. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}
<<<<<<< HEAD

		/**
		 * Getting restaurant details in background thread
		 * */
		protected String doInBackground(String... params) {
			/**
			 * Updating UI from Background Thread.
			 */
			runOnUiThread(new Runnable() {
				public void run() {
=======
		/**
		 * Getting restaurant details in background thread
		 * */
		protected String doInBackground(String... params) 
		{
			/**
			 * Updating UI from Background Thread.
			 */
			runOnUiThread(new Runnable() 
			{
				public void run() 
				{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
					/**
					 * Check for success tag.
					 */
					int success;
<<<<<<< HEAD
					try {
=======
					try 
					{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
						/**
						 * Building Parameters..
						 */
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("rest_id", rest_id));
						/**
						 * Getting restaurant details by making HTTP request.
<<<<<<< HEAD
						 * Note that restaurant details url will use GET
						 * request.
						 */
						JSONObject json = jsonParser.makeHttpRequest(
								url_restaurant_detials, "GET", params);
						/**
						 * Check log for json response.
=======
						 * Note that restaurant details url will use GET request.
						 */
						JSONObject json = jsonParser.makeHttpRequest(url_restaurant_detials, "GET", params);
						/**
						 * Check  log for json response.
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
						 */
						Log.d("Single Rest Details", json.toString());
						/**
						 * Json success tag.
						 */
						success = json.getInt(TAG_SUCCESS);
<<<<<<< HEAD
						if (success == 1) {
							/**
							 * Successfully received restaurant details. JSON
							 * Array.
							 */
							JSONArray restaurantObj = json
									.getJSONArray(TAG_RESTAURANTS);
=======
						if (success == 1) 
						{
							/**
							 * Successfully received restaurant details.
							 * JSON Array.
							 */
							JSONArray restaurantObj = json.getJSONArray(TAG_RESTAURANTS); 
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
							/**
							 * Get first restaurant object from JSON Array.
							 * restaurant with this rest_id found.
							 */
<<<<<<< HEAD
							JSONObject restaurant = restaurantObj
									.getJSONObject(0);
							/**
							 * Put in variables textview objects.
							 */
							String PhotoUrl = restaurant.getString(TAG_PHOTO);
							new LoadImage().execute(PhotoUrl);
=======
							JSONObject restaurant = restaurantObj.getJSONObject(0);
							/**
							 * Put in variables textview objects.
							 */
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
							txtPrice = (TextView) findViewById(R.id.inputPrice);
							txtDesc = (TextView) findViewById(R.id.inputDesc);
							txtLocation = (TextView) findViewById(R.id.inputLocation);
							txtLink = (TextView) findViewById(R.id.inputLink);
<<<<<<< HEAD
							txtPrice.setText(restaurant
									.getString(TAG_AVG_PRICE));
							txtDesc.setText(restaurant
									.getString(TAG_DESCRIPTION));
							txtLocation.setText(restaurant
									.getString(TAG_LOCATION));
							txtLink.setText(restaurant.getString(TAG_LINK));

						} 
					} catch (JSONException e) {
=======
							txtPrice.setText(restaurant.getString(TAG_AVG_PRICE ));
							txtDesc.setText(restaurant.getString(TAG_DESCRIPTION));
							txtLocation.setText(restaurant.getString(TAG_LOCATION));
							txtLink.setText(restaurant.getString(TAG_LINK));
						}else
						{
							// restaurant with rest_id not found
						}
					}catch (JSONException e) 
					{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
						e.printStackTrace();
					}
				}
			});
			return null;
		}
<<<<<<< HEAD

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
=======
		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) 
		{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
			/**
			 * Dismiss the dialog once got all details.
			 */
			pDialog.dismiss();
		}
	}
	/**
	 * Back button pressed. Go back to the all restaurant list.
<<<<<<< HEAD
	 */
	public void back(View v) {
		finish();

	}
	/**
	 * Main image .
	 */
	ImageView mainImage;
	/**
	 * Bitmap object.
	 */
	Bitmap bitmap;
	/**
	 *Load image from url using bitmap.
	 */
	private class LoadImage extends AsyncTask<String, String, Bitmap> {
		protected Bitmap doInBackground(String... args) {
			try {
				bitmap = BitmapFactory.decodeStream((InputStream) new URL(
						args[0]).getContent());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return bitmap;
		}
		/**
		 * Set image.
		 */
		protected void onPostExecute(Bitmap image) {
			if (image != null) {
				mainImage.setImageBitmap(image);

			} 
			/**
			 * If now image was found , put empty image.
			 */
			else {
				mainImage.setImageResource(R.drawable.empty);
			}
		}
	}

=======
	 * @param v
	 */
	public void back(View v)
	{
		this.finish();
		Intent intent = new Intent(this, AllRestaurantsActivity.class);
		startActivity(intent);
	}
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
	/**
	 * Only portrait view.
	 */
	@Override
<<<<<<< HEAD
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
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
				setContentView(R.layout.restinfo);
				/**
				 * Initialization objects.
				 */
				initialization();

			}
		});
		/**
		 * Showing Alert Message.
		 */
		alertDialog.show();
	}

=======
	public void onConfigurationChanged(Configuration newConfig) 
	{  
		super.onConfigurationChanged(newConfig);  
	}
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
}
