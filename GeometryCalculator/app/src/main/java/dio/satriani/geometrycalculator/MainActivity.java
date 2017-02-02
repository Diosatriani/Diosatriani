package dio.satriani.geometrycalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.geometry);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.geo_operator, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
    }

    public void calculator(View view){
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        Spinner spinner = (Spinner) findViewById(R.id.geometry);
        EditText input3=(EditText) findViewById(R.id.input3);
        double inp2 = 0, inp1 = 0, inp3 = 0;

        String operator = spinner.getSelectedItem().toString();
        String hasil = "";
        inp1 = Double.parseDouble(input1.getText().toString());
        if (input2.isEnabled()){
            inp2 = Double.parseDouble(input2.getText().toString());
        }if(input3.isEnabled())
        {
            inp3=Double.parseDouble(input3.getText().toString());
        }
        if (operator.equalsIgnoreCase("Lingkaran")){
            hasil = "Luas dari Lingkaran adalah :"+(Math.PI * (inp1*inp1))+"\n";
            hasil += "Keliling dari Lingkaran adalah :"+(Math.PI*(2*inp1));

        }else if (operator.equalsIgnoreCase("Segitiga")){
            hasil = "Luas dari Segitiga adalah :"+(inp1*inp2/2)+"\n";
            double hyp = Math.sqrt((inp1*inp1) + (inp2*inp2));
            hasil += "Keliling dari Segitiga adalah :"+(inp1+inp2+hyp);
        }else if(operator.equalsIgnoreCase("persegi")){
            hasil = "Luas dari persegi panjang adalah :"+(inp1*inp2)+"\n";
            hasil += "Keliling dari persegi adalah :"+((inp1*2)+(inp2*2));
        }else if(operator.equalsIgnoreCase("bola"))
        {
            hasil = "Luas Permukaan dari bola adalah : "+(4*Math.PI*inp1*inp1)+"\n";
            hasil += "Volume dari bola adalah : "+((4/3)*Math.PI*inp1*inp1*inp1)+"\n";
        }else
        {
            hasil = "Luas Permukaan dari balok adalah : "+(2*((inp1*inp2)+(inp1*inp3)+(inp2*inp3)))+"\n";
            hasil += "Volume dari balok adalah : "+(inp1*inp2*inp3)+"\n";
        }

        TextView result = (TextView) findViewById(R.id.result);
        result.setText(hasil);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView text1 = (TextView) findViewById(R.id.txt1);

        TextView text2 = (TextView) findViewById(R.id.txt2);
        TextView text3=(TextView) findViewById(R.id.txt3);
        EditText input1=(EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        EditText input3=(EditText) findViewById(R.id.input3);

        String operator = parent.getItemAtPosition(position).toString();
        if (operator.equalsIgnoreCase("Lingkaran")){
            text1.setText("jari-jari");
            text2.setText("");
            text3.setText("");
            input2.setEnabled(false);
            input3.setEnabled(false);

        }else if (operator.equalsIgnoreCase("Segitiga")){
            text1.setText("Alas");
            text2.setText("Tinggi");
            input3.setText("");
            input2.setEnabled(true);
            input3.setEnabled(false);
        }else if (operator.equalsIgnoreCase("Persegi")){
            text1.setText("Panjang");
            text2.setText("Lebar");
            text3.setText("");
            input2.setEnabled(true);
            input3.setEnabled(false);
        }else if (operator.equalsIgnoreCase("bola")){
            text1.setText("Jari-jari");
            text2.setText("");
            text3.setText("");
            input1.setText("");
            input2.setEnabled(false);
            input3.setEnabled(false);
        } else
        {
            text1.setText("Panjang");
            text2.setText("Lebar");
            text3.setText("Tinggi");
            input1.setText("");
            input2.setText("");
            input3.setText("");
            input3.setEnabled(true);
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
