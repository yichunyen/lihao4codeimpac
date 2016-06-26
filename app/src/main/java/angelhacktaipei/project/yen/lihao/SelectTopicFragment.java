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
import android.widget.TextView;

/**
 * Created by Yan on 6/11/16.
 */
public class SelectTopicFragment extends Fragment {
    private TextView tvStartChat;
    private TextView tvSelectTopic;
    private LinearLayout llTop;
    private LinearLayout llCenter;
    private LinearLayout llBottom;
    private ImageView imvTopic;
    private OnSelectTopicListener OnSelectTopicListener;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.frgment_select_topic, container, false);
        initViews(view);
        return view;
    }

    private void initViews(View view){
        tvStartChat = (TextView) view.findViewById(R.id.fragment_select_topic_tv_start_chat);
        tvSelectTopic = (TextView) view.findViewById(R.id.fragment_select_topic_tv_select_topic);
        llTop = (LinearLayout) view.findViewById(R.id.fragment_select_topic_ll_topic_upper);
//        llCenter = (LinearLayout)view.findViewById(R.id.fragment_select_topic_ll_topic_center);
//        llBottom = (LinearLayout) view.findViewById(R.id.fragment_select_topic_ll_topic_bottom);
        imvTopic = (ImageView) view.findViewById(R.id.fragment_select_topic_imv);
        initListener();
    }

    private void initListener(){
//        Glide.with(this)
//                .load(R.drawable.topic)
//                .placeholder(R.color.foreBackground)
//                .into(imvTopic);
        tvStartChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSelectTopicListener.onClickChat();
            }
        });

        tvSelectTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Set invisible to text views and show the topic list.
                displayTopicList();
            }
        });

        llTop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                OnSelectTopicListener.onClickChat();
            }
        });

//        llCenter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OnSelectTopicListener.onClickChat();
//            }
//        });
//
//        llBottom.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                OnSelectTopicListener.onClickChat();
//            }
//        });
    }

    private void displayTopicList(){
        tvStartChat.setVisibility(View.GONE);
        tvSelectTopic.setVisibility(View.GONE);
        llTop.setVisibility(View.VISIBLE);
//        llCenter.setVisibility(View.VISIBLE);
//        llBottom.setVisibility(View.VISIBLE);
    }

    public void hideTopicList(){
        tvStartChat.setVisibility(View.VISIBLE);
        tvSelectTopic.setVisibility(View.VISIBLE);
        llTop.setVisibility(View.GONE);
//        llCenter.setVisibility(View.GONE);
//        llBottom.setVisibility(View.GONE);
    }

    public interface OnSelectTopicListener{
        void onClickChat();
    }

    public void onAttach(Activity activity){
        super.onAttach(activity);
        try{
            OnSelectTopicListener = (OnSelectTopicListener) activity;
        } catch (ClassCastException exception){
            Log.e(getActivity().getPackageName(), exception.toString());
        }
    }
}
