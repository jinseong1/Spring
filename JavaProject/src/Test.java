import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Test {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeySpecException {
		System.out.println(PBKDF2.createHash("1232134"));
		System.out.println(PBKDF2.createHash("1234"));
		System.out.println(PBKDF2.createHash("1234"));
		System.out.println(PBKDF2.createHash("1234"));
		//2e96db181305a63f574b3312bf0f4a9773d8500062becd3f:e722e63ee8d49e281a7388185e09c27fedb851a4daeec08631744bbecdeedc752285d4c6e28854d5ea3b60314096d3b1ff70730e611adcb2ba3514d89b8619ad
		//2e96db181305a63f574b3312bf0f4a9773d8500062becd3f
		//:
		//e722e63ee8d49e281a7388185e09c27fedb851a4daeec08631744bbecdeedc752285d4c6e28854d5ea3b60314096d3b1ff70730e611adcb2ba3514d89b8619ad
		System.out.println(PBKDF2.validatePassword("1232134", "2e96db181305a63f574b3312bf0f4a9773d8500062becd3f:e722e63ee8d49e281a7388185e09c27fedb851a4daeec08631744bbecdeedc752285d4c6e28854d5ea3b60314096d3b1ff70730e611adcb2ba3514d89b8619ad"));
		System.out.println(PBKDF2.validatePassword("1234", "bb076168c5fd48c68075f84a4d88abc6092d4ecf7aa50969:f49c453ab401ceaacc06ec32fc01b0e742b295ccf5b8c28ce3534fac36890a950b35d00175833baacd9d90a7d6a13e1bde140660361a7cf3468aaacd9fa815e7"));
		
	}

}
