package app.chocka;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    private Button button;
    public static final String acgpasofar ="com.example.application.gpacalculator.cgpasofar";
    public static final String acreditsofar ="com.example.application.gpacalculator.creditsofar";
    public static final String asemcredits ="com.example.application.gpacalculator.semcredits";
    public static final String asemmodules ="com.example.application.gpacalculator.semmodules";
    public static final String aflag ="com.example.application.gpacalculator.aflag";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_results);

        TextView t1,t2,t3;
        t1=(TextView)findViewById(R.id.semgpa);
        t2=(TextView)findViewById(R.id.cgpa);
        t3=(TextView)findViewById(R.id.creditscleared);

        final Intent intent =getIntent();
        final float cgpapast = intent.getFloatExtra(HomeActivity.cgpasofar,0);
        final float creditpast = intent.getFloatExtra(HomeActivity.creditsofar,0);
        final int semcredit[] = getIntent().getIntArrayExtra(HomeActivity.semcredits);
        final int semmodule[] = getIntent().getIntArrayExtra(HomeActivity.semmodules);

        double gpapresent=0;
        double cgpa=0;
        double creditsumpresent = 0;
        creditsumpresent=creditcalc(semcredit[0],semmodule[0])+creditcalc(semcredit[1],semmodule[1])+creditcalc(semcredit[2],semmodule[2])+creditcalc(semcredit[3],semmodule[3])
                +creditcalc(semcredit[4],semmodule[4])+creditcalc(semcredit[5],semmodule[5])+creditcalc(semcredit[6],semmodule[6])+creditcalc(semcredit[7],semmodule[7]);

        gpapresent=calculation(semcredit[0],semmodule[0])+calculation(semcredit[1],semmodule[1])+calculation(semcredit[2],semmodule[2])+calculation(semcredit[3],semmodule[3])
                +calculation(semcredit[4],semmodule[4])+calculation(semcredit[5],semmodule[5])+calculation(semcredit[6],semmodule[6])+calculation(semcredit[7],semmodule[7]);
        double semgpa=0;
        semgpa=gpapresent/creditsumpresent;


        if(gpapresent>0 && creditsumpresent>0)
        {

        }
        else
        {
            semgpa=0;
        }
        t1.setText(""+String.format("%.02f", semgpa));


        double creditsumfull = creditpast+creditsumpresent;

        if(cgpapast>0 && semgpa==0)
        {
            cgpa=cgpapast;
        }
        else if(semgpa>0 && cgpapast==0)
        {
            cgpa=semgpa;
        }
        else if(semgpa>0 && cgpapast>0)
        {
            cgpa=(semgpa*creditsumpresent+cgpapast*creditpast)/creditsumfull;
        }


        t2.setText(""+String.format("%.02f",cgpa));


        t3.setText(""+(creditsumfull));

        //+semcredit[0]+semcredit[1]+semcredit[2]+semcredit[3]+semcredit[4]+semcredit[5]+semcredit[6]+semcredit[7]+
        button=findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View V){
                openActivity(cgpapast,creditpast,semcredit,semmodule);


            }
        });
    }






    public void openActivity(float cgpapast, float creditpast, int[] semcredit, int[] semmodule){

        Intent intent =new Intent(this, HomeActivity.class);
        double flag=1;
        intent.putExtra(acgpasofar,cgpapast);
        intent.putExtra(acreditsofar,creditpast);
        intent.putExtra(asemcredits,semcredit);
        intent.putExtra(asemmodules,semmodule);
        intent.putExtra(aflag,flag);

        startActivity(intent);
    }

    public double creditcalc(int a,int b)
    {   double grade;
        double credit;
        double value;
        credit=0;
        switch (a)
        {
            case 1:

                break;
            case 2:
                credit=2;
                break;
            case 3:
                credit=3;
                break;
            case 4:
                credit=4;
                break;
            case 5:
                credit=5;
                break;
            default:
                credit=0;
                break;
        }

        switch (b)
        {
            case 1:
                grade=1;
                break;
            case 2:
                grade=1;
                break;
            case 3:
                grade =1;
                break;
            case 4:
                grade=1;
                break;
            case 5:
                grade=1;
                break;
            case 6:
                grade=1;
                break;
            case 7:
                grade=1;
                break;
            case 8:
                grade=1;
                break;
            case 9:
                grade=1;
                break;
            default:
                grade=0;
                break;
        }
        value=grade*credit;

        return value;


    }


    public double calculation(int a, int b)
    {
        double grade;
        int credit;
        double value;

        switch (a)
        {
            case 1:
                credit=1;
                break;
            case 2:
                credit=2;
                break;
            case 3:
                credit=3;
                break;
            case 4:
                credit=4;
                break;
            case 5:
                credit=5;
                break;
            default:
                credit=0;
                break;
        }
        switch (b)
        {
            case 1:
                grade=5;
                break;
            case 2:
                grade=5;
                break;
            case 3:
                grade =4.5;
                break;
            case 4:
                grade=4;
                break;
            case 5:
                grade=3.5;;
                break;
            case 6:
                grade=3;
                break;
            case 7:
                grade=2.5;
                break;
            case 8:
                grade=2;
                break;
            case 9:
                grade=1.5;
                break;
            default:
                grade=0;
                break;
        }
        value=grade*credit;

        return value;

    }
}