package inducesmile.com.androidstaggeredgridlayoutmanager;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolderWrapper> {

    private List<ItemObjects> itemList;

    public RecyclerViewAdapter(Context context, List<ItemObjects> itemList) {
        this.itemList = itemList;
    }

    @Override
    public ViewHolderWrapper onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.solvent_list, null);
        ViewHolderWrapper viewHolderWrapper = new ViewHolderWrapper(layoutView);
        return viewHolderWrapper;
    }

    @Override
    public void onBindViewHolder(ViewHolderWrapper holder, int position) {
        holder.title.setText(itemList.get(position).getName());
        holder.image.setImageResource(itemList.get(position).getPhoto());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
