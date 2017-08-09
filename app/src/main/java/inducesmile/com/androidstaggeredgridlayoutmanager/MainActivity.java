package inducesmile.com.androidstaggeredgridlayoutmanager;

import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private StaggeredGridLayoutManager _layoutManager;
    private RecyclerViewAdapter _recyclerViewAdapter;
    private RecyclerView _recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        _recyclerView = (RecyclerView)findViewById(R.id.recycler_view);

        _layoutManager = new StaggeredGridLayoutManager(getSpanCountForOrientation(),
                StaggeredGridLayoutManager.VERTICAL);

        _layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);

        _recyclerView.setLayoutManager(_layoutManager);

        _recyclerViewAdapter = new RecyclerViewAdapter(MainActivity.this,
                getListItemData());
        _recyclerView.setAdapter(_recyclerViewAdapter);
    }

    /**
     * @return span count determined on the basis of the screen orientation, changes between 2 for
     *         portrait and 3 for landscape
     */
    private int getSpanCountForOrientation() {
        int spanCount = 2;
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE) {
            spanCount = 3;
        }
        return spanCount;
    }


    private List<ItemObjects> getListItemData(){
        List<ItemObjects> listViewItems = new ArrayList<>();
        listViewItems.add(new ItemObjects("Alkane", R.drawable.one));
        listViewItems.add(new ItemObjects("Ethane", R.drawable.two));
        listViewItems.add(new ItemObjects("Alkyne", R.drawable.three));
        listViewItems.add(new ItemObjects("Benzene", R.drawable.four));
        listViewItems.add(new ItemObjects("Amide", R.drawable.one));
        listViewItems.add(new ItemObjects("Amino Acid", R.drawable.two));
        listViewItems.add(new ItemObjects("Phenol", R.drawable.three));
        listViewItems.add(new ItemObjects("Carbonxylic", R.drawable.four));
        listViewItems.add(new ItemObjects("Nitril", R.drawable.one));
        listViewItems.add(new ItemObjects("Ether", R.drawable.two));
        listViewItems.add(new ItemObjects("Ester", R.drawable.three));

        return listViewItems;
    }
}
