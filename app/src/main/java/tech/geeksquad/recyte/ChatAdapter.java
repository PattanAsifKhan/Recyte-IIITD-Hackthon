package tech.geeksquad.recyte;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.annotation.NonNull;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ChatAdapter extends ArrayAdapter<Message> {

    public ChatAdapter(@NonNull Context context, @NonNull List<Message> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Message item = getItem(position);
        View view = convertView;
        if (item != null) {
            TextView textView;
            ImageView imageView = null;
            if (item.getAuthor().equalsIgnoreCase("user")) {
                view = LayoutInflater.from(getContext()).inflate(R.layout.adapterright, null);
                textView = (TextView) view.findViewById(R.id.usertext);
                imageView = (ImageView) view.findViewById(R.id.userimage);
            } else {
                view = LayoutInflater.from(getContext()).inflate(R.layout.adapterleft, null);
                textView = (TextView) view.findViewById(R.id.bottext);
            }

            if (item.getIsImage() == 1) {
                byte[] image = Base64.decode(item.getData(), Base64.DEFAULT);
                Bitmap bitmap = BitmapFactory.decodeByteArray(image, 0, image.length);
                imageView.setImageBitmap(bitmap);
                imageView.setVisibility(View.VISIBLE);
                textView.setVisibility(View.GONE);
            } else {
                textView.setText(item.getMessage());
                if (imageView != null)
                    imageView.setVisibility(View.GONE);
                textView.setVisibility(View.VISIBLE);
            }
        }
        return view;
    }


}
