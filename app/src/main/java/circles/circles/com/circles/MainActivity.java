package circles.circles.com.circles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import circles.circles.com.circles.Presenter.MainPresenter;
import circles.circles.com.circles.mvp.base.BaseActivity;

public class MainActivity extends BaseActivity<MainPresenter.MainUI, MainPresenter> implements MainPresenter.MainUI {


    @Override
    protected MainPresenter.MainUI createUI() {
        return this;
    }

    @Override
    protected MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    protected void initViews() {
        //这里可以做view的初始化

//        这里控件又一个点击方法  改变文字的方法   建议采用rxview    这里没有采用
        getUI().gettvmvp().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //在这里将业务逻辑 和网络请求放在了presenter中
                getPresenter().tvedit();

            }
        });

    }

    @Override
    public int getContentLayout() {
        return R.layout.activity_main;
    }

    @Override
    public TextView gettvmvp() {
        return getUI().finder().find(R.id.tv_mvp);
    }

    @Override
    public void setinfo(String userinfo) {
        //将网络的数据 进行页面布局的更新
        getUI().finder().textView(R.id.tv_userinfo).setText(userinfo);
    }
}
