package com.example.dominos;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.Resource;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import java.util.List;


public class ProductAdapter extends ArrayAdapter<Product> {
    private Context context;
    public ProductAdapter(@NonNull Context context, List<Product> products) {
        super(context,R.layout.product_item,products);
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View v = layoutInflater.inflate(R.layout.product_item,null);

        TextView txtTitle = v.findViewById(R.id.product_title);
        TextView txtDescription = v.findViewById(R.id.product_description);
        TextView txtPrice = v.findViewById(R.id.product_price);
        RelativeLayout imgbg =  v.findViewById(R.id.layout_background);
        Product product = getItem(position);

        txtTitle.setText(product.getProductTitle());
        txtDescription.setText((product.getProductDescription()));
        txtPrice.setText(product.getProductPrice());
        String[] sizes = {"Small","Medium","Large","Extra Large"};
        String[] Crust = {"Classic Hand toasted","Wheat Thin Crust","Classic Crust","Cheese Crust"};

        Glide.with(context).load(product.getProductImage()).into(new SimpleTarget<Drawable>() {
            @Override
            public void onResourceReady(@NonNull Drawable resource, @Nullable Transition<? super Drawable> transition) {
                imgbg.setBackground(resource);
            }
        });

        Spinner spinnerSizes = v.findViewById(R.id.spinner_size);
        Spinner spinnerCrust = v.findViewById(R.id.spinner_crust);
        ArrayAdapter<String> sizeadapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item,sizes);
        ArrayAdapter<String> crustadapter = new ArrayAdapter<>(context, android.R.layout.simple_spinner_dropdown_item,Crust);

        spinnerSizes.setAdapter(sizeadapter);
        spinnerCrust.setAdapter(crustadapter);
        return v;
    }
}
