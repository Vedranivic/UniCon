package hr.ferit.vedran.unicon;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class VolumeActivity extends AppCompatActivity {

    @BindView(R.id.tvTitle)
    TextView tvTitle;
    @BindView(R.id.tvSubTitle) TextView tvSubTitle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volume);
        
        ButterKnife.bind(this);

        tvTitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Kaleidos.ttf"));
        tvSubTitle.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/Novecento.otf"));
    }
}
