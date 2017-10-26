package cn.lfsenior.core.exception;

/**
 * 核心异常类
 * @author LF.zero
 *
 */
public abstract class SysException extends Exception {
	private String errorMsg;
	public SysException(){
	}
	
	public SysException(String message,Throwable cause){
		super(message, cause);
		errorMsg=message;
	}
	
	public SysException(String message){
		super(message);
		errorMsg=message;
	}
	
	public SysException(Throwable cause){
		super(cause);
	}

	public String getErrorMsg() {
		return errorMsg;
	}

	public void setErrorMsg(String errorMsg) {
		this.errorMsg = errorMsg;
	}
	
	
}
