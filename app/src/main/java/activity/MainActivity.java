package activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.albert.rob.peachblossomrob.R;
import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;

import java.lang.reflect.Field;

import butterknife.BindView;
import butterknife.ButterKnife;
import fragment.FindFragment;
import fragment.HomeFragment;
import fragment.MyFragment;
import fragment.TrendsFragment;

public class MainActivity extends BaseActivity implements BottomNavigationBar.OnTabSelectedListener {

    @BindView(R.id.bottom_navigation_bar)
    BottomNavigationBar mBottomNavigationBar;
    @BindView(R.id.fragment_container)
    FrameLayout fragmentContainer;

    private HomeFragment mHomeFragment;
    private FindFragment mFindFragment;
    private TrendsFragment mTrendsFragment;
    private MyFragment mMyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        initView();
    }

    private void initView() {
        mBottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED)
                .setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC)
                .setTabSelectedListener(this);

        mBottomNavigationBar
                .addItem(new BottomNavigationItem(R.mipmap.flower_black, null)
                        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.mipmap.flower_gray)))
                .addItem(new BottomNavigationItem(R.mipmap.find_black, null)
                        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.mipmap.find_gray)))
                .addItem(new BottomNavigationItem(R.mipmap.trends_black, null)
                        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.mipmap.trends_gray)))
                .addItem(new BottomNavigationItem(R.mipmap.my_black, null)
                        .setInactiveIcon(ContextCompat.getDrawable(MainActivity.this, R.mipmap.my_gray)))
                .setFirstSelectedPosition(0)//设置默认选择的按钮
                .initialise();//所有的设置需在调用该方法前完成
        setBottomNavigationItem(mBottomNavigationBar,0,27,0);
        setDefaultFragment();
    }
    /**
     @param bottomNavigationBar，需要修改的 BottomNavigationBar
     @param space 图片与文字之间的间距
     @param imgLen 单位：dp，图片大小，应 <= 36dp
     @param textSize 单位：dp，文字大小，应 <= 20dp

     使用方法：直接调用setBottomNavigationItem(bottomNavigationBar, 6, 26, 10);
     代表将bottomNavigationBar的文字大小设置为10dp，图片大小为26dp，二者间间距为6dp
     **/
    private void setBottomNavigationItem(BottomNavigationBar bottomNavigationBar, int space, int imgLen, int textSize){
        Class barClass = bottomNavigationBar.getClass();
        Field[] fields = barClass.getDeclaredFields();
        for(int i = 0; i < fields.length; i++){
            Field field = fields[i];
            field.setAccessible(true);
            if(field.getName().equals("mTabContainer")){
                try{
                    //反射得到 mTabContainer
                    LinearLayout mTabContainer = (LinearLayout) field.get(bottomNavigationBar);
                    for(int j = 0; j < mTabContainer.getChildCount(); j++){
                        //获取到容器内的各个Tab
                        View view = mTabContainer.getChildAt(j);
                        //获取到Tab内的各个显示控件
                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, dip2px(55));
                        FrameLayout container = (FrameLayout) view.findViewById(R.id.fixed_bottom_navigation_container);
                        container.setLayoutParams(params);
                        container.setPadding(dip2px(12),dip2px(0), dip2px(12), dip2px(0));


                        //获取到Tab内的文字控件
                        TextView labelView = (TextView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_title);
                        labelView.setVisibility(View.GONE);

                        //获取到Tab内的图像控件
                        ImageView iconView = (ImageView) view.findViewById(com.ashokvarma.bottomnavigation.R.id.fixed_bottom_navigation_icon);
                        //设置图片参数，其中，MethodUtils.dip2px()：换算dp值
                        params = new FrameLayout.LayoutParams(dip2px(imgLen), dip2px(imgLen));
                        params.gravity = Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL;
                        iconView.setLayoutParams(params);
//                        iconView.setPadding(0,10,0,0);

                    }
                } catch (IllegalAccessException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public int dip2px(float dpValue) {
        final float scale = getApplication().getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
    /**
     * 设置默认导航栏
     */
    private void setDefaultFragment() {
        FragmentManager fm = getFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        mHomeFragment = HomeFragment.newInstance();
        transaction.replace(R.id.fragment_container, mHomeFragment);
        transaction.commit();
    }

    /**
     * 设置导航选中的事件
     */
    @Override
    public void onTabSelected(int position) {
        FragmentManager fm = this.getFragmentManager();
        //开启事务
        FragmentTransaction transaction = fm.beginTransaction();
        switch (position) {
            case 0:
                if (mHomeFragment == null) {
                    mHomeFragment =  HomeFragment.newInstance();
                }
                transaction.replace(R.id.fragment_container, mHomeFragment);
                break;
            case 1:
                if (mFindFragment == null) {
                    mFindFragment = FindFragment.newInstance();
                }
                transaction.replace(R.id.fragment_container, mFindFragment);
                break;
            case 2:
                if (mTrendsFragment == null) {
                    mTrendsFragment = TrendsFragment.newInstance();
                }
                transaction.replace(R.id.fragment_container, mTrendsFragment);
                break;
            case 3:
                if (mMyFragment == null) {
                    mMyFragment = MyFragment.newInstance();
                }
                transaction.replace(R.id.fragment_container, mMyFragment);
                break;

            default:
                break;
        }

        transaction.commit();// 事务提交
    }

    /**
     * 设置未选中Fragment 事务
     */
    @Override
    public void onTabUnselected(int position) {
    }

    /**
     * 设置释放Fragment 事务
     */
    @Override
    public void onTabReselected(int position) {
    }
}
