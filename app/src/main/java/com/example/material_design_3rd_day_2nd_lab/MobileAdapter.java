package com.example.material_design_3rd_day_2nd_lab;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MobileAdapter extends RecyclerView.Adapter<MobileAdapter.ViewHolder> {

    private final Context context;
    private ArrayList<Mobile> values;

    public MobileAdapter(Context context, ArrayList<Mobile> values) {
        this.context = context;
        this.values = values;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.recycler_view_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Mobile mobile = values.get(position);
        holder.title.setText(mobile.getTitle());
        holder.description.setText(mobile.getDescription());
        String brand = mobile.getBrand();

        switch (brand) {
            case "Oppo":
                holder.mobile_image.setImageResource(R.drawable.oppo);
                break;
            case "Apple":
                holder.mobile_image.setImageResource(R.drawable.apple);
                break;
            case "Samsung":
                holder.mobile_image.setImageResource(R.drawable.samsung_8);
                break;
            default:
                holder.mobile_image.setImageResource(R.drawable.ic_launcher_foreground);
        }
    }

    @Override
    public int getItemCount() {
        return values.size();
    }

    public void updateList(ArrayList<Mobile> newList) {
        this.values = newList;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View layout;
        public TextView title;
        public TextView description;

        ImageView mobile_image;

        public ViewHolder(View view) {
            super(view);
            this.layout = view;

            title = view.findViewById(R.id.mobile_item_title_text_view);
            description = view.findViewById(R.id.mobile_item_desc_text_view);
            mobile_image = view.findViewById(R.id.mobile_Item_image_view);

        }

    }
}
