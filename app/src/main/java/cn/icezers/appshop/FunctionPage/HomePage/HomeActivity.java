package cn.icezers.appshop.FunctionPage.HomePage;

import android.content.Context;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;

import cn.icezers.appshop.BaseContent.BaseFragmentActivity;
import cn.icezers.appshop.FunctionPage.Search.SearchFragment;
import cn.icezers.appshop.R;

/**
 * Created by popze on 2016/2/27.
 */
public class HomeActivity extends BaseFragmentActivity {

    private HomeDataLayer _dataLayer;
    private HomeUILayer _uiLayer;

    private MyOntouch ontouch;

    InputMethodManager imm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTranslucentNavigation(true);
        setTranslucentStatus(true);
        setContentView(R.layout.activity_main);
        _dataLayer = new HomeDataLayer();
        _uiLayer = new HomeUILayer();

        findViewById(R.id.textview).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getSupportFragmentManager().beginTransaction()
                        .setCustomAnimations(R.anim.open_frombelow_totop, R.anim.close_fromtop_tobelow)
                        .add(R.id.viewgroup, new SearchFragment(), "search")
                        .commitAllowingStateLoss();
                findViewById(R.id.textview).setVisibility(View.GONE);
                findViewById(R.id.edittext).setVisibility(View.VISIBLE);
                findViewById(R.id.edittext).post(new Runnable() {
                    @Override
                    public void run() {
                        ((EditText) findViewById(R.id.edittext)).setFocusable(true);
                        ((EditText) findViewById(R.id.edittext)).setFocusableInTouchMode(true);
                        ((EditText) findViewById(R.id.edittext)).requestFocus();
                         imm = (InputMethodManager) HomeActivity.this.getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
                    }
                });
            }
        });
    }

    @Override
    public void onBackPressed() {
        if (findViewById(R.id.edittext).getVisibility() == View.VISIBLE) {
            findViewById(R.id.edittext).setVisibility(View.GONE);
            findViewById(R.id.textview).setVisibility(View.VISIBLE);
            getSupportFragmentManager().beginTransaction()
                    .setCustomAnimations(R.anim.open_frombelow_totop, R.anim.close_fromtop_tobelow)
                    .remove(getSupportFragmentManager().findFragmentByTag("search")).commitAllowingStateLoss();
            ontouch = null;
            imm.hideSoftInputFromWindow(findViewById(R.id.edittext).getWindowToken(), 0);
            return;
        }
        super.onBackPressed();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (ontouch != null) {
            ontouch.ontouch(event);
        }
        return super.onTouchEvent(event);
    }

    public interface MyOntouch {
        void ontouch(MotionEvent event);
    }

    public void setOntouch(MyOntouch ontouch) {
        this.ontouch = ontouch;
    }
}
