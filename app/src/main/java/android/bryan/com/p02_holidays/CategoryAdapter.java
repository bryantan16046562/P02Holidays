package android.bryan.com.p02_holidays;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class CategoryAdapter extends ArrayAdapter<Category> {
    private ArrayList<Category> categoryy;
    private Context context;
    private TextView tvCategory;

    public CategoryAdapter(Context context, int resource, ArrayList<Category> objects){
        super(context, resource, objects);
        // Store the food that is passed to this adapter
        categoryy = objects;
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
        View rowView = inflater.inflate(R.layout.type_row, parent, false);

        // Get the TextView object
        tvCategory = (TextView) rowView.findViewById(R.id.tvCategory);


        // The parameter "position" is the index of the
        //  row ListView is requesting.
        //  We get back the food at the same index.
        Category currentFood = categoryy.get(position);
        // Set the TextView to show the food

        tvCategory.setText(currentFood.getName());

        // Return the nicely done up View to the ListView
        return rowView;
    }
}
