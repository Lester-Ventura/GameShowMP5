//question Class for the questions.
class question{
    private String question;
    private String choiceCorrect;
    private String choiceW1;
    private String choiceW2;
    private String choiceW3;
    private String picture;
    question(String question,String choiceCorrect,String choiceW1,String choiceW2,String choiceW3){
         this.question=question;
         this.choiceCorrect=choiceCorrect;
         this.choiceW1=choiceW1;
         this.choiceW2=choiceW2;
         this.choiceW3=choiceW3;
    }
      question(String question,String choiceCorrect,String choiceW1,String choiceW2,String choiceW3,String picture){
         this.question=question;
         this.choiceCorrect=choiceCorrect;
         this.choiceW1=choiceW1;
         this.choiceW2=choiceW2;
         this.choiceW3=choiceW3;
         this.picture=picture;
    }
    boolean questionCheck(String answer){
        return(answer.equals(getChoiceCorrect()));
    }
    public String getQuestion() {
        return question;
    }
    public String getChoiceCorrect() {
        return choiceCorrect;
    }
    public String getChoiceW1() {
        return choiceW1;
    }
    public String getChoiceW2() {
        return choiceW2;
    }
    public String getChoiceW3() {
        return choiceW3;
    }
    public String getPicture(){
        return picture;
    }
}