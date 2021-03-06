package app.com.pearlsravanthi.mynews;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by sravanthi
 */

public class NewsAdapter extends ArrayAdapter<News> {

    private List<News> mNewsList;

    private static class ViewHolder {
        TextView title;
        TextView publishedDate;
        TextView sectionName;
    }

    public NewsAdapter(Context context, List<News> newsList) {
        super(context, 0, newsList);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        News news = getItem(position);

        ViewHolder viewHolder;

        if( convertView == null) {
            viewHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(R.layout.news_list_item, parent, false);

            viewHolder.title = (TextView) convertView.findViewById(R.id.news_title);
            viewHolder.publishedDate = (TextView) convertView.findViewById(R.id.published_date);
            viewHolder.sectionName = (TextView) convertView.findViewById(R.id.section_name);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.title.setText(news.getWebTitle());
        viewHolder.publishedDate.setText(news.getPublicationDate());
        viewHolder.sectionName.setText("Section : "+news.getSectionName().toUpperCase());

        return convertView;
    }
}
