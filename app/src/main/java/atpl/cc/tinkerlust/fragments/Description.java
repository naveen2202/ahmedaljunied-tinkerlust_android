package atpl.cc.tinkerlust.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;

import atpl.cc.tinkerlust.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Description extends Fragment {

ScrollView scrollview;

    public Description() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_description, container, false);
    scrollview=(ScrollView)view.findViewById(R.id.scrollview);
        scrollview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                scrollview.getParent().requestDisallowInterceptTouchEvent(true);
                return false;
            }
        });
    return view;
    }

}
