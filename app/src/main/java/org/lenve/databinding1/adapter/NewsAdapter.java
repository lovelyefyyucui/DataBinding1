package org.lenve.databinding1.adapter;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import org.lenve.databinding1.R;
import org.lenve.databinding1.data.DayNews;
import org.lenve.databinding1.util.UILRequestManager;

import java.util.List;

public class NewsAdapter extends BaseAdapter {
	private Context context;
	private List<DayNews> list;
	public NewsAdapter(Context context, List<DayNews> list)
	{
		this.context = context;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		return position;
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	private class Holder {
		ImageView msgPic;
		TextView msgTitle, time, content;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		Holder holder;
		if (convertView == null) {
			holder = new Holder();
			convertView = View.inflate(context,
					R.layout.msg_listview_item, null);
			holder.msgPic = (ImageView) convertView.findViewById(R.id.msg_pic);
			holder.msgTitle = (TextView) convertView
					.findViewById(R.id.msg_title);
			holder.content = (TextView) convertView
					.findViewById(R.id.msg_author);
			holder.time = (TextView) convertView
					.findViewById(R.id.msg_time);
			convertView.setTag(holder);
		} else {
			holder = (Holder) convertView.getTag();
		}
		DayNews news = list.get(position);
		String img = news.getLogofile();
		if (!TextUtils.isEmpty(img)){
			UILRequestManager.displayImage(img, holder.msgPic);
		}
		holder.msgTitle.setText(news.getTitle());
		holder.content.setText(news.getSummary());
		String time = "2015-04-09 08:10:56";
		if (!TextUtils.isEmpty(news.getPublishdate())) {
			time = news.getPublishdate();
		}
		holder.time.setText(time);
		return convertView;
	}
	

	
}
