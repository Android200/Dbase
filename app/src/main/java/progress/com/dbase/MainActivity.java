package progress.com.dbase;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import progress.com.dbase.AndroidCloudinary.Cloudinary;
import progress.com.dbase.AndroidDangerousPermission.Dangerous_Permissions;
import progress.com.dbase.AndroidDownloadFile.DownloadFile;
import progress.com.dbase.AndroidJson.AndroidJson;
import progress.com.dbase.AndroidPHPLogin.Androidphp2;
import progress.com.dbase.AndroidReaadingTextFile.ReadingTextFile;
import progress.com.dbase.AndroidSQLITE.AndroidSQLITE;
import progress.com.dbase.Dfirebase.FirebaseActivity;
import progress.com.dbase.PicassoGalleryGrid.Picasso_Gallery;
import progress.com.dbase.PicassoImageLoader.PicassoImage;

public class MainActivity extends AppCompatActivity {
    String list[]={"Android JSon","Picasso Image Loader","Picasso Gallery","android PHP LOGIN",
            "Downloading File","Dangerous Permission","Android Reading Text","Cloudinary Gallery","Complex SQlite","Fire Base"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,list));

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    startActivity(new Intent(getApplicationContext(),AndroidJson.class));
                }else if(position==1){
                    startActivity(new Intent(getApplicationContext(),PicassoImage.class));
                }else if(position==2){
                    startActivity(new Intent(getApplicationContext(),Picasso_Gallery.class));
                }else if (position==3){
                    startActivity(new Intent(getApplicationContext(),Androidphp2.class));
                }else if (position==4){
                    startActivity(new Intent(getApplicationContext(),DownloadFile.class));
                }else if (position==5){
                    startActivity(new Intent(getApplicationContext(),Dangerous_Permissions.class));
                }else if (position==6){
                    startActivity(new Intent(getApplicationContext(), ReadingTextFile.class));
                }else if (position==7){
                    startActivity(new Intent(getApplicationContext(), Cloudinary.class));
                }else if(position==8){
                    startActivity(new Intent(getApplicationContext(), AndroidSQLITE.class));
                }else if(position==9){
                    startActivity(new Intent(getApplicationContext(), FirebaseActivity.class));
                }
            }
        });
    }
}
