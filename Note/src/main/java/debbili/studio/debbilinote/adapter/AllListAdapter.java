package debbili.studio.debbilinote.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import debbili.studio.debbilinote.R;
import debbili.studio.debbilinote.data.NoteData;

/**
 * Created by SarahLee on 2017/3/11.
 */

public class AllListAdapter extends BaseAdapter {

    private Context mContext;
    private List<NoteData> mAllList = new ArrayList<>();
    private boolean mIsEditMode = false;

    public AllListAdapter(Context contexxt, List<NoteData> all_list) {
        this.mContext = contexxt;
        this.mAllList = all_list;
    }

    public void setEditMode(boolean isEditMode) {
        this.mIsEditMode = isEditMode;
    }

    @Override
    public int getCount() {
        return mAllList.size();
    }

    @Override
    public Object getItem(int position) {
        return mAllList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder mHolder = null;
        if(convertView==null) {
            mHolder = new ViewHolder();
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(R.layout.item_all_note, null);
            mHolder.id = (TextView) convertView.findViewById(R.id.note_id);
            mHolder.title = (TextView) convertView.findViewById(R.id.title);
            mHolder.content = (TextView) convertView.findViewById(R.id.content);
            convertView.setTag(mHolder);
        } else {
            mHolder = (ViewHolder) convertView.getTag();
        }
        NoteData note = mAllList.get(position);
        mHolder.note_id = note.getId();
        mHolder.id.setText(String.valueOf(note.getId()));
        mHolder.title.setText(note.getTitle());
        mHolder.content.setText(note.getContent());
        return convertView;
    }

    public class ViewHolder {
        public TextView id,title, content;
        public int note_id;
    }
}
