package cn.icezers.appshop.FunctionPage.Search;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import cn.icezers.appshop.FunctionPage.HomePage.HomeActivity;
import cn.icezers.appshop.R;

/**
 * Created by popze on 2016/2/28.
 */
public class SearchFragment extends Fragment {

    View view;

    float downY;

    float ViewY;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_fragment, container, false);
        ViewY = view.getY();
        ((HomeActivity) getActivity()).setOntouch(ontouch);
        return view;
    }


    private void moveView(float distance) {
        if (distance < 0) return;
        view.setY(ViewY + distance);
    }

    HomeActivity.MyOntouch ontouch = new HomeActivity.MyOntouch() {
        @Override
        public void ontouch(MotionEvent event) {
            switch (event.getAction()) {
                case MotionEvent.ACTION_DOWN:
                    downY = event.getY();
                    break;

                case MotionEvent.ACTION_MOVE:
                    Log.d("debug", "Y-->" + event.getY());
                    moveView(event.getY() - downY);
                    break;
                case MotionEvent.ACTION_CANCEL:
                case MotionEvent.ACTION_UP:
                    MoveFinish();
                    break;
            }
        }
    };

    private void MoveFinish() {
        if (view.getY() < view.getHeight() / 2) {
            view.setY(ViewY);
        } else {
            getActivity().onBackPressed();
        }
    }
}
