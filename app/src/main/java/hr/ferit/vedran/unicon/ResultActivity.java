package hr.ferit.vedran.unicon;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {

    @BindView(R.id.tvTitle) TextView tvTitle;
    @BindView(R.id.tvInput) TextView tvInput;
    @BindView(R.id.tvOutput) TextView tvOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ButterKnife.bind(this);

        //postavljanje fonta tekstovima
        tvTitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Kaleidos.ttf"));
        tvInput.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Novecento.otf"));
        tvOutput.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Novecento.otf"));
        //postavljanje sadržaja ulaznih vrijednosti
        setInput();
        //postavljanje sadržaja izlaznih vrijednosti
        setOutput();
    }
    protected void setInput(){
        String input = getIntent().getStringExtra("Input");
        input += " ";
        input += getIntent().getStringExtra("UnitIn");
        tvInput.setText(input);
    }
    protected void setOutput(){
        String output = getIntent().getStringExtra("Output");
        output += " ";
        output += getIntent().getStringExtra("UnitOut");
        tvOutput.setText(output);
    }
}
