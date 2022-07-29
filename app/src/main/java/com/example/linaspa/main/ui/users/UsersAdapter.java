package com.example.linaspa.main.ui.users;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.linaspa.R;

import java.util.List;

public class UsersAdapter extends BaseAdapter {
    private Context context;
    private int layout;
    private List<Users> usersList;
    public UsersAdapter(Context context,int layout,List<Users> usersList){
        this.context=context;
        this.layout=layout;
        this.usersList=usersList;
    }
    @Override
    public int getCount() {
        return usersList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
    private class ViewHolder{
        TextView text_Name,text_UserName;
        ImageView img_Edit,img_Delete;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view==null){
            holder=new ViewHolder();
            LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view=inflater.inflate(layout,null);
            holder.text_Name=(TextView) view.findViewById(R.id.text_Name);
            holder.text_UserName=(TextView) view.findViewById(R.id.text_UserName);
            holder.img_Edit=(ImageView) view.findViewById(R.id.img_Edit);
            holder.img_Delete=(ImageView) view.findViewById(R.id.img_Delete);
            view.setTag(holder);
        }
        else{
            holder=(ViewHolder) view.getTag();
        }
        Users users= usersList.get(i);
        holder.text_Name.setText(users.getName());
        holder.text_UserName.setText(users.getUserName());
        return view;
    }
}
