package edu.scse.nehelper;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class NewsAdapter extends BaseAdapter {

    private List<News> newsList;
    private View view;
    private Context mContext;
    private ViewHolder viewHolder;

    public NewsAdapter(Context mContext, List<News> newsList) {
        this.newsList = newsList;
        this.mContext= mContext;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public Object getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.news_item,
                    null);
            viewHolder = new ViewHolder();
            viewHolder.newsTitle = (TextView) view.findViewById(R.id.news_title);
            viewHolder.newsDesc = (TextView)view.findViewById(R.id.news_desc);
            viewHolder.imageView = (ImageView) view.findViewById(R.id.image_view);
            viewHolder.newsTime=(TextView)view.findViewById(R.id.news_time);
            view.setTag(viewHolder);
        } else {
            view = convertView;
            viewHolder = (ViewHolder) view.getTag();
        }
        if (newsList.get(position).getNewsBitmap() != null) {
            viewHolder.imageView.setImageBitmap(newsList.get(position).getNewsBitmap());
        } else {
            //���û��ͼƬ����imageview�ؼ�����
            viewHolder.imageView.setVisibility(View.GONE);
        }
        viewHolder.newsTitle.setText(newsList.get(position).getNewsTitle());
        viewHolder.newsDesc.setText(newsList.get(position).getDesc());
        viewHolder.newsTime.setText(newsList.get(position).getTime());
        return view;
    }

    class ViewHolder{
        TextView newsTitle;
        TextView newsDesc;
        TextView newsTime;
        ImageView imageView;
    }

}