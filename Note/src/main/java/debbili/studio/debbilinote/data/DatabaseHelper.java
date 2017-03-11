package debbili.studio.debbilinote.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
                "share_list text, " +
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
                " ( title, content, is_share, share_list, is_alarm, repeat_type )" +
                " values" +
                " ( '" + title +"', '" + content + "'," + isShare + ", '" + shareList + "', " + isAlarm + ", " + repeatType + " )";
        mDB.execSQL(insert_sql);
    }

    public List<NoteData> queryAllNote() {
        String query_all = "select * from note";
        Cursor cursor = mDB.query("note",null,null,null,null,null,"id");
        List<NoteData> noteList = new ArrayList<>();
        while (cursor.moveToNext()) {
            int noteID = cursor.getInt(cursor.getColumnIndex("id"));
            String title = cursor.getString(cursor.getColumnIndex("title"));
            String content = cursor.getString(cursor.getColumnIndex("content"));
            int isShare = cursor.getInt(cursor.getColumnIndex("is_share"));
            Object shareList = cursor.getString(cursor.getColumnIndex("share_list"));
            int isAlarm = cursor.getInt(cursor.getColumnIndex("is_alarm"));
            int repeatType = cursor.getInt(cursor.getColumnIndex("repeat_type"));
            NoteData note = new NoteData();
            note.setId(noteID);
            note.setTitle(title);
            note.setContent(content);
            note.setShare(isShare==1);
            note.setAlarm(isAlarm==1);
            note.setRepeatType(repeatType);
            noteList.add(note);
        }
        Log.i("debbili", noteList.size()+noteList.toString());
        return noteList;
    }

    public void deleteNote(int id) {
        String delete_note = "delete from note where id="+id;
        Log.i("debbili", "id = "+id);
        mDB.execSQL(delete_note);
    }
}
