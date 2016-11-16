package zeta.example.com.myapplication.tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import zeta.example.com.myapplication.entity.NewsClassfy;

/**
 * Created by Administrator on 2016/11/1 0001.
 */

public class Contans {

    public static String getdata(String s,int index){
        String url;
        Map<String,String> newsContans = new HashMap<>();
        newsContans.put("头条",Url.TopUrl+Url.TopId + "/" + index +Url.endUrl);
        newsContans.put("财经",Url.CommonUrl + Url.CaiJingId + "/" + index +Url.endUrl);
        newsContans.put("科技",Url.CommonUrl + Url.KeJiId + "/" + index +Url.endUrl);
        newsContans.put("电影",Url.CommonUrl + Url.DianYingId + "/" + index +Url.endUrl);
        newsContans.put("手机",Url.CommonUrl + Url.ShouJiId + "/" + index +Url.endUrl);
        newsContans.put("汽车",Url.CommonUrl + Url.QiChiId + "/" + index +Url.endUrl);
        newsContans.put("暴雪",Url.CommonUrl + Url.BaoXueId + "/" + index +Url.endUrl);

        url = newsContans.get(s);
        return url;
    }
    public static String getid(String s){
        String id;
        Map<String,String> newsContans = new HashMap<>();
        newsContans.put("头条",Url.TopId );
        newsContans.put("财经",Url.CaiJingId );
        newsContans.put("科技",Url.KeJiId );
        newsContans.put("电影",Url.DianYingId);
        newsContans.put("手机",Url.ShouJiId );
        newsContans.put("汽车",Url.QiChiId);
        newsContans.put("暴雪",Url.BaoXueId);


        id = newsContans.get(s);
        return id;
    }
}
