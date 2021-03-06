import java.io.InputStreamReader;
import java.io.BufferedReader;

public class Clavier{
	private static BufferedReader flux = new BufferedReader(new InputStreamReader(System.in));
        private Clavier(){}

	public static byte saisirByte(){
		byte b = 0;
		boolean ko = true;
		while (ko) {
			try{
				b = Byte.valueOf(flux.readLine()).byteValue();
				ko = false;
			} catch(Exception e){
				System.err.println("Erreur : la valeur saisie n'est pas un byte. Recommencez.");
			}
		}
		return b;
	}

	public static short saisirShort(){
		short s = 0;
		boolean ko = true;
		while (ko) {
			try{
				s = Short.valueOf(flux.readLine()).shortValue();	
				ko = false;
			} catch(Exception e){
				System.err.println("Erreur : la valeur saisie n'est pas un short. Recommencez."); 
			}
		}
		return s;
	}

	public static int saisirInt(){
		int i = 0;
		boolean ko = true;
		while (ko) {
			try{
				i = Integer.valueOf(flux.readLine()).intValue();	
				ko = false;
			} catch(Exception e){
				System.err.println("Erreur : la valeur saisie n'est pas un int. Recommencez.");
			}
		}
		return i;
	}

	public static long saisirLong(){
		long l = 0;
		boolean ko = true;
		while (ko) {
			try{
				l = Long.valueOf(flux.readLine()).longValue();
				ko = false;
			} catch(Exception e){
				System.err.println("Erreur : la valeur saisie n'est pas un long. Recommencez.");	
			}
		}
		return l;
	}

	public static double saisirDouble(){
		double d = 0;
		boolean ko = true;
		while (ko) {
			try{
				d = Double.valueOf(flux.readLine()).doubleValue();
				ko = false;
			} catch(Exception e){
				System.err.println("Erreur : la valeur saisie n'est pas un double. Recommencez.");
			}
		}
		return d;
	}

	public static float saisirFloat(){
		float f = 0;
		boolean ko = true;
		while (ko) {
			try{
				f = Float.valueOf(flux.readLine()).floatValue();
				ko = false;
			} catch(Exception e){
				System.err.println("Erreur : la valeur saisie n'est pas un float. Recommencez.");	
			}
		}
		return f;
	}

	public static char saisirChar(){
		char c = ' ';
		boolean ko = true;
		while (ko) {
			try{
				String line = flux.readLine();
				if (line.length() > 0) {
					c = line.charAt(line.length()-1);
					ko = false;
				}
			} catch(Exception e){
				System.err.println("Erreur : la valeur saisie n'est pas un char. Recommencez.");
			}
		}
		return c;
	}

	public static String saisirString(){
		String s = "";
		boolean ko = true;
		while (ko) {
			try{
				s = flux.readLine();
				ko = false;
			} catch(Exception e){
				System.err.println("Erreur : la valeur saisie n'est pas une chaine. Recommencez.");	
			}
		}
		return s;
	}

	
}