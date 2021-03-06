package progress.com.dbase.PicassoGalleryGrid;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import progress.com.dbase.R;

public class Picasso_Gallery extends AppCompatActivity {
    GridView grid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso__gallery);
        grid = (GridView)findViewById(R.id.grid);
        grid.setAdapter(new ImageAdapter(this));
    }
    private static class ImageAdapter extends BaseAdapter {

        private static final String[] IMAGE_URLS = PicassoGalleryConstant.IMAGES;

        private LayoutInflater inflater;

        Context c;

        ImageAdapter(Context context) {
            inflater = LayoutInflater.from(context);
            c = context;

        }

        @Override
        public int getCount() {
            return IMAGE_URLS.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            final ViewHolder holder;
            View view = convertView;
            if (view == null) {
                view = inflater.inflate(R.layout.item_picasso_grid, parent, false);
                holder = new ViewHolder();
                assert view != null;

                holder.imageView = (ImageView) view.findViewById(R.id.image);

                holder.progressBar = (ProgressBar) view.findViewById(R.id.progress);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }
            Picasso.with(c)
                    .load(IMAGE_URLS[position])
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher )
                    .fit()
                    .into(holder.imageView, new Callback() {

                        @Override
                        public void onSuccess() {
                            holder.imageView.setVisibility(View.VISIBLE);
                            holder.progressBar.setVisibility(View.INVISIBLE);
                        }

                        @Override
                        public void onError() {
                            holder.progressBar.setVisibility(View.VISIBLE);
                            holder.imageView.setVisibility(View.INVISIBLE);
                        }
                    });

            return view;
        }
    }

    static class ViewHolder {
        ImageView imageView;
        ProgressBar progressBar;
    }
}
