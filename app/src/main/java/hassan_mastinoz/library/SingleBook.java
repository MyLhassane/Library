package hassan_mastinoz.library;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by hassan on 8/18/16.
 */
public class SingleBook  extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.single_book);

        TextView title = (TextView)findViewById(R.id.Book_Title);
        TextView author = (TextView)findViewById(R.id.author);
        ImageView image = (ImageView)findViewById(R.id.image);



        Intent iin= getIntent();
        Bundle b = iin.getExtras();



//        Bundle extras = getIntent().getExtras();
//        Bitmap bmp = (Bitmap) extras.getParcelable("imagebitmap");
//
//        image.setImageBitmap(bmp );




        if(b!=null)
        {
            String titleBook =(String) b.get("titleBook");
            title.setText(titleBook);
            String Author =(String) b.get("Author");
            author.setText(Author);

        }
    }

}
