package com.example.exemplomodelos_de_comunicacao;

import android.widget.TextView;

public class PrecisaCalcular {
    TextView tv;
    public PrecisaCalcular(TextView tv){
        this.tv=tv;
    }
    public String calculoLocal(int operacao){
        Calculadora calc = new Calculadora();
        String result="";
        
        if(operacao == 1) {
            result= calc.soma(20.0,20.0)+"";
        }

        else if(operacao == 2) {
            result= calc.subtracao(20.0,20.0)+"";
        }

        else if(operacao == 3) {
            result= calc.multiplicao(20.0,20.0)+"";
        }

        else if(operacao == 4) {
            result= calc.divisao(20.0,20.0)+"";
        }

        return result;
    }

    public void calculoRemoto(int operacao){
        CalculadoraSocket shs = new CalculadoraSocket(this, "20", "20", operacao);
        shs.execute();

    }
    public void calculoRemotoHTTP(int operacao){
        CalculadoraHttpPOST shs = new CalculadoraHttpPOST(this, "20", "20", operacao);
        shs.execute();

    }
    public void result_calculoRemoto(String result){
        tv.setText(result);
    }

}
