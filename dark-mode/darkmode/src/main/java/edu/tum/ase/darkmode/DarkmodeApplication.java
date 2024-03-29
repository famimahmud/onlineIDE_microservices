package edu.tum.ase.darkmode;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication; import org.springframework.web.bind.annotation.RequestMapping; import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@SpringBootApplication @RestController
public class DarkmodeApplication {
	//if true then darkmode
	private boolean toggledarkmode = false;
	public static void main(String[] args) { SpringApplication.run(DarkmodeApplication.class, args);
	}
	@RequestMapping(path = "/dark-mode/toggle", method = RequestMethod.GET) public void toggleDarkMode() throws InterruptedException {
		toggledarkmode = !toggledarkmode;
		try
		{
			Thread.sleep(3000);
		}
		catch(InterruptedException ex)
		{
			Thread.currentThread().interrupt();
		}

		// TODO: implement dark mode toggle
	}
	@RequestMapping(path =  "/dark-mode", method = RequestMethod.GET)public boolean getMode() {
		return toggledarkmode;
	}
	// TODO: implement endpoint which returns dark mode status
}