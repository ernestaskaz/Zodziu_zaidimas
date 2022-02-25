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
    private List<String> wordsDictionary;

    public DictionaryViewModel(@NonNull Application application) {
        super(application);
        dictionaryRepository = new DictionaryRepository(application);

    }

    public List<String> getAllWords() {
        return wordsDictionary = dictionaryRepository.getAllWords();
    }
}
