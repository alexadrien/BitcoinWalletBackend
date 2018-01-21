package io.swagger.api;

import io.swagger.model.Transaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.MongoDB;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.*;
import javax.validation.Valid;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-01-21T13:41:11.054+01:00")

@Controller
public class TransactionApiController implements TransactionApi {

    private static final Logger log = LoggerFactory.getLogger(TransactionApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public TransactionApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<List<Transaction>> transactionNicknameGet(@ApiParam(value = "", required = true) @PathVariable("nickname") String nickname) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            MongoDB mongoDB = new MongoDB();
            LinkedList<Transaction> allTransactionsFromNickname = mongoDB.getAllTransactionsFromNickname(nickname);
            return new ResponseEntity<List<Transaction>>(allTransactionsFromNickname, HttpStatus.ACCEPTED);
        }

        return new ResponseEntity<List<Transaction>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Transaction> transactionPost(@ApiParam(value = "transaction to add", required = true) @Valid @RequestBody Transaction body) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            Transaction t = new Transaction();
            t.setOwner(body.getOwner());
            t.setBtc(body.getBtc());
            t.setTimestamp(body.getTimestamp());
            t.setType(body.isType());
            t.setUsd(body.getUsd());
            MongoDB mongoDB = new MongoDB();
            if (mongoDB.insertOneTransation(t)) {
                return new ResponseEntity<Transaction>(t, HttpStatus.ACCEPTED);
            } else {
                return new ResponseEntity<Transaction>(t, HttpStatus.I_AM_A_TEAPOT);
            }
        }

        return new ResponseEntity<Transaction>(HttpStatus.NOT_IMPLEMENTED);
    }

}
