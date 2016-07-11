package edu.feicui.toolbartest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/7/8.
 */
public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder>{

    private Context context;

    public MyAdapter(Context context) {
        this.context = context;
    }

    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyAdapter.ViewHolder holder, int position) {

        holder.mImageView.setImageResource(R.drawable.icon_setting);
        holder.mTextContent.setText("你是干啥的阿斯顿法师的肺癌");

        holder.mItemClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, Main2Activity.class);
                context.startActivity(intent);
            }
        });
        //手动更改高度，不同位置高度不同
        holder.mTextContent.setHeight(100 + (position % 3) * 30);
    }

    @Override
    public int getItemCount() {
        return 20;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView mTextContent;
        ImageView mImageView;
        LinearLayout mItemClick;
        public ViewHolder(View itemView) {
            super(itemView);
            mTextContent = (TextView) itemView.findViewById(R.id.tv_content);
            mImageView = (ImageView) itemView.findViewById(R.id.iv_imageView);
            mItemClick = (LinearLayout) itemView.findViewById(R.id.rl_itemClick);
        }
    }
}
