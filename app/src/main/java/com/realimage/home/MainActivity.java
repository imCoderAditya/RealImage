package com.realimage.home;

import static android.content.ContentValues.TAG;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.realimage.R;
import com.realimage.screens.DeshboardFragment;
import com.realimage.screens.HomeFragment;
import com.realimage.screens.HotTubFragment;
import com.realimage.screens.MoviesFragment;
import com.realimage.widgets.SearchActivity;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {

    BottomAppBar bottomAppBar;
    BottomNavigationView bottomNavigationView;
    FloatingActionButton floatingActionButton;
    int i = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment,new HomeFragment())
                .commit();

        setContentView(R.layout.activity_main);

        bottomAppBar =(BottomAppBar) findViewById(R.id.bottomAppBar);
        bottomNavigationView = (BottomNavigationView)findViewById(R.id.bottomNavigationBar);
//        floatingActionButton = (FloatingActionButton)findViewById(R.id.floatingActionButton);

//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view){
//                Log.d(TAG, String.valueOf(i+=10));
//            }
//        });

        bottomAppBar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(TAG, String.valueOf(i++));
            }
        });
        bottomAppBar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.search:
                        startActivity(new Intent(getApplicationContext(), SearchActivity.class));
                        break;
                }
                return false;
            }
        });

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @SuppressLint("NonConstantResourceId")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fragment = null;
                switch (item.getItemId()){
                    case R.id.home:
                        fragment = new HomeFragment();
                        break;
                    case R.id.dashboard:
                        fragment = new DeshboardFragment();
                        break;
                    case R.id.movies:
                        fragment = new MoviesFragment();
                        break;
                    case R.id.music:
                        fragment = new HotTubFragment();
                        break;
                }
                try{
                    assert fragment != null;
                    getSupportFragmentManager()
                           .beginTransaction()
                           .replace(R.id.fragment,fragment)
                           .commit();
                }catch(Exception e){
                    e.printStackTrace();
                }
                return true;
            }
        });
    }
}
