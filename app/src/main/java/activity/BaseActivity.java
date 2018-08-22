package activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.albert.rob.peachblossomrob.R;
import com.gyf.barlibrary.ImmersionBar;

/**
 * Created by admain on 2018/8/20.
 */

public class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ImmersionBar.with(this)
                .statusBarColor(R.color.barColor)
                .statusBarDarkFont(true)
                .init(); //初始化，默认透明状态栏和黑色导航栏
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }
}
