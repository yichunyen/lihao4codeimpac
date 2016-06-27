package angelhacktaipei.project.yen.lihao;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements SelectGenderFragment.OnSelectGenderListener, SelectLanguageFragment.OnSelectLanguageListener, SelectLivingAreaFragment.OnSelectLivingAreaListener
        , SelectReceiverGenderFragment.OnSelectReceiverGenderListener, SelectTopicFragment.OnSelectTopicListener,
        ChatFragment.OnCallingEndListener, RatingFragment.OnRateMemberListener {
    private final int SELECT_GENDER = 0;
    private final int SELECT_LANGUAGE = 1;
    private final int SELECT_LIVING_AREA = 2;
    private final int SELECT_RECEIVER_GENDER = 3;
    private final int SELECT_TOPIC = 4;
    private final int CHAT = 5;
    private final int RATING = 6;
    private final int HISTORY = 7;
    private ViewPager viewPager;
    private List<Fragment> fragmentList;
    private ViewPagerAdapter viewPagerAdapter;
    /* Fragments */
    private SelectGenderFragment selectGenderFragment;
    private SelectLanguageFragment selectLanguageFragment;
    private SelectLivingAreaFragment selectLivingAreaFragment;
    private SelectReceiverGenderFragment selectReceiverGenderFragment;
    private SelectTopicFragment selectTopicFragment;
    private ChatFragment chatFragment;
    private RatingFragment ratingFragment;
    private ConversationHistoryFragment conversationHistoryFragment;
    /* UI */
    private ImageView imvAudio;
    private MediaPlayer mediaPlayer;
    /* Sound Pool */
    private SoundPool soundPool;
    private int soundID4SelectYourGender;
    private int soundID4SelectYourLanguage;
    private int soundID4SelectChatGender;
    private int soundID4ChooseLivingArea;
    private boolean loaded = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mediaPlayer = new MediaPlayer();
        viewPager = (ViewPager) findViewById(R.id.activity_main_vp);

        /* Init sound pool */
        soundPool = new SoundPool(10, AudioManager.STREAM_MUSIC, 0);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId,
                                       int status) {
                loaded = true;
            }
        });
        soundID4SelectYourGender = soundPool.load(this, R.raw.audio_your_gender, 1);
        soundID4SelectYourLanguage = soundPool.load(this, R.raw.audio_language, 1);
        soundID4SelectChatGender = soundPool.load(this, R.raw.audio_chat_gender, 1);
        soundID4ChooseLivingArea = soundPool.load(this, R.raw.audio_map, 1);

        imvAudio = (ImageView) findViewById(R.id.activity_main_imv_voice);
        imvAudio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playAudio(viewPager.getCurrentItem());
            }
        });
        initFragments();
//        btnSend = (Button) findViewById(R.id.activity_main_send);
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                mWebSocketClient.send("Hello, Server. This is the request from Android device.");
//            }
//        });
    }

    private void initFragments() {
        selectGenderFragment = new SelectGenderFragment();
        selectLanguageFragment = new SelectLanguageFragment();
        selectLivingAreaFragment = new SelectLivingAreaFragment();
        selectReceiverGenderFragment = new SelectReceiverGenderFragment();
        selectTopicFragment = new SelectTopicFragment();
        chatFragment = new ChatFragment();
        ratingFragment = new RatingFragment();
        conversationHistoryFragment = new ConversationHistoryFragment();

        fragmentList = new ArrayList<>();
        fragmentList.add(selectGenderFragment);
        fragmentList.add(selectLanguageFragment);
        fragmentList.add(selectLivingAreaFragment);
        fragmentList.add(selectReceiverGenderFragment);
        fragmentList.add(selectTopicFragment);
        fragmentList.add(chatFragment);
        fragmentList.add(ratingFragment);
        fragmentList.add(conversationHistoryFragment);
        viewPagerAdapter = new ViewPagerAdapter(fragmentList, getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
    }

    /**
     * Click lister from SelectGenderFragment
     */
    @Override
    public void click() {
        viewPager.setCurrentItem(SELECT_LANGUAGE);
    }

    public void onBackPressed() {
        if (viewPager.getCurrentItem() == SELECT_TOPIC) {
            if (selectTopicFragment != null) {
                selectTopicFragment.hideTopicList();
            }
        } else {
            super.onBackPressed();
            finish();
        }
    }

    @Override
    public void onClickLanguage() {
        viewPager.setCurrentItem(SELECT_LIVING_AREA);
    }

    @Override
    public void onClickLivingArea() {
        viewPager.setCurrentItem(SELECT_RECEIVER_GENDER);
    }

    /**
     * Click listener from SelectReceiverGenderFragment
     */
    @Override
    public void onClickReceiverGender() {
        viewPager.setCurrentItem(SELECT_TOPIC);
    }

    /**
     * Click listener from SelectTopicFragment
     */
    @Override
    public void onClickChat() {
        //Go to answer phone fragment
        viewPager.setCurrentItem(CHAT);
    }

    @Override
    public void onEnd() {
        viewPager.setCurrentItem(RATING);
    }

    /**
     * Click listener from RatingFragment to rate this member.
     */
    @Override
    public void onSatisfy() {
        viewPager.setCurrentItem(HISTORY);
    }

    /**
     * Click listener from RatingFragment to rate this member.
     */
    @Override
    public void onUnSatisfy() {
        viewPager.setCurrentItem(HISTORY);
    }

//    private void connectWebSocket() {
//        URI uri;
//        try {
//            uri = new URI("ws://10.187.2.1:8080");
//        } catch (URISyntaxException e) {
////            e.printStackTrace();
//            return;
//        }
//
//        mWebSocketClient = new WebSocketClient(uri) {
//            @Override
//            public void onOpen(ServerHandshake serverHandshake) {
//                Log.i("Websocket", "Opened");
//                mWebSocketClient.send("Hello from " + getDeviceUUID());
//            }
//
//            @Override
//            public void onMessage(String s) {
//                final String message = s;
//                runOnUiThread(new Runnable() {
//                    @Override
//                    public void run() {
//                        Log.i("onMessage", message);
//                    }
//                });
//            }
//
//            @Override
//            public void onClose(int i, String s, boolean b) {
//                Log.i("Websocket", "Closed " + s);
//            }
//
//            @Override
//            public void onError(Exception e) {
//                Log.i("Websocket", "Error " + e.getMessage());
//            }
//        };
//        mWebSocketClient.connect();
//    }
//
//    public String getDeviceUUID() {
//        return Settings.Secure.getString(getContentResolver(),
//                Settings.Secure.ANDROID_ID);
//    }

    /**
     * Play audio via current page number.
     */
    private void playAudio(int page) {
        AudioManager audioManager = (AudioManager) getSystemService(AUDIO_SERVICE);
        float actualVolume = (float) audioManager
                .getStreamVolume(AudioManager.STREAM_MUSIC);
        float maxVolume = (float) audioManager
                .getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        float volume = actualVolume / maxVolume;
        if (loaded) {
            switch (page) {
                case SELECT_GENDER:
                    soundPool.play(soundID4SelectYourGender, volume, volume, 1, 0, 1f);
                    break;
                case SELECT_LANGUAGE:
                    soundPool.play(soundID4SelectYourLanguage, volume, volume, 1, 0, 1f);
                    break;
                case SELECT_RECEIVER_GENDER:
                    soundPool.play(soundID4SelectChatGender, volume, volume, 1, 0, 1f);
                    break;
                case SELECT_LIVING_AREA:
                    soundPool.play(soundID4ChooseLivingArea, volume, volume, 1, 0, 1f);
                    break;
            }
        }
    }
}
