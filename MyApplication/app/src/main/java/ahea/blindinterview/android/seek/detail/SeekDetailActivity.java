package ahea.blindinterview.android.seek.detail;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import ahea.blindinterview.android.R;
import ahea.blindinterview.android.seek.main.SeekMainActivity;

public class SeekDetailActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seek_detail);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("쿠팡맨 채용");


        viewPager = (ViewPager)findViewById(R.id.previewPager);
        PreviewPageAdapter adapter = new PreviewPageAdapter(getLayoutInflater());
        viewPager.setAdapter(adapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // inflater함수를 이용해서 menu 리소스를 menu로 변환.
        getMenuInflater().inflate(R.menu.seek_detail, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch(item.getItemId()){
            case android.R.id.home:
                Intent intent = new Intent(this, SeekMainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent);
                this.finish();
                return true;
            case R.id.favoriteButton:
                item.setIcon(android.R.drawable.star_big_on);
                return true;
            case R.id.offerButton:
                Context context = getApplicationContext();
                CharSequence text = "지원이 완료되었습니다";
                int duration = Toast.LENGTH_LONG;
                Toast toast = Toast.makeText(context, text, duration);
                toast.setGravity(Gravity.TOP, 0, 40);
                toast.show();
                return true;
        }


        return super.onOptionsItemSelected(item);
    }
}
