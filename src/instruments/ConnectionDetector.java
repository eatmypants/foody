package instruments;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
 /**
  * Detecror if device has connection with internet.
  */
public class ConnectionDetector {
     
    private Context _context;
     /**
      * Class constructor.
      */
    public ConnectionDetector(Context context){
        this._context = context;
    }
    /**
     * Desite if it is connectiong to internet , or not.
     */
    public boolean isConnectingToInternet(){
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
          if (connectivity != null) 
          {
              NetworkInfo[] info = connectivity.getAllNetworkInfo();
              if (info != null) 
                  for (int i = 0; i < info.length; i++) 
                      if (info[i].getState() == NetworkInfo.State.CONNECTED)
                      {
                          return true;
                      }
          }
          return false;
    }
}