package progress.com.dbase.PicassoImageLoader;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import progress.com.dbase.R;

public class PicassoImage extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso_image);
        ImageView image1 = (ImageView)findViewById(R.id.imageView1);
        ImageView image2 = (ImageView)findViewById(R.id.imageView2);
        ImageView image3 = (ImageView)findViewById(R.id.imageView3);

        Picasso.with(this)
                .load("http://192.168.43.183/Dbase/photos/download.png")
                .resize(700,700)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(image1);

        Picasso.with(this)
                .load("http://192.168.43.183/Dbase/photos/kotlin.png")
                .resize(700,400)
                .centerCrop()
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(image2);
        Picasso.with(this).load("http://192.168.43.183/Dbase/photos/nacoss.jpg").resize(700,400).centerCrop().placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(image3);

    }
}
