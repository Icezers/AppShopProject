package cn.icezers.appshop.Model;

import org.xutils.db.annotation.Column;
import org.xutils.db.annotation.Table;

/**
 * Created by popze on 2016/2/27.
 */

@Table(name = "apps")
public class Apps extends BaseModel {

    @Column(name = "name")
    public String name;

    @Column(name = "desc")
    public String desc;

    @Column(name = "url")
    public String url;

}
