package satriani.dio.javaclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String showString;
    public TextView showText;
    public Barang [] arrBarang = new Barang[10];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText = (TextView) findViewById(R.id.show_text);


        showString = "Manipulasi Class Java Android";
        addSeparator();

        initBarang();
        showString += arrBarang[0].toString();
        addSeparator();
        showString += arrBarang[1].toString();
        addSeparator();
        showString += arrBarang[2].toString();
        addSeparator();
        showString += arrBarang[3].toString();
        addSeparator();
        showString += arrBarang[6].toString();
        addSeparator();
        showString += arrBarang[7].toString();
        addSeparator();
        showString += arrBarang[8].toString();
        addSeparator();
        showText.setText(showString);
    }

    public void addSeparator(){
        showString += "\n--------------------------------\n";
    }

    public void  initBarang(){
        arrBarang[0] = new Barang("Laptop",1, 7000000);
        arrBarang[1] = new Barang("Printer",1, 2000000);
        arrBarang[2] = new Barang("Monitor",1, 5000000);
        arrBarang[3] = new Barang("KeyBoard",1, 200000);
        arrBarang[4] = new Barang("CPU",1, 7000000);
        arrBarang[5] = new Barang("Mouse",1, 200000);
        arrBarang[6] = new Barang("Meja",2, 2000000);
        arrBarang[7] = new Barang("Kursi",2, 2000000);
        arrBarang[8] = new Barang("Kabel",2, 200000);

    }
}





