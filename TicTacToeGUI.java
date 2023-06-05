/**
 * @Author: Hadi Jafar
 * @Date: December 19 2019
 * Filename: HadiTicTacToeGUI.java
 * Description: Creates a tictactoe game using jpanel
 */

 //Imports libraries needed
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
class HadiTicTacToeGUI extends JPanel implements ActionListener//Name of the class, allows the use of JPanel and uses actionListener to create screen changes
{
  //Global Variables
  public static CardLayout cdLayout = new CardLayout();//Used to create screens/change screens
  public static JButton button [][] = new JButton[3][3];//This creates the tic tac toe grid
  public static int turn = 0; //Used to determine whos turn it is
  public static int scoreX = (0);
  public static int scoreO = (0);
  public static String Winner=(" ");//
  public static boolean indicate=false;//Prevents the actionListener from reading grid information before the users have a chance to play
  public static int rounds=0;//Holds how many rounds the user wants
  public static JLabel score1;
  public static JLabel score2;

  //Colour theme
  public static Color lgreen=(new Color(50, 171, 50));//Creates a green colour
  public static Color white=(new Color(255, 255, 255));//Creates a white colour

  //Main code
  public static void main (String [] args)
  {
    HadiTicTacToeGUI content = new HadiTicTacToeGUI();//Defines content as the program
    JFrame window = new JFrame("Tic Tac Toe");//Gives the gui window a name
    window.setContentPane(content);//Lets the panes be used
    window.setSize(600,600);//Creates the window size
    window.setResizable(true);//Lets the screen be resized by the user
    window.setLocation(150,150);//Places the screen at location 100,100
    window.setVisible(true);//Lets the user see the screen
  }//Closes main function
 
  //Screens
  //Used as reference throughout the code
  public HadiTicTacToeGUI ()
  {
    setLayout(cdLayout);//Creates a layout that matches cdLayout
    intro();//First screen
    options();//Game option screen
    rules();//Rules screen
    grid();//Grid game screen
    end();//Ending screen
  }//Closes function
 
