package com.app.tringuyen.littlechat.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;

import com.app.tringuyen.littlechat.adapters.ChatAdapter;
import com.app.tringuyen.littlechat.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Tri Nguyen on 8/10/2016.
 */
public class ChatFragment extends Fragment {
    private RecyclerView.LayoutManager layoutManager;
    public ChatFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_chat,container,false);
        List<String> info = new ArrayList<>();
        for (int i= 0; i< 30; i++)
        {
            info.add("Item" + i);
        }
        RecyclerView.Adapter adapter = new ChatAdapter(info);
        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.message_list);
        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        v.clearFocus();
        return v;
    }

}
