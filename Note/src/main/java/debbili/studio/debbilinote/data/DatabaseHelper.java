package debbili.studio.debbilinote.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.Date;

/**
 * Created by liyue_000 on 2017/3/5.
 */
public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "db_note";
    private static final int DB_VERSION = 1;
    private SQLiteDatabase mDB;
    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DB_VERSION);
        mDB = this.getReadableDatabase();
    }
    public DatabaseHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE IF NOT EXISTS note (" +
                "id integer primary key autoincrement, " +
                "title text, " +
                "content text, " +
                "create_time  DEFAULT CURRENT_TIMESTAMP, " +
                "is_share integer, " +
                "sharelist text, " +
                "is_alarm integer, " +
                "alarmtime text, " +
                "repeat_type integer)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void createNewNote(NoteData noteData) {
        String title = noteData.getTitle();
        String content = noteData.getContent();
        Date createTime = noteData.getCreateDate();
        int isShare = noteData.isShare()?1:0;
        String shareList = noteData.getShareList().toString();
        int isAlarm = noteData.isAlarm()?1:0;
        Date alarmTime = noteData.getAlarmDate();
        int repeatType = noteData.getRepeatType();

        String insert_sql = "insert into note" +
                " ( title, content, is_share, sharelist, is_alarm, repeat_type )" +
                " values" +
                " ( '" + title +"', '" + content + "'," + isShare + ", '" + shareList + "', " + isAlarm + ", " + repeatType + " )";
        mDB.execSQL(insert_sql);
    }
}
