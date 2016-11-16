package zeta.example.com.myapplication.Util;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by Adamlambert on 2016/10/13.
 */
public class BitmapCache implements ImageLoader.ImageCache{

    private LruCache<String,Bitmap> mCache;
    public BitmapCache()
    {
        //缓存图片的大小设置10M
        int maxSize = 10 * 1024 *1024;
        mCache = new LruCache<String, Bitmap>(maxSize){
            @Override
            protected int sizeOf(String key, Bitmap value) {
                return value.getRowBytes()*value.getHeight();
            }
        };
    }
    //从缓存中获取图片。
    @Override
    public Bitmap getBitmap(String url) {
        return mCache.get(url);
    }
    //将请求到的网络图片加入到内存缓存中。
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        mCache.put(url,bitmap);
    }
}
