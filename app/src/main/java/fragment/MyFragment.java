package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.albert.rob.peachblossomrob.R;

/**
 * 我的
 * Created by admain on 2018/8/17.
 */

public class MyFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_my, null);
        return view;
    }
    public static MyFragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }
}
