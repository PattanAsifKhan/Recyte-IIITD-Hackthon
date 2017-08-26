package tech.geeksquad.recyte;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PlaceAdapter extends ArrayAdapter<Places> {

    public PlaceAdapter(@NonNull Context context, @NonNull List<Places> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Places item = getItem(position);
        View view = convertView;
        if (item != null) {
            if (view == null) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.maplayout, null);
            }
            TextView name = (TextView) view.findViewById(R.id.placename);
            TextView address = (TextView) view.findViewById(R.id.address);
            name.setText(item.getPlace());
            address.setText(item.getAddress());
        }
        return view;
    }


}
