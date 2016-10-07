package atpl.cc.tinkerlust.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.adapter.WhishList_Adapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class WhishList extends Fragment {

RecyclerView whishList;
    
    public WhishList() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_whish_list, container, false);
        whishList=(RecyclerView)view.findViewById(R.id.whishList_Recycler);
        whishList.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new GridLayoutManager(this.getActivity(),2);
        whishList.setLayoutManager(lm);
        whishList.setAdapter(new WhishList_Adapter(getActivity()));
        return view;  }

}
