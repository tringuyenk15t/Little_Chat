package com.app.tringuyen.littlechat.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.tringuyen.littlechat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tri Nguyen on 8/15/2016.
 */
public class ChatAdapter extends RecyclerView.Adapter {

    private List<String> chat_messanges = new ArrayList<>();
    public ChatAdapter (List<String> chat_messanges)
    {
        this.chat_messanges = chat_messanges;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_my_message,parent,false);
        ChatViewHolder viewHolder = new ChatViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ChatViewHolder)holder).textMessage.setText(chat_messanges.get(position));
    }

    public static class ChatViewHolder extends  RecyclerView.ViewHolder
    {
        public TextView textMessage;
        public ChatViewHolder(View itemView) {
            super(itemView);
            textMessage = (TextView) itemView.findViewById(R.id.mymessageTextView);
        }
    }
    public int getItemCount() {
        return chat_messanges.size();
    }
}
