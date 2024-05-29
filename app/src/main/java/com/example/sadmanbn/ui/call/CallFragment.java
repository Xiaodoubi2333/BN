package com.example.sadmanbn.ui.call;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.sadmanbn.R;

public class CallFragment extends Fragment {

    private CallViewModel callViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        callViewModel =
                ViewModelProviders.of(this).get(CallViewModel.class);
        View root = inflater.inflate(R.layout.fragment_call, container, false);
        final TextView textView = root.findViewById(R.id.text_call);
        callViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}