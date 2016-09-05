package com.app.tringuyen.littlechat.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.app.tringuyen.littlechat.R;

/**
 * Created by Tri Nguyen on 9/6/2016.
 */
public class RecievedMessageViewHolder extends RecyclerView.ViewHolder {

    private TextView message;

    public RecievedMessageViewHolder(View itemView) {
        super(itemView);
        message = (TextView) itemView.findViewById(R.id.tv_message);
    }


    public TextView getMessage() {
        return message;
    }

    public void setMessage(TextView message) {
        this.message = message;
    }
}
