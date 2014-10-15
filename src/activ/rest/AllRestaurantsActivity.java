package activ.rest;

import instruments.JSONParser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.apache.http.NameValuePair;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import activ.foody.MenuActivity;
import activ.foody.R;
<<<<<<< HEAD
import android.app.AlertDialog;
import android.app.ListActivity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
=======
import android.app.ListActivity;
import android.app.ProgressDialog;
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
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
<<<<<<< HEAD

/**
 * All restaurants activity with list of all restaurants.
 */
public class AllRestaurantsActivity extends ListActivity {
	/**
	 * flag for Internet connection status.
	 */
	Boolean isInternetPresent = false;
	/**
	 * Connection detector class.
	 */
	instruments.ConnectionDetector cd3;
=======
/**
 * All restaurants activity with list of all restaurants.
 */
public class AllRestaurantsActivity extends ListActivity 
{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
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
<<<<<<< HEAD
	ArrayList<HashMap<String, Object>> restaurantsList;
	/**
	 * Url to get all restaurants list.
	 */
	private static String url_all_restaurants = "http://foodyapp.890m.com//android_connect/get_all_restaurants.php";
=======
	ArrayList<HashMap<String, String>> restaurantsList;
	/**
	 * Url to get all restaurants list.
	 */
	private static String url_all_restaurants="http://foodyapp.890m.com//android_connect/get_all_restaurants.php";
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
	/**
	 * JSON Node names.
	 */
	private static final String TAG_SUCCESS = "success";
	private static final String TAG_restaurants = "restaurant";
	private static final String TAG_rest_id = "rest_id";
	private static final String TAG_NAME = "name";
<<<<<<< HEAD
	private static final String TAG_AVATAR = "avatar_image_url";
=======
	private static final String TAG_PHOTO = "photo";
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
	private static final String TAG_CUI = "cuisine";
	/**
	 * restaurants JSONArray.
	 */
	JSONArray restaurants = null;
<<<<<<< HEAD

=======
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
	/**
	 * On create method, content and view intilization.
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
		 * Objects initialization.
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
			// Ask user to connect to Internet.
			 */
			showAlertDialog(
					AllRestaurantsActivity.this,
					"No Internet Connection",
					"Please connect to the internet.Data cannot be load or might be lost.",
					false);
		}
	}
	/**
	 * Initialization objects.
	 */
	public void initialization() {
		/**
		 * Hashmap for ListView.
		 */
		restaurantsList = new ArrayList<HashMap<String, Object>>();
=======
		/**
		 * Set content view.
		 */
		setContentView(R.layout.all_restaurants);
		/**
		 * Hashmap for ListView.
		 */
		restaurantsList = new ArrayList<HashMap<String, String>>();
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
		/**
		 * Loading restaurants in Background Thread.
		 */
		new LoadAllrestaurants().execute();
		/**
		 * Get listview.
		 */
		ListView lv = getListView();
		/**
<<<<<<< HEAD
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
=======
		 * on seleting single restaurant
		 * launching restaurant information Screen
		 */
		lv.setOnItemClickListener(new OnItemClickListener() 
		{
			@Override
			public void onItemClick(AdapterView<?> parent, View view,int position, long id)
			{
				/**
				 * Getting values from selected ListItem.
				 */
				String rest_id = ((TextView) view.findViewById(R.id.rest_id)).getText().toString();
				/**
				 * Starting new intent.
				 */
				Intent in = new Intent(getApplicationContext(),RestInfoActivity.class);
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
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
<<<<<<< HEAD

	/**
	 * Background Async Task to Load all restaurant by making HTTP Request
	 * */
	class LoadAllrestaurants extends AsyncTask<String, String, String> {
=======
	/**
	 * Background Async Task to Load all restaurant by making HTTP Request
	 * */
	class LoadAllrestaurants extends AsyncTask<String, String, String> 
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
			pDialog = new ProgressDialog(AllRestaurantsActivity.this);
			pDialog.setMessage("Loading. Please wait...");
			pDialog.setIndeterminate(false);
			pDialog.setCancelable(false);
			pDialog.show();
		}
		/**
		 * getting All restaurants from url
		 * */
<<<<<<< HEAD
		protected String doInBackground(String... args) {
=======
		protected String doInBackground(String... args) 
		{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
			/**
			 * Building Parameters.
			 */
			List<NameValuePair> params = new ArrayList<NameValuePair>();
			/**
			 * Getting JSON string from URL.
			 */
<<<<<<< HEAD
			JSONObject json = jParser.makeHttpRequest(url_all_restaurants,
					"GET", params);
=======
			JSONObject json = jParser.makeHttpRequest(url_all_restaurants, "GET", params);
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
			/**
			 * Check log cat for JSON reponse.
			 */
			Log.d("All restaurants: ", json.toString());
			try {
				/**
				 * Checking for SUCCESS TAG.
				 */
				int success = json.getInt(TAG_SUCCESS);
<<<<<<< HEAD
				if (success == 1) {
					/**
					 * Restaurants found. Getting Array of restaurants.
=======
				if (success == 1) 
				{
					/**
					 * Restaurants found.
					 *  Getting Array of restaurants.
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
					 */
					restaurants = json.getJSONArray(TAG_restaurants);
					/**
					 * Looping through All restaurants.
					 */
<<<<<<< HEAD
					for (int i = 0; i < restaurants.length(); i++) {
=======
					for (int i = 0; i < restaurants.length(); i++) 
					{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
						JSONObject c = restaurants.getJSONObject(i);
						/**
						 * Storing each json item in variable.
						 */
						String id = c.getString(TAG_rest_id);
						String name = c.getString(TAG_NAME);
						String cuisine = c.getString(TAG_CUI);
<<<<<<< HEAD
						int rest_id = Integer.parseInt(id);

						/**
						 * Creating new HashMap.
						 */
						HashMap<String, Object> map = new HashMap<String, Object>();
						/**
						 * Set for each restaurant its avatar.It depends on restaurant id.
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
=======
						/**
						 * Creating new HashMap.
						 */
						HashMap<String, String> map = new HashMap<String, String>();
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
						/**
						 * Adding each child node to HashMap key => value.
						 */
						map.put(TAG_rest_id, id);
						map.put(TAG_NAME, name);
						map.put(TAG_CUI, cuisine);
<<<<<<< HEAD
						map.put(TAG_AVATAR, avatar);
=======
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
						/**
						 * Adding HashList to ArrayList.
						 */
						restaurantsList.add(map);
					}
<<<<<<< HEAD
				} else {
				}
			} catch (JSONException e) {
=======
				} else 
				{
				}
			}catch (JSONException e) 
			{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
				e.printStackTrace();
			}
			return null;
		}
<<<<<<< HEAD

		/**
		 * /** After completing background task Dismiss the progress dialog
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
			 * Dismiss the dialog after getting all restaurants.
			 */
			pDialog.dismiss();
			/**
			 * Updating UI from Background Thread.
			 */
<<<<<<< HEAD
			runOnUiThread(new Runnable() {
				public void run() {
					/**
					 * Updating parsed JSON data into ListView
					 * */

					ListAdapter adapter = new SimpleAdapter(
							AllRestaurantsActivity.this, restaurantsList,
							R.layout.list_item, new String[] { TAG_rest_id,
									TAG_NAME, TAG_AVATAR }, new int[] {
									R.id.rest_id, R.id.name, R.id.avatar });
=======
			runOnUiThread(new Runnable() 
			{
				public void run() 
				{
					/**
					 * Updating parsed JSON data into ListView
					 * */
					ListAdapter adapter = new SimpleAdapter(AllRestaurantsActivity.this, restaurantsList,R.layout.list_item, new String[] { TAG_rest_id,TAG_NAME,TAG_PHOTO},new int[] { R.id.rest_id, R.id.name });
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
					/**
					 * Updating listview.
					 */
					setListAdapter(adapter);
				}
			});
		}
	}
<<<<<<< HEAD

=======
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
	 * Back button was pressed. Menu screen started.
	 */
	public void back(View v) {
=======
	public void onConfigurationChanged(Configuration newConfig) 
	{  
		super.onConfigurationChanged(newConfig);  
	}
	/**
	 * Back button was pressed. Menu screen started.
	 */
	public void back(View v)
	{
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
		this.finish();
		Intent intent = new Intent(this, MenuActivity.class);
		startActivity(intent);
	}
<<<<<<< HEAD

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

		// Setting Dialog Title
		alertDialog.setTitle(title);

		// Setting Dialog Message
		alertDialog.setMessage(message);

		// Setting OK Button
		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int which) {
				/**
				 * Set content view.
				 */
				setContentView(R.layout.all_restaurants);
				initialization();

			}
		});

		// Showing Alert Message
		alertDialog.show();
	}

=======
>>>>>>> e397340e3e81b695d1a11a09dedcc2fc18d400a5
}