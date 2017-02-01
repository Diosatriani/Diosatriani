package satriani.dio.simplecalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void calculate(View view){
        EditText num1 = (EditText) findViewById(R.id.num1);
        EditText num2 = (EditText) findViewById(R.id.num2);
        TextView result = (TextView) findViewById(R.id.result);
        RadioGroup operator = (RadioGroup) findViewById(R.id.operator);

        double angka1, angka2, hasil=0;
        angka1 = Double.parseDouble(num1.getText().toString());
        angka2 = Double.parseDouble(num2.getText().toString());
        int opr = operator.getCheckedRadioButtonId();

        if (opr == R.id.plus){
            hasil = angka1+ angka2;
        }else if (opr == R.id.minus){
            hasil = angka1-angka2;
        }
        //perkalian
        //pembagian
        result.setText(Double.toString(hasil));
    }
}
