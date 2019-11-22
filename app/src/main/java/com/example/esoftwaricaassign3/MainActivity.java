package com.example.esoftwaricaassign3;

import android.os.Bundle;

import com.example.esoftwaricaassign3.models.Student;
import com.example.esoftwaricaassign3.ui.dashboard.StudentForm;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        StudentForm.userDetails.add(new Student("Samikshya oli", "23","Nepal", "female"));
        StudentForm.userDetails.add(new Student("Sadhikshya oli", "20","nepal", "female"));
        StudentForm.userDetails.add(new Student("Hari oli", "22","Nepal", "male"));



        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(navView, navController);
    }

}
