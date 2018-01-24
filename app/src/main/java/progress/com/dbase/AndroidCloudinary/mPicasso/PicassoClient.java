package progress.com.dbase.AndroidCloudinary.mPicasso;

import android.content.Context;
import android.text.style.IconMarginSpan;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import progress.com.dbase.R;

/**
 * Created by Umar Saidu Auna on 1/21/2018.
 */

public class PicassoClient {
    public static void downloadImage(Context context, String url, ImageView img){
        if(url !=null && url.length() > 0){
            Picasso.with(context).load(url).placeholder(R.drawable.androidstudio).into(img);
        }else{
            Toast.makeText(context, "Error Calling the Image", Toast.LENGTH_SHORT).show();
            Picasso.with(context).load(R.drawable.androidstudio);
        }
    }
}
