package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albert.rob.peachblossomrob.R;

/**
 * 动态
 * Created by admain on 2018/8/17.
 */

public class TrendsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_trends, null);
        return view;
    }
    public static TrendsFragment newInstance() {
        TrendsFragment fragment = new TrendsFragment();
        return fragment;
    }
}
