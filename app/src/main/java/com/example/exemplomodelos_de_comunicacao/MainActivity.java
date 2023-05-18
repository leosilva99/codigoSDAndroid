package com.example.exemplomodelos_de_comunicacao;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button bt = findViewById(R.id.button);
        Button bt2 = findViewById(R.id.button2);
        Button bt3 = findViewById(R.id.button3);
        Button bt4 = findViewById(R.id.button4);
        tv= findViewById(R.id.textView);
        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PrecisaCalcular shc = new PrecisaCalcular(tv);
                //shc.calculoRemoto(1);
                //shc.calculoLocal(1);
                shc.calculoRemotoHTTP(1);
            }
        });
        bt2.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PrecisaCalcular shc = new PrecisaCalcular(tv);
                //shc.calculoRemoto(2);
                //shc.calculoLocal(2);
                shc.calculoRemotoHTTP(2);
            }
        });
        bt3.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PrecisaCalcular shc = new PrecisaCalcular(tv);
                //shc.calculoRemoto(3);
                //shc.calculoLocal(1);
                shc.calculoRemotoHTTP(3);
            }
        });
        bt4.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                PrecisaCalcular shc = new PrecisaCalcular(tv);
                //shc.calculoRemoto(4);
                //shc.calculoLocal(1);
                shc.calculoRemotoHTTP(4);
            }
        });
    }
}
