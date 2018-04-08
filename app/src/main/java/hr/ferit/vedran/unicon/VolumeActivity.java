package hr.ferit.vedran.unicon;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.Locale;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class VolumeActivity extends AppCompatActivity {

    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvSubTitle) TextView tvSubTitle;
    @BindView(R.id.fabConvert) FloatingActionButton fabConvert;
    @BindView(R.id.evInput) EditText evInput;
    @BindView(R.id.spInput) Spinner spInput;
    @BindView(R.id.spOutput) Spinner spOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        
        ButterKnife.bind(this);

        tvTitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Kaleidos.ttf"));
        tvSubTitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Novecento.otf"));
        spOutput.setSelection(1);
    }

    @OnClick(R.id.fabConvert)
    public void showResult(){
        Intent result = new Intent(this, ResultActivity.class);
        result.putExtra("Input",evInput.getText().toString());
        result.putExtra("UnitIn",spInput.getSelectedItem().toString());
        result.putExtra("Output",convertLen());
        result.putExtra("UnitOut",spOutput.getSelectedItem().toString());
        startActivity(result);
    }

    private String convertLen(){
        Double valueIn = Double.parseDouble(evInput.getText().toString());
        Double valueOut;
        Double factorIn = 1.0;
        Double factorOut = 1.0;
        String unitIn = spInput.getSelectedItem().toString();
        String unitOut = spOutput.getSelectedItem().toString();
        Double[] VolumeFactors = {1.0, 1000.0, 10.0, 0.2199692};
        String [] VolumeUnits = getResources().getStringArray(R.array.VolumeUnits);

        for(int i = 0; i < VolumeUnits.length; i++){
            if(unitIn.equals(VolumeUnits[i])) factorIn = VolumeFactors[i];
        }
        for(int i = 0; i < VolumeUnits.length; i++){
            if(unitOut.equals(VolumeUnits[i])) factorOut = VolumeFactors[i];
        }
        valueOut = valueIn*(factorOut/factorIn);
        return (String.format(Locale.getDefault(),"%.3f",valueOut));
    }
}
