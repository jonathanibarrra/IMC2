package lenovo.imc;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;
    private TextView tv1,tv2;
    //private EditText  et3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        et1 = (EditText) findViewById(R.id.etgrabar);
        et2 = (EditText) findViewById(R.id.et2);
        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);
        //et3=(EditText)findViewById(R.id.et3);

    }




/*
        public void grabar(View v) {
           // String Peso=et1.getText().toString();
            //String Altura=et2.getText().toString();
            String Mail=et3.getText().toString();
            SharedPreferences preferencias=getSharedPreferences("agenda", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferencias.edit();
            editor.putString( Mail,);
            editor.commit();
            Toast.makeText(this,"Datos grabados", Toast.LENGTH_LONG).show();
        }
*/



    public void acerca(View view) {
        Intent i = new Intent(this, AcercaDe.class);
        startActivity(i);
    }



    @SuppressLint("SetTextI18n")
    public void calcular(View view) {
        String valor1 = et1.getText().toString();
        Float valor2 = Float.parseFloat(et2.getText().toString());
        double nro1 = Double.parseDouble(valor1);
        double nro2 = valor2;
        DecimalFormat df = new DecimalFormat("####.##");
        double re = nro1 / (nro2 * nro2);
        tv1.setText(df.format(re));




        if (re < 16.0) {
            tv2.setText(R.string.Delgadezsevera);
        } else if (re >= 40.0) {
            tv2.setText(R.string.obesidamorbida);
        } else if (re >= 16.0 && re <= 16.99) {
            tv2.setText(R.string.delgadezmoderada);
        } else if (re >= 17.0 && re <= 18.49) {
            tv2.setText(R.string.delgadesLeve);
        } else if (re >= 18.5 && re <= 24.99) {
            tv2.setText(R.string.TienePesoNormal);
        } else {
            if (re >= 25.0 && re <= 29.99) {
                tv2.setText(R.string.Preobesidad);
            } else {
                if (re >= 30.0 && re <= 34.99) {
                    tv2.setText(R.string.ObesidadLeve);
                } else {
                    if (re >= 35.0 && re <= 39.99) {
                        tv2.setText(R.string.ObesidadMorvida);
                    }

                    }
                }
            }
        }
    public void grabar(View v) {
        Intent i = new Intent(this, Historial.class);
        startActivity(i);
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    "notas.txt", Activity.MODE_PRIVATE));
            archivo.write(et1.getText().toString()+"");
            archivo.write(et2.getText().toString());
            archivo.flush();
            archivo.close();
        } catch (IOException e) {
        }
        Toast t = Toast.makeText(this, "Los datos fueron grabados",
                Toast.LENGTH_SHORT);
        t.show();
        finish();
    }
    }
