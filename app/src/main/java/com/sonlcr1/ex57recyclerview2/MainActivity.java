package com.sonlcr1.ex57recyclerview2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Item> items = new ArrayList<>();

    MyAdapter adapter;
    RecyclerAdapter recyclerAdapter;
    RecyclerView recyclerView;
    ViewPager viewPager;
    FragmentAdapter fragmentAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //대량의 데이터 추가(실무에서는 DB나 서버에서 데이터를 읽어옴)
        items.add( new Item("루피","해적단선장",R.drawable.bg_one01,"https://kr.hypebeast.com/files/2018/07/one-piece-manga-80-percent-finished-2018-00.jpg") );
        items.add( new Item("조로","해적단부선장",R.drawable.bg_one02,"https://mblogthumb-phinf.pstatic.net/20150629_221/luminous1998_1435588222343ode5v_JPEG/ONE_PIECE_full_800264.jpg?type=w800") );
        items.add( new Item("나미","해적단항해사",R.drawable.bg_one03,"https://www.beinews.net/news/photo/201911/29208_25980_4211.jpg") );
        items.add( new Item("우솝","해적단저격수",R.drawable.bg_one04,"https://i.pinimg.com/originals/be/d7/e9/bed7e9990a800bb0a886e5539ae1cdeb.png") );

        adapter = new MyAdapter(this,items );
        //recyclerView = findViewById(R.id.recycler);
        //recyclerView.setAdapter(adapter);

        //리사이클러뷰 가로방향으로 한페이지씩 넘기기
//          LinearLayoutManager mManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
//          recyclerView.setLayoutManager(mManager);
//          SnapHelper snapHelper = new PagerSnapHelper();
//          snapHelper.attachToRecyclerView(recyclerView);

        fragmentAdapter = new FragmentAdapter(getSupportFragmentManager());
        viewPager = findViewById(R.id.viewpager);
        viewPager.setAdapter(fragmentAdapter);





    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.optionmenu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch ( item.getItemId() ){
            case R.id.aa:   //Linear
                RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
                //세번째 파라미터 : 리버스 기법 아래에서 위로 올라가게끔 방향정하는 파라미터
                recyclerView.setLayoutManager(layoutManager);
                break;
            case R.id.bb:   //Grid
                RecyclerView.LayoutManager layoutManager1 = new GridLayoutManager(this,2);
                recyclerView.setLayoutManager(layoutManager1);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
