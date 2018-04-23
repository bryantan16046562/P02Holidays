package android.bryan.com.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvCategory;
    ArrayAdapter aa;
    ArrayList<Category> categoryy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lvCategory = (ListView) this.findViewById(R.id.lvCategory);

        // Create a few food objects in Food array
        categoryy = new ArrayList<Category>();
        categoryy.add(new Category("Secular"));

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new CategoryAdapter(this, R.layout.type_row, categoryy);
        lvCategory.setAdapter(aa);

        lvCategory.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    String secular = "Secular";
                    Intent i = new Intent(MainActivity.this, HolidaysActivity.class);
                    i.putExtra("secular", secular);
                    startActivity(i);
                }
            }
        });
    }
}
