package zeta.example.com.myapplication.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;

import java.util.ArrayList;

import zeta.example.com.myapplication.R;
import zeta.example.com.myapplication.adapter.AddAdapter;

public class AddActivity extends AppCompatActivity {
    RecyclerView rvExist,rvNot;
    AddAdapter addAdapter1,addAdapter2;
    ArrayList<String> tabinfos1,tabinfos2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_infos);


        rvExist = (RecyclerView) findViewById(R.id.rv_exist);
        rvNot = (RecyclerView) findViewById(R.id.rv_not);
        rvExist.setLayoutManager(new GridLayoutManager(this,4));
        rvNot.setLayoutManager(new GridLayoutManager(this,4));
        rvExist.setItemAnimator(new DefaultItemAnimator());
        rvNot.setItemAnimator(new DefaultItemAnimator());
        initData();
        addAdapter1 = new AddAdapter(tabinfos1,this);
        addAdapter2 = new AddAdapter(tabinfos2,this);
        initEvent();

        rvExist.setAdapter(addAdapter1);
        rvNot.setAdapter(addAdapter2);


    }


    private void initData(){
        tabinfos2 = new ArrayList<>();
        tabinfos1 = new ArrayList<>();
        tabinfos2.add("手机");
        tabinfos2.add("汽车");
        tabinfos2.add("暴雪");

        Intent intent = getIntent();
        tabinfos1 = (ArrayList<String>) intent.getSerializableExtra("tabinfos");
        Log.e("tabinfos","add get"+tabinfos1+"");
    }
    private void initEvent(){
        addAdapter1.setOnItemClickListener(new AddAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                addAdapter2.addData(tabinfos1.get(position));
                addAdapter1.removeData(position);
            }
        });
        addAdapter2.setOnItemClickListener(new AddAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                addAdapter1.addData(tabinfos2.get(position));
                addAdapter2.removeData(position);
            }
        });

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Intent intent = new Intent();
        intent.putExtra("tabinfos2",tabinfos1);
        Log.e("tabinfos","add send"+tabinfos1+"");
        setResult(2,intent);
        Log.e("tabinfos","on key down");
        return super.onKeyDown(keyCode, event);
    }
}
