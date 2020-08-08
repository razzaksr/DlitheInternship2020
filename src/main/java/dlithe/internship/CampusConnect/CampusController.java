package dlithe.internship.CampusConnect;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CampusController 
{
	@Autowired
	CampService camp;
	@RequestMapping("/begin")
	public ModelAndView initiate()
	{
		ModelAndView mod=new ModelAndView("one");
		mod.addObject("user", "Razak Mohamed");
		long mobile=9876545674L;
		mod.addObject("mob",mobile);
		return mod;
	}
	@RequestMapping("/second")
	public ModelAndView second()
	{
		return new ModelAndView("second");
	}
	@RequestMapping("/add")
	public ModelAndView askEnroll()
	{
		return new ModelAndView("enroll");
	}
	@RequestMapping(value="/added",method=RequestMethod.POST)
	public ModelAndView enrolled(@Valid Candidates candidates, BindingResult res)
	{
		if(res.hasErrors()) {return new ModelAndView("enroll"); }
		camp.insert(candidates);
		return new ModelAndView("enroll").addObject("msg", "Candidates Enrolled");
	}
	@RequestMapping("/list")
	public ModelAndView display()
	{
		List<Candidates> temp=camp.showAll();
		return new ModelAndView("show").addObject("every", temp);
	}
}
