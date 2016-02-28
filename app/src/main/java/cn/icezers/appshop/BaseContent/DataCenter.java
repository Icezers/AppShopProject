package cn.icezers.appshop.BaseContent;

import org.xutils.DbManager;

import java.util.List;

import cn.icezers.appshop.Model.BaseModel;

/**
 * Created by popze on 2016/2/24.
 */
public class DataCenter {


    public DbManager getDb() {
        return DataBase.getInstance(null);
    }

    public interface OnDataFindAllComplete {
        void onDateFindComplete(List list);
    }

    public interface OnDataFindComplete {
        void onDateFindComplete(BaseModel baseModel);
    }

}