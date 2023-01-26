package ifpb.edu.br.atlasboard.exceptions;

public class ExistingUserException extends Exception {
    
    public ExistingUserException (String msg) {
        super(msg);
    }
}
