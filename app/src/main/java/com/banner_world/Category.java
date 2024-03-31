package com.banner_world;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.ArrayList;

public class Category extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProgressBar progressBar;
//    private DatabaseReference reference;
    private ArrayList<String> list;
    private BannerAdapter adapter;
    private AdView mAdView;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        int arr[] = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3,
                R.drawable.pic4, R.drawable.pic5, R.drawable.pic6, R.drawable.pic7, R.drawable.pic8, R.drawable.pic9, R.drawable.pic10,R.drawable.pic11, R.drawable.pic12, R.drawable.pic13, R.drawable.pic14, R.drawable.pic15, R.drawable.pic16,
                R.drawable.pic17, R.drawable.pic18, R.drawable.pic19, R.drawable.pic20, R.drawable.pic21, R.drawable.pic22,
                R.drawable.pic23, R.drawable.pic24, R.drawable.pic25, R.drawable.pic26, R.drawable.pic27,
                R.drawable.pic28, R.drawable.pic29, R.drawable.pic30, R.drawable.pic31, R.drawable.pic32,
                R.drawable.pic33, R.drawable.pic34, R.drawable.pic35, R.drawable.pic36, R.drawable.pic37,
                R.drawable.pic38, R.drawable.pic39, R.drawable.pic40, R.drawable.pic41, R.drawable.pic42,
                R.drawable.pic43, R.drawable.pic44, R.drawable.pic45, R.drawable.pic46, R.drawable.pic47,
                R.drawable.pic48, R.drawable.pic49, R.drawable.pic50, R.drawable.pic51, R.drawable.pic52,
                R.drawable.pic53, R.drawable.pic54, R.drawable.pic55, R.drawable.pic56, R.drawable.pic57,
                R.drawable.pic58, R.drawable.pic59, R.drawable.pic60, R.drawable.pic61, R.drawable.pic62,
                R.drawable.pic63, R.drawable.pic64, R.drawable.pic65, R.drawable.pic66, R.drawable.pic67,
                R.drawable.pic68, R.drawable.pic69, R.drawable.pic70
        };
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);


//        reference = FirebaseDatabase.getInstance().getReference().child("images");
        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        adapter = new BannerAdapter(arr,Category.this);
        recyclerView.setAdapter(adapter);
//        progressBar = findViewById(R.id.progressbar);
//        if(!isConnected(Category.this)){
//            showCustomDialog();
//        }

//        getData();

    }

//
//    private void showCustomDialog() {
//        AlertDialog.Builder builder = new AlertDialog.Builder(Category.this);
//        builder.setMessage("Please connect to internet to get banners").setCancelable(false)
//                .setPositiveButton("Connect", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialog, int which) {
//                        startActivity(new Intent(Settings.ACTION_WIFI_SETTINGS));
//                    }
//                }).setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                startActivity(new Intent(getApplicationContext(), MainActivity.class));
//                finish();
//
//            }
//        });
//    }
//    private boolean isConnected(Category category){
//        ConnectivityManager connectivityManager =(ConnectivityManager) category.getSystemService(Context.CONNECTIVITY_SERVICE);
//        @SuppressLint("MissingPermission") NetworkInfo wifiConn = connectivityManager.getNetworkInfo(connectivityManager.TYPE_WIFI);
//        @SuppressLint("MissingPermission") NetworkInfo mobileConn = connectivityManager.getNetworkInfo(connectivityManager.TYPE_MOBILE);
//        if((wifiConn!=null && wifiConn.isConnected()) || (mobileConn !=null && mobileConn.isConnected())){
//            return  true;
//        }
//        else{
//            return false;
//        }
//    }
//    public void getData(){
//
//        reference.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//
//                progressBar.setVisibility(View.GONE);
//                Toast.makeText(Category.this, "Please wait while banner is loading", Toast.LENGTH_LONG).show();
//                list = new ArrayList<>();
//                for(DataSnapshot shot:snapshot.getChildren()){
//                    String data = shot.getValue().toString();
//                    list.add(data);
//
//                }
//                recyclerView.setLayoutManager(new GridLayoutManager(Category.this,2));
//                adapter = new BannerAdapter(list,Category.this);
//                recyclerView.setAdapter(adapter);
//
//                progressBar.setVisibility(View.GONE);
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//                progressBar.setVisibility(View.GONE);
//                Toast.makeText(Category.this, "Error"+error.getMessage(), Toast.LENGTH_SHORT).show();
//            }
//        });
//    }

}