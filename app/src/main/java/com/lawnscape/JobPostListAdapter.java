package com.lawnscape;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mellis on 2/19/2017.
 */

public class JobPostListAdapter extends BaseAdapter {
    private ArrayList<Job> jobPostDetails;
    private LayoutInflater layoutInflater;

    public JobPostListAdapter(Context aContext, ArrayList<Job> listData) {
        this.jobPostDetails = listData;
        layoutInflater = LayoutInflater.from(aContext);
    }

    @Override
    public int getCount() {
        return jobPostDetails.size();
    }

    @Override
    public Job getItem(int position) {
        return jobPostDetails.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.layout_job_post, null);
            holder = new ViewHolder();
            holder.tvTitle = (TextView) convertView.findViewById(R.id.tvPostLayoutTitle);
            holder.tvDescription = (TextView) convertView.findViewById(R.id.tvPostLayoutDescription);
            holder.tvLocation = (TextView) convertView.findViewById(R.id.tvPostLayoutLocation);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvTitle.setText(jobPostDetails.get(position).getTitle());
        holder.tvDescription.setText(jobPostDetails.get(position).getDescription());
        holder.tvLocation.setText(jobPostDetails.get(position).getLocation());
        return convertView;
    }

    static class ViewHolder {
        TextView tvTitle;
        TextView tvDescription;
        TextView tvLocation;
    }
}
