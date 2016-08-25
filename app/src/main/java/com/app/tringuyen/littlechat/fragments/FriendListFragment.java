package com.app.tringuyen.littlechat.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.tringuyen.littlechat.R;

import java.util.ArrayList;
import java.util.List;


public class FriendListFragment extends Fragment {

    private RecyclerView friedlistContainer;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    List<String> friendlist;

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_friend_list, container, false);
        friedlistContainer = (RecyclerView) v.findViewById(R.id.firend_list_container);
        friendlist = new ArrayList<>();
        setFriendListItem(30);
        layoutManager = new LinearLayoutManager(getContext());
        adapter = new FriendListAdapter(friendlist);
        friedlistContainer.setAdapter(adapter);
        friedlistContainer.setLayoutManager(layoutManager);
        return v;
    }

    private void setFriendListItem(int number) {
        for(int i = 0; i < number; i++)
        {
            friendlist.add("Item" + i);
        }
    }


}
