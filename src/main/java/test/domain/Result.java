package test.domain;


public class Result {
    private int state;
    private String operation;
    private String msg;

    public Result(){};

    public Result(int state, String operation, String msg){
        this.state = state;
        this.operation = operation;
        this.msg = msg;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
