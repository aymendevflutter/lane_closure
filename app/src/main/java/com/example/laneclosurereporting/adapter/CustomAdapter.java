package com.example.laneclosurereporting.adapter;

import static com.example.laneclosurereporting.ref.refs.again;
import static com.example.laneclosurereporting.ref.refs.lanesDataf;



import android.content.Context;
import android.graphics.Color;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;



import com.example.laneclosurereporting.R;
import com.example.laneclosurereporting.object.ItemData;
import com.example.laneclosurereporting.object.lanesData;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater mInflater;
    private List<ItemData> mItems;
    private int clickedPosition = -1;
    private boolean mcheck;

    public CustomAdapter(Context context, List<ItemData> items,boolean check) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
        mItems = items;
        mcheck = check;
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Object getItem(int position) {
        return mItems.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.itembox, parent, false);
            holder = new ViewHolder();
            holder.imageView = convertView.findViewById(R.id.imageView);
            holder.textView = convertView.findViewById(R.id.textView);
            holder.linearLayout = convertView.findViewById(R.id.linear);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        final ItemData item = mItems.get(position);
        holder.imageView.setImageResource(item.getImageSrc());
        holder.textView.setText(item.getName());



        if (position != clickedPosition) {

                holder.linearLayout.setBackgroundResource(R.drawable.round_light_grey_bg);
                holder.imageView.setColorFilter(null);
                holder.textView.setTextColor(Color.BLACK);
                again =!again;

        }

        holder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanesDataf.setB(false);
                if(holder.imageView.getColorFilter() == null){
                   holder.linearLayout.setBackgroundResource(R.drawable.round_setting_bg);
                    holder.imageView.setColorFilter(Color.WHITE);
                    holder.textView.setTextColor(Color.WHITE);

                    if(mcheck){

                        lanesDataf.setB(true);
                        lanesDataf.setNamesLanes("");
                        lanesDataf.setSrcIcons(R.color.blackn);



                        lanesDataf.setNamesLanes(mItems.get(position).getName());
                        lanesDataf.setSrcIcons(mItems.get(position).getImageSrc());

                    }else {
                        lanesDataf.setB(true);



                        lanesDataf.setNamesLanesx("");
                        lanesDataf.setSrcIconsx(R.color.blackn);
                        lanesDataf.setNamesLanesx(mItems.get(position).getName());
                        lanesDataf.setSrcIconsx(mItems.get(position).getImageSrc());


                    }

                    again  = false;}
                else {
                    holder.linearLayout.setBackgroundResource(R.drawable.round_light_grey_bg);
                    holder.imageView.setColorFilter(null);
                    holder.textView.setTextColor(Color.BLACK);
                    again = true;
                }
               ;



                clickedPosition = position;


                notifyDataSetChanged();
            }
        });

        return convertView;
    }

    private static class ViewHolder {
        ImageView imageView;
        TextView textView;
        LinearLayout linearLayout;
    }
    public void resetColors() {
        clickedPosition = -1;
        notifyDataSetChanged();
    }
}


