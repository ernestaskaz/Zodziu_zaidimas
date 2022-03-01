package com.example.zodziu_zaidimas.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.example.zodziu_zaidimas.Model.Words;
import com.example.zodziu_zaidimas.Repository.WordsRepository;

import java.util.List;
import java.util.Random;

public class WordsViewModel extends AndroidViewModel {

    private WordsRepository wordsRepository;
    private List<Words> wordsToGuess;

    public WordsViewModel(@NonNull Application application) {
        super(application);
        wordsRepository = new WordsRepository(application);
        getWordsToGuess();
    }


    public List<Words> getWordsToGuess() {
        wordsToGuess = wordsRepository.getWordsToGuess();

        return wordsToGuess;
    }

    public Words getRandomWord() {
        Random random = new Random();
        int randomValue = random.nextInt(wordsToGuess.size() - 1);

        Words currentGuess = wordsToGuess.get(randomValue);
        System.out.println("current word is " + currentGuess.getWord());

        return currentGuess;
    }

    public int wordsToGuessSize() {
        return wordsToGuess.size();
    }

    public void updateWord(Words word) {
        wordsRepository.update(word);
    }
}
