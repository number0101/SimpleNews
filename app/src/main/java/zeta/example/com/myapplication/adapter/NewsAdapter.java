package zeta.example.com.myapplication.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;

import java.util.List;

import zeta.example.com.myapplication.R;
import zeta.example.com.myapplication.Util.BitmapCache;
import zeta.example.com.myapplication.entity.NewsItem;
import zeta.example.com.myapplication.fragment.ConFragmentA;

/**
 * Created by Administrator on 2016/11/7 0007.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.MyViewHolder> {
    private List<NewsItem> datas;
    private Context context;
    private OnItemClickListener mOnItemClickListener;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener){
        this.mOnItemClickListener = mOnItemClickListener;
    }

    public NewsAdapter(List<NewsItem> datas,Context context) {
        this.datas = datas;
        this.context = context;
    }

    @Override
    public NewsAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        NewsAdapter.MyViewHolder holder = new NewsAdapter.MyViewHolder(LayoutInflater.from(context).inflate(R.layout.news_item, parent, false));

        return holder;
    }


    @Override
    public void onBindViewHolder(final NewsAdapter.MyViewHolder holder,  int position) {
        holder.tvTime.setText(datas.get(position).getLmodify());
        holder.tvTitle.setText(datas.get(position).getLtitle());
        setImage(holder.img,datas.get(position).getImgsrc());

        if(mOnItemClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.itemView,pos);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        NetworkImageView img;
        TextView tvTitle, tvTime;

        public MyViewHolder(View itemView) {
            super(itemView);
            img = (NetworkImageView) itemView.findViewById(R.id.img_item);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_item_title);
            tvTime = (TextView) itemView.findViewById(R.id.tv_item_time);

        }
    }



    void setImage(NetworkImageView img,String url){
        RequestQueue mQueue = Volley.newRequestQueue(context);
        ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
        img.setDefaultImageResId(R.drawable.load_progress1);
        img.setErrorImageResId(R.drawable.load_erro);
        img.setImageUrl(url, imageLoader);
    }
}