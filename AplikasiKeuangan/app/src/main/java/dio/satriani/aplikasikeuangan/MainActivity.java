package dio.satriani.aplikasikeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String strShow = "";
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtShow = (TextView) findViewById(R.id.txt_show);

        TransaksiHelper dHelper = new TransaksiHelper(this);
        List<Transaksi> ListTrans = dHelper.getTransaksi();

        for (int i = 0; i < ListTrans.size();i++){
            Transaksi trans = ListTrans.get(i);
            strShow += "----------------------------------\n";
            strShow += trans.nama+"["+trans.getJenis()+"] : "+trans.jumlah
                        +"\n"+trans.keterangan+"\n";
        }
        txtShow.setText(strShow);

    }
    public void pindah(View view){
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }
}
