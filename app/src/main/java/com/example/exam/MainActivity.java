package com.example.exam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.example.exam.adapter.ListViewAdapter;
import com.example.exam.entity.Product;
import com.example.exam.room.AppDatabase;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ListView listViewProduct;
    private List<Product> listProducts = new ArrayList<>();
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        db = AppDatabase.getAppDatabase(this);
        initData();
        listViewProduct = (ListView) findViewById(R.id.listViewProduct);
        ListViewAdapter adapter = new ListViewAdapter(listProducts, this);
        listViewProduct.setAdapter((ListAdapter) adapter);
        listViewProduct.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Product product = listProducts.get(i);
                Toast.makeText(MainActivity.this, product.productName, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void initData() {
        CharSequence charSequence = "Successful";
        Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
        toast.show();
        List<Product> list = db.productDao().listAll();
        for (Product product : list){
            listProducts.add(product);
            Log.d("TAG", "id: " + product.id + " name: " + product.productName);
        }
    }
}