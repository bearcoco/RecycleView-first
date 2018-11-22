package com.example.a10466.recycleviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by 10466 on 2018/11/21.
 */

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder>{//先不写泛型
    private List<Fruit> mFruitList;

    static class ViewHolder extends RecyclerView.ViewHolder{//这里是第一步 定义一个ViewHolder的内部类继承RecyclerView.ViewHolder
        View fruitView ;//在ViewHolder中添加了fruitView变量来保存子项最外层布局的实例，
    private ImageView fruitImage;
    private TextView fruitName;

        public ViewHolder(View itemView) { //ViewHolder的构造函数中要传入一个View参数，这个参数通向就是RecycleView子项的最外层布局
            super(itemView);
            fruitView= itemView;
            fruitImage = itemView.findViewById(R.id.fruit_image);//那么我们就可以通过findViewById()方法来获取布局中的Imageview和TextView的实例了
            fruitName=itemView.findViewById(R.id.fruit_name);
        }
    }

    public FruitAdapter(List<Fruit> fruitList) {//接下来FruitAdapter中也有一个构造函数，这个方法用于要把展示的数据源传进来
        mFruitList=fruitList;//并赋值给一个全局变量mFruitList，我们后续的操作都将在这个数据源的基础上进行。

    }
   //由于FruitAdapter是继承 RecyclerView.Adapter的，那么就必须重写onCreateViewHolder()，onBindViewHolder()，getItemCount()这3个方法
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {//onCreateViewHolder()方法是用于创建ViewHolder实例的

        View view =LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item,parent,false);//我们在这个方法中讲fruit_item布局加载进来，
        final ViewHolder holder = new ViewHolder(view);//然后创建一个ViewHolder实例， 并把加载出来的布局传入到构造函数当中
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();//再点击事件中先获取用户点击的positon，
                Fruit fruit = mFruitList.get(position);//然后通过position拿到相应的Fruit实例
                Toast.makeText(view.getContext(),"you clicked view"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        holder.fruitView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Fruit fruit = mFruitList.get(position);
                Toast.makeText(view.getContext(),"you clicked image"+fruit.getName(),Toast.LENGTH_SHORT).show();
            }
        });
        return holder;//最后将ViewHolder的实例返回
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {//onBindViewHolder()方法是用于对RecycleView子项的数据进行赋值的，会在每个子项被滚动到屏幕内的时候执行。
        Fruit fruit = mFruitList.get(position);//这里我们通过positon参数得到当前想的Fruit实例
        holder.fruitImage.setImageResource(fruit.getImageId());//然后再将数据设置到ImageView和TextView当中即可。
        holder.fruitName.setText(fruit.getName());


    }

    @Override
    public int getItemCount() {// getItemCount()告诉RecycleView一共有多少子项，直接返回数据源的长度就可以了
        return mFruitList.size();
    }


}
