package com.example.currency_converter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText enterAmount;
    TextView convertedAmount;
    Spinner convertFrom,convertTo;
    Button btnconvert;
    CountryItem countryItem;
    CountryItem countryItemTo;
    String clickedCountry,clickedCountryTo;
    private ArrayList<CountryItem> countryList;
    private CountryAdapter countryAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        iniListCountry();

        enterAmount=findViewById(R.id.amount_edit_txt);
        convertedAmount=findViewById(R.id.convert_amount);
        btnconvert=findViewById(R.id.btn_converter);

        convertFrom=findViewById(R.id.spinner_countries);
        convertTo=findViewById(R.id.spinner_countries_to);

        countryAdapter=new CountryAdapter(MainActivity.this,countryList);
        convertFrom.setAdapter(countryAdapter);
        convertTo.setAdapter(countryAdapter);

        convertFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countryItem=(CountryItem) adapterView.getItemAtPosition(i);
                clickedCountry=countryItem.getCountryName();
                Toast.makeText(MainActivity.this,clickedCountry + "selected",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        convertTo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                countryItemTo=(CountryItem) adapterView.getItemAtPosition(i);
                clickedCountryTo=countryItemTo.getCountryName();
                Toast.makeText(MainActivity.this,clickedCountryTo + "selected",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Double totalConverAmount;
                    Double amount=Double.parseDouble(enterAmount.getText().toString());

                    if(clickedCountry.equals("USA") && clickedCountryTo.equals("Pakistan"))
                    {
                        totalConverAmount=amount * 170.15;
                        String tot=String.format("%.2f",totalConverAmount);
                        convertedAmount.setText(""+tot);
                    }
                    if(clickedCountry.equals("USA") && clickedCountryTo.equals("India"))
                    {
                        totalConverAmount=amount * 74.19;
                        String tot=String.format("%.2f",totalConverAmount);
                        convertedAmount.setText(""+tot);
                    }
                if(clickedCountry.equals("USA") && clickedCountryTo.equals("Vietnam"))
                {
                    totalConverAmount=amount * 22681.00;
                    String tot=String.format("%.2f",totalConverAmount);
                    convertedAmount.setText(""+tot);
                }
                if (clickedCountry.equals("India") && clickedCountryTo.equals("Pakistan"))
                {
                    totalConverAmount=amount * 2.29;
                    String tot=String.format("%.2f",totalConverAmount);
                    convertedAmount.setText(""+tot);
                }
            }
        });
    }

    private void iniListCountry() {
        countryList=new ArrayList<>();
        countryList.add(new CountryItem("Pakistan",R.drawable.pakistan));
        countryList.add(new CountryItem("India",R.drawable.india));
        countryList.add(new CountryItem("USA",R.drawable.unitedstates));
        countryList.add(new CountryItem("Vietnam",R.drawable.vietnam));

    }


}