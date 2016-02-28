package cn.icezers.appshop.FunctionPage.Search;

import android.os.Bundle;

import cn.icezers.appshop.BaseContent.BaseActivity;
import cn.icezers.appshop.R;
import me.imid.swipebacklayout.lib.SwipeBackLayout;

/**
 * Created by popze on 2016/2/28.
 */
public class SearchActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentNavigation(false);
        setTranslucentStatus(true);
        setContentView(R.layout.search_activity);
        mSwipeBackLayout = getSwipeBackLayout();
        mSwipeBackLayout.setEdgeTrackingEnabled(SwipeBackLayout.EDGE_LEFT);
    }
}
