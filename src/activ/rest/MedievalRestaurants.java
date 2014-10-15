package activ.rest;

import instruments.JSONParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import activ.foody.R;
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

/**
 * All restaurants activity with list of all restaurants.
 */
public class MedievalRestaurants extends ListActivity {
	/**
	 * flag for Internet connection status.
	 */
	Boolean isInternetPresent = false;
	/**
	 * Connection detector class.
	 */
	instruments.ConnectionDetector cd3;
	/**
	 * Progress Dialog.
	 */
	private ProgressDialog pDialog;
	/**
	 * Creating JSON Parser object.
	 */
	JSONParser jParser = new JSONParser();
	/**
	 * Restaurants list.
	 */
	ArrayList<HashMap<String, Object>> restaurantsList;
	/**
	 * Url to get all restaurants list.
	 */
	private static String url_all_restaurants = "http://foodyapp.890m.com//android_connect/get_medieval_restaurants.php";
	/**
	 * JSON Node names.
	 */
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_restaurants = "restaurant";
	private static final String TAG_rest_id = "rest_id";
	private static final String TAG_NAME = "name";
	private static final String TAG_AVATAR = "avatar_image_url";
	private static final String TAG_CUI = "cuisine";
	/**
	 * restaurants JSONArray.
	 */
	JSONArray restaurants = null;

	/**
	 * On create method, content and view intilization.
	 */
	@Override
	public void onCreate(Bundle savedInstanceState) {

		/**
		 * No title on top
		 */
		requestWindowFeature(Window.FEATURE_NO_TITLE);

		super.onCreate(savedInstanceState);
		/**
		 * Check connection of internet.
		 */
		checkConnection();
		/**
		 * Initialization of objects.
		 */
		initialization();
	}
	/**
	 * Check internet connection.
	 */
	public void checkConnection() {
		/**
		 * creating connection detector class instance
		 */
		cd3 = new instruments.ConnectionDetector(getApplicationContext());
		/**
		 * get Internet status.
		 */
		isInternetPresent = cd3.isConnectingToInternet();
		/**
		 * check for Internet status.
		 */
		if (isInternetPresent) {
			/**
			 * Set content view.
			 */
			setContentView(R.layout.all_restaurants);

		} else {
			/**
			 * Set content view.
			 */
			setContentView(R.layout.all_restaurants);
			/**
			 * Internet connection is not present
			 *  Ask user to connect to Internet
			 */
			showAlertDialog(
					MedievalRestaurants.this,
					"No Internet Connection",
					"Please connect to the internet.Data cannot be load or might be lost.",
					false);

		}

	}
	/**
	 * Initialization of objects.
	 */
	public void initialization() {

		/**
		 * Hashmap for ListView.
		 */
		restaurantsList = new ArrayList<HashMap<String, Object>>();
		/**
		 * Loading restaurants in Background Thread.
		 */
		new LoadAllrestaurants().execute();
		/**
		 * Get listview.
		 */
		ListView lv = getListView();
		/**
		 * on seleting single restaurant launching restaurant information Screen
		 */
		lv.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				/**
				 * Getting values from selected ListItem.
				 */
				String rest_id = ((TextView) view.findViewById(R.id.rest_id))
						.getText().toString();
				/**
				 * Starting new intent.
				 */
				Intent in = new Intent(getApplicationContext(),
						RestInfoActivity.class);
				/**
				 * Sending rest_id to next activity.
				 */
				in.putExtra(TAG_rest_id, rest_id);
				/**
				 * Starting new activity.
				 */
				startActivity(in);
			}
		});
	}

	/**
	 * Background Async Task to Load all restaurant by making HTTP Request
	 * */
	class LoadAllrestaurants extends AsyncTask<String, String, String> {
		/**
		 * Before starting background thread Show Progress Dialog
		 * */
		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pDialog = new ProgressDialog(MedievalRestaurants.this);
			pDialog.setMessage("Loading. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * getting All restaurants from url
		 * */
		protected String doInBackground(String... args) {
			/**
			 * Building Parameters.
			 */
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			/**
			 * Getting JSON string from URL.
			 */
			JSONObject json = jParser.makeHttpRequest(url_all_restaurants,
					"GET", params);
			/**
			 * Check log cat for JSON reponse.
			 */
			Log.d("All restaurants: ", json.toString());
			try {
				/**
				 * Checking for SUCCESS TAG.
				 */
				int success = json.getInt(TAG_SUCCESS);
				if (success == 1) {
					/**
					 * Restaurants found. Getting Array of restaurants.
					 */
					restaurants = json.getJSONArray(TAG_restaurants);
					/**
					 * Looping through All restaurants.
					 */
					for (int i = 0; i < restaurants.length(); i++) {
						JSONObject c = restaurants.getJSONObject(i);
						/**
						 * Storing each json item in variable.
						 */
						String id = c.getString(TAG_rest_id);
						String name = c.getString(TAG_NAME);
						String cuisine = c.getString(TAG_CUI);

						/**
						 * Creating new HashMap.
						 */
						HashMap<String, Object> map = new HashMap<String, Object>();
						int rest_id = Integer.parseInt(id);
						/**
						 * Put avatar picture to each resaurant depends on restaurant id.
						 */
						int avatar = 0;
						if (rest_id == 1) {
							avatar = R.drawable.vapiano;
						}
						if (rest_id == 2) {
							avatar = R.drawable.bastion;
						}
						if (rest_id == 3) {
							avatar = R.drawable.peetri;
						}
						if (rest_id == 4) {
							avatar = R.drawable.americana;
						}
						if (rest_id == 5) {
							avatar = R.drawable.troika;
						}
						if (rest_id == 6) {
							avatar = R.drawable.peppersack;
						}
						if (rest_id == 7) {
							avatar = R.drawable.mysushi;
						}
						if (rest_id == 8) {
							avatar = R.drawable.sushipanda;
						}
						if (rest_id == 9) {
							avatar = R.drawable.lusikas;
						}
						/**
						 * Adding each child node to HashMap key => value.
						 */
						map.put(TAG_rest_id, id);
						map.put(TAG_NAME, name);
						map.put(TAG_CUI, cuisine);
						map.put(TAG_AVATAR, avatar);
						/**
						 * Adding HashList to ArrayList.
						 */
						restaurantsList.add(map);
					}
				} else {
				}
			} catch (JSONException e) {
				e.printStackTrace();
			}
			return null;
		}

		/**
		 * After completing background task Dismiss the progress dialog
		 * **/
		protected void onPostExecute(String file_url) {
			/**
			 * Dismiss the dialog after getting all restaurants.
			 */
			pDialog.dismiss();
			/**
			 * Updating UI from Background Thread.
			 */
			runOnUiThread(new Runnable() {
				public void run() {
					/**
					 * Updating parsed JSON data into ListView
					 * */
					ListAdapter adapter = new SimpleAdapter(
							MedievalRestaurants.this, restaurantsList,
							R.layout.list_item, new String[] { TAG_rest_id,
									TAG_NAME, TAG_AVATAR }, new int[] {
									R.id.rest_id, R.id.name, R.id.avatar });
					/**
					 * Updating listview.
					 */
					setListAdapter(adapter);
				}
			});
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
	 * Back button was pressed. Menu screen started.
	 */
	public void back(View v) {
		finish();

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
				setContentView(R.layout.all_restaurants);
				initialization();

			}
		});
		/**
		 * Showing Alert Message.
		 */
		alertDialog.show();
	}

}