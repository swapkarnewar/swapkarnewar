import java.util.Arrays;

class Outer {
	public void meth(){
		System.out.println("in outer meth");
	}
	class Inner {
		public final String text = "Inner";
		public void meth(){
			System.out.println("in inner meth");
		}
	}
}

public class Test3{
	public static void main1(String[] args) {
		//Base.buildBattleBoard();
		String str = null;
		if( str instanceof Object ){
			System.out.println( "Yes" );
		}
		else{
			System.out.println( "No" );
		}
	}
}

class Base{
	static char[][] battleBoard = new char[10][10];
	
	public static void buildBattleBoard(){
	
		for(char[] row : battleBoard)
		{
			Arrays.fill(row, '*');
		}
		
		for(int i = 0; i < battleBoard.length; i++){
			for(int j = 0; j < battleBoard[i].length; j++){
				System.out.print("|" + battleBoard[i][j] + "|");
			}
			System.out.println();
		}
	}
}

