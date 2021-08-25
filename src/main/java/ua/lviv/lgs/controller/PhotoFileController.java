package ua.lviv.lgs.controller;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.google.gson.Gson;

import ua.lviv.lgs.domain.PhotoFile;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.dto.PhotoUploadResponse;
import ua.lviv.lgs.service.PhotoFileService;

@RestController
public class PhotoFileController {
	
	@Autowired
	PhotoFileService photoFileService;
	
	PhotoUploadResponse photoUploadResponse;

	@PostMapping("/uploadFile")
	public PhotoUploadResponse uploadFile( @RequestParam("student") String stringStudent, @RequestParam("file") MultipartFile file) throws IOException {
		Gson gson = new Gson();
		Student student = gson.fromJson(stringStudent, Student.class);
		
		PhotoFile photoFile = photoFileService.storeFile(student, file);
		String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath().path("/downloadFile/")
				.path(photoFile.getId()).toUriString();

		photoUploadResponse = new PhotoUploadResponse(student.getFirstName(), student.getLastName(), student.getAge(), photoFile.getFileName(), fileDownloadUri, file.getContentType(),
				file.getSize());
		return photoUploadResponse;
	}

	@GetMapping("/downloadFile/{fileId}")
	public ResponseEntity<Resource> downloadFile(@PathVariable String fileId) throws FileNotFoundException {
		PhotoFile photoFile = photoFileService.getFile(fileId);

		return ResponseEntity.ok().contentType(MediaType.parseMediaType(photoFile.getFileType()))
				.header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + photoFile.getFileName() + "\"")
				.body(new ByteArrayResource(photoFile.getData()));
	}
	
	@GetMapping("/getStudentPage")
	public PhotoUploadResponse getStudentPage() {
		return photoUploadResponse;
	}
}
