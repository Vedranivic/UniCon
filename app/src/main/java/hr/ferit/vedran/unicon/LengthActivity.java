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

public class LengthActivity extends AppCompatActivity {

    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvSubTitle) TextView tvSubTitle;
    @BindView(R.id.fabConvert) FloatingActionButton fabConvert;
    @BindView(R.id.evInput) EditText evInput;
    @BindView(R.id.spInput) Spinner spInput;
    @BindView(R.id.spOutput) Spinner spOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        ButterKnife.bind(this);

        //mijenjanje fonta za textviewe
        tvTitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Kaleidos.ttf"));
        tvSubTitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Novecento.otf"));
        //postavljanje defaultnog izlaznog unita spinnera na drugi odabir
        spOutput.setSelection(1);

    }

    //klik na FAButton - ubacuju se podaci kao extras i pokreće result activity
    @OnClick (R.id.fabConvert)
    public void showResult(){
        //provjera postoji li unos vrijednosti
        if (!evInput.getText().toString().equals("")){
            Intent result = new Intent(this, ResultActivity.class);
            result.putExtra("Input",evInput.getText().toString());
            result.putExtra("UnitIn",spInput.getSelectedItem().toString());
            //poziva se funkcija koja obavalja racunanje i konverziju
            result.putExtra("Output",convertLen());
            result.putExtra("UnitOut",spOutput.getSelectedItem().toString());
            startActivity(result);
        }
        //ispis poruke o potrebnom unosu
        else Toast.makeText(getApplicationContext(),"Please enter a value!", Toast.LENGTH_LONG).show();
    }

    //funkcija konverzije (duljine)
    /*na osnovu ulazne odabrane jedinice (s prvog spinnera) i izlazne odabrane jedinice (s drugog)
      odredjuju se njihovi vrijednosni faktori iz poredanog niza faktora koji je u skladu s nizom
      stringova jedinica. Na osnovu dobivenih faktora i ulazne vrijednosti računa se izlazna
      vrijednost */
    private String convertLen(){
        Double valueIn = Double.parseDouble(evInput.getText().toString());
        Double valueOut;
        Double factorIn = 1.0;
        Double factorOut = 1.0;
        String unitIn = spInput.getSelectedItem().toString();
        String unitOut = spOutput.getSelectedItem().toString();
        Double[] LengthFactors = {1000.0, 39370.07874, 1.0, 100000.0, 3280.839895};
        String [] LengthUnits = getResources().getStringArray(R.array.LengthUnits);

        for(int i = 0; i < LengthUnits.length; i++){
            if(unitIn.equals(LengthUnits[i])) factorIn = LengthFactors[i];
        }
        for(int i = 0; i < LengthUnits.length; i++){
            if(unitOut.equals(LengthUnits[i])) factorOut = LengthFactors[i];
        }
        valueOut = valueIn*(factorOut/factorIn);
        return (String.format(Locale.getDefault(),"%.3f",valueOut));
    }
}
