package org.zerock.controller;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;

import javax.imageio.ImageIO;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//직접 이미지를 보낸다. 바이트의 배열로
@Controller
public class TempController {
	
	
	@RequestMapping(value = "/display")
	public @ResponseBody ResponseEntity<byte[]> display(String  file)  throws Exception{
		
	
		System.out.println("file" +file); //파일의 이름에 확장자가 붙어있음.
		
		HttpHeaders headers = new HttpHeaders();
		
		headers.add("Content-Type", "image/jpg");
		
		String filePath = "C:\\zzz\\upload\\" + file;
		ByteArrayOutputStream baos = 
				new ByteArrayOutputStream();
		
		File target = new File(filePath);
		
		FileCopyUtils.copy(new FileInputStream(target), baos);
		
		ResponseEntity<byte[]> result = 
				new ResponseEntity<>(baos.toByteArray(), headers,
						HttpStatus.OK);
		
		return result;
	}
	

	@RequestMapping(value ="/temp1", produces="image/gif")
	public @ResponseBody byte[] displayTemp() throws Exception {
	
		int value = (int)(Math.random() * 10000);
		
		String str = "T" + value;
		
		//가짜 이미지
		BufferedImage img =
				new BufferedImage(300, 300, 
						BufferedImage.TYPE_INT_RGB);
		
		//붓
		Graphics g= img.getGraphics();
		
		g.setColor(Color.pink);
		g.fillRect(0, 0, 300, 300); //채워져있는 사각형
		
		//글씨,임시 패스워드를 만드는 방법
		int style = Font.BOLD | Font.ITALIC;
		Font font = new Font ("Garamond", style , 35);
		g.setFont(font);
		g.setColor(Color.BLACK);
		g.drawString(str, 50, 150);
		
		
		
		ByteArrayOutputStream baos = 
				new ByteArrayOutputStream();
		
		
		ImageIO.write(img, "gif", baos);
		
		return baos.toByteArray();
		
		
	}
	
}
