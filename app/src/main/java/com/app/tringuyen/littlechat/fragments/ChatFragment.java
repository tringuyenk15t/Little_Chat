package com.app.tringuyen.littlechat.fragments;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.app.tringuyen.littlechat.adapters.ChatAdapter;
import com.app.tringuyen.littlechat.R;
import com.app.tringuyen.littlechat.models.Message;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by Tri Nguyen on 8/10/2016.
 */
public class ChatFragment extends Fragment {
    private List<String> info;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private EditText messageEditText;
    private List<Message> messageList;

    private boolean flag = true;
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
        info = new ArrayList<>();
        messageList = new ArrayList<>();

        ImageButton sendbutton = (ImageButton) v.findViewById(R.id.button_send);
        recyclerView = (RecyclerView) v.findViewById(R.id.message_list);
        messageEditText = (EditText) v.findViewById(R.id.text_typing);

        sendbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = messageEditText.getText().toString();
                messageList.add(new Message(flag,"someone",message,new Date()));
                flag = !flag;
                messageEditText.getText().clear();
                adapter.notifyDataSetChanged();
            }
        });

        adapter = new ChatAdapter(messageList);

        layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        v.clearFocus();
        return v;
    }

}
