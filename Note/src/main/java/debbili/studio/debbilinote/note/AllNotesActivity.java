package debbili.studio.debbilinote.note;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import debbili.studio.debbilinote.MainActivity;
import debbili.studio.debbilinote.R;
import debbili.studio.debbilinote.adapter.AllListAdapter;
import debbili.studio.debbilinote.data.DatabaseHelper;
import debbili.studio.debbilinote.data.NoteData;


public class AllNotesActivity extends AppCompatActivity {
    ListView all_list;
    List<NoteData> allList = new ArrayList<>();
    AllListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_all_notes);
        all_list = (ListView) findViewById(R.id.all_list);
        DatabaseHelper dbHelper = new DatabaseHelper(AllNotesActivity.this);
        allList = dbHelper.queryAllNote();
        adapter = new AllListAdapter(this, allList);
        all_list.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        all_list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AllListAdapter.ViewHolder holder = (AllListAdapter.ViewHolder)view.getTag();
                DatabaseHelper dbHelper = new DatabaseHelper(AllNotesActivity.this);
                dbHelper.deleteNote(holder.note_id);
                refreshView();
            }
        });
    }
    private void refreshView() {
        DatabaseHelper dbHelper = new DatabaseHelper(AllNotesActivity.this);
        allList.clear();
        List<NoteData> refreshList = dbHelper.queryAllNote();
        Log.i("debbili", "size = "+allList.size());
        allList.addAll(refreshList);
        adapter.notifyDataSetChanged();
    }
}
