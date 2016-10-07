package atpl.cc.tinkerlust.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import atpl.cc.tinkerlust.R;

/**
 * Created by user9 on 23/9/16.
 */

public class GridAdapterFashionista extends BaseAdapter {

    Context context;

    public GridAdapterFashionista(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.fashionista_row,null);
        return convertView;
    }
}
