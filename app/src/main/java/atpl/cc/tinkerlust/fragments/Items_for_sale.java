package atpl.cc.tinkerlust.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.adapter.Items_for_sale_Adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Items_for_sale extends Fragment {


    RecyclerView itemList;
    Items_for_sale_Adapter adapter;


    public Items_for_sale() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_items_for_sale, container, false);
        itemList=(RecyclerView)view.findViewById(R.id.itemsForSale_Recycler);
        itemList.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new GridLayoutManager(this.getActivity(),2);
        itemList.setLayoutManager(lm);
        adapter=new Items_for_sale_Adapter(getActivity());
        itemList.setAdapter(adapter);
    return view;
    }

}
