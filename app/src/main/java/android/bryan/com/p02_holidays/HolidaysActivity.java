package android.bryan.com.p02_holidays;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class HolidaysActivity extends AppCompatActivity {
    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Intent i = getIntent();
        String nametype = i.getStringExtra("secular");
        TextView tvholidaytype = (TextView) findViewById(R.id.tvselectedcategory);
        tvholidaytype.setText(nametype);


        lv = (ListView) this.findViewById(R.id.lvHolidays);

        // Create a few food objects in Food array
        holiday = new ArrayList<Holiday>();
        holiday.add(new Holiday("New Year's Day", "1 Jan 2017"));
        holiday.add(new Holiday("Labour Day", "1 May 2017"));

        // Link this Activity object, the row.xml layout for
        //  each row and the food String array together
        aa = new HolidayAdapter(this, R.layout.holiday_row, holiday);
        lv.setAdapter(aa);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Holiday selectedHoliday = holiday.get(position);

                Toast.makeText(HolidaysActivity.this, selectedHoliday.getName()
                                + " Date: " + selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });
    }
}
