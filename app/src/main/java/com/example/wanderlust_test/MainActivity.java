package com.example.wanderlust_test;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private DrawerLayout drawerLayout;

    // Check if we're running on Android 5.0 or higher
    @Override
    public void onBackPressed() {
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.home:
                break;
            case R.id.fav:
                startActivity(new Intent(this, FavoritesFragment.class));
                break;
            case R.id.profile:
                startActivity(new Intent(this, ProfileFragment.class));
                break;
            case R.id.visit:
                startActivity(new Intent(this, VisitedFragment.class));
                break;
            case R.id.about:
                startActivity(new Intent(this, AboutUsFragment.class));
                break;
            case R.id.lgout:
                AlertDialog.Builder logout=new AlertDialog.Builder(this);
                logout.setMessage("Are you sure you want to Log Out?");
                logout.setTitle("Log Out Alert");
                logout.setCancelable(false);

                logout.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });

                logout.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });

                AlertDialog alertDialog=logout.create();
                alertDialog.show();
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        overridePendingTransition(R.anim.enteractvity, R.anim.backactivity);
        setContentView(R.layout.activity_main);

        drawerLayout=findViewById(R.id.drawerLayout);
        findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView= (NavigationView)findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void goToHome(View view){

    }

    public void goToAsia(View view){

        startActivity(new Intent(MainActivity.this, asia.class));
    }

    public void goToAfrica(View view){


        startActivity(new Intent(MainActivity.this,africa.class));
    }

    public void goToEurope(View view){

        startActivity(new Intent(MainActivity.this,europe.class));
    }

    public void goToNamerica(View view){
        startActivity(new Intent(MainActivity.this,namerica.class));
    }

    public void goToSamerica(View view){
        startActivity(new Intent(MainActivity.this,samerica.class));
    }

    public void goToAustralia(View view){
        startActivity(new Intent(MainActivity.this,australia.class));
    }

    public void goToAntarctica(View view){
        startActivity(new Intent(MainActivity.this,antarctica.class));
    }
}
