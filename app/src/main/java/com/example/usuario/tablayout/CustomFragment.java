package com.example.usuario.tablayout;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class CustomFragment extends Fragment {

    private TextView txvMessage;
    public static final String KEY_MESSAGE = "message";

    public static CustomFragment newInstance(Bundle arguments) {
        CustomFragment customFragment = new CustomFragment();
        if (arguments != null) customFragment.setArguments(arguments);
        return customFragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        super.onCreateView(inflater, container, savedInstanceState);
        View rootView = inflater.inflate(R.layout.fragment_main, container, false);
        txvMessage = rootView.findViewById(R.id.txvMessage);
        String textMessage = getArguments().getString(KEY_MESSAGE);
        txvMessage.setText(textMessage);
        return rootView;
    }

}
