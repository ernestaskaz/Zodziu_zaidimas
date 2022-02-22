package com.example.zodziu_zaidimas.Repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.room.Update;

import com.example.zodziu_zaidimas.Database.WordsDatabase;
import com.example.zodziu_zaidimas.Model.Words;
import com.example.zodziu_zaidimas.Service.WordsService;

import java.util.List;
import java.util.concurrent.ExecutionException;

public class WordsRepository {

    private WordsService wordsService;
    private List<Words> wordsToGuess;



    public WordsRepository(Application application) {
        WordsDatabase wordsDatabase = WordsDatabase.getInstance(application);
        wordsService = wordsDatabase.wordsService();

    }

    public void update(Words word) {
        new UpdateWordsAsyncTask(wordsService).execute(word);
    }

    public List<Words> getWordsToGuess() {
        try {
            wordsToGuess = new GetWordsToGuessAsync(wordsService).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return wordsToGuess;
    }

    private static class UpdateWordsAsyncTask extends AsyncTask<Words, Void, Void> {
        private WordsService wordsService;
        private UpdateWordsAsyncTask(WordsService wordsService) {
            this.wordsService = wordsService;
        }

        @Override
        protected Void doInBackground(Words... word) {
            wordsService.update(word[0]);
            return null;
        }
    }

    private static class GetWordsToGuessAsync extends AsyncTask<Void, Void, List<Words>> {
        private WordsService wordsService;
        List<Words> wordsToGuess;

        // because class is static, nera galimybes prieiti prie serviso tiesiogiai (Repo), tačiau galima tai padaryti per konstruktorių.
        private GetWordsToGuessAsync(WordsService wordsService) {
            this.wordsService = wordsService;
        }

        @Override
        protected List<Words> doInBackground(Void... voids) {
           wordsToGuess = wordsService.getAllAsync();
           return wordsToGuess;
        }

        @Override
        protected void onPostExecute(List<Words> wordsToGuess) {
            super.onPostExecute(wordsToGuess);
        }
    }
}

