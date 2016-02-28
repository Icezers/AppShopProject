package cn.icezers.appshop.BaseContent;

import android.app.Application;

import org.xutils.x;

/**
 * Created by popze on 2016/2/24.
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        DataBase.setContext(this);
    }
}
