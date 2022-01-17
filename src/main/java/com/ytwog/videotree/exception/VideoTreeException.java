package com.ytwog.videotree.exception;

public class VideoTreeException extends RuntimeException {
    public VideoTreeException() {
        super();
    }

    public VideoTreeException(String message) {
        super(message);
    }

    public VideoTreeException(String message, Throwable cause) {
        super(message, cause);
    }

    public VideoTreeException(Throwable cause) {
        super(cause);
    }

    protected VideoTreeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
