package com.example.customlist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView_product;
    ArrayList<Product> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView_product=findViewById(R.id.listview_products);

        list=new ArrayList<Product>();
        Product product1=new Product("Laptp","i5-intel 16 gb ram 1TB harddisk","laptop","35000",true);
        Product product2=new Product("Hard-Disk","1TB 3.0 high speed","harddisk","5000",false);

        list.add(product1);
        list.add(product2);

        ProductAdapter myadapter=new ProductAdapter(this,list);
        listView_product.setAdapter(myadapter);
    }
}
