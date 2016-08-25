package com.app.tringuyen.littlechat.fragments;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.tringuyen.littlechat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tri Nguyen on 8/12/2016.
 */
public class FriendListAdapter extends RecyclerView.Adapter {

    private List<String> friendList = new ArrayList<>();

    public FriendListAdapter (List<String> friendList)
    {
        this.friendList = friendList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_friend_list_item,parent,false);
        FriendListViewHolder viewHolder = new FriendListViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((FriendListViewHolder)holder).friendName.setText(friendList.get(position));
    }

    public static class FriendListViewHolder extends RecyclerView.ViewHolder
    {
        public TextView friendName;
        public FriendListViewHolder(View itemView) {
            super(itemView);
            friendName = (TextView) itemView.findViewById(R.id.friend_name);
        }
    }

    @Override
    public int getItemCount() {
        return friendList.size();
    }
}
