package ahea.blindinterview.android.seek.detail;

import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import ahea.blindinterview.android.R;

public class PreviewPageAdapter extends PagerAdapter {

    LayoutInflater inflater;

    public PreviewPageAdapter(LayoutInflater inflater) {
        // TODO Auto-generated constructor stub

        //전달 받은 LayoutInflater를 멤버변수로 전달
        this.inflater=inflater;
    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }


    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        View view=null;

        //새로운 View 객체를 Layoutinflater를 이용해서 생성
        view= inflater.inflate(R.layout.seek_detail_viewpager, null);

        //만들어진 View안에 있는 ImageView 객체 참조
        //위에서 inflated 되어 만들어진 view로부터 findViewById()를 해야 하는 것에 주의.
        ImageView img= (ImageView)view.findViewById(R.id.seek_detail_viewpager_imageview);

        //ImageView에 현재 position 번째에 해당하는 이미지를 보여주기 위한 작업
        //현재 position에 해당하는 이미지를 setting
        if(position==0) {
            img.setImageResource(R.drawable.coupang_title1);
        } else {
            img.setImageResource(R.drawable.coupang_title2);
        }


        //ViewPager에 만들어 낸 View 추가
        container.addView(view);

        //Image가 세팅된 View를 리턴
        return view;
    }
}
