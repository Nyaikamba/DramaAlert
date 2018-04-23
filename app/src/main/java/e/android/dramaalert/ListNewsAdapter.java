package e.android.dramaalert;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.HashMap;

public class ListNewsAdapter extends BaseAdapter  {
    private Activity activity;
    private ArrayList<HashMap<String, String>> data;

    ListNewsAdapter(Activity a, ArrayList<HashMap<String, String>> d) {
        activity = a;
        data=d;
    }
    public int getCount() {
        return data.size();
    }
    public Object getItem(int position) {
        return position;
    }
    public long getItemId(int position) {
        return position;
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        ListNewsViewHolder holder;
        if (convertView == null) {
            holder = new ListNewsViewHolder();
            convertView = LayoutInflater.from(activity).inflate(
                    R.layout.list_row, parent, false);
            holder.galleryImage = convertView.findViewById(R.id.galleryImage);
            holder.author = convertView.findViewById(R.id.author);
            holder.title = convertView.findViewById(R.id.title);
            holder.sdetails = convertView.findViewById(R.id.description);
            holder.time = convertView.findViewById(R.id.time);
            convertView.setTag(holder);
        } else {
            holder = (ListNewsViewHolder) convertView.getTag();
        }
        holder.galleryImage.setId(position);
        holder.author.setId(position);
        holder.title.setId(position);
        holder.sdetails.setId(position);
        holder.time.setId(position);

        HashMap<String, String> song;
        song = data.get(position);

        try{
            holder.author.setText(song.get(SecondActivity.KEY_AUTHOR));
            holder.title.setText(song.get(SecondActivity.KEY_TITLE));
            holder.time.setText(song.get(SecondActivity.KEY_PUBLISH_DATE));
            holder.sdetails.setText(song.get(SecondActivity.KEY_DESCRIPTION));

            if(song.get(SecondActivity.KEY_IMAGE).length() < 5)
            {
                holder.galleryImage.setVisibility(View.GONE);
            }
        }
        catch(Exception e) {}
        return convertView;
    }
}


