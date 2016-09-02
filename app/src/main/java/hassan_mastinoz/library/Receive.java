package hassan_mastinoz.library;

import android.graphics.Bitmap;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class Receive extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bitmap bitmap = (Bitmap)this.getIntent().getParcelableExtra("Bitmap");

        setContentView(R.layout.activity_receive);

        ImageView viewBitmap = (ImageView)findViewById(R.id.bitmapview);
        viewBitmap.setImageBitmap(bitmap);

    }
}
