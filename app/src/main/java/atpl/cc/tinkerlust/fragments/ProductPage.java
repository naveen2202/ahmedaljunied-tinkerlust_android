package atpl.cc.tinkerlust.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.activities.First_page;
import atpl.cc.tinkerlust.adapter.ImageAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductPage extends Fragment {

    ViewPager Scrollimage,pager;
    TabLayout tablayout;
    LinearLayout shareLayout;
    ImageView imageview1,imageview2,imageview3,imageview4,share;
    int Array[]={R.drawable.blazzer,R.drawable.blazzer,R.drawable.blazzer,R.drawable.blazzer};
ScrollView scrollView;

    public ProductPage() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_product_page, container, false);
        shareLayout=(LinearLayout)view.findViewById(R.id.shareLayout);
        Scrollimage=(ViewPager)view.findViewById(R.id.productImagePager);
        scrollView=(ScrollView)view.findViewById(R.id.scrollview);
        share=(ImageView)view.findViewById(R.id.share);
        imageview1=(ImageView)view.findViewById(R.id.imageview1);
        imageview2=(ImageView)view.findViewById(R.id.imageview2);
        imageview3=(ImageView)view.findViewById(R.id.imageview3);
        imageview4=(ImageView)view.findViewById(R.id.imageview4);
        tablayout = (TabLayout)view.findViewById(R.id.tab_layoutProductDetail);
        pager = (ViewPager)view.findViewById(R.id.pagerProductDetails);
        TabLayout.Tab tab1 =tablayout.newTab().setText("DESCRIPTION");
        TabLayout.Tab tab2 =tablayout.newTab().setText("COMMENT");
        TabLayout.Tab tab3 =tablayout.newTab().setText("SHIPPING");
        TabLayout.Tab tab4 =tablayout.newTab().setText("PAYMENT");
        tablayout.addTab(tab1);
        tablayout.addTab(tab2);
        tablayout.addTab(tab3);
        tablayout.addTab(tab4);
        ProductPage.EditPagerAdapter adapter = new ProductPage.EditPagerAdapter((getActivity()).getSupportFragmentManager(), tablayout.getTabCount());
        pager.setAdapter(adapter);
        pager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tablayout));

        tablayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager.setCurrentItem(tab.getPosition());

            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        Scrollimage.setAdapter(new ImageAdapter(getActivity(),Array));
        Scrollimage.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
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

        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showShareLayout();
            }
        });

        shareLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hideShareLayout();
            }
        });


        return  view;
    }

    public class EditPagerAdapter extends FragmentStatePagerAdapter {
        int mNumOfTabs=0;

        public EditPagerAdapter( android.support.v4.app.FragmentManager fm, int NumOfTabs)
        {
            super(fm);
            //   super(fm);
            this.mNumOfTabs = NumOfTabs;
        }

        @Override
        public android.support.v4.app.Fragment getItem(int position) {


            switch (position) {
                case 0:
                    Description tab1= new Description();
                    return tab1;
                case 1:
                    Description tab2 = new Description();
                    return tab2;
                case 2:
                    Description tab3 = new Description();
                    return tab3;
                case 3:
                    Description tab4 = new Description();
                    return tab4;
                default:
                    return null;
            }
        }

        @Override
        public int getCount ()
        {
            return mNumOfTabs;
        }
    }

    public void showShareLayout()
    {
        shareLayout.setVisibility(View.VISIBLE);
    }
    public void hideShareLayout()
    {
        shareLayout.setVisibility(View.GONE);
    }


}
