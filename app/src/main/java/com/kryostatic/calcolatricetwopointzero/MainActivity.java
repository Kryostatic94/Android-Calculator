package com.kryostatic.calcolatricetwopointzero;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    TextView upschermo,risultato;
    Button canc,del,plusminus,add,seven,eight,nine,less,four,five,six,multy,one,two,three,diviso,zero,point,equal;
    StringBuilder memoria = new StringBuilder(" ");
    String valore = " ";
    LinkedList<String> valore2 = new LinkedList<>();
    char operazione = 0;
    String cache = " ";
    double result = 0.0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //SCHERMI
        upschermo = findViewById(R.id.upschermo);
        risultato = findViewById(R.id.risultato);
        //BOTTONI
        canc = findViewById(R.id.canc);
        del = findViewById(R.id.del);
        plusminus = findViewById(R.id.plusminus);
        add = findViewById(R.id.add);
        seven = findViewById(R.id.seven);
        eight = findViewById(R.id.eight);
        nine = findViewById(R.id.nine);
        less = findViewById(R.id.less);
        four = findViewById(R.id.four);
        five = findViewById(R.id.five);
        six = findViewById(R.id.six);
        multy = findViewById(R.id.multy);
        one = findViewById(R.id.one);
        two = findViewById(R.id.two);
        three = findViewById(R.id.three);
        diviso = findViewById(R.id.diviso);
        zero = findViewById(R.id.zero);
        point = findViewById(R.id.point);
        equal = findViewById(R.id.equal);



        canc.setOnClickListener(this);
        del.setOnClickListener(this);
        plusminus.setOnClickListener(this);
        add.setOnClickListener(this);
        seven.setOnClickListener(this);
        eight.setOnClickListener(this);
        nine.setOnClickListener(this);
        less.setOnClickListener(this);
        four.setOnClickListener(this);
        five.setOnClickListener(this);
        six.setOnClickListener(this);
        multy.setOnClickListener(this);
        one.setOnClickListener(this);
        two.setOnClickListener(this);
        three.setOnClickListener(this);
        diviso.setOnClickListener(this);
        zero.setOnClickListener(this);
        point.setOnClickListener(this);
        equal.setOnClickListener(this);

    }

    private void inserimentoOperazione (char c){
        if(!cache.isEmpty()){
            operazione = c;
            valore = cache;
            risultato.setText("");
            return;
        }else{
            operazione = c;
            return;
        }
    }
    private void forUpschermo(){
        memoria.append(valore);
        memoria.append(" "+operazione+" ");
        memoria.append(valore2.get(0));
        memoria.append(" = ");
        memoria.append(result);

    }
    private double risultatoDaOperazione(String x, String y,char c){
        double a = Double.parseDouble(x);
        double b = Double.parseDouble(y);
        switch (c){
            case '+':
                result = a+b;
                return result;
            case '-':
                result = a-b;
                return result;
            case '*':
                result = a*b;
                return result;
            case '/':
                if(b == 0.0){
                    result = 1.0;
                    return result;
                }
                result = a/b;
                return result;
        }
        return 0.0;
    }

    @Override
    public void onClick(View v) {
        cache = risultato.getText().toString();
        System.out.println("Cache"+cache);
        switch (v.getId()) {
            case R.id.point:
                if(cache.contains(".")){
                    break;
                }
                if (cache.equals("-")){
                    risultato.setText("-0");
                    cache = risultato.getText().toString();
                }
                if(cache.equals(" ") || cache.isEmpty()){
                    risultato.setText("0.");
                    cache = risultato.getText().toString();
                }else{
                    risultato.setText(cache+".");
                    cache = risultato.getText().toString();
                    break;
                }
                break;
            case R.id.plusminus:
                if(!cache.contains("-")){
                    risultato.setText("-"+cache);
                    cache = risultato.getText().toString();
                    break;
                }else{
                    cache = cache.replace("-","");
                    risultato.setText(cache);
                    cache = risultato.getText().toString();
                    break;

                }
            case R.id.del:
                upschermo.setText("");
                risultato.setText("");
                memoria.setLength(0);
                valore2.clear();
                break;
            case R.id.canc:{
                if(cache.isEmpty()){
                    break;
                }else{
                    String aggiornamento = cache.substring(0, cache.length() - 1);
                    risultato.setText(aggiornamento);
                }
                break;
            }
            //OPERAZIONI
            case R.id.add:
                inserimentoOperazione('+');
                valore2.clear();
                break;
            case R.id.less:
                inserimentoOperazione('-');
                valore2.clear();
                break;
            case R.id.diviso:
                inserimentoOperazione('/');
                valore2.clear();
                break;
            case R.id.multy:
                inserimentoOperazione('*');
                valore2.clear();
                break;
            case R.id.equal:
                if(cache.equals("-"))break;
                if(valore.equals(" ")) break;
                if(cache.equals(" ")) break;
                valore2.add(cache);
                if(valore2.get(0).equals(" ") || valore2.get(0).isEmpty() ) break;
                if(memoria.length() != 0){
                    memoria.setLength(0);
                }
                Double finale = risultatoDaOperazione(valore,valore2.get(0),operazione);
                forUpschermo();
                risultato.setText(finale.toString());
                upschermo.setText(memoria);
                valore = finale.toString();
                break;
                //TASTIERA
            case R.id.zero:
                if(cache.equals("0")){
                    break;
                }
                risultato.setText(cache+"0");
                break;
            case R.id.one:
                if(cache.equals("0")){
                    risultato.setText("1");
                    break;
                }
                risultato.setText(cache+"1");
                break;
            case R.id.two:
                if(cache.equals("0")){
                    risultato.setText("2");
                    break;
                }
                risultato.setText(cache+"2");
                break;
            case R.id.three:
                if(cache.equals("0")){
                    risultato.setText("3");
                    break;
                }
                risultato.setText(cache+"3");
                break;
            case R.id.four:
                if(cache.equals("0")){
                    risultato.setText("4");
                    break;
                }
                risultato.setText(cache+"4");
                break;
            case R.id.five:
                if(cache.equals("0")){
                    risultato.setText("5");
                    break;
                }
                risultato.setText(cache+"5");
                break;
            case R.id.six:
                if(cache.equals("0")){
                    risultato.setText("6");
                    break;
                }
                risultato.setText(cache+"6");
                break;
            case R.id.seven:
                if(cache.equals("0")){
                    risultato.setText("7");
                    break;
                }
                risultato.setText(cache+"7");
                break;
            case R.id.eight:
                if(cache.equals("0")){
                    risultato.setText("8");
                    break;
                }
                risultato.setText(cache+"8");
                break;
            case R.id.nine:
                if(cache.equals("0")){
                    risultato.setText("9");
                    break;
                }
                risultato.setText(cache+"9");
                break;
        }
    }
}