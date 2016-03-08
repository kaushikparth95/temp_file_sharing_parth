package com.project;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Controller_download
 */
@WebServlet("/Controller_download")
public class Controller_download extends HttpServlet {
	private static final long serialVersionUID = 165623787868233232L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller_download() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("application/download");
		String file_destination=request.getParameter("file_download");
		File file=new File(file_destination);
		ServletOutputStream out=response.getOutputStream();
		FileInputStream in=new FileInputStream(file);
		response.setContentLengthLong(file.length());
		response.setHeader("Content-Disposition","attachment;filename=\"" + file.getName() + "\"");
		if(!file.exists()){
			System.out.println("file not found");
		}
		else System.out.println("file found");
		int ch=in.read();
		while(ch!=-1){
			out.write(ch);
			ch=in.read();
		}
		out.flush();
		in.close();
		out.close();
		
		
	}

}
