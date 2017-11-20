package ipmobil.barisworkout;

import android.app.Fragment;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity{

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    HomeFragment hf= new HomeFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,hf).commit();
                    return true;
                case R.id.navigation_dashboard:
                    DashboardFragment df= new DashboardFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,df).commit();
                    return true;
                case R.id.navigation_excercises:
                    ExcercisesFragment ef= new ExcercisesFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,ef).commit();
                    return true;
                case R.id.navigation_myworkouts:
                    MyWorkoutsFragment mf= new MyWorkoutsFragment();
                    getSupportFragmentManager().beginTransaction().replace(R.id.content,mf).commit();
                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        HomeFragment hf= new HomeFragment();
        getSupportFragmentManager().beginTransaction().replace(R.id.content,hf).commit();

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

    }


}
