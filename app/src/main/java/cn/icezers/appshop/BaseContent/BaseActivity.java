package cn.icezers.appshop.BaseContent;

import android.os.Bundle;
import android.view.WindowManager;

import me.imid.swipebacklayout.lib.SwipeBackLayout;
import me.imid.swipebacklayout.lib.app.SwipeBackActivity;

/**
 * Created by popze on 2016/2/24.
 */
public class BaseActivity extends SwipeBackActivity {

    public SwipeBackLayout mSwipeBackLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

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
