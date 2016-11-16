package zeta.example.com.myapplication.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;

import zeta.example.com.myapplication.R;
import zeta.example.com.myapplication.adapter.MyFragmentPagerAdapter;
import zeta.example.com.myapplication.fragment.ConFragmentA;

public class MainActivity extends AppCompatActivity {
    Toolbar toolbar;
    TabLayout tabLayout;
    ViewPager viewPager;
    ImageView imageView;
    ArrayList<String> tabinfos;
    ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e("lifeprocess","+++++++++++++++onCreate");
        initview();
        tabinfos.add("头条");tabinfos.add("财经");tabinfos.add("科技");tabinfos.add("电影");
        Log.e("tabinfos","oncreat"+tabinfos);

        initData();
    }



    private void initview() {
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tablayout);
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        imageView = (ImageView) findViewById(R.id.img_add);

        tabinfos = new ArrayList<String>();
        fragments = new ArrayList<Fragment>();

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddActivity.class);
                Log.e("tabinfos","main send"+tabinfos+"");
                intent.putExtra("tabinfos",tabinfos);
                startActivityForResult(intent,1);
            }
        });
        //设置toolbar
        toolbar.setTitle("SimpleNews");
        toolbar.setNavigationIcon(R.drawable.btn_return);
        setSupportActionBar(toolbar);
        //设置bablayout
        tabLayout.setTabTextColors(R.color.green, R.color.red);
    }

    private void initData() {
//        int i =1;
        Log.e("tabinfos","tabLayout1"+tabLayout.getTabCount());
        tabLayout.removeAllTabs();
        Log.e("tabinfos","tabLayout2"+tabLayout.getTabCount());
        for (int i = 0;i <tabinfos.size();i++){
            tabLayout.addTab(tabLayout.newTab().setText(tabinfos.get(i)));
            ConFragmentA childfrag = new ConFragmentA();

            Bundle bundle = new Bundle();
            bundle.putString("title", tabinfos.get(i));
            childfrag.setArguments(bundle);
            fragments.add(childfrag);
        }
        Log.e("tabinfos","tabLayout3"+tabLayout.getTabCount());
        Log.e("tabinfos","before set adapter"+tabinfos);
        MyFragmentPagerAdapter fragAdapter = new MyFragmentPagerAdapter(getSupportFragmentManager(), fragments,tabinfos);
        viewPager.setAdapter(fragAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }


    //    创建menu和点击事件创建
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar_menu,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_share1:
                Toast.makeText(this,"share", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1&&resultCode == 2){
            tabinfos = (ArrayList<String>) data.getSerializableExtra("tabinfos2");
            Log.e("tabinfos","main get"+tabinfos);
        }
        initData();
    }
}
