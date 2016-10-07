package atpl.cc.tinkerlust.fragments;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import atpl.cc.tinkerlust.R;
import atpl.cc.tinkerlust.activities.HomeActivity;
import atpl.cc.tinkerlust.adapter.FilterListAdapter;
import atpl.cc.tinkerlust.adapter.Items_for_sale_Adapter;
import atpl.cc.tinkerlust.adapter.NewArrivalAdapter;
import atpl.cc.tinkerlust.adapter.SubmenuAdapter;
import atpl.cc.tinkerlust.classes.RefreshHolder;
import cn.bingoogolapple.refreshlayout.BGANormalRefreshViewHolder;
import cn.bingoogolapple.refreshlayout.BGARefreshLayout;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewArrivals extends Fragment implements BGARefreshLayout.BGARefreshLayoutDelegate {

     RecyclerView newArrivalList;
            NewArrivalAdapter adapter;
    ListView filterList,submenurightList;
    TextView rightTitle,filterText;
    String list[];
    LinearLayout toolbarMenu;
    Toolbar toolbar;
    DrawerLayout drawerLayout;
    BGARefreshLayout mRefreshLayout;

    public NewArrivals() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_new_arrivals, container, false);
        initRefreshLayout(mRefreshLayout,view);
        filterList=((HomeActivity)getActivity()).filterList;
        toolbar=((HomeActivity)getActivity()).toolbar;
        drawerLayout=((HomeActivity)getActivity()).mDrawerLayout;
       filterText=(TextView)toolbar.findViewById(R.id.toolbarFilterText);
       toolbarMenu=(LinearLayout)toolbar.findViewById(R.id.toolbarSmallMenuLayout);
       toolbarMenu.setVisibility(View.GONE);
       filterText.setVisibility(View.VISIBLE);
        submenurightList=((HomeActivity)getActivity()).submenuRight;
        rightTitle=((HomeActivity)getActivity()).titleRight;
        newArrivalList=(RecyclerView)view.findViewById(R.id.newArrivalsRecycler);
        newArrivalList.setHasFixedSize(true);
        RecyclerView.LayoutManager lm= new GridLayoutManager(this.getActivity(),2);
        newArrivalList.setLayoutManager(lm);
        adapter=new NewArrivalAdapter(getActivity(),this);
        newArrivalList.setAdapter(adapter);
        list=new String[]{"Categories","Price","Brand","Condition","Color","Price","Seller"};
        String submenuForBags[]=new String[]{"Bags","Clothing","Shoes","Accessories"};
        submenurightList.setAdapter(new SubmenuAdapter(getActivity(),submenuForBags));
        FilterListAdapter filterAdapter=new FilterListAdapter(getActivity(),list);
        filterList.setAdapter(filterAdapter);
        filterList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                rightTitle.setText("Categories");
                submenurightList.setVisibility(View.VISIBLE);
                rightTitle.setVisibility(View.VISIBLE);
            }
        });


        rightTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //       drawerList.setVisibility(View.VISIBLE);
                submenurightList.setVisibility(View.GONE);
                rightTitle.setVisibility(View.GONE);
            }
        });

        filterText.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        drawerLayout.openDrawer(GravityCompat.END);

    }
});


        return view;
    }


    private void initRefreshLayout(BGARefreshLayout refreshLayout,View view) {
        mRefreshLayout = (BGARefreshLayout)view.findViewById(R.id.refreshLayout);
        LayoutInflater inflater = (LayoutInflater)   getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        // 为BGARefreshLayout设置代理
        mRefreshLayout.setDelegate(this);
        mRefreshLayout.endRefreshing();
        //Set the pull-down refresh and pull-up to load more styles Parameter 1: Application context, parameter 2: Whether to have pull-up to load more
        BGARefreshViewHolder refreshViewHolder = new RefreshHolder(getActivity(),false);
        // Set the pull-down refresh and pull-up to load more styles
        mRefreshLayout.setRefreshViewHolder(refreshViewHolder);


        // In order to increase the drop-down refresh the head and load more versatility, provides the following optional configuration options ------------- START
        // Load more controls are not displayed when loading more
         mRefreshLayout.setIsShowLoadingMoreView(false);
        // Sets the text when more is being loaded
       /* refreshViewHolder.setLoadingMoreText("");
        // Sets the background color resource id for the entire load more controls
        refreshViewHolder.setLoadMoreBackgroundColorRes(loadMoreBackgroundColorRes);
        // Sets the background drawable resource id for the entire load more controls
        refreshViewHolder.setLoadMoreBackgroundDrawableRes(loadMoreBackgroundDrawableRes);
        // Sets the background color resource id for the drop-down refresh control
        refreshViewHolder.setRefreshViewBackgroundColorRes(refreshViewBackgroundColorRes);
        // Sets the drawable resource id for the drop-down refresh control's background
        refreshViewHolder.setRefreshViewBackgroundDrawableRes(refreshViewBackgroundDrawableRes);
       */ // Set a custom header view (can also be set) Parameter 1: Customize the header view (eg, ad slot), parameter 2: Pull-up load more
        //mRefreshLayout.setCustomHeaderView(mBanner, true);
        // Optional  -------------END
    }


    @Override
    public void onPause() {
        filterText.setVisibility(View.GONE);
        toolbarMenu.setVisibility(View.VISIBLE);
        drawerLayout.closeDrawers();
        super.onPause();
    }


    @Override
    public void onResume() {
        toolbarMenu.setVisibility(View.GONE);
        filterText.setVisibility(View.VISIBLE);
        super.onResume();
    }

    @Override
    public void onBGARefreshLayoutBeginRefreshing(BGARefreshLayout refreshLayout) {
        // 在这里加载最新数据

            // 如果网络可用，则加载网络数据
            new AsyncTask<Void, Void, Void>() {

                @Override
                protected Void doInBackground(Void... params) {
                    return null;
                }

                @Override
                protected void onPostExecute(Void aVoid) {
                    // 加载完毕后在UI线程结束下拉刷新
                  //  mRefreshLayout.endRefreshing();

                }
            }.execute();
        }


    @Override
    public boolean onBGARefreshLayoutBeginLoadingMore(BGARefreshLayout refreshLayout) {
        return false;
    }


    // Through the code to control the state is being refreshed. Application scenario: Some applications are invoked in the activity's onStart method, automatically entering the state of being refreshed for the most recent data
    public void beginRefreshing() {
        mRefreshLayout.beginRefreshing();
    }

    // Code-controlled access to load more states
    public void beginLoadingMore() {
        mRefreshLayout.beginLoadingMore();
    }
}
