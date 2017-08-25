package tech.geeksquad.recyte;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class adapter extends ArrayAdapter<Message> {

    public adapter(@NonNull Context context, @NonNull List<Message> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message item = getItem(position);
        View view = convertView;
        if (item != null) {
            TextView textView;
            if (item.getAuthor().equalsIgnoreCase("user")) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.adapterright, parent);
                textView = (TextView) view.findViewById(R.id.usertext);
            } else {
                view = LayoutInflater.from(getContext()).inflate(R.layout.adapterleft, parent);
                textView = (TextView) view.findViewById(R.id.bottext);
            }

            textView.setText(item.getMessage());
        }
        return view;
    }


}
