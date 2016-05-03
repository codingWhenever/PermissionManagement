package dbh.leo.com.permissionmanagement;

import android.Manifest;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import dbh.leo.com.permissionmanagement.utils.CheckPermissionUtil;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_CODE = 999;
    private final String[] PERMISSIONS = new String[]{
            Manifest.permission.RECORD_AUDIO,
            Manifest.permission.MODIFY_AUDIO_SETTINGS
    };

    private CheckPermissionUtil checkPermissionUtil;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        checkPermissionUtil = new CheckPermissionUtil(this);
    }


    @Override
    protected void onResume() {
        super.onResume();
        //check
        if (checkPermissionUtil.lackPermissions(PERMISSIONS)) {
            PermissionActivity.startActivityForResult(this, REQUEST_CODE, PERMISSIONS);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE && resultCode == PermissionActivity.PERMISSION_DENIED) {
            //拒绝授权
            finish();
        }
    }
}
