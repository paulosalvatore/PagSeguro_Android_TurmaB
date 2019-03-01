package br.com.paulosalvatore.pagseguroandroidturmab;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.net.URL;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String URL_IMAGE = "https://portal9677.blob.core.windows.net/portal/2017/07/RedacaoUOL_f_002.jpg";
//    private static final String URL_IMAGE = "https://eoimages.gsfc.nasa.gov/images/imagerecords/87000/87903/tyuleniy_oli_2016097_lrg.jpg";

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
    }

    public void clickWorkerThread(View view) {
        Toast.makeText(this, "Worker Thread", Toast.LENGTH_SHORT).show();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                Toast.makeText(MainActivity.this, "Worker", Toast.LENGTH_SHORT).show();

                final Bitmap bitmap = loadImage(URL_IMAGE);

                imageView.post(new Runnable() {
                    @Override
                    public void run() {
                        imageView.setImageBitmap(bitmap);
                    }
                });
            }
        }).start();
    }

    private Bitmap loadImage(String urlImage) {
        try {
            URL url = new URL(urlImage);
            return BitmapFactory.decodeStream(
                    url.openConnection().getInputStream()
            );
        } catch (Exception e) {
            Log.e("LOAD_IMAGE", "Error loading image.", e);
        }

        return null;
    }
}
