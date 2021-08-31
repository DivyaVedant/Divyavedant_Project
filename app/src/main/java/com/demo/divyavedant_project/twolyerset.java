package com.demo.divyavedant_project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;

public class twolyerset extends Fragment {
    Button checkout;
    TextView tv,tv2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.two_layerset, container, false);

        checkout=v.findViewById(R.id.checkout);
        tv=v.findViewById(R.id.textView16);
        tv2=v.findViewById(R.id.textView15);

        String[] word = { "Name : Two Layer Neckless (colorfull Dimounds)"};
        String[] price = {"Price : $1000"};

        tv.setText(Arrays.toString(word));
        tv2.setText(Arrays.toString(price));
        tv.setText(Arrays.toString(word).replaceAll("\\[|\\]", ""));
        tv2.setText(Arrays.toString(price).replaceAll("\\[|\\]", ""));


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nname=tv.getText().toString();
                String nprice=tv2.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("name",nname);
                bundle.putString("price",nprice);
                Fragment fragment = new checkout_activity();
                fragment.setArguments(bundle);
                FragmentManager fm = getActivity().getSupportFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frameLayout,fragment);
                ft.addToBackStack(null);
                ft.commit();



            }
        });
        return  v;
    }
}
