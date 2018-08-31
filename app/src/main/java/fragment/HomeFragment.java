package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
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
import utils.Utils;
import widget.SpaceItemDecoration;

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
    private int space;//分割线
    public static final int spanCount = 2;//列数（可在这里改变列数）

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


    private void initView() {
        for (int i = 0; i < 20; i++) {
            HomeRecyclerBean bean = new HomeRecyclerBean();
            switch (i) {
                case 2:
                    bean.setImgUrl("http://upload.mnw.cn/2017/0814/1502698443378.jpg");
                    break;
                case 3:
                    bean.setImgUrl("http://imgfs.oppo.cn/uploads/thread/attachment/2016/11/10/14787778607682.jpg");
                    break;
                case 6:
                    bean.setImgUrl("http://img3.imgtn.bdimg.com/it/u=1858227345,1086764166&fm=15&gp=0.jpg");
                    break;
                case 9:
                    bean.setImgUrl("http://img.pconline.com.cn/images/upload/upc/tx/wallpaper/1210/08/c1/14307187_1349676294934.jpg");
                    break;
                case 13:
                    bean.setImgUrl("http://g.hiphotos.baidu.com/zhidao/wh%3D450%2C600/sign=bff2680edb54564ee530ec3d86eeb0b4/d439b6003af33a871ff65407c05c10385343b510.jpg");
                    break;
                case 17:
                    bean.setImgUrl("http://upload.mnw.cn/2017/0814/1502698443378.jpg");
                    break;
                case 19:
                    bean.setImgUrl("http://img0.imgtn.bdimg.com/it/u=4203850523,3083361989&fm=26&gp=0.jpg");
                    break;

                default:
                    bean.setImgUrl("http://img3.imgtn.bdimg.com/it/u=1858227345,1086764166&fm=15&gp=0.jpg");
                    break;
            }

            bean.setContent("*/ω＼*)大大加拿大今年埃里克大男大女李达康麻蛋哪来的卡的哪款马丹丹拿大今年埃里克大男大");
            bean.setRelayNum(12);
            bean.setLikeNum(5);
            bean.setHeadImage("http://img2.touxiang.cn/file/20160504/688a3c6064034bc694279fe1d87490a0.jpg");
            bean.setNickName("我去，要不要这么拽");
            bean.setDrawingBoard("噜啦啦啦噜噜噜");
            mBean.add(bean);
        }
        space = Utils.px2dip(getContext(), 80);
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
        mRecycler.setLayoutManager(new StaggeredGridLayoutManager(spanCount, StaggeredGridLayoutManager.VERTICAL));
        //设置分割线
        mRecycler.addItemDecoration(new SpaceItemDecoration(space, spanCount));
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