  //THis function creates the opening screen
  public void intro()
  {
    JPanel screen = new JPanel();//Creates a screen for the entire window
    screen.setBackground(lgreen);//Fills the background with green
    screen.setLayout(new GridLayout (5,1,1,1));//Creates a grid for the screen
    
    //Layout for the first line
    JPanel sentence1 = new JPanel();//Creates a panel that will go into the grid
    sentence1.setLayout(new GridLayout(1,1,5,5));//Creates a grid for the text
    sentence1.setBackground(lgreen);//Stated above
    JLabel space = new JLabel(" ");//Used as a place holder to make the screen look cleaner
    sentence1.add(space);//Adds the space to the panel
    screen.add(sentence1);//Adds the panel to the screen
    
    //Layout for the second line
    JPanel sentence2 = new JPanel ();//Creates a panel that will go into the grid
    sentence2.setLayout(new GridLayout(1,1,1,1));//Creates a grid for the text
    JLabel intro = new JLabel ("   TIC TAC TOE");//Creates a text label called TIC TAC TOE
    sentence2.setBackground(lgreen);//Sets the background of the text as green
    intro.setForeground(white);//Make the text white
    intro.setFont (new Font ("Chalkboard", Font.PLAIN, 75));//Modifies the text font and size
    sentence2.add(intro);//Adds it to the panel
    screen.add(sentence2);//Adds it to the screen
    
    JPanel fun1 = new JPanel ();//Creates a panel that will go into the grid
    fun1.setLayout(new GridLayout(1,1,1,1));//Creates a grid for the text
    fun1.setBackground(lgreen);//Fills green
    JLabel fun2 = new JLabel ("                 Have Fun!! ");//Creates a text 
    fun2.setForeground(white);//Sets it as white
    fun2.setFont (new Font ("Chalkboard", Font.PLAIN, 35));// stated above
    fun1.setBackground(lgreen);//Stated above
    screen.add(fun2);//Adds fun2 label to the screen

    //Layout for the Start button
    JPanel sentence3 = new JPanel();//Stated above
    sentence3.setLayout(new GridLayout(1,5,10,10));//Creates a grid 1 row, 5 columns with a thickness of 10x10 between each box
    sentence3.setBackground(lgreen);//Stated above

    for (int i = 0;i<2;i++)//Repeats twice
    {
      JLabel blank = new JLabel (" ");//Creates a label to be used a placeholder to make a clean screen
      sentence3.add(blank);//Stated above
    }

    //Play button 
    JPanel button = new JPanel ();//Stated above
    button.setBackground(lgreen);//Stated above
    JButton start = new JButton ("Play");//Creates a button that will activate action listener when pressed
    start.setBackground(white);//Stated above
    start.setForeground(lgreen);//Stated above
    start.setFont(new Font ("Chalkboard",Font.PLAIN,20));//Stated above
    start.setPreferredSize(new Dimension(100, 50));//Creates the desired size for the button
    start.setActionCommand("2");//This will be compared in the function actionlistener to determine what screen should be displayed next
    start.addActionListener(this);//This is activated when the button is clicked
    button.add(start);//Stated above
    sentence3.add(button);//Stated above

    //Rules button
    JPanel button2 = new JPanel ();//Stated above
    button2.setBackground(lgreen);//Stated above
    JButton rules = new JButton ("Rules");//Creates a button that will activate once pressed with the text rules
    rules.setBackground(white);
    rules.setForeground(lgreen);//Stated above
    rules.setFont(new Font ("Chalkboard",Font.PLAIN,20));//Stated above
    rules.setPreferredSize(new Dimension(100, 50));//Stated above
    rules.setActionCommand("3");//Stated above
    rules.addActionListener(this);//Stated above
    button2.add(rules);//Stated above
    sentence3.add(button2);

    //For loop
    for (int j = 0;j<2;j++)//Repeats twice
    {
      JLabel blank = new JLabel(" ");//Creates a placeholder label
      sentence3.add(blank);//Adds it to the panel
    }//Closes for loop

    screen.add(sentence3);//Stated above
    add("1",screen);//This adds the whole screen to the first window. This means that this will all show once actiavted
  }//Closes function

  //Creates the option for game screen
  public void options(){
    JPanel screen = new JPanel();//Creates a new screen
    screen.setBackground(lgreen);//Stated above
    screen.setLayout(new GridLayout(4,1,2,2));//Creates a grid with 4 rows, 1 column, with a thickness of 2x2 between each

    JPanel block = new JPanel();//Stated above
    block.setBackground(lgreen);//Stated above
    JButton back = new JButton("Back");//Creates a button to go back 
    back.setPreferredSize(new Dimension(100, 50));//Stated above
    back.setFont(new Font ("Chalkboard",Font.PLAIN,25));//Stated above
    back.setForeground(lgreen);
    back.setBackground(white);
    back.setActionCommand("1");//Used to determine what screen should come next
    back.addActionListener(this);//Activates action listener
    block.add(back);//adds back variable to block

    JLabel title = new JLabel ("  Options     ");//Same as previous labl code, different text and size
    title.setFont(new Font ("Chalkboard",Font.PLAIN,70));
    title.setForeground(white);
    block.add(title);//Stated above
    screen.add(block);//Stated above

    //Creates options
    //Activates the according actiion listener statements
    JButton choice = new JButton ("Single game");//Used to determine how many rounds the user wants
    choice.setFont(new Font ("Chalkboard",Font.PLAIN,40));//Modifies the text
    choice.setForeground(lgreen);//Stated above
    choice.setBackground(white);//Stated above
    choice.setActionCommand("option 1");//Used to determine what button was pressed
    choice.addActionListener(this);//Activates only when the button is pressed
    screen.add(choice);//Adds th button to the screen

    JButton choice2 = new JButton (" Best of 3 ");//Stated above
    choice2.setFont(new Font ("Chalkboard",Font.PLAIN,40));
    choice2.setForeground(lgreen);
    choice2.setBackground(white);
    choice2.setActionCommand("option 2");
    choice2.addActionListener(this);
    screen.add(choice2);

    JButton choice3 = new JButton (" Best of 5 ");//Stated above
    choice3.setFont(new Font ("Chalkboard",Font.PLAIN,40));
    choice3.setForeground(lgreen);
    choice3.setBackground(white);
    choice3.setActionCommand("option 3");
    choice3.addActionListener(this);
    screen.add(choice3); 

    screen.setVisible(true);//Lets the user see the panel
    add("2",screen);//Adds the panel to the windows
  }
 
