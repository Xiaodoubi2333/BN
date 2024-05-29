package com.example.sadmanbn.ui.call;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        new AlertDialog.Builder(getContext())
                .setTitle("确认")
                .setMessage("你真的要使用系统自带的拨号程序吗？")

                //
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent=new Intent(Intent.ACTION_DIAL);           //intent，是 系统应用
                        intent.setData(Uri.parse("tel: "));
                        startActivity(intent);

                    }
                })
                .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // 自动关闭对话框
                    }
                })
                .create()
                .show();
//
    }
}