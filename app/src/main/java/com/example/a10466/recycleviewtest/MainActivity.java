package com.example.a10466.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private List<Fruit> fruitList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initFruits();//用于初始化所有的水果数据
        RecyclerView recyclerView =findViewById(R.id.recycle_view);//先获得RecyclerView的实例
        StaggeredGridLayoutManager layoutManager =new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);//创建StaggeredGridLayoutManager
        //第一个参数用于指定布局的列数，传入3表示回把布局分为3列；第二个参数用于指定布局的排列方向。传入StaggeredGridLayoutManager.VERTICAL会让布局纵向排列
       /* LinearLayoutManager layoutManager = new LinearLayoutManager(this);//然后创建一个LinearLayoutManager对象，这里LinearLayoutManager是线性布局的意思
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);*/
        recyclerView.setLayoutManager(layoutManager);//并加它设置到RecyclerView当中，layoutManager用于指定RecyclerView的布局方式
        FruitAdapter adapter = new FruitAdapter(fruitList);//创建FruitAdapter的实例，并将水果数据传入FruitAdapter的构造函数
        recyclerView.setAdapter(adapter);//最后调用recyclerView的setAdapter()方法来完成适配器的设置。完成RecycleView和数据之间的关联。
    }
    private void initFruits(){
        for (int i=0;i<3;i++){
            Fruit apple = new Fruit(getRandomLengthName("Apple"),R.drawable.apple);

            fruitList.add(apple);
            Fruit banana = new Fruit(getRandomLengthName("Banane"),R.drawable.banana);
            fruitList.add(banana);
            Fruit cherry = new Fruit(getRandomLengthName("Cherry"),R.drawable.cherry);
            fruitList.add(cherry);
            Fruit grape = new Fruit(getRandomLengthName("Grape"),R.drawable.grape);
            fruitList.add(grape);
            Fruit mango = new Fruit(getRandomLengthName("Mango"),R.drawable.mango);
            fruitList.add(mango);
            Fruit orange = new Fruit(getRandomLengthName("Orange"),R.drawable.orange);
            fruitList.add(orange);
            Fruit pear = new Fruit(getRandomLengthName("pear"),R.drawable.pear);
            fruitList.add(pear);
            Fruit watermelon = new Fruit(getRandomLengthName("Watermelon"),R.drawable.watermelon);
            fruitList.add(watermelon);
            Fruit pineapple = new Fruit(getRandomLengthName("Pineapple"),R.drawable.pineapple);
            fruitList.add(pineapple);
            Fruit strawberry = new Fruit(getRandomLengthName("Strawberry"),R.drawable.strawberry);
            fruitList.add(strawberry);

        }
    }
    private String getRandomLengthName(String name){//使用Random对象来创建一个1到20之间的随机数，然后降参数中传入的字符串随机重复几遍。
        Random random = new Random();
        int length = random.nextInt(20) + 1;
        StringBuilder builder= new StringBuilder();
        for (int i = 0 ; i<length;i++){
            builder.append(name);
        }
        return  builder.toString();

    }
}
