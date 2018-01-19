package com.example.vijay.runtimepermsission;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.vijay.runtimepermsission.DesignPatternOfPermssion.DesignPermssion;
import com.example.vijay.runtimepermsission.SimplePermission.SimplePermissionActivity;


public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void view_click(View view) {
        switch (view.getId()) {
            case R.id.simplepermission:
                startActivity(new Intent(getApplicationContext(), SimplePermissionActivity.class));
                break;
            case R.id.design_of_permission:
                startActivity(new Intent(getApplicationContext(), DesignPermssion.class));
                break;

        }
    }
}
