package com.example.android.guiatour.Fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.guiatour.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class NotificacaoFragment extends Fragment {


    public NotificacaoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_notificacao, container, false);
    }

}
