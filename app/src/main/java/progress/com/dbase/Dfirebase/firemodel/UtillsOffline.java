package progress.com.dbase.Dfirebase.firemodel;

import android.app.Application;

import com.google.firebase.FirebaseApp;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Umar Saidu Auna on 1/29/2018.
 */

public class UtillsOffline extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        if (!FirebaseApp.getApps(this).isEmpty()) {
            FirebaseDatabase.getInstance().setPersistenceEnabled(true);
        }
    }
}
