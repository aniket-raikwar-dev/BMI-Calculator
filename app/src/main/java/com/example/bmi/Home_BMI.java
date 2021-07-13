package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Home_BMI extends AppCompatActivity {

    EditText weight, height;
    TextView txtRes, txtInter;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__b_m_i);

        weight = (EditText) findViewById(R.id.etn_weight);
        height = (EditText) findViewById(R.id.etn_height);

        txtRes = (TextView) findViewById(R.id.txt_Res);
        txtInter = (TextView) findViewById(R.id.txt_inter);

        button = (Button) findViewById(R.id.btnFind);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String strweg = weight.getText().toString();
                String strHei = height.getText().toString();

                if (strweg.equals(""))
                {
                    weight.setError("Please Enter Your Weight !");
                    weight.requestFocus();
                    return;
                }

                if (strHei.equals(""))
                {
                    height.setError("Please Enter Your Height !");
                    height.requestFocus();
                    return;
                }

                float weigh = Float.parseFloat(strweg);
                float heigh = Float.parseFloat(strHei)/100;

                float bmiVlaue = BMICalculate(weigh, heigh);

                txtInter.setText(InterBMI(bmiVlaue));
                txtRes.setText("" + bmiVlaue);


            }
        });



    }

    public float BMICalculate(float wei, float hei)
    {
        return wei/(hei*hei);
    }

    public String InterBMI(float bmiValue)
    {
        if(bmiValue < 16)
        {
            return "     Serverly";
        }

        else if(bmiValue < 18.5)
        {
            return " Under Weight";
        }

        else if(bmiValue < 25)
        {
            return "Normal Weight";
        }

        else if(bmiValue < 30)
        {
            return " Over Weight";
        }

        else
            return "      Obese";
    }











}