package atpl.cc.tinkerlust.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atpl.cc.tinkerlust.R;

/**
 * Created by user9 on 27/9/16.
 */

public class SubscribeAdapter extends  RecyclerView.Adapter<SubscribeAdapter.Holder> {

    Context context;

    public SubscribeAdapter( Context context) {

        this.context = context;
    }

    @Override
    public SubscribeAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.subscription_row, parent, false);
        return new SubscribeAdapter.Holder(itemView);
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
