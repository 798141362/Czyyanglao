package listview;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo1.application1.R;


/**
 * Created by lenovo1 on 2019/2/10.
 */
public class MyListAdapter extends BaseAdapter{

    private Context mContext;
    private LayoutInflater mLayoutInflater;

    public MyListAdapter(Context context){
        this.mContext = context;
        mLayoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 50;//要保证确实有有效的数据传到了自定义的适配器里。因为如果getcount（）的返回值是0的话，getview是不会被执行的。
    }
//getCount实现列表长度
    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{//静态class
        public ImageView imageView;
        public TextView tvTitle,tvTime,tvContent;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup Parent) {
        ViewHolder holder = null; //先申明 实义化viewholder
        if(convertView == null){
             convertView = mLayoutInflater.inflate(R.layout.layout_list_item,null);
             holder = new ViewHolder();
             holder.imageView = (ImageView) convertView.findViewById(R.id.iv);
             holder.tvTitle = (TextView) convertView.findViewById(R.id.tv_title);
             holder.tvContent = (TextView) convertView.findViewById(R.id.tv_content);
             holder.tvTime = (TextView) convertView.findViewById(R.id.tv_time);//让每一控件都能被找到
            convertView.setTag(holder);
        }else {
            holder = (ViewHolder) convertView.getTag();
        }
        //给控件赋值
        holder.tvTitle.setText("药名");
        holder.tvTime.setText("2019-03-09");
        holder.tvContent.setText("服药说明");

        return convertView;
    }
}
//getview重要