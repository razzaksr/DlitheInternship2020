package dlithe.internship.CampusConnect;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ResourceUtils;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@Service
public class CampService 
{
	@Autowired
	CampusRepo repo;
	public Candidates insert(Candidates candidates)
	{
		return repo.save(candidates);
	}
	public List<Candidates> showAll()
	{
		return repo.findAll();
	}
	public Candidates readOne(Long regno)
	{
		return repo.getOne(regno);
	}
	public Candidates change(Candidates candidates)
	{
		return repo.save(candidates);
	}
	public String erase(Candidates candidates)
	{
		String get=candidates.getName();
		repo.delete(candidates);
		return get;
	}
	public List<Candidates> fetchViaDepartment(String dept)
	{
		return repo.getByDepartment(dept);
	}
	public List<Candidates> fetchViaCareer(String career)
	{
		return repo.getByCareer(career);
	}
	public List<Candidates> fetchViaStatus(String status)
	{
		return repo.getByStatus(status);
	}
	public String generate(List<Candidates> can,String format)
	{
		File fgen=null;
        String hai="";
		try
		{
			File file = ResourceUtils.getFile("classpath:CampusReport.jrxml");
	        JasperReport jasperReport = JasperCompileManager.compileReport(file.getAbsolutePath());
	        JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(can);
	        Map<String, Object> parameters = new HashMap<>();
	        parameters.put("createdBy", "Arun Rajpurohit");
	        parameters.put("createdFor", "DLithe Consultancy Services");
	        System.out.println("Received @ report end before writing "+can);
	        JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, dataSource);
	        if (format.equalsIgnoreCase("html")) {
	        	fgen=new File("dlithe.html");
	            JasperExportManager.exportReportToHtmlFile(jasperPrint, fgen.getAbsolutePath());
	        }
	        if (format.equalsIgnoreCase("pdf")) {
	        	fgen=new File("dlithe.pdf");
	            JasperExportManager.exportReportToPdfFile(jasperPrint, fgen.getAbsolutePath());
	        }
	        hai="Report generated @ "+fgen.getAbsolutePath();
	        System.out.println("Received @ report end after writing "+can);
		}
		catch(JRException j)
		{j.printStackTrace();} 
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return hai;
	}
}