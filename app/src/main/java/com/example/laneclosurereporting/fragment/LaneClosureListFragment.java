package com.example.laneclosurereporting.fragment;

import static com.example.laneclosurereporting.ref.refs.lanesDataf;



import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import com.example.laneclosurereporting.R;
import com.example.laneclosurereporting.adapter.MyAdapter;
import com.example.laneclosurereporting.object.lanesData;
import com.example.laneclosurereporting.ref.refs;
import com.example.laneclosurereporting.sharedpref.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;


public class LaneClosureListFragment extends Fragment {
    private RecyclerView recyclerView;
    Button button;
    LinearLayout  linearLayout;
    private MyAdapter adapter;
    RecyclerView.AdapterDataObserver observer;
    public void updateRecyclerView(List<String> data) {
       // dataList.clear();
      //  .addAll(data);
        adapter.notifyDataSetChanged();
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lane_closure_list, container, false);





        return view ;
    }



        private void reloadFragment() {
        if(refs.rolaodx ){
            FragmentManager fragmentManager = getParentFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            // Replace the current instance of the fragment with a new instance
            fragmentTransaction.replace(R.id.viewPager, new LaneClosureListFragment());



            // Commit the fragment transaction
            fragmentTransaction.commit();}
        }



    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
         linearLayout = view.findViewById(R.id.lin);


        recyclerView = view.findViewById(R.id.recycel);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        LaneClosureListFragment laneClosureListFragment = new LaneClosureListFragment();


        adapter= new MyAdapter( getContext());

        recyclerView.setAdapter(adapter);
        if (recyclerView.getAdapter().getItemCount() != 0  && (SharedPreferenceHelper.getLanesDataList(getContext()) != null || !SharedPreferenceHelper.getLanesDataList(getContext()).isEmpty())  ) {
            linearLayout.setVisibility(View.GONE);
        }else {
            linearLayout.setVisibility(View.VISIBLE);
        }
        observer = new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                if (adapter.getItemCount() == 0) {


                    linearLayout.setVisibility(View.VISIBLE);


                }else {
                    linearLayout.setVisibility(View.GONE);

                }
            }
        };
        adapter.registerAdapterDataObserver(observer);







    }
     public  void update(){
         recyclerView.setAdapter(adapter);
    }
    @Override
    public void onDestroyView() {
        super.onDestroyView();
        adapter.unregisterAdapterDataObserver(observer);
    }

    @Override
    public void onResume() {
        super.onResume();
        adapter.notifyItemChanged(0);

        // Update the data set or perform any necessary actions
        adapter.notifyDataSetChanged();
        if (recyclerView.getAdapter().getItemCount() != 0) {
            linearLayout.setVisibility(View.GONE);
        }else {
            linearLayout.setVisibility(View.VISIBLE);
        }

    }
}