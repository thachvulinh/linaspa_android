package com.example.linaspa.main;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.ListView;

import com.example.linaspa.R;
import com.example.linaspa.databinding.ActivityMainBinding;
import com.example.linaspa.main.ui.gallery.GalleryFragment;
import com.example.linaspa.main.ui.home.HomeFragment;
import com.example.linaspa.main.ui.slideshow.SlideshowFragment;
import com.example.linaspa.main.ui.users.UsersFragment;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {
    private AppBarConfiguration mAppBarConfiguration;
    private ActivityMainBinding binding;
    ListView lvUsers;
    public String users_list="http://192.168.1.2/honespa.atwebpages.com/api/admin/users/list";
    private  static final int FRAGMENT_HOME=1;
    private  static final int FRAGMENT_GALLERY=2;
    private  static final int FRAGMENT_SLINESHOW=3;
    private  static final int FRAGMENT_USERS=4;

    private  int currentFragment=FRAGMENT_HOME;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        setSupportActionBar(binding.appBarMain.toolbar);

        binding.appBarMain.fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        DrawerLayout drawer = binding.drawerLayout;
        NavigationView navigationView = binding.navView;
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(
                this,drawer,binding.appBarMain.toolbar,R.string.main_drawer_open,R.string.main_drawer_clode);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    @Override
    public void onBackPressed(){
        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else{
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id=item.getItemId();
        if(id==R.id.nav_home){
            if(FRAGMENT_HOME!=currentFragment){
                replaceFragment(new HomeFragment());
                currentFragment=FRAGMENT_HOME;
            }
        }
        else if(id==R.id.nav_gallery){
            if(FRAGMENT_GALLERY!=currentFragment){
                replaceFragment(new GalleryFragment());
                currentFragment=FRAGMENT_GALLERY;
            }
        }
        else if(id==R.id.nav_slideshow){
            if(FRAGMENT_SLINESHOW!=currentFragment){
                replaceFragment(new SlideshowFragment());
                currentFragment=FRAGMENT_SLINESHOW;
            }
        }
        else if(id==R.id.nav_user){
            if(FRAGMENT_USERS!=currentFragment){
                replaceFragment(new UsersFragment());
                currentFragment=FRAGMENT_USERS;
            }
        }
        DrawerLayout drawer=findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return  true;
    }
    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame,fragment);
        fragmentTransaction.commit();
    }
}