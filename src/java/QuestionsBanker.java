
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet(urlPatterns = {"/QuestionsBanker"})
public class QuestionsBanker extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            //Set all the attributes first if starting
            HttpSession session= request.getSession();
            if(session.getAttribute("currentUser")==null)
                request.getRequestDispatcher("HomeMenu.jsp").forward(request,response);
            if(session.getAttribute("roundNumber")==null){
                session.setAttribute("roundNumber",1);}
            if(session.getAttribute("currentScore")==null){
                long a=0;
                session.setAttribute("currentScore",a);}
            //Check if a question is missing, if it is, generate all the questions.
            if(session.getAttribute("question1W3")==null){
            //Rough implementation of Random Questions and sets the questions
            question[] questionList = questionPicker(4,3,3);
            //Set the Questions 
             for(int i=1;i<11;i++){
             session.setAttribute("question"+i+"W3",questionList[i-1].getChoiceW3());
             session.setAttribute("question"+i+"W2",questionList[i-1].getChoiceW2());
             session.setAttribute("question"+i+"W1",questionList[i-1].getChoiceW1());
             session.setAttribute("question"+i+"correct",questionList[i-1].getChoiceCorrect());
             session.setAttribute("question"+i+"desc",questionList[i-1].getQuestion());
             session.setAttribute("question"+i+"picture",questionList[i-1].getPicture());
             }
             long Date = new Date().getTime();
             session.setAttribute("date",Date);
             request.getRequestDispatcher("questionQuiz.jsp").forward(request,response);
            }
            if(request.getParameter("radioAns")==null||request.getParameter("radioAns").equals("")){
                request.getRequestDispatcher("questionQuiz.jsp").forward(request,response);
            }
            //Check if its correct otherwise die.
            else if(!request.getParameter("radioAns").equals("correct")){
                session.setAttribute("victoryFlag",true);
                session.setAttribute("currentScore",session.getAttribute("currentScore"));
                request.getRequestDispatcher("leaderBoardManager").forward(request,response);
            }
            //The person won!  Send to the leaderBoardManager with VictoryFlag set to true.
            else if((int)session.getAttribute("roundNumber")>=10){
            session.setAttribute("currentScore",scoreCalculator((long)session.getAttribute("currentScore"),(long)session.getAttribute("date"),roundCalculator(4,3,3,(int)session.getAttribute("roundNumber"))));
            session.setAttribute("victoryFlag",true);
            request.getRequestDispatcher("leaderBoardManager").forward(request,response);}
            else{
            session.setAttribute("currentScore",scoreCalculator((long)session.getAttribute("currentScore"),(long)session.getAttribute("date"),roundCalculator(4,3,3,(int)session.getAttribute("roundNumber"))));
            session.setAttribute("date",new Date().getTime());
            session.setAttribute("roundNumber",(int)session.getAttribute("roundNumber")+1);
            request.getRequestDispatcher("questionQuiz.jsp").forward(request,response);
            }
        }
    }
    static long scoreCalculator(long currentScore, long date, int diff){
       long curDate = new Date().getTime();
        if((curDate-date)<60000)
            return currentScore+(500+(600-(curDate-date)/100))*diff;
        else
            return currentScore+500*diff;
    }
    static int roundCalculator(int easy,int medium,int hard, int roundNumber){
        if(roundNumber<=easy){
            return 1;
        }
        if(roundNumber<=easy+medium){
            return 2;
        }
        if(roundNumber<=easy+medium+hard){
            return 3;
        }
        return 1;
    }
    static question[] questionPicker(int easy,int medium,int diff)
    {
        //A hardcoded set of questions put inside an array.
        question[] easyQuestions = new question[10];
        question[] mediumQuestions = new question[10];
        question[] hardQuestions = new question[10];
        
        easyQuestions[0] = new question("What is the this move known as?","En Passant","Two-Move Pawn Take","En Passing","The Passant","Easy1");
        easyQuestions[1] = new question("What is the point value of the Queen?","8","7","6","9","Easy2");
        easyQuestions[2] = new question("What is the point value of the Bishop","3","2","4","5","Easy3");
        easyQuestions[3] = new question("What is the point value of the Knight?","3","2","4","5","Easy4");
        easyQuestions[4] = new question("What is the point value of the Rook?","5","3","4","2","Easy5");
        easyQuestions[5] = new question("What is this mate known as?","Smothered Mate","Choked Mate","Blocked Mate","Crushed Mate","Easy6");
        easyQuestions[6] = new question("What is this mate known as?","Fool's Mate","Idiot's Mate","Three-Move Mate","Open Mate","Easy7");
        easyQuestions[7] = new question("What is the terminology for attacking two undefended pieces?","Fork","Double-Edge","Wooden Shield","Double-Hit","Easy8");
        easyQuestions[8] = new question("What is the terminology for attacking the king with two pieces at once?","Double-Check","Double-Attack","Double-Edge","Double-Take","Easy9");
        easyQuestions[9] = new question("What is the terminology for preventing a piece from moving by atacking the piece protecting the king?","Pin","Block","Stun","Freeze","Easy10");
        mediumQuestions[0] = new question("White to Move: What is the best move in this position?","Ra1","d5","Bf4","Kf1","Medium1");
        mediumQuestions[1] = new question("White to Move: What is the best move in this position?","Rg4xg7","Qf6xQe5","Qf6xh6","Re4","Medium2");
        mediumQuestions[2] = new question("White to Move: What is the best move in this position?","Ke1","Kg1","Kg2","Kf2","Medium3");
        mediumQuestions[3] = new question("Black to Move: What is the best move in this position?","Bd6xNf3","Bf3xBe2","Qg4","Nc6xd4","Medium4");
        mediumQuestions[4] = new question("White to Move: What is the best move in this position?","Rf2xf7+","Qh8+","Qh7xf7+","Ng5xe6","Medium5");
        mediumQuestions[5] = new question("Black to Move: What is the best move in this position?","Qa5xQd2","c6xNb5","Bb4","Qa5xNb5","Medium6");
        mediumQuestions[6] = new question("What is the name of this opening?","BongCloud","Forward King","HighCloud","Insanity","Medium7");
        mediumQuestions[7] = new question("What is the name of this opening?","Sicilian Defense","Sicilian Attack","Fischer Opening","Italian Opening","Medium8");
        mediumQuestions[8] = new question("What is the name of this opening?","Modern Defense","Classic Defense","Accelerated Dragon","Fianchetto Opening","Medium9");
        mediumQuestions[9] = new question("What is the name of this opening?","Vienna","French","London","Berlin","Medium10");
        hardQuestions[0] = new question("White to Move: What is the best move in this position?","Qd6xNe5","Bh5xf7","Qd5","Qd7","Difficult1");
        hardQuestions[1] = new question("Black to Move: What is the best move in this position?","Rf6xf2","Bb6xf2","d5","Qe6xNc4","Difficult2");
        hardQuestions[2] = new question("Black to Move: What is the best move in this position?","Qc5xc2","Rc7","Ne2+","Qc5xa3","Difficult3");
        hardQuestions[3] = new question("White to Move: What is the best move in this position?","Rg7+","Nf4+","Rd6","Bf5","Difficult4");
        hardQuestions[4] = new question("Black to Move: What is the best move in this position?","Qc2+","Re8xe3+","Qf5xRf4","Qe6","Difficult5");
        hardQuestions[5] = new question("Black to Move: What is the best move in this position?","Nd4+","Qc3xQc2","Re8","Bg4xNf3","Difficult6");
        hardQuestions[6] = new question("What is the name of this opening?","Tennison Gambit: ICBM Variation","Spanish Opening: Italian Variation","Tennison Gambit: Double-Pawn Gambit","Tennison Gambit: Bg6","Difficult7");
        hardQuestions[7] = new question("What is the name of this opening?","Fried-Liver Attack","Vienna Opening: F7 Attack","English Opening: F7 Attack","Three Knights Opening: Knight Sacrifice","Difficult8");
        hardQuestions[8] = new question("What is the name of this opening?","Stafford Gambit","Benko Gambit","King's Knight Gambit","Swedish Gambit","Difficult9");
        hardQuestions[9] = new question("What is the name of this opening?","Black-Mar Diemer Gambit","Alekhine Gambit","Khan Gambit","Wing Gambit","Difficult10");
        List<Integer> randomNum = new ArrayList<>();
        question[] questionArray = new question[easy+medium+diff];
        int questionCounter = 0;
        for(int i =0;i<10;i++){
            randomNum.add(i);
        }
        Collections.shuffle(randomNum);
        while(easy!=0){
            questionArray[questionCounter]= easyQuestions[randomNum.get(easy)];
            questionCounter++;
            easy--;
        }
        Collections.shuffle(randomNum);
        while(medium!=0){
            questionArray[questionCounter]= mediumQuestions[randomNum.get(medium)];
            questionCounter++;
            medium--;
        }
        Collections.shuffle(randomNum);
        while(diff!=0){
            questionArray[questionCounter]= hardQuestions[randomNum.get(diff)];
            questionCounter++;
            diff--;
        }
        return questionArray;
  }

        
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
    
}
