package dbh.leo.com.permissionmanagement.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.support.v4.content.ContextCompat;

/**
 * 权限检查
 * Created by lulei on 2016/5/3.
 */
public class CheckPermissionUtil {
    private Context mContext;

    public CheckPermissionUtil(Context mContext) {
        this.mContext = mContext.getApplicationContext();
    }

    /**
     * 检查权限集合
     *
     * @param permissions
     * @return
     */
    public boolean lackPermissions(String... permissions) {

        for (String permission : permissions) {
            if (lackPermission(permission)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否缺少指定权限
     *
     * @param permission
     * @return
     */
    private boolean lackPermission(String permission) {
        return ContextCompat.checkSelfPermission(mContext, permission) ==
                PackageManager.PERMISSION_DENIED;
    }

    /**
     * 是否已经申请全部权限
     *
     * @param permissions
     * @return
     */
    public boolean hasAllPermissionGranted(int[] permissions) {
        for (int permission : permissions) {
            if (permission == PackageManager.PERMISSION_DENIED) {
                return false;
            }
        }
        return true;
    }
}
