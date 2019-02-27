package br.com.paulosalvatore.pagseguroandroidturmab;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    private static final String TEXT = "TEXT";

    private TextView textView;

    private String persistText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        final Intent intent = getIntent();

        String info = intent.getStringExtra("INFO");
        if (info != null) {
            Toast.makeText(this, info, Toast.LENGTH_SHORT).show();
        }

        textView = findViewById(R.id.textView);
        final EditText editText = findViewById(R.id.editText);
        final Button btApplyChanges = findViewById(R.id.btApplyChanges);
        final Button btKeepValue = findViewById(R.id.btKeepValue);
        final Button btResetValue = findViewById(R.id.btResetValue);

        /*if (savedInstanceState != null) {
            String textPersisted = savedInstanceState.getString(TEXT);
            textView.setText(textPersisted);
        }*/

        btApplyChanges.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = editText.getText().toString();
                textView.setText(text);

                // Setting Result
                intent.putExtra("RESULT", text);
                setResult(RESULT_OK, intent);
                DetailsActivity.this.finish();
            }
        });

        btKeepValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Value to be persisted
                persistText = editText.getText().toString();
                Toast.makeText(DetailsActivity.this, "Persisted Value: " + persistText, Toast.LENGTH_LONG).show();
            }
        });

        btResetValue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                persistText = null;
                Toast.makeText(DetailsActivity.this, "Value reseted.", Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        if (persistText != null && !persistText.isEmpty()) {
            outState.putString(TEXT, persistText);
        } else {
            outState.remove(TEXT);
        }

        UsuarioSerializable usuarioSerializable = new UsuarioSerializable("Paulo", "Salvatore");
        outState.putSerializable("USUARIO_SERIALIZABLE", usuarioSerializable);

        UsuarioParcelable usuarioParcelable = new UsuarioParcelable("Paulo", "Salvatore");
        outState.putParcelable("USUARIO_PARCELABLE", usuarioParcelable);

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String persistedText = savedInstanceState.getString(TEXT);
        if (persistedText != null && !persistedText.isEmpty()) {
            persistText = persistedText;
            textView.setText(persistedText);
        }

        UsuarioSerializable usuarioSerializable = (UsuarioSerializable) savedInstanceState.getSerializable("USUARIO_SERIALIZABLE");
        if (usuarioSerializable != null) {
            Log.d(getClass().getSimpleName(), usuarioSerializable.getNome());
            Log.d(getClass().getSimpleName(), usuarioSerializable.getSobrenome());
        }

        UsuarioParcelable usuarioParcelable = savedInstanceState.getParcelable("USUARIO_PARCELABLE");
        if (usuarioParcelable != null) {
            Log.d(getClass().getSimpleName(), usuarioParcelable.getNome());
            Log.d(getClass().getSimpleName(), usuarioParcelable.getSobrenome());
        }
    }
}
