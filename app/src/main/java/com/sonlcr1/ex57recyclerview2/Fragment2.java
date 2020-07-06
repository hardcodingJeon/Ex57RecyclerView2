package com.sonlcr1.ex57recyclerview2;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import java.util.ArrayList;

public class Fragment2 extends Fragment {

    ArrayList<String> datas = new ArrayList<>();
    RecyclerView recyclerView;
    RecyclerAdapter adapter;
    Context context;
    FragmentActivity activity;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fragment2,container,false);

        datas.add("#111");
        datas.add("#222");
        datas.add("#333");
        datas.add("#444");

        context = getContext();
        activity = getActivity();



        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter = new RecyclerAdapter(context,datas);
        recyclerView = activity.findViewById(R.id.recycler);
        recyclerView.setAdapter(adapter);

        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerView);


    }
}
