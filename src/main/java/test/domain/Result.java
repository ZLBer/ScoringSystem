package test.domain;

/**
 * 成功0 失败1
 *
 */
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

    public static Result CreateSuccessResult(){
        return new Result(0,"提示","操作成功");
    }

    public static Result CreateFailureResult(){
        return new Result(0,"提示","操作失败");
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
