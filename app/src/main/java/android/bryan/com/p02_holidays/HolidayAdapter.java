package android.bryan.com.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.ImageView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter<Holiday> {
    private ArrayList<Holiday> holiday;
    private Context context;
    private TextView tvName;
    private TextView tvDate;
    private ImageView ivImg;

    public HolidayAdapter (Context context, int resource, ArrayList<Holiday> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        holiday = objects;
        // Store Context object as we would need to use it later
        this.context = context;
    }

    // getView() is the method ListView will call to get the
    //  View object every time ListView needs a row
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // The usual way to get the LayoutInflater object to
        //  "inflate" the XML file into a View object
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        // "Inflate" the row.xml as the layout for the View object
        View rowView = inflater.inflate(R.layout.holiday_row, parent, false);

        // Get the TextView object
        tvName = (TextView) rowView.findViewById(R.id.tvName);
        tvDate = (TextView) rowView.findViewById(R.id.tvDate);
        // Get the ImageView object
        ivImg = (ImageView) rowView.findViewById(R.id.ivImg);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Holiday currentHoliday = holiday.get(position);
        // Set the TextView to show the food
        tvName.setText(currentHoliday.getName());
        tvDate.setText(currentHoliday.getDate());

        // Set the image
        if(tvName.getText().toString().equalsIgnoreCase("Christmas Day") ) {
            ivImg.setImageResource(R.drawable.christmas);
        } else if(tvName.getText().toString().equalsIgnoreCase("Chinese New Year") ) {
            ivImg.setImageResource(R.drawable.cny);
        } else if(tvName.getText().toString().equalsIgnoreCase("Deepavali") ) {
            ivImg.setImageResource(R.drawable.deepavali);
        } else if(tvName.getText().toString().equalsIgnoreCase("Good Friday") ) {
            ivImg.setImageResource(R.drawable.goodfriday);
        } else if(tvName.getText().toString().equalsIgnoreCase("Hari Raya Haji") ) {
            ivImg.setImageResource(R.drawable.harirayahaji);
        } else if(tvName.getText().toString().equalsIgnoreCase("Hari Raya Puasa") ) {
            ivImg.setImageResource(R.drawable.harirayapuasa);
        } else if(tvName.getText().toString().equalsIgnoreCase("Labour Day") ) {
            ivImg.setImageResource(R.drawable.labourday);
        } else if(tvName.getText().toString().equalsIgnoreCase("National Day") ) {
            ivImg.setImageResource(R.drawable.nationalday);
        } else if(tvName.getText().toString().equalsIgnoreCase("New Year's Day") ) {
            ivImg.setImageResource(R.drawable.newyear);
        } else if(tvName.getText().toString().equalsIgnoreCase("Vesak Day") ) {
            ivImg.setImageResource(R.drawable.vesakday);
        }
        // Return the nicely done up View to the ListView
        return rowView;
    }
}
