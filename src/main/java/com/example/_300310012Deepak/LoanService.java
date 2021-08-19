package com.example._300310012Deepak;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoanService {

    private static List<Loan> todos = new ArrayList<Loan>();

    private static int todoCount = 5;

    static {
        todos.add(new Loan("1157", "Joy Ramirez",100000.0,5,"Business"));
        todos.add(new Loan("1005", "Josaphet Dee",5000.0,5,"Business"));
    }

    public void initialadd(){

        todos.add(new Loan("1157", "Joy Ramirez",100000.0,5,"Business"));
        todos.add(new Loan("1005", "Josaphet Dee",5000.0,5,"Business"));
    }

    public void update(Loan todo){

        todos.remove(todo);
        todos.add(todo);
    }

    public void deleteTodo(String clientno) {

        for (int i = 0; i < todos.size(); i++) {

            if(clientno.equals(todos.get(i).getClientNo())) {

                todos.remove(i);
                break;
            }
        }
    }

    public List<Loan> retrieveTodos() {
        List<Loan> filteredTodos = new ArrayList<Loan>();
        for (Loan todo : todos) {
            filteredTodos.add(todo); }
        return filteredTodos; }

    public void addTodo(String clientno, String clientname ,double loanamount, int years, String loantype) {

        todos.add(new Loan(clientno, clientname,loanamount,years,loantype));

    }

    public Loan retrieve(String clientno){

        for(Loan todo: todos){

            if(todo.getClientNo().equals(clientno)){
                return todo;
            }
        }
        return null;
    }



}
