package www.mohamed.com.fragmentex;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.zip.Inflater;

/**
 * Created by User on 1/27/2017.
 */

 interface OnEditlistener{

    public void newItemadded(String item) ;
}
public class EnternameFragment extends Fragment {

    OnEditlistener onEditlistener ;
    EditText editText ;
    View view ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


            view = inflater.inflate(R.layout.first_fragmint, container, false);
            editText = (EditText) view.findViewById(R.id.first_fr);
            editText.setOnKeyListener(new View.OnKeyListener() {
                @Override
                public boolean onKey(View v, int keyCode, KeyEvent event) {
                    if (event.getAction() == KeyEvent.ACTION_DOWN) {
                        if ((keyCode == KeyEvent.KEYCODE_ENTER) || (keyCode == KeyEvent.KEYCODE_DPAD_CENTER)) {
                            if(onEditlistener!=null) {
                                onEditlistener.newItemadded(editText.getText().toString());
                            }
                            else{
                                onEditlistener = (OnEditlistener) getActivity();
                                onEditlistener.newItemadded(editText.getText().toString());
                            }
                            editText.setText("");
                        }
                    }

                    return false;
                }
            });

        return view ;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            onEditlistener = (OnEditlistener) context;
        }catch (ClassCastException e){
            Log.i("exception","Class must implement OnEditlistenr");
        }
    }
}
