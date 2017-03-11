package debbili.studio.debbilinote.note;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import debbili.studio.debbilinote.MainActivity;
import debbili.studio.debbilinote.R;
import debbili.studio.debbilinote.data.DatabaseHelper;
import debbili.studio.debbilinote.data.NoteData;

public class CreateNoteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_note);

        final EditText title = (EditText) findViewById(R.id.title);
        final EditText content = (EditText) findViewById(R.id.content);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(title.getText().toString())||TextUtils.isEmpty(content.getText().toString())) {
                    Toast.makeText(CreateNoteActivity.this, "Empty Note Title/Content", Toast.LENGTH_SHORT).show();
                    return;
                }
                //startActivity(new Intent(MainActivity.this, CreateNoteActivity.class));
                DatabaseHelper dbHelper = new DatabaseHelper(CreateNoteActivity.this);
                NoteData note = new NoteData();
                note.setTitle(title.getText().toString());
                note.setContent(content.getText().toString());
                note.setShare(false);
                note.setAlarm(false);
                dbHelper.createNewNote(note);
                Toast.makeText(CreateNoteActivity.this, "Saved New Note", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
