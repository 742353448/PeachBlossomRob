package fragment;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.albert.rob.peachblossomrob.R;

import java.util.ArrayList;
import java.util.List;

import adapter.HomeRecyclerAdapter;
import bean.HomeRecyclerBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 主页
 * Created by admain on 2018/8/17.
 */

public class HomeFragment extends Fragment {

    @BindView(R.id.line_search)
    LinearLayout lineSearch;
    @BindView(R.id.home_recycler)
    RecyclerView mRecycler;
    Unbinder unbinder;

    private HomeRecyclerAdapter mAdapter;
    private List<HomeRecyclerBean> mBean = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    public static HomeFragment newInstance() {
        HomeFragment fragment = new HomeFragment();
        return fragment;
    }


    private void initView(){
        for(int i = 0;i < 20;i++){
            HomeRecyclerBean bean = new HomeRecyclerBean();
            bean.setImgUrl("http://img3.imgtn.bdimg.com/it/u=1858227345,1086764166&fm=15&gp=0.jpg");
            bean.setContent("*/ω＼*)大大加拿大今年埃里克大男大女李达康麻蛋哪来的卡的哪款马丹丹拿大今年埃里克大男大");
            bean.setRelayNum(12);
            bean.setLikeNum(5);
            bean.setHeadImage("http://img2.touxiang.cn/file/20160504/688a3c6064034bc694279fe1d87490a0.jpg");
            bean.setNickName("我去，要不要这么拽");
            bean.setDrawingBoard("噜啦啦啦噜噜噜");
            mBean.add(bean);
        }
        mAdapter = new HomeRecyclerAdapter(getActivity(), mBean);
        mAdapter.setOnItemClickListener(new HomeRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void onLongClick(int position) {

            }
        });
        mAdapter.setHasStableIds(true);
        mRecycler.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRecycler.setAdapter(mAdapter);
    }

    @OnClick(R.id.line_search)
    public void onClick() {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
