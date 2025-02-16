package com.example.material_design_3rd_day_2nd_lab;


import android.os.Bundle;
import android.widget.CompoundButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ChipGroup chipGroup;
    RecyclerView recyclerView;
    ArrayList<Mobile> mobileList;
    ArrayList<Mobile> filteredmobileList;
    MobileAdapter mobileListAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.mobileItemsRecyclerView);
        chipGroup = findViewById(R.id.chipGroup);

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        mobileList = new ArrayList<>();
        filteredmobileList = new ArrayList<>();

        mobileList.add(new Mobile("Oppo", "Oppo Find X6 Pro", "A flagship experience with a 6.8-inch AMOLED display, 12GB RAM, and a 50MP triple camera system."));
        mobileList.add(new Mobile("Oppo", "Oppo Reno 8 5G", "The Reno 8 5G offers lightning-fast connectivity, 8GB RAM, 128GB storage, and a 64MP main camera."));
        mobileList.add(new Mobile("Samsung", "Samsung Galaxy S23 Ultra", "Premium phone with a 6.9-inch display, 16GB RAM, and a 200MP quad-camera setup."));
        mobileList.add(new Mobile("Samsung", "Samsung Galaxy A54", "Affordable and feature-packed with a 6.4-inch AMOLED display, 6GB RAM, 128GB storage, and a 50MP main camera."));
        mobileList.add(new Mobile("Apple", "iPhone 14 Pro Max", "The latest in Apple's lineup with a 6.7-inch Super Retina display, A16 Bionic chip, and a 48MP main camera."));
        mobileList.add(new Mobile("Apple", "iPhone SE (2024)", "Compact and powerful with a 4.7-inch Retina display, A15 Bionic chip, and a 12MP single rear camera."));

        mobileListAdapter = new MobileAdapter(MainActivity.this, mobileList);
        recyclerView.setAdapter(mobileListAdapter);
        setupFilterChips();
    }

    private void setupFilterChips() {
        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);
            chip.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    filterMobileList();
                }
            });
        }
    }

    private void filterMobileList() {
        filteredmobileList.clear();
        ArrayList<String> selectedBrand = new ArrayList<>();

        for (int i = 0; i < chipGroup.getChildCount(); i++) {
            Chip chip = (Chip) chipGroup.getChildAt(i);
            if (chip.isChecked()) {
                selectedBrand.add(chip.getText().toString());
            }
        }
        if (selectedBrand.isEmpty()) {
            filteredmobileList.addAll(mobileList);
        } else {
            for (Mobile mobile : mobileList) {
                if (selectedBrand.contains(mobile.getBrand())) {
                    filteredmobileList.add(mobile);
                }
            }
        }
        mobileListAdapter.updateList(filteredmobileList);
    }
}

