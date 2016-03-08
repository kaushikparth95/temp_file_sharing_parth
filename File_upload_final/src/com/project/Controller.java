package com.project;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
@MultipartConfig
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 156733417980922096L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Controller() {
        super();
        // TODO Auto-generated constructor stub
    }

		
	public void create_url(File file){
		System.out.println("Downloading link is :"+file.getAbsolutePath());
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		
		
		String destination_file_name=request.getPart("uploaded_file").getSubmittedFileName();
		/*String[] split_destination_file_name=destination_file_name.split("\\.");
		
		
		for(int j=0;j<split_destination_file_name.length;j++){
			
			System.out.println("file name is given by :"+split_destination_file_name[j]);
		}*/
		InputStream in=request.getPart("uploaded_file").getInputStream();
		File temp_dir=new File("C:\\Users\\Parth Kaushik\\Desktop\\Temp Folder");
		if(!temp_dir.exists()){
			boolean result=false;
				try{
					temp_dir.mkdir();
					result=true;
				}catch(Exception ex){
					System.out.println("error in creating temp directory !!");
				}
				
				if(result){
					System.out.println("Directory created");
				}
		}
		
		File file=new File(destination_file_name);
		FileOutputStream out=new FileOutputStream(file);
		int size_source=0;
		int ch=in.read();
		while(ch!=-1){
			size_source=size_source+1;
			out.write((char)ch);
			ch=in.read();
		}
		in.close();
		out.close();
		if(size_source==file.length()){
			System.out.println("FILE UPLOAD COMPLETED");
		}
		create_url(file);
	}

}
