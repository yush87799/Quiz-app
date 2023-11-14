// A simple quiz app in Kotlin
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    // Declare the UI elements
    private lateinit var questionTextView: TextView
    private lateinit var answerTextView: TextView
    private lateinit var button1: Button
    private lateinit var button2: Button

    // Declare the questions and answers as arrays of strings
    private val questions = arrayOf(
        "What is the capital of India?",
        "Who is the author of Harry Potter?",
        "Which planet is the second from the sun?"
    )
    private val answers = arrayOf(
        "New Delhi",
        "J.K. Rowling",
        "Venus"
    )

    // Declare the current question index and score variables
    private var currentQuestionIndex = 0
    private var score = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Initialize the UI elements by finding them by their IDs
        questionTextView = findViewById(R.id.questionTextView)
        answerTextView = findViewById(R.id.answerTextView)
        button1 = findViewById(R.id.button1)
        button2 = findViewById(R.id.button2)

        // Set the text of the question and answer views to the first question and answer pair
        questionTextView.text = questions[currentQuestionIndex]
        answerTextView.text = answers[currentQuestionIndex]

        // Set the onClickListener for each button to handle the user's choice
        button1.setOnClickListener {
            if (currentQuestionIndex == questions.size - 1) {
                // If this is the last question, show a message and end the quiz
                score += 1 // Increase the score by one point for each correct answer
                Toast.makeText(this, "You scored ${score} out of ${questions.size}", Toast.LENGTH_SHORT).show()
                finishQuiz()
            } else {
                // If this is not the last question, increment the current question index and show an error message
                currentQuestionIndex++
                Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()
            }
        }

        button2.setOnClickListener {
            if (currentQuestionIndex == questions.size - 1) {
                // If this is the last question, show a message and end the quiz
                score += 1 // Increase the score by one point for each correct answer
                Toast.makeText(this, "You scored ${score} out of ${questions.size}", Toast.LENGTH_SHORT).show()
                finishQuiz()
            } else {
                // If this is not the last question, increment the current question index and show an error message
                currentQuestionIndex++
                Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()
            }
        }
    }

    // A helper function to check if a given answer matches any of the answers in an array of strings
    fun checkAnswer(answer: String): Boolean {
        return answers.contains(answer)
    }

    // A helper function to end the quiz and show a message based on whether the user answered correctly or not
    fun finishQuiz() {
        if (checkAnswer(answerTextView.text)) {
            // If the user answered correctly, show a congratulatory message and reset some UI elements to start a new quiz
            score = 0 // Reset the score to zero for each new quiz session
            currentQuestionIndex = 0 // Reset the current question index to zero for each new quiz session

            questionTextView.text = questions[currentQuestionIndex]
            answerTextView.text = answers[currentQuestionIndex]

            button1.isEnabled = true // Enable both buttons for choosing an answer

            button2.isEnabled = false // Disable only one button for choosing an answer

            Toast.makeText(this, "Correct!", Toast.LENGTH_SHORT).show()
        } else {
            // If the user answered incorrectly, show an error message and disable both buttons for choosing an answer

            Toast.makeText(this, "Wrong answer", Toast.LENGTH_SHORT).show()

            button1.isEnabled = false

            button2.isEnabled = false

        }
    }
}
