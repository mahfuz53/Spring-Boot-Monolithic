# Quiz Example using Spring Boot - Monolithic

## DB
- [many to many](#manyToMany)
- [postgresql]

## description
- There are two controllers: QuestionController and QuizController.
- Each controller has its own dedicated service (QuestionService and QuizService), and each service uses its own separate DAO.
- Using field injection to @Autowired

## Postmen request URL provide here:
- [GET question] : http://localhost:8080/question-domain/question
- [GET Question by ID] : [http://localhost:8080/question-domain/question](http://localhost:8080/question-domain/question/Java)
- [POST question] : http://localhost:8080/question-domain/question
  **Set at body:**
   ```bash
    {
        "questionTitle": "Which keyword is used to create a subclass in JavaTest?",
        "option1": "class",
        "option2": "interface",
        "option3": "extends",
        "option4": "implements",
        "rightAnswer": "extends",
        "difficultylevel": "Easy",
        "category": "JAVA"
    }
   ```
- [PUT question] : http://localhost:8080/question-domain/question/53
   **Set at body:**
   ```bash
    {
        "id": 53,
        "questionTitle": "Which keyword is used to create a subclass in JavaTest?",
        "option1": "class",
        "option2": "interface",
        "option3": "extends",
        "option4": "implements",
        "rightAnswer": "extends",
        "difficultylevel": "Easy level",
        "category": "JAVA"
    }
   ```
- [DELETE question] : http://localhost:8080/question-domain/question/53
- [POST Create Quiz] : http://localhost:8080/quiz-domain/quizCreate?category=Java&numOfQuestion=5&title=quiz Test 2
  
  #### Description
  Create a quiz competition generator in Java that uses the Category "Java" so that only Java-related questions are included. Limit the quiz to 5 questions, and set the competition name to "Quiz Test 2".
  
- [GET Quiz Question] : http://localhost:8080/quiz-domain/getQuiz/2
- [POST submit quiz] : http://localhost:8080/quiz-domain/submit/2
