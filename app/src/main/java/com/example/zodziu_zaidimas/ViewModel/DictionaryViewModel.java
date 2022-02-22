package com.example.zodziu_zaidimas.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.zodziu_zaidimas.Model.Dictionary;
import com.example.zodziu_zaidimas.Repository.DictionaryRepository;

import java.util.List;


public class DictionaryViewModel extends AndroidViewModel {
    private DictionaryRepository dictionaryRepository;
    private LiveData<List<Dictionary>> wordsDictionary;

    public DictionaryViewModel(@NonNull Application application) {
        super(application);
        dictionaryRepository = new DictionaryRepository(application);
        wordsDictionary = dictionaryRepository.getAllWords();

    }

    public LiveData<List<Dictionary>> getAllWords() {
        return wordsDictionary;
    }
}
