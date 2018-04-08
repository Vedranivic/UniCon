package hr.ferit.vedran.unicon;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.ivLen)
    ImageView ivLen;
    @BindView(R.id.ivTemp)
    ImageView ivTemp;
    @BindView(R.id.ivWeight)
    ImageView ivWeight;
    @BindView(R.id.ivVol)
    ImageView ivVol;

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

    @OnClick({R.id.ivLen, R.id.ivTemp, R.id.ivWeight, R.id.ivVol})
    public void goToConversion(ImageView iv) {
        Intent conversion = new Intent();
        switch (iv.getId()) {
            case R.id.ivLen:
                conversion.setClass(this, LengthActivity.class);
                startActivity(conversion);
                break;
            case R.id.ivTemp:
                conversion.setClass(this, TemperatureActivity.class);
                startActivity(conversion);
                break;
            case R.id.ivWeight:
                conversion.setClass(this, WeightActivity.class);
                startActivity(conversion);
                break;
            case R.id.ivVol:
                conversion.setClass(this, VolumeActivity.class);
                startActivity(conversion);
                break;
        }
    }

}
