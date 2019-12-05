package com.example.abhinavc0761494_mt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Spinner spinner;
    EditText rentText;
    EditText amount;
    EditText totalAmount;
    SeekBar seekBar;
    TextView textView;
    RadioButton r1;
    RadioButton r2;
    RadioButton r3;
    RadioGroup rg;
    CheckBox c1;
    CheckBox c2;
    CheckBox c3;
    Button btn;
    double addedPrice;
    double addedamount;
    double amount1;
    double price;
    double extradays;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spinner);
        rentText = findViewById(R.id.rentText);
        seekBar = findViewById(R.id.seekBar);
        r1 = findViewById(R.id.radioButton1);
        r2 = findViewById(R.id.radioButton2);
        r3 = findViewById(R.id.radioButton3);
        rg = findViewById(R.id.radioGroup);
        c1 = findViewById(R.id.checkBox1);
        c2 = findViewById(R.id.checkBox2);
        c3 = findViewById(R.id.checkBox3);
        amount = findViewById(R.id.amountText);
        totalAmount = findViewById(R.id.totalAmount);
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);


      //  amount.addTextChangedListener(textWatcher);






        rentText.setKeyListener(null);
        amount.setKeyListener(null);
        totalAmount.setKeyListener(null);




        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                String text = spinner.getSelectedItem().toString();

                switch (text){

                    case "BMW":
                        rentText.setText(String.valueOf("100"));
                        break;
                    case "Audi":
                        rentText.setText(String.valueOf("125"));
                        break;
                    case "Mercedes":
                        rentText.setText(String.valueOf("150"));
                        break;
                    case "Toyota":
                        rentText.setText(String.valueOf("75"));
                        break;
                    case "Nissan":
                        rentText.setText(String.valueOf("80"));
                        break;
                    case "Honda":
                        rentText.setText(String.valueOf("77"));
                        break;
                    case "VW":
                        rentText.setText(String.valueOf("90"));
                        break;
                    case "Cadillac":
                        rentText.setText(String.valueOf("95"));
                        break;
                    case "Please Choose a car":
                        rentText.setText(String.valueOf("Daily Rent"));


                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                @Override
                public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                   textView.setText(String.valueOf(progress));

                }

                @Override
                public void onStartTrackingTouch(SeekBar seekBar) {

                }

                @Override
                public void onStopTrackingTouch(SeekBar seekBar) {

                }
            });




            btn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {





                    double tax = 0.13;

                    extradays = Integer.valueOf(textView.getText().toString());
                    price = Integer.valueOf(rentText.getText().toString());
                    amount1 = price*extradays;
                    double amount2 = addedPrice;
                    double amount3 = addedamount;
                    double amount4 = amount1*tax;
                    double finalamount = amount1+amount2+amount3;
                    double totalamount1 = amount1+amount2+amount3+amount4;

                   // System.out.println(amount1);
                    System.out.println(amount2);
                    System.out.println(amount3);
                    //System.out.println(amount4);



                    amount.setText(String.valueOf(finalamount));

                    totalAmount.setText(String.valueOf(totalamount1));




                    if(r1.isChecked()){

                        addedPrice = 5;

                    }
                    else if(r2.isChecked()){

                        addedPrice = 0;

                    }
                    else if (r3.isChecked()){

                        addedPrice = -10;

                    }

                    if (c1.isChecked()){

                        addedamount = 5;

                    }
                    if (c2.isChecked()){

                        addedamount = 7;

                    }
                    if (c3.isChecked()){

                        addedamount = 10;

                    }


                    if(c1.isChecked()&&c2.isChecked()){

                        addedamount = 12;

                    }


                    if(c1.isChecked()&&c3.isChecked()){
                        addedamount = 15;
                    }
                    if(c1.isChecked()&&c2.isChecked()&&c3.isChecked()){

                        addedamount = 22;
                    }


                    Intent intent = new Intent(MainActivity.this , RecActivity.class);

                      intent.putExtra("car" , spinner.getSelectedItem().toString());
                      intent.putExtra("rent", rentText.getText().toString());
                      intent.putExtra("days", textView.getText().toString());
                      intent.putExtra("age",r1.getText().toString());
                    intent.putExtra("age",r2.getText().toString());
                    intent.putExtra("age",r3.getText().toString());
                    intent.putExtra("amount" ,amount.getText().toString());
                    intent.putExtra("totalAmount" , totalAmount.getText().toString());

                        startActivity(intent);





                }
            });


    }

/*                TextWatcher textWatcher = new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {



                    if(rentText.getText().toString().isEmpty()){
                        double tax = 0.13;

                        double extradays = Integer.valueOf(textView.getText().toString());
                        double price = Integer.valueOf(rentText.getText().toString());

                        amount1 = price*extradays;
                        double amount2 = addedPrice;
                        double amount3 = addedamount;
                        double amount4 = amount1*tax;
                        double finalamount = amount1+amount2+amount3+amount4;

                        System.out.println(amount1);
                        System.out.println(amount2);
                        System.out.println(amount3);
                        System.out.println(amount4);



                        amount.setText(String.valueOf(finalamount));






                        if(r1.isChecked()){

                            addedPrice = 5;

                        }
                        else if(r2.isChecked()){

                            addedPrice = 0;

                        }
                        else if (r3.isChecked()){

                            addedPrice = -10;

                        }

                        if (c1.isChecked()){

                            addedamount = 5;

                        }
                        if (c2.isChecked()){

                            addedamount = 5;

                        }
                        if (c3.isChecked()){

                            addedamount = 5;

                        }


                        if(c1.isChecked()&&c2.isChecked()){

                            addedamount = 12;

                        }

                        if(c1.isChecked()&&c2.isChecked()&&c3.isChecked()){

                            addedamount = 22;
                        }

                        if(c1.isChecked()&&c3.isChecked()){
                            addedamount = 15;
                        }

                    }



                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                };*/


}
