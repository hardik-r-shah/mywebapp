package com.bnpparibas.mywebapp.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import com.bnpparibas.mywebapp.uibean.Employee;

/**
 * Servlet implementation class MyWebAppController
 */
public class MyWebAppController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor. 
     */
    public MyWebAppController() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setTemplateMode("XHTML");
        templateResolver.setPrefix("/WEB-INF/");
        templateResolver.setSuffix(".html");
		TemplateEngine templateEngine = new TemplateEngine();
		templateEngine.setTemplateResolver(templateResolver);
		WebContext webContext = new WebContext(request, response, getServletContext(), request.getLocale());
		
		List<Employee> empList = new ArrayList<Employee>();
		
		Employee emp1 = new Employee();
		emp1.setEmpId(1);
		emp1.setAge(28);
		emp1.setEmpName("Hardik");
		emp1.setSalary(100000);
		
		Employee emp2 = new Employee();
		emp2.setEmpId(2);
		emp2.setAge(28);
		emp2.setEmpName("eKTA");
		emp2.setSalary(100000);
		
		Employee emp3 = new Employee();
		emp3.setEmpId(3);
		emp3.setAge(28);
		emp3.setEmpName("nIKUNJ");
		emp3.setSalary(100000);
		
		empList.add(emp1);
		empList.add(emp2);
		empList.add(emp3);
		
		webContext.setVariable("employees", empList);
		templateEngine.process("thymeleaf",webContext,response.getWriter());
		response.setContentType("text/html;charset=UTF-8");
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
