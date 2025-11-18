[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/8WbEQaRE)
# Portfolio project IDATA1003
This file uses Mark Down syntax. For more information see [here](https://www.markdownguide.org/basic-syntax/).

[//]: # (TODO: Fill inn your name and student ID)

STUDENT NAME = "Jørgen Eira Nilsen"  
STUDENT ID = "null"

## Project description

[//]: # (TODO: Write a short description of your project/product here.)
A console diary that you can create posts on

## Project structure

[//]: # (TODO: Describe the structure of your project here. How have you used packages in your structure. Where are all sourcefiles stored. Where are all JUnit-test classes stored. etc.)
I have two UI classes called Input and DiaryInterface. They are located in the ui package. Input is for handling user input, DiaryInterface is for creating a interface for the diary.
The diary package includes all classes that are needed for the diary. It includes Author, AuthorRegister, Constants, Diary, Post and Time.
Author handles authors, this includes formatting the name of user input. AuthorRegister links different Authors with a Diary using HashMap, meaning fast access and no duplicates.
Constants hold literal constants used in the program.
Post is the diaryentry class. Diary is the register of posts, it uses a HashMap meaning no dublicate dates (One post a day) but have added a function to add posts on different dates then today. It also handles adding, removing and getting posts.
Time class is used for formatting user input to a useable time format. It uses LocalDateTime to get the date of when posts get created.

Junit tests are located in test folder. Tests are run on Diary classes.

## Link to repository

[//]: # (TODO: Include a link to your GitHub repository here.)
https://github.com/NTNU-IE-IDI-IDATG1003-2025/mappe-idatg1003-2025-JrgenEN

## How to run the project

[//]: # (TODO: Describe how to run your project here. What is the main class? What is the main method?
What is the input and output of the program? What is the expected behaviour of the program?)
You download the project then run main to start the program. You will be promted with info on the ui.

## How to run the tests

[//]: # (TODO: Describe how to run the tests here.)
Open test folder and run the classes in the test folder.
## References

[//]: # (TODO: Include references here, if any. For example, if you have used code from the course book, include a reference to the chapter.
Or if you have used code from a website or other source, include a link to the source.)
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/time/LocalDateTime.html
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/HashMap.html
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collections.html
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Collection.html
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/ArrayList.html
https://docs.oracle.com/en/java/javase/21/docs/api/java.base/java/util/Arrays.html
