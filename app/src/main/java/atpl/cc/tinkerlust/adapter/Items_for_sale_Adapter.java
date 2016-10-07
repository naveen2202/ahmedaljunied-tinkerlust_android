package atpl.cc.tinkerlust.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.StringTokenizer;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.fragments.Items_for_sale;

/**
 * Created by user9 on 27/9/16.
 */

public class Items_for_sale_Adapter extends RecyclerView.Adapter<Items_for_sale_Adapter.Holder> {

    Context context;

    public Items_for_sale_Adapter( Context context) {

        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_column, parent, false);
        return new Holder(itemView);
    }

    @Override
    public void onBindViewHolder(final Holder holder, final int position) {



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
