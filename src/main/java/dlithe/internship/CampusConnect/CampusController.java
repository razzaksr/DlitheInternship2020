package dlithe.internship.CampusConnect;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CampusController 
{
	@RequestMapping("/begin")
	public ModelAndView initiate()
	{
		ModelAndView mod=new ModelAndView("one");
		return mod;
	}
	@RequestMapping("/second")
	public ModelAndView second()
	{
		return new ModelAndView("second");
	}
}
