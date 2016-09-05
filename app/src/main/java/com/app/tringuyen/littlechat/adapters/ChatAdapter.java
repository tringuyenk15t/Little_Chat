package com.app.tringuyen.littlechat.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.tringuyen.littlechat.R;
import com.app.tringuyen.littlechat.models.Message;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tri Nguyen on 8/15/2016.
 */
public class ChatAdapter extends RecyclerView.Adapter {


    private List<Message> messageList = new ArrayList<>();
    private final int SEND = 1, RECEIVED = 0;

    public ChatAdapter (List<Message> messageList)
    {
        this.messageList = messageList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        RecyclerView.ViewHolder viewHolder;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        if (viewType == SEND)
        {
            View sendMessageView = inflater.inflate(R.layout.layout_send_message,parent,false);
            viewHolder = new SendMessageViewHolder(sendMessageView);
        }
        else
        {
            View recievedMessageView = inflater.inflate(R.layout.layout_received_message,parent,false);
            viewHolder = new RecievedMessageViewHolder(recievedMessageView);
        }
        return viewHolder;
    }

    @Override
    public int getItemViewType(int position) {
        if (messageList.get(position).isCreatedByMe() == true)
            return 1;
        else
            return 0;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder.getItemViewType() == SEND)
        {
            SendMessageViewHolder vhs  = (SendMessageViewHolder) holder;
            setSendMessage(vhs,position);
        }
        else
        {
            RecievedMessageViewHolder vhr = (RecievedMessageViewHolder) holder;
            setRecievedMessage(vhr,position);
        }
    }

    private void setRecievedMessage(RecievedMessageViewHolder vhr, int position)
    {
        vhr.getMessage().setText(messageList.get(position).getMessage());
    }

    private void setSendMessage(SendMessageViewHolder vhs, int position) {
        vhs.getMessage().setText(messageList.get(position).getMessage());
    }

    public int getItemCount() {
        return messageList.size();
    }
}
