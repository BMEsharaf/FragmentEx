package www.mohamed.com.fragmentex;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by User on 1/27/2017.
 */


public class Listfragment extends Fragment {

    View view ;
    ListView listView ;
    ArrayAdapter<String> arrayAdapter ;
    ArrayList<String> names = new ArrayList<String>();
    Activity activity ;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(view ==null) {
            view = inflater.inflate(R.layout.second_fragment, container, false);
            listView = (ListView) view.findViewById(R.id.list);
            arrayAdapter = new ArrayAdapter<String>(activity,R.layout.notepadetextview,names);
            listView.setAdapter(arrayAdapter);
        }
        return view ;
    }

    public void newItem (String item){
        names.add(0,item);
        if(listView!=null){
            arrayAdapter.notifyDataSetChanged();
        }
    }
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);

        this.activity = activity;
    }
}
