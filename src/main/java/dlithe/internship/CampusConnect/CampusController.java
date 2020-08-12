package dlithe.internship.CampusConnect;

import java.util.List;
import java.util.Vector;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CampusController 
{
	@Autowired
	CampService camp;
	List<Candidates> temp;
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
		temp=camp.showAll();
		return new ModelAndView("show").addObject("every", temp);
	}
	@RequestMapping("/update")
	public ModelAndView info(@RequestParam("reg") Long reg)
	{
		return new ModelAndView("letting").addObject("fetched", camp.readOne(reg));
	}
	@RequestMapping(value="/alter",method=RequestMethod.POST)
	public ModelAndView alter(Candidates candidates)
	{
		camp.change(candidates);
		return display().addObject("msg", candidates.getName()+" Updated SuccessFully");
	}
	@RequestMapping("/remove")
	public ModelAndView flush(@RequestParam("reg") Long reg)
	{
		Candidates can=camp.readOne(reg);
		String got=camp.erase(can);
		return display().addObject("msg", got+" Deleted Successfully");
	}
	@RequestMapping("/find")
	public ModelAndView search()
	{
		return new ModelAndView("search");
	}
	@RequestMapping(value="/fetch",method=RequestMethod.POST)
	public ModelAndView reads(@RequestParam("regno") String regno,@RequestParam("department") String department,@RequestParam("career") String career,@RequestParam("status") String status)
	{
		temp=new Vector<Candidates>();
		if(!regno.equals("")&&department.equals("Select Any Department")&&career.equals("Select Any Career")&&status.equals("Select Any Status"))
		{
			Candidates tmp=camp.readOne(Long.parseLong(regno));
			temp.add(tmp);
		}
		else if(regno.equals("")&&!department.equals("Select Any Department")&&career.equals("Select Any Career")&&status.equals("Select Any Status"))
		{
			temp=camp.fetchViaDepartment(department);
			//camp.fetchViaDepartment(department).forEach(temp::add);
		}
		else if(regno.equals("")&&department.equals("Select Any Department")&&!career.equals("Select Any Career")&&status.equals("Select Any Status"))
		{
			temp=camp.fetchViaCareer(career);
		}
		else if(regno.equals("")&&department.equals("Select Any Department")&&career.equals("Select Any Career")&&!status.equals("Select Any Status"))
		{
			temp=camp.fetchViaStatus(status);
		}
		return new ModelAndView("show").addObject("every", temp);
	}
}