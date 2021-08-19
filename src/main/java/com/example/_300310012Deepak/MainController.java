package com.example._300310012Deepak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@SessionAttributes({"no","name","amount","years","type","errMsg","errorMessage"})

@RequestMapping
@Controller
public class MainController {

    LoanImplementation service1;

    @Autowired
    LoanService service;


    Connection connect;

    @RequestMapping(value = "/Loan", method = RequestMethod.GET)
    public String showloanPage(ModelMap model, @RequestParam(defaultValue = "")
            String id) throws ClassNotFoundException, SQLException {

        service1 = new LoanImplementation(connect.Connection());
        model.addAttribute("todos", service1.display());
        List<Loan> filteredTodos = new ArrayList<Loan>();
        filteredTodos = (List) model.get("todos");
        model.put("no",filteredTodos.get(0).getClientNo());
        model.put("name",filteredTodos.get(0).getClientName());
        model.put("amount",filteredTodos.get(0).getLoanAmount());
        model.put("years",filteredTodos.get(0).getYears());
        model.put("type",filteredTodos.get(0).getLoantype());

        return "Loan";
    }

    @RequestMapping(value ="/add-todo", method = RequestMethod.POST)
    public String addTodo(ModelMap model, @RequestParam String clientno, @RequestParam String clientname
            , @RequestParam double loanamount,@RequestParam int years,@RequestParam String loantype)
            throws SQLException, ClassNotFoundException {

        if (!((service1.search(clientno)) ==null))
        {
            model.put("errorMessage","Record Existing");

            return "Loan";
        }

        Loan cc = new Loan(clientno,clientname,loanamount,years,loantype);

        service1.add(cc);
        model.clear();

        return "Loan";

    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.GET)
    public String showUpdateTodoPage(ModelMap model, @RequestParam(defaultValue = "") String clientno)
            throws SQLException, ClassNotFoundException {


        model.put("no", clientno);
        Loan cc = service1.search(clientno);

        model.put("name",cc.getClientName());

        model.put("amount", cc.getLoanAmount());
        model.put("years", cc.getYears());
        model.put("type", cc.getLoantype());

        return "Loanedit";

    }

    @RequestMapping(value = "/update-todo", method = RequestMethod.POST)
    public String showUpdate(ModelMap model, @RequestParam String clientno, @RequestParam String clientname
            , @RequestParam double loanamount,@RequestParam int years,@RequestParam String loantype)
            throws SQLException, ClassNotFoundException
    {


        String cclientno = (String) model.get("no");
        String cclientname = (String) model.get("name");
        String cloanamount = (String) model.get("amount");
        String cyears = (String) model.get("years");
        String cloantype = (String) model.get("type");
        Loan cc = new Loan(clientno,clientname,loanamount,years,loantype);
        service1.edit(cc,cclientno,loanamount,years,loantype);

        return "redirect:/";

    }

    @RequestMapping(value ="/delete-todo", method = RequestMethod.GET)
    public String deleteTodo(ModelMap model, @RequestParam String clientno)
            throws SQLException, ClassNotFoundException {

        service1.delete(clientno);
        model.clear();

        return "redirect:/";

    }



}
