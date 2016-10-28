package com.koudaijiajiao.koudaijiajiaojj.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.koudaijiajiao.koudaijiajiaojj.R;

/**
 * Created by killandy on 2016/10/28.
 */

public class FindFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.findfg, container, false);
        return view;
    }
}
