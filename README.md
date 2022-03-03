

## Description

A Wordle game for android  - inspired by original Wordle. Created without word/day limit.  Only existing words are permitted to be guessed.


## How it works

Find hidden word with up to 6 tries. Each guess may reveal: 

- correct letter in a correct index - background set in green;
- correct letter but wrong index - background set in orange;
- wrong letters - background set in black.


- Keyboard letters also change colors according to guesses;
- Words are checked in Dictionary that was imported to SQL and then to Room DB;
- wordsToGuess are generated randomly from Room DB (also imported to Room with SQL);


![Screenshot_20220303-133834_Zodziu_zaidimas](https://user-images.githubusercontent.com/6989478/156567901-1fa95d9b-6aa4-48b6-a5b1-e2febfc979dc.jpg)
![Screenshot_20220303-135529_Zodziu_zaidimas](https://user-images.githubusercontent.com/6989478/156567898-3980c3e2-0d19-43ee-8cc1-b8515a16c07e.jpg)

