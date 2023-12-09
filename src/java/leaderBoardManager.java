import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(urlPatterns = {"/leaderBoardManager"})
public class leaderBoardManager extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
           HttpSession session = request.getSession();
            //If winner, do this.
           if(session.getAttribute("victoryFlag")!=null){
            if((boolean)session.getAttribute("victoryFlag")){
                boolean full=true;
                String minScore="score1",minLeader="leader1";
                for(int i=1;i-1<20;i++){
                 if(session.getAttribute("leader"+i)== null){
                     full=false;
                     session.setAttribute("leader"+i,session.getAttribute("currentUser"));
                     session.setAttribute("score"+i,session.getAttribute("currentScore"));
                     break;}
                 else if(session.getAttribute("leader"+i).equals(session.getAttribute("currentUser"))){
                     full=false;
                     if((long)session.getAttribute("score"+i)<(long)session.getAttribute("currentScore"))
                         session.setAttribute("score"+i,session.getAttribute("currentScore"));
                     break;}
                 if((long)session.getAttribute(minScore)>(long)session.getAttribute("score"+i)){
                     minScore="score"+i;
                     minLeader="leader"+i;
                 }
                        }
                 if(full){
                       if((long)session.getAttribute(minScore)<(long)session.getAttribute("currentScore"))
                         session.setAttribute(minScore,session.getAttribute("currentScore"));
                         session.setAttribute(minLeader,session.getAttribute("currentUser"));
               }
                 request.getRequestDispatcher("You Died.jsp").forward(request,response);
            }}
            else if(session.getAttribute("admin")!=null){
                if(request.getParameterValues("checkrows")!=null){
                String[] checkbox = request.getParameterValues("checkrows");
                for(String check: checkbox){
                    session.removeAttribute("leader"+check);
                    session.removeAttribute("score"+check);
                }
                session.removeAttribute("admin");
                session.removeAttribute("currentUser");
               request.getRequestDispatcher("HomeMenu.jsp").forward(request,response);
             }  }
                  session.removeAttribute("currentUser");
               request.getRequestDispatcher("HomeMenu.jsp").forward(request,response);

        }
           //Default backup just in case
        
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
