package atpl.cc.tinkerlust.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.adapter.SubscribeAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class SubscribedBy extends Fragment {

    RecyclerView subscriberList;


    public SubscribedBy() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_subscriptions, container, false);
        subscriberList=(RecyclerView)view.findViewById(R.id.Subscriber_Recycler);
        subscriberList.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new LinearLayoutManager(this.getActivity());
        subscriberList.setLayoutManager(lm);
        subscriberList.setAdapter(new SubscribeAdapter(getActivity()));
        return view;
    }

}
