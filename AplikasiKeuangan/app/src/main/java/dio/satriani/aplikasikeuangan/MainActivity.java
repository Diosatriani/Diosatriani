package dio.satriani.aplikasikeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    String strShow = "";
    TextView txtShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    @Override
    protected void onResume() {
        super.onResume();

        ListView listTransaksi =  (ListView) findViewById(R.id.list_transaksi);
        TransaksiHelper dHelper = new TransaksiHelper(this);
        final List<Transaksi> ListTrans = dHelper.getTransaksi();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, ListTrans);
        listTransaksi.setAdapter(adapter);

        int saldo = 0;
        for (int i =0; i < ListTrans.size();i++){
            if (ListTrans.get(i).jenis == 1){
                saldo += ListTrans.get(i).jumlah;
            }else{
                saldo -= ListTrans.get(i).jumlah;
            }
        }

        TextView txtSaldo = (TextView) findViewById(R.id.txt_saldo);
        txtSaldo.setText("Saldo Tersisa: "+Integer.toString(saldo));

        listTransaksi.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Transaksi transaksi = ListTrans.get(position);
                Intent intent = new Intent(parent.getContext(), detail.class);
                intent.putExtra("transaksi.detail", transaksi);
                startActivity(intent);
            }
        });

       // txtShow = (TextView) findViewById(R.id.txt_show);

        //TransaksiHelper dHelper = new TransaksiHelper(this);
        //List<Transaksi> ListTrans = dHelper.getTransaksi();

        //for (int i = 0; i < ListTrans.size();i++){
        //    Transaksi trans = ListTrans.get(i);
        //    strShow += "----------------------------------------------------\n";
        //    strShow += trans.nama+"["+trans.getJenis()+"] : "+trans.jumlah
        //            +"\n"+trans.keterangan+"\n";
        //}
      //  txtShow.setText(strShow);
    }


    public void pindah(View view){
        Intent intent = new Intent(this, FormActivity.class);
        startActivity(intent);
    }
}
