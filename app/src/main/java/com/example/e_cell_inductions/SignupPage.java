package com.example.e_cell_inductions;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class SignupPage extends Fragment {

    EditText email;
    EditText password;
    EditText captchaentry;
    TextView captcha;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_signup_page, container, false);
        captcha = v.findViewById(R.id.captcha);
        captcha.setText(RandomCaptchaGenerator.generateCaptcha());
        return v;
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