  //Creates the rule screen
  public void rules()
  {
    JPanel screen = new JPanel();//Creates a new panel
    screen.setBackground(lgreen);//Stated above
    screen.setLayout(new GridLayout(7,1,1,1));//Creates a new grid layout
    
    //Rule lines
    JPanel sentence1 = new JPanel();//Stated above
    sentence1.setBackground(lgreen);
    sentence1.setLayout(new GridLayout (1,1,5,5));//Stated above
    JLabel rule1 = new JLabel(" Rules:");//Creates a title
    rule1.setForeground(white);
    rule1.setFont(new Font ("Chalkboard",Font.PLAIN,40));//Stated above
    sentence1.add(rule1);
    screen.add(sentence1);

    JPanel sentence2 = new JPanel ();//Stated above
    sentence2.setBackground(lgreen);
    sentence2.setLayout(new GridLayout(1,1,5,5));//Stated above
    JLabel rule2 = new JLabel("  1) There are 2 players, X and O. X will go first");
    rule2.setForeground(white);
    rule2.setFont(new Font ("Chalkboard",Font.PLAIN,20));
    sentence2.add(rule2);//Adds to sentence2
    screen.add(sentence2);//Adds to panel

    JPanel sentence3 = new JPanel();
    sentence3.setBackground(lgreen);
    sentence3.setLayout(new GridLayout(1,1,5,5));
    JLabel rule3 = new JLabel("  2) Player will take turns placing their characters on the grid");
    rule3.setForeground(white);
    rule3.setFont(new Font ("Chalkboard",Font.PLAIN,20));
    sentence3.add(rule3);
    screen.add(sentence3);//Stated above

    JPanel sentence4 = new JPanel();
    sentence4.setBackground(lgreen);
    sentence4.setLayout(new GridLayout(1,1,5,5));
    JLabel rule4 = new JLabel("  3) First player to create a line of 3 spaces wins");
    rule4.setForeground(white);
    rule4.setFont(new Font ("Chalkboard",Font.PLAIN,20));
    sentence4.add(rule4);
    screen.add(sentence4);//same as above
    
    JPanel space = new JPanel();
    space.setBackground(lgreen);
    space.setLayout(new GridLayout(1,1,5,5));//Stated above
    screen.add(space);

    JPanel sentence5 = new JPanel();
    sentence5.setBackground(lgreen);
    sentence5.setLayout(new GridLayout(1,1,5,5));//Stated above

    //For loop
    for (int i = 0;i<2;i++)//Repeats twice to add spaces
    {
      JLabel blank = new JLabel (" ");//Creates a placeholder
      sentence5.add(blank);//Places it
    }

    JPanel button = new JPanel ();//Stated above
    button.setBackground(lgreen);
    JButton play = new JButton("Back");
    play.setBackground(white);
    play.setForeground(lgreen);
    play.setFont(new Font ("Chalkboard",Font.PLAIN,20));//Stated above
    play.setPreferredSize(new Dimension(100, 50));//Creates the desired size of the button
    play.setActionCommand("1");//Stated above
    play.addActionListener(this);
    button.add(play);
    sentence5.add(button);//Stated above
    screen.add(sentence5);//Stated above

    for (int i = 0;i<2;i++)//Same as above
    {
      JLabel blank = new JLabel (" ");
      sentence5.add(blank);
    }
    
    add("3",screen);//Adds the panel to the window
  }
 
