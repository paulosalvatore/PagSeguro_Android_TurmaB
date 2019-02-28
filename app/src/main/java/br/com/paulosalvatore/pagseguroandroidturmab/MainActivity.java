package br.com.paulosalvatore.pagseguroandroidturmab;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        ProgrammingLanguage programmingLanguage = new ProgrammingLanguage(
                R.drawable.java,
                "Java",
                1996,
                "Java Description");

        List<ProgrammingLanguage> programmingLanguages = new ArrayList<>();
        programmingLanguages.add(programmingLanguage);
        programmingLanguages.add(programmingLanguage);

        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tvTitle = v.findViewById(R.id.tvTitle);
                Toast.makeText(MainActivity.this, "Clicked item: " + tvTitle.getText(), Toast.LENGTH_LONG).show();
            }
        };

        RecyclerView.Adapter adapter = new ProgrammingLanguageAdapter(programmingLanguages, listener);
        recyclerView.setAdapter(adapter);
    }
}
