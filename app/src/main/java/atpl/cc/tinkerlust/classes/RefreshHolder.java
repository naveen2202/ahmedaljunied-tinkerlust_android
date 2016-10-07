package atpl.cc.tinkerlust.classes;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import atpl.cc.tinkerlust.R;
import cn.bingoogolapple.refreshlayout.BGARefreshViewHolder;

/**
 * Created by user9 on 29/9/16.
 */

public class RefreshHolder extends BGARefreshViewHolder {

    private TextView mHeaderStatusTv;
    private ImageView mHeaderArrowIv;
    private ProgressBar mHeaderChrysanthemumIv;
  //  private AnimationDrawable mHeaderChrysanthemumAd;
    private RotateAnimation mUpAnim;
    private RotateAnimation mDownAnim;

        private String mPullDownRefreshText = "Pull down to refresh";
    private String mReleaseRefreshText = "Release the update";
    private String mRefreshingText = "Loading...";


    public  RefreshHolder(Context context,boolean isLoadingMoreEnabled)
      {  super(context, isLoadingMoreEnabled);
          initAnimation();}


    private void initAnimation() {
        mUpAnim = new RotateAnimation(0, -360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mUpAnim.setDuration(300);
        mUpAnim.setFillAfter(true);

        mDownAnim = new RotateAnimation(-360, 0, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        mDownAnim.setDuration(300);
        mDownAnim.setFillAfter(true);
    }

    /**
     * 设置未满足刷新条件，提示继续往下拉的文本
     *
     * @param pullDownRefreshText
     */
    public void setPullDownRefreshText(String pullDownRefreshText) {
        mPullDownRefreshText = pullDownRefreshText;
    }

    /**
     * 设置满足刷新条件时的文本
     *
     * @param releaseRefreshText
     */
    public void setReleaseRefreshText(String releaseRefreshText) {
        mReleaseRefreshText = releaseRefreshText;
    }

    /**
     * 设置正在刷新时的文本
     *
     * @param refreshingText
     */
    public void setRefreshingText(String refreshingText) {
        mRefreshingText = refreshingText;
    }

    @Override
    public View getRefreshHeaderView() {
        if (mRefreshHeaderView == null) {
            mRefreshHeaderView = View.inflate(mContext, R.layout.refresh_layout, null);

            mHeaderStatusTv = (TextView) mRefreshHeaderView.findViewById(R.id.progressText);
            mHeaderArrowIv = (ImageView) mRefreshHeaderView.findViewById(R.id.rotationIV);
            mHeaderChrysanthemumIv = (ProgressBar) mRefreshHeaderView.findViewById(R.id.progressBar);
            //mHeaderChrysanthemumAd = (AnimationDrawable) mHeaderChrysanthemumIv.getDrawable();
            mHeaderStatusTv.setText(mPullDownRefreshText);
        }
        return mRefreshHeaderView;
    }

    @Override
    public void handleScale(float scale, int moveYDistance) {
    }

    @Override
    public void changeToIdle() {
    }

    @Override
    public void changeToPullDown() {
        mHeaderStatusTv.setText(mPullDownRefreshText);
        mHeaderChrysanthemumIv.setVisibility(View.INVISIBLE);
     //   mHeaderChrysanthemumAd.stop();
        mHeaderArrowIv.setVisibility(View.VISIBLE);
        mDownAnim.setDuration(150);
        mHeaderArrowIv.startAnimation(mDownAnim);
    }

    @Override
    public void changeToReleaseRefresh() {
        mHeaderStatusTv.setText(mReleaseRefreshText);
        mHeaderChrysanthemumIv.setVisibility(View.INVISIBLE);
       // mHeaderChrysanthemumAd.stop();
        mHeaderArrowIv.setVisibility(View.VISIBLE);
        mHeaderArrowIv.startAnimation(mUpAnim);
    }

    @Override
    public void changeToRefreshing() {
        mHeaderStatusTv.setText(mRefreshingText);
        // 必须把动画清空才能隐藏成功
        mHeaderArrowIv.clearAnimation();
        mHeaderArrowIv.setVisibility(View.INVISIBLE);
        mHeaderChrysanthemumIv.setVisibility(View.VISIBLE);
        //mHeaderChrysanthemumAd.start();
    }

    @Override
    public void onEndRefreshing() {
        mHeaderStatusTv.setText(mPullDownRefreshText);
        mHeaderChrysanthemumIv.setVisibility(View.INVISIBLE);
       // mHeaderChrysanthemumAd.stop();
        mHeaderArrowIv.setVisibility(View.VISIBLE);
        mDownAnim.setDuration(0);
        mHeaderArrowIv.startAnimation(mDownAnim);
    }
}
