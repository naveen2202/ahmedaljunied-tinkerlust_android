package atpl.cc.tinkerlust.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.adapter.SubscribeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Subscriptions extends Fragment {

RecyclerView subscriberList;


    public Subscriptions() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_subscriptions, container, false);
subscriberList=(RecyclerView)view.findViewById(R.id.Subscriber_Recycler);
        subscriberList.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(this.getActivity());
        subscriberList.setLayoutManager(lm);
subscriberList.setAdapter(new SubscribeAdapter(getActivity()));
   return view;
    }

}
