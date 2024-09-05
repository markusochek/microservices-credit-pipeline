package com.example.coursework.client;

import com.example.coursework.answer.Answer;
import com.example.coursework.authentication.enumerations.Status;
import com.example.coursework.client.entities.borrower.Borrower;
import com.example.coursework.client.entities.borrowerIncome.BorrowersIncome;
import com.example.coursework.cookies.CookieController;
import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.servlet.http.HttpServletRequest;
import lombok.AllArgsConstructor;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api")
@AllArgsConstructor
public class ClientController {
    private final ClientService clientService;
    private Answer<Object> answerObject;
    private final CookieController cookieController;

    @PostMapping("client")
    public Object client(@RequestBody String object, HttpServletRequest request)
            throws JsonProcessingException, ParseException, IllegalAccessException {
        if(cookieController.checkToken(request) != null) {
            JSONObject jo = (JSONObject) (new JSONParser().parse(object));
            Borrower borrower = new Borrower(jo.get("borrower"));
            Borrower coBorrower = new Borrower(jo.get("coBorrower"));
            BorrowersIncome borrowersIncome = new BorrowersIncome(jo.get("borrowersIncome"));

            return answerObject.json(Status.OK, clientService.addClient(borrower, coBorrower, borrowersIncome));
        }
        return answerObject.json(Status.ERROR);
    }
}
