package ua.lviv.lgs.service;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import ua.lviv.lgs.domain.PhotoFile;
import ua.lviv.lgs.domain.Student;
import ua.lviv.lgs.repository.PhotoFileRepository;

@Service
public class PhotoFileService {
	
	@Autowired
	private PhotoFileRepository photoFileRepository;

	public PhotoFile storeFile(Student student, MultipartFile file) throws IOException {

		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
		PhotoFile photoFile = null;
		if (!fileName.contains("..") && student != null) {
			photoFile = new PhotoFile(fileName, file.getContentType(), file.getBytes(), student);
		}
		return photoFileRepository.save(photoFile);
	}
	
	public PhotoFile getFile(String fileId) throws FileNotFoundException {
		return photoFileRepository.findById(fileId).orElseThrow(() -> new FileNotFoundException("File not found with Id = " + fileId)) ;
		
	}
}
