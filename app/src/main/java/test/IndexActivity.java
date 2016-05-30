package test;

import android.view.View;
import android.widget.ImageView;

import com.cysion.tdframework.IUrl;
import com.cysion.tdframework.R;
import com.cysion.tdframework.base.TBaseActivity;
import com.cysion.tdframework.base.Td;

/**
 * The type Index activity.
 */
public class IndexActivity extends TBaseActivity implements View.OnClickListener {


    private ImageView mImgFirst;
    private ImageView mImgSec;
    private ImageView mImgThird;

    @Override
    protected void initView() {
        setContentView(R.layout.activity_index);
        mImgFirst = (ImageView) findViewById(R.id.img_first);
        mImgSec = (ImageView) findViewById(R.id.img_second);
        mImgThird = (ImageView) findViewById(R.id.img_three);

    }

    @Override
    protected void loadData() {
    }

    @Override
    protected void setListener() {
        mImgFirst.setOnClickListener(this);
        mImgSec.setOnClickListener(this);
        mImgThird.setOnClickListener(this);

    }

    @Override
    protected void getData() {
        Td.getImgExecutor().init(this).load(IUrl.P1).placeholder(R.mipmap.p9).into(mImgFirst);
        Td.getImgExecutor().init(this).load(IUrl.P2).placeholder(R.mipmap.p9).into(mImgSec);
        Td.getImgExecutor().init(this).load(IUrl.P3).placeholder(R.mipmap.p9).animate(R.anim.anim_index_eg).into(mImgThird);

    }

    @Override
    protected void tracePage() {

    }

    @Override
    public void onClick(View v) {
        int viewId = v.getId();
        switch (viewId) {
            case R.id.img_first:
                Td.getImgExecutor().init(this).load(IUrl.P4).animate(R.anim.anim_index_eg).into(mImgFirst);
                break;
            case R.id.img_second:
                Td.getImgExecutor().init(this).load(IUrl.P5).animate(R.anim.anim_index_eg).into(mImgSec);
                break;
            case R.id.img_three:
                Td.getImgExecutor().clearCache(getApplicationContext());
                Td.getImgExecutor().clearDiskCache(getApplicationContext());

            default:
                break;
        }
    }
}
