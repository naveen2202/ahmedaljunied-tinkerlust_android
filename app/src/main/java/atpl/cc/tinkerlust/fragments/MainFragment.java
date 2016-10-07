package atpl.cc.tinkerlust.fragments;


import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.adapter.GridAdapter;
import atpl.cc.tinkerlust.adapter.GridAdapterFashionista;
import atpl.cc.tinkerlust.adapter.ImageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {

GridView gridView,gridviewfashion;
    ViewPager viewPager;
    ImageView imageview1,imageview2,imageview3,imageview4;
    TextView seeMore;
    int Array[]={R.drawable.homepage_tinkerlust_two,R.drawable.homepage_tinkerlust_two,R.drawable.homepage_tinkerlust_two,R.drawable.homepage_tinkerlust_two};

    public MainFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_main, container, false);
        seeMore=(TextView)view.findViewById(R.id.seeMoreText);
        gridView=(GridView)view.findViewById(R.id.gridView);
   gridviewfashion=(GridView)view.findViewById(R.id.gridViewFashionista);
        gridView.setFocusable(false);
        gridviewfashion.setFocusable(false);
        viewPager = (ViewPager)view.findViewById(R.id.mainScreenPager);
        viewPager.setAdapter(new ImageAdapter(getActivity(),Array));
   gridView.setAdapter(new GridAdapter(getActivity()));
   gridviewfashion.setAdapter(new GridAdapterFashionista(getActivity()));
        imageview1=(ImageView)view.findViewById(R.id.imageview1);
        imageview2=(ImageView)view.findViewById(R.id.imageview2);
        imageview3=(ImageView)view.findViewById(R.id.imageview3);
        imageview4=(ImageView)view.findViewById(R.id.imageview4);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {


            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        imageview1.setImageResource(R.drawable.whitecircle);
                        imageview2.setImageResource(R.drawable.lightcircleimage);
                        imageview3.setImageResource(R.drawable.lightcircleimage);
                        imageview4.setImageResource(R.drawable.lightcircleimage);
                        break;
                    case 1:
                        imageview1.setImageResource(R.drawable.lightcircleimage);
                        imageview2.setImageResource(R.drawable.whitecircle);
                        imageview3.setImageResource(R.drawable.lightcircleimage);
                        imageview4.setImageResource(R.drawable.lightcircleimage);
                        break;
                    case 2:
                        imageview1.setImageResource(R.drawable.lightcircleimage);
                        imageview2.setImageResource(R.drawable.lightcircleimage);
                        imageview3.setImageResource(R.drawable.whitecircle);
                        imageview4.setImageResource(R.drawable.lightcircleimage);
                        break;
                    case 3:
                        imageview1.setImageResource(R.drawable.lightcircleimage);
                        imageview2.setImageResource(R.drawable.lightcircleimage);
                        imageview3.setImageResource(R.drawable.lightcircleimage);
                        imageview4.setImageResource(R.drawable.whitecircle);
                        break;

                }

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
seeMore.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        Log.d("Click","see more Called");
      getFragmentManager().beginTransaction().replace(R.id.container,new NewArrivals()).addToBackStack(null).commit();
    }
});

   return view;
    }

}
