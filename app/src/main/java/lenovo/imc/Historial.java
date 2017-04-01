package lenovo.imc;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


import com.google.android.gms.common.api.GoogleApiClient;

public class Historial extends AppCompatActivity {
    private EditText etgrabar;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */
    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);


        etgrabar=(EditText)findViewById(R.id.etgrabar);
        String[] archivos = fileList();

        if (existe(archivos, "notas.txt"))
            try {
                InputStreamReader archivo = new InputStreamReader(
                        openFileInput("notas.txt"));
                BufferedReader br = new BufferedReader(archivo);
                String linea = br.readLine();
                String todo = "";
                while (linea != null) {
                    todo = todo + linea + "\n";
                    linea = br.readLine();
                }
                br.close();
                archivo.close();
                etgrabar.setText(todo);
            } catch (IOException e) {
            }
    }

    private boolean existe(String[] archivos, String archbusca) {
        for (int f = 0; f < archivos.length; f++)
            if (archbusca.equals(archivos[f]))
                return true;
        return false;
    }

    public void grabar(View v) {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(
                    "notas.txt", Activity.MODE_PRIVATE));
            archivo.write(etgrabar.getText().toString());
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






