package com.example.exemplomodelos_de_comunicacao;

import android.os.AsyncTask;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class CalculadoraSocket extends AsyncTask<Void, Void, String> {

    TextView tv;
    String oper1,oper2;
    int operacao; // 1-somar 2-subtrair 3-multiplicar 4-dividir
    PrecisaCalcular pc;
    
    public CalculadoraSocket(TextView tv, String oper1, String oper2, int operacao){
        this.tv=tv;
        this.oper1=oper1;
        this.oper2=oper2;
        this.operacao=operacao;

    }
    public CalculadoraSocket(PrecisaCalcular pc, String oper1, String oper2, int operacao){
        this.tv=tv;
        this.oper1=oper1;
        this.oper2=oper2;
        this.pc=pc;
        this.operacao=operacao;

    }
    @Override
    protected String doInBackground(Void... voids) {
        String result="";
        //double oper1=20,oper2=20;
        try {
            //Conexão com o Servidor
            Socket clientSocket = new Socket("localhost", 9090);
            DataOutputStream socketSaidaServer = new DataOutputStream(clientSocket.getOutputStream());
            
            //Enviando os dados
            socketSaidaServer.writeBytes(""+operacao + '\n');
            socketSaidaServer.writeBytes(""+oper1 + '\n');
            socketSaidaServer.writeBytes(""+oper2 + '\n');
            socketSaidaServer.flush();

            //Recebendo a resposta
            BufferedReader messageFromServer = new BufferedReader
                    (new InputStreamReader(clientSocket.getInputStream()));
            result = messageFromServer.readLine();
            
            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }


    @Override
protected void onPreExecute() {
        //Codigo
        }


@Override
protected void onPostExecute(String result) {
        //Codigo
           if(this.tv!=null) {
               this.tv.setText(result);
           }else {
               this.pc.result_calculoRemoto(result);
           }
        }

}
