package com.grandvauxc.companyutility.exceptions;

import lombok.Getter;

@Getter
public class EntityNotFoundException extends RuntimeException{

    private final transient Class<?> entityClass;

    private final transient Object entityId;

    public EntityNotFoundException(Class<?> entityClass, Object entityId) {
        this.entityClass = entityClass;
        this.entityId = entityId;
    }

    public EntityNotFoundException(String message, Class<?> entityClass, Object entityId) {
        super(message);
        this.entityClass = entityClass;
        this.entityId = entityId;
    }

    public EntityNotFoundException(String message, Throwable cause, Class<?> entityClass, Object entityId) {
        super(message, cause);
        this.entityClass = entityClass;
        this.entityId = entityId;
    }

    public EntityNotFoundException(Throwable cause, Class<?> entityClass, Object entityId) {
        super(cause);
        this.entityClass = entityClass;
        this.entityId = entityId;
    }

    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace, Class<?> entityClass, Object entityId) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.entityClass = entityClass;
        this.entityId = entityId;
    }
}
