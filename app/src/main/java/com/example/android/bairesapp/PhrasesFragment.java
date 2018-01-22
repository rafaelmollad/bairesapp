package com.example.android.bairesapp;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class PhrasesFragment extends Fragment {

    private MediaPlayer mMediaPlayer;
    private AudioManager mAudioManager;


    /**
     * This listener gets triggered when the {@link MediaPlayer} has completed
     * playing the audio file.
     */
    private MediaPlayer.OnCompletionListener mCompletionListener = new MediaPlayer.OnCompletionListener() {
        @Override
        public void onCompletion(MediaPlayer mediaPlayer) {
            // Now that the sound file has finished playing, release the media player resources.
            releaseMediaPlayer();
        }
    };

    /**
     * This listener gets triggered whenever the audio focus changes
     * (i.e., we gain or lose audio focus because of another app or device).
     */
    private AudioManager.OnAudioFocusChangeListener mOnAudioFocusChangeListener = new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int focusChange) {
            if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT ||
                    focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                // The AUDIOFOCUS_LOSS_TRANSIENT case means that we've lost audio focus for a
                // short amount of time. The AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK case means that
                // our app is allowed to continue playing sound but at a lower volume. We'll treat
                // both cases the same way because our app is playing short sound files.

                // Pause playback and reset player to the start of the file. That way, we can
                // play the word from the beginning when we resume playback.
                mMediaPlayer.pause();
                mMediaPlayer.seekTo(0);
            } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                // The AUDIOFOCUS_GAIN case means we have regained focus and can resume playback.
                mMediaPlayer.start();
            } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                // The AUDIOFOCUS_LOSS case means we've lost audio focus and
                // Stop playback and clean up resources
                releaseMediaPlayer();
            }
        }
    };


    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.phrases_list_view, container, false);

        // Create and setup the {@link AudioManager} to request audio focus
        mAudioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        // Get listView reference
        final ListView listView = (ListView) rootView.findViewById(R.id.phrases_list_view);


        // Create arrayList containing objects instances from ListItemObject.java
        ArrayList<ListItemObject> arrayOfObjects = new ArrayList<ListItemObject>();

        // Populate arrayList
        arrayOfObjects.add(new ListItemObject(R.string.buenos_dias, R.string.good_morning, R.drawable.good_morning,R.raw.buenos_dias));
        arrayOfObjects.add(new ListItemObject(R.string.buenas_tardes, R.string.good_afternoon, R.drawable.good_afternoon,R.raw.buenas_tardes));
        arrayOfObjects.add(new ListItemObject(R.string.buenas_noches, R.string.good_evening, R.drawable.good_evening,R.raw.buenas_noches));
        arrayOfObjects.add(new ListItemObject(R.string.como_estas, R.string.how_are_you, R.drawable.how_are_you,R.raw.como_estas));
        arrayOfObjects.add(new ListItemObject(R.string.bien_gracias, R.string.fine_thank_you, R.drawable.fine_thank_you,R.raw.bien_gracias_y_vos));
        arrayOfObjects.add(new ListItemObject(R.string.no_entiendo, R.string.dont_understand, R.drawable.dont_understand,R.raw.no_entiendo));
        arrayOfObjects.add(new ListItemObject(R.string.perdon, R.string.sorry, R.drawable.sorry,R.raw.perdon));
        arrayOfObjects.add(new ListItemObject(R.string.adios, R.string.goodbye, R.drawable.good_bye,R.raw.adios));
        arrayOfObjects.add(new ListItemObject(R.string.muchas_gracias, R.string.thank_you_very_much, R.drawable.thank_you_very_much,R.raw.muchas_gracias));
        arrayOfObjects.add(new ListItemObject(R.string.de_nada, R.string.you_are_welcome, R.drawable.you_are_welcome,R.raw.de_nada));
        arrayOfObjects.add(new ListItemObject(R.string.mi_nombre_es, R.string.my_name_is, R.drawable.my_name_is,R.raw.me_llamo));
        arrayOfObjects.add(new ListItemObject(R.string.cuanto_cuesta, R.string.how_much_is_it, R.drawable.how_much_is_it,R.raw.cuanto_cuesta));
        arrayOfObjects.add(new ListItemObject(R.string.muy_barato, R.string.very_cheap, R.drawable.very_cheap,R.raw.muy_barato));
        arrayOfObjects.add(new ListItemObject(R.string.muy_caro, R.string.very_expensive, R.drawable.very_expensive,R.raw.es_muy_caro));
        arrayOfObjects.add(new ListItemObject(R.string.hacer_precio, R.string.lower_the_price, R.drawable.lower_the_price,R.raw.hacerme_precio));
        arrayOfObjects.add(new ListItemObject(R.string.comprar_este, R.string.buy_this_one, R.drawable.buy_this_one,R.raw.quisiera_comprar_este));
        arrayOfObjects.add(new ListItemObject(R.string.solo_estoy_mirando, R.string.looking_around, R.drawable.looking_around,R.raw.solo_estoy_mirando));
        arrayOfObjects.add(new ListItemObject(R.string.a_donde_queda, R.string.where_is, R.drawable.where_is,R.raw.a_donde_queda));
        arrayOfObjects.add(new ListItemObject(R.string.cerca, R.string.close, R.drawable.close,R.raw.queda_cerca));
        arrayOfObjects.add(new ListItemObject(R.string.lejos, R.string.far, R.drawable.far,R.raw.queda_lejos));
        arrayOfObjects.add(new ListItemObject(R.string.que_hora_es, R.string.what_time_is_it, R.drawable.what_time_is_it,R.raw.hora));
        arrayOfObjects.add(new ListItemObject(R.string.que_recomendas, R.string.what_can_you_recommend, R.drawable.que_recomendas,R.raw.que_recomendas));
        arrayOfObjects.add(new ListItemObject(R.string.llama_a_una_ambulancia, R.string.call_an_ambulance, R.drawable.ambulance,R.raw.ambulancia));
        arrayOfObjects.add(new ListItemObject(R.string.llama_al_911, R.string.call_911, R.drawable.police,R.raw.police));
        arrayOfObjects.add(new ListItemObject(R.string.a_donde_hay_un_hospital, R.string.where_is_a_hospital, R.drawable.hospital,R.raw.a_donde_hay_un_hospital));
        arrayOfObjects.add(new ListItemObject(R.string.no_me_siento_muy_bien, R.string.i_dont_feel_very_good, R.drawable.i_dont_feel_very_good,R.raw.no_me_siento_muy_bien));
        arrayOfObjects.add(new ListItemObject(R.string.encontrar_los_baños, R.string.find_the_restrooms, R.drawable.find_the_restroooms,R.raw.a_donde_quedan_los_banos));
        arrayOfObjects.add(new ListItemObject(R.string.ayuda, R.string.help, R.drawable.help,R.raw.ayuda));
        arrayOfObjects.add(new ListItemObject(R.string.me_he_perdido, R.string.im_lost, R.drawable.lost,R.raw.me_he_perdido));
        arrayOfObjects.add(new ListItemObject(R.string.hablas_ingles, R.string.do_you_speak_english, R.drawable.english,R.raw.hablas_ingles));
        arrayOfObjects.add(new ListItemObject(R.string.estoy_buscando_un_hotel, R.string.im_looking_for_a_hotel, R.drawable.hotel,R.raw.busco_un_hotel));
        arrayOfObjects.add(new ListItemObject(R.string.casa_de_cambio, R.string.wheres_an_exchange, R.drawable.exchange,R.raw.casa_de_cambio));

        // Instantiate CustomArrayAdapter
        PhrasesArrayAdapter adapter = new PhrasesArrayAdapter(getActivity(), arrayOfObjects, "font/Poppins-Regular.ttf");

        // Attach adapter to ListView
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapter, View v, int position, long id) {
                // Release MediaPlayer resources before
                // The MediaPlayer is initialized
                releaseMediaPlayer();

                //Añade el código que quieras para tu item
                ListItemObject item = (ListItemObject) listView.getItemAtPosition(position);

                // Request audio focus so in order to play the audio file. The app needs to play a
                // short audio file, so we will request audio focus with a short amount of time
                // with AUDIOFOCUS_GAIN_TRANSIENT.
                int result = mAudioManager.requestAudioFocus(mOnAudioFocusChangeListener,
                        AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                if (result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    // We have audio focus now.
                    mMediaPlayer = MediaPlayer.create(getActivity(), item.getAudioResourceId());
                    mMediaPlayer.start();

                    // Setup a listener on the media player, so that we can stop and release the
                    // media player once the sound has finished playing.
                    mMediaPlayer.setOnCompletionListener(mCompletionListener);
                }
            }
        });


        // Return listView(RootView)
        return rootView;
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }

    /**
     * Clean up the media player by releasing its resources.
     */
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mMediaPlayer != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mMediaPlayer.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mMediaPlayer = null;

            // Regardless of whether or not we were granted audio focus, abandon it. This also
            // unregisters the AudioFocusChangeListener so we don't get anymore callbacks.
            mAudioManager.abandonAudioFocus(mOnAudioFocusChangeListener);
        }
    }



}
