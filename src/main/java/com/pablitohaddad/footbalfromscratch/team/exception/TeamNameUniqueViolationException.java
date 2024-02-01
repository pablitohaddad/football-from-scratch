package com.pablitohaddad.footbalfromscratch.team.exception;

import org.springframework.dao.DataIntegrityViolationException;

public class TeamNameUniqueViolationException extends DataIntegrityViolationException {
    public TeamNameUniqueViolationException(String message) {
        super(message);
    }
}
