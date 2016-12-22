package com.brandongogetap.stickyheaders.demo;

import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import com.brandongogetap.stickyheaders.exposed.Item;
import com.brandongogetap.stickyheaders.exposed.StickyHeaderHandler;

import java.util.List;

import static android.view.LayoutInflater.from;

final class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.BaseViewHolder>
        implements StickyHeaderHandler {

    private final List<MyItem> data;

    RecyclerAdapter(List<MyItem> data) {
        this.data = data;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        final BaseViewHolder viewHolder;
        if (viewType == 0) {
            viewHolder = new MyViewHolder(view);
        } else {
            viewHolder = new MyOtherViewHolder(view);
        }
        return viewHolder;
    }

    @Override public void onBindViewHolder(BaseViewHolder holder, int position) {
        MyItem item = data.get(position);
        holder.titleTextView.setText(item.title);
        holder.messageTextView.setText(item.message);

        holder.itemView.setPadding(0, 0, 0, 0);

        if (item.isHeader()) {
            holder.itemView.setBackgroundColor(Color.CYAN);
        } else {
            holder.itemView.setBackgroundColor(Color.TRANSPARENT);
        }

        holder.titleTextView.setOnClickListener(new buttonClickListener(position));
    }

    private class buttonClickListener implements OnClickListener {

        int position;

        buttonClickListener(int i){
            position = i;
        }

        @Override
        public void onClick(View view) {
            MyItem item = data.get(position);

            if(item.isHeader()) {
                item.setIsHeader(false);
            } else {
                item.setIsHeader(true);
            }

            notifyItemChanged(position);
        }
    }

    @Override public int getItemCount() {
        return data.size();
    }

    @Override public int getItemViewType(int position) {
        return 0;
    }

    @Override public List<? extends Item> getAdapterData() {
        return data;
    }

    private static final class MyViewHolder extends BaseViewHolder {

        MyViewHolder(View itemView) {
            super(itemView);
        }
    }

    private static final class MyOtherViewHolder extends BaseViewHolder {

        MyOtherViewHolder(View itemView) {
            super(itemView);
        }
    }

    static class BaseViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView;
        TextView messageTextView;

        BaseViewHolder(View itemView) {
            super(itemView);
            titleTextView = (TextView) itemView.findViewById(R.id.tv_title);
            messageTextView = (TextView) itemView.findViewById(R.id.tv_message);
        }
    }
}
