package fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.albert.rob.peachblossomrob.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 发现
 * Created by admain on 2018/8/17.
 */

public class FindFragment extends Fragment {

    @BindView(R.id.find_tablayout)
    TabLayout tabLayout;
    @BindView(R.id.iv_find_search)
    ImageView findSearch;
    @BindView(R.id.find_tab_viewpager)
    ViewPager viewpager;
    Unbinder unbinder;

    private List<String> tabTitle = new ArrayList<>();
    private List<Fragment> fragmentList = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_find, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public static FindFragment newInstance() {
        FindFragment fragment = new FindFragment();
        return fragment;
    }

    private void initView(){
        tabTitle.clear();
        fragmentList.clear();

        tabTitle.add("发现");
        tabTitle.add("分类");

        fragmentList.add(new FindDiscoveryChildFragment());
        fragmentList.add(new FindClassifyChildFragment());

        viewpager.setAdapter(new MyViewPagerAdapter(getChildFragmentManager()));
        tabLayout.setSelectedTabIndicatorColor(Color.parseColor("#00000000"));//设置指示器背景透明
        tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.setupWithViewPager(viewpager);
    }

    @OnClick(R.id.iv_find_search)
    public void onClick() {
    }
    final class MyViewPagerAdapter extends FragmentPagerAdapter {

        public MyViewPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return fragmentList.get(position);
        }

        @Override
        public int getCount() {
            return tabTitle.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return tabTitle.get(position);

        }
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
