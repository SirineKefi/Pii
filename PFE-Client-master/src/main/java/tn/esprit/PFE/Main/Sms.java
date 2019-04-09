package tn.esprit.PFE.Main;



import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
public class Sms {

	 public static final String ACCOUNT_SID =
	            "AC577b83652e652cfc84e0b5501c6a2be4";
	    public static final String AUTH_TOKEN =
	            "c87f5a1c6aa382b34d8b7f194b05847d";
		public static void main(String[] args) {
			  Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
			  System.out.println("oussama");
		        Message message = Message
		                .creator(new PhoneNumber("+21629072808"), 
		                        new PhoneNumber("+12015155237"), 
		                        "yes we can ya bougalb...")
		                .create();

		        System.out.println(message.getSid());
		        

		}

}
