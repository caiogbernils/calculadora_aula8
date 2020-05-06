package br.com.caiob.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    EditText numero1;
    EditText numero2;
    TextView resultado;
    ListView lvHistorico;

    ArrayList<String> historico = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        numero1 = findViewById(R.id.etNum1);
        numero2 = findViewById(R.id.etNum2);
        resultado = findViewById(R.id.result);
        lvHistorico = findViewById(R.id.lvHist);
    }

    private void adicionarHistorico(String operacao){
        historico.add(operacao);
        ArrayAdapter<String> histArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, historico);
        lvHistorico.setAdapter(histArrayAdapter);
    }
    public void limparHistorico(View v){
        historico.clear();
        ArrayAdapter<String> histArrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, historico);
        lvHistorico.setAdapter(histArrayAdapter);

        Toast.makeText(this, "Histórico limpo.", Toast.LENGTH_SHORT).show();
    }
    public void adicaoResultado (View v){
        resultado.setText("");
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")) {
            Toast.makeText(this, "Por favor informar os dois números.", Toast.LENGTH_LONG).show();
        } else {
            float res = Float.valueOf(num1St) + Float.valueOf(num2St);
            adicionarHistorico(num1St + " + " + num2St + " = " + res);
            numero1.setText("");
            numero2.setText("");
            resultado.setText("Resultado: " + res);
        }
    }
    public void subtracaoResultado (View v){
        resultado.setText("");
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")) {
            Toast.makeText(this, "Por favor informar os dois números.", Toast.LENGTH_LONG).show();
        } else {
            float res = Float.valueOf(num1St) - Float.valueOf(num2St);
            adicionarHistorico(num1St + " - " + num2St + " = " + res);
            numero1.setText("");
            numero2.setText("");
            resultado.setText("Resultado: " + res);
        }
    }
    public void multiplicacaoResultado (View v){
        resultado.setText("");
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")) {
            Toast.makeText(this, "Por favor informar os dois números.", Toast.LENGTH_LONG).show();
        } else {
            float res = Float.valueOf(num1St) * Float.valueOf(num2St);
            adicionarHistorico(num1St + " * " + num2St + " = " + res);
            numero1.setText("");
            numero2.setText("");
            resultado.setText("Resultado: " + res);
        }
    }
    public void divisaoResultado (View v) {
        resultado.setText("");
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if (num1St.equals("") || num2St.equals("")) {
            Toast.makeText(this, "Por favor informar os dois números!", Toast.LENGTH_LONG).show();
        } else if (num2St.equals("0")) {
            Toast.makeText(this, "Não é possível divisão por 0 (Zero)!", Toast.LENGTH_LONG).show();
        } else {
            float res = Float.valueOf(num1St) / Float.valueOf(num2St);
            adicionarHistorico(num1St + " / " + num2St + " = " + res);
            numero1.setText("");
            numero2.setText("");
            resultado.setText("Resultado: " + res);
        }
    }
}
