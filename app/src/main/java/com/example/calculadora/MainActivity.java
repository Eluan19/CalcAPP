package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ////////////*BOTÕES*//////////
    private Button numeroZero,numeroUm,numeroDois,numeroTres,numeroQuatro,numeroCinco,numeroSeis,numeroSete,numeroOito,
    numeroNove,ponto,adicao,diminuir,multilicacao,divisao,igual,botao_limpar;

    ////////////*BOTÕES*//////////
    private TextView txtExpressao,txtResultado;
    private ImageView backspace;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        ////////////*DEIXAR O BAR EM BRANCO*//////////
        getSupportActionBar().hide();

        //////////*Iniciar Componentes*//////////////
        numeroZero.setOnClickListener(this);
        numeroUm.setOnClickListener(this);
        numeroDois.setOnClickListener(this);
        numeroTres.setOnClickListener(this);
        numeroQuatro.setOnClickListener(this);
        numeroCinco.setOnClickListener(this);
        numeroSeis.setOnClickListener(this);
        numeroSete.setOnClickListener(this);
        numeroOito.setOnClickListener(this);
        numeroNove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        adicao.setOnClickListener(this);
        diminuir.setOnClickListener(this);
        multilicacao.setOnClickListener(this);
        divisao.setOnClickListener(this);

       /////////*BOTÃO DE LIMPAR*////////
        botao_limpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtExpressao.setText("");
                txtResultado.setText("");
            }
        });
        ////////////*BOTÃO DE LIMPAR UMA CASA*//////////
        backspace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                TextView expressao = findViewById(R.id.txt_expressao);
                String string = expressao.getText().toString();

                if (!string.isEmpty()){

                    byte var0 = 0;
                    int var1= string.length()-1;
                    String txtExpressao = string.substring(var0,var1);
                    expressao.setText(txtExpressao);
                }
                txtResultado.setText("");
            }
        });
        ////////////*BOTÃO DE FAZER A CONTA*//////////
        igual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try {
                    Expression expressao = new ExpressionBuilder(txtExpressao.getText().toString()).build();
                    double resultado = expressao.evaluate();
                    long longResult = (long) resultado;

                    if (resultado == (double)longResult){
                        txtResultado.setText((CharSequence) String.valueOf(longResult));
                    }else{
                        txtResultado.setText((CharSequence) String.valueOf(resultado));
                    }
                }catch (Exception e){

                }

            }
        });

    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.numero_zero);
        numeroUm = findViewById(R.id.numero_um);
        numeroDois = findViewById(R.id.numero_dois);
        numeroTres = findViewById(R.id.numero_tres);
        numeroQuatro = findViewById(R.id.numero_quatro);
        numeroCinco = findViewById(R.id.numero_cinco);
        numeroSeis = findViewById(R.id.numero_seis);
        numeroSete = findViewById(R.id.numero_sete);
        numeroOito = findViewById(R.id.numero_oito);
        numeroNove = findViewById(R.id.numero_nove);
        ponto = findViewById(R.id.ponto);
        adicao = findViewById(R.id.adicao);
        diminuir = findViewById(R.id.diminuir);
        multilicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.igual);
        botao_limpar = findViewById(R.id.bt_limpar);
        txtExpressao = findViewById(R.id.txt_expressao);
        txtResultado = findViewById(R.id.txt_resultado);
        backspace = findViewById(R.id.backspace);
    }

    ////////////*ACRESCENTANDO EXPRESSÕES*//////////
    public void AcrescentarUmaExpressao(String string,boolean limapr_dados){

        if (txtResultado.getText().equals("")){
            txtExpressao.setText(" ");
        }

        if (limapr_dados){
            txtResultado.setText(" ");
            txtExpressao.append(string);
        }else{
            txtExpressao.append(txtResultado.getText());
            txtExpressao.append(string);
            txtResultado.setText(" ");
        }
    }

    ////////////*FUNÇÃO DOS BOTÕES*//////////
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.numero_zero:
                AcrescentarUmaExpressao("0",true);
                break;

            case R.id.numero_um:
                AcrescentarUmaExpressao("1",true);
                break;

            case R.id.numero_dois:
                AcrescentarUmaExpressao("2",true);
                break;

            case R.id.numero_tres:
                AcrescentarUmaExpressao("3",true);
                break;

            case R.id.numero_quatro:
                AcrescentarUmaExpressao("4",true);
                break;

            case R.id.numero_cinco:
                AcrescentarUmaExpressao("5",true);
                break;

            case R.id.numero_seis:
                AcrescentarUmaExpressao("6",true);
                break;

            case R.id.numero_sete:
                AcrescentarUmaExpressao("7",true);
                break;

            case R.id.numero_oito:
                AcrescentarUmaExpressao("8",true);
                break;

            case R.id.numero_nove:
                AcrescentarUmaExpressao("9",true);
                break;

            case R.id.ponto:
                AcrescentarUmaExpressao(".",true);
                break;

            case R.id.adicao:
                AcrescentarUmaExpressao("+",false);
                break;

            case R.id.diminuir:
                AcrescentarUmaExpressao("-",false);
                break;

            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*",false);
                break;

            case R.id.divisao:
                AcrescentarUmaExpressao("/",false);
                break;
        }
    }
}