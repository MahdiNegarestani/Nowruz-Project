package org.project;

public class IDR {

    private final boolean success;
    private final String message;

    public IDR(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public boolean isSuccess() {return success;}

    public String getMessage() {return message;}

    public static IDR creatSeccesIDR(String message){
        return new IDR(true, message);
    }

    public static IDR creatFailedIDR(String message){
        return new IDR(false, message);
    }

}