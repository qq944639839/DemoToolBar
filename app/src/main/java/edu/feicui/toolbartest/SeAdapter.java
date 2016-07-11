package edu.feicui.toolbartest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/7/8.
 */
public class SeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<String> list = new ArrayList<>();
    private Context context;
    RecyclerView.ViewHolder viewHolder = null;
    private int isContent;

    public SeAdapter(Context context) {
        this.context = context;
    }
    public List<String> getList() {
        return list;
    }
    public void setList(List<String> list) {
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = null;

        if (viewType == 1){
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_one,parent,false);
            viewHolder = new ViewHolderOne(view);
        }else {
            view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view_two,parent,false);
            viewHolder = new ViewHolderTwo(view);
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (isContent == 1){
            ViewHolderOne holderOne = (ViewHolderOne) holder;
            holderOne.tv_text1.setText(list.get(position));
        }
        if (isContent == 2){
            ViewHolderTwo holderTwo = (ViewHolderTwo) holder;
            holderTwo.tv_text2.setText(list.get(position));
        }

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (position%2 == 0){
            isContent = 1;
            return isContent;
        }else {
            isContent = 2;
            return isContent;
        }
    }

    class ViewHolderOne extends RecyclerView.ViewHolder{
        TextView tv_text1;
        public ViewHolderOne(View v) {
            super(v);
            tv_text1 = (TextView) v.findViewById(R.id.tv_text1);
        }
    }

    class ViewHolderTwo extends RecyclerView.ViewHolder{
        TextView tv_text2;
        public ViewHolderTwo(View itemView) {
            super(itemView);
            tv_text2 = (TextView) itemView.findViewById(R.id.tv_text2);
        }
    }

}
