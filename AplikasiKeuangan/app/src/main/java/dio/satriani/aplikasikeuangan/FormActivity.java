package dio.satriani.aplikasikeuangan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    private String [] jenisStr = {"Pemasukan", "Pengeluaran"};
    private EditText edtNama, edtJumlah, edtKeterangan;
    private Spinner spnJenis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        spnJenis = (Spinner) findViewById(R.id.jenis);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, jenisStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnJenis.setAdapter(adapter);

        edtNama = (EditText) findViewById(R.id.name);
        edtJumlah = (EditText) findViewById(R.id.jumlah);
        edtKeterangan = (EditText) findViewById(R.id.keterangan);
    }

    public void saveTransaksi(View view){
        TransaksiHelper dHelper = new TransaksiHelper(this);
        String nama = edtNama.getText().toString();
        int jenis = spnJenis.getSelectedItemPosition()+1;
        int jumlah = Integer.parseInt(edtJumlah.getText().toString());
        String keterangan = edtKeterangan.getText().toString();

        dHelper.insertTransaksi(nama, jenis, jumlah, keterangan);

        Log.d("form.transaksi", nama+" -"+Integer.toString(jenis)+" -"+Integer.toString(jumlah)
                                +" -"+keterangan);

                Toast.makeText(this, "Transaksi"+nama+" berhasil disimpan", Toast.LENGTH_SHORT).show();
        //startActivity(new Intent(this, MainActivity.class));
        finish();
    }
}
