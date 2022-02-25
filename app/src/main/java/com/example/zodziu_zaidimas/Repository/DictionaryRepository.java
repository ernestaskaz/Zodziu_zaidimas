package com.example.zodziu_zaidimas.Repository;

import android.app.Application;
import android.os.AsyncTask;
    import com.example.zodziu_zaidimas.Database.WordsDatabase;
import com.example.zodziu_zaidimas.Service.DictionaryService;


import java.util.List;
import java.util.concurrent.ExecutionException;

public class DictionaryRepository {

    private List<String> wordsDictionary;
    private DictionaryService dictionaryService;

    public DictionaryRepository(Application application) {
        WordsDatabase wordsDatabase = WordsDatabase.getInstance(application);
        dictionaryService = wordsDatabase.dictionaryService();
    }

    public List<String> getAllWords() {
        try {
            wordsDictionary = new GetDictionarySync(dictionaryService).execute().get();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return wordsDictionary;
    }

        private static class GetDictionarySync extends AsyncTask<Void, Void, List<String>> {
            private DictionaryService dictionaryService;
            List<String> wordsDictionary;

            // because class is static, nera galimybes prieiti prie serviso tiesiogiai (Repo), tačiau galima tai padaryti per konstruktorių.
            private GetDictionarySync(DictionaryService dictionaryService) {
                this.dictionaryService = dictionaryService;
            }

            @Override
            protected List<String> doInBackground(Void... voids) {
                wordsDictionary = dictionaryService.getAllSync();
                return wordsDictionary;
            }

            @Override
            protected void onPostExecute(List<String> wordsDictionary) {
                super.onPostExecute(wordsDictionary);
            }
        }


    }


