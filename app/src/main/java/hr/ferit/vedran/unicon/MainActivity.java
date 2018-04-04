package hr.ferit.vedran.unicon;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.tvLen)
    TextView tvLen;
    @BindView(R.id.tvTemp)
    TextView tvTemp;
    @BindView(R.id.tvWeight)
    TextView tvWeight;
    @BindView(R.id.tvVol)
    TextView tvVol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        tvLen.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Kaleidos.ttf"));
        tvTemp.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Kaleidos.ttf"));
        tvWeight.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Kaleidos.ttf"));
        tvVol.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/Kaleidos.ttf"));
    }
}
