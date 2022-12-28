package com.example.e_cell_inductions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class LoginPage extends Fragment {

    EditText email;
    EditText password;
    EditText captchaentry;
    Button button;
    TextView captcha;
    TextView signuplink;
    Button login;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login_page, container, false);
        signuplink = v.findViewById(R.id.signuplink);
        captcha = v.findViewById(R.id.captcha);
        button = v.findViewById(R.id.button1);
        login = v.findViewById(R.id.button);
        captchaentry = v.findViewById(R.id.captchaentry);
        email = v.findViewById(R.id.email);
        FragmentManager fragmentManager = getParentFragmentManager();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                captcha.setText(RandomCaptchaGenerator.generateCaptcha());
            }
        });
        signuplink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.home_layout,new SignupFragment()).commit();
            }
        });
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(captcha.getText().toString().equals(captchaentry.getText().toString()) && captcha.getText().toString()!=""){
                    if(checkEntryExists(v)){
                        Toast.makeText(getContext(),"Login Successful!",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getContext(),"Invalid credentials",Toast.LENGTH_SHORT).show();
                    }
                }
                else{
                    Toast.makeText(getContext(),"Captcha does not match",Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
    public boolean checkEntryExists(View v){
        for(int i = 0;i<Data.database.size();i++){
            email = v.findViewById(R.id.email);
            password = v.findViewById(R.id.password);
            if(Data.database.get(i).getEmail().equals(email.getText().toString())){
                if(Data.database.get(i).getPassword().equals(password.getText().toString())){
                    return true;
                }
            }
        }
        return false;
    }
}
class RandomCaptchaGenerator{
    static String characterPool = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890!@#$%^&*";
    static Random r = new Random(characterPool.length());
    public static String generateCaptcha(){
        StringBuffer stringBuffer = new StringBuffer();
        for(int i = 0;i<5;i++){
            stringBuffer.append(characterPool.charAt(r.nextInt(characterPool.length())));
        }
        return stringBuffer.toString();
    }
}