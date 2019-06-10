package com.ugtechie;

import android.support.design.widget.BottomNavigationView;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import com.ugtechie.Fragments.CartFragment;
import com.ugtechie.Fragments.GiftsFragment;
import com.ugtechie.Fragments.ProfileFragment;
import com.ugtechie.Fragments.StoreFragment;


public class HomeActivity extends AppCompatActivity {

    private ActionBar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = getSupportActionBar();

        // load the store fragment by default
        toolbar.setTitle("Shop");
        loadFragment(new StoreFragment());

        BottomNavigationView navigation = findViewById(R.id.navigation);

       navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
           @Override
           public boolean onNavigationItemSelected(@NonNull MenuItem item) {

               Fragment fragment;

               switch (item.getItemId()){
                   case R.id.navigation_shop:
                       toolbar.setTitle("Shop");
                       // Creates and loads the fragment
                       fragment = new StoreFragment();
                       loadFragment(fragment);

                       return true;
                   case R.id.navigation_gifts:
                       toolbar.setTitle("My Gifts");

                       // Creates and loads the fragment
                       fragment = new GiftsFragment();
                       loadFragment(fragment);
                       return true;
                   case R.id.navigation_cart:
                       toolbar.setTitle("Cart");

                       // Creates and loads the fragment
                       fragment = new CartFragment();
                       loadFragment(fragment);
                       return true;
                   case R.id.navigation_profile:
                       toolbar.setTitle("Profile");

                       // Creates and loads the fragment
                       fragment = new ProfileFragment();
                       loadFragment(fragment);
                       return true;
               }
               return false;
           }
       });

    }

    private void loadFragment(Fragment fragment) {
        // load fragment
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack(null);
        transaction.commit();
    }
}
