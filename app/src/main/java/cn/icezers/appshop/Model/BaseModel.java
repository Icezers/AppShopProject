package cn.icezers.appshop.Model;

import org.xutils.db.annotation.Column;

import java.io.Serializable;

/**
 * Created by popze on 2016/2/27.
 */
public class BaseModel implements Serializable {

    @Column(name = "id", isId = true, autoGen = true)
    public long id;

    @Column(name = "uuid")
    public long uuid;

    @Column(name = "stime")
    public long stime;

}
