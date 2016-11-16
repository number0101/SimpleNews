package zeta.example.com.myapplication.entity;

/**
 * Created by Administrator on 2016/11/3 0003.
 */

public class NewsItem {
    String title;
    String lmodify;
    String url;
    String imgsrc;

    public String getLtitle() {
        return title;
    }

    public void setLtitle(String ltitle) {
        this.title = ltitle;
    }

    public String getLmodify() {
        return lmodify;
    }

    public void setLmodify(String lmodify) {
        this.lmodify = lmodify;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImgsrc() {
        return imgsrc;
    }

    public void setImgsrc(String imgsrc) {
        this.imgsrc = imgsrc;
    }
}
