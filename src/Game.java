package src;

import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

 

public class Game implements ActionListener{
    Random _random = new Random();
    JFrame _frame = new JFrame("Game");
    JPanel _tittle = new JPanel();
    JPanel _button_panel = new JPanel();
    JLabel _textfield = new JLabel();
    JButton[] _button = new JButton[9];
    JButton _playAgainButton = new JButton("Play Again");
    boolean _player1Turn = true;


    Game(){
        _frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        _frame.setSize(500,500);
        _frame.getContentPane().setBackground(new Color(50,50,50));
        _frame.setLayout(new BorderLayout());
        _frame.setVisible(true);

        _textfield.setBackground(new Color(25,25,25));
        _textfield.setForeground(new Color(25,255,1));
        _textfield.setFont(new Font("Ink Free",Font.BOLD,50));
        _textfield.setHorizontalAlignment(JLabel.CENTER);
        _textfield.setForeground(Color.CYAN);
        _textfield.setText("Tic Tac Toe");
        _textfield.setOpaque(true);

        _tittle.setLayout(new BorderLayout());
        _tittle.setBounds(0,0,500,200);

        _button_panel.setLayout(new GridLayout(3,3));
        _button_panel.setBackground(new Color(150,150,150));

        for(int index=0;index<9;index++){
            _button[index] = new JButton();
            _button_panel.add(_button[index]);
            _button[index].setFont(new Font("MV Boli",Font.ITALIC,120));
            _button[index].setFocusable(true);
            _button[index].addActionListener(this);

        }

        _tittle.add(_textfield);
        _frame.add(_tittle,BorderLayout.NORTH);
        _frame.add(_button_panel);

        _playAgainButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        _playAgainButton.setFocusable(true);
        _playAgainButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetGame();
            }
        });


        Turn1();
    
}
    
    @Override
    public void actionPerformed(ActionEvent e){
        for(int index=0;index<9;index++){
            if(e.getSource()==_button[index]){
                if(_player1Turn){
                    if(_button[index].getText()==""){
                        _button[index].setForeground(new Color(255,0,255));
                        _button[index].setFont(new Font("Jokerman", Font.BOLD, 80));
                        _button[index].setText("X");
                        _player1Turn = false;
                        _textfield.setText("Player 2 turn (O)");
                        check();
                    }
                }
                else {
                    if(_button[index].getText()==""){
                        _button[index].setForeground(new Color(0,0,255));
                        _button[index].setFont(new Font("Jokerman", Font.BOLD, 80));
                        _button[index].setText("O");
                        _player1Turn = true;
                        _textfield.setText("Player 1 turn (X)");
                        check();
                    }
                }
            }
        }
    }


    public void Turn1(){
        try{
            Thread.sleep(2000);
        }
        catch(InterruptedException e){
            e.printStackTrace();
        }


        if(_random.nextInt(2)==0){
            _player1Turn = true;
            _textfield.setText("Player 1 turn (X)");
        }
        else{
            _player1Turn = false;
            _textfield.setText("Player 2 turn (O)");
        }

    }

    public void check(){
        // if X wins
        if((_button[0].getText()=="X") && (_button[1].getText()=="X") && (_button[2].getText()=="X")){
            XWins(0,1,2);
        }
        if((_button[3].getText()=="X") && (_button[4].getText()=="X") && (_button[5].getText()=="X")){
            XWins(3,4,5);
        }
        if((_button[6].getText()=="X") && (_button[7].getText()=="X") && (_button[8].getText()=="X")){
            XWins(6,7,8);
        }
        if((_button[0].getText()=="X") && (_button[3].getText()=="X") && (_button[6].getText()=="X")){
            XWins(0,3,6);
        }
        if((_button[1].getText()=="X") && (_button[4].getText()=="X") && (_button[7].getText()=="X")){
            XWins(1,4,7);
        }
        if((_button[2].getText()=="X") && (_button[5].getText()=="X") && (_button[8].getText()=="X")){
            XWins(2,5,8);
        }
        if((_button[0].getText()=="X") && (_button[4].getText()=="X") && (_button[8].getText()=="X")){
            XWins(0,4,8);
        }
        if((_button[2].getText()=="X") && (_button[4].getText()=="X") && (_button[6].getText()=="X")){
            XWins(2,4,6);
        }

        // if O wins
        if((_button[0].getText()=="O") && (_button[1].getText()=="O") && (_button[2].getText()=="O")){
            OWins(0,1,2);
        }
        if((_button[3].getText()=="O") && (_button[4].getText()=="O") && (_button[5].getText()=="O")){
            OWins(3,4,5);
        }
        if((_button[6].getText()=="O") && (_button[7].getText()=="O") && (_button[8].getText()=="O")){
            OWins(6,7,8);
        }
        if((_button[0].getText()=="O") && (_button[3].getText()=="O") && (_button[6].getText()=="O")){
            OWins(0,3,6);
        }
        if((_button[1].getText()=="O") && (_button[4].getText()=="O") && (_button[7].getText()=="O")){
            OWins(1,4,7);
        }
        if((_button[2].getText()=="O") && (_button[5].getText()=="O") && (_button[8].getText()=="O")){
            OWins(2,5,8);
        }
        if((_button[0].getText()=="O") && (_button[4].getText()=="O") && (_button[8].getText()=="O")){
            OWins(0,4,8);
        }
        if((_button[2].getText()=="O") && (_button[4].getText()=="O") && (_button[6].getText()=="O")){
            OWins(2,4,6);
        }

    else if(isBoardFull()) {
            draw();
    }    


 }

    public void XWins(int button1, int button2, int button3){
        _button[button1].setBackground(Color.GREEN);
        _button[button2].setBackground(Color.GREEN);
        _button[button3].setBackground(Color.GREEN);

        for(int index =0;index<9;index++){
            _button[index].setEnabled(false);
        } 

        _textfield.setForeground(Color.GREEN);
        _textfield.setText("Player 1 Wins");
        showPlayAgainButton();

    }

    public void OWins(int button1, int button2, int button3){
        _button[button1].setBackground(Color.RED);
        _button[button2].setBackground(Color.RED);
        _button[button3].setBackground(Color.RED);

        for(int index =0;index<9;index++){
            _button[index].setEnabled(false);
        }
         
        _textfield.setForeground(Color.RED);
        _textfield.setText("Player 2 Wins");
        showPlayAgainButton();


    }

    public void showPlayAgainButton() {
        _frame.add(_playAgainButton, BorderLayout.SOUTH);
        _frame.revalidate();
        _frame.repaint();
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 9; i++) {
            if (_button[i].getText().isEmpty()) {
                return false;
            }
        }
        return true;
    }
    
    public void draw() {
        for (int index = 0; index < 9; index++) {
            _button[index].setEnabled(false);
        }

        _textfield.setForeground(Color.YELLOW);
        _textfield.setText("Draw");
        showPlayAgainButton();
    }

    
    public void resetGame() {
        for (int i = 0; i < 9; i++) {
            _button[i].setText("");
            _button[i].setEnabled(true);
            _button[i].setBackground(new Color(238, 238, 238)); // default button color
        }
        _textfield.setForeground(Color.CYAN);
        _textfield.setText("Tic Tac Toe");
        _frame.remove(_playAgainButton);
        _frame.revalidate();
        _frame.repaint();
        Turn1();
    }


}
