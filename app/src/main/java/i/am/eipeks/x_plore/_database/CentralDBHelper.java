package i.am.eipeks.x_plore._database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



public class CentralDBHelper extends SQLiteOpenHelper {

    //Database general information
    private static final String DB_NAME = "centralDB.db";
    private static final int DB_VERSION = 1;

    public CentralDBHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
