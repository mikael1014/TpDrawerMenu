package com.example.mytpdrawermenu;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.os.Bundle;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = findViewById(R.id.drawerLayout);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout,
                toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.navView);
        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutPrincipal,
                AccountFragment.newInstance()).commit();

        navigationView.setNavigationItemSelectedListener(item -> {
            switch (item.getItemId()) {
                case R.id.navprofile:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutPrincipal,
                            AccountFragment.newInstance()).commit();
                    break;
                case R.id.navchat:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutPrincipal,
                            ChatFragment.newInstance()).commit();
                    break;
                case R.id.navmessage:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutPrincipal,
                            MessageFragment.newInstance()).commit();
                    break;
                case R.id.navSend:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutPrincipal,
                            SendFragment.newInstance()).commit();
                    break;
                case R.id.navShare:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayoutPrincipal,
                            ShareFragment.newInstance()).commit();
                    break;
            }
            drawerLayout.closeDrawer(GravityCompat.START);
            return true;
        });
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}