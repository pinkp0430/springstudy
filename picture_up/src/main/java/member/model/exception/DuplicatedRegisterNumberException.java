package member.model.exception;

public class DuplicatedRegisterNumberException extends Exception {
	public DuplicatedRegisterNumberException(){}
	public DuplicatedRegisterNumberException(String message){
		super(message);
	}
}
