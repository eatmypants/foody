package activ.foody;

import instruments.JSONParser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;






import android.app.ListActivity;
import android.app.ProgressDialog;
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

public class AllRestaurantsActivity extends ListActivity {

	// Progress Dialog
	private ProgressDialog pDialog;

	// Creating JSON Parser object
	JSONParser jParser = new JSONParser();

	ArrayList<HashMap<String, String>> restaurantsList;

	// url to get all restaurants list
	private static String url_all_restaurants = "http://foodyapp.890m.com//android_connect/get_all_restaurants.php";

	// JSON Node names
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_restaurants = "restaurant";
	private static final String TAG_rest_id = "rest_id";
	private static final String TAG_NAME = "name";

	// restaurants JSONArray
	JSONArray restaurants = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/**
		 * No title on top
		 */
			requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.all_restaurants);

		// Hashmap for ListView
		restaurantsList = new ArrayList<HashMap<String, String>>();

		// Loading restaurants in Background Thread
		new LoadAllrestaurants().execute();

		// Get listview
		ListView lv = getListView();

		// on seleting single restaurant
		// launching Edit restaurant Screen
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// getting values from selected ListItem
				String rest_id = ((TextView) view.findViewById(R.id.rest_id)).getText()
						.toString();

				// Starting new intent
				Intent in = new Intent(getApplicationContext(),
						RestInfoActivity.class);
				// sending rest_id to next activity
				in.putExtra(TAG_rest_id, rest_id);
				
				// starting new activity and expecting some response back
				startActivityForResult(in, 100);
			}
		});

	}

	// Response from Edit restaurant Activity
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		// if result code 100
		if (resultCode == 100) {
			// if result code 100 is received 
			// means user edited/deleted restaurant
			// reload this screen again
			Intent intent = getIntent();
			finish();
			startActivity(intent);
		}

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
			pDialog = new ProgressDialog(AllRestaurantsActivity.this);
			pDialog.setMessage("Loading restaurants. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}

		/**
		 * getting All restaurants from url
		 * */
		protected String doInBackground(String... args) {
			// Building Parameters
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			// getting JSON string from URL
			JSONObject json = jParser.makeHttpRequest(url_all_restaurants, "GET", params);
			
			// Check your log cat for JSON reponse
			Log.d("All restaurants: ", json.toString());

			try {
				// Checking for SUCCESS TAG
				int success = json.getInt(TAG_SUCCESS);

				if (success == 1) {
					// restaurants found
					// Getting Array of restaurants
					restaurants = json.getJSONArray(TAG_restaurants);

					// looping through All restaurants
					for (int i = 0; i < restaurants.length(); i++) {
						JSONObject c = restaurants.getJSONObject(i);

						// Storing each json item in variable
						String id = c.getString(TAG_rest_id);
						String name = c.getString(TAG_NAME);

						// creating new HashMap
						HashMap<String, String> map = new HashMap<String, String>();

						// adding each child node to HashMap key => value
						map.put(TAG_rest_id, id);
						map.put(TAG_NAME, name);

						// adding HashList to ArrayList
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
			// dismiss the dialog after getting all restaurants
			pDialog.dismiss();
			// updating UI from Background Thread
			runOnUiThread(new Runnable() {
				public void run() {
					/**
					 * Updating parsed JSON data into ListView
					 * */
					ListAdapter adapter = new SimpleAdapter(
							AllRestaurantsActivity.this, restaurantsList,
							R.layout.list_item, new String[] { TAG_rest_id,
									TAG_NAME},
							new int[] { R.id.rest_id, R.id.name });
					// updating listview
					setListAdapter(adapter);
				}
			});

		}

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