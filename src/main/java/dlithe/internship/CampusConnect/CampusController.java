package dlithe.internship.CampusConnect;

import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
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
	HttpSession session;
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
	@RequestMapping("/")
	public ModelAndView login()
	{
		return new ModelAndView("index");
	}
	@RequestMapping(value="/log",method=RequestMethod.POST)
	public ModelAndView home(@RequestParam("user") String user, @RequestParam("pass") String pass, HttpServletRequest request)
	{
		if(user.equalsIgnoreCase("dlithe")&&pass.equalsIgnoreCase("bangalore"))
		{
			session=request.getSession();
			session.setAttribute("user", user);
			return new ModelAndView("home");
		}
		else {return new ModelAndView("index").addObject("msg", "Invalid Credentials");}
	}
	@RequestMapping("/add")
	public ModelAndView askEnroll()
	{
		if(session.getAttribute("user")!=null) {return new ModelAndView("enroll");}
		else {return new ModelAndView("index");}
	}
	@RequestMapping(value="/added",method=RequestMethod.POST)
	public ModelAndView enrolled(@Valid Candidates candidates, BindingResult res)
	{
		if(session.getAttribute("user")!=null)
		{
			if(res.hasErrors()) {return new ModelAndView("enroll"); }
			camp.insert(candidates);
			return new ModelAndView("enroll").addObject("msg", "Candidates Enrolled");
		}
		else {return new ModelAndView("index");}
	}
	@RequestMapping("/list")
	public ModelAndView display()
	{
		if(session.getAttribute("user")!=null) 
		{
			temp=camp.showAll();
			return new ModelAndView("show").addObject("every", temp);
		}
		else {return new ModelAndView("index");}
	}
	@RequestMapping("/update")
	public ModelAndView info(@RequestParam("reg") Long reg)
	{
		if(session.getAttribute("user")!=null) {return new ModelAndView("letting").addObject("fetched", camp.readOne(reg));}
		else {return new ModelAndView("index");}
	}
	@RequestMapping(value="/alter",method=RequestMethod.POST)
	public ModelAndView alter(Candidates candidates)
	{
		if(session.getAttribute("user")!=null)
		{
			camp.change(candidates);
			return display().addObject("msg", candidates.getName()+" Updated SuccessFully");
		}
		else {return new ModelAndView("index");}
	}
	@RequestMapping("/remove")
	public ModelAndView flush(@RequestParam("reg") Long reg)
	{
		if(session.getAttribute("user")!=null)
		{
			Candidates can=camp.readOne(reg);
			String got=camp.erase(can);
			return display().addObject("msg", got+" Deleted Successfully");
		}
		else {return new ModelAndView("index");}
	}
	@RequestMapping("/find")
	public ModelAndView search()
	{
		if(session.getAttribute("user")!=null) {return new ModelAndView("search");}
		else {return new ModelAndView("index");}
	}
	@RequestMapping(value="/fetch",method=RequestMethod.POST)
	public ModelAndView reads(@RequestParam("regno") String regno,@RequestParam("department") String department,@RequestParam("career") String career,@RequestParam("status") String status)
	{
		if(session.getAttribute("user")!=null)
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
		else {return new ModelAndView("index");}
	}
	@RequestMapping("/report")
	public ModelAndView rep(@RequestParam("form") String form)
	{
		if(session.getAttribute("user")!=null)
		{
			ModelAndView mod=new ModelAndView("show");
			System.out.println("Before report calls"+temp);
			String get=camp.generate(temp, form);
			mod.addObject("every", temp);
			mod.addObject("msg", get);
			System.out.println("Done in report navigate back to show with "+temp);
			return mod;
		}
		else {return new ModelAndView("index");}
	}
	@RequestMapping("/home")
	public ModelAndView home()
	{
		if(session.getAttribute("user")!=null)
		{
			return new ModelAndView("home");
		}
		else {return new ModelAndView("index");}
	}
	@RequestMapping("/logout")
	public ModelAndView loggingOut()
	{
		session.removeAttribute("user");
		session.setAttribute("user", null);
		return new ModelAndView("index").addObject("msg", "Loggedout successfully");
	}
}