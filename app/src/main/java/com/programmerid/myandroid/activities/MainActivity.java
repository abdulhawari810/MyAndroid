package com.programmerid.myandroid;

import android.os.Bundle;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import com.programmerid.myandroid.databinding.ActivityMainBinding;
import com.programmerid.myandroid.fragments.HomeFragment;
import com.programmerid.myandroid.fragments.AboutFragment;
import com.programmerid.myandroid.fragments.SettingsFragment;

import androidx.fragment.app.Fragment;

public class MainActivity extends AppCompatActivity {

  public void loadFragment(Fragment fragment){
    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer,fragment).addToBackStack(null).commit();
  }

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        setSupportActionBar(binding.toolbar);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this,
                binding.drawerLayout,
                binding.toolbar,
                R.string.open_drawer,
                R.string.close_drawer
        );

        binding.drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        loadFragment(new HomeFragment());

      binding.navigationView.setNavigationItemSelectedListener(item -> {

    if (item.getItemId() == R.id.nav_home) {
        loadFragment(new HomeFragment());
    } else if (item.getItemId() == R.id.nav_about) {
        loadFragment(new AboutFragment());
    } else if (item.getItemId() == R.id.nav_settings) {
        loadFragment(new SettingsFragment());
    }

    /*if (loadFragment != null) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragmentContainer, fragment)
                .commit();
    }*/

    binding.drawerLayout.closeDrawers();

    return true;
});

    }
}