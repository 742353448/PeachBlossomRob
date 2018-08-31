package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albert.rob.peachblossomrob.R;

import java.util.ArrayList;
import java.util.List;

import adapter.FindChildCategoryAdapter;
import adapter.FindChildRecommendAdapter;
import bean.FindChildCategoryBean;
import bean.FindChildRecommendBean;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;
import widget.RecycleViewDivider;

/**
 * 子页发现
 * Created by admain on 2018/8/23.
 */

public class FindDiscoveryChildFragment extends Fragment {

    @BindView(R.id.trends_horizontal_recycler)
    RecyclerView horizontalRecycler;
    Unbinder unbinder;
    @BindView(R.id.trends_recommend_recycler)
    RecyclerView recommendRecycler;

    private FindChildCategoryAdapter mCategoryAdapter;
    private FindChildRecommendAdapter recommendAdapter;
    private List<FindChildCategoryBean> categoryBean = new ArrayList<>();
    private List<FindChildRecommendBean> recommendBean = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trends, null);
        unbinder = ButterKnife.bind(this, view);
        initView();
        return view;
    }

    private void initView() {

        mCategoryAdapter = new FindChildCategoryAdapter(getContext(), categoryBean);
        mCategoryAdapter.setOnItemClickListener(new FindChildCategoryAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void onLongClick(int position) {

            }
        });
        mCategoryAdapter.setHasStableIds(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        horizontalRecycler.setLayoutManager(layoutManager);
        horizontalRecycler.addItemDecoration(new RecycleViewDivider(
                getContext(), LinearLayoutManager.HORIZONTAL, 25, ContextCompat.getColor(getContext(), R.color.white)));
        horizontalRecycler.setAdapter(mCategoryAdapter);

        //推荐兴趣
        recommendAdapter = new FindChildRecommendAdapter(getContext(), recommendBean);
        recommendAdapter.setOnItemClickListener(new FindChildRecommendAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position) {

            }

            @Override
            public void onLongClick(int position) {

            }
        });
        recommendAdapter.setHasStableIds(true);
        LinearLayoutManager layoutManager2 = new LinearLayoutManager(getContext());
        layoutManager2.setOrientation(LinearLayoutManager.HORIZONTAL);
        recommendRecycler.setLayoutManager(layoutManager2);
        recommendRecycler.addItemDecoration(new RecycleViewDivider(
                getContext(), LinearLayoutManager.HORIZONTAL, 25, ContextCompat.getColor(getContext(), R.color.white)));
        recommendRecycler.setAdapter(recommendAdapter);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
