package com.mavolas.mavo.ec.database;

import android.content.Context;

import com.mavolas.mavo.activitys.ProxyActivity;

import org.greenrobot.greendao.database.Database;

/**
 * Created by 宋棋安
 * on 2018/10/6.
 */
public class DatabaseManager {

    private DaoSession mDaoSession = null;
    private UserProfileDao mDao = null;

    private void initDao(Context context){
        final ReleaseOpenHelper helper = new ReleaseOpenHelper( context, "mavo_ec.db" );
        final Database db = helper.getWritableDb();
        mDaoSession = new DaoMaster( db ).newSession();
        mDao = mDaoSession.getUserProfileDao();

    }


}
