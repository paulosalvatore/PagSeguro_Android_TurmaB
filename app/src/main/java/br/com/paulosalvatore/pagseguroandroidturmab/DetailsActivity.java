package br.com.paulosalvatore.pagseguroandroidturmab;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DetailsActivity extends AppCompatActivity {

    private static final String TEXT = "TEXT";

    private TextView textView;

    private String persistText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

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

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String persistedText = savedInstanceState.getString(TEXT);
        textView.setText(persistedText);
    }
}
