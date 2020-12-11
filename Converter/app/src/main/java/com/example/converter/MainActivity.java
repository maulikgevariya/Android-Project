package com.example.converter;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked{

    Spinner spSource, spDestination;
    EditText etFirst;
    TextView tvsecond;
    Button btnconvert,btnReset;
    int numberOfConverter;
    String source,destination;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spSource = findViewById(R.id.spSource);
        spDestination = findViewById(R.id.spDestination);
        etFirst = findViewById(R.id.etFirst);
        tvsecond = findViewById(R.id.tvSecond);
        btnconvert=findViewById(R.id.btnConvert);
        btnReset=findViewById(R.id.btnReset);


        if (findViewById(R.id.layout_portrait) != null) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFrag))
                    .hide(manager.findFragmentById(R.id.detailFrag))
                    .commit();
        }
        if (findViewById(R.id.layout_land) != null) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .show(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .commit();
        }

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                etFirst.setText(null);
                tvsecond.setText(null);
            }
        });

        btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(etFirst.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Enter valid number", Toast.LENGTH_SHORT).show();
                }
                else {
                    switch (numberOfConverter){
                        case 0:{
                            UnitConvversion convert =
                                    new UnitConvversion(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                            break;
                        }
                        case 1:{
                            CurrencyConverter convert =new CurrencyConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                            break;
                        }
                        case 2:{
                            TemeratureConverter convert =
                                    new TemeratureConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                            break;
                        }
                        case 3:{
                            SpeedConverter convert =
                                    new SpeedConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                            break;
                        }
                        case 4:{
                            AreaConverter convert =
                                    new AreaConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                            break;
                        }
                        default:{
                            break;
                        }
                    }
                }

            }
        });
    }


    @Override
    public void onItemClicked(int i) {

        if (findViewById(R.id.layout_portrait) != null) {
            FragmentManager manager = this.getSupportFragmentManager();
            manager.beginTransaction()
                    .hide(manager.findFragmentById(R.id.listFrag))
                    .show(manager.findFragmentById(R.id.detailFrag))
                    .addToBackStack(null)
                    .commit();
        }
        switch (i){
            case 0 :{
                numberOfConverter=0;
                String [] unit={"meter","centimeter","feet","inch","kilometer","miles","millimeter","yards"};
                ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,unit);
                unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSource.setAdapter(unitAdapter);
                spDestination.setAdapter(unitAdapter);
                spSource.setSelection(0);
                spDestination.setSelection(1);
                source="meter";
                destination="centimeter";

                spSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        source=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            UnitConvversion convert =
                                    new UnitConvversion(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                spDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        destination=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            UnitConvversion convert =
                                    new UnitConvversion(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            }
            case 1:{
                numberOfConverter=1;
                String [] unit={"US_Doller","Indian_Rupee","British_Pound","Australian_Doller","Canadian_Doller","Singapore_Doller"};
                ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,unit);
                unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSource.setAdapter(unitAdapter);
                spDestination.setAdapter(unitAdapter);
                spSource.setSelection(0);
                spDestination.setSelection(1);
                source="US_Doller";
                destination="Indian_Rupee";

                spSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        source=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            CurrencyConverter convert =new CurrencyConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                spDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        destination=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            CurrencyConverter convert =new CurrencyConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;



            }
            case 2:{
                numberOfConverter=2;
                String [] unit={"celsius","fahrenheit","kelvin"};
                ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,unit);
                unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSource.setAdapter(unitAdapter);
                spDestination.setAdapter(unitAdapter);
                spSource.setSelection(0);
                spDestination.setSelection(1);
                source="celsius";
                destination="fahhrenheit";

                spSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        source=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            TemeratureConverter convert =
                                    new TemeratureConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        destination=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            TemeratureConverter convert =
                                    new TemeratureConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            }
            case 3:{
                numberOfConverter=3;
                String [] unit={"Meters/Sec","Km/hour","Mies/hour","Feet/Sec"};
                ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,unit);
                unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSource.setAdapter(unitAdapter);
                spDestination.setAdapter(unitAdapter);
                spSource.setSelection(0);
                spDestination.setSelection(1);
                source="Meters/Sec";
                destination="Km/hour";

                spSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        source=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            SpeedConverter convert =
                                    new SpeedConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        destination=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            SpeedConverter convert =
                                    new SpeedConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            }
            case 4:{
                numberOfConverter=4;
                String [] unit={"Square Km","Hectare","Square meter","Sqaure mile","Acre","Square yard","Square foot","Square inch"};
                ArrayAdapter<String> unitAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,unit);
                unitAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spSource.setAdapter(unitAdapter);
                spDestination.setAdapter(unitAdapter);
                spSource.setSelection(0);
                spDestination.setSelection(1);
                source="Square Km";
                destination="Hectare";

                spSource.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        source=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            AreaConverter convert =
                                    new AreaConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });

                spDestination.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                        destination=parent.getItemAtPosition(position).toString();
                        if(!etFirst.getText().toString().isEmpty()){
                            AreaConverter convert =
                                    new AreaConverter(source,destination,Double.parseDouble(etFirst.getText().toString()));
                            tvsecond.setText(Double.toString(convert.conversion()));
                        }
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }
                });
                break;
            }
            default:{
                break;
            }
        }
    }
}
