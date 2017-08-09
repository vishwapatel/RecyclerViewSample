package inducesmile.com.androidstaggeredgridlayoutmanager;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewHolderWrapper extends RecyclerView.ViewHolder {

    public TextView title;
    public ImageView image;

    public ViewHolderWrapper(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.country_name);
        image = (ImageView) itemView.findViewById(R.id.country_photo);
    }
}
