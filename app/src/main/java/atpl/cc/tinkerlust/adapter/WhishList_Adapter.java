package atpl.cc.tinkerlust.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.fragments.WhishList;

/**
 * Created by user9 on 27/9/16.
 */

public class WhishList_Adapter extends RecyclerView.Adapter<WhishList_Adapter.Holder> {

    Context context;

    public WhishList_Adapter(Context context)
    {
        this.context = context;
    }


    @Override
    public WhishList_Adapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_column, parent, false);
        return new WhishList_Adapter.Holder(itemView);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {

    }


    @Override
    public int getItemCount() {
        return 10;
    }

    public class Holder extends RecyclerView.ViewHolder {


        public Holder(View itemView) {
            super(itemView);

        }
    }
}
