package fish.cool.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by ch on 2017/11/27.
 */

public class PageMainAdapter extends PagerAdapter {
    private String[] imgUrls;

    public PageMainAdapter(String[] imgUrls) {
        this.imgUrls = imgUrls;
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;//int的取值范围 ：-21亿---+21亿
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object; //固定写法
    }
     //  下面的两个方法destroyItem和instantiateItem，需要手动调用，并删除里面的super.方法

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);   //固定写法
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
      position=position%imgUrls.length;
        ImageView iv=new ImageView(container.getContext());//创建view
        Glide.with(container).load(imgUrls[position]).into(iv);//填充数据
        iv.setScaleType(ImageView.ScaleType.CENTER_CROP);//页面图片填充
        //固定写法
        container.addView(iv);
        return iv;
    }
}


