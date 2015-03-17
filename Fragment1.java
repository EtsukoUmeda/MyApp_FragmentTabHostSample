package com.example.e2ko777.fragment;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class Fragment1 extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
        Bundle savedInstanceState) {
        final View  view = inflater.inflate(R.layout.fragment_fragment1, container, false);
        Button calc1 = (Button)view.findViewById(R.id.calc);
        calc1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                EditText gram1 = (EditText)view.findViewById(R.id.gram);
                        EditText  yen1 = (EditText)view.findViewById(R.id.yen);
                        TextView txtResult1 = (TextView)view.findViewById(R.id.txtResult);
                        String strNum = gram1.getText().toString();
                        String strMoney = yen1.getText().toString();
                        int num = Integer.parseInt(strNum);
                        int money = Integer.parseInt(strMoney);
                        Double result = (double) num / money;
                        NumberFormat nm = NumberFormat.getNumberInstance();
                        txtResult1.setText(nm.format(result));
                    }
                });
        Button clear1 = (Button)view.findViewById(R.id.clear);
        clear1.setOnClickListener(new View.OnClickListener() {
         public  void onClick(View v) {
                        EditText gram1 = (EditText)view.findViewById(R.id.gram);
                        gram1.setText("");
                        EditText  yen1 = (EditText)view.findViewById(R.id.yen);
                        yen1.setText("");
                        TextView txtResult1 = (TextView)view.findViewById(R.id.txtResult);
                        txtResult1.setText("");
         }
        });
        return view;
    }
}