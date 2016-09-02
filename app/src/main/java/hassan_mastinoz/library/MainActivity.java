package hassan_mastinoz.library;

import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TypedArray imgs;

    int[] androidBooksImg = {
            R.drawable.android_1,
            R.drawable.android_2,
            R.drawable.android_3,
            R.drawable.android_4,
            R.drawable.android_5
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView list = (ListView) findViewById(R.id.listView);
        String [] AndroidBooksTitle = getResources().getStringArray(R.array.AndroidBooksTitle);
        String [] AndroidBooksAuthor = getResources().getStringArray(R.array.AndroidBooksAuthor);
        ArrayList<listitem> listBook = new ArrayList<listitem>();

        for (int i = 0; i < AndroidBooksTitle.length || i < AndroidBooksAuthor.length; i++){
            listBook.add(new listitem(i,androidBooksImg[i],AndroidBooksTitle[i],AndroidBooksAuthor[i]));
        }

        ListAdapter ad = new ListAdapter(listBook);
        list.setAdapter(ad);

        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView title = (TextView)view.findViewById(R.id.Book_Title);
                TextView author = (TextView)view.findViewById(R.id.Author);
                ImageView imageView = (ImageView)findViewById(R.id.Book_Image);
//                Toast.makeText(MainActivity.this, title.getText() , Toast.LENGTH_SHORT).show();
                imgs = getResources().obtainTypedArray(R.array.AndroidBooksImage);

                
                Intent intent = new Intent(MainActivity.this,SingleBook.class);


//                imageView.buildDrawingCache();
//                Bitmap image= imageView.getDrawingCache();
//
//                Bundle extras = new Bundle();
//                extras.putParcelable("imagebitmap", image);


                intent.putExtra("titleBook",title.getText());
                intent.putExtra("Author",author.getText());
                startActivity(intent);
            }
        });



    }


    class ListAdapter extends BaseAdapter{

        ArrayList<listitem> listitem = new ArrayList<listitem>();
        ListAdapter(ArrayList<listitem> listitem){
            this.listitem = listitem;
        }

        @Override
        public int getCount() {
            return listitem.size();
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public Object getItem(int position) {
            return listitem.get(position).title;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            LayoutInflater layoutInflater = getLayoutInflater();
            View view = layoutInflater.inflate(R.layout.list_book,null);

            TextView id = (TextView)view.findViewById(R.id.id);
            ImageView img = (ImageView)view.findViewById(R.id.Book_Image);
            TextView title = (TextView)view.findViewById(R.id.Book_Title);
            TextView author = (TextView)view.findViewById(R.id.Author);

            id.setText(String.valueOf(listitem.get(position).id));
            img.setImageResource(listitem.get(position).img);
            title.setText(listitem.get(position).title);
            author.setText(listitem.get(position).author);

            return view;
        }
    }
}
