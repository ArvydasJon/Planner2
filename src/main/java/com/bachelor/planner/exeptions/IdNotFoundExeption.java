package com.bachelor.planner.exeptions;


import io.github.wimdeblauwe.errorhandlingspringbootstarter.ResponseErrorCode;
import io.github.wimdeblauwe.errorhandlingspringbootstarter.ResponseErrorProperty;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


/*
Čia subėriau patobulinimus. By default wimdeblauwe tvarkosi gerai.
@ResponseStatus - nustato norimą statusą
@ResponseErrorCode pakeičia error kodą šiuo atveju default buvo: ID_NOT_FOUND_EXEPTION,
t.y paėmė pagal klasės pavadinimą
 @ResponseErrorProperty prideaa prie Jason, labai naudinga.
 */
@ResponseStatus(HttpStatus.NOT_FOUND)
@ResponseErrorCode("Projekto su tokiu Id neradau")
public class IdNotFoundExeption  extends RuntimeException {
  /*  public IdNotFoundExeption(Long projectId) {
        super("Could not find user with id " + projectId);  */
        /*    public IdNotFoundExeption(String message) {
            super(message); */

                   public IdNotFoundExeption(Long id) {
                    super("Neradau "+ id);

    }
    @ResponseErrorProperty
    public HttpStatus getStatus() {
        return HttpStatus.NOT_FOUND;
    }
}
