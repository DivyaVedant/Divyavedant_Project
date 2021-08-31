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

public class colorfullneckless extends Fragment {
    Button checkout;
    TextView tv1,tv2;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.colorfull_neckless, container, false);
        checkout=v.findViewById(R.id.checkout);
        tv1=v.findViewById(R.id.textView13);
        tv2=v.findViewById(R.id.textView14);
        String[] word = { "Name : Color full Dimound Neckless with Multiple Layer "};
        String[] price = {"Price : $199"};

        tv1.setText(Arrays.toString(word));
        tv2.setText(Arrays.toString(price));
        tv1.setText(Arrays.toString(word).replaceAll("\\[|\\]", ""));
        tv2.setText(Arrays.toString(price).replaceAll("\\[|\\]", ""));

        checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String jnm=tv1.getText().toString();
                String jprice=tv2.getText().toString();
                Bundle bundle=new Bundle();
                bundle.putString("name",jnm);
                bundle.putString("price",jprice);
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
