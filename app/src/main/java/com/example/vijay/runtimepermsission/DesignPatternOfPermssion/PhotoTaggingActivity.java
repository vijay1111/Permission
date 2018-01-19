package com.example.vijay.runtimepermsission.DesignPatternOfPermssion;

import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.view.View;
import android.widget.Toast;

import com.example.vijay.runtimepermsission.R;

public class PhotoTaggingActivity extends BaseActivity {
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_tagging);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_PHOTO_TAGGING_PERMISSIONS && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            if (checkWhetherAllPermissionsPresentForPhotoTagging()) {
                Toast.makeText(this, "Please go ahead do your stuff", Toast.LENGTH_SHORT).show();
            } else if (requestCode == MY_PHOTO_TAGGING_PERMISSIONS && grantResults[0] == PackageManager.PERMISSION_DENIED) {
                Snackbar.make(findViewById(android.R.id.content), "Permission denied, photo tagging will not work, to enable now click here",
                        Snackbar.LENGTH_INDEFINITE).setAction("ENABLE", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        ActivityCompat.requestPermissions(PhotoTaggingActivity.this, getDeniedPermissionsAmongPhototaggingPermissions(), MY_PHOTO_TAGGING_PERMISSIONS);
                    }
                }).show();
            }
        } else if (permissions.length > 1) {
            if (requestCode == MY_PHOTO_TAGGING_PERMISSIONS) {
                if (checkWhetherAllPermissionsPresentForPhotoTagging()) {
                    Toast.makeText(this, "Please go ahead do your stuff", Toast.LENGTH_SHORT).show();
                } else {
                    Snackbar.make(findViewById(android.R.id.content), "Permissions denied, photo tagging will not work. To enable now click here",
                            Snackbar.LENGTH_INDEFINITE).setAction("ENABLE", new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            ActivityCompat.requestPermissions(PhotoTaggingActivity.this, getDeniedPermissionsAmongPhototaggingPermissions(), MY_PHOTO_TAGGING_PERMISSIONS);
                        }
                    }).show();
                }
            }
        }
    }

    public void view_click(View view) {
        switch (view.getId()) {
            case R.id.buttonTagPhoto:
                if (checkWhetherAllPermissionsPresentForPhotoTagging()) {
                    Toast.makeText(PhotoTaggingActivity.this, "Go ahead, you have all permissions", Toast.LENGTH_LONG).show();
                } else {
                    requestRunTimePermissions(PhotoTaggingActivity.this, permissionsNeededForPhotoTagging, MY_PHOTO_TAGGING_PERMISSIONS);
                }

                break;
        }
    }
}
