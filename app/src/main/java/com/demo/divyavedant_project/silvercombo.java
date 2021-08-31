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

public class silvercombo extends Fragment {
    Button checkout;
    TextView tv1,tv2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.silvercombo, container, false);
        checkout=v.findViewById(R.id.checkout);
        tv1=v.findViewById(R.id.textView13);
        tv2=v.findViewById(R.id.textView14);
        String[] word = { "Name : Silver Crown and Earings Combo (Pack of 2)"};
        String[] price = {"Price : $599"};

        tv1.setText(Arrays.toString(word));
        tv2.setText(Arrays.toString(price));
        tv1.setText(Arrays.toString(word).replaceAll("\\[|\\]", ""));
        tv2.setText(Arrays.toString(price).replaceAll("\\[|\\]", ""));


        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phonename=tv1.getText().toString();
                String phoneprice=tv2.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("name",phonename);
                bundle.putString("price",phoneprice);
                Fragment fragment = new com.demo.divyavedant_project.checkout_activity();
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
