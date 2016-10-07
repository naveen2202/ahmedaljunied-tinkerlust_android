package atpl.cc.tinkerlust.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import atpl.cc.tinkerlust.R;

/**
 * Created by user9 on 23/9/16.
 */

public class SubmenuAdapter extends BaseAdapter
{
    String[] list;
    Context context;

    public  SubmenuAdapter(Context context,String [] list)
    {
        this.context=context;
        this.list=list;
    }

    @Override
    public int getCount() {
        return list.length;
    }

    @Override
    public Object getItem(int i) {
        return list[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater= LayoutInflater.from(context);
        if(view==null) {
            view = inflater.inflate(R.layout.row_submenu, viewGroup, false);
              }
        TextView menuItem=(TextView)view.findViewById(R.id.rowTextview);
        menuItem.setText(list[i]);
        return view;
    }
}