  //Creates the grid
  public void grid(){
    indicate=true;//This becomes true to allow the for loops in action listener to run
    JPanel screen = new JPanel();//Creates a new panel
    screen.setLayout(new GridLayout(5,3));//Stated above
    screen.setBackground(lgreen);//Stated above

    //Creates a button to reset the grid
    JPanel button1 = new JPanel();
    button1.setBackground(lgreen);//Stated above
    button1.setLayout(new GridLayout(2,2));//Stated above
    JButton back1 = new JButton("Clear");//Creates a button to be pressed
    back1.setFont (new Font ("Chalkboard", Font.PLAIN, 20));//Stated above
    back1.setForeground(lgreen);//Stated above
    back1.setBackground(white);
    back1.setActionCommand("clear");
    back1.addActionListener(this);//Stated above
    button1.add(back1);

    for (int i=0;i<3;i++){//Repeats 3 times and adds a placeholder
      JLabel spacer = new JLabel(" ");
      button1.add(spacer);
    }//Closes for loop

    JPanel gametitle = new JPanel();//Stated above
    gametitle.setBackground(lgreen);//Stated above
    JLabel title = new JLabel("Tic Tac Toe");//Creates a title for the grid game
    title.setFont (new Font ("Chalkboard", Font.PLAIN, 38));//Stated above
    title.setForeground(white);
    gametitle.add (title);//Adds the title to the panel

    JLabel space2 = new JLabel(" ");//Placeholder

    //Adds the panel, title and placeholder
    screen.add(button1);
    screen.add(gametitle);
    screen.add(space2);

    //For loops
    //creates the 3x3 grid for the game
    for (int i = 0; i < 3; i++){//Repeats 3 times which represents all fo the rows
      for (int k=0;k<3;k++){//Repeats 3 times which represents all of the columns
        button[i][k] = new JButton(" ");//Creates a button for each array spot and leaves it empty
        button[i][k].setFont (new Font ("Chalkboard", Font.PLAIN, 65));//Modifies the text
        button[i][k].setForeground(lgreen);//Stated above
        button[i][k].setBackground(white);//Stated above
        screen.add(button[i][k]);//Adds the button to the screen
        button[i][k].setActionCommand("button"+i+""+k);//Stated above
        button[i][k].addActionListener(this);//Stated above
      }//Close for loop
    }//Close for loop

    score1 = new JLabel("  X Score: "+scoreX);//Creates the x score label
    score1.setFont (new Font ("Chalkboard", Font.PLAIN, 30));//Stated above
    score1.setForeground(white);//Stated above
    score1.setBackground(lgreen);

    JLabel space3 = new JLabel(" ");//Creates a placeholder

    score2 = new JLabel("  O score: "+scoreO);//Creates the 0 score label
    score2.setFont (new Font ("Chalkboard", Font.PLAIN, 30));//Stated above
    score2.setForeground(white);
    score2.setBackground(lgreen);

    //Adds xscore, space, and 0 score in order
    screen.add(score1);
    screen.add(space3);
    screen.add(score2);
  
    screen.setVisible(true);//Sets the screen to visible
    add("4",screen);////Stated above
  }//Closes the function

