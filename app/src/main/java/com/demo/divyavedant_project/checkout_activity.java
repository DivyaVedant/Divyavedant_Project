package com.demo.divyavedant_project;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class checkout_activity extends Fragment {

    Button b;
    TextView tv,tv2;
    Spinner sp;
    String name,price;
    EditText edtnm;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.checkout_activity, container, false);

        edtnm = v.findViewById(R.id.editText);
        b=v.findViewById(R.id.button4);
        tv=v.findViewById(R.id.Name);
        tv2=v.findViewById(R.id.Price);
        Bundle bundle = getArguments();
        tv.setText(String.valueOf(bundle.getString("name")));
        tv2.setText(String.valueOf(bundle.getString("price")));

        String[] values =
                {"1","2","3","4","5"};
        Spinner spinner =v.findViewById(R.id.spinner);
        ArrayAdapter<String> LTRadapter = new ArrayAdapter<String>(this.getActivity(), android.R.layout.simple_spinner_item, values);
        LTRadapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line);
        spinner.setAdapter(LTRadapter);

        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name = edtnm.getText().toString();
                if(TextUtils.isEmpty(name)) {
                    Toast.makeText(getActivity(),"Name is Required", Toast.LENGTH_LONG).show();
                    tv.setError("Name is Required");
                    return;
                }
                else
                {
                    Fragment fragment = new com.demo.divyavedant_project.thankyou();
                    FragmentManager fm = getActivity().getSupportFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    ft.replace(R.id.frameLayout,fragment);
                    ft.addToBackStack(null);
                    ft.commit();
                }
            }
        });
        return  v;
    }
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //you can set the title for your toolbar here for different fragments different titles
        getActivity().setTitle("Billing Page");
    }
}
