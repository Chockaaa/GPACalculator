package app.chocka;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;
import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {
    private Button button;
    public double alpha=0;
    public static EditText a,b;
    public static float cgpanum,creditnum;
    public static final String cgpasofar ="app.chocka.cgpasofar";
    public static final String creditsofar ="app.chocka.creditsofar";
    public static final String semcredits ="app.chocka.semcredits";
    public static final String semmodules ="app.chocka.semmodules";

    int[] val1 = { 0, 1, 2, 3, 4, 5, 6};
    int[] val2 = { 0, 1, 2, 3, 4, 5, 6,7,8,9,10,11,12};
    int[] creditdetails={0,0,0,0,0,0,0,0};
    int[] modulegradedetails={0,0,0,0,0,0,0,0};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_home);




        ArrayAdapter<CharSequence> adapter0 = ArrayAdapter.createFromResource(this,R.array.creditsspin,android.R.layout.simple_spinner_item);
        adapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner spinner0 = findViewById(R.id.AU_M0);
        spinner0.setAdapter(adapter0);
        spinner0.setOnItemSelectedListener(onItemSelectedListener0);

        Spinner spinner1 = findViewById(R.id.AU_M1);
        spinner1.setAdapter(adapter0);
        spinner1.setOnItemSelectedListener(onItemSelectedListener1);

        Spinner spinner2 = findViewById(R.id.AU_M2);
        spinner2.setAdapter(adapter0);
        spinner2.setOnItemSelectedListener(onItemSelectedListener2);

        Spinner spinner3 = findViewById(R.id.AU_M3);
        spinner3.setAdapter(adapter0);
        spinner3.setOnItemSelectedListener(onItemSelectedListener3);

        Spinner spinner4 = findViewById(R.id.AU_M4);
        spinner4.setAdapter(adapter0);
        spinner4.setOnItemSelectedListener(onItemSelectedListener4);

        Spinner spinner5 = findViewById(R.id.AU_M5);
        spinner5.setAdapter(adapter0);
        spinner5.setOnItemSelectedListener(onItemSelectedListener5);

        Spinner spinner6 = findViewById(R.id.AU_M6);
        spinner6.setAdapter(adapter0);
        spinner6.setOnItemSelectedListener(onItemSelectedListener6);

        Spinner spinner7 = findViewById(R.id.AU_M7);
        spinner7.setAdapter(adapter0);
        spinner7.setOnItemSelectedListener(onItemSelectedListener7);




        ArrayAdapter<CharSequence> aadapter0 = ArrayAdapter.createFromResource(this,R.array.gradespin,android.R.layout.simple_spinner_item);
        aadapter0.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Spinner aspinner0 = findViewById(R.id.GPA_M0);
        aspinner0.setAdapter(aadapter0);
        aspinner0.setOnItemSelectedListener(aonItemSelectedListener0);

        Spinner aspinner1 = findViewById(R.id.GPA_M1);
        aspinner1.setAdapter(aadapter0);
        aspinner1.setOnItemSelectedListener(aonItemSelectedListener1);

        Spinner aspinner2 = findViewById(R.id.GPA_M2);
        aspinner2.setAdapter(aadapter0);
        aspinner2.setOnItemSelectedListener(aonItemSelectedListener2);

        Spinner aspinner3 = findViewById(R.id.GPA_M3);
        aspinner3.setAdapter(aadapter0);
        aspinner3.setOnItemSelectedListener(aonItemSelectedListener3);

        Spinner aspinner4 = findViewById(R.id.GPA_M4);
        aspinner4.setAdapter(aadapter0);
        aspinner4.setOnItemSelectedListener(aonItemSelectedListener4);

        Spinner aspinner5 = findViewById(R.id.GPA_M5);
        aspinner5.setAdapter(aadapter0);
        aspinner5.setOnItemSelectedListener(aonItemSelectedListener5);

        Spinner aspinner6 = findViewById(R.id.GPA_M6);
        aspinner6.setAdapter(aadapter0);
        aspinner6.setOnItemSelectedListener(aonItemSelectedListener6);

        Spinner aspinner7 = findViewById(R.id.GPA_M7);
        aspinner7.setAdapter(aadapter0);
        aspinner7.setOnItemSelectedListener(aonItemSelectedListener7);

        a = (EditText) findViewById(R.id.cgpa);
        b = (EditText) findViewById(R.id.pastcredit);
        a.setText(String.valueOf(0));
        b.setText(String.valueOf(0));



        final Intent intent =getIntent();
        final double bravo = intent.getFloatExtra(Results.acgpasofar,0);
        alpha =intent.getDoubleExtra(Results.aflag,0);

        if(alpha==1)
        {
            final float cgpapast = intent.getFloatExtra(Results.acgpasofar,0);
            final float creditpast = intent.getFloatExtra(Results.acreditsofar,0);
            final int semcredit[] = getIntent().getIntArrayExtra(Results.asemcredits);
            final int semmodule[] = getIntent().getIntArrayExtra(Results.asemmodules);

            aspinner0.setSelection(semmodule[0]);
            aspinner1.setSelection(semmodule[1]);
            aspinner2.setSelection(semmodule[2]);
            aspinner3.setSelection(semmodule[3]);
            aspinner4.setSelection(semmodule[4]);
            aspinner5.setSelection(semmodule[5]);
            aspinner6.setSelection(semmodule[6]);
            aspinner7.setSelection(semmodule[7]);

            spinner0.setSelection(semcredit[0]);
            spinner1.setSelection(semcredit[1]);
            spinner2.setSelection(semcredit[2]);
            spinner3.setSelection(semcredit[3]);
            spinner4.setSelection(semcredit[4]);
            spinner5.setSelection(semcredit[5]);
            spinner6.setSelection(semcredit[6]);
            spinner7.setSelection(semcredit[7]);

            a = (EditText) findViewById(R.id.cgpa);
            b = (EditText) findViewById(R.id.pastcredit);
            a.setText(String.valueOf(cgpapast));
            b.setText(String.valueOf(creditpast));
        }


        button=findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V){
                openActivity();
            }
        });
        button=findViewById(R.id.button3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V)
            {
                openActivity2();
            }
        });
    }

    public void openActivity(){

        Intent intent =new Intent(this, Results.class);

        a = (EditText) findViewById(R.id.cgpa);
        b = (EditText) findViewById(R.id.pastcredit);

        if(TextUtils.isEmpty(a.getText())||TextUtils.isEmpty(b.getText()))
        {
            cgpanum= 0;
            creditnum = 0;

        }
        else {


            cgpanum = Float.parseFloat(a.getText().toString());
            creditnum = Float.parseFloat(b.getText().toString());

            if(cgpanum>5) {
                cgpanum= 0;
                creditnum = 0;
            }

        }



        intent.putExtra(cgpasofar,cgpanum);
        intent.putExtra(creditsofar,creditnum);
        intent.putExtra(semcredits,creditdetails);
        intent.putExtra(semmodules,modulegradedetails);



        startActivity(intent);
    }

    public void openActivity2(){

        Intent intent =new Intent(this, HomeActivity.class);
        alpha=0;
        startActivity(intent);
    }

    AdapterView.OnItemSelectedListener onItemSelectedListener0 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    creditdetails[0]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener onItemSelectedListener1 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    creditdetails[1]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener onItemSelectedListener2 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    creditdetails[2]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener onItemSelectedListener3 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    creditdetails[3]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener onItemSelectedListener4 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    creditdetails[4]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener onItemSelectedListener5 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    creditdetails[5]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener onItemSelectedListener6 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    creditdetails[6]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener onItemSelectedListener7 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    creditdetails[7]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };






    AdapterView.OnItemSelectedListener aonItemSelectedListener0 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    modulegradedetails[0]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener aonItemSelectedListener1 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    modulegradedetails[1]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener aonItemSelectedListener2 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    modulegradedetails[2]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener aonItemSelectedListener3 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    modulegradedetails[3]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener aonItemSelectedListener4 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    modulegradedetails[4]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener aonItemSelectedListener5 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    modulegradedetails[5]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener aonItemSelectedListener6 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    modulegradedetails[6]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };

    AdapterView.OnItemSelectedListener aonItemSelectedListener7 =
            new AdapterView.OnItemSelectedListener(){

                @Override
                public void onItemSelected(AdapterView<?> parent, View view,
                                           int position, long id) {

                    modulegradedetails[7]=position;

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {}
            };


}