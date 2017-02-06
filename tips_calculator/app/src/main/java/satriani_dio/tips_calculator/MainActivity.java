package satriani_dio.tips_calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
    public void calculator (View view){
        EditText input1 = (EditText) findViewById(R.id.input1);
        EditText input2 = (EditText) findViewById(R.id.input2);
        EditText input3 = (EditText) findViewById(R.id.input3);
        double inp1 , inp2, inp3;

        String hasil = "";
        inp1 = Double.parseDouble(input1.getText().toString());
        inp2 = Double.parseDouble(input2.getText().toString());
        inp3 = Double.parseDouble(input3.getText().toString());

        hasil = "Tips :"+(inp1*(inp2/100))+"\n";
        hasil += "Total :"+(inp1+(inp1*(inp2/100)))+"\n";
        hasil += "Per Orang :"+((inp1+(inp1*(inp2)/100))/inp3)+"\n";

        TextView result = (TextView) findViewById(R.id.result);
        result.setText(hasil);
    }
}
