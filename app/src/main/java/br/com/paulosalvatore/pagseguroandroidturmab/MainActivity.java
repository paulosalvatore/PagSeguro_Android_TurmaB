package br.com.paulosalvatore.pagseguroandroidturmab;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

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

        RecyclerView.Adapter adapter = new ProgrammingLanguageAdapter(programmingLanguages);
        recyclerView.setAdapter(adapter);
    }
}
