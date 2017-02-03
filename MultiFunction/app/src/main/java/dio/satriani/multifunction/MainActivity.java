package dio.satriani.multifunction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA ="dio.satriani.multifunctionapp.Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void showMessage(View view){
        //contoh penggunaan explicit intent
        Intent intent = new Intent(this, ShowMessage.class);
        TextView txtMessage = (TextView) findViewById(R.id.txt_message);
        intent.putExtra(EXTRA, txtMessage.getText().toString());
        startActivity(intent);
    }

    public void openBrowser(View view){
        //membuka activity yang akan mengeksekusi implicit intent
        Intent intent = new Intent(this, IntentExecutor.class);
        intent.putExtra(EXTRA, "browse");
        startActivity(intent);
    }

    public  void openPhone(View view){
        //membuka activity yang
        Intent intent = new Intent(this, IntentExecutor.class);
        intent.putExtra(EXTRA, "phone");
        startActivity(intent);
    }
    public  void openPeta(View view){
        //membuka activity yang
        Intent intent = new Intent(this, IntentExecutor.class);
        intent.putExtra(EXTRA, "map");
        startActivity(intent);
    }
}
