package com.example.wanderlust_test;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.navigation.NavigationView;

public class africa extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout drawerLayout;

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                startActivity(new Intent(this, MainActivity.class));
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
                AlertDialog.Builder logout = new AlertDialog.Builder(this);
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

                AlertDialog alertDialog = logout.create();
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
        setContentView(R.layout.activity_africa);

        drawerLayout = findViewById(R.id.drawerLayout);
        findViewById(R.id.imagemenu).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigationView);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void goToHome(View view) {
        startActivity(new Intent(this, MainActivity.class));
    }
}