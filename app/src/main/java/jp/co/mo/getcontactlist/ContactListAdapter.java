package jp.co.mo.getcontactlist;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.lang.ref.WeakReference;
import java.util.List;

public class ContactListAdapter extends BaseAdapter {

    WeakReference<Activity> mActivity;
    List<ContactItems> mList;


    public ContactListAdapter(Activity activity, List<ContactItems> list) {
        this.mActivity = new WeakReference<>(activity);
        this.mList = list;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = mActivity.get().getLayoutInflater();
        View view = inflater.inflate(R.layout.contact_list_layout, null);

        ContactItems items = mList.get(position);

        if(!TextUtils.isEmpty(items.getName())) {
            ((TextView) view.findViewById(R.id.contactName)).setText(items.getName());
        }
        if(!TextUtils.isEmpty(items.getPhoneNumber())) {
            ((TextView) view.findViewById(R.id.contactNumber)).setText(items.getPhoneNumber());
        }

        return view;
    }
}
