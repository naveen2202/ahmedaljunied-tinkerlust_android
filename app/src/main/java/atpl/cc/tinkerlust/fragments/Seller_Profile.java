package atpl.cc.tinkerlust.fragments;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import atpl.cc.tinkerlust.R;


public class Seller_Profile extends Fragment {

    TabLayout tablayout;
    ViewPager pager;

    public Seller_Profile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_seller__profile, container, false);

        tablayout = (TabLayout)view.findViewById(R.id.tab_layoutSeller);
        pager = (ViewPager)view.findViewById(R.id.pagerSeller);
        TabLayout.Tab tab1 =tablayout.newTab().setText("ITEMS FOR SALE");
        TabLayout.Tab tab2 =tablayout.newTab().setText("SUBSCRIPTIONS");
        TabLayout.Tab tab3 =tablayout.newTab().setText("SUBSCRIBED BY");
        TabLayout.Tab tab4 =tablayout.newTab().setText("WISH LIST");
        tablayout.addTab(tab1);
        tablayout.addTab(tab2);
        tablayout.addTab(tab3);
        tablayout.addTab(tab4);
        final EditPagerAdapter adapter = new EditPagerAdapter((getActivity()).getSupportFragmentManager(), tablayout.getTabCount());
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

                    Items_for_sale tab1= new Items_for_sale();
                    return tab1;
                case 1:
                    Subscriptions tab2 = new Subscriptions();
                    return tab2;
                case 2:
                    SubscribedBy tab3 = new SubscribedBy();
                    return tab3;
                case 3:
                    WhishList tab4 = new WhishList();
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




}
