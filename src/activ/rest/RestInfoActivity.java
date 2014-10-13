package activ.rest;

import instruments.JSONParser;



import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;



import activ.foody.R;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;

public class RestInfoActivity extends Activity {

	TextView txtName;
	TextView txtPrice;
	TextView txtDesc;
	TextView txtLink;
	TextView txtLocation;
	EditText TextView;


	String rest_id;

	// Progress Dialog
	private ProgressDialog pDialog;

	// JSON parser class
	JSONParser jsonParser = new JSONParser();

	// single restaurant url
	private static final String url_restaurant_detials = "http://foodyapp.890m.com//android_connect/get_rest_details.php";


	// JSON Node names
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_RESTAURANTS = "restaurant";
	private static final String TAG_RES_ID = "rest_id";
	private static final String TAG_AVG_PRICE = "avg_price";
	private static final String TAG_DESCRIPTION = "description";
	private static final String TAG_LOCATION = "location";
	private static final String TAG_LINK = "link";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * No title on top
		 */
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.restinfo);

		TextView desc = (TextView)findViewById(R.id.inputDesc);
	      Typeface custom_font = Typeface.createFromAsset(getAssets(),
	      "fonts/koz.otf");
	      desc.setTypeface(custom_font);
	      
	      TextView price = (TextView)findViewById(R.id.price);
	      TextView location = (TextView)findViewById(R.id.location);
	  
	      TextView inputprice = (TextView)findViewById(R.id.inputPrice);
	      TextView inputlocation = (TextView)findViewById(R.id.inputLocation);
	   
	      
	 
	      
	      price.setTypeface(custom_font);
	      location.setTypeface(custom_font);
	 
	      inputprice.setTypeface(custom_font); 
	      inputlocation.setTypeface(custom_font);
	  
		// getting restaurant details from intent
		Intent i = getIntent();
		
		// getting restaurant id (rest_id) from intent
		rest_id = i.getStringExtra(TAG_RES_ID);

		// Getting complete restaurant details in background thread
		new GetRestDetails().execute();

	


	}

	/**
	 * Background Async Task to Get complete restaurant details
	 * */
	class GetRestDetails extends AsyncTask<String, String, String> {

		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(RestInfoActivity.this);
			pDialog.setMessage("Loading rest details. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(true);
			pDialog.show();
		}

		/**
		 * Getting restaurant details in background thread
		 * */
		protected String doInBackground(String... params) {

			// updating UI from Background Thread
			runOnUiThread(new Runnable() {
				public void run() {
					// Check for success tag
					int success;
					try {
						// Building Parameters
						List<NameValuePair> params = new ArrayList<NameValuePair>();
						params.add(new BasicNameValuePair("rest_id", rest_id));

						// getting restaurant details by making HTTP request
						// Note that restaurant details url will use GET request
						JSONObject json = jsonParser.makeHttpRequest(
								url_restaurant_detials, "GET", params);

						// check your log for json response
						Log.d("Single Rest Details", json.toString());
						
						// json success tag
						success = json.getInt(TAG_SUCCESS);
						if (success == 1) {
							// successfully received restaurant details
							JSONArray restaurantObj = json
									.getJSONArray(TAG_RESTAURANTS); // JSON Array
							
							// get first restaurant object from JSON Array
							JSONObject restaurant = restaurantObj.getJSONObject(0);

							// restaurant with this rest_id found
							// Edit Text
							
							txtPrice = (TextView) findViewById(R.id.inputPrice);
							txtDesc = (TextView) findViewById(R.id.inputDesc);
							
							txtLocation = (TextView) findViewById(R.id.inputLocation);
							
							txtPrice.setText(restaurant.getString(TAG_AVG_PRICE));
							txtDesc.setText(restaurant.getString(TAG_DESCRIPTION));
					;
							txtLocation.setText(restaurant.getString(TAG_LOCATION));

						}else{
							// restaurant with rest_id not found
						}
					} catch (JSONException e) {
						e.printStackTrace();
					}
				}
			});

			return null;
		}


		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			// dismiss the dialog once got all details
			pDialog.dismiss();
		}
	}
	
	public void back(View v)
	{
		this.finish();
		Intent intent = new Intent(this, AllRestaurantsActivity.class);
		
		startActivity(intent);
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
