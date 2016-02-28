package cn.icezers.appshop.BaseContent;

import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

/**
 * Created by popze on 2016/2/24.
 */
public class BaseFragmentActivity extends FragmentActivity {

    public void setTranslucentStatus(boolean isTranslucent) {
        //透明状态栏
        if (isTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }
    }

    public void setTranslucentNavigation(boolean isTranslucent) {
        //透明导航栏
        if (isTranslucent) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
        }
    }

}