  //This function determines whether the users won or not
  //It checks all possible functions
  public void winOrLose(){
    //.equals() and == does not make a difference in this situation

    Winner=null;//This prevents games with more then one round from changing the score if the board is a tie
    //If statements
    //Checks all rows
    if ((button[0][0].getText().equals(button[0][1].getText())) && (button[0][0].getText().equals(button[0][2].getText())) && (button[0][0].getText()!=(" "))){
      Winner = button[0][0].getText();//Recieves the text for one of the box
      scoreChanger();//Activates score changer
    }
    else if (button[1][0].getText() == button[1][1].getText() && button[1][0].getText() == button[1][2].getText() && button[1][0].getText()!= (" ")){
      Winner = button[1][0].getText();
      scoreChanger();
    }
    else if (button[2][0].getText() == button[2][1].getText() && button[2][0].getText() == button[2][2].getText() && button[2][0].getText()!= (" ")){
      Winner = button[2][0].getText();
      scoreChanger();
    }

    //All columns
    else if (button[0][0].getText() == button[1][0].getText() && button[0][0].getText() == button[2][0].getText() && button[0][0].getText()!= (" ")){
      Winner = button[0][0].getText();
      scoreChanger();
    }
    else if (button[0][1].getText() == button[1][1].getText() && button[0][1].getText() == button[2][1].getText() && button[0][1].getText()!= (" ")){
      Winner = button[0][1].getText();
      scoreChanger();
    }
    else if (button[0][2].getText() == button[1][2].getText() && button[0][2].getText() == button[2][2].getText() && button[0][2].getText()!= (" ")){
      Winner = button[0][2].getText();
      scoreChanger();
    }
    
    //Both diagonals
    else if (button[0][0].getText() == button[1][1].getText() && button[0][0].getText() == button[2][2].getText() && button[0][0].getText()!= (" ")){
      Winner = button[0][0].getText();
      scoreChanger();
    }
    else if (button[0][2].getText() == button[1][1].getText() && button[0][2].getText() == button[2][0].getText() && button[0][2].getText()!= (" ")){
      Winner = button[0][2].getText();
      scoreChanger();
    }

    //If the board is filled
    else if (button[0][0].getText()!=(" ") && button[0][1].getText()!=(" ") && button[0][2].getText()!=(" ") && button[1][0].getText()!=(" ") && button[1][1].getText()!=(" ") && button[1][2].getText()!=(" ") && button[2][0].getText()!=(" ") && button[2][1].getText()!=(" ") && button[2][2].getText()!=(" ")){
      Winner=("N");
      scoreChanger();
    }
  }//Closes function

  //Changes the score for each player accordingly
  public void scoreChanger(){

    //If statements
    if (Winner.equals("X")){//If Winner = "X", then 
      scoreX++;//ScoreX goes up by one
      roundTracker();//Activates roundTracker
      score1.setText("  X score: "+scoreX);//Changes the text for the Jlabel that has score X
    }//Closes if statement

    else if (Winner.equals("O")){//If Winner = "O", then 
      scoreO++;//ScoreO goes up by one
      roundTracker();//Activates roundTracker
      score2.setText("  O score: "+scoreO);//Changes the text for the Jlabel that has score O
    }//Closes else if statement
    else{//Otherwise
      roundTracker();//Activates round tracker
    }//Closes else statement
  }//CLoses function

  //Determines whether a user has won the majority
  public void roundTracker(){
    end();//Activates the end function

    //If statement
    //This statement checks whether player x has won majoirty rounds of the game
    if (scoreX>=(rounds/2+1)){
      cdLayout.show(this, "5");//Activates the end screen
    }//Closes if statement
    
    //Else if statement
    //This statement checks whether player O has won majoirty rounds of the game
    else if (scoreO>=(rounds/2+1)){
      cdLayout.show(this, "5");//Stated above
    }//Closes loop

    //checks if the game is tied 
    else if (scoreO==0 && scoreX==0 && rounds==1){
      cdLayout.show(this, "5");
    }

    else{//Otherwise
      //Clears the board to play another round
      for (int i=0;i<3;i++){
        for (int k=0;k<3;k++){
          button[i][k].setText(" ");
        }//Closes for loop
      }//Closes for loop
    }//Closes else loop
  }//Closes function

  //This function displays who won and prompts the user to restart the game
  public void end(){
    JPanel screen = new JPanel();//Creates the screen for the end window
    screen.setBackground(lgreen);//Stated above

    JLabel win = new JLabel(" ");//Creates a text that change accoring to what user won or if its a tie
    win.setText (" Player "+Winner+", Has Won The Game!");//Changes the statement fo the win label
    if (Winner.equals("N")){//if winner is N then it is a tie game
      win.setText("The game is a tie!");//Changes the text of win
    }//Closes if loop

    JLabel icon = new JLabel();//Creates a label that holds the image
    icon.setIcon (createImageIcon("giphy.gif"));//Uses the gif gipghy and activates createImageIcon function
    icon.setSize(100,100);//resizes the gif
    
    win.setFont (new Font ("Chalkboard", Font.BOLD, 35));//Stated above
    JButton reset = new JButton ("Restart");//Creates a new button used to restart the game
    reset.setPreferredSize(new Dimension(250, 50));//Stated above
    reset.setForeground(lgreen);//Stated above
    reset.setBackground(white);//Stated above
    reset.setFont (new Font ("Chalkboard", Font.BOLD, 35));//Stated above
    reset.setActionCommand("redo");//Stated above
    reset.addActionListener(this);//Stated above
    win.setForeground(white);//Stated above

    screen.add(win);//Adds the label and button to the screen
    screen.add(reset);//adds the button
    screen.add(icon, BorderLayout.CENTER );//Places th image in the center
    screen.setVisible(true);//Stated above
    add("5",screen);//Stated above
  }//Closes function
 
