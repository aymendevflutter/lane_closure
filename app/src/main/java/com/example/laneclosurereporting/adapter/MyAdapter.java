package com.example.laneclosurereporting.adapter;




import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.laneclosurereporting.R;
import com.example.laneclosurereporting.object.lanesData;
import com.example.laneclosurereporting.sharedpref.SharedPreferenceHelper;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<lanesData> itemList;
    private Context context;

    public MyAdapter( Context context) {

        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlane, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        lanesData item = SharedPreferenceHelper.getLanesDataList(context).get(position);
        try {
            holder.icon1.setImageResource(item.getSrcIcons() );

        }catch (Exception e){
            holder.icon1.setImageResource(R.color.blackn );

        }
        try {
            holder.icon2.setImageResource(item.getSrcIconsx() );

        }catch (Exception e){
            holder.icon2.setImageResource(R.color.blackn);



        }





        if( item.getNamesLanes().equals("-") ){
            holder.text.setText( item.getNamesLanesx()   );

        } else if( item.getNamesLanesx().equals("-")){
            holder.text.setText(  item.getNamesLanes()  );

        }else {
            holder.text.setText(  item.getNamesLanes() + "," +item.getNamesLanesx() );
        }






        holder.imageViewDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle delete action here
              //  notifyItemRemoved(position );

             //   if (position >= 0 && position < totallanes.size() +1) {
               //     totallanes.remove(position -1);

                int position = holder.getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    List<lanesData> totallanes = new ArrayList<>();
                    totallanes.addAll(SharedPreferenceHelper.getLanesDataList(context));
                    totallanes.remove(position);
                    SharedPreferenceHelper.saveLanesDataList(context, totallanes);
                    totallanes.clear();
                //    if (position == totallanes.size()) {
                        // If the removed item was the last one, use notifyDataSetChanged
                     //   notifyDataSetChanged();
               //     } else {
                        Handler handler = new Handler();
                        handler.postDelayed(new Runnable() {
                            @Override
                            public void run() {
                              //  if(position ==0){
                               //     totallanes.addAll(SharedPreferenceHelper.getLanesDataList(context));
                               //     totallanes.clear();
                               //     SharedPreferenceHelper.saveLanesDataList(context, SharedPreferenceHelper.getLanesDataList(context));

                               //     notifyDataSetChanged();
                                //    MyAdapter.this.notifyAll();


                               // }else{

                                    notifyItemChanged(position);
                                    notifyItemRemoved(position);
                                    notifyItemRangeChanged(position, SharedPreferenceHelper.getLanesDataList(context).size());
                                    notifyDataSetChanged();

                             //   }

                           //     MyAdapter.this.

                            }
                        }, 200); // Delay in milliseconds (e.g., 200ms)

                   // }
                } else {
                    List<lanesData> total = new ArrayList<>();
                    SharedPreferenceHelper.saveLanesDataList(context,total);
                    MyAdapter.this.notifyAll();
                }






            }
        });
    }

    @Override
    public int getItemCount() {
        return  SharedPreferenceHelper.getLanesDataList(context).size();
              //  totallanes.size();
                //itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView icon1;
        ImageView icon2;
        TextView text;
        ImageView imageViewDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            icon1 = itemView.findViewById(R.id.icon1);
            icon2 = itemView.findViewById(R.id.icon2);
            text = itemView.findViewById(R.id.text);
            imageViewDelete = itemView.findViewById(R.id.imageView2);
        }
    }
}
