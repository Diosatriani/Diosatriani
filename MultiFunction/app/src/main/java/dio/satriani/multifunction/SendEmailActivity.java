package dio.satriani.multifunction;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class SendEmailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_email);
    }

    public void  sendEmail(View view){
        EditText txtpenerima = (EditText) findViewById(R.id.penerima);
        EditText txtjudul= (EditText) findViewById(R.id.judul);
        EditText txtKonten= (EditText) findViewById(R.id.konten);

        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);

        emailIntent.setData(Uri.parse("mailto:"+txtpenerima.getText().toString()));
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, "diosatriani44@gmail.com");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, txtjudul.getText().toString());
        emailIntent.putExtra(Intent.EXTRA_TEXT, txtKonten.getText().toString());


            startActivity(emailIntent);

    }
}
