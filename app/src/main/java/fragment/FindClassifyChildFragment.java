package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albert.rob.peachblossomrob.R;

/**
 * 子页分类
 * Created by admain on 2018/8/23.
 */

public class FindClassifyChildFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trends, null);
        return view;
    }
}
