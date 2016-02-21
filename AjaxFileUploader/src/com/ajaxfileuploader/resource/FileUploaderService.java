package com.ajaxfileuploader.resource;

import com.sun.jersey.multipart.FormDataParam;
import java.io.*;
import javax.ws.rs.*;

@Path("/webservice")
public class FileUploaderService {
	

	@POST
	@Path("upload")
	@Consumes({ "application/x-www-form-urlencoded", "multipart/form-data" })

	public void uploadFileWithDetails(@FormDataParam("file") InputStream fileStream,
			@FormDataParam("fileName") String fileName) throws IOException {
		String basePath = "D:\\images";
		try {

			OutputStream out = new FileOutputStream(new File(basePath + "\\" + fileName));
			int read = 0;
			byte[] bytes = new byte[1024];
			while ((read = fileStream.read(bytes)) != -1) {
				out.write(bytes, 0, read);
			}
			out.flush();
			out.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
