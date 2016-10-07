package atpl.cc.tinkerlust.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.fragments.NewArrivals;
import atpl.cc.tinkerlust.fragments.ProductPage;

/**
 * Created by vikram
 */

public class NewArrivalAdapter extends RecyclerView.Adapter<NewArrivalAdapter.Holder> {

    Context context;
Fragment fragment;
    public NewArrivalAdapter(Context context, Fragment fragment) {
        this.fragment=fragment;
        this.context = context;
    }

    @Override
    public NewArrivalAdapter.Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.grid_column, parent, false);
        return new NewArrivalAdapter.Holder(itemView);
    }

    @Override
    public void onBindViewHolder(final NewArrivalAdapter.Holder holder, final int position) {
holder.itemView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        fragment.getFragmentManager().beginTransaction().replace(R.id.container,new ProductPage()).addToBackStack(null).commit();
    }
});
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class Holder extends RecyclerView.ViewHolder {


        public Holder(View itemView) {
            super(itemView);
        }
    }


}
