package com.example.exam.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.exam.MainActivity;
import com.example.exam.R;
import com.example.exam.entity.Product;
import com.example.exam.room.AppDatabase;

public class FormActivity extends AppCompatActivity {
    Button btnSubmit;
    EditText etProductName;
    EditText etProductQuantity;
    Context context;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);
        db = AppDatabase.getAppDatabase(this);
        context = this;
        initData();
        initListener();
    }

    private void initData() {
        etProductName = (EditText) findViewById(R.id.product_name);
        etProductQuantity = (EditText) findViewById(R.id.product_quantity);
        btnSubmit = (Button) findViewById(R.id.buttonSubmitForm);
    }

    private void initListener() {
        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String et1 = etProductName.getText().toString();
                String et2 = etProductQuantity.getText().toString();
                try {
                    Product product = new Product();
                    product.productName = et1;
                    product.quantity = Integer.parseInt(et2);
                    db.productDao().insertProduct(product);
                    CharSequence charSequence = "Successful";
                    Toast toast = Toast.makeText(getApplicationContext(), charSequence, Toast.LENGTH_LONG);
                    toast.show();
                    context.startActivity(new Intent(context, MainActivity.class));
                } catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }
}