  //This function is activated whenever a button is pressed
  //Depending on whatever string was assigned to the button, the corresponding will happen
  public void actionPerformed (ActionEvent e)
  {
    if (e.getActionCommand().equals ("1"))
    {
      cdLayout.show (this, "1");//Activates screen which in this case is intro
    }
    else if (e.getActionCommand().equals ("2"))//Similiarly to the first if statement, this one activates the options slide since that corresponds with 2
    {
      cdLayout.show (this, "2");
    }
    else if (e.getActionCommand().equals ("3")){
      cdLayout.show(this, "3");
    }
    //The next 3 getActionCommand() are used for the option buttons and set rounds accordingly
    else if (e.getActionCommand().equals ("option 1"))//Single game
    {
      rounds=1;
      cdLayout.show(this,"4");
    }
    else if (e.getActionCommand().equals ("option 2"))//Best of 3
    {
      rounds=3;
      cdLayout.show(this,"4");
    }
    else if (e.getActionCommand().equals ("option 3")) {//Best of 5
      rounds=5;
      cdLayout.show(this,"4");
    }   
    else if (e.getActionCommand().equals ("clear")){ //This is activated if the users want to clear the board during the game
      for (int i=0;i<3;i++){
        for (int k=0;k<3;k++){
          button[i][k].setText(" "); //Sets all buttons as " "
        }
      }
    }
    else if (e.getActionCommand().equals ("redo")){//this is activated if the users want to restart the game
      for (int i=0;i<3;i++){//Same for loop as above
        for (int k=0;k<3;k++){
          button[i][k].setText(" ");
        }
      }
      //Resets all used variables
      turn = 0;//This variable determines the players turn
      scoreX = 0;//This variable keeps track of player x score
      scoreO = 0;//This variable keeps track of player o score
      Winner=null;//This variable holds who won the game
      intro();//Activates intro
      cdLayout.show(this, "1");//Displays the opening screen
      score1.setText("  X Score: "+scoreX);//Resets the score display variables
      score2.setText("  O Score: "+scoreO);
    }//Closes else if statement 

    else if (indicate!=false){//Indicate is used to determine whether the users have started playing tic tac toe 
      for (int i=0;i<3;i++){//For loop for all  rows and columns in the game
        for (int k=0;k<3;k++){
          if (e.getActionCommand().equals ("button"+i+""+k)){//Isolates the button pressed
            if (button[i][k].getText()!=(" ")){//Checks to see whether the spot is taken.
              turn++;//turn goes up by one which changes it back to the same players turn
            }//Closes if statement
            else{////Determines whos turn it is 
              if(turn%2 == 0)//Determines whether turn is divisible by 2
                button[i][k].setText("X");//Places x as the button text

              else  
                button[i][k].setText("O");//Places o as the button text
            }
            turn++;//Increases turn to change the player
            winOrLose();//Activates winOrLose function
          }
        }
      }
    }
  }
  //method that all java to access image files 
  protected static ImageIcon createImageIcon (String path)
  {
    java.net.URL imgURL = HadiTicTacToeGUI.class.getResource (path);//Deetermines the path to the image
    if (imgURL != null)//Checks if its null
    {
      return new ImageIcon (imgURL);//Creates a imageIcon and returns it
    }
    else//Otherwise
    {
      System.out.println ("Couldn't find file: "+path);//Informs the user that it did not work
      return null;//Returns null
    }
  }//Closes function
}//Closes class
