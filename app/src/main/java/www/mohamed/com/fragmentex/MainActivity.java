package www.mohamed.com.fragmentex;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements OnEditlistener{

    EnternameFragment enternameFragment ;
    Listfragment     listfragment ;
    FragmentManager fragmentManager   ;
    FragmentTransaction fragmentTransaction ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        enternameFragment = new EnternameFragment();
        listfragment      = new Listfragment();
        fragmentManager = getFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.container1,enternameFragment);
        fragmentTransaction.add(R.id.container2,listfragment);
        fragmentTransaction.commit();
    }

    @Override
    public void newItemadded(String item) {
        listfragment.newItem(item);
    }
}
