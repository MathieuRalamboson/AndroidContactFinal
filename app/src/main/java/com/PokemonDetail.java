package com;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.github.vincebrees.esiea32.R;


public class PokemonDetail extends Fragment {
   private static final String TAG = "PokemonDetail";
   private Button btnNavFrag;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pokemon_detail,container,false);

        btnNavFrag = (Button) view.findViewById(R.id.backbutton);
        Log.d(TAG,"onCreateView: started.");

        btnNavFrag.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(),"Going to Fragment",Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
