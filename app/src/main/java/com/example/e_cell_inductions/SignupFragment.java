package com.example.e_cell_inductions;

import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;


public class SignupFragment extends Fragment {

    Button button;
    EditText password;
    EditText reenterpwd;
    EditText dob;
    EditText phone;
    EditText username;
    EditText email;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signup, container, false);
        button = v.findViewById(R.id.submit);
        password = v.findViewById(R.id.pwd);
        reenterpwd = v.findViewById(R.id.pwdreenter);
        dob = v.findViewById(R.id.dob);
        phone = v.findViewById(R.id.phoneno);
        username = v.findViewById(R.id.username);
        email = v.findViewById(R.id.email);
        ArrayList<String> list = new ArrayList<>();
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                list.add(reenterpwd.getText().toString());
                list.add(username.getText().toString());
                list.add(phone.getText().toString());
                list.add(dob.getText().toString());
                list.add(password.getText().toString());
                list.add(email.getText().toString());
                int a = performedAllChecks(list);
                System.out.println(a);
                switch(a){
                    case 0:
                        Toast.makeText(getContext(),"Enter value in all fields",Toast.LENGTH_SHORT).show();
                        list.clear();
                        break;
                    case 1:
                        Toast.makeText(getContext(),"Passwords do not match",Toast.LENGTH_SHORT).show();
                        list.clear();
                        break;
                    case 2:
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            Data.database.add(new Data(list.get(1),Long.parseLong(list.get(2)),LocalDate.parse(list.get(3)),list.get(4),list.get(5)));
                        }
                        Toast.makeText(getContext(),"Signed up successfully!",Toast.LENGTH_SHORT).show();
                        list.clear();
                        FragmentManager fragmentManager = getParentFragmentManager();
                        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                        fragmentTransaction.replace(R.id.home_layout,new LoginPage()).commit();
                        break;
                }
            }
        });
        return v;
    }
    public int performedAllChecks(ArrayList<String>list){
        for(String s: list){
            if(s.equals("")){
                return 0;
            }
        }
        if(!list.get(0).equals(list.get(4))){
            return 1;
        }
            return 2;

    }
}