package hr.ferit.vedran.unicon;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TemperatureActivity extends AppCompatActivity {

    //sve analogno LengthActivityju osim funkcije konverzije
    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvSubTitle) TextView tvSubTitle;
    @BindView(R.id.fabConvert) FloatingActionButton fabConvert;
    @BindView(R.id.evInput) EditText evInput;
    @BindView(R.id.spInput) Spinner spInput;
    @BindView(R.id.spOutput) Spinner spOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        ButterKnife.bind(this);

        tvTitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Kaleidos.ttf"));
        tvSubTitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Novecento.otf"));
        spOutput.setSelection(1);
    }

    @OnClick(R.id.fabConvert)
    public void showResult(){
        if (!evInput.getText().toString().equals("")){
            Intent result = new Intent(this, ResultActivity.class);
            result.putExtra("Input",evInput.getText().toString());
            result.putExtra("UnitIn",spInput.getSelectedItem().toString());
            result.putExtra("Output",convertLen());
            result.putExtra("UnitOut",spOutput.getSelectedItem().toString());
            startActivity(result);
        }
        else Toast.makeText(getApplicationContext(),"Please enter a value!", Toast.LENGTH_LONG).show();
    }

    /* funkcija konverzije je malo drugačija - ponajprije se ulazna jedinica pretvara u stupnjeve
       Celzijuse te zatim u traženu jedinicu. Navedeno se postiže određivanjem ofseta izmedju
       jedinica te koeficijenta (faktora) multiplikacije na temelju odabranih jedinica i nizova
       ofseta, faktora i stringova jedinica koji su uskladjeni
     */
    private String convertLen(){
        Double valueIn = Double.parseDouble(evInput.getText().toString());
        Double valueOut,valueCelsius;
        Double offsetIn = 0.0;
        Double offsetOut = 0.0;
        Double factorIn = 1.0;
        Double factorOut = 1.0;
        String unitIn = spInput.getSelectedItem().toString();
        String unitOut = spOutput.getSelectedItem().toString();
        Double[] TemperatureOffsets = {0.0, 32.0, 273.15};
        Double[] TemperatureFactors = {1.0, 1.8, 1.0};
        String [] TemperatureUnits = getResources().getStringArray(R.array.TemperatureUnits);

        for(int i = 0; i < TemperatureUnits.length; i++){
            if(unitIn.equals(TemperatureUnits[i])){
                offsetIn = TemperatureOffsets[i];
                factorIn = TemperatureFactors[i];
            }
        }
        valueCelsius = (valueIn - offsetIn)/factorIn;

        for(int i = 0; i < TemperatureUnits.length; i++){
            if(unitOut.equals(TemperatureUnits[i])){
                offsetOut = TemperatureOffsets[i];
                factorOut = TemperatureFactors[i];
            }
        }
        valueOut = valueCelsius*factorOut + offsetOut;
        return (String.format(Locale.getDefault(),"%.2f",valueOut));
    }
}
