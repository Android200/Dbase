package progress.com.dbase.AndroidCloudinary.mRecyler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import progress.com.dbase.AndroidCloudinary.mCLoud.CloudinaryClient;
import progress.com.dbase.AndroidCloudinary.mData.Contents;
import progress.com.dbase.AndroidCloudinary.mPicasso.PicassoClient;
import progress.com.dbase.PicassoGalleryGrid.Picasso_Gallery;
import progress.com.dbase.R;

/**
 * Created by Umar Saidu Auna on 1/21/2018.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {
    Context context;
    ArrayList<Contents> contents;
    public MyAdapter (Context context,ArrayList<Contents> contents){
        this.context=context;
        this.contents=contents;
    }
    @Override
    public  MyHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.modelcloudinary,parent,false);
        MyHolder holder = new MyHolder(v);
        return holder;
    }
    @Override
    public void onBindViewHolder(MyHolder holder, int position){
        holder.nameField.setText(contents.get(position).getName());
        PicassoClient.downloadImage(context, CloudinaryClient.getRoundCornerImage(contents.get(position).getUrl()),holder.img);
    }
    @Override
    public int getItemCount(){
        return contents.size();
    }
}
