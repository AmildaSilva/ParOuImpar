package br.edu.ifsp.scl.sdm.parouimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private RadioGroup opcaoRg;
    private Button  zeroBt;
    private Button   umBt;
    private Button  doisBt;
    private Button  tresBt;
    private Button  quatroBt;
    private Button  cincoBt;
    private TextView resultadoTv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        opcaoRg=findViewById(R.id.opcaoRg);
        zeroBt=findViewById(R.id.zeroBt);
        umBt=findViewById(R.id.umBt);
        doisBt=findViewById(R.id.doisBt);
        tresBt=findViewById(R.id.tresBt);
        quatroBt=findViewById(R.id.quatroBt);
        cincoBt=findViewById(R.id.cincoBt);
        resultadoTv=findViewById(R.id.resultadoTv);

     zeroBt.setOnClickListener(this);
     umBt.setOnClickListener(this);
     doisBt.setOnClickListener(this);
     tresBt.setOnClickListener(this);
     quatroBt.setOnClickListener(this);
     cincoBt.setOnClickListener(this);
    }


    @Override
    public void onClick(View view) {
        int jogada = -1;
        switch (view.getId()){
            case R.id.zeroBt:
                jogada=0;
                break;
            case R.id.umBt:
                jogada=1;
                break;
            case R.id.doisBt:
                jogada=2;
                break;
            case R.id.tresBt:
                jogada=3;
                break;
            case R.id.quatroBt:
                jogada=4;
                break;
            case R.id.cincoBt:
                jogada=5;
                break;
        }
        jogarParOuImpar(jogada);
    }
    private void jogarParOuImpar(int jogada){
        Random random =new Random(System.currentTimeMillis());
        int jogadaComputador = random.nextInt(6);

        StringBuilder resultadoSb = new StringBuilder();
        resultadoSb.append("Sua jogada: ");
        resultadoSb.append(jogada);

        resultadoSb.append(", Computador");
        resultadoSb.append(jogadaComputador);

        if(opcaoRg.getCheckedRadioButtonId()==R.id.parRb){
            resultadoSb.append((jogada + jogadaComputador)%2 ==0? "Você GANHOU!":"Você PERDEU!");
        }
        else{
            resultadoSb.append((jogada + jogadaComputador)%2 ==0? "Você PERDEU!":"Você GANHOU!");

        }
        resultadoTv.setText(resultadoSb.toString());

    }
}