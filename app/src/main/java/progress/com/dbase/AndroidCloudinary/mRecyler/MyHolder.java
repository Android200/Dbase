package progress.com.dbase.AndroidCloudinary.mRecyler;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import progress.com.dbase.R;

/**
 * Created by Umar Saidu Auna on 1/21/2018.
 */

public class MyHolder extends RecyclerView.ViewHolder {
    ImageView img;
    TextView nameField;

    public MyHolder(View itemview){
        super(itemview);

        img = (ImageView) itemview.findViewById(R.id.img);
        nameField= (TextView) itemview.findViewById(R.id.nameTxt);

    }
}
