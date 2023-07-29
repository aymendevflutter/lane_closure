package com.example.laneclosurereporting.fragment;

import static com.example.laneclosurereporting.ref.refs.first;
import static com.example.laneclosurereporting.ref.refs.lanesDataf;



import static com.example.laneclosurereporting.ref.refs.viewPager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.GridView;
import android.widget.Toast;

import com.example.laneclosurereporting.DataListener;
import com.example.laneclosurereporting.R;
import com.example.laneclosurereporting.adapter.CustomAdapter;
import com.example.laneclosurereporting.adapter.MyAdapter;
import com.example.laneclosurereporting.interf.OnViewPagerReadyListener;
import com.example.laneclosurereporting.object.ItemData;
import com.example.laneclosurereporting.object.lanesData;
import com.example.laneclosurereporting.ref.refs;
import com.example.laneclosurereporting.sharedpref.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class SelectLaneClosureFragment extends Fragment {
    CustomAdapter adapter;
    CustomAdapter adapterx;
    GridView gridView;
    GridView gridViewx;
    List<ItemData> items = new ArrayList<>();
    List<ItemData> itemsx = new ArrayList<>();











    private OnViewPagerReadyListener viewPagerReadyListener;





    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_select_lane_closure, container, false);




        items.add(new ItemData("Shoulder", R.drawable.ic_shoulder));
        items.add(new ItemData("Hov", R.drawable.ic_hov));
        items.add(new ItemData("Median", R.drawable.ic_median));
        items.add(new ItemData("Ramp", R.drawable.ic_ramp));
        items.add(new ItemData("Gore", R.drawable.ic_gore));
        List<ItemData> itemsx = new ArrayList<>();
        itemsx.add(new ItemData("Closed", R.drawable.ic_closed));
        itemsx.add(new ItemData("Unknown", R.drawable.ic_unknown));
        itemsx.add(new ItemData("Rolling", R.drawable.ic_rolling));
        itemsx.add(new ItemData("Blocked", R.drawable.ic_blocked));
        itemsx.add(new ItemData("Alternating", R.drawable.ic_alternating));
        itemsx.add(new ItemData("Intermittent", R.drawable.ic_intermittent));
        itemsx.add(new ItemData("Lanes Afected", R.drawable.ic_lanesaffected));

// Add more items as needed

        adapter = new CustomAdapter(getActivity(), items,true);
        adapterx = new CustomAdapter(getActivity(), itemsx,false);
        GridView gridView = view.findViewById(R.id.gridView);
        GridView gridViewx = view.findViewById(R.id.gridViewsecond);
        gridView.setAdapter(adapter);
        gridViewx.setAdapter(adapterx);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // Retrieve the clicked model object
                ItemData clickedModel = items.get(position);


            }
        });


        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button button = view.findViewById(R.id.save);
        Button button1 = view.findViewById(R.id.cancel);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanesDataf.Clear();
                adapterx.resetColors();
                adapter.resetColors();
                first = true;
                viewPager.setCurrentItem(0);

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle button click event
//                lanesDataf.setB(false);




                if(lanesDataf.isB()){
                    first = true;

                    lanesData lanesDatax = new lanesData();
                    lanesDatax.setSrcIconsx( lanesDataf.getSrcIconsx());
                    lanesDatax.setSrcIcons( lanesDataf.getSrcIcons());
                    lanesDatax.setNamesLanesx( lanesDataf.getNamesLanesx());
                    lanesDatax.setNamesLanes( lanesDataf.getNamesLanes());
                    List<lanesData>  totallanes =new ArrayList<>();

                    totallanes = SharedPreferenceHelper.getLanesDataList(getContext());
                    totallanes.add(lanesDatax);
                    SharedPreferenceHelper.saveLanesDataList(getActivity(), totallanes);

                    lanesDataf.Clear();
                    adapter.resetColors();
                    adapterx.resetColors();



               //     totallanes.clear();



                          }else {
                              Toast.makeText(getActivity(),"Nothing added",Toast.LENGTH_LONG).show();
                           }


                    int nextPage = viewPager.getCurrentItem()-1 ;
                refs.rolaodx = true;
                    viewPager.setCurrentItem(0);
            //    adapter.notifyDataSetChanged();


            }
        });

        if (viewPagerReadyListener != null) {
            viewPagerReadyListener.onViewPagerReady(viewPager);
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if(first){

        // Update the data set or perform any necessary actions
       // gridView.setAdapter(adapter);
        //gridViewx.setAdapter(adapterx);


        }

    }






}