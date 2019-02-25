package br.com.paulosalvatore.pagseguroandroidturmab;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tvPrincipal = findViewById(R.id.tvPrincipal);
        final EditText etPrincipal = findViewById(R.id.etPrincipal);
        final Button btEnviar = findViewById(R.id.btEnviar);

        btEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = etPrincipal.getText().toString();
                if (!text.isEmpty()) {
                    tvPrincipal.setText(text);
                } else {
//                    tvPrincipal.setText(R.string.type_some_text);
                    Toast.makeText(MainActivity.this, R.string.type_some_text, Toast.LENGTH_LONG).show();
                    etPrincipal.setError(getText(R.string.type_some_text));
                }
            }
        });
    }
}
