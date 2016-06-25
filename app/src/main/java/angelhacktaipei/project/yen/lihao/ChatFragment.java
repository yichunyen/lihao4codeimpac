package angelhacktaipei.project.yen.lihao;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.bumptech.glide.Glide;

/**
 * Created by Yan on 6/11/16.
 */
public class ChatFragment extends Fragment{
    private ImageView imvCalling;
    private LinearLayout llTimer;
    private OnCallingEndListener OnCallingEndListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chat, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        imvCalling = (ImageView) view.findViewById(R.id.fragment_chat_imv_calling);
        llTimer = (LinearLayout) view.findViewById(R.id.fragment_chat_ll_timer);
        Glide
                .with(getActivity())
                .load(R.drawable.calling)
                .placeholder(R.color.foreBackground)
                .into(imvCalling);
        initListener();
    }

    private void initListener(){
        imvCalling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display the timer.
                displayTimer();
            }
        });

        llTimer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnCallingEndListener.onEnd();
            }
        });
    }

    private void displayTimer() {
        imvCalling.setVisibility(View.GONE);
        llTimer.setVisibility(View.VISIBLE);
    }

    public interface OnCallingEndListener{
        void onEnd();
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            OnCallingEndListener = (OnCallingEndListener) activity;
        } catch (ClassCastException exception){
            Log.e(getActivity().getPackageName(), exception.toString());
        }
    }
}
