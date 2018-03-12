import java.util.Random;

public class MoveWords{

    public static final int EMPATE = 0;
    public static final int GANA = 1;
    public static final int PIERDE = 2;

    private static final String[] validMoves = {"TIJERAS", "PAPEL", "PIEDRA", "LAGARTIJA", "TORITO"};
    private static final String[] validCommands = {"SALIR", "HELP"};

    private Random rnd;
    
    public MoveWords(){
    	rnd = new Random();
    }
    
    public boolean isValidMoveCommand(String value){

	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
	    	    return true;
	    }
	    
	    for (int i =0; i< validCommands.length; i++){
	        if(validCommands[i].equals(value))
		        return true;
	    }
	    
	    return false;
    }

    public String randomMove(){
	    float p = rnd.nextFloat();
	    return validMoves[ (int) (p * validMoves.length)];
    }

    public void showMoves(){
        for (String move : validMoves)
	        System.out.print(move+" ");
	    System.out.println();
    }
    public void showCommands(){
	    for (String cmd : validCommands)
	        System.out.print(cmd+" ");
	    System.out.println();
    }

    public void showWords(){
        showMoves();
        showCommands();    
    }

    private static int getIndex(String value){
	    for (int i =0; i< validMoves.length; i++){
	        if(validMoves[i].equals(value))
		        return i;
	    }
    	return -1;
    }

    public static int checkWinner(String first, String second){
	    int first_i, second_i;

	    first_i = getIndex(first);
	    second_i = getIndex(second);
	    
	    if (first_i == second_i) return EMPATE;
	    
	    //Si el usuario elige Tijeras y sale Piedra
	    if(first_i == 0 && second_i == 2){return PIERDE;}
	    
	    //Si el usuario elige Tijeras y sale Lagartija
	    if(first_i == 0 && second_i == 3){ return GANA;}
	    
	    //Si el usuario elige Papel y sale Torito
	    if(first_i == 1 && second_i == 4){ return GANA;}
	    
	    //Si el usuario elige Papel y sale Lagartija
	    if(first_i == 1 && second_i == 3){ return PIERDE;}
	    
	    //Si el usuario elige Piedra y sale Tijeras
	    if(first_i == 2 && second_i == 0){ return GANA;}
	    
	    //Si el usuario elige Piedra y sale Torito
	    if(first_i == 2 && second_i == 4){ return PIERDE;}
	    
	    //Si el usuario elige Lagartija y sale Papel
	    if(first_i == 3 && second_i == 1){ return GANA;}
	    
	    //Si el usuario elige Lagartija y sale Tijeras
	    if(first_i == 3 && second_i == 0){ return PIERDE;}
	    
	    //Si el usuario elige Torito y sale Papel
	    if(first_i == 4 && second_i == 1){ return PIERDE;}
	    
	    //Si el usuario elige Torito y sale Piedra
	    if(first_i == 4 && second_i == 2){ return GANA;}
	    //Si no es ninguno anterior:
	    else {
	    	return (( (first_i +1) % validMoves.length ) == second_i ) ? GANA: PIERDE;
	    }
	}
	
} 
