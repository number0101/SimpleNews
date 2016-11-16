package zeta.example.com.myapplication.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.NetworkImageView;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import zeta.example.com.myapplication.R;
import zeta.example.com.myapplication.Util.BitmapCache;
import zeta.example.com.myapplication.Util.DividerItemDecoration;
import zeta.example.com.myapplication.activity.Show;
import zeta.example.com.myapplication.adapter.NewsAdapter;
import zeta.example.com.myapplication.entity.NewsItem;
import zeta.example.com.myapplication.myInterface.FragmentCreated;
import zeta.example.com.myapplication.tools.Contans;
import zeta.example.com.myapplication.tools.Url;

/**
 * Created by Administrator on 2016/10/26 0026.
 */

public class ConFragmentA extends Fragment{
    NetworkImageView imageView;
    TextView textView;
    RecyclerView recyclerView;
    JSONArray jsonArray;
    List<NewsItem> newsItems;
    Gson gson;
    String title;
    NewsAdapter mAdapter;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arg = getArguments();
        title = arg.getString("title");
        gson = new Gson();



        Log.e("lifeprocess","-----------2---------onCreate");
    }
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_a,container,false);
        imageView = (NetworkImageView) view.findViewById(R.id.img_head_title);
        textView = (TextView) view.findViewById(R.id.tv_head_title);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL_LIST));
        Log.e("lifeprocess","--------3-----------onCreateView");
        return view;

    }

    @Override
    public void registerForContextMenu(View view) {
        super.registerForContextMenu(view);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Log.e("lifeprocess","---------4----------onActivityCreated");
        super.onActivityCreated(savedInstanceState);

        volleyGetJson(0);


    }


    //获取index之后的20条数据，并返回NewsItem的对象集合
    private List<NewsItem> volleyGetJson(int index) {
        //获取一个RequestQueue对象
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        JsonObjectRequest jor = new JsonObjectRequest(
                Contans.getdata(title,index),
                null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    jsonArray = response.getJSONArray(Contans.getid(title));
                } catch (JSONException e) {
                    e.printStackTrace();
                }
//                String str = getResources().getString(R.string.json2);
                newsItems = gson.fromJson(jsonArray.toString(), new TypeToken<List<NewsItem>>(){}.getType());
                if(newsItems != null){
                    setImage(imageView,newsItems.get(0).getImgsrc());
                    textView.setText(newsItems.get(0).getLtitle());
                    newsItems.remove(0);
                    mAdapter = new NewsAdapter(newsItems,getActivity());
                    recyclerView.setAdapter(mAdapter);
                    initEvent();
                }
//                Log.e("lifeprocess0000","-----------2---------onCreate"+newsItems);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("lifeprocess", "eeeeeeeeeeeeeeeeeeeee"+error);
            }
        });
        mQueue.add(jor);
        return newsItems;
    }

    void setImage(NetworkImageView img,String url){
        RequestQueue mQueue = Volley.newRequestQueue(getActivity());
        ImageLoader imageLoader = new ImageLoader(mQueue, new BitmapCache());
        img.setDefaultImageResId(R.drawable.load_progress1);
        img.setErrorImageResId(R.drawable.load_erro);
        img.setImageUrl(url, imageLoader);
    }

    private void initEvent(){
        mAdapter.setOnItemClickListener(new NewsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Bundle bundle= new Bundle();
                bundle.putString("3gurl",newsItems.get(position).getUrl());
                Intent intent = new Intent(getActivity(),Show.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }

        });
    }














    public void onAttach(Context activity) {
        super.onAttach(activity);
//        Log.e("lifeprocess","nnnnnnnnnnnum" + num);
//        try
//        {
//            fragmentCreated = (FragmentCreated) activity;
//            Log.e("interfacecreated","已经继承接口" );
//        }catch (Exception e)
//        {
//            throw new ClassCastException(activity.toString()+
//                    "必须继承接口");
//        }
        Log.e("lifeprocess","----------1---------onAttach");
    }


    public void onStart() {
        super.onStart();
        Log.e("lifeprocess","-----------5---------onStart");
    }


    @Override
    public void onResume() {
        super.onResume();
//        textView.setText("i = "+i);
        Log.e("lifeprocess","---------6---------onResume");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.e("lifeprocess","----------7---------onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.e("lifeprocess","----------8--------onStop");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.e("lifeprocess","----------9--------onDestroyView");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.e("lifeprocess","--------10---------onDestroy");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.e("lifeprocess","--------11:kill---------onDetach");
    }
}
